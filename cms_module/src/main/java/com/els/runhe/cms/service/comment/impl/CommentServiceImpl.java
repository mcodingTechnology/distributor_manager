package com.els.runhe.cms.service.comment.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.els.base.core.entity.PageView;
import com.els.runhe.cms.dao.comment.CommentMapper;
import com.els.runhe.cms.entity.comment.Comment;
import com.els.runhe.cms.entity.comment.CommentData;
import com.els.runhe.cms.entity.comment.CommentExample;
import com.els.runhe.cms.service.comment.CommentService;

/**
 * CommentServiceImpl
 * 
 * @author acer
 * 
 */
@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	protected CommentMapper commentMapper;

	@Override
	public void addObj(Comment comment) {
		commentMapper.insertSelective(comment);
	}

	@Override
	public void deleteObjById(Integer commentId) {
		commentMapper.deleteByPrimaryKey(commentId);
	}

	@Override
	public void modifyObj(Comment comment) {
		commentMapper.updateByPrimaryKeySelective(comment);
	}

	@Override
	public List<Comment> queryAllObjByExample(CommentExample commentExample) {
		return commentMapper.selectByExample(commentExample);
	}

	@Override
	public Comment queryObjById(Integer commentId) {
		return commentMapper.selectByPrimaryKey(commentId);
	}

	@Override
	public PageView<Comment> queryObjByPage(CommentExample example) {
		PageView<Comment> pageView = example.getPageView();
		if (pageView == null) {
			pageView = new PageView<Comment>();
			pageView.setPageNo(1);
			pageView.setPageSize(10);
			example.setPageView(pageView);
		}
		List<Comment> list = commentMapper.selectByExampleByPage(example);
		pageView.setQueryResult(list);
		return pageView;
	}

	@Override
	public List<CommentData> getCommentsByArticleId(Integer articleId,
			Integer storeId, String memberId) {
		CommentExample commentExample = new CommentExample();
		commentExample.createCriteria().andArticleIdEqualTo(articleId);
		commentExample.setOrderByClause(" create_time ASC");
		List<Comment> commentList = commentMapper
				.selectByExample(commentExample);
		return buildData(commentList, 0);
	}

	/**
	 * 递归遍历
	 * 
	 * @param list
	 * @param commentId
	 * @return
	 */
	public static List<CommentData> buildData(List<Comment> list,
			Integer commentId) {
		List<CommentData> listData = new ArrayList<CommentData>();
		for (Comment comment : list) {
			if (commentId == comment.getCommentId()) {
				CommentData data = new CommentData();
				data.setComment(comment);
				data.setCommentList(buildData(list, comment.getId()));
				listData.add(data);
			}
		}
		return listData;
	}
}
