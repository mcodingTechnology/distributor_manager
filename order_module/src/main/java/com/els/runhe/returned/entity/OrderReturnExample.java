package com.els.runhe.returned.entity;

import com.els.base.core.entity.AbstractExample;
import com.els.base.core.entity.PageView;
import com.els.runhe.order.entity.OrderExample.Criteria;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderReturnExample extends AbstractExample<OrderReturn> implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected PageView<OrderReturn> pageView = new PageView<OrderReturn>(1, 10);

    private static final long serialVersionUID = 1L;

    public OrderReturnExample() {
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
    public PageView<OrderReturn> getPageView() {
        return pageView;
    }

    @Override
    public void setPageView(PageView<OrderReturn> pageView) {
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

        public Criteria andOrderReturnNoIsNull() {
            addCriterion("order_return_no is null");
            return (Criteria) this;
        }

        public Criteria andOrderReturnNoIsNotNull() {
            addCriterion("order_return_no is not null");
            return (Criteria) this;
        }

        public Criteria andOrderReturnNoEqualTo(String value) {
            addCriterion("order_return_no =", value, "orderReturnNo");
            return (Criteria) this;
        }

        public Criteria andOrderReturnNoNotEqualTo(String value) {
            addCriterion("order_return_no <>", value, "orderReturnNo");
            return (Criteria) this;
        }

        public Criteria andOrderReturnNoGreaterThan(String value) {
            addCriterion("order_return_no >", value, "orderReturnNo");
            return (Criteria) this;
        }

        public Criteria andOrderReturnNoGreaterThanOrEqualTo(String value) {
            addCriterion("order_return_no >=", value, "orderReturnNo");
            return (Criteria) this;
        }

        public Criteria andOrderReturnNoLessThan(String value) {
            addCriterion("order_return_no <", value, "orderReturnNo");
            return (Criteria) this;
        }

        public Criteria andOrderReturnNoLessThanOrEqualTo(String value) {
            addCriterion("order_return_no <=", value, "orderReturnNo");
            return (Criteria) this;
        }

        public Criteria andOrderReturnNoLike(String value) {
            addCriterion("order_return_no like", value, "orderReturnNo");
            return (Criteria) this;
        }

        public Criteria andOrderReturnNoNotLike(String value) {
            addCriterion("order_return_no not like", value, "orderReturnNo");
            return (Criteria) this;
        }

        public Criteria andOrderReturnNoIn(List<String> values) {
            addCriterion("order_return_no in", values, "orderReturnNo");
            return (Criteria) this;
        }

        public Criteria andOrderReturnNoNotIn(List<String> values) {
            addCriterion("order_return_no not in", values, "orderReturnNo");
            return (Criteria) this;
        }

        public Criteria andOrderReturnNoBetween(String value1, String value2) {
            addCriterion("order_return_no between", value1, value2, "orderReturnNo");
            return (Criteria) this;
        }

        public Criteria andOrderReturnNoNotBetween(String value1, String value2) {
            addCriterion("order_return_no not between", value1, value2, "orderReturnNo");
            return (Criteria) this;
        }

        public Criteria andOrderTimeIsNull() {
            addCriterion("order_time is null");
            return (Criteria) this;
        }

        public Criteria andOrderTimeIsNotNull() {
            addCriterion("order_time is not null");
            return (Criteria) this;
        }

        public Criteria andOrderTimeEqualTo(Date value) {
            addCriterion("order_time =", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeNotEqualTo(Date value) {
            addCriterion("order_time <>", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeGreaterThan(Date value) {
            addCriterion("order_time >", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("order_time >=", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeLessThan(Date value) {
            addCriterion("order_time <", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeLessThanOrEqualTo(Date value) {
            addCriterion("order_time <=", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeIn(List<Date> values) {
            addCriterion("order_time in", values, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeNotIn(List<Date> values) {
            addCriterion("order_time not in", values, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeBetween(Date value1, Date value2) {
            addCriterion("order_time between", value1, value2, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeNotBetween(Date value1, Date value2) {
            addCriterion("order_time not between", value1, value2, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderReturnStatusIsNull() {
            addCriterion("order_return_status is null");
            return (Criteria) this;
        }

        public Criteria andOrderReturnStatusIsNotNull() {
            addCriterion("order_return_status is not null");
            return (Criteria) this;
        }

        public Criteria andOrderReturnStatusEqualTo(Integer value) {
            addCriterion("order_return_status =", value, "orderReturnStatus");
            return (Criteria) this;
        }

        public Criteria andOrderReturnStatusNotEqualTo(Integer value) {
            addCriterion("order_return_status <>", value, "orderReturnStatus");
            return (Criteria) this;
        }

        public Criteria andOrderReturnStatusGreaterThan(Integer value) {
            addCriterion("order_return_status >", value, "orderReturnStatus");
            return (Criteria) this;
        }

        public Criteria andOrderReturnStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_return_status >=", value, "orderReturnStatus");
            return (Criteria) this;
        }

        public Criteria andOrderReturnStatusLessThan(Integer value) {
            addCriterion("order_return_status <", value, "orderReturnStatus");
            return (Criteria) this;
        }

        public Criteria andOrderReturnStatusLessThanOrEqualTo(Integer value) {
            addCriterion("order_return_status <=", value, "orderReturnStatus");
            return (Criteria) this;
        }

        public Criteria andOrderReturnStatusLike(Integer value) {
            addCriterion("order_return_status like", value, "orderReturnStatus");
            return (Criteria) this;
        }

        public Criteria andOrderReturnStatusNotLike(Integer value) {
            addCriterion("order_return_status not like", value, "orderReturnStatus");
            return (Criteria) this;
        }

        public Criteria andOrderReturnStatusIn(List<Integer> values) {
            addCriterion("order_return_status in", values, "orderReturnStatus");
            return (Criteria) this;
        }

        public Criteria andOrderReturnStatusNotIn(List<Integer> values) {
            addCriterion("order_return_status not in", values, "orderReturnStatus");
            return (Criteria) this;
        }

        public Criteria andOrderReturnStatusBetween(Integer value1, Integer value2) {
            addCriterion("order_return_status between", value1, value2, "orderReturnStatus");
            return (Criteria) this;
        }

        public Criteria andOrderReturnStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("order_return_status not between", value1, value2, "orderReturnStatus");
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

        public Criteria andPurCompanyIdIsNull() {
            addCriterion("pur_company_id is null");
            return (Criteria) this;
        }
        public Criteria andNotPurCompanyId() {
            addCriterion("1 > 1");
            return (Criteria) this;
        }

        public Criteria andPurCompanyIdIsNotNull() {
            addCriterion("pur_company_id is not null");
            return (Criteria) this;
        }

        public Criteria andPurCompanyIdEqualTo(String value) {
            addCriterion("pur_company_id =", value, "purCompanyId");
            return (Criteria) this;
        }

        public Criteria andPurCompanyIdNotEqualTo(String value) {
            addCriterion("pur_company_id <>", value, "purCompanyId");
            return (Criteria) this;
        }

        public Criteria andPurCompanyIdGreaterThan(String value) {
            addCriterion("pur_company_id >", value, "purCompanyId");
            return (Criteria) this;
        }

        public Criteria andPurCompanyIdGreaterThanOrEqualTo(String value) {
            addCriterion("pur_company_id >=", value, "purCompanyId");
            return (Criteria) this;
        }

        public Criteria andPurCompanyIdLessThan(String value) {
            addCriterion("pur_company_id <", value, "purCompanyId");
            return (Criteria) this;
        }

        public Criteria andPurCompanyIdLessThanOrEqualTo(String value) {
            addCriterion("pur_company_id <=", value, "purCompanyId");
            return (Criteria) this;
        }

        public Criteria andPurCompanyIdLike(String value) {
            addCriterion("pur_company_id like", value, "purCompanyId");
            return (Criteria) this;
        }

        public Criteria andPurCompanyIdNotLike(String value) {
            addCriterion("pur_company_id not like", value, "purCompanyId");
            return (Criteria) this;
        }

        public Criteria andPurCompanyIdIn(List<String> values) {
            addCriterion("pur_company_id in", values, "purCompanyId");
            return (Criteria) this;
        }

        public Criteria andPurCompanyIdNotIn(List<String> values) {
            addCriterion("pur_company_id not in", values, "purCompanyId");
            return (Criteria) this;
        }

        public Criteria andPurCompanyIdBetween(String value1, String value2) {
            addCriterion("pur_company_id between", value1, value2, "purCompanyId");
            return (Criteria) this;
        }

        public Criteria andPurCompanyIdNotBetween(String value1, String value2) {
            addCriterion("pur_company_id not between", value1, value2, "purCompanyId");
            return (Criteria) this;
        }

        public Criteria andPurCompanyNameIsNull() {
            addCriterion("pur_company_name is null");
            return (Criteria) this;
        }

        public Criteria andPurCompanyNameIsNotNull() {
            addCriterion("pur_company_name is not null");
            return (Criteria) this;
        }

        public Criteria andPurCompanyNameEqualTo(String value) {
            addCriterion("pur_company_name =", value, "purCompanyName");
            return (Criteria) this;
        }

        public Criteria andPurCompanyNameNotEqualTo(String value) {
            addCriterion("pur_company_name <>", value, "purCompanyName");
            return (Criteria) this;
        }

        public Criteria andPurCompanyNameGreaterThan(String value) {
            addCriterion("pur_company_name >", value, "purCompanyName");
            return (Criteria) this;
        }

        public Criteria andPurCompanyNameGreaterThanOrEqualTo(String value) {
            addCriterion("pur_company_name >=", value, "purCompanyName");
            return (Criteria) this;
        }

        public Criteria andPurCompanyNameLessThan(String value) {
            addCriterion("pur_company_name <", value, "purCompanyName");
            return (Criteria) this;
        }

        public Criteria andPurCompanyNameLessThanOrEqualTo(String value) {
            addCriterion("pur_company_name <=", value, "purCompanyName");
            return (Criteria) this;
        }

        public Criteria andPurCompanyNameLike(String value) {
            addCriterion("pur_company_name like", value, "purCompanyName");
            return (Criteria) this;
        }

        public Criteria andPurCompanyNameNotLike(String value) {
            addCriterion("pur_company_name not like", value, "purCompanyName");
            return (Criteria) this;
        }

        public Criteria andPurCompanyNameIn(List<String> values) {
            addCriterion("pur_company_name in", values, "purCompanyName");
            return (Criteria) this;
        }

        public Criteria andPurCompanyNameNotIn(List<String> values) {
            addCriterion("pur_company_name not in", values, "purCompanyName");
            return (Criteria) this;
        }

        public Criteria andPurCompanyNameBetween(String value1, String value2) {
            addCriterion("pur_company_name between", value1, value2, "purCompanyName");
            return (Criteria) this;
        }

        public Criteria andPurCompanyNameNotBetween(String value1, String value2) {
            addCriterion("pur_company_name not between", value1, value2, "purCompanyName");
            return (Criteria) this;
        }

        public Criteria andSupCompanyIdIsNull() {
            addCriterion("sup_company_id is null");
            return (Criteria) this;
        }

        public Criteria andSupCompanyIdIsNotNull() {
            addCriterion("sup_company_id is not null");
            return (Criteria) this;
        }

        public Criteria andSupCompanyIdEqualTo(String value) {
            addCriterion("sup_company_id =", value, "supCompanyId");
            return (Criteria) this;
        }

        public Criteria andSupCompanyIdNotEqualTo(String value) {
            addCriterion("sup_company_id <>", value, "supCompanyId");
            return (Criteria) this;
        }

        public Criteria andSupCompanyIdGreaterThan(String value) {
            addCriterion("sup_company_id >", value, "supCompanyId");
            return (Criteria) this;
        }

        public Criteria andSupCompanyIdGreaterThanOrEqualTo(String value) {
            addCriterion("sup_company_id >=", value, "supCompanyId");
            return (Criteria) this;
        }

        public Criteria andSupCompanyIdLessThan(String value) {
            addCriterion("sup_company_id <", value, "supCompanyId");
            return (Criteria) this;
        }

        public Criteria andSupCompanyIdLessThanOrEqualTo(String value) {
            addCriterion("sup_company_id <=", value, "supCompanyId");
            return (Criteria) this;
        }

        public Criteria andSupCompanyIdLike(String value) {
            addCriterion("sup_company_id like", value, "supCompanyId");
            return (Criteria) this;
        }

        public Criteria andSupCompanyIdNotLike(String value) {
            addCriterion("sup_company_id not like", value, "supCompanyId");
            return (Criteria) this;
        }

        public Criteria andSupCompanyIdIn(List<String> values) {
            addCriterion("sup_company_id in", values, "supCompanyId");
            return (Criteria) this;
        }

        public Criteria andSupCompanyIdNotIn(List<String> values) {
            addCriterion("sup_company_id not in", values, "supCompanyId");
            return (Criteria) this;
        }

        public Criteria andSupCompanyIdBetween(String value1, String value2) {
            addCriterion("sup_company_id between", value1, value2, "supCompanyId");
            return (Criteria) this;
        }

        public Criteria andSupCompanyIdNotBetween(String value1, String value2) {
            addCriterion("sup_company_id not between", value1, value2, "supCompanyId");
            return (Criteria) this;
        }

        public Criteria andSupCompanyNameIsNull() {
            addCriterion("sup_company_name is null");
            return (Criteria) this;
        }

        public Criteria andSupCompanyNameIsNotNull() {
            addCriterion("sup_company_name is not null");
            return (Criteria) this;
        }

        public Criteria andSupCompanyNameEqualTo(String value) {
            addCriterion("sup_company_name =", value, "supCompanyName");
            return (Criteria) this;
        }

        public Criteria andSupCompanyNameNotEqualTo(String value) {
            addCriterion("sup_company_name <>", value, "supCompanyName");
            return (Criteria) this;
        }

        public Criteria andSupCompanyNameGreaterThan(String value) {
            addCriterion("sup_company_name >", value, "supCompanyName");
            return (Criteria) this;
        }

        public Criteria andSupCompanyNameGreaterThanOrEqualTo(String value) {
            addCriterion("sup_company_name >=", value, "supCompanyName");
            return (Criteria) this;
        }

        public Criteria andSupCompanyNameLessThan(String value) {
            addCriterion("sup_company_name <", value, "supCompanyName");
            return (Criteria) this;
        }

        public Criteria andSupCompanyNameLessThanOrEqualTo(String value) {
            addCriterion("sup_company_name <=", value, "supCompanyName");
            return (Criteria) this;
        }

        public Criteria andSupCompanyNameLike(String value) {
            addCriterion("sup_company_name like", value, "supCompanyName");
            return (Criteria) this;
        }

        public Criteria andSupCompanyNameNotLike(String value) {
            addCriterion("sup_company_name not like", value, "supCompanyName");
            return (Criteria) this;
        }

        public Criteria andSupCompanyNameIn(List<String> values) {
            addCriterion("sup_company_name in", values, "supCompanyName");
            return (Criteria) this;
        }

        public Criteria andSupCompanyNameNotIn(List<String> values) {
            addCriterion("sup_company_name not in", values, "supCompanyName");
            return (Criteria) this;
        }

        public Criteria andSupCompanyNameBetween(String value1, String value2) {
            addCriterion("sup_company_name between", value1, value2, "supCompanyName");
            return (Criteria) this;
        }

        public Criteria andSupCompanyNameNotBetween(String value1, String value2) {
            addCriterion("sup_company_name not between", value1, value2, "supCompanyName");
            return (Criteria) this;
        }

        public Criteria andAddTimeIsNull() {
            addCriterion("add_time is null");
            return (Criteria) this;
        }

        public Criteria andAddTimeIsNotNull() {
            addCriterion("add_time is not null");
            return (Criteria) this;
        }

        public Criteria andAddTimeEqualTo(Date value) {
            addCriterion("add_time =", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeNotEqualTo(Date value) {
            addCriterion("add_time <>", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeGreaterThan(Date value) {
            addCriterion("add_time >", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("add_time >=", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeLessThan(Date value) {
            addCriterion("add_time <", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeLessThanOrEqualTo(Date value) {
            addCriterion("add_time <=", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeIn(List<Date> values) {
            addCriterion("add_time in", values, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeNotIn(List<Date> values) {
            addCriterion("add_time not in", values, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeBetween(Date value1, Date value2) {
            addCriterion("add_time between", value1, value2, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeNotBetween(Date value1, Date value2) {
            addCriterion("add_time not between", value1, value2, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddressReveiverIsNull() {
            addCriterion("address_reveiver is null");
            return (Criteria) this;
        }

        public Criteria andAddressReveiverIsNotNull() {
            addCriterion("address_reveiver is not null");
            return (Criteria) this;
        }

        public Criteria andAddressReveiverEqualTo(String value) {
            addCriterion("address_reveiver =", value, "addressReveiver");
            return (Criteria) this;
        }

        public Criteria andAddressReveiverNotEqualTo(String value) {
            addCriterion("address_reveiver <>", value, "addressReveiver");
            return (Criteria) this;
        }

        public Criteria andAddressReveiverGreaterThan(String value) {
            addCriterion("address_reveiver >", value, "addressReveiver");
            return (Criteria) this;
        }

        public Criteria andAddressReveiverGreaterThanOrEqualTo(String value) {
            addCriterion("address_reveiver >=", value, "addressReveiver");
            return (Criteria) this;
        }

        public Criteria andAddressReveiverLessThan(String value) {
            addCriterion("address_reveiver <", value, "addressReveiver");
            return (Criteria) this;
        }

        public Criteria andAddressReveiverLessThanOrEqualTo(String value) {
            addCriterion("address_reveiver <=", value, "addressReveiver");
            return (Criteria) this;
        }

        public Criteria andAddressReveiverLike(String value) {
            addCriterion("address_reveiver like", value, "addressReveiver");
            return (Criteria) this;
        }

        public Criteria andAddressReveiverNotLike(String value) {
            addCriterion("address_reveiver not like", value, "addressReveiver");
            return (Criteria) this;
        }

        public Criteria andAddressReveiverIn(List<String> values) {
            addCriterion("address_reveiver in", values, "addressReveiver");
            return (Criteria) this;
        }

        public Criteria andAddressReveiverNotIn(List<String> values) {
            addCriterion("address_reveiver not in", values, "addressReveiver");
            return (Criteria) this;
        }

        public Criteria andAddressReveiverBetween(String value1, String value2) {
            addCriterion("address_reveiver between", value1, value2, "addressReveiver");
            return (Criteria) this;
        }

        public Criteria andAddressReveiverNotBetween(String value1, String value2) {
            addCriterion("address_reveiver not between", value1, value2, "addressReveiver");
            return (Criteria) this;
        }

        public Criteria andAddressPhoneIsNull() {
            addCriterion("address_phone is null");
            return (Criteria) this;
        }

        public Criteria andAddressPhoneIsNotNull() {
            addCriterion("address_phone is not null");
            return (Criteria) this;
        }

        public Criteria andAddressPhoneEqualTo(String value) {
            addCriterion("address_phone =", value, "addressPhone");
            return (Criteria) this;
        }

        public Criteria andAddressPhoneNotEqualTo(String value) {
            addCriterion("address_phone <>", value, "addressPhone");
            return (Criteria) this;
        }

        public Criteria andAddressPhoneGreaterThan(String value) {
            addCriterion("address_phone >", value, "addressPhone");
            return (Criteria) this;
        }

        public Criteria andAddressPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("address_phone >=", value, "addressPhone");
            return (Criteria) this;
        }

        public Criteria andAddressPhoneLessThan(String value) {
            addCriterion("address_phone <", value, "addressPhone");
            return (Criteria) this;
        }

        public Criteria andAddressPhoneLessThanOrEqualTo(String value) {
            addCriterion("address_phone <=", value, "addressPhone");
            return (Criteria) this;
        }

        public Criteria andAddressPhoneLike(String value) {
            addCriterion("address_phone like", value, "addressPhone");
            return (Criteria) this;
        }

        public Criteria andAddressPhoneNotLike(String value) {
            addCriterion("address_phone not like", value, "addressPhone");
            return (Criteria) this;
        }

        public Criteria andAddressPhoneIn(List<String> values) {
            addCriterion("address_phone in", values, "addressPhone");
            return (Criteria) this;
        }

        public Criteria andAddressPhoneNotIn(List<String> values) {
            addCriterion("address_phone not in", values, "addressPhone");
            return (Criteria) this;
        }

        public Criteria andAddressPhoneBetween(String value1, String value2) {
            addCriterion("address_phone between", value1, value2, "addressPhone");
            return (Criteria) this;
        }

        public Criteria andAddressPhoneNotBetween(String value1, String value2) {
            addCriterion("address_phone not between", value1, value2, "addressPhone");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }
        
        public Criteria andLogisticsNoIsNull() {
            addCriterion("logistics_no is null");
            return (Criteria) this;
        }

        public Criteria andLogisticsNoIsNotNull() {
            addCriterion("logistics_no is not null");
            return (Criteria) this;
        }

        public Criteria andLogisticsNoEqualTo(String value) {
            addCriterion("logistics_no =", value, "logisticsNo");
            return (Criteria) this;
        }

        public Criteria andLogisticsNoNotEqualTo(String value) {
            addCriterion("logistics_no <>", value, "logisticsNo");
            return (Criteria) this;
        }

        public Criteria andLogisticsNoGreaterThan(String value) {
            addCriterion("logistics_no >", value, "logisticsNo");
            return (Criteria) this;
        }

        public Criteria andLogisticsNoGreaterThanOrEqualTo(String value) {
            addCriterion("logistics_no >=", value, "logisticsNo");
            return (Criteria) this;
        }

        public Criteria andLogisticsNoLessThan(String value) {
            addCriterion("logistics_no <", value, "logisticsNo");
            return (Criteria) this;
        }

        public Criteria andLogisticsNoLessThanOrEqualTo(String value) {
            addCriterion("logistics_no <=", value, "logisticsNo");
            return (Criteria) this;
        }

        public Criteria andLogisticsNoLike(String value) {
            addCriterion("logistics_no like", value, "logisticsNo");
            return (Criteria) this;
        }

        public Criteria andLogisticsNoNotLike(String value) {
            addCriterion("logistics_no not like", value, "logisticsNo");
            return (Criteria) this;
        }

        public Criteria andLogisticsNoIn(List<String> values) {
            addCriterion("logistics_no in", values, "logisticsNo");
            return (Criteria) this;
        }

        public Criteria andLogisticsNoNotIn(List<String> values) {
            addCriterion("logistics_no not in", values, "logisticsNo");
            return (Criteria) this;
        }

        public Criteria andLogisticsNoBetween(String value1, String value2) {
            addCriterion("logistics_no between", value1, value2, "logisticsNo");
            return (Criteria) this;
        }

        public Criteria andLogisticsNoNotBetween(String value1, String value2) {
            addCriterion("logistics_no not between", value1, value2, "logisticsNo");
            return (Criteria) this;
        }
        
        public Criteria andOrderReturnUserNameIsNull() {
            addCriterion("order_return_user_name is null");
            return (Criteria) this;
        }

        public Criteria andOrderReturnUserNameIsNotNull() {
            addCriterion("order_return_user_name is not null");
            return (Criteria) this;
        }

        public Criteria andOrderReturnUserNameEqualTo(String value) {
            addCriterion("order_return_user_name =", value, "orderReturnUserName");
            return (Criteria) this;
        }

        public Criteria andOrderReturnUserNameNotEqualTo(String value) {
            addCriterion("order_return_user_name <>", value, "orderReturnUserName");
            return (Criteria) this;
        }

        public Criteria andOrderReturnUserNameGreaterThan(String value) {
            addCriterion("order_return_user_name >", value, "orderReturnUserName");
            return (Criteria) this;
        }

        public Criteria andOrderReturnUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("order_return_user_name >=", value, "orderReturnUserName");
            return (Criteria) this;
        }

        public Criteria andOrderReturnUserNameLessThan(String value) {
            addCriterion("order_return_user_name <", value, "orderReturnUserName");
            return (Criteria) this;
        }

        public Criteria andOrderReturnUserNameLessThanOrEqualTo(String value) {
            addCriterion("order_return_user_name <=", value, "orderReturnUserName");
            return (Criteria) this;
        }

        public Criteria andOrderReturnUserNameLike(String value) {
            addCriterion("order_return_user_name like", value, "orderReturnUserName");
            return (Criteria) this;
        }

        public Criteria andOrderReturnUserNameNotLike(String value) {
            addCriterion("order_return_user_name not like", value, "orderReturnUserName");
            return (Criteria) this;
        }

        public Criteria andOrderReturnUserNameIn(List<String> values) {
            addCriterion("order_return_user_name in", values, "orderReturnUserName");
            return (Criteria) this;
        }

        public Criteria andOrderReturnUserNameNotIn(List<String> values) {
            addCriterion("order_return_user_name not in", values, "orderReturnUserName");
            return (Criteria) this;
        }

        public Criteria andOrderReturnUserNameBetween(String value1, String value2) {
            addCriterion("order_return_user_name between", value1, value2, "orderReturnUserName");
            return (Criteria) this;
        }

        public Criteria andOrderReturnUserNameNotBetween(String value1, String value2) {
            addCriterion("order_return_user_name not between", value1, value2, "orderReturnUserName");
            return (Criteria) this;
        }

        public Criteria andOrderReturnPhoneIsNull() {
            addCriterion("order_return_phone is null");
            return (Criteria) this;
        }

        public Criteria andOrderReturnPhoneIsNotNull() {
            addCriterion("order_return_phone is not null");
            return (Criteria) this;
        }

        public Criteria andOrderReturnPhoneEqualTo(String value) {
            addCriterion("order_return_phone =", value, "orderReturnPhone");
            return (Criteria) this;
        }

        public Criteria andOrderReturnPhoneNotEqualTo(String value) {
            addCriterion("order_return_phone <>", value, "orderReturnPhone");
            return (Criteria) this;
        }

        public Criteria andOrderReturnPhoneGreaterThan(String value) {
            addCriterion("order_return_phone >", value, "orderReturnPhone");
            return (Criteria) this;
        }

        public Criteria andOrderReturnPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("order_return_phone >=", value, "orderReturnPhone");
            return (Criteria) this;
        }

        public Criteria andOrderReturnPhoneLessThan(String value) {
            addCriterion("order_return_phone <", value, "orderReturnPhone");
            return (Criteria) this;
        }

        public Criteria andOrderReturnPhoneLessThanOrEqualTo(String value) {
            addCriterion("order_return_phone <=", value, "orderReturnPhone");
            return (Criteria) this;
        }

        public Criteria andOrderReturnPhoneLike(String value) {
            addCriterion("order_return_phone like", value, "orderReturnPhone");
            return (Criteria) this;
        }

        public Criteria andOrderReturnPhoneNotLike(String value) {
            addCriterion("order_return_phone not like", value, "orderReturnPhone");
            return (Criteria) this;
        }

        public Criteria andOrderReturnPhoneIn(List<String> values) {
            addCriterion("order_return_phone in", values, "orderReturnPhone");
            return (Criteria) this;
        }

        public Criteria andOrderReturnPhoneNotIn(List<String> values) {
            addCriterion("order_return_phone not in", values, "orderReturnPhone");
            return (Criteria) this;
        }

        public Criteria andOrderReturnPhoneBetween(String value1, String value2) {
            addCriterion("order_return_phone between", value1, value2, "orderReturnPhone");
            return (Criteria) this;
        }

        public Criteria andOrderReturnPhoneNotBetween(String value1, String value2) {
            addCriterion("order_return_phone not between", value1, value2, "orderReturnPhone");
            return (Criteria) this;
        }

        public Criteria andPurchaseOrderNoIsNull() {
            addCriterion("purchase_order_no is null");
            return (Criteria) this;
        }

        public Criteria andPurchaseOrderNoIsNotNull() {
            addCriterion("purchase_order_no is not null");
            return (Criteria) this;
        }

        public Criteria andPurchaseOrderNoEqualTo(String value) {
            addCriterion("purchase_order_no =", value, "purchaseOrderNo");
            return (Criteria) this;
        }

        public Criteria andPurchaseOrderNoNotEqualTo(String value) {
            addCriterion("purchase_order_no <>", value, "purchaseOrderNo");
            return (Criteria) this;
        }

        public Criteria andPurchaseOrderNoGreaterThan(String value) {
            addCriterion("purchase_order_no >", value, "purchaseOrderNo");
            return (Criteria) this;
        }

        public Criteria andPurchaseOrderNoGreaterThanOrEqualTo(String value) {
            addCriterion("purchase_order_no >=", value, "purchaseOrderNo");
            return (Criteria) this;
        }

        public Criteria andPurchaseOrderNoLessThan(String value) {
            addCriterion("purchase_order_no <", value, "purchaseOrderNo");
            return (Criteria) this;
        }

        public Criteria andPurchaseOrderNoLessThanOrEqualTo(String value) {
            addCriterion("purchase_order_no <=", value, "purchaseOrderNo");
            return (Criteria) this;
        }

        public Criteria andPurchaseOrderNoLike(String value) {
            addCriterion("purchase_order_no like", value, "purchaseOrderNo");
            return (Criteria) this;
        }

        public Criteria andPurchaseOrderNoNotLike(String value) {
            addCriterion("purchase_order_no not like", value, "purchaseOrderNo");
            return (Criteria) this;
        }

        public Criteria andPurchaseOrderNoIn(List<String> values) {
            addCriterion("purchase_order_no in", values, "purchaseOrderNo");
            return (Criteria) this;
        }

        public Criteria andPurchaseOrderNoNotIn(List<String> values) {
            addCriterion("purchase_order_no not in", values, "purchaseOrderNo");
            return (Criteria) this;
        }

        public Criteria andPurchaseOrderNoBetween(String value1, String value2) {
            addCriterion("purchase_order_no between", value1, value2, "purchaseOrderNo");
            return (Criteria) this;
        }

        public Criteria andPurchaseOrderNoNotBetween(String value1, String value2) {
            addCriterion("purchase_order_no not between", value1, value2, "purchaseOrderNo");
            return (Criteria) this;
        }

        public Criteria andOptionContractIsNull() {
            addCriterion("option_contract is null");
            return (Criteria) this;
        }

        public Criteria andOptionContractIsNotNull() {
            addCriterion("option_contract is not null");
            return (Criteria) this;
        }

        public Criteria andOptionContractEqualTo(String value) {
            addCriterion("option_contract =", value, "optionContract");
            return (Criteria) this;
        }

        public Criteria andOptionContractNotEqualTo(String value) {
            addCriterion("option_contract <>", value, "optionContract");
            return (Criteria) this;
        }

        public Criteria andOptionContractGreaterThan(String value) {
            addCriterion("option_contract >", value, "optionContract");
            return (Criteria) this;
        }

        public Criteria andOptionContractGreaterThanOrEqualTo(String value) {
            addCriterion("option_contract >=", value, "optionContract");
            return (Criteria) this;
        }

        public Criteria andOptionContractLessThan(String value) {
            addCriterion("option_contract <", value, "optionContract");
            return (Criteria) this;
        }

        public Criteria andOptionContractLessThanOrEqualTo(String value) {
            addCriterion("option_contract <=", value, "optionContract");
            return (Criteria) this;
        }

        public Criteria andOptionContractLike(String value) {
            addCriterion("option_contract like", value, "optionContract");
            return (Criteria) this;
        }

        public Criteria andOptionContractNotLike(String value) {
            addCriterion("option_contract not like", value, "optionContract");
            return (Criteria) this;
        }

        public Criteria andOptionContractIn(List<String> values) {
            addCriterion("option_contract in", values, "optionContract");
            return (Criteria) this;
        }

        public Criteria andOptionContractNotIn(List<String> values) {
            addCriterion("option_contract not in", values, "optionContract");
            return (Criteria) this;
        }

        public Criteria andOptionContractBetween(String value1, String value2) {
            addCriterion("option_contract between", value1, value2, "optionContract");
            return (Criteria) this;
        }

        public Criteria andOptionContractNotBetween(String value1, String value2) {
            addCriterion("option_contract not between", value1, value2, "optionContract");
            return (Criteria) this;
        }

        public Criteria andContractNoIsNull() {
            addCriterion("contract_no is null");
            return (Criteria) this;
        }

        public Criteria andContractNoIsNotNull() {
            addCriterion("contract_no is not null");
            return (Criteria) this;
        }

        public Criteria andContractNoEqualTo(String value) {
            addCriterion("contract_no =", value, "contractNo");
            return (Criteria) this;
        }

        public Criteria andContractNoNotEqualTo(String value) {
            addCriterion("contract_no <>", value, "contractNo");
            return (Criteria) this;
        }

        public Criteria andContractNoGreaterThan(String value) {
            addCriterion("contract_no >", value, "contractNo");
            return (Criteria) this;
        }

        public Criteria andContractNoGreaterThanOrEqualTo(String value) {
            addCriterion("contract_no >=", value, "contractNo");
            return (Criteria) this;
        }

        public Criteria andContractNoLessThan(String value) {
            addCriterion("contract_no <", value, "contractNo");
            return (Criteria) this;
        }

        public Criteria andContractNoLessThanOrEqualTo(String value) {
            addCriterion("contract_no <=", value, "contractNo");
            return (Criteria) this;
        }

        public Criteria andContractNoLike(String value) {
            addCriterion("contract_no like", value, "contractNo");
            return (Criteria) this;
        }

        public Criteria andContractNoNotLike(String value) {
            addCriterion("contract_no not like", value, "contractNo");
            return (Criteria) this;
        }

        public Criteria andContractNoIn(List<String> values) {
            addCriterion("contract_no in", values, "contractNo");
            return (Criteria) this;
        }

        public Criteria andContractNoNotIn(List<String> values) {
            addCriterion("contract_no not in", values, "contractNo");
            return (Criteria) this;
        }

        public Criteria andContractNoBetween(String value1, String value2) {
            addCriterion("contract_no between", value1, value2, "contractNo");
            return (Criteria) this;
        }

        public Criteria andContractNoNotBetween(String value1, String value2) {
            addCriterion("contract_no not between", value1, value2, "contractNo");
            return (Criteria) this;
        }

        public Criteria andOrderRemarkIsNull() {
            addCriterion("order_remark is null");
            return (Criteria) this;
        }

        public Criteria andOrderRemarkIsNotNull() {
            addCriterion("order_remark is not null");
            return (Criteria) this;
        }

        public Criteria andOrderRemarkEqualTo(String value) {
            addCriterion("order_remark =", value, "orderRemark");
            return (Criteria) this;
        }

        public Criteria andOrderRemarkNotEqualTo(String value) {
            addCriterion("order_remark <>", value, "orderRemark");
            return (Criteria) this;
        }

        public Criteria andOrderRemarkGreaterThan(String value) {
            addCriterion("order_remark >", value, "orderRemark");
            return (Criteria) this;
        }

        public Criteria andOrderRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("order_remark >=", value, "orderRemark");
            return (Criteria) this;
        }

        public Criteria andOrderRemarkLessThan(String value) {
            addCriterion("order_remark <", value, "orderRemark");
            return (Criteria) this;
        }

        public Criteria andOrderRemarkLessThanOrEqualTo(String value) {
            addCriterion("order_remark <=", value, "orderRemark");
            return (Criteria) this;
        }

        public Criteria andOrderRemarkLike(String value) {
            addCriterion("order_remark like", value, "orderRemark");
            return (Criteria) this;
        }

        public Criteria andOrderRemarkNotLike(String value) {
            addCriterion("order_remark not like", value, "orderRemark");
            return (Criteria) this;
        }

        public Criteria andOrderRemarkIn(List<String> values) {
            addCriterion("order_remark in", values, "orderRemark");
            return (Criteria) this;
        }

        public Criteria andOrderRemarkNotIn(List<String> values) {
            addCriterion("order_remark not in", values, "orderRemark");
            return (Criteria) this;
        }

        public Criteria andOrderRemarkBetween(String value1, String value2) {
            addCriterion("order_remark between", value1, value2, "orderRemark");
            return (Criteria) this;
        }

        public Criteria andOrderRemarkNotBetween(String value1, String value2) {
            addCriterion("order_remark not between", value1, value2, "orderRemark");
            return (Criteria) this;
        }

        public Criteria andDeliveryPriorityIsNull() {
            addCriterion("delivery_priority is null");
            return (Criteria) this;
        }

        public Criteria andDeliveryPriorityIsNotNull() {
            addCriterion("delivery_priority is not null");
            return (Criteria) this;
        }

        public Criteria andDeliveryPriorityEqualTo(Integer value) {
            addCriterion("delivery_priority =", value, "deliveryPriority");
            return (Criteria) this;
        }

        public Criteria andDeliveryPriorityNotEqualTo(Integer value) {
            addCriterion("delivery_priority <>", value, "deliveryPriority");
            return (Criteria) this;
        }

        public Criteria andDeliveryPriorityGreaterThan(Integer value) {
            addCriterion("delivery_priority >", value, "deliveryPriority");
            return (Criteria) this;
        }

        public Criteria andDeliveryPriorityGreaterThanOrEqualTo(Integer value) {
            addCriterion("delivery_priority >=", value, "deliveryPriority");
            return (Criteria) this;
        }

        public Criteria andDeliveryPriorityLessThan(Integer value) {
            addCriterion("delivery_priority <", value, "deliveryPriority");
            return (Criteria) this;
        }

        public Criteria andDeliveryPriorityLessThanOrEqualTo(Integer value) {
            addCriterion("delivery_priority <=", value, "deliveryPriority");
            return (Criteria) this;
        }

        public Criteria andDeliveryPriorityLike(Integer value) {
            addCriterion("delivery_priority like", value, "deliveryPriority");
            return (Criteria) this;
        }

        public Criteria andDeliveryPriorityNotLike(Integer value) {
            addCriterion("delivery_priority not like", value, "deliveryPriority");
            return (Criteria) this;
        }

        public Criteria andDeliveryPriorityIn(List<Integer> values) {
            addCriterion("delivery_priority in", values, "deliveryPriority");
            return (Criteria) this;
        }

        public Criteria andDeliveryPriorityNotIn(List<Integer> values) {
            addCriterion("delivery_priority not in", values, "deliveryPriority");
            return (Criteria) this;
        }

        public Criteria andDeliveryPriorityBetween(Integer value1, Integer value2) {
            addCriterion("delivery_priority between", value1, value2, "deliveryPriority");
            return (Criteria) this;
        }

        public Criteria andDeliveryPriorityNotBetween(Integer value1, Integer value2) {
            addCriterion("delivery_priority not between", value1, value2, "deliveryPriority");
            return (Criteria) this;
        }

        public Criteria andReturnOrderTypeIsNull() {
            addCriterion("return_order_type is null");
            return (Criteria) this;
        }

        public Criteria andReturnOrderTypeIsNotNull() {
            addCriterion("return_order_type is not null");
            return (Criteria) this;
        }

        public Criteria andReturnOrderTypeEqualTo(String value) {
            addCriterion("return_order_type =", value, "returnOrderType");
            return (Criteria) this;
        }

        public Criteria andReturnOrderTypeNotEqualTo(String value) {
            addCriterion("return_order_type <>", value, "returnOrderType");
            return (Criteria) this;
        }

        public Criteria andReturnOrderTypeGreaterThan(String value) {
            addCriterion("return_order_type >", value, "returnOrderType");
            return (Criteria) this;
        }

        public Criteria andReturnOrderTypeGreaterThanOrEqualTo(String value) {
            addCriterion("return_order_type >=", value, "returnOrderType");
            return (Criteria) this;
        }

        public Criteria andReturnOrderTypeLessThan(String value) {
            addCriterion("return_order_type <", value, "returnOrderType");
            return (Criteria) this;
        }

        public Criteria andReturnOrderTypeLessThanOrEqualTo(String value) {
            addCriterion("return_order_type <=", value, "returnOrderType");
            return (Criteria) this;
        }

        public Criteria andReturnOrderTypeLike(String value) {
            addCriterion("return_order_type like", value, "returnOrderType");
            return (Criteria) this;
        }

        public Criteria andReturnOrderTypeNotLike(String value) {
            addCriterion("return_order_type not like", value, "returnOrderType");
            return (Criteria) this;
        }

        public Criteria andReturnOrderTypeIn(List<String> values) {
            addCriterion("return_order_type in", values, "returnOrderType");
            return (Criteria) this;
        }

        public Criteria andReturnOrderTypeNotIn(List<String> values) {
            addCriterion("return_order_type not in", values, "returnOrderType");
            return (Criteria) this;
        }

        public Criteria andReturnOrderTypeBetween(String value1, String value2) {
            addCriterion("return_order_type between", value1, value2, "returnOrderType");
            return (Criteria) this;
        }

        public Criteria andReturnOrderTypeNotBetween(String value1, String value2) {
            addCriterion("return_order_type not between", value1, value2, "returnOrderType");
            return (Criteria) this;
        }

        public Criteria andTaxIsNull() {
            addCriterion("tax is null");
            return (Criteria) this;
        }

        public Criteria andTaxIsNotNull() {
            addCriterion("tax is not null");
            return (Criteria) this;
        }

        public Criteria andTaxEqualTo(BigDecimal value) {
            addCriterion("tax =", value, "tax");
            return (Criteria) this;
        }

        public Criteria andTaxNotEqualTo(BigDecimal value) {
            addCriterion("tax <>", value, "tax");
            return (Criteria) this;
        }

        public Criteria andTaxGreaterThan(BigDecimal value) {
            addCriterion("tax >", value, "tax");
            return (Criteria) this;
        }

        public Criteria andTaxGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("tax >=", value, "tax");
            return (Criteria) this;
        }

        public Criteria andTaxLessThan(BigDecimal value) {
            addCriterion("tax <", value, "tax");
            return (Criteria) this;
        }

        public Criteria andTaxLessThanOrEqualTo(BigDecimal value) {
            addCriterion("tax <=", value, "tax");
            return (Criteria) this;
        }

        public Criteria andTaxIn(List<BigDecimal> values) {
            addCriterion("tax in", values, "tax");
            return (Criteria) this;
        }

        public Criteria andTaxNotIn(List<BigDecimal> values) {
            addCriterion("tax not in", values, "tax");
            return (Criteria) this;
        }

        public Criteria andTaxBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("tax between", value1, value2, "tax");
            return (Criteria) this;
        }

        public Criteria andTaxNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("tax not between", value1, value2, "tax");
            return (Criteria) this;
        }

        public Criteria andAreaIsNull() {
            addCriterion("area is null");
            return (Criteria) this;
        }

        public Criteria andAreaIsNotNull() {
            addCriterion("area is not null");
            return (Criteria) this;
        }

        public Criteria andAreaEqualTo(String value) {
            addCriterion("area =", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotEqualTo(String value) {
            addCriterion("area <>", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaGreaterThan(String value) {
            addCriterion("area >", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaGreaterThanOrEqualTo(String value) {
            addCriterion("area >=", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLessThan(String value) {
            addCriterion("area <", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLessThanOrEqualTo(String value) {
            addCriterion("area <=", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLike(String value) {
            addCriterion("area like", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotLike(String value) {
            addCriterion("area not like", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaIn(List<String> values) {
            addCriterion("area in", values, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotIn(List<String> values) {
            addCriterion("area not in", values, "area");
            return (Criteria) this;
        }

        public Criteria andAreaBetween(String value1, String value2) {
            addCriterion("area between", value1, value2, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotBetween(String value1, String value2) {
            addCriterion("area not between", value1, value2, "area");
            return (Criteria) this;
        }

        public Criteria andPaytypeIsNull() {
            addCriterion("payType is null");
            return (Criteria) this;
        }

        public Criteria andPaytypeIsNotNull() {
            addCriterion("payType is not null");
            return (Criteria) this;
        }

        public Criteria andPaytypeEqualTo(String value) {
            addCriterion("payType =", value, "paytype");
            return (Criteria) this;
        }

        public Criteria andPaytypeNotEqualTo(String value) {
            addCriterion("payType <>", value, "paytype");
            return (Criteria) this;
        }

        public Criteria andPaytypeGreaterThan(String value) {
            addCriterion("payType >", value, "paytype");
            return (Criteria) this;
        }

        public Criteria andPaytypeGreaterThanOrEqualTo(String value) {
            addCriterion("payType >=", value, "paytype");
            return (Criteria) this;
        }

        public Criteria andPaytypeLessThan(String value) {
            addCriterion("payType <", value, "paytype");
            return (Criteria) this;
        }

        public Criteria andPaytypeLessThanOrEqualTo(String value) {
            addCriterion("payType <=", value, "paytype");
            return (Criteria) this;
        }

        public Criteria andPaytypeLike(String value) {
            addCriterion("payType like", value, "paytype");
            return (Criteria) this;
        }

        public Criteria andPaytypeNotLike(String value) {
            addCriterion("payType not like", value, "paytype");
            return (Criteria) this;
        }

        public Criteria andPaytypeIn(List<String> values) {
            addCriterion("payType in", values, "paytype");
            return (Criteria) this;
        }

        public Criteria andPaytypeNotIn(List<String> values) {
            addCriterion("payType not in", values, "paytype");
            return (Criteria) this;
        }

        public Criteria andPaytypeBetween(String value1, String value2) {
            addCriterion("payType between", value1, value2, "paytype");
            return (Criteria) this;
        }

        public Criteria andPaytypeNotBetween(String value1, String value2) {
            addCriterion("payType not between", value1, value2, "paytype");
            return (Criteria) this;
        }

        public Criteria andDeliveryTypeIsNull() {
            addCriterion("delivery_type is null");
            return (Criteria) this;
        }

        public Criteria andDeliveryTypeIsNotNull() {
            addCriterion("delivery_type is not null");
            return (Criteria) this;
        }

        public Criteria andDeliveryTypeEqualTo(Integer value) {
            addCriterion("delivery_type =", value, "deliveryType");
            return (Criteria) this;
        }

        public Criteria andDeliveryTypeNotEqualTo(Integer value) {
            addCriterion("delivery_type <>", value, "deliveryType");
            return (Criteria) this;
        }

        public Criteria andDeliveryTypeGreaterThan(Integer value) {
            addCriterion("delivery_type >", value, "deliveryType");
            return (Criteria) this;
        }

        public Criteria andDeliveryTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("delivery_type >=", value, "deliveryType");
            return (Criteria) this;
        }

        public Criteria andDeliveryTypeLessThan(Integer value) {
            addCriterion("delivery_type <", value, "deliveryType");
            return (Criteria) this;
        }

        public Criteria andDeliveryTypeLessThanOrEqualTo(Integer value) {
            addCriterion("delivery_type <=", value, "deliveryType");
            return (Criteria) this;
        }

        public Criteria andDeliveryTypeLike(Integer value) {
            addCriterion("delivery_type like", value, "deliveryType");
            return (Criteria) this;
        }

        public Criteria andDeliveryTypeNotLike(Integer value) {
            addCriterion("delivery_type not like", value, "deliveryType");
            return (Criteria) this;
        }

        public Criteria andDeliveryTypeIn(List<Integer> values) {
            addCriterion("delivery_type in", values, "deliveryType");
            return (Criteria) this;
        }

        public Criteria andDeliveryTypeNotIn(List<Integer> values) {
            addCriterion("delivery_type not in", values, "deliveryType");
            return (Criteria) this;
        }

        public Criteria andDeliveryTypeBetween(Integer value1, Integer value2) {
            addCriterion("delivery_type between", value1, value2, "deliveryType");
            return (Criteria) this;
        }

        public Criteria andDeliveryTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("delivery_type not between", value1, value2, "deliveryType");
            return (Criteria) this;
        }

        public Criteria andProductionNoIsNull() {
            addCriterion("production_no is null");
            return (Criteria) this;
        }

        public Criteria andProductionNoIsNotNull() {
            addCriterion("production_no is not null");
            return (Criteria) this;
        }

        public Criteria andProductionNoEqualTo(String value) {
            addCriterion("production_no =", value, "productionNo");
            return (Criteria) this;
        }

        public Criteria andProductionNoNotEqualTo(String value) {
            addCriterion("production_no <>", value, "productionNo");
            return (Criteria) this;
        }

        public Criteria andProductionNoGreaterThan(String value) {
            addCriterion("production_no >", value, "productionNo");
            return (Criteria) this;
        }

        public Criteria andProductionNoGreaterThanOrEqualTo(String value) {
            addCriterion("production_no >=", value, "productionNo");
            return (Criteria) this;
        }

        public Criteria andProductionNoLessThan(String value) {
            addCriterion("production_no <", value, "productionNo");
            return (Criteria) this;
        }

        public Criteria andProductionNoLessThanOrEqualTo(String value) {
            addCriterion("production_no <=", value, "productionNo");
            return (Criteria) this;
        }

        public Criteria andProductionNoLike(String value) {
            addCriterion("production_no like", value, "productionNo");
            return (Criteria) this;
        }

        public Criteria andProductionNoNotLike(String value) {
            addCriterion("production_no not like", value, "productionNo");
            return (Criteria) this;
        }

        public Criteria andProductionNoIn(List<String> values) {
            addCriterion("production_no in", values, "productionNo");
            return (Criteria) this;
        }

        public Criteria andProductionNoNotIn(List<String> values) {
            addCriterion("production_no not in", values, "productionNo");
            return (Criteria) this;
        }

        public Criteria andProductionNoBetween(String value1, String value2) {
            addCriterion("production_no between", value1, value2, "productionNo");
            return (Criteria) this;
        }

        public Criteria andProductionNoNotBetween(String value1, String value2) {
            addCriterion("production_no not between", value1, value2, "productionNo");
            return (Criteria) this;
        }

        public Criteria andNumsIsNull() {
            addCriterion("nums is null");
            return (Criteria) this;
        }

        public Criteria andNumsIsNotNull() {
            addCriterion("nums is not null");
            return (Criteria) this;
        }

        public Criteria andNumsEqualTo(Integer value) {
            addCriterion("nums =", value, "nums");
            return (Criteria) this;
        }

        public Criteria andNumsNotEqualTo(Integer value) {
            addCriterion("nums <>", value, "nums");
            return (Criteria) this;
        }

        public Criteria andNumsGreaterThan(Integer value) {
            addCriterion("nums >", value, "nums");
            return (Criteria) this;
        }

        public Criteria andNumsGreaterThanOrEqualTo(Integer value) {
            addCriterion("nums >=", value, "nums");
            return (Criteria) this;
        }

        public Criteria andNumsLessThan(Integer value) {
            addCriterion("nums <", value, "nums");
            return (Criteria) this;
        }

        public Criteria andNumsLessThanOrEqualTo(Integer value) {
            addCriterion("nums <=", value, "nums");
            return (Criteria) this;
        }

        public Criteria andNumsIn(List<Integer> values) {
            addCriterion("nums in", values, "nums");
            return (Criteria) this;
        }

        public Criteria andNumsNotIn(List<Integer> values) {
            addCriterion("nums not in", values, "nums");
            return (Criteria) this;
        }

        public Criteria andNumsBetween(Integer value1, Integer value2) {
            addCriterion("nums between", value1, value2, "nums");
            return (Criteria) this;
        }

        public Criteria andNumsNotBetween(Integer value1, Integer value2) {
            addCriterion("nums not between", value1, value2, "nums");
            return (Criteria) this;
        }

        public Criteria andAmountTotalIsNull() {
            addCriterion("amount_total is null");
            return (Criteria) this;
        }

        public Criteria andAmountTotalIsNotNull() {
            addCriterion("amount_total is not null");
            return (Criteria) this;
        }

        public Criteria andAmountTotalEqualTo(BigDecimal value) {
            addCriterion("amount_total =", value, "amountTotal");
            return (Criteria) this;
        }

        public Criteria andAmountTotalNotEqualTo(BigDecimal value) {
            addCriterion("amount_total <>", value, "amountTotal");
            return (Criteria) this;
        }

        public Criteria andAmountTotalGreaterThan(BigDecimal value) {
            addCriterion("amount_total >", value, "amountTotal");
            return (Criteria) this;
        }

        public Criteria andAmountTotalGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("amount_total >=", value, "amountTotal");
            return (Criteria) this;
        }

        public Criteria andAmountTotalLessThan(BigDecimal value) {
            addCriterion("amount_total <", value, "amountTotal");
            return (Criteria) this;
        }

        public Criteria andAmountTotalLessThanOrEqualTo(BigDecimal value) {
            addCriterion("amount_total <=", value, "amountTotal");
            return (Criteria) this;
        }

        public Criteria andAmountTotalIn(List<BigDecimal> values) {
            addCriterion("amount_total in", values, "amountTotal");
            return (Criteria) this;
        }

        public Criteria andAmountTotalNotIn(List<BigDecimal> values) {
            addCriterion("amount_total not in", values, "amountTotal");
            return (Criteria) this;
        }

        public Criteria andAmountTotalBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("amount_total between", value1, value2, "amountTotal");
            return (Criteria) this;
        }

        public Criteria andAmountTotalNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("amount_total not between", value1, value2, "amountTotal");
            return (Criteria) this;
        }

        public Criteria andAmountReduceIsNull() {
            addCriterion("amount_reduce is null");
            return (Criteria) this;
        }

        public Criteria andAmountReduceIsNotNull() {
            addCriterion("amount_reduce is not null");
            return (Criteria) this;
        }

        public Criteria andAmountReduceEqualTo(BigDecimal value) {
            addCriterion("amount_reduce =", value, "amountReduce");
            return (Criteria) this;
        }

        public Criteria andAmountReduceNotEqualTo(BigDecimal value) {
            addCriterion("amount_reduce <>", value, "amountReduce");
            return (Criteria) this;
        }

        public Criteria andAmountReduceGreaterThan(BigDecimal value) {
            addCriterion("amount_reduce >", value, "amountReduce");
            return (Criteria) this;
        }

        public Criteria andAmountReduceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("amount_reduce >=", value, "amountReduce");
            return (Criteria) this;
        }

        public Criteria andAmountReduceLessThan(BigDecimal value) {
            addCriterion("amount_reduce <", value, "amountReduce");
            return (Criteria) this;
        }

        public Criteria andAmountReduceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("amount_reduce <=", value, "amountReduce");
            return (Criteria) this;
        }

        public Criteria andAmountReduceIn(List<BigDecimal> values) {
            addCriterion("amount_reduce in", values, "amountReduce");
            return (Criteria) this;
        }

        public Criteria andAmountReduceNotIn(List<BigDecimal> values) {
            addCriterion("amount_reduce not in", values, "amountReduce");
            return (Criteria) this;
        }

        public Criteria andAmountReduceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("amount_reduce between", value1, value2, "amountReduce");
            return (Criteria) this;
        }

        public Criteria andAmountReduceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("amount_reduce not between", value1, value2, "amountReduce");
            return (Criteria) this;
        }

        public Criteria andAmountPayIsNull() {
            addCriterion("amount_pay is null");
            return (Criteria) this;
        }

        public Criteria andAmountPayIsNotNull() {
            addCriterion("amount_pay is not null");
            return (Criteria) this;
        }

        public Criteria andAmountPayEqualTo(BigDecimal value) {
            addCriterion("amount_pay =", value, "amountPay");
            return (Criteria) this;
        }

        public Criteria andAmountPayNotEqualTo(BigDecimal value) {
            addCriterion("amount_pay <>", value, "amountPay");
            return (Criteria) this;
        }

        public Criteria andAmountPayGreaterThan(BigDecimal value) {
            addCriterion("amount_pay >", value, "amountPay");
            return (Criteria) this;
        }

        public Criteria andAmountPayGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("amount_pay >=", value, "amountPay");
            return (Criteria) this;
        }

        public Criteria andAmountPayLessThan(BigDecimal value) {
            addCriterion("amount_pay <", value, "amountPay");
            return (Criteria) this;
        }

        public Criteria andAmountPayLessThanOrEqualTo(BigDecimal value) {
            addCriterion("amount_pay <=", value, "amountPay");
            return (Criteria) this;
        }

        public Criteria andAmountPayIn(List<BigDecimal> values) {
            addCriterion("amount_pay in", values, "amountPay");
            return (Criteria) this;
        }

        public Criteria andAmountPayNotIn(List<BigDecimal> values) {
            addCriterion("amount_pay not in", values, "amountPay");
            return (Criteria) this;
        }

        public Criteria andAmountPayBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("amount_pay between", value1, value2, "amountPay");
            return (Criteria) this;
        }

        public Criteria andAmountPayNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("amount_pay not between", value1, value2, "amountPay");
            return (Criteria) this;
        }

        public Criteria andPayTimeIsNull() {
            addCriterion("pay_time is null");
            return (Criteria) this;
        }

        public Criteria andPayTimeIsNotNull() {
            addCriterion("pay_time is not null");
            return (Criteria) this;
        }

        public Criteria andPayTimeEqualTo(Date value) {
            addCriterion("pay_time =", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeNotEqualTo(Date value) {
            addCriterion("pay_time <>", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeGreaterThan(Date value) {
            addCriterion("pay_time >", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("pay_time >=", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeLessThan(Date value) {
            addCriterion("pay_time <", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeLessThanOrEqualTo(Date value) {
            addCriterion("pay_time <=", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeIn(List<Date> values) {
            addCriterion("pay_time in", values, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeNotIn(List<Date> values) {
            addCriterion("pay_time not in", values, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeBetween(Date value1, Date value2) {
            addCriterion("pay_time between", value1, value2, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeNotBetween(Date value1, Date value2) {
            addCriterion("pay_time not between", value1, value2, "payTime");
            return (Criteria) this;
        }

        public Criteria andPresetReturnTimeIsNull() {
            addCriterion("preset_return_time is null");
            return (Criteria) this;
        }

        public Criteria andPresetReturnTimeIsNotNull() {
            addCriterion("preset_return_time is not null");
            return (Criteria) this;
        }

        public Criteria andPresetReturnTimeEqualTo(Date value) {
            addCriterion("preset_return_time =", value, "presetReturnTime");
            return (Criteria) this;
        }

        public Criteria andPresetReturnTimeNotEqualTo(Date value) {
            addCriterion("preset_return_time <>", value, "presetReturnTime");
            return (Criteria) this;
        }

        public Criteria andPresetReturnTimeGreaterThan(Date value) {
            addCriterion("preset_return_time >", value, "presetReturnTime");
            return (Criteria) this;
        }

        public Criteria andPresetReturnTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("preset_return_time >=", value, "presetReturnTime");
            return (Criteria) this;
        }

        public Criteria andPresetReturnTimeLessThan(Date value) {
            addCriterion("preset_return_time <", value, "presetReturnTime");
            return (Criteria) this;
        }

        public Criteria andPresetReturnTimeLessThanOrEqualTo(Date value) {
            addCriterion("preset_return_time <=", value, "presetReturnTime");
            return (Criteria) this;
        }

        public Criteria andPresetReturnTimeIn(List<Date> values) {
            addCriterion("preset_return_time in", values, "presetReturnTime");
            return (Criteria) this;
        }

        public Criteria andPresetReturnTimeNotIn(List<Date> values) {
            addCriterion("preset_return_time not in", values, "presetReturnTime");
            return (Criteria) this;
        }

        public Criteria andPresetReturnTimeBetween(Date value1, Date value2) {
            addCriterion("preset_return_time between", value1, value2, "presetReturnTime");
            return (Criteria) this;
        }

        public Criteria andPresetReturnTimeNotBetween(Date value1, Date value2) {
            addCriterion("preset_return_time not between", value1, value2, "presetReturnTime");
            return (Criteria) this;
        }

        public Criteria andReturnReasonIsNull() {
            addCriterion("return_reason is null");
            return (Criteria) this;
        }

        public Criteria andReturnReasonIsNotNull() {
            addCriterion("return_reason is not null");
            return (Criteria) this;
        }

        public Criteria andReturnReasonEqualTo(String value) {
            addCriterion("return_reason =", value, "returnReason");
            return (Criteria) this;
        }

        public Criteria andReturnReasonNotEqualTo(String value) {
            addCriterion("return_reason <>", value, "returnReason");
            return (Criteria) this;
        }

        public Criteria andReturnReasonGreaterThan(String value) {
            addCriterion("return_reason >", value, "returnReason");
            return (Criteria) this;
        }

        public Criteria andReturnReasonGreaterThanOrEqualTo(String value) {
            addCriterion("return_reason >=", value, "returnReason");
            return (Criteria) this;
        }

        public Criteria andReturnReasonLessThan(String value) {
            addCriterion("return_reason <", value, "returnReason");
            return (Criteria) this;
        }

        public Criteria andReturnReasonLessThanOrEqualTo(String value) {
            addCriterion("return_reason <=", value, "returnReason");
            return (Criteria) this;
        }

        public Criteria andReturnReasonLike(String value) {
            addCriterion("return_reason like", value, "returnReason");
            return (Criteria) this;
        }

        public Criteria andReturnReasonNotLike(String value) {
            addCriterion("return_reason not like", value, "returnReason");
            return (Criteria) this;
        }

        public Criteria andReturnReasonIn(List<String> values) {
            addCriterion("return_reason in", values, "returnReason");
            return (Criteria) this;
        }

        public Criteria andReturnReasonNotIn(List<String> values) {
            addCriterion("return_reason not in", values, "returnReason");
            return (Criteria) this;
        }

        public Criteria andReturnReasonBetween(String value1, String value2) {
            addCriterion("return_reason between", value1, value2, "returnReason");
            return (Criteria) this;
        }

        public Criteria andReturnReasonNotBetween(String value1, String value2) {
            addCriterion("return_reason not between", value1, value2, "returnReason");
            return (Criteria) this;
        }

        public Criteria andAuditTimeIsNull() {
            addCriterion("audit_time is null");
            return (Criteria) this;
        }

        public Criteria andAuditTimeIsNotNull() {
            addCriterion("audit_time is not null");
            return (Criteria) this;
        }

        public Criteria andAuditTimeEqualTo(Date value) {
            addCriterion("audit_time =", value, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditTimeNotEqualTo(Date value) {
            addCriterion("audit_time <>", value, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditTimeGreaterThan(Date value) {
            addCriterion("audit_time >", value, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("audit_time >=", value, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditTimeLessThan(Date value) {
            addCriterion("audit_time <", value, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditTimeLessThanOrEqualTo(Date value) {
            addCriterion("audit_time <=", value, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditTimeIn(List<Date> values) {
            addCriterion("audit_time in", values, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditTimeNotIn(List<Date> values) {
            addCriterion("audit_time not in", values, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditTimeBetween(Date value1, Date value2) {
            addCriterion("audit_time between", value1, value2, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditTimeNotBetween(Date value1, Date value2) {
            addCriterion("audit_time not between", value1, value2, "auditTime");
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

        public Criteria andExt11IsNull() {
            addCriterion("ext11 is null");
            return (Criteria) this;
        }

        public Criteria andExt11IsNotNull() {
            addCriterion("ext11 is not null");
            return (Criteria) this;
        }

        public Criteria andExt11EqualTo(String value) {
            addCriterion("ext11 =", value, "ext11");
            return (Criteria) this;
        }

        public Criteria andExt11NotEqualTo(String value) {
            addCriterion("ext11 <>", value, "ext11");
            return (Criteria) this;
        }

        public Criteria andExt11GreaterThan(String value) {
            addCriterion("ext11 >", value, "ext11");
            return (Criteria) this;
        }

        public Criteria andExt11GreaterThanOrEqualTo(String value) {
            addCriterion("ext11 >=", value, "ext11");
            return (Criteria) this;
        }

        public Criteria andExt11LessThan(String value) {
            addCriterion("ext11 <", value, "ext11");
            return (Criteria) this;
        }

        public Criteria andExt11LessThanOrEqualTo(String value) {
            addCriterion("ext11 <=", value, "ext11");
            return (Criteria) this;
        }

        public Criteria andExt11Like(String value) {
            addCriterion("ext11 like", value, "ext11");
            return (Criteria) this;
        }

        public Criteria andExt11NotLike(String value) {
            addCriterion("ext11 not like", value, "ext11");
            return (Criteria) this;
        }

        public Criteria andExt11In(List<String> values) {
            addCriterion("ext11 in", values, "ext11");
            return (Criteria) this;
        }

        public Criteria andExt11NotIn(List<String> values) {
            addCriterion("ext11 not in", values, "ext11");
            return (Criteria) this;
        }

        public Criteria andExt11Between(String value1, String value2) {
            addCriterion("ext11 between", value1, value2, "ext11");
            return (Criteria) this;
        }

        public Criteria andExt11NotBetween(String value1, String value2) {
            addCriterion("ext11 not between", value1, value2, "ext11");
            return (Criteria) this;
        }

        public Criteria andExt12IsNull() {
            addCriterion("ext12 is null");
            return (Criteria) this;
        }

        public Criteria andExt12IsNotNull() {
            addCriterion("ext12 is not null");
            return (Criteria) this;
        }

        public Criteria andExt12EqualTo(String value) {
            addCriterion("ext12 =", value, "ext12");
            return (Criteria) this;
        }

        public Criteria andExt12NotEqualTo(String value) {
            addCriterion("ext12 <>", value, "ext12");
            return (Criteria) this;
        }

        public Criteria andExt12GreaterThan(String value) {
            addCriterion("ext12 >", value, "ext12");
            return (Criteria) this;
        }

        public Criteria andExt12GreaterThanOrEqualTo(String value) {
            addCriterion("ext12 >=", value, "ext12");
            return (Criteria) this;
        }

        public Criteria andExt12LessThan(String value) {
            addCriterion("ext12 <", value, "ext12");
            return (Criteria) this;
        }

        public Criteria andExt12LessThanOrEqualTo(String value) {
            addCriterion("ext12 <=", value, "ext12");
            return (Criteria) this;
        }

        public Criteria andExt12Like(String value) {
            addCriterion("ext12 like", value, "ext12");
            return (Criteria) this;
        }

        public Criteria andExt12NotLike(String value) {
            addCriterion("ext12 not like", value, "ext12");
            return (Criteria) this;
        }

        public Criteria andExt12In(List<String> values) {
            addCriterion("ext12 in", values, "ext12");
            return (Criteria) this;
        }

        public Criteria andExt12NotIn(List<String> values) {
            addCriterion("ext12 not in", values, "ext12");
            return (Criteria) this;
        }

        public Criteria andExt12Between(String value1, String value2) {
            addCriterion("ext12 between", value1, value2, "ext12");
            return (Criteria) this;
        }

        public Criteria andExt12NotBetween(String value1, String value2) {
            addCriterion("ext12 not between", value1, value2, "ext12");
            return (Criteria) this;
        }

        public Criteria andExt13IsNull() {
            addCriterion("ext13 is null");
            return (Criteria) this;
        }

        public Criteria andExt13IsNotNull() {
            addCriterion("ext13 is not null");
            return (Criteria) this;
        }

        public Criteria andExt13EqualTo(String value) {
            addCriterion("ext13 =", value, "ext13");
            return (Criteria) this;
        }

        public Criteria andExt13NotEqualTo(String value) {
            addCriterion("ext13 <>", value, "ext13");
            return (Criteria) this;
        }

        public Criteria andExt13GreaterThan(String value) {
            addCriterion("ext13 >", value, "ext13");
            return (Criteria) this;
        }

        public Criteria andExt13GreaterThanOrEqualTo(String value) {
            addCriterion("ext13 >=", value, "ext13");
            return (Criteria) this;
        }

        public Criteria andExt13LessThan(String value) {
            addCriterion("ext13 <", value, "ext13");
            return (Criteria) this;
        }

        public Criteria andExt13LessThanOrEqualTo(String value) {
            addCriterion("ext13 <=", value, "ext13");
            return (Criteria) this;
        }

        public Criteria andExt13Like(String value) {
            addCriterion("ext13 like", value, "ext13");
            return (Criteria) this;
        }

        public Criteria andExt13NotLike(String value) {
            addCriterion("ext13 not like", value, "ext13");
            return (Criteria) this;
        }

        public Criteria andExt13In(List<String> values) {
            addCriterion("ext13 in", values, "ext13");
            return (Criteria) this;
        }

        public Criteria andExt13NotIn(List<String> values) {
            addCriterion("ext13 not in", values, "ext13");
            return (Criteria) this;
        }

        public Criteria andExt13Between(String value1, String value2) {
            addCriterion("ext13 between", value1, value2, "ext13");
            return (Criteria) this;
        }

        public Criteria andExt13NotBetween(String value1, String value2) {
            addCriterion("ext13 not between", value1, value2, "ext13");
            return (Criteria) this;
        }

        public Criteria andExt14IsNull() {
            addCriterion("ext14 is null");
            return (Criteria) this;
        }

        public Criteria andExt14IsNotNull() {
            addCriterion("ext14 is not null");
            return (Criteria) this;
        }

        public Criteria andExt14EqualTo(String value) {
            addCriterion("ext14 =", value, "ext14");
            return (Criteria) this;
        }

        public Criteria andExt14NotEqualTo(String value) {
            addCriterion("ext14 <>", value, "ext14");
            return (Criteria) this;
        }

        public Criteria andExt14GreaterThan(String value) {
            addCriterion("ext14 >", value, "ext14");
            return (Criteria) this;
        }

        public Criteria andExt14GreaterThanOrEqualTo(String value) {
            addCriterion("ext14 >=", value, "ext14");
            return (Criteria) this;
        }

        public Criteria andExt14LessThan(String value) {
            addCriterion("ext14 <", value, "ext14");
            return (Criteria) this;
        }

        public Criteria andExt14LessThanOrEqualTo(String value) {
            addCriterion("ext14 <=", value, "ext14");
            return (Criteria) this;
        }

        public Criteria andExt14Like(String value) {
            addCriterion("ext14 like", value, "ext14");
            return (Criteria) this;
        }

        public Criteria andExt14NotLike(String value) {
            addCriterion("ext14 not like", value, "ext14");
            return (Criteria) this;
        }

        public Criteria andExt14In(List<String> values) {
            addCriterion("ext14 in", values, "ext14");
            return (Criteria) this;
        }

        public Criteria andExt14NotIn(List<String> values) {
            addCriterion("ext14 not in", values, "ext14");
            return (Criteria) this;
        }

        public Criteria andExt14Between(String value1, String value2) {
            addCriterion("ext14 between", value1, value2, "ext14");
            return (Criteria) this;
        }

        public Criteria andExt14NotBetween(String value1, String value2) {
            addCriterion("ext14 not between", value1, value2, "ext14");
            return (Criteria) this;
        }

        public Criteria andExt15IsNull() {
            addCriterion("ext15 is null");
            return (Criteria) this;
        }

        public Criteria andExt15IsNotNull() {
            addCriterion("ext15 is not null");
            return (Criteria) this;
        }

        public Criteria andExt15EqualTo(String value) {
            addCriterion("ext15 =", value, "ext15");
            return (Criteria) this;
        }

        public Criteria andExt15NotEqualTo(String value) {
            addCriterion("ext15 <>", value, "ext15");
            return (Criteria) this;
        }

        public Criteria andExt15GreaterThan(String value) {
            addCriterion("ext15 >", value, "ext15");
            return (Criteria) this;
        }

        public Criteria andExt15GreaterThanOrEqualTo(String value) {
            addCriterion("ext15 >=", value, "ext15");
            return (Criteria) this;
        }

        public Criteria andExt15LessThan(String value) {
            addCriterion("ext15 <", value, "ext15");
            return (Criteria) this;
        }

        public Criteria andExt15LessThanOrEqualTo(String value) {
            addCriterion("ext15 <=", value, "ext15");
            return (Criteria) this;
        }

        public Criteria andExt15Like(String value) {
            addCriterion("ext15 like", value, "ext15");
            return (Criteria) this;
        }

        public Criteria andExt15NotLike(String value) {
            addCriterion("ext15 not like", value, "ext15");
            return (Criteria) this;
        }

        public Criteria andExt15In(List<String> values) {
            addCriterion("ext15 in", values, "ext15");
            return (Criteria) this;
        }

        public Criteria andExt15NotIn(List<String> values) {
            addCriterion("ext15 not in", values, "ext15");
            return (Criteria) this;
        }

        public Criteria andExt15Between(String value1, String value2) {
            addCriterion("ext15 between", value1, value2, "ext15");
            return (Criteria) this;
        }

        public Criteria andExt15NotBetween(String value1, String value2) {
            addCriterion("ext15 not between", value1, value2, "ext15");
            return (Criteria) this;
        }

        public Criteria andExt16IsNull() {
            addCriterion("ext16 is null");
            return (Criteria) this;
        }

        public Criteria andExt16IsNotNull() {
            addCriterion("ext16 is not null");
            return (Criteria) this;
        }

        public Criteria andExt16EqualTo(String value) {
            addCriterion("ext16 =", value, "ext16");
            return (Criteria) this;
        }

        public Criteria andExt16NotEqualTo(String value) {
            addCriterion("ext16 <>", value, "ext16");
            return (Criteria) this;
        }

        public Criteria andExt16GreaterThan(String value) {
            addCriterion("ext16 >", value, "ext16");
            return (Criteria) this;
        }

        public Criteria andExt16GreaterThanOrEqualTo(String value) {
            addCriterion("ext16 >=", value, "ext16");
            return (Criteria) this;
        }

        public Criteria andExt16LessThan(String value) {
            addCriterion("ext16 <", value, "ext16");
            return (Criteria) this;
        }

        public Criteria andExt16LessThanOrEqualTo(String value) {
            addCriterion("ext16 <=", value, "ext16");
            return (Criteria) this;
        }

        public Criteria andExt16Like(String value) {
            addCriterion("ext16 like", value, "ext16");
            return (Criteria) this;
        }

        public Criteria andExt16NotLike(String value) {
            addCriterion("ext16 not like", value, "ext16");
            return (Criteria) this;
        }

        public Criteria andExt16In(List<String> values) {
            addCriterion("ext16 in", values, "ext16");
            return (Criteria) this;
        }

        public Criteria andExt16NotIn(List<String> values) {
            addCriterion("ext16 not in", values, "ext16");
            return (Criteria) this;
        }

        public Criteria andExt16Between(String value1, String value2) {
            addCriterion("ext16 between", value1, value2, "ext16");
            return (Criteria) this;
        }

        public Criteria andExt16NotBetween(String value1, String value2) {
            addCriterion("ext16 not between", value1, value2, "ext16");
            return (Criteria) this;
        }

        public Criteria andExt17IsNull() {
            addCriterion("ext17 is null");
            return (Criteria) this;
        }

        public Criteria andExt17IsNotNull() {
            addCriterion("ext17 is not null");
            return (Criteria) this;
        }

        public Criteria andExt17EqualTo(String value) {
            addCriterion("ext17 =", value, "ext17");
            return (Criteria) this;
        }

        public Criteria andExt17NotEqualTo(String value) {
            addCriterion("ext17 <>", value, "ext17");
            return (Criteria) this;
        }

        public Criteria andExt17GreaterThan(String value) {
            addCriterion("ext17 >", value, "ext17");
            return (Criteria) this;
        }

        public Criteria andExt17GreaterThanOrEqualTo(String value) {
            addCriterion("ext17 >=", value, "ext17");
            return (Criteria) this;
        }

        public Criteria andExt17LessThan(String value) {
            addCriterion("ext17 <", value, "ext17");
            return (Criteria) this;
        }

        public Criteria andExt17LessThanOrEqualTo(String value) {
            addCriterion("ext17 <=", value, "ext17");
            return (Criteria) this;
        }

        public Criteria andExt17Like(String value) {
            addCriterion("ext17 like", value, "ext17");
            return (Criteria) this;
        }

        public Criteria andExt17NotLike(String value) {
            addCriterion("ext17 not like", value, "ext17");
            return (Criteria) this;
        }

        public Criteria andExt17In(List<String> values) {
            addCriterion("ext17 in", values, "ext17");
            return (Criteria) this;
        }

        public Criteria andExt17NotIn(List<String> values) {
            addCriterion("ext17 not in", values, "ext17");
            return (Criteria) this;
        }

        public Criteria andExt17Between(String value1, String value2) {
            addCriterion("ext17 between", value1, value2, "ext17");
            return (Criteria) this;
        }

        public Criteria andExt17NotBetween(String value1, String value2) {
            addCriterion("ext17 not between", value1, value2, "ext17");
            return (Criteria) this;
        }

        public Criteria andExt18IsNull() {
            addCriterion("ext18 is null");
            return (Criteria) this;
        }

        public Criteria andExt18IsNotNull() {
            addCriterion("ext18 is not null");
            return (Criteria) this;
        }

        public Criteria andExt18EqualTo(String value) {
            addCriterion("ext18 =", value, "ext18");
            return (Criteria) this;
        }

        public Criteria andExt18NotEqualTo(String value) {
            addCriterion("ext18 <>", value, "ext18");
            return (Criteria) this;
        }

        public Criteria andExt18GreaterThan(String value) {
            addCriterion("ext18 >", value, "ext18");
            return (Criteria) this;
        }

        public Criteria andExt18GreaterThanOrEqualTo(String value) {
            addCriterion("ext18 >=", value, "ext18");
            return (Criteria) this;
        }

        public Criteria andExt18LessThan(String value) {
            addCriterion("ext18 <", value, "ext18");
            return (Criteria) this;
        }

        public Criteria andExt18LessThanOrEqualTo(String value) {
            addCriterion("ext18 <=", value, "ext18");
            return (Criteria) this;
        }

        public Criteria andExt18Like(String value) {
            addCriterion("ext18 like", value, "ext18");
            return (Criteria) this;
        }

        public Criteria andExt18NotLike(String value) {
            addCriterion("ext18 not like", value, "ext18");
            return (Criteria) this;
        }

        public Criteria andExt18In(List<String> values) {
            addCriterion("ext18 in", values, "ext18");
            return (Criteria) this;
        }

        public Criteria andExt18NotIn(List<String> values) {
            addCriterion("ext18 not in", values, "ext18");
            return (Criteria) this;
        }

        public Criteria andExt18Between(String value1, String value2) {
            addCriterion("ext18 between", value1, value2, "ext18");
            return (Criteria) this;
        }

        public Criteria andExt18NotBetween(String value1, String value2) {
            addCriterion("ext18 not between", value1, value2, "ext18");
            return (Criteria) this;
        }

        public Criteria andExt19IsNull() {
            addCriterion("ext19 is null");
            return (Criteria) this;
        }

        public Criteria andExt19IsNotNull() {
            addCriterion("ext19 is not null");
            return (Criteria) this;
        }

        public Criteria andExt19EqualTo(String value) {
            addCriterion("ext19 =", value, "ext19");
            return (Criteria) this;
        }

        public Criteria andExt19NotEqualTo(String value) {
            addCriterion("ext19 <>", value, "ext19");
            return (Criteria) this;
        }

        public Criteria andExt19GreaterThan(String value) {
            addCriterion("ext19 >", value, "ext19");
            return (Criteria) this;
        }

        public Criteria andExt19GreaterThanOrEqualTo(String value) {
            addCriterion("ext19 >=", value, "ext19");
            return (Criteria) this;
        }

        public Criteria andExt19LessThan(String value) {
            addCriterion("ext19 <", value, "ext19");
            return (Criteria) this;
        }

        public Criteria andExt19LessThanOrEqualTo(String value) {
            addCriterion("ext19 <=", value, "ext19");
            return (Criteria) this;
        }

        public Criteria andExt19Like(String value) {
            addCriterion("ext19 like", value, "ext19");
            return (Criteria) this;
        }

        public Criteria andExt19NotLike(String value) {
            addCriterion("ext19 not like", value, "ext19");
            return (Criteria) this;
        }

        public Criteria andExt19In(List<String> values) {
            addCriterion("ext19 in", values, "ext19");
            return (Criteria) this;
        }

        public Criteria andExt19NotIn(List<String> values) {
            addCriterion("ext19 not in", values, "ext19");
            return (Criteria) this;
        }

        public Criteria andExt19Between(String value1, String value2) {
            addCriterion("ext19 between", value1, value2, "ext19");
            return (Criteria) this;
        }

        public Criteria andExt19NotBetween(String value1, String value2) {
            addCriterion("ext19 not between", value1, value2, "ext19");
            return (Criteria) this;
        }

        public Criteria andExt20IsNull() {
            addCriterion("ext20 is null");
            return (Criteria) this;
        }

        public Criteria andExt20IsNotNull() {
            addCriterion("ext20 is not null");
            return (Criteria) this;
        }

        public Criteria andExt20EqualTo(String value) {
            addCriterion("ext20 =", value, "ext20");
            return (Criteria) this;
        }

        public Criteria andExt20NotEqualTo(String value) {
            addCriterion("ext20 <>", value, "ext20");
            return (Criteria) this;
        }

        public Criteria andExt20GreaterThan(String value) {
            addCriterion("ext20 >", value, "ext20");
            return (Criteria) this;
        }

        public Criteria andExt20GreaterThanOrEqualTo(String value) {
            addCriterion("ext20 >=", value, "ext20");
            return (Criteria) this;
        }

        public Criteria andExt20LessThan(String value) {
            addCriterion("ext20 <", value, "ext20");
            return (Criteria) this;
        }

        public Criteria andExt20LessThanOrEqualTo(String value) {
            addCriterion("ext20 <=", value, "ext20");
            return (Criteria) this;
        }

        public Criteria andExt20Like(String value) {
            addCriterion("ext20 like", value, "ext20");
            return (Criteria) this;
        }

        public Criteria andExt20NotLike(String value) {
            addCriterion("ext20 not like", value, "ext20");
            return (Criteria) this;
        }

        public Criteria andExt20In(List<String> values) {
            addCriterion("ext20 in", values, "ext20");
            return (Criteria) this;
        }

        public Criteria andExt20NotIn(List<String> values) {
            addCriterion("ext20 not in", values, "ext20");
            return (Criteria) this;
        }

        public Criteria andExt20Between(String value1, String value2) {
            addCriterion("ext20 between", value1, value2, "ext20");
            return (Criteria) this;
        }

        public Criteria andExt20NotBetween(String value1, String value2) {
            addCriterion("ext20 not between", value1, value2, "ext20");
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