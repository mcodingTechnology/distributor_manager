package com.els.runhe.cms.service.label;

import java.util.List;

import com.els.base.core.service.BaseService;
import com.els.runhe.cms.entity.label.ArticleLabelRef;
import com.els.runhe.cms.entity.label.Label;
import com.els.runhe.cms.entity.label.LabelExample;

/**
 * LabelService
 * 
 * @author acer
 * 
 */
public interface LabelService extends BaseService<Label, LabelExample, Integer> {

	/**
	 * 根据标签更新标签的热度
	 * 
	 * @param storeId
	 * @param label
	 */
	void addLabelHit(int storeId, String label);

	/**
	 * 如果标签不存在，就创建标签，如果存在就加标签的热度
	 * @param storeId
	 * @param labelList
	 */
	void addLabelOrModifyLabelHit(int articleId, int storeId, List<ArticleLabelRef> labelList);

}
