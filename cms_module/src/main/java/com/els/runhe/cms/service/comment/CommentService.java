package com.els.runhe.cms.service.comment;

import java.util.List;

import com.els.base.core.service.BaseService;
import com.els.runhe.cms.entity.comment.Comment;
import com.els.runhe.cms.entity.comment.CommentData;
import com.els.runhe.cms.entity.comment.CommentExample;

/**
 * CommentService
 * 
 * @author acer
 * 
 */
public interface CommentService extends BaseService<Comment, CommentExample, Integer> {

	List<CommentData> getCommentsByArticleId(Integer articleId,
			Integer storeId, String memberId);
}
