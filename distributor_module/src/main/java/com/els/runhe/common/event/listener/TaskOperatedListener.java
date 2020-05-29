package com.els.runhe.common.event.listener;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.els.base.auth.entity.Role;
import com.els.base.auth.entity.RoleExample;
import com.els.base.auth.entity.UserRole;
import com.els.base.auth.entity.UserRoleExample;
import com.els.base.auth.service.RoleService;
import com.els.base.auth.service.UserRoleService;
import com.els.base.workflow.common.event.TaskOperateEvent;
import com.els.base.workflow.common.event.TaskStartedEvent;
import com.els.runhe.order.utils.OrderSendWxMsgUtils;

@Component
public class TaskOperatedListener implements ApplicationListener<TaskOperateEvent>{
	
	private static Logger logger = LoggerFactory.getLogger(TaskOperatedListener.class);
	
	@Resource
	private UserRoleService userRoleService;

	@Resource
	private RoleService roleService;
	
	@Resource
	private TaskService taskService;
	
	@Override
	public void onApplicationEvent(TaskOperateEvent event) {
		if (event.isFinished()) {
			logger.info("因为审批的任务已完成，不用发送消息");
			return;
		}
		
		List<Task> taskList = taskService.createTaskQuery()
				.processInstanceId(event.getCurrentProcess().getId())
				.includeTaskLocalVariables()
				.list();
		
		if (CollectionUtils.isEmpty(taskList)) {
			logger.warn("发送微信消息失败，因为审批的任务信息为空");
			return;
		}
		
		String roleCode = taskList.get(0).getAssignee();
		if (StringUtils.isBlank(roleCode)) {
			logger.warn("发送微信消息失败，因为审批的任务指派的角色为空");
			return;
		}
		
		RoleExample roleExample = new RoleExample();
		roleExample.createCriteria().andRoleCodeEqualTo(roleCode);
		
		List<Role> roleList = this.roleService.queryAllObjByExample(roleExample);
		if (CollectionUtils.isEmpty(roleList)) {
			logger.warn("发送微信消息失败，因为审批的任务指派的角色为空");
			return;
		}
		
		UserRoleExample userRoleExample = new UserRoleExample();
		userRoleExample.createCriteria().andRoleIdEqualTo(roleList.get(0).getId());
		List<UserRole> userRoles = this.userRoleService.queryAllObjByExample(userRoleExample);
		if (CollectionUtils.isEmpty(userRoles)) {
			logger.warn("发送微信消息失败，因为审批的任务指派的角色的用户为空");
			return;
		}
		
		Set<String> userIds = new HashSet<>();
		for(UserRole userRole : userRoles){
			userIds.add(userRole.getUserId());
		}
		
		Map<String, Object> processMap = event.getCurrentProcess().getProcessVariables();
		processMap.put("businessKey", event.getCurrentProcess().getBusinessKey());
		
		Task task = taskList.get(0);
		Map<String, Object> taskMap = task.getTaskLocalVariables();
		taskMap.put("taskName", task.getName());
		
		Map<String, Object> data= new HashMap<>();
		data.put("task", taskMap);
		data.put("process", processMap);
		
		OrderSendWxMsgUtils.sendMsg(userIds, "TASK_STATUS_OPERATE", data);
	}

}
