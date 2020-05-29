package com.els.runhe.order.entity;

import com.els.base.core.entity.AbstractExample;
import com.els.base.core.entity.PageView;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderExample extends AbstractExample<Order> implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected PageView<Order> pageView = new PageView<Order>(1, 10);

    private static final long serialVersionUID = 1L;

    public OrderExample() {
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
    public PageView<Order> getPageView() {
        return pageView;
    }

    @Override
    public void setPageView(PageView<Order> pageView) {
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

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andPurCompanyIdIsNull() {
            addCriterion("pur_company_id is null");
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
        
        public Criteria andNotPurCompanyId() {
            addCriterion("1 > 1");
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

        public Criteria andOrderUserIdIsNull() {
            addCriterion("order_user_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderUserIdIsNotNull() {
            addCriterion("order_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderUserIdEqualTo(String value) {
            addCriterion("order_user_id =", value, "orderUserId");
            return (Criteria) this;
        }

        public Criteria andOrderUserIdNotEqualTo(String value) {
            addCriterion("order_user_id <>", value, "orderUserId");
            return (Criteria) this;
        }

        public Criteria andOrderUserIdGreaterThan(String value) {
            addCriterion("order_user_id >", value, "orderUserId");
            return (Criteria) this;
        }

        public Criteria andOrderUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("order_user_id >=", value, "orderUserId");
            return (Criteria) this;
        }

        public Criteria andOrderUserIdLessThan(String value) {
            addCriterion("order_user_id <", value, "orderUserId");
            return (Criteria) this;
        }

        public Criteria andOrderUserIdLessThanOrEqualTo(String value) {
            addCriterion("order_user_id <=", value, "orderUserId");
            return (Criteria) this;
        }

        public Criteria andOrderUserIdLike(String value) {
            addCriterion("order_user_id like", value, "orderUserId");
            return (Criteria) this;
        }

        public Criteria andOrderUserIdNotLike(String value) {
            addCriterion("order_user_id not like", value, "orderUserId");
            return (Criteria) this;
        }

        public Criteria andOrderUserIdIn(List<String> values) {
            addCriterion("order_user_id in", values, "orderUserId");
            return (Criteria) this;
        }

        public Criteria andOrderUserIdNotIn(List<String> values) {
            addCriterion("order_user_id not in", values, "orderUserId");
            return (Criteria) this;
        }

        public Criteria andOrderUserIdBetween(String value1, String value2) {
            addCriterion("order_user_id between", value1, value2, "orderUserId");
            return (Criteria) this;
        }

        public Criteria andOrderUserIdNotBetween(String value1, String value2) {
            addCriterion("order_user_id not between", value1, value2, "orderUserId");
            return (Criteria) this;
        }

        public Criteria andOrderUserNameIsNull() {
            addCriterion("order_user_name is null");
            return (Criteria) this;
        }

        public Criteria andOrderUserNameIsNotNull() {
            addCriterion("order_user_name is not null");
            return (Criteria) this;
        }

        public Criteria andOrderUserNameEqualTo(String value) {
            addCriterion("order_user_name =", value, "orderUserName");
            return (Criteria) this;
        }

        public Criteria andOrderUserNameNotEqualTo(String value) {
            addCriterion("order_user_name <>", value, "orderUserName");
            return (Criteria) this;
        }

        public Criteria andOrderUserNameGreaterThan(String value) {
            addCriterion("order_user_name >", value, "orderUserName");
            return (Criteria) this;
        }

        public Criteria andOrderUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("order_user_name >=", value, "orderUserName");
            return (Criteria) this;
        }

        public Criteria andOrderUserNameLessThan(String value) {
            addCriterion("order_user_name <", value, "orderUserName");
            return (Criteria) this;
        }

        public Criteria andOrderUserNameLessThanOrEqualTo(String value) {
            addCriterion("order_user_name <=", value, "orderUserName");
            return (Criteria) this;
        }

        public Criteria andOrderUserNameLike(String value) {
            addCriterion("order_user_name like", value, "orderUserName");
            return (Criteria) this;
        }

        public Criteria andOrderUserNameNotLike(String value) {
            addCriterion("order_user_name not like", value, "orderUserName");
            return (Criteria) this;
        }

        public Criteria andOrderUserNameIn(List<String> values) {
            addCriterion("order_user_name in", values, "orderUserName");
            return (Criteria) this;
        }

        public Criteria andOrderUserNameNotIn(List<String> values) {
            addCriterion("order_user_name not in", values, "orderUserName");
            return (Criteria) this;
        }

        public Criteria andOrderUserNameBetween(String value1, String value2) {
            addCriterion("order_user_name between", value1, value2, "orderUserName");
            return (Criteria) this;
        }

        public Criteria andOrderUserNameNotBetween(String value1, String value2) {
            addCriterion("order_user_name not between", value1, value2, "orderUserName");
            return (Criteria) this;
        }

        public Criteria andOrderUserPhoneIsNull() {
            addCriterion("order_user_phone is null");
            return (Criteria) this;
        }

        public Criteria andOrderUserPhoneIsNotNull() {
            addCriterion("order_user_phone is not null");
            return (Criteria) this;
        }

        public Criteria andOrderUserPhoneEqualTo(String value) {
            addCriterion("order_user_phone =", value, "orderUserPhone");
            return (Criteria) this;
        }

        public Criteria andOrderUserPhoneNotEqualTo(String value) {
            addCriterion("order_user_phone <>", value, "orderUserPhone");
            return (Criteria) this;
        }

        public Criteria andOrderUserPhoneGreaterThan(String value) {
            addCriterion("order_user_phone >", value, "orderUserPhone");
            return (Criteria) this;
        }

        public Criteria andOrderUserPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("order_user_phone >=", value, "orderUserPhone");
            return (Criteria) this;
        }

        public Criteria andOrderUserPhoneLessThan(String value) {
            addCriterion("order_user_phone <", value, "orderUserPhone");
            return (Criteria) this;
        }

        public Criteria andOrderUserPhoneLessThanOrEqualTo(String value) {
            addCriterion("order_user_phone <=", value, "orderUserPhone");
            return (Criteria) this;
        }

        public Criteria andOrderUserPhoneLike(String value) {
            addCriterion("order_user_phone like", value, "orderUserPhone");
            return (Criteria) this;
        }

        public Criteria andOrderUserPhoneNotLike(String value) {
            addCriterion("order_user_phone not like", value, "orderUserPhone");
            return (Criteria) this;
        }

        public Criteria andOrderUserPhoneIn(List<String> values) {
            addCriterion("order_user_phone in", values, "orderUserPhone");
            return (Criteria) this;
        }

        public Criteria andOrderUserPhoneNotIn(List<String> values) {
            addCriterion("order_user_phone not in", values, "orderUserPhone");
            return (Criteria) this;
        }

        public Criteria andOrderUserPhoneBetween(String value1, String value2) {
            addCriterion("order_user_phone between", value1, value2, "orderUserPhone");
            return (Criteria) this;
        }

        public Criteria andOrderUserPhoneNotBetween(String value1, String value2) {
            addCriterion("order_user_phone not between", value1, value2, "orderUserPhone");
            return (Criteria) this;
        }

        public Criteria andOrderNoIsNull() {
            addCriterion("order_no is null");
            return (Criteria) this;
        }

        public Criteria andOrderNoIsNotNull() {
            addCriterion("order_no is not null");
            return (Criteria) this;
        }

        public Criteria andOrderNoEqualTo(String value) {
            addCriterion("order_no =", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotEqualTo(String value) {
            addCriterion("order_no <>", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoGreaterThan(String value) {
            addCriterion("order_no >", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoGreaterThanOrEqualTo(String value) {
            addCriterion("order_no >=", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLessThan(String value) {
            addCriterion("order_no <", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLessThanOrEqualTo(String value) {
            addCriterion("order_no <=", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLike(String value) {
            addCriterion("order_no like", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotLike(String value) {
            addCriterion("order_no not like", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoIn(List<String> values) {
            addCriterion("order_no in", values, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotIn(List<String> values) {
            addCriterion("order_no not in", values, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoBetween(String value1, String value2) {
            addCriterion("order_no between", value1, value2, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotBetween(String value1, String value2) {
            addCriterion("order_no not between", value1, value2, "orderNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoIsNull() {
            addCriterion("trade_no is null");
            return (Criteria) this;
        }

        public Criteria andTradeNoIsNotNull() {
            addCriterion("trade_no is not null");
            return (Criteria) this;
        }

        public Criteria andTradeNoEqualTo(String value) {
            addCriterion("trade_no =", value, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoNotEqualTo(String value) {
            addCriterion("trade_no <>", value, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoGreaterThan(String value) {
            addCriterion("trade_no >", value, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoGreaterThanOrEqualTo(String value) {
            addCriterion("trade_no >=", value, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoLessThan(String value) {
            addCriterion("trade_no <", value, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoLessThanOrEqualTo(String value) {
            addCriterion("trade_no <=", value, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoLike(String value) {
            addCriterion("trade_no like", value, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoNotLike(String value) {
            addCriterion("trade_no not like", value, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoIn(List<String> values) {
            addCriterion("trade_no in", values, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoNotIn(List<String> values) {
            addCriterion("trade_no not in", values, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoBetween(String value1, String value2) {
            addCriterion("trade_no between", value1, value2, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoNotBetween(String value1, String value2) {
            addCriterion("trade_no not between", value1, value2, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Integer value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Integer value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Integer value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Integer value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Integer value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Integer> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Integer> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Integer value1, Integer value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andSceneCodeIsNull() {
            addCriterion("scene_code is null");
            return (Criteria) this;
        }

        public Criteria andSceneCodeIsNotNull() {
            addCriterion("scene_code is not null");
            return (Criteria) this;
        }

        public Criteria andSceneCodeEqualTo(String value) {
            addCriterion("scene_code =", value, "sceneCode");
            return (Criteria) this;
        }

        public Criteria andSceneCodeNotEqualTo(String value) {
            addCriterion("scene_code <>", value, "sceneCode");
            return (Criteria) this;
        }

        public Criteria andSceneCodeGreaterThan(String value) {
            addCriterion("scene_code >", value, "sceneCode");
            return (Criteria) this;
        }

        public Criteria andSceneCodeGreaterThanOrEqualTo(String value) {
            addCriterion("scene_code >=", value, "sceneCode");
            return (Criteria) this;
        }

        public Criteria andSceneCodeLessThan(String value) {
            addCriterion("scene_code <", value, "sceneCode");
            return (Criteria) this;
        }

        public Criteria andSceneCodeLessThanOrEqualTo(String value) {
            addCriterion("scene_code <=", value, "sceneCode");
            return (Criteria) this;
        }

        public Criteria andSceneCodeLike(String value) {
            addCriterion("scene_code like", value, "sceneCode");
            return (Criteria) this;
        }

        public Criteria andSceneCodeNotLike(String value) {
            addCriterion("scene_code not like", value, "sceneCode");
            return (Criteria) this;
        }

        public Criteria andSceneCodeIn(List<String> values) {
            addCriterion("scene_code in", values, "sceneCode");
            return (Criteria) this;
        }

        public Criteria andSceneCodeNotIn(List<String> values) {
            addCriterion("scene_code not in", values, "sceneCode");
            return (Criteria) this;
        }

        public Criteria andSceneCodeBetween(String value1, String value2) {
            addCriterion("scene_code between", value1, value2, "sceneCode");
            return (Criteria) this;
        }

        public Criteria andSceneCodeNotBetween(String value1, String value2) {
            addCriterion("scene_code not between", value1, value2, "sceneCode");
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

        public Criteria andDeliveryStatusIsNull() {
            addCriterion("delivery_status is null");
            return (Criteria) this;
        }

        public Criteria andDeliveryStatusIsNotNull() {
            addCriterion("delivery_status is not null");
            return (Criteria) this;
        }

        public Criteria andDeliveryStatusEqualTo(Integer value) {
            addCriterion("delivery_status =", value, "deliveryStatus");
            return (Criteria) this;
        }

        public Criteria andDeliveryStatusNotEqualTo(Integer value) {
            addCriterion("delivery_status <>", value, "deliveryStatus");
            return (Criteria) this;
        }

        public Criteria andDeliveryStatusGreaterThan(Integer value) {
            addCriterion("delivery_status >", value, "deliveryStatus");
            return (Criteria) this;
        }

        public Criteria andDeliveryStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("delivery_status >=", value, "deliveryStatus");
            return (Criteria) this;
        }

        public Criteria andDeliveryStatusLessThan(Integer value) {
            addCriterion("delivery_status <", value, "deliveryStatus");
            return (Criteria) this;
        }

        public Criteria andDeliveryStatusLessThanOrEqualTo(Integer value) {
            addCriterion("delivery_status <=", value, "deliveryStatus");
            return (Criteria) this;
        }

        public Criteria andDeliveryStatusIn(List<Integer> values) {
            addCriterion("delivery_status in", values, "deliveryStatus");
            return (Criteria) this;
        }

        public Criteria andDeliveryStatusNotIn(List<Integer> values) {
            addCriterion("delivery_status not in", values, "deliveryStatus");
            return (Criteria) this;
        }

        public Criteria andDeliveryStatusBetween(Integer value1, Integer value2) {
            addCriterion("delivery_status between", value1, value2, "deliveryStatus");
            return (Criteria) this;
        }

        public Criteria andDeliveryStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("delivery_status not between", value1, value2, "deliveryStatus");
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

        public Criteria andApprovalTimeIsNull() {
            addCriterion("approval_time is null");
            return (Criteria) this;
        }

        public Criteria andApprovalTimeIsNotNull() {
            addCriterion("approval_time is not null");
            return (Criteria) this;
        }

        public Criteria andApprovalTimeEqualTo(Date value) {
            addCriterion("approval_time =", value, "approvalTime");
            return (Criteria) this;
        }

        public Criteria andApprovalTimeNotEqualTo(Date value) {
            addCriterion("approval_time <>", value, "approvalTime");
            return (Criteria) this;
        }

        public Criteria andApprovalTimeGreaterThan(Date value) {
            addCriterion("approval_time >", value, "approvalTime");
            return (Criteria) this;
        }

        public Criteria andApprovalTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("approval_time >=", value, "approvalTime");
            return (Criteria) this;
        }

        public Criteria andApprovalTimeLessThan(Date value) {
            addCriterion("approval_time <", value, "approvalTime");
            return (Criteria) this;
        }

        public Criteria andApprovalTimeLessThanOrEqualTo(Date value) {
            addCriterion("approval_time <=", value, "approvalTime");
            return (Criteria) this;
        }

        public Criteria andApprovalTimeIn(List<Date> values) {
            addCriterion("approval_time in", values, "approvalTime");
            return (Criteria) this;
        }

        public Criteria andApprovalTimeNotIn(List<Date> values) {
            addCriterion("approval_time not in", values, "approvalTime");
            return (Criteria) this;
        }

        public Criteria andApprovalTimeBetween(Date value1, Date value2) {
            addCriterion("approval_time between", value1, value2, "approvalTime");
            return (Criteria) this;
        }

        public Criteria andApprovalTimeNotBetween(Date value1, Date value2) {
            addCriterion("approval_time not between", value1, value2, "approvalTime");
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

        public Criteria andPayTypeIsNull() {
            addCriterion("pay_type is null");
            return (Criteria) this;
        }

        public Criteria andPayTypeIsNotNull() {
            addCriterion("pay_type is not null");
            return (Criteria) this;
        }

        public Criteria andPayTypeEqualTo(String value) {
            addCriterion("pay_type =", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotEqualTo(String value) {
            addCriterion("pay_type <>", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeGreaterThan(String value) {
            addCriterion("pay_type >", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeGreaterThanOrEqualTo(String value) {
            addCriterion("pay_type >=", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeLessThan(String value) {
            addCriterion("pay_type <", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeLessThanOrEqualTo(String value) {
            addCriterion("pay_type <=", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeLike(String value) {
            addCriterion("pay_type like", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotLike(String value) {
            addCriterion("pay_type not like", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeIn(List<String> values) {
            addCriterion("pay_type in", values, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotIn(List<String> values) {
            addCriterion("pay_type not in", values, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeBetween(String value1, String value2) {
            addCriterion("pay_type between", value1, value2, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotBetween(String value1, String value2) {
            addCriterion("pay_type not between", value1, value2, "payType");
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

        public Criteria andAmountPreferentialIsNull() {
            addCriterion("amount_preferential is null");
            return (Criteria) this;
        }

        public Criteria andAmountPreferentialIsNotNull() {
            addCriterion("amount_preferential is not null");
            return (Criteria) this;
        }

        public Criteria andAmountPreferentialEqualTo(BigDecimal value) {
            addCriterion("amount_preferential =", value, "amountPreferential");
            return (Criteria) this;
        }

        public Criteria andAmountPreferentialNotEqualTo(BigDecimal value) {
            addCriterion("amount_preferential <>", value, "amountPreferential");
            return (Criteria) this;
        }

        public Criteria andAmountPreferentialGreaterThan(BigDecimal value) {
            addCriterion("amount_preferential >", value, "amountPreferential");
            return (Criteria) this;
        }

        public Criteria andAmountPreferentialGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("amount_preferential >=", value, "amountPreferential");
            return (Criteria) this;
        }

        public Criteria andAmountPreferentialLessThan(BigDecimal value) {
            addCriterion("amount_preferential <", value, "amountPreferential");
            return (Criteria) this;
        }

        public Criteria andAmountPreferentialLessThanOrEqualTo(BigDecimal value) {
            addCriterion("amount_preferential <=", value, "amountPreferential");
            return (Criteria) this;
        }

        public Criteria andAmountPreferentialIn(List<BigDecimal> values) {
            addCriterion("amount_preferential in", values, "amountPreferential");
            return (Criteria) this;
        }

        public Criteria andAmountPreferentialNotIn(List<BigDecimal> values) {
            addCriterion("amount_preferential not in", values, "amountPreferential");
            return (Criteria) this;
        }

        public Criteria andAmountPreferentialBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("amount_preferential between", value1, value2, "amountPreferential");
            return (Criteria) this;
        }

        public Criteria andAmountPreferentialNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("amount_preferential not between", value1, value2, "amountPreferential");
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

        public Criteria andDeliveryNameIsNull() {
            addCriterion("delivery_name is null");
            return (Criteria) this;
        }

        public Criteria andDeliveryNameIsNotNull() {
            addCriterion("delivery_name is not null");
            return (Criteria) this;
        }

        public Criteria andDeliveryNameEqualTo(String value) {
            addCriterion("delivery_name =", value, "deliveryName");
            return (Criteria) this;
        }

        public Criteria andDeliveryNameNotEqualTo(String value) {
            addCriterion("delivery_name <>", value, "deliveryName");
            return (Criteria) this;
        }

        public Criteria andDeliveryNameGreaterThan(String value) {
            addCriterion("delivery_name >", value, "deliveryName");
            return (Criteria) this;
        }

        public Criteria andDeliveryNameGreaterThanOrEqualTo(String value) {
            addCriterion("delivery_name >=", value, "deliveryName");
            return (Criteria) this;
        }

        public Criteria andDeliveryNameLessThan(String value) {
            addCriterion("delivery_name <", value, "deliveryName");
            return (Criteria) this;
        }

        public Criteria andDeliveryNameLessThanOrEqualTo(String value) {
            addCriterion("delivery_name <=", value, "deliveryName");
            return (Criteria) this;
        }

        public Criteria andDeliveryNameLike(String value) {
            addCriterion("delivery_name like", value, "deliveryName");
            return (Criteria) this;
        }

        public Criteria andDeliveryNameNotLike(String value) {
            addCriterion("delivery_name not like", value, "deliveryName");
            return (Criteria) this;
        }

        public Criteria andDeliveryNameIn(List<String> values) {
            addCriterion("delivery_name in", values, "deliveryName");
            return (Criteria) this;
        }

        public Criteria andDeliveryNameNotIn(List<String> values) {
            addCriterion("delivery_name not in", values, "deliveryName");
            return (Criteria) this;
        }

        public Criteria andDeliveryNameBetween(String value1, String value2) {
            addCriterion("delivery_name between", value1, value2, "deliveryName");
            return (Criteria) this;
        }

        public Criteria andDeliveryNameNotBetween(String value1, String value2) {
            addCriterion("delivery_name not between", value1, value2, "deliveryName");
            return (Criteria) this;
        }

        public Criteria andDeliveryCodeIsNull() {
            addCriterion("delivery_code is null");
            return (Criteria) this;
        }

        public Criteria andDeliveryCodeIsNotNull() {
            addCriterion("delivery_code is not null");
            return (Criteria) this;
        }

        public Criteria andDeliveryCodeEqualTo(String value) {
            addCriterion("delivery_code =", value, "deliveryCode");
            return (Criteria) this;
        }

        public Criteria andDeliveryCodeNotEqualTo(String value) {
            addCriterion("delivery_code <>", value, "deliveryCode");
            return (Criteria) this;
        }

        public Criteria andDeliveryCodeGreaterThan(String value) {
            addCriterion("delivery_code >", value, "deliveryCode");
            return (Criteria) this;
        }

        public Criteria andDeliveryCodeGreaterThanOrEqualTo(String value) {
            addCriterion("delivery_code >=", value, "deliveryCode");
            return (Criteria) this;
        }

        public Criteria andDeliveryCodeLessThan(String value) {
            addCriterion("delivery_code <", value, "deliveryCode");
            return (Criteria) this;
        }

        public Criteria andDeliveryCodeLessThanOrEqualTo(String value) {
            addCriterion("delivery_code <=", value, "deliveryCode");
            return (Criteria) this;
        }

        public Criteria andDeliveryCodeLike(String value) {
            addCriterion("delivery_code like", value, "deliveryCode");
            return (Criteria) this;
        }

        public Criteria andDeliveryCodeNotLike(String value) {
            addCriterion("delivery_code not like", value, "deliveryCode");
            return (Criteria) this;
        }

        public Criteria andDeliveryCodeIn(List<String> values) {
            addCriterion("delivery_code in", values, "deliveryCode");
            return (Criteria) this;
        }

        public Criteria andDeliveryCodeNotIn(List<String> values) {
            addCriterion("delivery_code not in", values, "deliveryCode");
            return (Criteria) this;
        }

        public Criteria andDeliveryCodeBetween(String value1, String value2) {
            addCriterion("delivery_code between", value1, value2, "deliveryCode");
            return (Criteria) this;
        }

        public Criteria andDeliveryCodeNotBetween(String value1, String value2) {
            addCriterion("delivery_code not between", value1, value2, "deliveryCode");
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

        public Criteria andFreightIsNull() {
            addCriterion("freight is null");
            return (Criteria) this;
        }

        public Criteria andFreightIsNotNull() {
            addCriterion("freight is not null");
            return (Criteria) this;
        }

        public Criteria andFreightEqualTo(Integer value) {
            addCriterion("freight =", value, "freight");
            return (Criteria) this;
        }

        public Criteria andFreightNotEqualTo(Integer value) {
            addCriterion("freight <>", value, "freight");
            return (Criteria) this;
        }

        public Criteria andFreightGreaterThan(Integer value) {
            addCriterion("freight >", value, "freight");
            return (Criteria) this;
        }

        public Criteria andFreightGreaterThanOrEqualTo(Integer value) {
            addCriterion("freight >=", value, "freight");
            return (Criteria) this;
        }

        public Criteria andFreightLessThan(Integer value) {
            addCriterion("freight <", value, "freight");
            return (Criteria) this;
        }

        public Criteria andFreightLessThanOrEqualTo(Integer value) {
            addCriterion("freight <=", value, "freight");
            return (Criteria) this;
        }

        public Criteria andFreightIn(List<Integer> values) {
            addCriterion("freight in", values, "freight");
            return (Criteria) this;
        }

        public Criteria andFreightNotIn(List<Integer> values) {
            addCriterion("freight not in", values, "freight");
            return (Criteria) this;
        }

        public Criteria andFreightBetween(Integer value1, Integer value2) {
            addCriterion("freight between", value1, value2, "freight");
            return (Criteria) this;
        }

        public Criteria andFreightNotBetween(Integer value1, Integer value2) {
            addCriterion("freight not between", value1, value2, "freight");
            return (Criteria) this;
        }

        public Criteria andAddressIdIsNull() {
            addCriterion("address_id is null");
            return (Criteria) this;
        }

        public Criteria andAddressIdIsNotNull() {
            addCriterion("address_id is not null");
            return (Criteria) this;
        }

        public Criteria andAddressIdEqualTo(Integer value) {
            addCriterion("address_id =", value, "addressId");
            return (Criteria) this;
        }

        public Criteria andAddressIdNotEqualTo(Integer value) {
            addCriterion("address_id <>", value, "addressId");
            return (Criteria) this;
        }

        public Criteria andAddressIdGreaterThan(Integer value) {
            addCriterion("address_id >", value, "addressId");
            return (Criteria) this;
        }

        public Criteria andAddressIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("address_id >=", value, "addressId");
            return (Criteria) this;
        }

        public Criteria andAddressIdLessThan(Integer value) {
            addCriterion("address_id <", value, "addressId");
            return (Criteria) this;
        }

        public Criteria andAddressIdLessThanOrEqualTo(Integer value) {
            addCriterion("address_id <=", value, "addressId");
            return (Criteria) this;
        }

        public Criteria andAddressIdIn(List<Integer> values) {
            addCriterion("address_id in", values, "addressId");
            return (Criteria) this;
        }

        public Criteria andAddressIdNotIn(List<Integer> values) {
            addCriterion("address_id not in", values, "addressId");
            return (Criteria) this;
        }

        public Criteria andAddressIdBetween(Integer value1, Integer value2) {
            addCriterion("address_id between", value1, value2, "addressId");
            return (Criteria) this;
        }

        public Criteria andAddressIdNotBetween(Integer value1, Integer value2) {
            addCriterion("address_id not between", value1, value2, "addressId");
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

        public Criteria andAddressRegsonIsNull() {
            addCriterion("address_regson is null");
            return (Criteria) this;
        }

        public Criteria andAddressRegsonIsNotNull() {
            addCriterion("address_regson is not null");
            return (Criteria) this;
        }

        public Criteria andAddressRegsonEqualTo(String value) {
            addCriterion("address_regson =", value, "addressRegson");
            return (Criteria) this;
        }

        public Criteria andAddressRegsonNotEqualTo(String value) {
            addCriterion("address_regson <>", value, "addressRegson");
            return (Criteria) this;
        }

        public Criteria andAddressRegsonGreaterThan(String value) {
            addCriterion("address_regson >", value, "addressRegson");
            return (Criteria) this;
        }

        public Criteria andAddressRegsonGreaterThanOrEqualTo(String value) {
            addCriterion("address_regson >=", value, "addressRegson");
            return (Criteria) this;
        }

        public Criteria andAddressRegsonLessThan(String value) {
            addCriterion("address_regson <", value, "addressRegson");
            return (Criteria) this;
        }

        public Criteria andAddressRegsonLessThanOrEqualTo(String value) {
            addCriterion("address_regson <=", value, "addressRegson");
            return (Criteria) this;
        }

        public Criteria andAddressRegsonLike(String value) {
            addCriterion("address_regson like", value, "addressRegson");
            return (Criteria) this;
        }

        public Criteria andAddressRegsonNotLike(String value) {
            addCriterion("address_regson not like", value, "addressRegson");
            return (Criteria) this;
        }

        public Criteria andAddressRegsonIn(List<String> values) {
            addCriterion("address_regson in", values, "addressRegson");
            return (Criteria) this;
        }

        public Criteria andAddressRegsonNotIn(List<String> values) {
            addCriterion("address_regson not in", values, "addressRegson");
            return (Criteria) this;
        }

        public Criteria andAddressRegsonBetween(String value1, String value2) {
            addCriterion("address_regson between", value1, value2, "addressRegson");
            return (Criteria) this;
        }

        public Criteria andAddressRegsonNotBetween(String value1, String value2) {
            addCriterion("address_regson not between", value1, value2, "addressRegson");
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

        public Criteria andPresetReceiverTimeIsNull() {
            addCriterion("preset_receiver_time is null");
            return (Criteria) this;
        }

        public Criteria andPresetReceiverTimeIsNotNull() {
            addCriterion("preset_receiver_time is not null");
            return (Criteria) this;
        }

        public Criteria andPresetReceiverTimeEqualTo(Date value) {
            addCriterion("preset_receiver_time =", value, "presetReceiverTime");
            return (Criteria) this;
        }

        public Criteria andPresetReceiverTimeNotEqualTo(Date value) {
            addCriterion("preset_receiver_time <>", value, "presetReceiverTime");
            return (Criteria) this;
        }

        public Criteria andPresetReceiverTimeGreaterThan(Date value) {
            addCriterion("preset_receiver_time >", value, "presetReceiverTime");
            return (Criteria) this;
        }

        public Criteria andPresetReceiverTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("preset_receiver_time >=", value, "presetReceiverTime");
            return (Criteria) this;
        }

        public Criteria andPresetReceiverTimeLessThan(Date value) {
            addCriterion("preset_receiver_time <", value, "presetReceiverTime");
            return (Criteria) this;
        }

        public Criteria andPresetReceiverTimeLessThanOrEqualTo(Date value) {
            addCriterion("preset_receiver_time <=", value, "presetReceiverTime");
            return (Criteria) this;
        }

        public Criteria andPresetReceiverTimeIn(List<Date> values) {
            addCriterion("preset_receiver_time in", values, "presetReceiverTime");
            return (Criteria) this;
        }

        public Criteria andPresetReceiverTimeNotIn(List<Date> values) {
            addCriterion("preset_receiver_time not in", values, "presetReceiverTime");
            return (Criteria) this;
        }

        public Criteria andPresetReceiverTimeBetween(Date value1, Date value2) {
            addCriterion("preset_receiver_time between", value1, value2, "presetReceiverTime");
            return (Criteria) this;
        }

        public Criteria andPresetReceiverTimeNotBetween(Date value1, Date value2) {
            addCriterion("preset_receiver_time not between", value1, value2, "presetReceiverTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeIsNull() {
            addCriterion("delivery_time is null");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeIsNotNull() {
            addCriterion("delivery_time is not null");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeEqualTo(Date value) {
            addCriterion("delivery_time =", value, "deliveryTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeNotEqualTo(Date value) {
            addCriterion("delivery_time <>", value, "deliveryTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeGreaterThan(Date value) {
            addCriterion("delivery_time >", value, "deliveryTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("delivery_time >=", value, "deliveryTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeLessThan(Date value) {
            addCriterion("delivery_time <", value, "deliveryTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeLessThanOrEqualTo(Date value) {
            addCriterion("delivery_time <=", value, "deliveryTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeIn(List<Date> values) {
            addCriterion("delivery_time in", values, "deliveryTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeNotIn(List<Date> values) {
            addCriterion("delivery_time not in", values, "deliveryTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeBetween(Date value1, Date value2) {
            addCriterion("delivery_time between", value1, value2, "deliveryTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeNotBetween(Date value1, Date value2) {
            addCriterion("delivery_time not between", value1, value2, "deliveryTime");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeIsNull() {
            addCriterion("receive_time is null");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeIsNotNull() {
            addCriterion("receive_time is not null");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeEqualTo(Date value) {
            addCriterion("receive_time =", value, "receiveTime");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeNotEqualTo(Date value) {
            addCriterion("receive_time <>", value, "receiveTime");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeGreaterThan(Date value) {
            addCriterion("receive_time >", value, "receiveTime");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("receive_time >=", value, "receiveTime");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeLessThan(Date value) {
            addCriterion("receive_time <", value, "receiveTime");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeLessThanOrEqualTo(Date value) {
            addCriterion("receive_time <=", value, "receiveTime");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeIn(List<Date> values) {
            addCriterion("receive_time in", values, "receiveTime");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeNotIn(List<Date> values) {
            addCriterion("receive_time not in", values, "receiveTime");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeBetween(Date value1, Date value2) {
            addCriterion("receive_time between", value1, value2, "receiveTime");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeNotBetween(Date value1, Date value2) {
            addCriterion("receive_time not between", value1, value2, "receiveTime");
            return (Criteria) this;
        }

        public Criteria andReturnStatusIsNull() {
            addCriterion("return_status is null");
            return (Criteria) this;
        }

        public Criteria andReturnStatusIsNotNull() {
            addCriterion("return_status is not null");
            return (Criteria) this;
        }

        public Criteria andReturnStatusEqualTo(Integer value) {
            addCriterion("return_status =", value, "returnStatus");
            return (Criteria) this;
        }

        public Criteria andReturnStatusNotEqualTo(Integer value) {
            addCriterion("return_status <>", value, "returnStatus");
            return (Criteria) this;
        }

        public Criteria andReturnStatusGreaterThan(Integer value) {
            addCriterion("return_status >", value, "returnStatus");
            return (Criteria) this;
        }

        public Criteria andReturnStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("return_status >=", value, "returnStatus");
            return (Criteria) this;
        }

        public Criteria andReturnStatusLessThan(Integer value) {
            addCriterion("return_status <", value, "returnStatus");
            return (Criteria) this;
        }

        public Criteria andReturnStatusLessThanOrEqualTo(Integer value) {
            addCriterion("return_status <=", value, "returnStatus");
            return (Criteria) this;
        }

        public Criteria andReturnStatusIn(List<Integer> values) {
            addCriterion("return_status in", values, "returnStatus");
            return (Criteria) this;
        }

        public Criteria andReturnStatusNotIn(List<Integer> values) {
            addCriterion("return_status not in", values, "returnStatus");
            return (Criteria) this;
        }

        public Criteria andReturnStatusBetween(Integer value1, Integer value2) {
            addCriterion("return_status between", value1, value2, "returnStatus");
            return (Criteria) this;
        }

        public Criteria andReturnStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("return_status not between", value1, value2, "returnStatus");
            return (Criteria) this;
        }

        public Criteria andReturnTimeIsNull() {
            addCriterion("return_time is null");
            return (Criteria) this;
        }

        public Criteria andReturnTimeIsNotNull() {
            addCriterion("return_time is not null");
            return (Criteria) this;
        }

        public Criteria andReturnTimeEqualTo(Date value) {
            addCriterion("return_time =", value, "returnTime");
            return (Criteria) this;
        }

        public Criteria andReturnTimeNotEqualTo(Date value) {
            addCriterion("return_time <>", value, "returnTime");
            return (Criteria) this;
        }

        public Criteria andReturnTimeGreaterThan(Date value) {
            addCriterion("return_time >", value, "returnTime");
            return (Criteria) this;
        }

        public Criteria andReturnTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("return_time >=", value, "returnTime");
            return (Criteria) this;
        }

        public Criteria andReturnTimeLessThan(Date value) {
            addCriterion("return_time <", value, "returnTime");
            return (Criteria) this;
        }

        public Criteria andReturnTimeLessThanOrEqualTo(Date value) {
            addCriterion("return_time <=", value, "returnTime");
            return (Criteria) this;
        }

        public Criteria andReturnTimeIn(List<Date> values) {
            addCriterion("return_time in", values, "returnTime");
            return (Criteria) this;
        }

        public Criteria andReturnTimeNotIn(List<Date> values) {
            addCriterion("return_time not in", values, "returnTime");
            return (Criteria) this;
        }

        public Criteria andReturnTimeBetween(Date value1, Date value2) {
            addCriterion("return_time between", value1, value2, "returnTime");
            return (Criteria) this;
        }

        public Criteria andReturnTimeNotBetween(Date value1, Date value2) {
            addCriterion("return_time not between", value1, value2, "returnTime");
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

        public Criteria andApplySaleSupportIsNull() {
            addCriterion("apply_sale_support is null");
            return (Criteria) this;
        }

        public Criteria andApplySaleSupportIsNotNull() {
            addCriterion("apply_sale_support is not null");
            return (Criteria) this;
        }

        public Criteria andApplySaleSupportEqualTo(BigDecimal value) {
            addCriterion("apply_sale_support =", value, "applySaleSupport");
            return (Criteria) this;
        }

        public Criteria andApplySaleSupportNotEqualTo(BigDecimal value) {
            addCriterion("apply_sale_support <>", value, "applySaleSupport");
            return (Criteria) this;
        }

        public Criteria andApplySaleSupportGreaterThan(BigDecimal value) {
            addCriterion("apply_sale_support >", value, "applySaleSupport");
            return (Criteria) this;
        }

        public Criteria andApplySaleSupportGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("apply_sale_support >=", value, "applySaleSupport");
            return (Criteria) this;
        }

        public Criteria andApplySaleSupportLessThan(BigDecimal value) {
            addCriterion("apply_sale_support <", value, "applySaleSupport");
            return (Criteria) this;
        }

        public Criteria andApplySaleSupportLessThanOrEqualTo(BigDecimal value) {
            addCriterion("apply_sale_support <=", value, "applySaleSupport");
            return (Criteria) this;
        }

        public Criteria andApplySaleSupportIn(List<BigDecimal> values) {
            addCriterion("apply_sale_support in", values, "applySaleSupport");
            return (Criteria) this;
        }

        public Criteria andApplySaleSupportNotIn(List<BigDecimal> values) {
            addCriterion("apply_sale_support not in", values, "applySaleSupport");
            return (Criteria) this;
        }

        public Criteria andApplySaleSupportBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("apply_sale_support between", value1, value2, "applySaleSupport");
            return (Criteria) this;
        }

        public Criteria andApplySaleSupportNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("apply_sale_support not between", value1, value2, "applySaleSupport");
            return (Criteria) this;
        }

        public Criteria andApplyMarketSupportIsNull() {
            addCriterion("apply_market_support is null");
            return (Criteria) this;
        }

        public Criteria andApplyMarketSupportIsNotNull() {
            addCriterion("apply_market_support is not null");
            return (Criteria) this;
        }

        public Criteria andApplyMarketSupportEqualTo(BigDecimal value) {
            addCriterion("apply_market_support =", value, "applyMarketSupport");
            return (Criteria) this;
        }

        public Criteria andApplyMarketSupportNotEqualTo(BigDecimal value) {
            addCriterion("apply_market_support <>", value, "applyMarketSupport");
            return (Criteria) this;
        }

        public Criteria andApplyMarketSupportGreaterThan(BigDecimal value) {
            addCriterion("apply_market_support >", value, "applyMarketSupport");
            return (Criteria) this;
        }

        public Criteria andApplyMarketSupportGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("apply_market_support >=", value, "applyMarketSupport");
            return (Criteria) this;
        }

        public Criteria andApplyMarketSupportLessThan(BigDecimal value) {
            addCriterion("apply_market_support <", value, "applyMarketSupport");
            return (Criteria) this;
        }

        public Criteria andApplyMarketSupportLessThanOrEqualTo(BigDecimal value) {
            addCriterion("apply_market_support <=", value, "applyMarketSupport");
            return (Criteria) this;
        }

        public Criteria andApplyMarketSupportIn(List<BigDecimal> values) {
            addCriterion("apply_market_support in", values, "applyMarketSupport");
            return (Criteria) this;
        }

        public Criteria andApplyMarketSupportNotIn(List<BigDecimal> values) {
            addCriterion("apply_market_support not in", values, "applyMarketSupport");
            return (Criteria) this;
        }

        public Criteria andApplyMarketSupportBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("apply_market_support between", value1, value2, "applyMarketSupport");
            return (Criteria) this;
        }

        public Criteria andApplyMarketSupportNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("apply_market_support not between", value1, value2, "applyMarketSupport");
            return (Criteria) this;
        }

        public Criteria andAmountTaxIsNull() {
            addCriterion("amount_tax is null");
            return (Criteria) this;
        }

        public Criteria andAmountTaxIsNotNull() {
            addCriterion("amount_tax is not null");
            return (Criteria) this;
        }

        public Criteria andAmountTaxEqualTo(Integer value) {
            addCriterion("amount_tax =", value, "amountTax");
            return (Criteria) this;
        }

        public Criteria andAmountTaxNotEqualTo(Integer value) {
            addCriterion("amount_tax <>", value, "amountTax");
            return (Criteria) this;
        }

        public Criteria andAmountTaxGreaterThan(Integer value) {
            addCriterion("amount_tax >", value, "amountTax");
            return (Criteria) this;
        }

        public Criteria andAmountTaxGreaterThanOrEqualTo(Integer value) {
            addCriterion("amount_tax >=", value, "amountTax");
            return (Criteria) this;
        }

        public Criteria andAmountTaxLessThan(Integer value) {
            addCriterion("amount_tax <", value, "amountTax");
            return (Criteria) this;
        }

        public Criteria andAmountTaxLessThanOrEqualTo(Integer value) {
            addCriterion("amount_tax <=", value, "amountTax");
            return (Criteria) this;
        }

        public Criteria andAmountTaxIn(List<Integer> values) {
            addCriterion("amount_tax in", values, "amountTax");
            return (Criteria) this;
        }

        public Criteria andAmountTaxNotIn(List<Integer> values) {
            addCriterion("amount_tax not in", values, "amountTax");
            return (Criteria) this;
        }

        public Criteria andAmountTaxBetween(Integer value1, Integer value2) {
            addCriterion("amount_tax between", value1, value2, "amountTax");
            return (Criteria) this;
        }

        public Criteria andAmountTaxNotBetween(Integer value1, Integer value2) {
            addCriterion("amount_tax not between", value1, value2, "amountTax");
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