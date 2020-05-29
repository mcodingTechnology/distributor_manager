package com.els.runhe.contract.entity;

import com.els.base.core.entity.AbstractExample;
import com.els.base.core.entity.PageView;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ContractSaleSupportExample extends AbstractExample<ContractSaleSupport> implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected PageView<ContractSaleSupport> pageView = new PageView<ContractSaleSupport>(1, 10);

    private static final long serialVersionUID = 1L;

    public ContractSaleSupportExample() {
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
    public PageView<ContractSaleSupport> getPageView() {
        return pageView;
    }

    @Override
    public void setPageView(PageView<ContractSaleSupport> pageView) {
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

        public Criteria andSerialNumIsNull() {
            addCriterion("SERIAL_NUM is null");
            return (Criteria) this;
        }

        public Criteria andSerialNumIsNotNull() {
            addCriterion("SERIAL_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andSerialNumEqualTo(Integer value) {
            addCriterion("SERIAL_NUM =", value, "serialNum");
            return (Criteria) this;
        }

        public Criteria andSerialNumNotEqualTo(Integer value) {
            addCriterion("SERIAL_NUM <>", value, "serialNum");
            return (Criteria) this;
        }

        public Criteria andSerialNumGreaterThan(Integer value) {
            addCriterion("SERIAL_NUM >", value, "serialNum");
            return (Criteria) this;
        }

        public Criteria andSerialNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("SERIAL_NUM >=", value, "serialNum");
            return (Criteria) this;
        }

        public Criteria andSerialNumLessThan(Integer value) {
            addCriterion("SERIAL_NUM <", value, "serialNum");
            return (Criteria) this;
        }

        public Criteria andSerialNumLessThanOrEqualTo(Integer value) {
            addCriterion("SERIAL_NUM <=", value, "serialNum");
            return (Criteria) this;
        }

        public Criteria andSerialNumIn(List<Integer> values) {
            addCriterion("SERIAL_NUM in", values, "serialNum");
            return (Criteria) this;
        }

        public Criteria andSerialNumNotIn(List<Integer> values) {
            addCriterion("SERIAL_NUM not in", values, "serialNum");
            return (Criteria) this;
        }

        public Criteria andSerialNumBetween(Integer value1, Integer value2) {
            addCriterion("SERIAL_NUM between", value1, value2, "serialNum");
            return (Criteria) this;
        }

        public Criteria andSerialNumNotBetween(Integer value1, Integer value2) {
            addCriterion("SERIAL_NUM not between", value1, value2, "serialNum");
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

        public Criteria andRefundMinEqualTo(Double value) {
            addCriterion("REFUND_MIN =", value, "refundMin");
            return (Criteria) this;
        }

        public Criteria andRefundMinNotEqualTo(Double value) {
            addCriterion("REFUND_MIN <>", value, "refundMin");
            return (Criteria) this;
        }

        public Criteria andRefundMinGreaterThan(Double value) {
            addCriterion("REFUND_MIN >", value, "refundMin");
            return (Criteria) this;
        }

        public Criteria andRefundMinGreaterThanOrEqualTo(Double value) {
            addCriterion("REFUND_MIN >=", value, "refundMin");
            return (Criteria) this;
        }

        public Criteria andRefundMinLessThan(Double value) {
            addCriterion("REFUND_MIN <", value, "refundMin");
            return (Criteria) this;
        }

        public Criteria andRefundMinLessThanOrEqualTo(Double value) {
            addCriterion("REFUND_MIN <=", value, "refundMin");
            return (Criteria) this;
        }

        public Criteria andRefundMinIn(List<Double> values) {
            addCriterion("REFUND_MIN in", values, "refundMin");
            return (Criteria) this;
        }

        public Criteria andRefundMinNotIn(List<Double> values) {
            addCriterion("REFUND_MIN not in", values, "refundMin");
            return (Criteria) this;
        }

        public Criteria andRefundMinBetween(Double value1, Double value2) {
            addCriterion("REFUND_MIN between", value1, value2, "refundMin");
            return (Criteria) this;
        }

        public Criteria andRefundMinNotBetween(Double value1, Double value2) {
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

        public Criteria andRefundMaxEqualTo(Double value) {
            addCriterion("REFUND_MAX =", value, "refundMax");
            return (Criteria) this;
        }

        public Criteria andRefundMaxNotEqualTo(Double value) {
            addCriterion("REFUND_MAX <>", value, "refundMax");
            return (Criteria) this;
        }

        public Criteria andRefundMaxGreaterThan(Double value) {
            addCriterion("REFUND_MAX >", value, "refundMax");
            return (Criteria) this;
        }

        public Criteria andRefundMaxGreaterThanOrEqualTo(Double value) {
            addCriterion("REFUND_MAX >=", value, "refundMax");
            return (Criteria) this;
        }

        public Criteria andRefundMaxLessThan(Double value) {
            addCriterion("REFUND_MAX <", value, "refundMax");
            return (Criteria) this;
        }

        public Criteria andRefundMaxLessThanOrEqualTo(Double value) {
            addCriterion("REFUND_MAX <=", value, "refundMax");
            return (Criteria) this;
        }

        public Criteria andRefundMaxIn(List<Double> values) {
            addCriterion("REFUND_MAX in", values, "refundMax");
            return (Criteria) this;
        }

        public Criteria andRefundMaxNotIn(List<Double> values) {
            addCriterion("REFUND_MAX not in", values, "refundMax");
            return (Criteria) this;
        }

        public Criteria andRefundMaxBetween(Double value1, Double value2) {
            addCriterion("REFUND_MAX between", value1, value2, "refundMax");
            return (Criteria) this;
        }

        public Criteria andRefundMaxNotBetween(Double value1, Double value2) {
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

        public Criteria andSupportRateEqualTo(Double value) {
            addCriterion("SUPPORT_RATE =", value, "supportRate");
            return (Criteria) this;
        }

        public Criteria andSupportRateNotEqualTo(Double value) {
            addCriterion("SUPPORT_RATE <>", value, "supportRate");
            return (Criteria) this;
        }

        public Criteria andSupportRateGreaterThan(Double value) {
            addCriterion("SUPPORT_RATE >", value, "supportRate");
            return (Criteria) this;
        }

        public Criteria andSupportRateGreaterThanOrEqualTo(Double value) {
            addCriterion("SUPPORT_RATE >=", value, "supportRate");
            return (Criteria) this;
        }

        public Criteria andSupportRateLessThan(Double value) {
            addCriterion("SUPPORT_RATE <", value, "supportRate");
            return (Criteria) this;
        }

        public Criteria andSupportRateLessThanOrEqualTo(Double value) {
            addCriterion("SUPPORT_RATE <=", value, "supportRate");
            return (Criteria) this;
        }

        public Criteria andSupportRateIn(List<Double> values) {
            addCriterion("SUPPORT_RATE in", values, "supportRate");
            return (Criteria) this;
        }

        public Criteria andSupportRateNotIn(List<Double> values) {
            addCriterion("SUPPORT_RATE not in", values, "supportRate");
            return (Criteria) this;
        }

        public Criteria andSupportRateBetween(Double value1, Double value2) {
            addCriterion("SUPPORT_RATE between", value1, value2, "supportRate");
            return (Criteria) this;
        }

        public Criteria andSupportRateNotBetween(Double value1, Double value2) {
            addCriterion("SUPPORT_RATE not between", value1, value2, "supportRate");
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

        public Criteria andUpdateTimeIsNull() {
            addCriterion("UPDATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("UPDATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("UPDATE_TIME =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("UPDATE_TIME <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("UPDATE_TIME >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("UPDATE_TIME >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("UPDATE_TIME <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("UPDATE_TIME <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("UPDATE_TIME in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("UPDATE_TIME not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("UPDATE_TIME between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("UPDATE_TIME not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andIsEnableIsNull() {
            addCriterion("IS_ENABLE is null");
            return (Criteria) this;
        }

        public Criteria andIsEnableIsNotNull() {
            addCriterion("IS_ENABLE is not null");
            return (Criteria) this;
        }

        public Criteria andIsEnableEqualTo(Integer value) {
            addCriterion("IS_ENABLE =", value, "isEnable");
            return (Criteria) this;
        }

        public Criteria andIsEnableNotEqualTo(Integer value) {
            addCriterion("IS_ENABLE <>", value, "isEnable");
            return (Criteria) this;
        }

        public Criteria andIsEnableGreaterThan(Integer value) {
            addCriterion("IS_ENABLE >", value, "isEnable");
            return (Criteria) this;
        }

        public Criteria andIsEnableGreaterThanOrEqualTo(Integer value) {
            addCriterion("IS_ENABLE >=", value, "isEnable");
            return (Criteria) this;
        }

        public Criteria andIsEnableLessThan(Integer value) {
            addCriterion("IS_ENABLE <", value, "isEnable");
            return (Criteria) this;
        }

        public Criteria andIsEnableLessThanOrEqualTo(Integer value) {
            addCriterion("IS_ENABLE <=", value, "isEnable");
            return (Criteria) this;
        }

        public Criteria andIsEnableIn(List<Integer> values) {
            addCriterion("IS_ENABLE in", values, "isEnable");
            return (Criteria) this;
        }

        public Criteria andIsEnableNotIn(List<Integer> values) {
            addCriterion("IS_ENABLE not in", values, "isEnable");
            return (Criteria) this;
        }

        public Criteria andIsEnableBetween(Integer value1, Integer value2) {
            addCriterion("IS_ENABLE between", value1, value2, "isEnable");
            return (Criteria) this;
        }

        public Criteria andIsEnableNotBetween(Integer value1, Integer value2) {
            addCriterion("IS_ENABLE not between", value1, value2, "isEnable");
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