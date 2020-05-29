package com.els.runhe.market.entity.train;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.els.base.core.entity.AbstractExample;
import com.els.base.core.entity.PageView;
import com.els.runhe.market.entity.design.MarketDesignApplyExample.Criteria;

public class MarketTrainApplyExample extends AbstractExample<MarketTrainApply> implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected PageView<MarketTrainApply> pageView = new PageView<MarketTrainApply>(1, 10);

    private static final long serialVersionUID = 1L;

    public MarketTrainApplyExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    @Override
    public PageView<MarketTrainApply> getPageView() {
        return pageView;
    }

    @Override
    public void setPageView(PageView<MarketTrainApply> pageView) {
        this.pageView = pageView;
    }

    protected abstract static class GeneratedCriteria implements Serializable {
        protected List<Criterion> criteria;

        private static final long serialVersionUID = 1L;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }
        
        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("user_id like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("user_id not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNull() {
            addCriterion("user_name is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("user_name is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("user_name =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("user_name <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("user_name >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("user_name >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("user_name <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("user_name <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("user_name like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("user_name not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("user_name in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("user_name not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("user_name between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("user_name not between", value1, value2, "userName");
            return (Criteria) this;
        }
        
        public Criteria andTrainApplyIdIsNull() {
            addCriterion("train_apply_id is null");
            return (Criteria) this;
        }

        public Criteria andTrainApplyIdIsNotNull() {
            addCriterion("train_apply_id is not null");
            return (Criteria) this;
        }

        public Criteria andTrainApplyIdEqualTo(String value) {
            addCriterion("train_apply_id =", value, "trainApplyId");
            return (Criteria) this;
        }

        public Criteria andTrainApplyIdNotEqualTo(String value) {
            addCriterion("train_apply_id <>", value, "trainApplyId");
            return (Criteria) this;
        }

        public Criteria andTrainApplyIdGreaterThan(String value) {
            addCriterion("train_apply_id >", value, "trainApplyId");
            return (Criteria) this;
        }

        public Criteria andTrainApplyIdGreaterThanOrEqualTo(String value) {
            addCriterion("train_apply_id >=", value, "trainApplyId");
            return (Criteria) this;
        }

        public Criteria andTrainApplyIdLessThan(String value) {
            addCriterion("train_apply_id <", value, "trainApplyId");
            return (Criteria) this;
        }

        public Criteria andTrainApplyIdLessThanOrEqualTo(String value) {
            addCriterion("train_apply_id <=", value, "trainApplyId");
            return (Criteria) this;
        }

        public Criteria andTrainApplyIdLike(String value) {
            addCriterion("train_apply_id like", value, "trainApplyId");
            return (Criteria) this;
        }

        public Criteria andTrainApplyIdNotLike(String value) {
            addCriterion("train_apply_id not like", value, "trainApplyId");
            return (Criteria) this;
        }

        public Criteria andTrainApplyIdIn(List<String> values) {
            addCriterion("train_apply_id in", values, "trainApplyId");
            return (Criteria) this;
        }

        public Criteria andTrainApplyIdNotIn(List<String> values) {
            addCriterion("train_apply_id not in", values, "trainApplyId");
            return (Criteria) this;
        }

        public Criteria andTrainApplyIdBetween(String value1, String value2) {
            addCriterion("train_apply_id between", value1, value2, "trainApplyId");
            return (Criteria) this;
        }

        public Criteria andTrainApplyIdNotBetween(String value1, String value2) {
            addCriterion("train_apply_id not between", value1, value2, "trainApplyId");
            return (Criteria) this;
        }
        
        public Criteria andThemeIdIsNull() {
            addCriterion("theme_id is null");
            return (Criteria) this;
        }

        public Criteria andThemeIdIsNotNull() {
            addCriterion("theme_id is not null");
            return (Criteria) this;
        }

        public Criteria andThemeIdEqualTo(String value) {
            addCriterion("theme_id =", value, "themeId");
            return (Criteria) this;
        }

        public Criteria andThemeIdNotEqualTo(String value) {
            addCriterion("theme_id <>", value, "themeId");
            return (Criteria) this;
        }

        public Criteria andThemeIdGreaterThan(String value) {
            addCriterion("theme_id >", value, "themeId");
            return (Criteria) this;
        }

        public Criteria andThemeIdGreaterThanOrEqualTo(String value) {
            addCriterion("theme_id >=", value, "themeId");
            return (Criteria) this;
        }

        public Criteria andThemeIdLessThan(String value) {
            addCriterion("theme_id <", value, "themeId");
            return (Criteria) this;
        }

        public Criteria andThemeIdLessThanOrEqualTo(String value) {
            addCriterion("theme_id <=", value, "themeId");
            return (Criteria) this;
        }

        public Criteria andThemeIdLike(String value) {
            addCriterion("theme_id like", value, "themeId");
            return (Criteria) this;
        }

        public Criteria andThemeIdNotLike(String value) {
            addCriterion("theme_id not like", value, "themeId");
            return (Criteria) this;
        }

        public Criteria andThemeIdIn(List<String> values) {
            addCriterion("theme_id in", values, "themeId");
            return (Criteria) this;
        }

        public Criteria andThemeIdNotIn(List<String> values) {
            addCriterion("theme_id not in", values, "themeId");
            return (Criteria) this;
        }

        public Criteria andThemeIdBetween(String value1, String value2) {
            addCriterion("theme_id between", value1, value2, "themeId");
            return (Criteria) this;
        }

        public Criteria andThemeIdNotBetween(String value1, String value2) {
            addCriterion("theme_id not between", value1, value2, "themeId");
            return (Criteria) this;
        }

        public Criteria andThemeIsNull() {
            addCriterion("theme is null");
            return (Criteria) this;
        }

        public Criteria andThemeIsNotNull() {
            addCriterion("theme is not null");
            return (Criteria) this;
        }

        public Criteria andThemeEqualTo(String value) {
            addCriterion("theme =", value, "theme");
            return (Criteria) this;
        }

        public Criteria andThemeNotEqualTo(String value) {
            addCriterion("theme <>", value, "theme");
            return (Criteria) this;
        }

        public Criteria andThemeGreaterThan(String value) {
            addCriterion("theme >", value, "theme");
            return (Criteria) this;
        }

        public Criteria andThemeGreaterThanOrEqualTo(String value) {
            addCriterion("theme >=", value, "theme");
            return (Criteria) this;
        }

        public Criteria andThemeLessThan(String value) {
            addCriterion("theme <", value, "theme");
            return (Criteria) this;
        }

        public Criteria andThemeLessThanOrEqualTo(String value) {
            addCriterion("theme <=", value, "theme");
            return (Criteria) this;
        }

        public Criteria andThemeLike(String value) {
            addCriterion("theme like", value, "theme");
            return (Criteria) this;
        }

        public Criteria andThemeNotLike(String value) {
            addCriterion("theme not like", value, "theme");
            return (Criteria) this;
        }

        public Criteria andThemeIn(List<String> values) {
            addCriterion("theme in", values, "theme");
            return (Criteria) this;
        }

        public Criteria andThemeNotIn(List<String> values) {
            addCriterion("theme not in", values, "theme");
            return (Criteria) this;
        }

        public Criteria andThemeBetween(String value1, String value2) {
            addCriterion("theme between", value1, value2, "theme");
            return (Criteria) this;
        }

        public Criteria andThemeNotBetween(String value1, String value2) {
            addCriterion("theme not between", value1, value2, "theme");
            return (Criteria) this;
        }

        public Criteria andApplicantIdIsNull() {
            addCriterion("applicant_id is null");
            return (Criteria) this;
        }

        public Criteria andApplicantIdIsNotNull() {
            addCriterion("applicant_id is not null");
            return (Criteria) this;
        }

        public Criteria andApplicantIdEqualTo(String value) {
            addCriterion("applicant_id =", value, "applicantId");
            return (Criteria) this;
        }

        public Criteria andApplicantIdNotEqualTo(String value) {
            addCriterion("applicant_id <>", value, "applicantId");
            return (Criteria) this;
        }

        public Criteria andApplicantIdGreaterThan(String value) {
            addCriterion("applicant_id >", value, "applicantId");
            return (Criteria) this;
        }

        public Criteria andApplicantIdGreaterThanOrEqualTo(String value) {
            addCriterion("applicant_id >=", value, "applicantId");
            return (Criteria) this;
        }

        public Criteria andApplicantIdLessThan(String value) {
            addCriterion("applicant_id <", value, "applicantId");
            return (Criteria) this;
        }

        public Criteria andApplicantIdLessThanOrEqualTo(String value) {
            addCriterion("applicant_id <=", value, "applicantId");
            return (Criteria) this;
        }

        public Criteria andApplicantIdLike(String value) {
            addCriterion("applicant_id like", value, "applicantId");
            return (Criteria) this;
        }

        public Criteria andApplicantIdNotLike(String value) {
            addCriterion("applicant_id not like", value, "applicantId");
            return (Criteria) this;
        }

        public Criteria andApplicantIdIn(List<String> values) {
            addCriterion("applicant_id in", values, "applicantId");
            return (Criteria) this;
        }

        public Criteria andApplicantIdNotIn(List<String> values) {
            addCriterion("applicant_id not in", values, "applicantId");
            return (Criteria) this;
        }

        public Criteria andApplicantIdBetween(String value1, String value2) {
            addCriterion("applicant_id between", value1, value2, "applicantId");
            return (Criteria) this;
        }

        public Criteria andApplicantIdNotBetween(String value1, String value2) {
            addCriterion("applicant_id not between", value1, value2, "applicantId");
            return (Criteria) this;
        }

        public Criteria andApplicantIsNull() {
            addCriterion("applicant is null");
            return (Criteria) this;
        }

        public Criteria andApplicantIsNotNull() {
            addCriterion("applicant is not null");
            return (Criteria) this;
        }

        public Criteria andApplicantEqualTo(String value) {
            addCriterion("applicant =", value, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantNotEqualTo(String value) {
            addCriterion("applicant <>", value, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantGreaterThan(String value) {
            addCriterion("applicant >", value, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantGreaterThanOrEqualTo(String value) {
            addCriterion("applicant >=", value, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantLessThan(String value) {
            addCriterion("applicant <", value, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantLessThanOrEqualTo(String value) {
            addCriterion("applicant <=", value, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantLike(String value) {
            addCriterion("applicant like", value, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantNotLike(String value) {
            addCriterion("applicant not like", value, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantIn(List<String> values) {
            addCriterion("applicant in", values, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantNotIn(List<String> values) {
            addCriterion("applicant not in", values, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantBetween(String value1, String value2) {
            addCriterion("applicant between", value1, value2, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantNotBetween(String value1, String value2) {
            addCriterion("applicant not between", value1, value2, "applicant");
            return (Criteria) this;
        }
        
        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }
        
        public Criteria andApprovalStatusIsNull() {
            addCriterion("approval_status is null");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusIsNotNull() {
            addCriterion("approval_status is not null");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusEqualTo(Integer value) {
            addCriterion("approval_status =", value, "approvalStatus");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusNotEqualTo(Integer value) {
            addCriterion("approval_status <>", value, "approvalStatus");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusGreaterThan(Integer value) {
            addCriterion("approval_status >", value, "approvalStatus");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("approval_status >=", value, "approvalStatus");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusLessThan(Integer value) {
            addCriterion("approval_status <", value, "approvalStatus");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusLessThanOrEqualTo(Integer value) {
            addCriterion("approval_status <=", value, "approvalStatus");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusIn(List<Integer> values) {
            addCriterion("approval_status in", values, "approvalStatus");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusNotIn(List<Integer> values) {
            addCriterion("approval_status not in", values, "approvalStatus");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusBetween(Integer value1, Integer value2) {
            addCriterion("approval_status between", value1, value2, "approvalStatus");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("approval_status not between", value1, value2, "approvalStatus");
            return (Criteria) this;
        }

        public Criteria andCategoryIdIsNull() {
            addCriterion("category_id is null");
            return (Criteria) this;
        }

        public Criteria andCategoryIdIsNotNull() {
            addCriterion("category_id is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryIdEqualTo(String value) {
            addCriterion("category_id =", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotEqualTo(String value) {
            addCriterion("category_id <>", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdGreaterThan(String value) {
            addCriterion("category_id >", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdGreaterThanOrEqualTo(String value) {
            addCriterion("category_id >=", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdLessThan(String value) {
            addCriterion("category_id <", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdLessThanOrEqualTo(String value) {
            addCriterion("category_id <=", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdLike(String value) {
            addCriterion("category_id like", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotLike(String value) {
            addCriterion("category_id not like", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdIn(List<String> values) {
            addCriterion("category_id in", values, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotIn(List<String> values) {
            addCriterion("category_id not in", values, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdBetween(String value1, String value2) {
            addCriterion("category_id between", value1, value2, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotBetween(String value1, String value2) {
            addCriterion("category_id not between", value1, value2, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIsNull() {
            addCriterion("category is null");
            return (Criteria) this;
        }

        public Criteria andCategoryIsNotNull() {
            addCriterion("category is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryEqualTo(String value) {
            addCriterion("category =", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotEqualTo(String value) {
            addCriterion("category <>", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryGreaterThan(String value) {
            addCriterion("category >", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryGreaterThanOrEqualTo(String value) {
            addCriterion("category >=", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryLessThan(String value) {
            addCriterion("category <", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryLessThanOrEqualTo(String value) {
            addCriterion("category <=", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryLike(String value) {
            addCriterion("category like", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotLike(String value) {
            addCriterion("category not like", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryIn(List<String> values) {
            addCriterion("category in", values, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotIn(List<String> values) {
            addCriterion("category not in", values, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryBetween(String value1, String value2) {
            addCriterion("category between", value1, value2, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotBetween(String value1, String value2) {
            addCriterion("category not between", value1, value2, "category");
            return (Criteria) this;
        }

        public Criteria andCityIsNull() {
            addCriterion("city is null");
            return (Criteria) this;
        }

        public Criteria andCityIsNotNull() {
            addCriterion("city is not null");
            return (Criteria) this;
        }

        public Criteria andCityEqualTo(String value) {
            addCriterion("city =", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotEqualTo(String value) {
            addCriterion("city <>", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThan(String value) {
            addCriterion("city >", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThanOrEqualTo(String value) {
            addCriterion("city >=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThan(String value) {
            addCriterion("city <", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThanOrEqualTo(String value) {
            addCriterion("city <=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLike(String value) {
            addCriterion("city like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotLike(String value) {
            addCriterion("city not like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityIn(List<String> values) {
            addCriterion("city in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotIn(List<String> values) {
            addCriterion("city not in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityBetween(String value1, String value2) {
            addCriterion("city between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotBetween(String value1, String value2) {
            addCriterion("city not between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andTrainingNumberIsNull() {
            addCriterion("training_number is null");
            return (Criteria) this;
        }

        public Criteria andTrainingNumberIsNotNull() {
            addCriterion("training_number is not null");
            return (Criteria) this;
        }

        public Criteria andTrainingNumberEqualTo(Integer value) {
            addCriterion("training_number =", value, "trainingNumber");
            return (Criteria) this;
        }

        public Criteria andTrainingNumberNotEqualTo(Integer value) {
            addCriterion("training_number <>", value, "trainingNumber");
            return (Criteria) this;
        }

        public Criteria andTrainingNumberGreaterThan(Integer value) {
            addCriterion("training_number >", value, "trainingNumber");
            return (Criteria) this;
        }

        public Criteria andTrainingNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("training_number >=", value, "trainingNumber");
            return (Criteria) this;
        }

        public Criteria andTrainingNumberLessThan(Integer value) {
            addCriterion("training_number <", value, "trainingNumber");
            return (Criteria) this;
        }

        public Criteria andTrainingNumberLessThanOrEqualTo(Integer value) {
            addCriterion("training_number <=", value, "trainingNumber");
            return (Criteria) this;
        }

        public Criteria andTrainingNumberIn(List<Integer> values) {
            addCriterion("training_number in", values, "trainingNumber");
            return (Criteria) this;
        }

        public Criteria andTrainingNumberNotIn(List<Integer> values) {
            addCriterion("training_number not in", values, "trainingNumber");
            return (Criteria) this;
        }

        public Criteria andTrainingNumberBetween(Integer value1, Integer value2) {
            addCriterion("training_number between", value1, value2, "trainingNumber");
            return (Criteria) this;
        }

        public Criteria andTrainingNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("training_number not between", value1, value2, "trainingNumber");
            return (Criteria) this;
        }

        public Criteria andChainNameIsNull() {
            addCriterion("chain_name is null");
            return (Criteria) this;
        }

        public Criteria andChainNameIsNotNull() {
            addCriterion("chain_name is not null");
            return (Criteria) this;
        }

        public Criteria andChainNameEqualTo(String value) {
            addCriterion("chain_name =", value, "chainName");
            return (Criteria) this;
        }

        public Criteria andChainNameNotEqualTo(String value) {
            addCriterion("chain_name <>", value, "chainName");
            return (Criteria) this;
        }

        public Criteria andChainNameGreaterThan(String value) {
            addCriterion("chain_name >", value, "chainName");
            return (Criteria) this;
        }

        public Criteria andChainNameGreaterThanOrEqualTo(String value) {
            addCriterion("chain_name >=", value, "chainName");
            return (Criteria) this;
        }

        public Criteria andChainNameLessThan(String value) {
            addCriterion("chain_name <", value, "chainName");
            return (Criteria) this;
        }

        public Criteria andChainNameLessThanOrEqualTo(String value) {
            addCriterion("chain_name <=", value, "chainName");
            return (Criteria) this;
        }

        public Criteria andChainNameLike(String value) {
            addCriterion("chain_name like", value, "chainName");
            return (Criteria) this;
        }

        public Criteria andChainNameNotLike(String value) {
            addCriterion("chain_name not like", value, "chainName");
            return (Criteria) this;
        }

        public Criteria andChainNameIn(List<String> values) {
            addCriterion("chain_name in", values, "chainName");
            return (Criteria) this;
        }

        public Criteria andChainNameNotIn(List<String> values) {
            addCriterion("chain_name not in", values, "chainName");
            return (Criteria) this;
        }

        public Criteria andChainNameBetween(String value1, String value2) {
            addCriterion("chain_name between", value1, value2, "chainName");
            return (Criteria) this;
        }

        public Criteria andChainNameNotBetween(String value1, String value2) {
            addCriterion("chain_name not between", value1, value2, "chainName");
            return (Criteria) this;
        }

        public Criteria andAgentChannelsIsNull() {
            addCriterion("agent_channels is null");
            return (Criteria) this;
        }

        public Criteria andAgentChannelsIsNotNull() {
            addCriterion("agent_channels is not null");
            return (Criteria) this;
        }

        public Criteria andAgentChannelsEqualTo(String value) {
            addCriterion("agent_channels =", value, "agentChannels");
            return (Criteria) this;
        }

        public Criteria andAgentChannelsNotEqualTo(String value) {
            addCriterion("agent_channels <>", value, "agentChannels");
            return (Criteria) this;
        }

        public Criteria andAgentChannelsGreaterThan(String value) {
            addCriterion("agent_channels >", value, "agentChannels");
            return (Criteria) this;
        }

        public Criteria andAgentChannelsGreaterThanOrEqualTo(String value) {
            addCriterion("agent_channels >=", value, "agentChannels");
            return (Criteria) this;
        }

        public Criteria andAgentChannelsLessThan(String value) {
            addCriterion("agent_channels <", value, "agentChannels");
            return (Criteria) this;
        }

        public Criteria andAgentChannelsLessThanOrEqualTo(String value) {
            addCriterion("agent_channels <=", value, "agentChannels");
            return (Criteria) this;
        }

        public Criteria andAgentChannelsLike(String value) {
            addCriterion("agent_channels like", value, "agentChannels");
            return (Criteria) this;
        }

        public Criteria andAgentChannelsNotLike(String value) {
            addCriterion("agent_channels not like", value, "agentChannels");
            return (Criteria) this;
        }

        public Criteria andAgentChannelsIn(List<String> values) {
            addCriterion("agent_channels in", values, "agentChannels");
            return (Criteria) this;
        }

        public Criteria andAgentChannelsNotIn(List<String> values) {
            addCriterion("agent_channels not in", values, "agentChannels");
            return (Criteria) this;
        }

        public Criteria andAgentChannelsBetween(String value1, String value2) {
            addCriterion("agent_channels between", value1, value2, "agentChannels");
            return (Criteria) this;
        }

        public Criteria andAgentChannelsNotBetween(String value1, String value2) {
            addCriterion("agent_channels not between", value1, value2, "agentChannels");
            return (Criteria) this;
        }

        public Criteria andAgentIdIsNull() {
            addCriterion("agent_id is null");
            return (Criteria) this;
        }

        public Criteria andAgentIdIsNotNull() {
            addCriterion("agent_id is not null");
            return (Criteria) this;
        }

        public Criteria andAgentIdEqualTo(String value) {
            addCriterion("agent_id =", value, "agentId");
            return (Criteria) this;
        }

        public Criteria andAgentIdNotEqualTo(String value) {
            addCriterion("agent_id <>", value, "agentId");
            return (Criteria) this;
        }

        public Criteria andAgentIdGreaterThan(String value) {
            addCriterion("agent_id >", value, "agentId");
            return (Criteria) this;
        }

        public Criteria andAgentIdGreaterThanOrEqualTo(String value) {
            addCriterion("agent_id >=", value, "agentId");
            return (Criteria) this;
        }

        public Criteria andAgentIdLessThan(String value) {
            addCriterion("agent_id <", value, "agentId");
            return (Criteria) this;
        }

        public Criteria andAgentIdLessThanOrEqualTo(String value) {
            addCriterion("agent_id <=", value, "agentId");
            return (Criteria) this;
        }

        public Criteria andAgentIdLike(String value) {
            addCriterion("agent_id like", value, "agentId");
            return (Criteria) this;
        }

        public Criteria andAgentIdNotLike(String value) {
            addCriterion("agent_id not like", value, "agentId");
            return (Criteria) this;
        }

        public Criteria andAgentIdIn(List<String> values) {
            addCriterion("agent_id in", values, "agentId");
            return (Criteria) this;
        }

        public Criteria andAgentIdNotIn(List<String> values) {
            addCriterion("agent_id not in", values, "agentId");
            return (Criteria) this;
        }

        public Criteria andAgentIdBetween(String value1, String value2) {
            addCriterion("agent_id between", value1, value2, "agentId");
            return (Criteria) this;
        }

        public Criteria andAgentIdNotBetween(String value1, String value2) {
            addCriterion("agent_id not between", value1, value2, "agentId");
            return (Criteria) this;
        }

        public Criteria andAgentsIsNull() {
            addCriterion("agents is null");
            return (Criteria) this;
        }

        public Criteria andAgentsIsNotNull() {
            addCriterion("agents is not null");
            return (Criteria) this;
        }

        public Criteria andAgentsEqualTo(String value) {
            addCriterion("agents =", value, "agents");
            return (Criteria) this;
        }

        public Criteria andAgentsNotEqualTo(String value) {
            addCriterion("agents <>", value, "agents");
            return (Criteria) this;
        }

        public Criteria andAgentsGreaterThan(String value) {
            addCriterion("agents >", value, "agents");
            return (Criteria) this;
        }

        public Criteria andAgentsGreaterThanOrEqualTo(String value) {
            addCriterion("agents >=", value, "agents");
            return (Criteria) this;
        }

        public Criteria andAgentsLessThan(String value) {
            addCriterion("agents <", value, "agents");
            return (Criteria) this;
        }

        public Criteria andAgentsLessThanOrEqualTo(String value) {
            addCriterion("agents <=", value, "agents");
            return (Criteria) this;
        }

        public Criteria andAgentsLike(String value) {
            addCriterion("agents like", value, "agents");
            return (Criteria) this;
        }

        public Criteria andAgentsNotLike(String value) {
            addCriterion("agents not like", value, "agents");
            return (Criteria) this;
        }

        public Criteria andAgentsIn(List<String> values) {
            addCriterion("agents in", values, "agents");
            return (Criteria) this;
        }

        public Criteria andAgentsNotIn(List<String> values) {
            addCriterion("agents not in", values, "agents");
            return (Criteria) this;
        }

        public Criteria andAgentsBetween(String value1, String value2) {
            addCriterion("agents between", value1, value2, "agents");
            return (Criteria) this;
        }

        public Criteria andAgentsNotBetween(String value1, String value2) {
            addCriterion("agents not between", value1, value2, "agents");
            return (Criteria) this;
        }

        public Criteria andTrainContactNameIsNull() {
            addCriterion("train_contact_name is null");
            return (Criteria) this;
        }

        public Criteria andTrainContactNameIsNotNull() {
            addCriterion("train_contact_name is not null");
            return (Criteria) this;
        }

        public Criteria andTrainContactNameEqualTo(String value) {
            addCriterion("train_contact_name =", value, "trainContactName");
            return (Criteria) this;
        }

        public Criteria andTrainContactNameNotEqualTo(String value) {
            addCriterion("train_contact_name <>", value, "trainContactName");
            return (Criteria) this;
        }

        public Criteria andTrainContactNameGreaterThan(String value) {
            addCriterion("train_contact_name >", value, "trainContactName");
            return (Criteria) this;
        }

        public Criteria andTrainContactNameGreaterThanOrEqualTo(String value) {
            addCriterion("train_contact_name >=", value, "trainContactName");
            return (Criteria) this;
        }

        public Criteria andTrainContactNameLessThan(String value) {
            addCriterion("train_contact_name <", value, "trainContactName");
            return (Criteria) this;
        }

        public Criteria andTrainContactNameLessThanOrEqualTo(String value) {
            addCriterion("train_contact_name <=", value, "trainContactName");
            return (Criteria) this;
        }

        public Criteria andTrainContactNameLike(String value) {
            addCriterion("train_contact_name like", value, "trainContactName");
            return (Criteria) this;
        }

        public Criteria andTrainContactNameNotLike(String value) {
            addCriterion("train_contact_name not like", value, "trainContactName");
            return (Criteria) this;
        }

        public Criteria andTrainContactNameIn(List<String> values) {
            addCriterion("train_contact_name in", values, "trainContactName");
            return (Criteria) this;
        }

        public Criteria andTrainContactNameNotIn(List<String> values) {
            addCriterion("train_contact_name not in", values, "trainContactName");
            return (Criteria) this;
        }

        public Criteria andTrainContactNameBetween(String value1, String value2) {
            addCriterion("train_contact_name between", value1, value2, "trainContactName");
            return (Criteria) this;
        }

        public Criteria andTrainContactNameNotBetween(String value1, String value2) {
            addCriterion("train_contact_name not between", value1, value2, "trainContactName");
            return (Criteria) this;
        }

        public Criteria andTrainContactPhoneIsNull() {
            addCriterion("train_contact_phone is null");
            return (Criteria) this;
        }

        public Criteria andTrainContactPhoneIsNotNull() {
            addCriterion("train_contact_phone is not null");
            return (Criteria) this;
        }

        public Criteria andTrainContactPhoneEqualTo(String value) {
            addCriterion("train_contact_phone =", value, "trainContactPhone");
            return (Criteria) this;
        }

        public Criteria andTrainContactPhoneNotEqualTo(String value) {
            addCriterion("train_contact_phone <>", value, "trainContactPhone");
            return (Criteria) this;
        }

        public Criteria andTrainContactPhoneGreaterThan(String value) {
            addCriterion("train_contact_phone >", value, "trainContactPhone");
            return (Criteria) this;
        }

        public Criteria andTrainContactPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("train_contact_phone >=", value, "trainContactPhone");
            return (Criteria) this;
        }

        public Criteria andTrainContactPhoneLessThan(String value) {
            addCriterion("train_contact_phone <", value, "trainContactPhone");
            return (Criteria) this;
        }

        public Criteria andTrainContactPhoneLessThanOrEqualTo(String value) {
            addCriterion("train_contact_phone <=", value, "trainContactPhone");
            return (Criteria) this;
        }

        public Criteria andTrainContactPhoneLike(String value) {
            addCriterion("train_contact_phone like", value, "trainContactPhone");
            return (Criteria) this;
        }

        public Criteria andTrainContactPhoneNotLike(String value) {
            addCriterion("train_contact_phone not like", value, "trainContactPhone");
            return (Criteria) this;
        }

        public Criteria andTrainContactPhoneIn(List<String> values) {
            addCriterion("train_contact_phone in", values, "trainContactPhone");
            return (Criteria) this;
        }

        public Criteria andTrainContactPhoneNotIn(List<String> values) {
            addCriterion("train_contact_phone not in", values, "trainContactPhone");
            return (Criteria) this;
        }

        public Criteria andTrainContactPhoneBetween(String value1, String value2) {
            addCriterion("train_contact_phone between", value1, value2, "trainContactPhone");
            return (Criteria) this;
        }

        public Criteria andTrainContactPhoneNotBetween(String value1, String value2) {
            addCriterion("train_contact_phone not between", value1, value2, "trainContactPhone");
            return (Criteria) this;
        }

        public Criteria andExpectTrainingContentIsNull() {
            addCriterion("expect_training_content is null");
            return (Criteria) this;
        }

        public Criteria andExpectTrainingContentIsNotNull() {
            addCriterion("expect_training_content is not null");
            return (Criteria) this;
        }

        public Criteria andExpectTrainingContentEqualTo(String value) {
            addCriterion("expect_training_content =", value, "expectTrainingContent");
            return (Criteria) this;
        }

        public Criteria andExpectTrainingContentNotEqualTo(String value) {
            addCriterion("expect_training_content <>", value, "expectTrainingContent");
            return (Criteria) this;
        }

        public Criteria andExpectTrainingContentGreaterThan(String value) {
            addCriterion("expect_training_content >", value, "expectTrainingContent");
            return (Criteria) this;
        }

        public Criteria andExpectTrainingContentGreaterThanOrEqualTo(String value) {
            addCriterion("expect_training_content >=", value, "expectTrainingContent");
            return (Criteria) this;
        }

        public Criteria andExpectTrainingContentLessThan(String value) {
            addCriterion("expect_training_content <", value, "expectTrainingContent");
            return (Criteria) this;
        }

        public Criteria andExpectTrainingContentLessThanOrEqualTo(String value) {
            addCriterion("expect_training_content <=", value, "expectTrainingContent");
            return (Criteria) this;
        }

        public Criteria andExpectTrainingContentLike(String value) {
            addCriterion("expect_training_content like", value, "expectTrainingContent");
            return (Criteria) this;
        }

        public Criteria andExpectTrainingContentNotLike(String value) {
            addCriterion("expect_training_content not like", value, "expectTrainingContent");
            return (Criteria) this;
        }

        public Criteria andExpectTrainingContentIn(List<String> values) {
            addCriterion("expect_training_content in", values, "expectTrainingContent");
            return (Criteria) this;
        }

        public Criteria andExpectTrainingContentNotIn(List<String> values) {
            addCriterion("expect_training_content not in", values, "expectTrainingContent");
            return (Criteria) this;
        }

        public Criteria andExpectTrainingContentBetween(String value1, String value2) {
            addCriterion("expect_training_content between", value1, value2, "expectTrainingContent");
            return (Criteria) this;
        }

        public Criteria andExpectTrainingContentNotBetween(String value1, String value2) {
            addCriterion("expect_training_content not between", value1, value2, "expectTrainingContent");
            return (Criteria) this;
        }

        public Criteria andApplyTrainTimeIsNull() {
            addCriterion("apply_train_time is null");
            return (Criteria) this;
        }

        public Criteria andApplyTrainTimeIsNotNull() {
            addCriterion("apply_train_time is not null");
            return (Criteria) this;
        }

        public Criteria andApplyTrainTimeEqualTo(Date value) {
            addCriterion("apply_train_time =", value, "applyTrainTime");
            return (Criteria) this;
        }

        public Criteria andApplyTrainTimeNotEqualTo(Date value) {
            addCriterion("apply_train_time <>", value, "applyTrainTime");
            return (Criteria) this;
        }

        public Criteria andApplyTrainTimeGreaterThan(Date value) {
            addCriterion("apply_train_time >", value, "applyTrainTime");
            return (Criteria) this;
        }

        public Criteria andApplyTrainTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("apply_train_time >=", value, "applyTrainTime");
            return (Criteria) this;
        }

        public Criteria andApplyTrainTimeLessThan(Date value) {
            addCriterion("apply_train_time <", value, "applyTrainTime");
            return (Criteria) this;
        }

        public Criteria andApplyTrainTimeLessThanOrEqualTo(Date value) {
            addCriterion("apply_train_time <=", value, "applyTrainTime");
            return (Criteria) this;
        }

        public Criteria andApplyTrainTimeIn(List<Date> values) {
            addCriterion("apply_train_time in", values, "applyTrainTime");
            return (Criteria) this;
        }

        public Criteria andApplyTrainTimeNotIn(List<Date> values) {
            addCriterion("apply_train_time not in", values, "applyTrainTime");
            return (Criteria) this;
        }

        public Criteria andApplyTrainTimeBetween(Date value1, Date value2) {
            addCriterion("apply_train_time between", value1, value2, "applyTrainTime");
            return (Criteria) this;
        }

        public Criteria andApplyTrainTimeNotBetween(Date value1, Date value2) {
            addCriterion("apply_train_time not between", value1, value2, "applyTrainTime");
            return (Criteria) this;
        }

        public Criteria andTrainingTimesIsNull() {
            addCriterion("training_times is null");
            return (Criteria) this;
        }

        public Criteria andTrainingTimesIsNotNull() {
            addCriterion("training_times is not null");
            return (Criteria) this;
        }

        public Criteria andTrainingTimesEqualTo(String value) {
            addCriterion("training_times =", value, "trainingTimes");
            return (Criteria) this;
        }

        public Criteria andTrainingTimesNotEqualTo(String value) {
            addCriterion("training_times <>", value, "trainingTimes");
            return (Criteria) this;
        }

        public Criteria andTrainingTimesGreaterThan(String value) {
            addCriterion("training_times >", value, "trainingTimes");
            return (Criteria) this;
        }

        public Criteria andTrainingTimesGreaterThanOrEqualTo(String value) {
            addCriterion("training_times >=", value, "trainingTimes");
            return (Criteria) this;
        }

        public Criteria andTrainingTimesLessThan(String value) {
            addCriterion("training_times <", value, "trainingTimes");
            return (Criteria) this;
        }

        public Criteria andTrainingTimesLessThanOrEqualTo(String value) {
            addCriterion("training_times <=", value, "trainingTimes");
            return (Criteria) this;
        }

        public Criteria andTrainingTimesLike(String value) {
            addCriterion("training_times like", value, "trainingTimes");
            return (Criteria) this;
        }

        public Criteria andTrainingTimesNotLike(String value) {
            addCriterion("training_times not like", value, "trainingTimes");
            return (Criteria) this;
        }

        public Criteria andTrainingTimesIn(List<String> values) {
            addCriterion("training_times in", values, "trainingTimes");
            return (Criteria) this;
        }

        public Criteria andTrainingTimesNotIn(List<String> values) {
            addCriterion("training_times not in", values, "trainingTimes");
            return (Criteria) this;
        }

        public Criteria andTrainingTimesBetween(String value1, String value2) {
            addCriterion("training_times between", value1, value2, "trainingTimes");
            return (Criteria) this;
        }

        public Criteria andTrainingTimesNotBetween(String value1, String value2) {
            addCriterion("training_times not between", value1, value2, "trainingTimes");
            return (Criteria) this;
        }

        public Criteria andWhetherTrainingGroundIsNull() {
            addCriterion("whether_training_ground is null");
            return (Criteria) this;
        }

        public Criteria andWhetherTrainingGroundIsNotNull() {
            addCriterion("whether_training_ground is not null");
            return (Criteria) this;
        }

        public Criteria andWhetherTrainingGroundEqualTo(String value) {
            addCriterion("whether_training_ground =", value, "whetherTrainingGround");
            return (Criteria) this;
        }

        public Criteria andWhetherTrainingGroundNotEqualTo(String value) {
            addCriterion("whether_training_ground <>", value, "whetherTrainingGround");
            return (Criteria) this;
        }

        public Criteria andWhetherTrainingGroundGreaterThan(String value) {
            addCriterion("whether_training_ground >", value, "whetherTrainingGround");
            return (Criteria) this;
        }

        public Criteria andWhetherTrainingGroundGreaterThanOrEqualTo(String value) {
            addCriterion("whether_training_ground >=", value, "whetherTrainingGround");
            return (Criteria) this;
        }

        public Criteria andWhetherTrainingGroundLessThan(String value) {
            addCriterion("whether_training_ground <", value, "whetherTrainingGround");
            return (Criteria) this;
        }

        public Criteria andWhetherTrainingGroundLessThanOrEqualTo(String value) {
            addCriterion("whether_training_ground <=", value, "whetherTrainingGround");
            return (Criteria) this;
        }

        public Criteria andWhetherTrainingGroundLike(String value) {
            addCriterion("whether_training_ground like", value, "whetherTrainingGround");
            return (Criteria) this;
        }

        public Criteria andWhetherTrainingGroundNotLike(String value) {
            addCriterion("whether_training_ground not like", value, "whetherTrainingGround");
            return (Criteria) this;
        }

        public Criteria andWhetherTrainingGroundIn(List<String> values) {
            addCriterion("whether_training_ground in", values, "whetherTrainingGround");
            return (Criteria) this;
        }

        public Criteria andWhetherTrainingGroundNotIn(List<String> values) {
            addCriterion("whether_training_ground not in", values, "whetherTrainingGround");
            return (Criteria) this;
        }

        public Criteria andWhetherTrainingGroundBetween(String value1, String value2) {
            addCriterion("whether_training_ground between", value1, value2, "whetherTrainingGround");
            return (Criteria) this;
        }

        public Criteria andWhetherTrainingGroundNotBetween(String value1, String value2) {
            addCriterion("whether_training_ground not between", value1, value2, "whetherTrainingGround");
            return (Criteria) this;
        }

        public Criteria andTrainAddressIsNull() {
            addCriterion("train_address is null");
            return (Criteria) this;
        }

        public Criteria andTrainAddressIsNotNull() {
            addCriterion("train_address is not null");
            return (Criteria) this;
        }

        public Criteria andTrainAddressEqualTo(String value) {
            addCriterion("train_address =", value, "trainAddress");
            return (Criteria) this;
        }

        public Criteria andTrainAddressNotEqualTo(String value) {
            addCriterion("train_address <>", value, "trainAddress");
            return (Criteria) this;
        }

        public Criteria andTrainAddressGreaterThan(String value) {
            addCriterion("train_address >", value, "trainAddress");
            return (Criteria) this;
        }

        public Criteria andTrainAddressGreaterThanOrEqualTo(String value) {
            addCriterion("train_address >=", value, "trainAddress");
            return (Criteria) this;
        }

        public Criteria andTrainAddressLessThan(String value) {
            addCriterion("train_address <", value, "trainAddress");
            return (Criteria) this;
        }

        public Criteria andTrainAddressLessThanOrEqualTo(String value) {
            addCriterion("train_address <=", value, "trainAddress");
            return (Criteria) this;
        }

        public Criteria andTrainAddressLike(String value) {
            addCriterion("train_address like", value, "trainAddress");
            return (Criteria) this;
        }

        public Criteria andTrainAddressNotLike(String value) {
            addCriterion("train_address not like", value, "trainAddress");
            return (Criteria) this;
        }

        public Criteria andTrainAddressIn(List<String> values) {
            addCriterion("train_address in", values, "trainAddress");
            return (Criteria) this;
        }

        public Criteria andTrainAddressNotIn(List<String> values) {
            addCriterion("train_address not in", values, "trainAddress");
            return (Criteria) this;
        }

        public Criteria andTrainAddressBetween(String value1, String value2) {
            addCriterion("train_address between", value1, value2, "trainAddress");
            return (Criteria) this;
        }

        public Criteria andTrainAddressNotBetween(String value1, String value2) {
            addCriterion("train_address not between", value1, value2, "trainAddress");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andAttaIdIsNull() {
            addCriterion("atta_id is null");
            return (Criteria) this;
        }

        public Criteria andAttaIdIsNotNull() {
            addCriterion("atta_id is not null");
            return (Criteria) this;
        }

        public Criteria andAttaIdEqualTo(String value) {
            addCriterion("atta_id =", value, "attaId");
            return (Criteria) this;
        }

        public Criteria andAttaIdNotEqualTo(String value) {
            addCriterion("atta_id <>", value, "attaId");
            return (Criteria) this;
        }

        public Criteria andAttaIdGreaterThan(String value) {
            addCriterion("atta_id >", value, "attaId");
            return (Criteria) this;
        }

        public Criteria andAttaIdGreaterThanOrEqualTo(String value) {
            addCriterion("atta_id >=", value, "attaId");
            return (Criteria) this;
        }

        public Criteria andAttaIdLessThan(String value) {
            addCriterion("atta_id <", value, "attaId");
            return (Criteria) this;
        }

        public Criteria andAttaIdLessThanOrEqualTo(String value) {
            addCriterion("atta_id <=", value, "attaId");
            return (Criteria) this;
        }

        public Criteria andAttaIdLike(String value) {
            addCriterion("atta_id like", value, "attaId");
            return (Criteria) this;
        }

        public Criteria andAttaIdNotLike(String value) {
            addCriterion("atta_id not like", value, "attaId");
            return (Criteria) this;
        }

        public Criteria andAttaIdIn(List<String> values) {
            addCriterion("atta_id in", values, "attaId");
            return (Criteria) this;
        }

        public Criteria andAttaIdNotIn(List<String> values) {
            addCriterion("atta_id not in", values, "attaId");
            return (Criteria) this;
        }

        public Criteria andAttaIdBetween(String value1, String value2) {
            addCriterion("atta_id between", value1, value2, "attaId");
            return (Criteria) this;
        }

        public Criteria andAttaIdNotBetween(String value1, String value2) {
            addCriterion("atta_id not between", value1, value2, "attaId");
            return (Criteria) this;
        }

        public Criteria andAttaNameIsNull() {
            addCriterion("atta_name is null");
            return (Criteria) this;
        }

        public Criteria andAttaNameIsNotNull() {
            addCriterion("atta_name is not null");
            return (Criteria) this;
        }

        public Criteria andAttaNameEqualTo(String value) {
            addCriterion("atta_name =", value, "attaName");
            return (Criteria) this;
        }

        public Criteria andAttaNameNotEqualTo(String value) {
            addCriterion("atta_name <>", value, "attaName");
            return (Criteria) this;
        }

        public Criteria andAttaNameGreaterThan(String value) {
            addCriterion("atta_name >", value, "attaName");
            return (Criteria) this;
        }

        public Criteria andAttaNameGreaterThanOrEqualTo(String value) {
            addCriterion("atta_name >=", value, "attaName");
            return (Criteria) this;
        }

        public Criteria andAttaNameLessThan(String value) {
            addCriterion("atta_name <", value, "attaName");
            return (Criteria) this;
        }

        public Criteria andAttaNameLessThanOrEqualTo(String value) {
            addCriterion("atta_name <=", value, "attaName");
            return (Criteria) this;
        }

        public Criteria andAttaNameLike(String value) {
            addCriterion("atta_name like", value, "attaName");
            return (Criteria) this;
        }

        public Criteria andAttaNameNotLike(String value) {
            addCriterion("atta_name not like", value, "attaName");
            return (Criteria) this;
        }

        public Criteria andAttaNameIn(List<String> values) {
            addCriterion("atta_name in", values, "attaName");
            return (Criteria) this;
        }

        public Criteria andAttaNameNotIn(List<String> values) {
            addCriterion("atta_name not in", values, "attaName");
            return (Criteria) this;
        }

        public Criteria andAttaNameBetween(String value1, String value2) {
            addCriterion("atta_name between", value1, value2, "attaName");
            return (Criteria) this;
        }

        public Criteria andAttaNameNotBetween(String value1, String value2) {
            addCriterion("atta_name not between", value1, value2, "attaName");
            return (Criteria) this;
        }

        public Criteria andAttaUrlIsNull() {
            addCriterion("atta_url is null");
            return (Criteria) this;
        }

        public Criteria andAttaUrlIsNotNull() {
            addCriterion("atta_url is not null");
            return (Criteria) this;
        }

        public Criteria andAttaUrlEqualTo(String value) {
            addCriterion("atta_url =", value, "attaUrl");
            return (Criteria) this;
        }

        public Criteria andAttaUrlNotEqualTo(String value) {
            addCriterion("atta_url <>", value, "attaUrl");
            return (Criteria) this;
        }

        public Criteria andAttaUrlGreaterThan(String value) {
            addCriterion("atta_url >", value, "attaUrl");
            return (Criteria) this;
        }

        public Criteria andAttaUrlGreaterThanOrEqualTo(String value) {
            addCriterion("atta_url >=", value, "attaUrl");
            return (Criteria) this;
        }

        public Criteria andAttaUrlLessThan(String value) {
            addCriterion("atta_url <", value, "attaUrl");
            return (Criteria) this;
        }

        public Criteria andAttaUrlLessThanOrEqualTo(String value) {
            addCriterion("atta_url <=", value, "attaUrl");
            return (Criteria) this;
        }

        public Criteria andAttaUrlLike(String value) {
            addCriterion("atta_url like", value, "attaUrl");
            return (Criteria) this;
        }

        public Criteria andAttaUrlNotLike(String value) {
            addCriterion("atta_url not like", value, "attaUrl");
            return (Criteria) this;
        }

        public Criteria andAttaUrlIn(List<String> values) {
            addCriterion("atta_url in", values, "attaUrl");
            return (Criteria) this;
        }

        public Criteria andAttaUrlNotIn(List<String> values) {
            addCriterion("atta_url not in", values, "attaUrl");
            return (Criteria) this;
        }

        public Criteria andAttaUrlBetween(String value1, String value2) {
            addCriterion("atta_url between", value1, value2, "attaUrl");
            return (Criteria) this;
        }

        public Criteria andAttaUrlNotBetween(String value1, String value2) {
            addCriterion("atta_url not between", value1, value2, "attaUrl");
            return (Criteria) this;
        }

        public Criteria andExt1IsNull() {
            addCriterion("ext1 is null");
            return (Criteria) this;
        }

        public Criteria andExt1IsNotNull() {
            addCriterion("ext1 is not null");
            return (Criteria) this;
        }

        public Criteria andExt1EqualTo(String value) {
            addCriterion("ext1 =", value, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1NotEqualTo(String value) {
            addCriterion("ext1 <>", value, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1GreaterThan(String value) {
            addCriterion("ext1 >", value, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1GreaterThanOrEqualTo(String value) {
            addCriterion("ext1 >=", value, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1LessThan(String value) {
            addCriterion("ext1 <", value, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1LessThanOrEqualTo(String value) {
            addCriterion("ext1 <=", value, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1Like(String value) {
            addCriterion("ext1 like", value, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1NotLike(String value) {
            addCriterion("ext1 not like", value, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1In(List<String> values) {
            addCriterion("ext1 in", values, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1NotIn(List<String> values) {
            addCriterion("ext1 not in", values, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1Between(String value1, String value2) {
            addCriterion("ext1 between", value1, value2, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1NotBetween(String value1, String value2) {
            addCriterion("ext1 not between", value1, value2, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt2IsNull() {
            addCriterion("ext2 is null");
            return (Criteria) this;
        }

        public Criteria andExt2IsNotNull() {
            addCriterion("ext2 is not null");
            return (Criteria) this;
        }

        public Criteria andExt2EqualTo(String value) {
            addCriterion("ext2 =", value, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2NotEqualTo(String value) {
            addCriterion("ext2 <>", value, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2GreaterThan(String value) {
            addCriterion("ext2 >", value, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2GreaterThanOrEqualTo(String value) {
            addCriterion("ext2 >=", value, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2LessThan(String value) {
            addCriterion("ext2 <", value, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2LessThanOrEqualTo(String value) {
            addCriterion("ext2 <=", value, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2Like(String value) {
            addCriterion("ext2 like", value, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2NotLike(String value) {
            addCriterion("ext2 not like", value, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2In(List<String> values) {
            addCriterion("ext2 in", values, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2NotIn(List<String> values) {
            addCriterion("ext2 not in", values, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2Between(String value1, String value2) {
            addCriterion("ext2 between", value1, value2, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2NotBetween(String value1, String value2) {
            addCriterion("ext2 not between", value1, value2, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt3IsNull() {
            addCriterion("ext3 is null");
            return (Criteria) this;
        }

        public Criteria andExt3IsNotNull() {
            addCriterion("ext3 is not null");
            return (Criteria) this;
        }

        public Criteria andExt3EqualTo(String value) {
            addCriterion("ext3 =", value, "ext3");
            return (Criteria) this;
        }

        public Criteria andExt3NotEqualTo(String value) {
            addCriterion("ext3 <>", value, "ext3");
            return (Criteria) this;
        }

        public Criteria andExt3GreaterThan(String value) {
            addCriterion("ext3 >", value, "ext3");
            return (Criteria) this;
        }

        public Criteria andExt3GreaterThanOrEqualTo(String value) {
            addCriterion("ext3 >=", value, "ext3");
            return (Criteria) this;
        }

        public Criteria andExt3LessThan(String value) {
            addCriterion("ext3 <", value, "ext3");
            return (Criteria) this;
        }

        public Criteria andExt3LessThanOrEqualTo(String value) {
            addCriterion("ext3 <=", value, "ext3");
            return (Criteria) this;
        }

        public Criteria andExt3Like(String value) {
            addCriterion("ext3 like", value, "ext3");
            return (Criteria) this;
        }

        public Criteria andExt3NotLike(String value) {
            addCriterion("ext3 not like", value, "ext3");
            return (Criteria) this;
        }

        public Criteria andExt3In(List<String> values) {
            addCriterion("ext3 in", values, "ext3");
            return (Criteria) this;
        }

        public Criteria andExt3NotIn(List<String> values) {
            addCriterion("ext3 not in", values, "ext3");
            return (Criteria) this;
        }

        public Criteria andExt3Between(String value1, String value2) {
            addCriterion("ext3 between", value1, value2, "ext3");
            return (Criteria) this;
        }

        public Criteria andExt3NotBetween(String value1, String value2) {
            addCriterion("ext3 not between", value1, value2, "ext3");
            return (Criteria) this;
        }

        public Criteria andExt4IsNull() {
            addCriterion("ext4 is null");
            return (Criteria) this;
        }

        public Criteria andExt4IsNotNull() {
            addCriterion("ext4 is not null");
            return (Criteria) this;
        }

        public Criteria andExt4EqualTo(String value) {
            addCriterion("ext4 =", value, "ext4");
            return (Criteria) this;
        }

        public Criteria andExt4NotEqualTo(String value) {
            addCriterion("ext4 <>", value, "ext4");
            return (Criteria) this;
        }

        public Criteria andExt4GreaterThan(String value) {
            addCriterion("ext4 >", value, "ext4");
            return (Criteria) this;
        }

        public Criteria andExt4GreaterThanOrEqualTo(String value) {
            addCriterion("ext4 >=", value, "ext4");
            return (Criteria) this;
        }

        public Criteria andExt4LessThan(String value) {
            addCriterion("ext4 <", value, "ext4");
            return (Criteria) this;
        }

        public Criteria andExt4LessThanOrEqualTo(String value) {
            addCriterion("ext4 <=", value, "ext4");
            return (Criteria) this;
        }

        public Criteria andExt4Like(String value) {
            addCriterion("ext4 like", value, "ext4");
            return (Criteria) this;
        }

        public Criteria andExt4NotLike(String value) {
            addCriterion("ext4 not like", value, "ext4");
            return (Criteria) this;
        }

        public Criteria andExt4In(List<String> values) {
            addCriterion("ext4 in", values, "ext4");
            return (Criteria) this;
        }

        public Criteria andExt4NotIn(List<String> values) {
            addCriterion("ext4 not in", values, "ext4");
            return (Criteria) this;
        }

        public Criteria andExt4Between(String value1, String value2) {
            addCriterion("ext4 between", value1, value2, "ext4");
            return (Criteria) this;
        }

        public Criteria andExt4NotBetween(String value1, String value2) {
            addCriterion("ext4 not between", value1, value2, "ext4");
            return (Criteria) this;
        }

        public Criteria andExt5IsNull() {
            addCriterion("ext5 is null");
            return (Criteria) this;
        }

        public Criteria andExt5IsNotNull() {
            addCriterion("ext5 is not null");
            return (Criteria) this;
        }

        public Criteria andExt5EqualTo(String value) {
            addCriterion("ext5 =", value, "ext5");
            return (Criteria) this;
        }

        public Criteria andExt5NotEqualTo(String value) {
            addCriterion("ext5 <>", value, "ext5");
            return (Criteria) this;
        }

        public Criteria andExt5GreaterThan(String value) {
            addCriterion("ext5 >", value, "ext5");
            return (Criteria) this;
        }

        public Criteria andExt5GreaterThanOrEqualTo(String value) {
            addCriterion("ext5 >=", value, "ext5");
            return (Criteria) this;
        }

        public Criteria andExt5LessThan(String value) {
            addCriterion("ext5 <", value, "ext5");
            return (Criteria) this;
        }

        public Criteria andExt5LessThanOrEqualTo(String value) {
            addCriterion("ext5 <=", value, "ext5");
            return (Criteria) this;
        }

        public Criteria andExt5Like(String value) {
            addCriterion("ext5 like", value, "ext5");
            return (Criteria) this;
        }

        public Criteria andExt5NotLike(String value) {
            addCriterion("ext5 not like", value, "ext5");
            return (Criteria) this;
        }

        public Criteria andExt5In(List<String> values) {
            addCriterion("ext5 in", values, "ext5");
            return (Criteria) this;
        }

        public Criteria andExt5NotIn(List<String> values) {
            addCriterion("ext5 not in", values, "ext5");
            return (Criteria) this;
        }

        public Criteria andExt5Between(String value1, String value2) {
            addCriterion("ext5 between", value1, value2, "ext5");
            return (Criteria) this;
        }

        public Criteria andExt5NotBetween(String value1, String value2) {
            addCriterion("ext5 not between", value1, value2, "ext5");
            return (Criteria) this;
        }

        public Criteria andExt6IsNull() {
            addCriterion("ext6 is null");
            return (Criteria) this;
        }

        public Criteria andExt6IsNotNull() {
            addCriterion("ext6 is not null");
            return (Criteria) this;
        }

        public Criteria andExt6EqualTo(String value) {
            addCriterion("ext6 =", value, "ext6");
            return (Criteria) this;
        }

        public Criteria andExt6NotEqualTo(String value) {
            addCriterion("ext6 <>", value, "ext6");
            return (Criteria) this;
        }

        public Criteria andExt6GreaterThan(String value) {
            addCriterion("ext6 >", value, "ext6");
            return (Criteria) this;
        }

        public Criteria andExt6GreaterThanOrEqualTo(String value) {
            addCriterion("ext6 >=", value, "ext6");
            return (Criteria) this;
        }

        public Criteria andExt6LessThan(String value) {
            addCriterion("ext6 <", value, "ext6");
            return (Criteria) this;
        }

        public Criteria andExt6LessThanOrEqualTo(String value) {
            addCriterion("ext6 <=", value, "ext6");
            return (Criteria) this;
        }

        public Criteria andExt6Like(String value) {
            addCriterion("ext6 like", value, "ext6");
            return (Criteria) this;
        }

        public Criteria andExt6NotLike(String value) {
            addCriterion("ext6 not like", value, "ext6");
            return (Criteria) this;
        }

        public Criteria andExt6In(List<String> values) {
            addCriterion("ext6 in", values, "ext6");
            return (Criteria) this;
        }

        public Criteria andExt6NotIn(List<String> values) {
            addCriterion("ext6 not in", values, "ext6");
            return (Criteria) this;
        }

        public Criteria andExt6Between(String value1, String value2) {
            addCriterion("ext6 between", value1, value2, "ext6");
            return (Criteria) this;
        }

        public Criteria andExt6NotBetween(String value1, String value2) {
            addCriterion("ext6 not between", value1, value2, "ext6");
            return (Criteria) this;
        }

        public Criteria andExt7IsNull() {
            addCriterion("ext7 is null");
            return (Criteria) this;
        }

        public Criteria andExt7IsNotNull() {
            addCriterion("ext7 is not null");
            return (Criteria) this;
        }

        public Criteria andExt7EqualTo(String value) {
            addCriterion("ext7 =", value, "ext7");
            return (Criteria) this;
        }

        public Criteria andExt7NotEqualTo(String value) {
            addCriterion("ext7 <>", value, "ext7");
            return (Criteria) this;
        }

        public Criteria andExt7GreaterThan(String value) {
            addCriterion("ext7 >", value, "ext7");
            return (Criteria) this;
        }

        public Criteria andExt7GreaterThanOrEqualTo(String value) {
            addCriterion("ext7 >=", value, "ext7");
            return (Criteria) this;
        }

        public Criteria andExt7LessThan(String value) {
            addCriterion("ext7 <", value, "ext7");
            return (Criteria) this;
        }

        public Criteria andExt7LessThanOrEqualTo(String value) {
            addCriterion("ext7 <=", value, "ext7");
            return (Criteria) this;
        }

        public Criteria andExt7Like(String value) {
            addCriterion("ext7 like", value, "ext7");
            return (Criteria) this;
        }

        public Criteria andExt7NotLike(String value) {
            addCriterion("ext7 not like", value, "ext7");
            return (Criteria) this;
        }

        public Criteria andExt7In(List<String> values) {
            addCriterion("ext7 in", values, "ext7");
            return (Criteria) this;
        }

        public Criteria andExt7NotIn(List<String> values) {
            addCriterion("ext7 not in", values, "ext7");
            return (Criteria) this;
        }

        public Criteria andExt7Between(String value1, String value2) {
            addCriterion("ext7 between", value1, value2, "ext7");
            return (Criteria) this;
        }

        public Criteria andExt7NotBetween(String value1, String value2) {
            addCriterion("ext7 not between", value1, value2, "ext7");
            return (Criteria) this;
        }

        public Criteria andExt8IsNull() {
            addCriterion("ext8 is null");
            return (Criteria) this;
        }

        public Criteria andExt8IsNotNull() {
            addCriterion("ext8 is not null");
            return (Criteria) this;
        }

        public Criteria andExt8EqualTo(String value) {
            addCriterion("ext8 =", value, "ext8");
            return (Criteria) this;
        }

        public Criteria andExt8NotEqualTo(String value) {
            addCriterion("ext8 <>", value, "ext8");
            return (Criteria) this;
        }

        public Criteria andExt8GreaterThan(String value) {
            addCriterion("ext8 >", value, "ext8");
            return (Criteria) this;
        }

        public Criteria andExt8GreaterThanOrEqualTo(String value) {
            addCriterion("ext8 >=", value, "ext8");
            return (Criteria) this;
        }

        public Criteria andExt8LessThan(String value) {
            addCriterion("ext8 <", value, "ext8");
            return (Criteria) this;
        }

        public Criteria andExt8LessThanOrEqualTo(String value) {
            addCriterion("ext8 <=", value, "ext8");
            return (Criteria) this;
        }

        public Criteria andExt8Like(String value) {
            addCriterion("ext8 like", value, "ext8");
            return (Criteria) this;
        }

        public Criteria andExt8NotLike(String value) {
            addCriterion("ext8 not like", value, "ext8");
            return (Criteria) this;
        }

        public Criteria andExt8In(List<String> values) {
            addCriterion("ext8 in", values, "ext8");
            return (Criteria) this;
        }

        public Criteria andExt8NotIn(List<String> values) {
            addCriterion("ext8 not in", values, "ext8");
            return (Criteria) this;
        }

        public Criteria andExt8Between(String value1, String value2) {
            addCriterion("ext8 between", value1, value2, "ext8");
            return (Criteria) this;
        }

        public Criteria andExt8NotBetween(String value1, String value2) {
            addCriterion("ext8 not between", value1, value2, "ext8");
            return (Criteria) this;
        }

        public Criteria andExt9IsNull() {
            addCriterion("ext9 is null");
            return (Criteria) this;
        }

        public Criteria andExt9IsNotNull() {
            addCriterion("ext9 is not null");
            return (Criteria) this;
        }

        public Criteria andExt9EqualTo(String value) {
            addCriterion("ext9 =", value, "ext9");
            return (Criteria) this;
        }

        public Criteria andExt9NotEqualTo(String value) {
            addCriterion("ext9 <>", value, "ext9");
            return (Criteria) this;
        }

        public Criteria andExt9GreaterThan(String value) {
            addCriterion("ext9 >", value, "ext9");
            return (Criteria) this;
        }

        public Criteria andExt9GreaterThanOrEqualTo(String value) {
            addCriterion("ext9 >=", value, "ext9");
            return (Criteria) this;
        }

        public Criteria andExt9LessThan(String value) {
            addCriterion("ext9 <", value, "ext9");
            return (Criteria) this;
        }

        public Criteria andExt9LessThanOrEqualTo(String value) {
            addCriterion("ext9 <=", value, "ext9");
            return (Criteria) this;
        }

        public Criteria andExt9Like(String value) {
            addCriterion("ext9 like", value, "ext9");
            return (Criteria) this;
        }

        public Criteria andExt9NotLike(String value) {
            addCriterion("ext9 not like", value, "ext9");
            return (Criteria) this;
        }

        public Criteria andExt9In(List<String> values) {
            addCriterion("ext9 in", values, "ext9");
            return (Criteria) this;
        }

        public Criteria andExt9NotIn(List<String> values) {
            addCriterion("ext9 not in", values, "ext9");
            return (Criteria) this;
        }

        public Criteria andExt9Between(String value1, String value2) {
            addCriterion("ext9 between", value1, value2, "ext9");
            return (Criteria) this;
        }

        public Criteria andExt9NotBetween(String value1, String value2) {
            addCriterion("ext9 not between", value1, value2, "ext9");
            return (Criteria) this;
        }

        public Criteria andExt10IsNull() {
            addCriterion("ext10 is null");
            return (Criteria) this;
        }

        public Criteria andExt10IsNotNull() {
            addCriterion("ext10 is not null");
            return (Criteria) this;
        }

        public Criteria andExt10EqualTo(String value) {
            addCriterion("ext10 =", value, "ext10");
            return (Criteria) this;
        }

        public Criteria andExt10NotEqualTo(String value) {
            addCriterion("ext10 <>", value, "ext10");
            return (Criteria) this;
        }

        public Criteria andExt10GreaterThan(String value) {
            addCriterion("ext10 >", value, "ext10");
            return (Criteria) this;
        }

        public Criteria andExt10GreaterThanOrEqualTo(String value) {
            addCriterion("ext10 >=", value, "ext10");
            return (Criteria) this;
        }

        public Criteria andExt10LessThan(String value) {
            addCriterion("ext10 <", value, "ext10");
            return (Criteria) this;
        }

        public Criteria andExt10LessThanOrEqualTo(String value) {
            addCriterion("ext10 <=", value, "ext10");
            return (Criteria) this;
        }

        public Criteria andExt10Like(String value) {
            addCriterion("ext10 like", value, "ext10");
            return (Criteria) this;
        }

        public Criteria andExt10NotLike(String value) {
            addCriterion("ext10 not like", value, "ext10");
            return (Criteria) this;
        }

        public Criteria andExt10In(List<String> values) {
            addCriterion("ext10 in", values, "ext10");
            return (Criteria) this;
        }

        public Criteria andExt10NotIn(List<String> values) {
            addCriterion("ext10 not in", values, "ext10");
            return (Criteria) this;
        }

        public Criteria andExt10Between(String value1, String value2) {
            addCriterion("ext10 between", value1, value2, "ext10");
            return (Criteria) this;
        }

        public Criteria andExt10NotBetween(String value1, String value2) {
            addCriterion("ext10 not between", value1, value2, "ext10");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreaterIsNull() {
            addCriterion("creater is null");
            return (Criteria) this;
        }

        public Criteria andCreaterIsNotNull() {
            addCriterion("creater is not null");
            return (Criteria) this;
        }

        public Criteria andCreaterEqualTo(String value) {
            addCriterion("creater =", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterNotEqualTo(String value) {
            addCriterion("creater <>", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterGreaterThan(String value) {
            addCriterion("creater >", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterGreaterThanOrEqualTo(String value) {
            addCriterion("creater >=", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterLessThan(String value) {
            addCriterion("creater <", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterLessThanOrEqualTo(String value) {
            addCriterion("creater <=", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterLike(String value) {
            addCriterion("creater like", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterNotLike(String value) {
            addCriterion("creater not like", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterIn(List<String> values) {
            addCriterion("creater in", values, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterNotIn(List<String> values) {
            addCriterion("creater not in", values, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterBetween(String value1, String value2) {
            addCriterion("creater between", value1, value2, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterNotBetween(String value1, String value2) {
            addCriterion("creater not between", value1, value2, "creater");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdaterIsNull() {
            addCriterion("updater is null");
            return (Criteria) this;
        }

        public Criteria andUpdaterIsNotNull() {
            addCriterion("updater is not null");
            return (Criteria) this;
        }

        public Criteria andUpdaterEqualTo(String value) {
            addCriterion("updater =", value, "updater");
            return (Criteria) this;
        }

        public Criteria andUpdaterNotEqualTo(String value) {
            addCriterion("updater <>", value, "updater");
            return (Criteria) this;
        }

        public Criteria andUpdaterGreaterThan(String value) {
            addCriterion("updater >", value, "updater");
            return (Criteria) this;
        }

        public Criteria andUpdaterGreaterThanOrEqualTo(String value) {
            addCriterion("updater >=", value, "updater");
            return (Criteria) this;
        }

        public Criteria andUpdaterLessThan(String value) {
            addCriterion("updater <", value, "updater");
            return (Criteria) this;
        }

        public Criteria andUpdaterLessThanOrEqualTo(String value) {
            addCriterion("updater <=", value, "updater");
            return (Criteria) this;
        }

        public Criteria andUpdaterLike(String value) {
            addCriterion("updater like", value, "updater");
            return (Criteria) this;
        }

        public Criteria andUpdaterNotLike(String value) {
            addCriterion("updater not like", value, "updater");
            return (Criteria) this;
        }

        public Criteria andUpdaterIn(List<String> values) {
            addCriterion("updater in", values, "updater");
            return (Criteria) this;
        }

        public Criteria andUpdaterNotIn(List<String> values) {
            addCriterion("updater not in", values, "updater");
            return (Criteria) this;
        }

        public Criteria andUpdaterBetween(String value1, String value2) {
            addCriterion("updater between", value1, value2, "updater");
            return (Criteria) this;
        }

        public Criteria andUpdaterNotBetween(String value1, String value2) {
            addCriterion("updater not between", value1, value2, "updater");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria implements Serializable {
        private static final long serialVersionUID = 1L;

        protected Criteria() {
            super();
        }
    }

    public static class Criterion implements Serializable {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        private static final long serialVersionUID = 1L;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}