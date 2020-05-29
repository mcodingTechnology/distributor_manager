package com.els.runhe.common.event.listener;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
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
import com.els.base.workflow.common.event.TaskStartedEvent;
import com.els.runhe.order.utils.OrderSendWxMsgUtils;

@Component
public class TaskStartedListener implements ApplicationListener<TaskStartedEvent>{
	
	private static Logger logger = LoggerFactory.getLogger(TaskStartedListener.class);
	
	@Resource
	private UserRoleService userRoleService;

	@Resource
	private RoleService roleService;
	
	@Resource
	protected TaskService taskService;
	
	@Resource
	protected RuntimeService runtimeService;
	
	@Override
	public void onApplicationEvent(TaskStartedEvent event) {
		ProcessInstance processInstance = event.getCurrentProcess();
		if (processInstance == null || StringUtils.isBlank(processInstance.getId())) {
			logger.warn("发送微信消息失败，因为审批的流程信息为空");
			return;
			
		}
		
		if (MapUtils.isEmpty(processInstance.getProcessVariables())) {
			processInstance = this.runtimeService.createProcessInstanceQuery()
					.processInstanceId(processInstance.getId())
					.includeProcessVariables()
					.singleResult();
		}
		
		Task task = event.getCurrentTask();
		if (task == null || MapUtils.isEmpty(task.getTaskLocalVariables())) {
			
			List<Task> taskList = this.taskService.createTaskQuery()
					.processInstanceId(processInstance.getId())
					.includeTaskLocalVariables().list();
			
			if (CollectionUtils.isEmpty(taskList)) {
				logger.warn("发送微信消息失败，因为审批的任务信息为空");
				return;
			}
			
			task = taskList.get(0);
		}
		
		String roleCode = task.getAssignee();
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
		
		Map<String, Object> processMap = processInstance.getProcessVariables();
		processMap.put("businessKey", processInstance.getBusinessKey());
		
		Map<String, Object> taskMap = task.getTaskLocalVariables();
		taskMap.put("taskName", task.getName());
		
		Map<String, Object> data= new HashMap<>();
		data.put("task", taskMap);
		data.put("process", processMap);
		OrderSendWxMsgUtils.sendMsg(userIds, "TASK_STATUS_OPERATE", data);
	}

}
