package com.els.runhe.cms.service.collect.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.els.base.core.entity.PageView;
import com.els.base.core.entity.ResponseResult;
import com.els.runhe.cms.dao.collect.CollectMapper;
import com.els.runhe.cms.entity.collect.Collect;
import com.els.runhe.cms.entity.collect.CollectExample;
import com.els.runhe.cms.service.collect.CollectService;

/**
 * CollectServiceImpl
 * 
 * @author acer
 * 
 */
@Service
public class CollectServiceImpl implements CollectService {

	@Autowired
	protected CollectMapper collectMapper;

	@Override
	public void addObj(Collect collect) {
		collectMapper.insertSelective(collect);
	}

	@Override
	public void deleteObjById(Integer collectId) {
		collectMapper.deleteByPrimaryKey(collectId);
	}

	@Override
	public void modifyObj(Collect collect) {
		collectMapper.updateByPrimaryKeySelective(collect);
	}

	@Override
	public List<Collect> queryAllObjByExample(CollectExample collectExample) {
		return collectMapper.selectByExample(collectExample);
	}

	@Override
	public Collect queryObjById(Integer collectId) {
		return collectMapper.selectByPrimaryKey(collectId);
	}

	@Override
	public PageView<Collect> queryObjByPage(CollectExample example) {
		PageView<Collect> pageView = example.getPageView();
		if (pageView == null) {
			pageView = new PageView<Collect>();
			pageView.setPageNo(1);
			pageView.setPageSize(10);
			example.setPageView(pageView);
		}
		List<Collect> list = collectMapper.selectByExampleByPage(example);
		pageView.setQueryResult(list);
		return pageView;
	}

	@Override
	public ResponseResult<String> collectOrUncollect(String memberId,
			Integer articleId, Integer status, Integer storeId) {
		String code = "00";
		String msg = "ok";

		CollectExample example = new CollectExample();
		example.createCriteria().andArticleIdEqualTo(articleId)
				.andMemberIdEqualTo(memberId);
//		example.createCriteria().andArticleIdEqualTo(articleId)
//		.andMemberIdEqualTo(memberId).andStoreIdEqualTo(storeId);
		List<Collect> list = collectMapper.selectByExample(example);

		Collect collect = new Collect();
		collect.setArticleId(articleId);
		collect.setMemberId(memberId);
		collect.setStoreId(storeId);

		if (CollectionUtils.isNotEmpty(list)) {
			if (list.get(0).getStatus().equals(status)) {
				code = "-1";
				msg = "不能重复操作。";
			} else {
				collect.setId(list.get(0).getId());
				collectMapper.updateByPrimaryKeySelective(collect);
			}
		} else {
			collectMapper.insertSelective(collect);
		}
		return ResponseResult.success();
	}
}
