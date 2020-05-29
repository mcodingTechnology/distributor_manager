package com.els.runhe.cms.service.collect;

import com.els.base.core.service.BaseService;
import com.els.runhe.cms.entity.collect.Collect;
import com.els.runhe.cms.entity.collect.CollectExample;
import com.els.base.core.entity.ResponseResult;

/**
 * CollectService
 * 
 * @author acer
 * 
 */
public interface CollectService extends BaseService<Collect, CollectExample, Integer> {

	/**
	 * 收藏取消收藏
	 * 
	 * @param memberId
	 * @param articleId
	 * @param status
	 * @param storeId
	 * @return
	 */
	ResponseResult<String> collectOrUncollect(String memberId, Integer articleId,
			Integer status, Integer storeId);
}
