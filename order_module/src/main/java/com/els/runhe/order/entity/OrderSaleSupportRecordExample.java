package com.els.runhe.order.entity;

import com.els.base.core.entity.AbstractExample;
import com.els.base.core.entity.PageView;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderSaleSupportRecordExample extends AbstractExample<OrderSaleSupportRecord> implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected PageView<OrderSaleSupportRecord> pageView = new PageView<OrderSaleSupportRecord>(1, 10);

    private static final long serialVersionUID = 1L;

    public OrderSaleSupportRecordExample() {
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
    public PageView<OrderSaleSupportRecord> getPageView() {
        return pageView;
    }

    @Override
    public void setPageView(PageView<OrderSaleSupportRecord> pageView) {
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
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("ID like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("ID not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andPurCompanyIdIsNull() {
            addCriterion("PUR_COMPANY_ID is null");
            return (Criteria) this;
        }

        public Criteria andPurCompanyIdIsNotNull() {
            addCriterion("PUR_COMPANY_ID is not null");
            return (Criteria) this;
        }

        public Criteria andPurCompanyIdEqualTo(String value) {
            addCriterion("PUR_COMPANY_ID =", value, "purCompanyId");
            return (Criteria) this;
        }

        public Criteria andPurCompanyIdNotEqualTo(String value) {
            addCriterion("PUR_COMPANY_ID <>", value, "purCompanyId");
            return (Criteria) this;
        }

        public Criteria andPurCompanyIdGreaterThan(String value) {
            addCriterion("PUR_COMPANY_ID >", value, "purCompanyId");
            return (Criteria) this;
        }

        public Criteria andPurCompanyIdGreaterThanOrEqualTo(String value) {
            addCriterion("PUR_COMPANY_ID >=", value, "purCompanyId");
            return (Criteria) this;
        }

        public Criteria andPurCompanyIdLessThan(String value) {
            addCriterion("PUR_COMPANY_ID <", value, "purCompanyId");
            return (Criteria) this;
        }

        public Criteria andPurCompanyIdLessThanOrEqualTo(String value) {
            addCriterion("PUR_COMPANY_ID <=", value, "purCompanyId");
            return (Criteria) this;
        }

        public Criteria andPurCompanyIdLike(String value) {
            addCriterion("PUR_COMPANY_ID like", value, "purCompanyId");
            return (Criteria) this;
        }

        public Criteria andPurCompanyIdNotLike(String value) {
            addCriterion("PUR_COMPANY_ID not like", value, "purCompanyId");
            return (Criteria) this;
        }

        public Criteria andPurCompanyIdIn(List<String> values) {
            addCriterion("PUR_COMPANY_ID in", values, "purCompanyId");
            return (Criteria) this;
        }

        public Criteria andPurCompanyIdNotIn(List<String> values) {
            addCriterion("PUR_COMPANY_ID not in", values, "purCompanyId");
            return (Criteria) this;
        }

        public Criteria andPurCompanyIdBetween(String value1, String value2) {
            addCriterion("PUR_COMPANY_ID between", value1, value2, "purCompanyId");
            return (Criteria) this;
        }

        public Criteria andPurCompanyIdNotBetween(String value1, String value2) {
            addCriterion("PUR_COMPANY_ID not between", value1, value2, "purCompanyId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNull() {
            addCriterion("ORDER_ID is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("ORDER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(String value) {
            addCriterion("ORDER_ID =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(String value) {
            addCriterion("ORDER_ID <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(String value) {
            addCriterion("ORDER_ID >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(String value) {
            addCriterion("ORDER_ID >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(String value) {
            addCriterion("ORDER_ID <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(String value) {
            addCriterion("ORDER_ID <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLike(String value) {
            addCriterion("ORDER_ID like", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotLike(String value) {
            addCriterion("ORDER_ID not like", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<String> values) {
            addCriterion("ORDER_ID in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<String> values) {
            addCriterion("ORDER_ID not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(String value1, String value2) {
            addCriterion("ORDER_ID between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(String value1, String value2) {
            addCriterion("ORDER_ID not between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderNoIsNull() {
            addCriterion("ORDER_NO is null");
            return (Criteria) this;
        }

        public Criteria andOrderNoIsNotNull() {
            addCriterion("ORDER_NO is not null");
            return (Criteria) this;
        }

        public Criteria andOrderNoEqualTo(String value) {
            addCriterion("ORDER_NO =", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotEqualTo(String value) {
            addCriterion("ORDER_NO <>", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoGreaterThan(String value) {
            addCriterion("ORDER_NO >", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoGreaterThanOrEqualTo(String value) {
            addCriterion("ORDER_NO >=", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLessThan(String value) {
            addCriterion("ORDER_NO <", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLessThanOrEqualTo(String value) {
            addCriterion("ORDER_NO <=", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLike(String value) {
            addCriterion("ORDER_NO like", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotLike(String value) {
            addCriterion("ORDER_NO not like", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoIn(List<String> values) {
            addCriterion("ORDER_NO in", values, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotIn(List<String> values) {
            addCriterion("ORDER_NO not in", values, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoBetween(String value1, String value2) {
            addCriterion("ORDER_NO between", value1, value2, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotBetween(String value1, String value2) {
            addCriterion("ORDER_NO not between", value1, value2, "orderNo");
            return (Criteria) this;
        }

        public Criteria andContractIdIsNull() {
            addCriterion("CONTRACT_ID is null");
            return (Criteria) this;
        }

        public Criteria andContractIdIsNotNull() {
            addCriterion("CONTRACT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andContractIdEqualTo(String value) {
            addCriterion("CONTRACT_ID =", value, "contractId");
            return (Criteria) this;
        }

        public Criteria andContractIdNotEqualTo(String value) {
            addCriterion("CONTRACT_ID <>", value, "contractId");
            return (Criteria) this;
        }

        public Criteria andContractIdGreaterThan(String value) {
            addCriterion("CONTRACT_ID >", value, "contractId");
            return (Criteria) this;
        }

        public Criteria andContractIdGreaterThanOrEqualTo(String value) {
            addCriterion("CONTRACT_ID >=", value, "contractId");
            return (Criteria) this;
        }

        public Criteria andContractIdLessThan(String value) {
            addCriterion("CONTRACT_ID <", value, "contractId");
            return (Criteria) this;
        }

        public Criteria andContractIdLessThanOrEqualTo(String value) {
            addCriterion("CONTRACT_ID <=", value, "contractId");
            return (Criteria) this;
        }

        public Criteria andContractIdLike(String value) {
            addCriterion("CONTRACT_ID like", value, "contractId");
            return (Criteria) this;
        }

        public Criteria andContractIdNotLike(String value) {
            addCriterion("CONTRACT_ID not like", value, "contractId");
            return (Criteria) this;
        }

        public Criteria andContractIdIn(List<String> values) {
            addCriterion("CONTRACT_ID in", values, "contractId");
            return (Criteria) this;
        }

        public Criteria andContractIdNotIn(List<String> values) {
            addCriterion("CONTRACT_ID not in", values, "contractId");
            return (Criteria) this;
        }

        public Criteria andContractIdBetween(String value1, String value2) {
            addCriterion("CONTRACT_ID between", value1, value2, "contractId");
            return (Criteria) this;
        }

        public Criteria andContractIdNotBetween(String value1, String value2) {
            addCriterion("CONTRACT_ID not between", value1, value2, "contractId");
            return (Criteria) this;
        }

        public Criteria andRefundMinIsNull() {
            addCriterion("REFUND_MIN is null");
            return (Criteria) this;
        }

        public Criteria andRefundMinIsNotNull() {
            addCriterion("REFUND_MIN is not null");
            return (Criteria) this;
        }

        public Criteria andRefundMinEqualTo(BigDecimal value) {
            addCriterion("REFUND_MIN =", value, "refundMin");
            return (Criteria) this;
        }

        public Criteria andRefundMinNotEqualTo(BigDecimal value) {
            addCriterion("REFUND_MIN <>", value, "refundMin");
            return (Criteria) this;
        }

        public Criteria andRefundMinGreaterThan(BigDecimal value) {
            addCriterion("REFUND_MIN >", value, "refundMin");
            return (Criteria) this;
        }

        public Criteria andRefundMinGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("REFUND_MIN >=", value, "refundMin");
            return (Criteria) this;
        }

        public Criteria andRefundMinLessThan(BigDecimal value) {
            addCriterion("REFUND_MIN <", value, "refundMin");
            return (Criteria) this;
        }

        public Criteria andRefundMinLessThanOrEqualTo(BigDecimal value) {
            addCriterion("REFUND_MIN <=", value, "refundMin");
            return (Criteria) this;
        }

        public Criteria andRefundMinIn(List<BigDecimal> values) {
            addCriterion("REFUND_MIN in", values, "refundMin");
            return (Criteria) this;
        }

        public Criteria andRefundMinNotIn(List<BigDecimal> values) {
            addCriterion("REFUND_MIN not in", values, "refundMin");
            return (Criteria) this;
        }

        public Criteria andRefundMinBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("REFUND_MIN between", value1, value2, "refundMin");
            return (Criteria) this;
        }

        public Criteria andRefundMinNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("REFUND_MIN not between", value1, value2, "refundMin");
            return (Criteria) this;
        }

        public Criteria andRefundMaxIsNull() {
            addCriterion("REFUND_MAX is null");
            return (Criteria) this;
        }

        public Criteria andRefundMaxIsNotNull() {
            addCriterion("REFUND_MAX is not null");
            return (Criteria) this;
        }

        public Criteria andRefundMaxEqualTo(BigDecimal value) {
            addCriterion("REFUND_MAX =", value, "refundMax");
            return (Criteria) this;
        }

        public Criteria andRefundMaxNotEqualTo(BigDecimal value) {
            addCriterion("REFUND_MAX <>", value, "refundMax");
            return (Criteria) this;
        }

        public Criteria andRefundMaxGreaterThan(BigDecimal value) {
            addCriterion("REFUND_MAX >", value, "refundMax");
            return (Criteria) this;
        }

        public Criteria andRefundMaxGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("REFUND_MAX >=", value, "refundMax");
            return (Criteria) this;
        }

        public Criteria andRefundMaxLessThan(BigDecimal value) {
            addCriterion("REFUND_MAX <", value, "refundMax");
            return (Criteria) this;
        }

        public Criteria andRefundMaxLessThanOrEqualTo(BigDecimal value) {
            addCriterion("REFUND_MAX <=", value, "refundMax");
            return (Criteria) this;
        }

        public Criteria andRefundMaxIn(List<BigDecimal> values) {
            addCriterion("REFUND_MAX in", values, "refundMax");
            return (Criteria) this;
        }

        public Criteria andRefundMaxNotIn(List<BigDecimal> values) {
            addCriterion("REFUND_MAX not in", values, "refundMax");
            return (Criteria) this;
        }

        public Criteria andRefundMaxBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("REFUND_MAX between", value1, value2, "refundMax");
            return (Criteria) this;
        }

        public Criteria andRefundMaxNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("REFUND_MAX not between", value1, value2, "refundMax");
            return (Criteria) this;
        }

        public Criteria andSupportRateIsNull() {
            addCriterion("SUPPORT_RATE is null");
            return (Criteria) this;
        }

        public Criteria andSupportRateIsNotNull() {
            addCriterion("SUPPORT_RATE is not null");
            return (Criteria) this;
        }

        public Criteria andSupportRateEqualTo(BigDecimal value) {
            addCriterion("SUPPORT_RATE =", value, "supportRate");
            return (Criteria) this;
        }

        public Criteria andSupportRateNotEqualTo(BigDecimal value) {
            addCriterion("SUPPORT_RATE <>", value, "supportRate");
            return (Criteria) this;
        }

        public Criteria andSupportRateGreaterThan(BigDecimal value) {
            addCriterion("SUPPORT_RATE >", value, "supportRate");
            return (Criteria) this;
        }

        public Criteria andSupportRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("SUPPORT_RATE >=", value, "supportRate");
            return (Criteria) this;
        }

        public Criteria andSupportRateLessThan(BigDecimal value) {
            addCriterion("SUPPORT_RATE <", value, "supportRate");
            return (Criteria) this;
        }

        public Criteria andSupportRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("SUPPORT_RATE <=", value, "supportRate");
            return (Criteria) this;
        }

        public Criteria andSupportRateIn(List<BigDecimal> values) {
            addCriterion("SUPPORT_RATE in", values, "supportRate");
            return (Criteria) this;
        }

        public Criteria andSupportRateNotIn(List<BigDecimal> values) {
            addCriterion("SUPPORT_RATE not in", values, "supportRate");
            return (Criteria) this;
        }

        public Criteria andSupportRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SUPPORT_RATE between", value1, value2, "supportRate");
            return (Criteria) this;
        }

        public Criteria andSupportRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SUPPORT_RATE not between", value1, value2, "supportRate");
            return (Criteria) this;
        }

        public Criteria andOrderAmountPayIsNull() {
            addCriterion("ORDER_AMOUNT_PAY is null");
            return (Criteria) this;
        }

        public Criteria andOrderAmountPayIsNotNull() {
            addCriterion("ORDER_AMOUNT_PAY is not null");
            return (Criteria) this;
        }

        public Criteria andOrderAmountPayEqualTo(BigDecimal value) {
            addCriterion("ORDER_AMOUNT_PAY =", value, "orderAmountPay");
            return (Criteria) this;
        }

        public Criteria andOrderAmountPayNotEqualTo(BigDecimal value) {
            addCriterion("ORDER_AMOUNT_PAY <>", value, "orderAmountPay");
            return (Criteria) this;
        }

        public Criteria andOrderAmountPayGreaterThan(BigDecimal value) {
            addCriterion("ORDER_AMOUNT_PAY >", value, "orderAmountPay");
            return (Criteria) this;
        }

        public Criteria andOrderAmountPayGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ORDER_AMOUNT_PAY >=", value, "orderAmountPay");
            return (Criteria) this;
        }

        public Criteria andOrderAmountPayLessThan(BigDecimal value) {
            addCriterion("ORDER_AMOUNT_PAY <", value, "orderAmountPay");
            return (Criteria) this;
        }

        public Criteria andOrderAmountPayLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ORDER_AMOUNT_PAY <=", value, "orderAmountPay");
            return (Criteria) this;
        }

        public Criteria andOrderAmountPayIn(List<BigDecimal> values) {
            addCriterion("ORDER_AMOUNT_PAY in", values, "orderAmountPay");
            return (Criteria) this;
        }

        public Criteria andOrderAmountPayNotIn(List<BigDecimal> values) {
            addCriterion("ORDER_AMOUNT_PAY not in", values, "orderAmountPay");
            return (Criteria) this;
        }

        public Criteria andOrderAmountPayBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ORDER_AMOUNT_PAY between", value1, value2, "orderAmountPay");
            return (Criteria) this;
        }

        public Criteria andOrderAmountPayNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ORDER_AMOUNT_PAY not between", value1, value2, "orderAmountPay");
            return (Criteria) this;
        }

        public Criteria andRefundIsNull() {
            addCriterion("REFUND is null");
            return (Criteria) this;
        }

        public Criteria andRefundIsNotNull() {
            addCriterion("REFUND is not null");
            return (Criteria) this;
        }

        public Criteria andRefundEqualTo(BigDecimal value) {
            addCriterion("REFUND =", value, "refund");
            return (Criteria) this;
        }

        public Criteria andRefundNotEqualTo(BigDecimal value) {
            addCriterion("REFUND <>", value, "refund");
            return (Criteria) this;
        }

        public Criteria andRefundGreaterThan(BigDecimal value) {
            addCriterion("REFUND >", value, "refund");
            return (Criteria) this;
        }

        public Criteria andRefundGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("REFUND >=", value, "refund");
            return (Criteria) this;
        }

        public Criteria andRefundLessThan(BigDecimal value) {
            addCriterion("REFUND <", value, "refund");
            return (Criteria) this;
        }

        public Criteria andRefundLessThanOrEqualTo(BigDecimal value) {
            addCriterion("REFUND <=", value, "refund");
            return (Criteria) this;
        }

        public Criteria andRefundIn(List<BigDecimal> values) {
            addCriterion("REFUND in", values, "refund");
            return (Criteria) this;
        }

        public Criteria andRefundNotIn(List<BigDecimal> values) {
            addCriterion("REFUND not in", values, "refund");
            return (Criteria) this;
        }

        public Criteria andRefundBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("REFUND between", value1, value2, "refund");
            return (Criteria) this;
        }

        public Criteria andRefundNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("REFUND not between", value1, value2, "refund");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("CREATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("CREATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("CREATE_TIME =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("CREATE_TIME <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("CREATE_TIME >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("CREATE_TIME <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("CREATE_TIME in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("CREATE_TIME not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("TYPE is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("TYPE =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("TYPE <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("TYPE >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("TYPE >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("TYPE <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("TYPE <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("TYPE like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("TYPE not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("TYPE in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("TYPE not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("TYPE between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("TYPE not between", value1, value2, "type");
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