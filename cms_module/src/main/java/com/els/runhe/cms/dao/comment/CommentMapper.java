package com.els.runhe.cms.dao.comment;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.els.runhe.cms.entity.comment.Comment;
import com.els.runhe.cms.entity.comment.CommentExample;

/**
 * CommentMapper
 * 
 * @author acer
 * 
 */
public interface CommentMapper {

	int countByExample(CommentExample example);

	int deleteByExample(CommentExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(Comment record);

	int insertSelective(Comment record);

	List<Comment> selectByExample(CommentExample example);

	Comment selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") Comment record,
			@Param("example") CommentExample example);

	int updateByExample(@Param("record") Comment record,
			@Param("example") CommentExample example);

	int updateByPrimaryKeySelective(Comment record);

	int updateByPrimaryKey(Comment record);

	List<Comment> selectByExampleByPage(CommentExample example);
}