package com.els.runhe.cms.service.favorite;

import com.els.base.core.service.BaseService;
import com.els.runhe.cms.entity.favorite.Favorite;
import com.els.runhe.cms.entity.favorite.FavoriteExample;
import com.els.base.core.entity.ResponseResult;

/**
 * FavoriteService
 * 
 * @author acer
 * 
 */
public interface FavoriteService extends BaseService<Favorite, FavoriteExample, Integer> {
	/**
	 * 点赞、取消赞、点衰、取消衰
	 * 
	 * @param map
	 */
	public ResponseResult<String> likeOrDislike(Integer type, Integer status,
			String memberId, Integer articleId, Integer storeId);
}
