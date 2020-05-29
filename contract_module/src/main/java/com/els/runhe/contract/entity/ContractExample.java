package com.els.runhe.contract.entity;

import com.els.base.core.entity.AbstractExample;
import com.els.base.core.entity.PageView;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ContractExample extends AbstractExample<Contract> implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected PageView<Contract> pageView = new PageView<Contract>(1, 10);

    private static final long serialVersionUID = 1L;

    public ContractExample() {
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
    public PageView<Contract> getPageView() {
        return pageView;
    }

    @Override
    public void setPageView(PageView<Contract> pageView) {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
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

        public Criteria andContractNameIsNull() {
            addCriterion("CONTRACT_NAME is null");
            return (Criteria) this;
        }

        public Criteria andContractNameIsNotNull() {
            addCriterion("CONTRACT_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andContractNameEqualTo(String value) {
            addCriterion("CONTRACT_NAME =", value, "contractName");
            return (Criteria) this;
        }

        public Criteria andContractNameNotEqualTo(String value) {
            addCriterion("CONTRACT_NAME <>", value, "contractName");
            return (Criteria) this;
        }

        public Criteria andContractNameGreaterThan(String value) {
            addCriterion("CONTRACT_NAME >", value, "contractName");
            return (Criteria) this;
        }

        public Criteria andContractNameGreaterThanOrEqualTo(String value) {
            addCriterion("CONTRACT_NAME >=", value, "contractName");
            return (Criteria) this;
        }

        public Criteria andContractNameLessThan(String value) {
            addCriterion("CONTRACT_NAME <", value, "contractName");
            return (Criteria) this;
        }

        public Criteria andContractNameLessThanOrEqualTo(String value) {
            addCriterion("CONTRACT_NAME <=", value, "contractName");
            return (Criteria) this;
        }

        public Criteria andContractNameLike(String value) {
            addCriterion("CONTRACT_NAME like", value, "contractName");
            return (Criteria) this;
        }

        public Criteria andContractNameNotLike(String value) {
            addCriterion("CONTRACT_NAME not like", value, "contractName");
            return (Criteria) this;
        }

        public Criteria andContractNameIn(List<String> values) {
            addCriterion("CONTRACT_NAME in", values, "contractName");
            return (Criteria) this;
        }

        public Criteria andContractNameNotIn(List<String> values) {
            addCriterion("CONTRACT_NAME not in", values, "contractName");
            return (Criteria) this;
        }

        public Criteria andContractNameBetween(String value1, String value2) {
            addCriterion("CONTRACT_NAME between", value1, value2, "contractName");
            return (Criteria) this;
        }

        public Criteria andContractNameNotBetween(String value1, String value2) {
            addCriterion("CONTRACT_NAME not between", value1, value2, "contractName");
            return (Criteria) this;
        }

        public Criteria andContractNumIsNull() {
            addCriterion("CONTRACT_NUM is null");
            return (Criteria) this;
        }

        public Criteria andContractNumIsNotNull() {
            addCriterion("CONTRACT_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andContractNumEqualTo(String value) {
            addCriterion("CONTRACT_NUM =", value, "contractNum");
            return (Criteria) this;
        }

        public Criteria andContractNumNotEqualTo(String value) {
            addCriterion("CONTRACT_NUM <>", value, "contractNum");
            return (Criteria) this;
        }

        public Criteria andContractNumGreaterThan(String value) {
            addCriterion("CONTRACT_NUM >", value, "contractNum");
            return (Criteria) this;
        }

        public Criteria andContractNumGreaterThanOrEqualTo(String value) {
            addCriterion("CONTRACT_NUM >=", value, "contractNum");
            return (Criteria) this;
        }

        public Criteria andContractNumLessThan(String value) {
            addCriterion("CONTRACT_NUM <", value, "contractNum");
            return (Criteria) this;
        }

        public Criteria andContractNumLessThanOrEqualTo(String value) {
            addCriterion("CONTRACT_NUM <=", value, "contractNum");
            return (Criteria) this;
        }

        public Criteria andContractNumLike(String value) {
            addCriterion("CONTRACT_NUM like", value, "contractNum");
            return (Criteria) this;
        }

        public Criteria andContractNumNotLike(String value) {
            addCriterion("CONTRACT_NUM not like", value, "contractNum");
            return (Criteria) this;
        }

        public Criteria andContractNumIn(List<String> values) {
            addCriterion("CONTRACT_NUM in", values, "contractNum");
            return (Criteria) this;
        }

        public Criteria andContractNumNotIn(List<String> values) {
            addCriterion("CONTRACT_NUM not in", values, "contractNum");
            return (Criteria) this;
        }

        public Criteria andContractNumBetween(String value1, String value2) {
            addCriterion("CONTRACT_NUM between", value1, value2, "contractNum");
            return (Criteria) this;
        }

        public Criteria andContractNumNotBetween(String value1, String value2) {
            addCriterion("CONTRACT_NUM not between", value1, value2, "contractNum");
            return (Criteria) this;
        }

        public Criteria andSignDateIsNull() {
            addCriterion("SIGN_DATE is null");
            return (Criteria) this;
        }

        public Criteria andSignDateIsNotNull() {
            addCriterion("SIGN_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andSignDateEqualTo(Date value) {
            addCriterionForJDBCDate("SIGN_DATE =", value, "signDate");
            return (Criteria) this;
        }

        public Criteria andSignDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("SIGN_DATE <>", value, "signDate");
            return (Criteria) this;
        }

        public Criteria andSignDateGreaterThan(Date value) {
            addCriterionForJDBCDate("SIGN_DATE >", value, "signDate");
            return (Criteria) this;
        }

        public Criteria andSignDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("SIGN_DATE >=", value, "signDate");
            return (Criteria) this;
        }

        public Criteria andSignDateLessThan(Date value) {
            addCriterionForJDBCDate("SIGN_DATE <", value, "signDate");
            return (Criteria) this;
        }

        public Criteria andSignDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("SIGN_DATE <=", value, "signDate");
            return (Criteria) this;
        }

        public Criteria andSignDateIn(List<Date> values) {
            addCriterionForJDBCDate("SIGN_DATE in", values, "signDate");
            return (Criteria) this;
        }

        public Criteria andSignDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("SIGN_DATE not in", values, "signDate");
            return (Criteria) this;
        }

        public Criteria andSignDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("SIGN_DATE between", value1, value2, "signDate");
            return (Criteria) this;
        }

        public Criteria andSignDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("SIGN_DATE not between", value1, value2, "signDate");
            return (Criteria) this;
        }

        public Criteria andStartDateIsNull() {
            addCriterion("START_DATE is null");
            return (Criteria) this;
        }

        public Criteria andStartDateIsNotNull() {
            addCriterion("START_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andStartDateEqualTo(Date value) {
            addCriterionForJDBCDate("START_DATE =", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("START_DATE <>", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateGreaterThan(Date value) {
            addCriterionForJDBCDate("START_DATE >", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("START_DATE >=", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateLessThan(Date value) {
            addCriterionForJDBCDate("START_DATE <", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("START_DATE <=", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateIn(List<Date> values) {
            addCriterionForJDBCDate("START_DATE in", values, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("START_DATE not in", values, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("START_DATE between", value1, value2, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("START_DATE not between", value1, value2, "startDate");
            return (Criteria) this;
        }

        public Criteria andEndDateIsNull() {
            addCriterion("END_DATE is null");
            return (Criteria) this;
        }

        public Criteria andEndDateIsNotNull() {
            addCriterion("END_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andEndDateEqualTo(Date value) {
            addCriterionForJDBCDate("END_DATE =", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("END_DATE <>", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateGreaterThan(Date value) {
            addCriterionForJDBCDate("END_DATE >", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("END_DATE >=", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateLessThan(Date value) {
            addCriterionForJDBCDate("END_DATE <", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("END_DATE <=", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateIn(List<Date> values) {
            addCriterionForJDBCDate("END_DATE in", values, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("END_DATE not in", values, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("END_DATE between", value1, value2, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("END_DATE not between", value1, value2, "endDate");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("STATUS is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("STATUS =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("STATUS <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("STATUS >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("STATUS >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("STATUS <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("STATUS <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("STATUS like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("STATUS not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("STATUS in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("STATUS not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("STATUS between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("STATUS not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andSignAddrIsNull() {
            addCriterion("SIGN_ADDR is null");
            return (Criteria) this;
        }

        public Criteria andSignAddrIsNotNull() {
            addCriterion("SIGN_ADDR is not null");
            return (Criteria) this;
        }

        public Criteria andSignAddrEqualTo(String value) {
            addCriterion("SIGN_ADDR =", value, "signAddr");
            return (Criteria) this;
        }

        public Criteria andSignAddrNotEqualTo(String value) {
            addCriterion("SIGN_ADDR <>", value, "signAddr");
            return (Criteria) this;
        }

        public Criteria andSignAddrGreaterThan(String value) {
            addCriterion("SIGN_ADDR >", value, "signAddr");
            return (Criteria) this;
        }

        public Criteria andSignAddrGreaterThanOrEqualTo(String value) {
            addCriterion("SIGN_ADDR >=", value, "signAddr");
            return (Criteria) this;
        }

        public Criteria andSignAddrLessThan(String value) {
            addCriterion("SIGN_ADDR <", value, "signAddr");
            return (Criteria) this;
        }

        public Criteria andSignAddrLessThanOrEqualTo(String value) {
            addCriterion("SIGN_ADDR <=", value, "signAddr");
            return (Criteria) this;
        }

        public Criteria andSignAddrLike(String value) {
            addCriterion("SIGN_ADDR like", value, "signAddr");
            return (Criteria) this;
        }

        public Criteria andSignAddrNotLike(String value) {
            addCriterion("SIGN_ADDR not like", value, "signAddr");
            return (Criteria) this;
        }

        public Criteria andSignAddrIn(List<String> values) {
            addCriterion("SIGN_ADDR in", values, "signAddr");
            return (Criteria) this;
        }

        public Criteria andSignAddrNotIn(List<String> values) {
            addCriterion("SIGN_ADDR not in", values, "signAddr");
            return (Criteria) this;
        }

        public Criteria andSignAddrBetween(String value1, String value2) {
            addCriterion("SIGN_ADDR between", value1, value2, "signAddr");
            return (Criteria) this;
        }

        public Criteria andSignAddrNotBetween(String value1, String value2) {
            addCriterion("SIGN_ADDR not between", value1, value2, "signAddr");
            return (Criteria) this;
        }

        public Criteria andPartyAIdIsNull() {
            addCriterion("PARTY_A_ID is null");
            return (Criteria) this;
        }

        public Criteria andPartyAIdIsNotNull() {
            addCriterion("PARTY_A_ID is not null");
            return (Criteria) this;
        }

        public Criteria andPartyAIdEqualTo(String value) {
            addCriterion("PARTY_A_ID =", value, "partyAId");
            return (Criteria) this;
        }

        public Criteria andPartyAIdNotEqualTo(String value) {
            addCriterion("PARTY_A_ID <>", value, "partyAId");
            return (Criteria) this;
        }

        public Criteria andPartyAIdGreaterThan(String value) {
            addCriterion("PARTY_A_ID >", value, "partyAId");
            return (Criteria) this;
        }

        public Criteria andPartyAIdGreaterThanOrEqualTo(String value) {
            addCriterion("PARTY_A_ID >=", value, "partyAId");
            return (Criteria) this;
        }

        public Criteria andPartyAIdLessThan(String value) {
            addCriterion("PARTY_A_ID <", value, "partyAId");
            return (Criteria) this;
        }

        public Criteria andPartyAIdLessThanOrEqualTo(String value) {
            addCriterion("PARTY_A_ID <=", value, "partyAId");
            return (Criteria) this;
        }

        public Criteria andPartyAIdLike(String value) {
            addCriterion("PARTY_A_ID like", value, "partyAId");
            return (Criteria) this;
        }

        public Criteria andPartyAIdNotLike(String value) {
            addCriterion("PARTY_A_ID not like", value, "partyAId");
            return (Criteria) this;
        }

        public Criteria andPartyAIdIn(List<String> values) {
            addCriterion("PARTY_A_ID in", values, "partyAId");
            return (Criteria) this;
        }

        public Criteria andPartyAIdNotIn(List<String> values) {
            addCriterion("PARTY_A_ID not in", values, "partyAId");
            return (Criteria) this;
        }

        public Criteria andPartyAIdBetween(String value1, String value2) {
            addCriterion("PARTY_A_ID between", value1, value2, "partyAId");
            return (Criteria) this;
        }

        public Criteria andPartyAIdNotBetween(String value1, String value2) {
            addCriterion("PARTY_A_ID not between", value1, value2, "partyAId");
            return (Criteria) this;
        }

        public Criteria andPartyAIsNull() {
            addCriterion("PARTY_A is null");
            return (Criteria) this;
        }

        public Criteria andPartyAIsNotNull() {
            addCriterion("PARTY_A is not null");
            return (Criteria) this;
        }

        public Criteria andPartyAEqualTo(String value) {
            addCriterion("PARTY_A =", value, "partyA");
            return (Criteria) this;
        }

        public Criteria andPartyANotEqualTo(String value) {
            addCriterion("PARTY_A <>", value, "partyA");
            return (Criteria) this;
        }

        public Criteria andPartyAGreaterThan(String value) {
            addCriterion("PARTY_A >", value, "partyA");
            return (Criteria) this;
        }

        public Criteria andPartyAGreaterThanOrEqualTo(String value) {
            addCriterion("PARTY_A >=", value, "partyA");
            return (Criteria) this;
        }

        public Criteria andPartyALessThan(String value) {
            addCriterion("PARTY_A <", value, "partyA");
            return (Criteria) this;
        }

        public Criteria andPartyALessThanOrEqualTo(String value) {
            addCriterion("PARTY_A <=", value, "partyA");
            return (Criteria) this;
        }

        public Criteria andPartyALike(String value) {
            addCriterion("PARTY_A like", value, "partyA");
            return (Criteria) this;
        }

        public Criteria andPartyANotLike(String value) {
            addCriterion("PARTY_A not like", value, "partyA");
            return (Criteria) this;
        }

        public Criteria andPartyAIn(List<String> values) {
            addCriterion("PARTY_A in", values, "partyA");
            return (Criteria) this;
        }

        public Criteria andPartyANotIn(List<String> values) {
            addCriterion("PARTY_A not in", values, "partyA");
            return (Criteria) this;
        }

        public Criteria andPartyABetween(String value1, String value2) {
            addCriterion("PARTY_A between", value1, value2, "partyA");
            return (Criteria) this;
        }

        public Criteria andPartyANotBetween(String value1, String value2) {
            addCriterion("PARTY_A not between", value1, value2, "partyA");
            return (Criteria) this;
        }

        public Criteria andPartyBIdIsNull() {
            addCriterion("PARTY_B_ID is null");
            return (Criteria) this;
        }

        public Criteria andPartyBIdIsNotNull() {
            addCriterion("PARTY_B_ID is not null");
            return (Criteria) this;
        }

        public Criteria andPartyBIdEqualTo(String value) {
            addCriterion("PARTY_B_ID =", value, "partyBId");
            return (Criteria) this;
        }

        public Criteria andPartyBIdNotEqualTo(String value) {
            addCriterion("PARTY_B_ID <>", value, "partyBId");
            return (Criteria) this;
        }

        public Criteria andPartyBIdGreaterThan(String value) {
            addCriterion("PARTY_B_ID >", value, "partyBId");
            return (Criteria) this;
        }

        public Criteria andPartyBIdGreaterThanOrEqualTo(String value) {
            addCriterion("PARTY_B_ID >=", value, "partyBId");
            return (Criteria) this;
        }

        public Criteria andPartyBIdLessThan(String value) {
            addCriterion("PARTY_B_ID <", value, "partyBId");
            return (Criteria) this;
        }

        public Criteria andPartyBIdLessThanOrEqualTo(String value) {
            addCriterion("PARTY_B_ID <=", value, "partyBId");
            return (Criteria) this;
        }

        public Criteria andPartyBIdLike(String value) {
            addCriterion("PARTY_B_ID like", value, "partyBId");
            return (Criteria) this;
        }

        public Criteria andPartyBIdNotLike(String value) {
            addCriterion("PARTY_B_ID not like", value, "partyBId");
            return (Criteria) this;
        }

        public Criteria andPartyBIdIn(List<String> values) {
            addCriterion("PARTY_B_ID in", values, "partyBId");
            return (Criteria) this;
        }
        
        public Criteria andNotPartyBIdIn() {
        	addCriterion("1 > 1");
        	return (Criteria) this;
        }

        public Criteria andPartyBIdNotIn(List<String> values) {
            addCriterion("PARTY_B_ID not in", values, "partyBId");
            return (Criteria) this;
        }

        public Criteria andPartyBIdBetween(String value1, String value2) {
            addCriterion("PARTY_B_ID between", value1, value2, "partyBId");
            return (Criteria) this;
        }

        public Criteria andPartyBIdNotBetween(String value1, String value2) {
            addCriterion("PARTY_B_ID not between", value1, value2, "partyBId");
            return (Criteria) this;
        }

        public Criteria andPartyBIsNull() {
            addCriterion("PARTY_B is null");
            return (Criteria) this;
        }

        public Criteria andPartyBIsNotNull() {
            addCriterion("PARTY_B is not null");
            return (Criteria) this;
        }

        public Criteria andPartyBEqualTo(String value) {
            addCriterion("PARTY_B =", value, "partyB");
            return (Criteria) this;
        }

        public Criteria andPartyBNotEqualTo(String value) {
            addCriterion("PARTY_B <>", value, "partyB");
            return (Criteria) this;
        }

        public Criteria andPartyBGreaterThan(String value) {
            addCriterion("PARTY_B >", value, "partyB");
            return (Criteria) this;
        }

        public Criteria andPartyBGreaterThanOrEqualTo(String value) {
            addCriterion("PARTY_B >=", value, "partyB");
            return (Criteria) this;
        }

        public Criteria andPartyBLessThan(String value) {
            addCriterion("PARTY_B <", value, "partyB");
            return (Criteria) this;
        }

        public Criteria andPartyBLessThanOrEqualTo(String value) {
            addCriterion("PARTY_B <=", value, "partyB");
            return (Criteria) this;
        }

        public Criteria andPartyBLike(String value) {
            addCriterion("PARTY_B like", value, "partyB");
            return (Criteria) this;
        }

        public Criteria andPartyBNotLike(String value) {
            addCriterion("PARTY_B not like", value, "partyB");
            return (Criteria) this;
        }

        public Criteria andPartyBIn(List<String> values) {
            addCriterion("PARTY_B in", values, "partyB");
            return (Criteria) this;
        }

        public Criteria andPartyBNotIn(List<String> values) {
            addCriterion("PARTY_B not in", values, "partyB");
            return (Criteria) this;
        }

        public Criteria andPartyBBetween(String value1, String value2) {
            addCriterion("PARTY_B between", value1, value2, "partyB");
            return (Criteria) this;
        }

        public Criteria andPartyBNotBetween(String value1, String value2) {
            addCriterion("PARTY_B not between", value1, value2, "partyB");
            return (Criteria) this;
        }

        public Criteria andSaleProvinceIsNull() {
            addCriterion("SALE_PROVINCE is null");
            return (Criteria) this;
        }

        public Criteria andSaleProvinceIsNotNull() {
            addCriterion("SALE_PROVINCE is not null");
            return (Criteria) this;
        }

        public Criteria andSaleProvinceEqualTo(String value) {
            addCriterion("SALE_PROVINCE =", value, "saleProvince");
            return (Criteria) this;
        }

        public Criteria andSaleProvinceNotEqualTo(String value) {
            addCriterion("SALE_PROVINCE <>", value, "saleProvince");
            return (Criteria) this;
        }

        public Criteria andSaleProvinceGreaterThan(String value) {
            addCriterion("SALE_PROVINCE >", value, "saleProvince");
            return (Criteria) this;
        }

        public Criteria andSaleProvinceGreaterThanOrEqualTo(String value) {
            addCriterion("SALE_PROVINCE >=", value, "saleProvince");
            return (Criteria) this;
        }

        public Criteria andSaleProvinceLessThan(String value) {
            addCriterion("SALE_PROVINCE <", value, "saleProvince");
            return (Criteria) this;
        }

        public Criteria andSaleProvinceLessThanOrEqualTo(String value) {
            addCriterion("SALE_PROVINCE <=", value, "saleProvince");
            return (Criteria) this;
        }

        public Criteria andSaleProvinceLike(String value) {
            addCriterion("SALE_PROVINCE like", value, "saleProvince");
            return (Criteria) this;
        }

        public Criteria andSaleProvinceNotLike(String value) {
            addCriterion("SALE_PROVINCE not like", value, "saleProvince");
            return (Criteria) this;
        }

        public Criteria andSaleProvinceIn(List<String> values) {
            addCriterion("SALE_PROVINCE in", values, "saleProvince");
            return (Criteria) this;
        }

        public Criteria andSaleProvinceNotIn(List<String> values) {
            addCriterion("SALE_PROVINCE not in", values, "saleProvince");
            return (Criteria) this;
        }

        public Criteria andSaleProvinceBetween(String value1, String value2) {
            addCriterion("SALE_PROVINCE between", value1, value2, "saleProvince");
            return (Criteria) this;
        }

        public Criteria andSaleProvinceNotBetween(String value1, String value2) {
            addCriterion("SALE_PROVINCE not between", value1, value2, "saleProvince");
            return (Criteria) this;
        }

        public Criteria andSaleCityIsNull() {
            addCriterion("SALE_CITY is null");
            return (Criteria) this;
        }

        public Criteria andSaleCityIsNotNull() {
            addCriterion("SALE_CITY is not null");
            return (Criteria) this;
        }

        public Criteria andSaleCityEqualTo(String value) {
            addCriterion("SALE_CITY =", value, "saleCity");
            return (Criteria) this;
        }

        public Criteria andSaleCityNotEqualTo(String value) {
            addCriterion("SALE_CITY <>", value, "saleCity");
            return (Criteria) this;
        }

        public Criteria andSaleCityGreaterThan(String value) {
            addCriterion("SALE_CITY >", value, "saleCity");
            return (Criteria) this;
        }

        public Criteria andSaleCityGreaterThanOrEqualTo(String value) {
            addCriterion("SALE_CITY >=", value, "saleCity");
            return (Criteria) this;
        }

        public Criteria andSaleCityLessThan(String value) {
            addCriterion("SALE_CITY <", value, "saleCity");
            return (Criteria) this;
        }

        public Criteria andSaleCityLessThanOrEqualTo(String value) {
            addCriterion("SALE_CITY <=", value, "saleCity");
            return (Criteria) this;
        }

        public Criteria andSaleCityLike(String value) {
            addCriterion("SALE_CITY like", value, "saleCity");
            return (Criteria) this;
        }

        public Criteria andSaleCityNotLike(String value) {
            addCriterion("SALE_CITY not like", value, "saleCity");
            return (Criteria) this;
        }

        public Criteria andSaleCityIn(List<String> values) {
            addCriterion("SALE_CITY in", values, "saleCity");
            return (Criteria) this;
        }

        public Criteria andSaleCityNotIn(List<String> values) {
            addCriterion("SALE_CITY not in", values, "saleCity");
            return (Criteria) this;
        }

        public Criteria andSaleCityBetween(String value1, String value2) {
            addCriterion("SALE_CITY between", value1, value2, "saleCity");
            return (Criteria) this;
        }

        public Criteria andSaleCityNotBetween(String value1, String value2) {
            addCriterion("SALE_CITY not between", value1, value2, "saleCity");
            return (Criteria) this;
        }

        public Criteria andSaleDistrictIsNull() {
            addCriterion("SALE_DISTRICT is null");
            return (Criteria) this;
        }

        public Criteria andSaleDistrictIsNotNull() {
            addCriterion("SALE_DISTRICT is not null");
            return (Criteria) this;
        }

        public Criteria andSaleDistrictEqualTo(String value) {
            addCriterion("SALE_DISTRICT =", value, "saleDistrict");
            return (Criteria) this;
        }

        public Criteria andSaleDistrictNotEqualTo(String value) {
            addCriterion("SALE_DISTRICT <>", value, "saleDistrict");
            return (Criteria) this;
        }

        public Criteria andSaleDistrictGreaterThan(String value) {
            addCriterion("SALE_DISTRICT >", value, "saleDistrict");
            return (Criteria) this;
        }

        public Criteria andSaleDistrictGreaterThanOrEqualTo(String value) {
            addCriterion("SALE_DISTRICT >=", value, "saleDistrict");
            return (Criteria) this;
        }

        public Criteria andSaleDistrictLessThan(String value) {
            addCriterion("SALE_DISTRICT <", value, "saleDistrict");
            return (Criteria) this;
        }

        public Criteria andSaleDistrictLessThanOrEqualTo(String value) {
            addCriterion("SALE_DISTRICT <=", value, "saleDistrict");
            return (Criteria) this;
        }

        public Criteria andSaleDistrictLike(String value) {
            addCriterion("SALE_DISTRICT like", value, "saleDistrict");
            return (Criteria) this;
        }

        public Criteria andSaleDistrictNotLike(String value) {
            addCriterion("SALE_DISTRICT not like", value, "saleDistrict");
            return (Criteria) this;
        }

        public Criteria andSaleDistrictIn(List<String> values) {
            addCriterion("SALE_DISTRICT in", values, "saleDistrict");
            return (Criteria) this;
        }

        public Criteria andSaleDistrictNotIn(List<String> values) {
            addCriterion("SALE_DISTRICT not in", values, "saleDistrict");
            return (Criteria) this;
        }

        public Criteria andSaleDistrictBetween(String value1, String value2) {
            addCriterion("SALE_DISTRICT between", value1, value2, "saleDistrict");
            return (Criteria) this;
        }

        public Criteria andSaleDistrictNotBetween(String value1, String value2) {
            addCriterion("SALE_DISTRICT not between", value1, value2, "saleDistrict");
            return (Criteria) this;
        }

        public Criteria andSaleProvinceCodeIsNull() {
            addCriterion("SALE_PROVINCE_CODE is null");
            return (Criteria) this;
        }

        public Criteria andSaleProvinceCodeIsNotNull() {
            addCriterion("SALE_PROVINCE_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andSaleProvinceCodeEqualTo(String value) {
            addCriterion("SALE_PROVINCE_CODE =", value, "saleProvinceCode");
            return (Criteria) this;
        }

        public Criteria andSaleProvinceCodeNotEqualTo(String value) {
            addCriterion("SALE_PROVINCE_CODE <>", value, "saleProvinceCode");
            return (Criteria) this;
        }

        public Criteria andSaleProvinceCodeGreaterThan(String value) {
            addCriterion("SALE_PROVINCE_CODE >", value, "saleProvinceCode");
            return (Criteria) this;
        }

        public Criteria andSaleProvinceCodeGreaterThanOrEqualTo(String value) {
            addCriterion("SALE_PROVINCE_CODE >=", value, "saleProvinceCode");
            return (Criteria) this;
        }

        public Criteria andSaleProvinceCodeLessThan(String value) {
            addCriterion("SALE_PROVINCE_CODE <", value, "saleProvinceCode");
            return (Criteria) this;
        }

        public Criteria andSaleProvinceCodeLessThanOrEqualTo(String value) {
            addCriterion("SALE_PROVINCE_CODE <=", value, "saleProvinceCode");
            return (Criteria) this;
        }

        public Criteria andSaleProvinceCodeLike(String value) {
            addCriterion("SALE_PROVINCE_CODE like", value, "saleProvinceCode");
            return (Criteria) this;
        }

        public Criteria andSaleProvinceCodeNotLike(String value) {
            addCriterion("SALE_PROVINCE_CODE not like", value, "saleProvinceCode");
            return (Criteria) this;
        }

        public Criteria andSaleProvinceCodeIn(List<String> values) {
            addCriterion("SALE_PROVINCE_CODE in", values, "saleProvinceCode");
            return (Criteria) this;
        }

        public Criteria andSaleProvinceCodeNotIn(List<String> values) {
            addCriterion("SALE_PROVINCE_CODE not in", values, "saleProvinceCode");
            return (Criteria) this;
        }

        public Criteria andSaleProvinceCodeBetween(String value1, String value2) {
            addCriterion("SALE_PROVINCE_CODE between", value1, value2, "saleProvinceCode");
            return (Criteria) this;
        }

        public Criteria andSaleProvinceCodeNotBetween(String value1, String value2) {
            addCriterion("SALE_PROVINCE_CODE not between", value1, value2, "saleProvinceCode");
            return (Criteria) this;
        }

        public Criteria andSaleCityCodeIsNull() {
            addCriterion("SALE_CITY_CODE is null");
            return (Criteria) this;
        }

        public Criteria andSaleCityCodeIsNotNull() {
            addCriterion("SALE_CITY_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andSaleCityCodeEqualTo(String value) {
            addCriterion("SALE_CITY_CODE =", value, "saleCityCode");
            return (Criteria) this;
        }

        public Criteria andSaleCityCodeNotEqualTo(String value) {
            addCriterion("SALE_CITY_CODE <>", value, "saleCityCode");
            return (Criteria) this;
        }

        public Criteria andSaleCityCodeGreaterThan(String value) {
            addCriterion("SALE_CITY_CODE >", value, "saleCityCode");
            return (Criteria) this;
        }

        public Criteria andSaleCityCodeGreaterThanOrEqualTo(String value) {
            addCriterion("SALE_CITY_CODE >=", value, "saleCityCode");
            return (Criteria) this;
        }

        public Criteria andSaleCityCodeLessThan(String value) {
            addCriterion("SALE_CITY_CODE <", value, "saleCityCode");
            return (Criteria) this;
        }

        public Criteria andSaleCityCodeLessThanOrEqualTo(String value) {
            addCriterion("SALE_CITY_CODE <=", value, "saleCityCode");
            return (Criteria) this;
        }

        public Criteria andSaleCityCodeLike(String value) {
            addCriterion("SALE_CITY_CODE like", value, "saleCityCode");
            return (Criteria) this;
        }

        public Criteria andSaleCityCodeNotLike(String value) {
            addCriterion("SALE_CITY_CODE not like", value, "saleCityCode");
            return (Criteria) this;
        }

        public Criteria andSaleCityCodeIn(List<String> values) {
            addCriterion("SALE_CITY_CODE in", values, "saleCityCode");
            return (Criteria) this;
        }

        public Criteria andSaleCityCodeNotIn(List<String> values) {
            addCriterion("SALE_CITY_CODE not in", values, "saleCityCode");
            return (Criteria) this;
        }

        public Criteria andSaleCityCodeBetween(String value1, String value2) {
            addCriterion("SALE_CITY_CODE between", value1, value2, "saleCityCode");
            return (Criteria) this;
        }

        public Criteria andSaleCityCodeNotBetween(String value1, String value2) {
            addCriterion("SALE_CITY_CODE not between", value1, value2, "saleCityCode");
            return (Criteria) this;
        }

        public Criteria andSaleDistrictCodeIsNull() {
            addCriterion("SALE_DISTRICT_CODE is null");
            return (Criteria) this;
        }

        public Criteria andSaleDistrictCodeIsNotNull() {
            addCriterion("SALE_DISTRICT_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andSaleDistrictCodeEqualTo(String value) {
            addCriterion("SALE_DISTRICT_CODE =", value, "saleDistrictCode");
            return (Criteria) this;
        }

        public Criteria andSaleDistrictCodeNotEqualTo(String value) {
            addCriterion("SALE_DISTRICT_CODE <>", value, "saleDistrictCode");
            return (Criteria) this;
        }

        public Criteria andSaleDistrictCodeGreaterThan(String value) {
            addCriterion("SALE_DISTRICT_CODE >", value, "saleDistrictCode");
            return (Criteria) this;
        }

        public Criteria andSaleDistrictCodeGreaterThanOrEqualTo(String value) {
            addCriterion("SALE_DISTRICT_CODE >=", value, "saleDistrictCode");
            return (Criteria) this;
        }

        public Criteria andSaleDistrictCodeLessThan(String value) {
            addCriterion("SALE_DISTRICT_CODE <", value, "saleDistrictCode");
            return (Criteria) this;
        }

        public Criteria andSaleDistrictCodeLessThanOrEqualTo(String value) {
            addCriterion("SALE_DISTRICT_CODE <=", value, "saleDistrictCode");
            return (Criteria) this;
        }

        public Criteria andSaleDistrictCodeLike(String value) {
            addCriterion("SALE_DISTRICT_CODE like", value, "saleDistrictCode");
            return (Criteria) this;
        }

        public Criteria andSaleDistrictCodeNotLike(String value) {
            addCriterion("SALE_DISTRICT_CODE not like", value, "saleDistrictCode");
            return (Criteria) this;
        }

        public Criteria andSaleDistrictCodeIn(List<String> values) {
            addCriterion("SALE_DISTRICT_CODE in", values, "saleDistrictCode");
            return (Criteria) this;
        }

        public Criteria andSaleDistrictCodeNotIn(List<String> values) {
            addCriterion("SALE_DISTRICT_CODE not in", values, "saleDistrictCode");
            return (Criteria) this;
        }

        public Criteria andSaleDistrictCodeBetween(String value1, String value2) {
            addCriterion("SALE_DISTRICT_CODE between", value1, value2, "saleDistrictCode");
            return (Criteria) this;
        }

        public Criteria andSaleDistrictCodeNotBetween(String value1, String value2) {
            addCriterion("SALE_DISTRICT_CODE not between", value1, value2, "saleDistrictCode");
            return (Criteria) this;
        }

        public Criteria andSaleChannelIsNull() {
            addCriterion("SALE_CHANNEL is null");
            return (Criteria) this;
        }

        public Criteria andSaleChannelIsNotNull() {
            addCriterion("SALE_CHANNEL is not null");
            return (Criteria) this;
        }

        public Criteria andSaleChannelEqualTo(String value) {
            addCriterion("SALE_CHANNEL =", value, "saleChannel");
            return (Criteria) this;
        }

        public Criteria andSaleChannelNotEqualTo(String value) {
            addCriterion("SALE_CHANNEL <>", value, "saleChannel");
            return (Criteria) this;
        }

        public Criteria andSaleChannelGreaterThan(String value) {
            addCriterion("SALE_CHANNEL >", value, "saleChannel");
            return (Criteria) this;
        }

        public Criteria andSaleChannelGreaterThanOrEqualTo(String value) {
            addCriterion("SALE_CHANNEL >=", value, "saleChannel");
            return (Criteria) this;
        }

        public Criteria andSaleChannelLessThan(String value) {
            addCriterion("SALE_CHANNEL <", value, "saleChannel");
            return (Criteria) this;
        }

        public Criteria andSaleChannelLessThanOrEqualTo(String value) {
            addCriterion("SALE_CHANNEL <=", value, "saleChannel");
            return (Criteria) this;
        }

        public Criteria andSaleChannelLike(String value) {
            addCriterion("SALE_CHANNEL like", value, "saleChannel");
            return (Criteria) this;
        }

        public Criteria andSaleChannelNotLike(String value) {
            addCriterion("SALE_CHANNEL not like", value, "saleChannel");
            return (Criteria) this;
        }

        public Criteria andSaleChannelIn(List<String> values) {
            addCriterion("SALE_CHANNEL in", values, "saleChannel");
            return (Criteria) this;
        }

        public Criteria andSaleChannelNotIn(List<String> values) {
            addCriterion("SALE_CHANNEL not in", values, "saleChannel");
            return (Criteria) this;
        }

        public Criteria andSaleChannelBetween(String value1, String value2) {
            addCriterion("SALE_CHANNEL between", value1, value2, "saleChannel");
            return (Criteria) this;
        }

        public Criteria andSaleChannelNotBetween(String value1, String value2) {
            addCriterion("SALE_CHANNEL not between", value1, value2, "saleChannel");
            return (Criteria) this;
        }

        public Criteria andYearRefundTargetIsNull() {
            addCriterion("YEAR_REFUND_TARGET is null");
            return (Criteria) this;
        }

        public Criteria andYearRefundTargetIsNotNull() {
            addCriterion("YEAR_REFUND_TARGET is not null");
            return (Criteria) this;
        }

        public Criteria andYearRefundTargetEqualTo(Double value) {
            addCriterion("YEAR_REFUND_TARGET =", value, "yearRefundTarget");
            return (Criteria) this;
        }

        public Criteria andYearRefundTargetNotEqualTo(Double value) {
            addCriterion("YEAR_REFUND_TARGET <>", value, "yearRefundTarget");
            return (Criteria) this;
        }

        public Criteria andYearRefundTargetGreaterThan(Double value) {
            addCriterion("YEAR_REFUND_TARGET >", value, "yearRefundTarget");
            return (Criteria) this;
        }

        public Criteria andYearRefundTargetGreaterThanOrEqualTo(Double value) {
            addCriterion("YEAR_REFUND_TARGET >=", value, "yearRefundTarget");
            return (Criteria) this;
        }

        public Criteria andYearRefundTargetLessThan(Double value) {
            addCriterion("YEAR_REFUND_TARGET <", value, "yearRefundTarget");
            return (Criteria) this;
        }

        public Criteria andYearRefundTargetLessThanOrEqualTo(Double value) {
            addCriterion("YEAR_REFUND_TARGET <=", value, "yearRefundTarget");
            return (Criteria) this;
        }

        public Criteria andYearRefundTargetIn(List<Double> values) {
            addCriterion("YEAR_REFUND_TARGET in", values, "yearRefundTarget");
            return (Criteria) this;
        }

        public Criteria andYearRefundTargetNotIn(List<Double> values) {
            addCriterion("YEAR_REFUND_TARGET not in", values, "yearRefundTarget");
            return (Criteria) this;
        }

        public Criteria andYearRefundTargetBetween(Double value1, Double value2) {
            addCriterion("YEAR_REFUND_TARGET between", value1, value2, "yearRefundTarget");
            return (Criteria) this;
        }

        public Criteria andYearRefundTargetNotBetween(Double value1, Double value2) {
            addCriterion("YEAR_REFUND_TARGET not between", value1, value2, "yearRefundTarget");
            return (Criteria) this;
        }

        public Criteria andFirstPayAmountIsNull() {
            addCriterion("FIRST_PAY_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andFirstPayAmountIsNotNull() {
            addCriterion("FIRST_PAY_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andFirstPayAmountEqualTo(Double value) {
            addCriterion("FIRST_PAY_AMOUNT =", value, "firstPayAmount");
            return (Criteria) this;
        }

        public Criteria andFirstPayAmountNotEqualTo(Double value) {
            addCriterion("FIRST_PAY_AMOUNT <>", value, "firstPayAmount");
            return (Criteria) this;
        }

        public Criteria andFirstPayAmountGreaterThan(Double value) {
            addCriterion("FIRST_PAY_AMOUNT >", value, "firstPayAmount");
            return (Criteria) this;
        }

        public Criteria andFirstPayAmountGreaterThanOrEqualTo(Double value) {
            addCriterion("FIRST_PAY_AMOUNT >=", value, "firstPayAmount");
            return (Criteria) this;
        }

        public Criteria andFirstPayAmountLessThan(Double value) {
            addCriterion("FIRST_PAY_AMOUNT <", value, "firstPayAmount");
            return (Criteria) this;
        }

        public Criteria andFirstPayAmountLessThanOrEqualTo(Double value) {
            addCriterion("FIRST_PAY_AMOUNT <=", value, "firstPayAmount");
            return (Criteria) this;
        }

        public Criteria andFirstPayAmountIn(List<Double> values) {
            addCriterion("FIRST_PAY_AMOUNT in", values, "firstPayAmount");
            return (Criteria) this;
        }

        public Criteria andFirstPayAmountNotIn(List<Double> values) {
            addCriterion("FIRST_PAY_AMOUNT not in", values, "firstPayAmount");
            return (Criteria) this;
        }

        public Criteria andFirstPayAmountBetween(Double value1, Double value2) {
            addCriterion("FIRST_PAY_AMOUNT between", value1, value2, "firstPayAmount");
            return (Criteria) this;
        }

        public Criteria andFirstPayAmountNotBetween(Double value1, Double value2) {
            addCriterion("FIRST_PAY_AMOUNT not between", value1, value2, "firstPayAmount");
            return (Criteria) this;
        }

        public Criteria andFirstReceiptDateIsNull() {
            addCriterion("FIRST_RECEIPT_DATE is null");
            return (Criteria) this;
        }

        public Criteria andFirstReceiptDateIsNotNull() {
            addCriterion("FIRST_RECEIPT_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andFirstReceiptDateEqualTo(Date value) {
            addCriterionForJDBCDate("FIRST_RECEIPT_DATE =", value, "firstReceiptDate");
            return (Criteria) this;
        }

        public Criteria andFirstReceiptDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("FIRST_RECEIPT_DATE <>", value, "firstReceiptDate");
            return (Criteria) this;
        }

        public Criteria andFirstReceiptDateGreaterThan(Date value) {
            addCriterionForJDBCDate("FIRST_RECEIPT_DATE >", value, "firstReceiptDate");
            return (Criteria) this;
        }

        public Criteria andFirstReceiptDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("FIRST_RECEIPT_DATE >=", value, "firstReceiptDate");
            return (Criteria) this;
        }

        public Criteria andFirstReceiptDateLessThan(Date value) {
            addCriterionForJDBCDate("FIRST_RECEIPT_DATE <", value, "firstReceiptDate");
            return (Criteria) this;
        }

        public Criteria andFirstReceiptDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("FIRST_RECEIPT_DATE <=", value, "firstReceiptDate");
            return (Criteria) this;
        }

        public Criteria andFirstReceiptDateIn(List<Date> values) {
            addCriterionForJDBCDate("FIRST_RECEIPT_DATE in", values, "firstReceiptDate");
            return (Criteria) this;
        }

        public Criteria andFirstReceiptDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("FIRST_RECEIPT_DATE not in", values, "firstReceiptDate");
            return (Criteria) this;
        }

        public Criteria andFirstReceiptDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("FIRST_RECEIPT_DATE between", value1, value2, "firstReceiptDate");
            return (Criteria) this;
        }

        public Criteria andFirstReceiptDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("FIRST_RECEIPT_DATE not between", value1, value2, "firstReceiptDate");
            return (Criteria) this;
        }

        public Criteria andPerOrderAmountIsNull() {
            addCriterion("PER_ORDER_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andPerOrderAmountIsNotNull() {
            addCriterion("PER_ORDER_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andPerOrderAmountEqualTo(Double value) {
            addCriterion("PER_ORDER_AMOUNT =", value, "perOrderAmount");
            return (Criteria) this;
        }

        public Criteria andPerOrderAmountNotEqualTo(Double value) {
            addCriterion("PER_ORDER_AMOUNT <>", value, "perOrderAmount");
            return (Criteria) this;
        }

        public Criteria andPerOrderAmountGreaterThan(Double value) {
            addCriterion("PER_ORDER_AMOUNT >", value, "perOrderAmount");
            return (Criteria) this;
        }

        public Criteria andPerOrderAmountGreaterThanOrEqualTo(Double value) {
            addCriterion("PER_ORDER_AMOUNT >=", value, "perOrderAmount");
            return (Criteria) this;
        }

        public Criteria andPerOrderAmountLessThan(Double value) {
            addCriterion("PER_ORDER_AMOUNT <", value, "perOrderAmount");
            return (Criteria) this;
        }

        public Criteria andPerOrderAmountLessThanOrEqualTo(Double value) {
            addCriterion("PER_ORDER_AMOUNT <=", value, "perOrderAmount");
            return (Criteria) this;
        }

        public Criteria andPerOrderAmountIn(List<Double> values) {
            addCriterion("PER_ORDER_AMOUNT in", values, "perOrderAmount");
            return (Criteria) this;
        }

        public Criteria andPerOrderAmountNotIn(List<Double> values) {
            addCriterion("PER_ORDER_AMOUNT not in", values, "perOrderAmount");
            return (Criteria) this;
        }

        public Criteria andPerOrderAmountBetween(Double value1, Double value2) {
            addCriterion("PER_ORDER_AMOUNT between", value1, value2, "perOrderAmount");
            return (Criteria) this;
        }

        public Criteria andPerOrderAmountNotBetween(Double value1, Double value2) {
            addCriterion("PER_ORDER_AMOUNT not between", value1, value2, "perOrderAmount");
            return (Criteria) this;
        }

        public Criteria andGoodsPaymentIsNull() {
            addCriterion("GOODS_PAYMENT is null");
            return (Criteria) this;
        }

        public Criteria andGoodsPaymentIsNotNull() {
            addCriterion("GOODS_PAYMENT is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsPaymentEqualTo(String value) {
            addCriterion("GOODS_PAYMENT =", value, "goodsPayment");
            return (Criteria) this;
        }

        public Criteria andGoodsPaymentNotEqualTo(String value) {
            addCriterion("GOODS_PAYMENT <>", value, "goodsPayment");
            return (Criteria) this;
        }

        public Criteria andGoodsPaymentGreaterThan(String value) {
            addCriterion("GOODS_PAYMENT >", value, "goodsPayment");
            return (Criteria) this;
        }

        public Criteria andGoodsPaymentGreaterThanOrEqualTo(String value) {
            addCriterion("GOODS_PAYMENT >=", value, "goodsPayment");
            return (Criteria) this;
        }

        public Criteria andGoodsPaymentLessThan(String value) {
            addCriterion("GOODS_PAYMENT <", value, "goodsPayment");
            return (Criteria) this;
        }

        public Criteria andGoodsPaymentLessThanOrEqualTo(String value) {
            addCriterion("GOODS_PAYMENT <=", value, "goodsPayment");
            return (Criteria) this;
        }

        public Criteria andGoodsPaymentLike(String value) {
            addCriterion("GOODS_PAYMENT like", value, "goodsPayment");
            return (Criteria) this;
        }

        public Criteria andGoodsPaymentNotLike(String value) {
            addCriterion("GOODS_PAYMENT not like", value, "goodsPayment");
            return (Criteria) this;
        }

        public Criteria andGoodsPaymentIn(List<String> values) {
            addCriterion("GOODS_PAYMENT in", values, "goodsPayment");
            return (Criteria) this;
        }

        public Criteria andGoodsPaymentNotIn(List<String> values) {
            addCriterion("GOODS_PAYMENT not in", values, "goodsPayment");
            return (Criteria) this;
        }

        public Criteria andGoodsPaymentBetween(String value1, String value2) {
            addCriterion("GOODS_PAYMENT between", value1, value2, "goodsPayment");
            return (Criteria) this;
        }

        public Criteria andGoodsPaymentNotBetween(String value1, String value2) {
            addCriterion("GOODS_PAYMENT not between", value1, value2, "goodsPayment");
            return (Criteria) this;
        }

        public Criteria andPayTypeIsNull() {
            addCriterion("PAY_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andPayTypeIsNotNull() {
            addCriterion("PAY_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andPayTypeEqualTo(String value) {
            addCriterion("PAY_TYPE =", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotEqualTo(String value) {
            addCriterion("PAY_TYPE <>", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeGreaterThan(String value) {
            addCriterion("PAY_TYPE >", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeGreaterThanOrEqualTo(String value) {
            addCriterion("PAY_TYPE >=", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeLessThan(String value) {
            addCriterion("PAY_TYPE <", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeLessThanOrEqualTo(String value) {
            addCriterion("PAY_TYPE <=", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeLike(String value) {
            addCriterion("PAY_TYPE like", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotLike(String value) {
            addCriterion("PAY_TYPE not like", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeIn(List<String> values) {
            addCriterion("PAY_TYPE in", values, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotIn(List<String> values) {
            addCriterion("PAY_TYPE not in", values, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeBetween(String value1, String value2) {
            addCriterion("PAY_TYPE between", value1, value2, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotBetween(String value1, String value2) {
            addCriterion("PAY_TYPE not between", value1, value2, "payType");
            return (Criteria) this;
        }

        public Criteria andPayeeIdIsNull() {
            addCriterion("PAYEE_ID is null");
            return (Criteria) this;
        }

        public Criteria andPayeeIdIsNotNull() {
            addCriterion("PAYEE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andPayeeIdEqualTo(String value) {
            addCriterion("PAYEE_ID =", value, "payeeId");
            return (Criteria) this;
        }

        public Criteria andPayeeIdNotEqualTo(String value) {
            addCriterion("PAYEE_ID <>", value, "payeeId");
            return (Criteria) this;
        }

        public Criteria andPayeeIdGreaterThan(String value) {
            addCriterion("PAYEE_ID >", value, "payeeId");
            return (Criteria) this;
        }

        public Criteria andPayeeIdGreaterThanOrEqualTo(String value) {
            addCriterion("PAYEE_ID >=", value, "payeeId");
            return (Criteria) this;
        }

        public Criteria andPayeeIdLessThan(String value) {
            addCriterion("PAYEE_ID <", value, "payeeId");
            return (Criteria) this;
        }

        public Criteria andPayeeIdLessThanOrEqualTo(String value) {
            addCriterion("PAYEE_ID <=", value, "payeeId");
            return (Criteria) this;
        }

        public Criteria andPayeeIdLike(String value) {
            addCriterion("PAYEE_ID like", value, "payeeId");
            return (Criteria) this;
        }

        public Criteria andPayeeIdNotLike(String value) {
            addCriterion("PAYEE_ID not like", value, "payeeId");
            return (Criteria) this;
        }

        public Criteria andPayeeIdIn(List<String> values) {
            addCriterion("PAYEE_ID in", values, "payeeId");
            return (Criteria) this;
        }

        public Criteria andPayeeIdNotIn(List<String> values) {
            addCriterion("PAYEE_ID not in", values, "payeeId");
            return (Criteria) this;
        }

        public Criteria andPayeeIdBetween(String value1, String value2) {
            addCriterion("PAYEE_ID between", value1, value2, "payeeId");
            return (Criteria) this;
        }

        public Criteria andPayeeIdNotBetween(String value1, String value2) {
            addCriterion("PAYEE_ID not between", value1, value2, "payeeId");
            return (Criteria) this;
        }

        public Criteria andPayeeNameIsNull() {
            addCriterion("PAYEE_NAME is null");
            return (Criteria) this;
        }

        public Criteria andPayeeNameIsNotNull() {
            addCriterion("PAYEE_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andPayeeNameEqualTo(String value) {
            addCriterion("PAYEE_NAME =", value, "payeeName");
            return (Criteria) this;
        }

        public Criteria andPayeeNameNotEqualTo(String value) {
            addCriterion("PAYEE_NAME <>", value, "payeeName");
            return (Criteria) this;
        }

        public Criteria andPayeeNameGreaterThan(String value) {
            addCriterion("PAYEE_NAME >", value, "payeeName");
            return (Criteria) this;
        }

        public Criteria andPayeeNameGreaterThanOrEqualTo(String value) {
            addCriterion("PAYEE_NAME >=", value, "payeeName");
            return (Criteria) this;
        }

        public Criteria andPayeeNameLessThan(String value) {
            addCriterion("PAYEE_NAME <", value, "payeeName");
            return (Criteria) this;
        }

        public Criteria andPayeeNameLessThanOrEqualTo(String value) {
            addCriterion("PAYEE_NAME <=", value, "payeeName");
            return (Criteria) this;
        }

        public Criteria andPayeeNameLike(String value) {
            addCriterion("PAYEE_NAME like", value, "payeeName");
            return (Criteria) this;
        }

        public Criteria andPayeeNameNotLike(String value) {
            addCriterion("PAYEE_NAME not like", value, "payeeName");
            return (Criteria) this;
        }

        public Criteria andPayeeNameIn(List<String> values) {
            addCriterion("PAYEE_NAME in", values, "payeeName");
            return (Criteria) this;
        }

        public Criteria andPayeeNameNotIn(List<String> values) {
            addCriterion("PAYEE_NAME not in", values, "payeeName");
            return (Criteria) this;
        }

        public Criteria andPayeeNameBetween(String value1, String value2) {
            addCriterion("PAYEE_NAME between", value1, value2, "payeeName");
            return (Criteria) this;
        }

        public Criteria andPayeeNameNotBetween(String value1, String value2) {
            addCriterion("PAYEE_NAME not between", value1, value2, "payeeName");
            return (Criteria) this;
        }

        public Criteria andBankTypeIsNull() {
            addCriterion("BANK_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andBankTypeIsNotNull() {
            addCriterion("BANK_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andBankTypeEqualTo(String value) {
            addCriterion("BANK_TYPE =", value, "bankType");
            return (Criteria) this;
        }

        public Criteria andBankTypeNotEqualTo(String value) {
            addCriterion("BANK_TYPE <>", value, "bankType");
            return (Criteria) this;
        }

        public Criteria andBankTypeGreaterThan(String value) {
            addCriterion("BANK_TYPE >", value, "bankType");
            return (Criteria) this;
        }

        public Criteria andBankTypeGreaterThanOrEqualTo(String value) {
            addCriterion("BANK_TYPE >=", value, "bankType");
            return (Criteria) this;
        }

        public Criteria andBankTypeLessThan(String value) {
            addCriterion("BANK_TYPE <", value, "bankType");
            return (Criteria) this;
        }

        public Criteria andBankTypeLessThanOrEqualTo(String value) {
            addCriterion("BANK_TYPE <=", value, "bankType");
            return (Criteria) this;
        }

        public Criteria andBankTypeLike(String value) {
            addCriterion("BANK_TYPE like", value, "bankType");
            return (Criteria) this;
        }

        public Criteria andBankTypeNotLike(String value) {
            addCriterion("BANK_TYPE not like", value, "bankType");
            return (Criteria) this;
        }

        public Criteria andBankTypeIn(List<String> values) {
            addCriterion("BANK_TYPE in", values, "bankType");
            return (Criteria) this;
        }

        public Criteria andBankTypeNotIn(List<String> values) {
            addCriterion("BANK_TYPE not in", values, "bankType");
            return (Criteria) this;
        }

        public Criteria andBankTypeBetween(String value1, String value2) {
            addCriterion("BANK_TYPE between", value1, value2, "bankType");
            return (Criteria) this;
        }

        public Criteria andBankTypeNotBetween(String value1, String value2) {
            addCriterion("BANK_TYPE not between", value1, value2, "bankType");
            return (Criteria) this;
        }

        public Criteria andBankNameIsNull() {
            addCriterion("BANK_NAME is null");
            return (Criteria) this;
        }

        public Criteria andBankNameIsNotNull() {
            addCriterion("BANK_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andBankNameEqualTo(String value) {
            addCriterion("BANK_NAME =", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameNotEqualTo(String value) {
            addCriterion("BANK_NAME <>", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameGreaterThan(String value) {
            addCriterion("BANK_NAME >", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameGreaterThanOrEqualTo(String value) {
            addCriterion("BANK_NAME >=", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameLessThan(String value) {
            addCriterion("BANK_NAME <", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameLessThanOrEqualTo(String value) {
            addCriterion("BANK_NAME <=", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameLike(String value) {
            addCriterion("BANK_NAME like", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameNotLike(String value) {
            addCriterion("BANK_NAME not like", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameIn(List<String> values) {
            addCriterion("BANK_NAME in", values, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameNotIn(List<String> values) {
            addCriterion("BANK_NAME not in", values, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameBetween(String value1, String value2) {
            addCriterion("BANK_NAME between", value1, value2, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameNotBetween(String value1, String value2) {
            addCriterion("BANK_NAME not between", value1, value2, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankAccountIsNull() {
            addCriterion("BANK_ACCOUNT is null");
            return (Criteria) this;
        }

        public Criteria andBankAccountIsNotNull() {
            addCriterion("BANK_ACCOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andBankAccountEqualTo(String value) {
            addCriterion("BANK_ACCOUNT =", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountNotEqualTo(String value) {
            addCriterion("BANK_ACCOUNT <>", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountGreaterThan(String value) {
            addCriterion("BANK_ACCOUNT >", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountGreaterThanOrEqualTo(String value) {
            addCriterion("BANK_ACCOUNT >=", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountLessThan(String value) {
            addCriterion("BANK_ACCOUNT <", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountLessThanOrEqualTo(String value) {
            addCriterion("BANK_ACCOUNT <=", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountLike(String value) {
            addCriterion("BANK_ACCOUNT like", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountNotLike(String value) {
            addCriterion("BANK_ACCOUNT not like", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountIn(List<String> values) {
            addCriterion("BANK_ACCOUNT in", values, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountNotIn(List<String> values) {
            addCriterion("BANK_ACCOUNT not in", values, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountBetween(String value1, String value2) {
            addCriterion("BANK_ACCOUNT between", value1, value2, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountNotBetween(String value1, String value2) {
            addCriterion("BANK_ACCOUNT not between", value1, value2, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andDeliveryAddressIsNull() {
            addCriterion("DELIVERY_ADDRESS is null");
            return (Criteria) this;
        }

        public Criteria andDeliveryAddressIsNotNull() {
            addCriterion("DELIVERY_ADDRESS is not null");
            return (Criteria) this;
        }

        public Criteria andDeliveryAddressEqualTo(String value) {
            addCriterion("DELIVERY_ADDRESS =", value, "deliveryAddress");
            return (Criteria) this;
        }

        public Criteria andDeliveryAddressNotEqualTo(String value) {
            addCriterion("DELIVERY_ADDRESS <>", value, "deliveryAddress");
            return (Criteria) this;
        }

        public Criteria andDeliveryAddressGreaterThan(String value) {
            addCriterion("DELIVERY_ADDRESS >", value, "deliveryAddress");
            return (Criteria) this;
        }

        public Criteria andDeliveryAddressGreaterThanOrEqualTo(String value) {
            addCriterion("DELIVERY_ADDRESS >=", value, "deliveryAddress");
            return (Criteria) this;
        }

        public Criteria andDeliveryAddressLessThan(String value) {
            addCriterion("DELIVERY_ADDRESS <", value, "deliveryAddress");
            return (Criteria) this;
        }

        public Criteria andDeliveryAddressLessThanOrEqualTo(String value) {
            addCriterion("DELIVERY_ADDRESS <=", value, "deliveryAddress");
            return (Criteria) this;
        }

        public Criteria andDeliveryAddressLike(String value) {
            addCriterion("DELIVERY_ADDRESS like", value, "deliveryAddress");
            return (Criteria) this;
        }

        public Criteria andDeliveryAddressNotLike(String value) {
            addCriterion("DELIVERY_ADDRESS not like", value, "deliveryAddress");
            return (Criteria) this;
        }

        public Criteria andDeliveryAddressIn(List<String> values) {
            addCriterion("DELIVERY_ADDRESS in", values, "deliveryAddress");
            return (Criteria) this;
        }

        public Criteria andDeliveryAddressNotIn(List<String> values) {
            addCriterion("DELIVERY_ADDRESS not in", values, "deliveryAddress");
            return (Criteria) this;
        }

        public Criteria andDeliveryAddressBetween(String value1, String value2) {
            addCriterion("DELIVERY_ADDRESS between", value1, value2, "deliveryAddress");
            return (Criteria) this;
        }

        public Criteria andDeliveryAddressNotBetween(String value1, String value2) {
            addCriterion("DELIVERY_ADDRESS not between", value1, value2, "deliveryAddress");
            return (Criteria) this;
        }

        public Criteria andReceiveAddressIsNull() {
            addCriterion("RECEIVE_ADDRESS is null");
            return (Criteria) this;
        }

        public Criteria andReceiveAddressIsNotNull() {
            addCriterion("RECEIVE_ADDRESS is not null");
            return (Criteria) this;
        }

        public Criteria andReceiveAddressEqualTo(String value) {
            addCriterion("RECEIVE_ADDRESS =", value, "receiveAddress");
            return (Criteria) this;
        }

        public Criteria andReceiveAddressNotEqualTo(String value) {
            addCriterion("RECEIVE_ADDRESS <>", value, "receiveAddress");
            return (Criteria) this;
        }

        public Criteria andReceiveAddressGreaterThan(String value) {
            addCriterion("RECEIVE_ADDRESS >", value, "receiveAddress");
            return (Criteria) this;
        }

        public Criteria andReceiveAddressGreaterThanOrEqualTo(String value) {
            addCriterion("RECEIVE_ADDRESS >=", value, "receiveAddress");
            return (Criteria) this;
        }

        public Criteria andReceiveAddressLessThan(String value) {
            addCriterion("RECEIVE_ADDRESS <", value, "receiveAddress");
            return (Criteria) this;
        }

        public Criteria andReceiveAddressLessThanOrEqualTo(String value) {
            addCriterion("RECEIVE_ADDRESS <=", value, "receiveAddress");
            return (Criteria) this;
        }

        public Criteria andReceiveAddressLike(String value) {
            addCriterion("RECEIVE_ADDRESS like", value, "receiveAddress");
            return (Criteria) this;
        }

        public Criteria andReceiveAddressNotLike(String value) {
            addCriterion("RECEIVE_ADDRESS not like", value, "receiveAddress");
            return (Criteria) this;
        }

        public Criteria andReceiveAddressIn(List<String> values) {
            addCriterion("RECEIVE_ADDRESS in", values, "receiveAddress");
            return (Criteria) this;
        }

        public Criteria andReceiveAddressNotIn(List<String> values) {
            addCriterion("RECEIVE_ADDRESS not in", values, "receiveAddress");
            return (Criteria) this;
        }

        public Criteria andReceiveAddressBetween(String value1, String value2) {
            addCriterion("RECEIVE_ADDRESS between", value1, value2, "receiveAddress");
            return (Criteria) this;
        }

        public Criteria andReceiveAddressNotBetween(String value1, String value2) {
            addCriterion("RECEIVE_ADDRESS not between", value1, value2, "receiveAddress");
            return (Criteria) this;
        }

        public Criteria andReceiveNameIsNull() {
            addCriterion("RECEIVE_NAME is null");
            return (Criteria) this;
        }

        public Criteria andReceiveNameIsNotNull() {
            addCriterion("RECEIVE_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andReceiveNameEqualTo(String value) {
            addCriterion("RECEIVE_NAME =", value, "receiveName");
            return (Criteria) this;
        }

        public Criteria andReceiveNameNotEqualTo(String value) {
            addCriterion("RECEIVE_NAME <>", value, "receiveName");
            return (Criteria) this;
        }

        public Criteria andReceiveNameGreaterThan(String value) {
            addCriterion("RECEIVE_NAME >", value, "receiveName");
            return (Criteria) this;
        }

        public Criteria andReceiveNameGreaterThanOrEqualTo(String value) {
            addCriterion("RECEIVE_NAME >=", value, "receiveName");
            return (Criteria) this;
        }

        public Criteria andReceiveNameLessThan(String value) {
            addCriterion("RECEIVE_NAME <", value, "receiveName");
            return (Criteria) this;
        }

        public Criteria andReceiveNameLessThanOrEqualTo(String value) {
            addCriterion("RECEIVE_NAME <=", value, "receiveName");
            return (Criteria) this;
        }

        public Criteria andReceiveNameLike(String value) {
            addCriterion("RECEIVE_NAME like", value, "receiveName");
            return (Criteria) this;
        }

        public Criteria andReceiveNameNotLike(String value) {
            addCriterion("RECEIVE_NAME not like", value, "receiveName");
            return (Criteria) this;
        }

        public Criteria andReceiveNameIn(List<String> values) {
            addCriterion("RECEIVE_NAME in", values, "receiveName");
            return (Criteria) this;
        }

        public Criteria andReceiveNameNotIn(List<String> values) {
            addCriterion("RECEIVE_NAME not in", values, "receiveName");
            return (Criteria) this;
        }

        public Criteria andReceiveNameBetween(String value1, String value2) {
            addCriterion("RECEIVE_NAME between", value1, value2, "receiveName");
            return (Criteria) this;
        }

        public Criteria andReceiveNameNotBetween(String value1, String value2) {
            addCriterion("RECEIVE_NAME not between", value1, value2, "receiveName");
            return (Criteria) this;
        }

        public Criteria andReceivePhoneIsNull() {
            addCriterion("RECEIVE_PHONE is null");
            return (Criteria) this;
        }

        public Criteria andReceivePhoneIsNotNull() {
            addCriterion("RECEIVE_PHONE is not null");
            return (Criteria) this;
        }

        public Criteria andReceivePhoneEqualTo(String value) {
            addCriterion("RECEIVE_PHONE =", value, "receivePhone");
            return (Criteria) this;
        }

        public Criteria andReceivePhoneNotEqualTo(String value) {
            addCriterion("RECEIVE_PHONE <>", value, "receivePhone");
            return (Criteria) this;
        }

        public Criteria andReceivePhoneGreaterThan(String value) {
            addCriterion("RECEIVE_PHONE >", value, "receivePhone");
            return (Criteria) this;
        }

        public Criteria andReceivePhoneGreaterThanOrEqualTo(String value) {
            addCriterion("RECEIVE_PHONE >=", value, "receivePhone");
            return (Criteria) this;
        }

        public Criteria andReceivePhoneLessThan(String value) {
            addCriterion("RECEIVE_PHONE <", value, "receivePhone");
            return (Criteria) this;
        }

        public Criteria andReceivePhoneLessThanOrEqualTo(String value) {
            addCriterion("RECEIVE_PHONE <=", value, "receivePhone");
            return (Criteria) this;
        }

        public Criteria andReceivePhoneLike(String value) {
            addCriterion("RECEIVE_PHONE like", value, "receivePhone");
            return (Criteria) this;
        }

        public Criteria andReceivePhoneNotLike(String value) {
            addCriterion("RECEIVE_PHONE not like", value, "receivePhone");
            return (Criteria) this;
        }

        public Criteria andReceivePhoneIn(List<String> values) {
            addCriterion("RECEIVE_PHONE in", values, "receivePhone");
            return (Criteria) this;
        }

        public Criteria andReceivePhoneNotIn(List<String> values) {
            addCriterion("RECEIVE_PHONE not in", values, "receivePhone");
            return (Criteria) this;
        }

        public Criteria andReceivePhoneBetween(String value1, String value2) {
            addCriterion("RECEIVE_PHONE between", value1, value2, "receivePhone");
            return (Criteria) this;
        }

        public Criteria andReceivePhoneNotBetween(String value1, String value2) {
            addCriterion("RECEIVE_PHONE not between", value1, value2, "receivePhone");
            return (Criteria) this;
        }

        public Criteria andFirstPenaltyIsNull() {
            addCriterion("FIRST_PENALTY is null");
            return (Criteria) this;
        }

        public Criteria andFirstPenaltyIsNotNull() {
            addCriterion("FIRST_PENALTY is not null");
            return (Criteria) this;
        }

        public Criteria andFirstPenaltyEqualTo(Integer value) {
            addCriterion("FIRST_PENALTY =", value, "firstPenalty");
            return (Criteria) this;
        }

        public Criteria andFirstPenaltyNotEqualTo(Integer value) {
            addCriterion("FIRST_PENALTY <>", value, "firstPenalty");
            return (Criteria) this;
        }

        public Criteria andFirstPenaltyGreaterThan(Integer value) {
            addCriterion("FIRST_PENALTY >", value, "firstPenalty");
            return (Criteria) this;
        }

        public Criteria andFirstPenaltyGreaterThanOrEqualTo(Integer value) {
            addCriterion("FIRST_PENALTY >=", value, "firstPenalty");
            return (Criteria) this;
        }

        public Criteria andFirstPenaltyLessThan(Integer value) {
            addCriterion("FIRST_PENALTY <", value, "firstPenalty");
            return (Criteria) this;
        }

        public Criteria andFirstPenaltyLessThanOrEqualTo(Integer value) {
            addCriterion("FIRST_PENALTY <=", value, "firstPenalty");
            return (Criteria) this;
        }

        public Criteria andFirstPenaltyIn(List<Integer> values) {
            addCriterion("FIRST_PENALTY in", values, "firstPenalty");
            return (Criteria) this;
        }

        public Criteria andFirstPenaltyNotIn(List<Integer> values) {
            addCriterion("FIRST_PENALTY not in", values, "firstPenalty");
            return (Criteria) this;
        }

        public Criteria andFirstPenaltyBetween(Integer value1, Integer value2) {
            addCriterion("FIRST_PENALTY between", value1, value2, "firstPenalty");
            return (Criteria) this;
        }

        public Criteria andFirstPenaltyNotBetween(Integer value1, Integer value2) {
            addCriterion("FIRST_PENALTY not between", value1, value2, "firstPenalty");
            return (Criteria) this;
        }

        public Criteria andSecondPenaltyIsNull() {
            addCriterion("SECOND_PENALTY is null");
            return (Criteria) this;
        }

        public Criteria andSecondPenaltyIsNotNull() {
            addCriterion("SECOND_PENALTY is not null");
            return (Criteria) this;
        }

        public Criteria andSecondPenaltyEqualTo(Integer value) {
            addCriterion("SECOND_PENALTY =", value, "secondPenalty");
            return (Criteria) this;
        }

        public Criteria andSecondPenaltyNotEqualTo(Integer value) {
            addCriterion("SECOND_PENALTY <>", value, "secondPenalty");
            return (Criteria) this;
        }

        public Criteria andSecondPenaltyGreaterThan(Integer value) {
            addCriterion("SECOND_PENALTY >", value, "secondPenalty");
            return (Criteria) this;
        }

        public Criteria andSecondPenaltyGreaterThanOrEqualTo(Integer value) {
            addCriterion("SECOND_PENALTY >=", value, "secondPenalty");
            return (Criteria) this;
        }

        public Criteria andSecondPenaltyLessThan(Integer value) {
            addCriterion("SECOND_PENALTY <", value, "secondPenalty");
            return (Criteria) this;
        }

        public Criteria andSecondPenaltyLessThanOrEqualTo(Integer value) {
            addCriterion("SECOND_PENALTY <=", value, "secondPenalty");
            return (Criteria) this;
        }

        public Criteria andSecondPenaltyIn(List<Integer> values) {
            addCriterion("SECOND_PENALTY in", values, "secondPenalty");
            return (Criteria) this;
        }

        public Criteria andSecondPenaltyNotIn(List<Integer> values) {
            addCriterion("SECOND_PENALTY not in", values, "secondPenalty");
            return (Criteria) this;
        }

        public Criteria andSecondPenaltyBetween(Integer value1, Integer value2) {
            addCriterion("SECOND_PENALTY between", value1, value2, "secondPenalty");
            return (Criteria) this;
        }

        public Criteria andSecondPenaltyNotBetween(Integer value1, Integer value2) {
            addCriterion("SECOND_PENALTY not between", value1, value2, "secondPenalty");
            return (Criteria) this;
        }

        public Criteria andMarketExpenseRateIsNull() {
            addCriterion("MARKET_EXPENSE_RATE is null");
            return (Criteria) this;
        }

        public Criteria andMarketExpenseRateIsNotNull() {
            addCriterion("MARKET_EXPENSE_RATE is not null");
            return (Criteria) this;
        }

        public Criteria andMarketExpenseRateEqualTo(Double value) {
            addCriterion("MARKET_EXPENSE_RATE =", value, "marketExpenseRate");
            return (Criteria) this;
        }

        public Criteria andMarketExpenseRateNotEqualTo(Double value) {
            addCriterion("MARKET_EXPENSE_RATE <>", value, "marketExpenseRate");
            return (Criteria) this;
        }

        public Criteria andMarketExpenseRateGreaterThan(Double value) {
            addCriterion("MARKET_EXPENSE_RATE >", value, "marketExpenseRate");
            return (Criteria) this;
        }

        public Criteria andMarketExpenseRateGreaterThanOrEqualTo(Double value) {
            addCriterion("MARKET_EXPENSE_RATE >=", value, "marketExpenseRate");
            return (Criteria) this;
        }

        public Criteria andMarketExpenseRateLessThan(Double value) {
            addCriterion("MARKET_EXPENSE_RATE <", value, "marketExpenseRate");
            return (Criteria) this;
        }

        public Criteria andMarketExpenseRateLessThanOrEqualTo(Double value) {
            addCriterion("MARKET_EXPENSE_RATE <=", value, "marketExpenseRate");
            return (Criteria) this;
        }

        public Criteria andMarketExpenseRateIn(List<Double> values) {
            addCriterion("MARKET_EXPENSE_RATE in", values, "marketExpenseRate");
            return (Criteria) this;
        }

        public Criteria andMarketExpenseRateNotIn(List<Double> values) {
            addCriterion("MARKET_EXPENSE_RATE not in", values, "marketExpenseRate");
            return (Criteria) this;
        }

        public Criteria andMarketExpenseRateBetween(Double value1, Double value2) {
            addCriterion("MARKET_EXPENSE_RATE between", value1, value2, "marketExpenseRate");
            return (Criteria) this;
        }

        public Criteria andMarketExpenseRateNotBetween(Double value1, Double value2) {
            addCriterion("MARKET_EXPENSE_RATE not between", value1, value2, "marketExpenseRate");
            return (Criteria) this;
        }

        public Criteria andRefundExchangeAddressIsNull() {
            addCriterion("REFUND_EXCHANGE_ADDRESS is null");
            return (Criteria) this;
        }

        public Criteria andRefundExchangeAddressIsNotNull() {
            addCriterion("REFUND_EXCHANGE_ADDRESS is not null");
            return (Criteria) this;
        }

        public Criteria andRefundExchangeAddressEqualTo(String value) {
            addCriterion("REFUND_EXCHANGE_ADDRESS =", value, "refundExchangeAddress");
            return (Criteria) this;
        }

        public Criteria andRefundExchangeAddressNotEqualTo(String value) {
            addCriterion("REFUND_EXCHANGE_ADDRESS <>", value, "refundExchangeAddress");
            return (Criteria) this;
        }

        public Criteria andRefundExchangeAddressGreaterThan(String value) {
            addCriterion("REFUND_EXCHANGE_ADDRESS >", value, "refundExchangeAddress");
            return (Criteria) this;
        }

        public Criteria andRefundExchangeAddressGreaterThanOrEqualTo(String value) {
            addCriterion("REFUND_EXCHANGE_ADDRESS >=", value, "refundExchangeAddress");
            return (Criteria) this;
        }

        public Criteria andRefundExchangeAddressLessThan(String value) {
            addCriterion("REFUND_EXCHANGE_ADDRESS <", value, "refundExchangeAddress");
            return (Criteria) this;
        }

        public Criteria andRefundExchangeAddressLessThanOrEqualTo(String value) {
            addCriterion("REFUND_EXCHANGE_ADDRESS <=", value, "refundExchangeAddress");
            return (Criteria) this;
        }

        public Criteria andRefundExchangeAddressLike(String value) {
            addCriterion("REFUND_EXCHANGE_ADDRESS like", value, "refundExchangeAddress");
            return (Criteria) this;
        }

        public Criteria andRefundExchangeAddressNotLike(String value) {
            addCriterion("REFUND_EXCHANGE_ADDRESS not like", value, "refundExchangeAddress");
            return (Criteria) this;
        }

        public Criteria andRefundExchangeAddressIn(List<String> values) {
            addCriterion("REFUND_EXCHANGE_ADDRESS in", values, "refundExchangeAddress");
            return (Criteria) this;
        }

        public Criteria andRefundExchangeAddressNotIn(List<String> values) {
            addCriterion("REFUND_EXCHANGE_ADDRESS not in", values, "refundExchangeAddress");
            return (Criteria) this;
        }

        public Criteria andRefundExchangeAddressBetween(String value1, String value2) {
            addCriterion("REFUND_EXCHANGE_ADDRESS between", value1, value2, "refundExchangeAddress");
            return (Criteria) this;
        }

        public Criteria andRefundExchangeAddressNotBetween(String value1, String value2) {
            addCriterion("REFUND_EXCHANGE_ADDRESS not between", value1, value2, "refundExchangeAddress");
            return (Criteria) this;
        }

        public Criteria andRefundExchangeNameIsNull() {
            addCriterion("REFUND_EXCHANGE_NAME is null");
            return (Criteria) this;
        }

        public Criteria andRefundExchangeNameIsNotNull() {
            addCriterion("REFUND_EXCHANGE_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andRefundExchangeNameEqualTo(String value) {
            addCriterion("REFUND_EXCHANGE_NAME =", value, "refundExchangeName");
            return (Criteria) this;
        }

        public Criteria andRefundExchangeNameNotEqualTo(String value) {
            addCriterion("REFUND_EXCHANGE_NAME <>", value, "refundExchangeName");
            return (Criteria) this;
        }

        public Criteria andRefundExchangeNameGreaterThan(String value) {
            addCriterion("REFUND_EXCHANGE_NAME >", value, "refundExchangeName");
            return (Criteria) this;
        }

        public Criteria andRefundExchangeNameGreaterThanOrEqualTo(String value) {
            addCriterion("REFUND_EXCHANGE_NAME >=", value, "refundExchangeName");
            return (Criteria) this;
        }

        public Criteria andRefundExchangeNameLessThan(String value) {
            addCriterion("REFUND_EXCHANGE_NAME <", value, "refundExchangeName");
            return (Criteria) this;
        }

        public Criteria andRefundExchangeNameLessThanOrEqualTo(String value) {
            addCriterion("REFUND_EXCHANGE_NAME <=", value, "refundExchangeName");
            return (Criteria) this;
        }

        public Criteria andRefundExchangeNameLike(String value) {
            addCriterion("REFUND_EXCHANGE_NAME like", value, "refundExchangeName");
            return (Criteria) this;
        }

        public Criteria andRefundExchangeNameNotLike(String value) {
            addCriterion("REFUND_EXCHANGE_NAME not like", value, "refundExchangeName");
            return (Criteria) this;
        }

        public Criteria andRefundExchangeNameIn(List<String> values) {
            addCriterion("REFUND_EXCHANGE_NAME in", values, "refundExchangeName");
            return (Criteria) this;
        }

        public Criteria andRefundExchangeNameNotIn(List<String> values) {
            addCriterion("REFUND_EXCHANGE_NAME not in", values, "refundExchangeName");
            return (Criteria) this;
        }

        public Criteria andRefundExchangeNameBetween(String value1, String value2) {
            addCriterion("REFUND_EXCHANGE_NAME between", value1, value2, "refundExchangeName");
            return (Criteria) this;
        }

        public Criteria andRefundExchangeNameNotBetween(String value1, String value2) {
            addCriterion("REFUND_EXCHANGE_NAME not between", value1, value2, "refundExchangeName");
            return (Criteria) this;
        }

        public Criteria andRefundExchangePhoneIsNull() {
            addCriterion("REFUND_EXCHANGE_PHONE is null");
            return (Criteria) this;
        }

        public Criteria andRefundExchangePhoneIsNotNull() {
            addCriterion("REFUND_EXCHANGE_PHONE is not null");
            return (Criteria) this;
        }

        public Criteria andRefundExchangePhoneEqualTo(String value) {
            addCriterion("REFUND_EXCHANGE_PHONE =", value, "refundExchangePhone");
            return (Criteria) this;
        }

        public Criteria andRefundExchangePhoneNotEqualTo(String value) {
            addCriterion("REFUND_EXCHANGE_PHONE <>", value, "refundExchangePhone");
            return (Criteria) this;
        }

        public Criteria andRefundExchangePhoneGreaterThan(String value) {
            addCriterion("REFUND_EXCHANGE_PHONE >", value, "refundExchangePhone");
            return (Criteria) this;
        }

        public Criteria andRefundExchangePhoneGreaterThanOrEqualTo(String value) {
            addCriterion("REFUND_EXCHANGE_PHONE >=", value, "refundExchangePhone");
            return (Criteria) this;
        }

        public Criteria andRefundExchangePhoneLessThan(String value) {
            addCriterion("REFUND_EXCHANGE_PHONE <", value, "refundExchangePhone");
            return (Criteria) this;
        }

        public Criteria andRefundExchangePhoneLessThanOrEqualTo(String value) {
            addCriterion("REFUND_EXCHANGE_PHONE <=", value, "refundExchangePhone");
            return (Criteria) this;
        }

        public Criteria andRefundExchangePhoneLike(String value) {
            addCriterion("REFUND_EXCHANGE_PHONE like", value, "refundExchangePhone");
            return (Criteria) this;
        }

        public Criteria andRefundExchangePhoneNotLike(String value) {
            addCriterion("REFUND_EXCHANGE_PHONE not like", value, "refundExchangePhone");
            return (Criteria) this;
        }

        public Criteria andRefundExchangePhoneIn(List<String> values) {
            addCriterion("REFUND_EXCHANGE_PHONE in", values, "refundExchangePhone");
            return (Criteria) this;
        }

        public Criteria andRefundExchangePhoneNotIn(List<String> values) {
            addCriterion("REFUND_EXCHANGE_PHONE not in", values, "refundExchangePhone");
            return (Criteria) this;
        }

        public Criteria andRefundExchangePhoneBetween(String value1, String value2) {
            addCriterion("REFUND_EXCHANGE_PHONE between", value1, value2, "refundExchangePhone");
            return (Criteria) this;
        }

        public Criteria andRefundExchangePhoneNotBetween(String value1, String value2) {
            addCriterion("REFUND_EXCHANGE_PHONE not between", value1, value2, "refundExchangePhone");
            return (Criteria) this;
        }

        public Criteria andRefundExchangeLimitRateIsNull() {
            addCriterion("REFUND_EXCHANGE_LIMIT_RATE is null");
            return (Criteria) this;
        }

        public Criteria andRefundExchangeLimitRateIsNotNull() {
            addCriterion("REFUND_EXCHANGE_LIMIT_RATE is not null");
            return (Criteria) this;
        }

        public Criteria andRefundExchangeLimitRateEqualTo(Double value) {
            addCriterion("REFUND_EXCHANGE_LIMIT_RATE =", value, "refundExchangeLimitRate");
            return (Criteria) this;
        }

        public Criteria andRefundExchangeLimitRateNotEqualTo(Double value) {
            addCriterion("REFUND_EXCHANGE_LIMIT_RATE <>", value, "refundExchangeLimitRate");
            return (Criteria) this;
        }

        public Criteria andRefundExchangeLimitRateGreaterThan(Double value) {
            addCriterion("REFUND_EXCHANGE_LIMIT_RATE >", value, "refundExchangeLimitRate");
            return (Criteria) this;
        }

        public Criteria andRefundExchangeLimitRateGreaterThanOrEqualTo(Double value) {
            addCriterion("REFUND_EXCHANGE_LIMIT_RATE >=", value, "refundExchangeLimitRate");
            return (Criteria) this;
        }

        public Criteria andRefundExchangeLimitRateLessThan(Double value) {
            addCriterion("REFUND_EXCHANGE_LIMIT_RATE <", value, "refundExchangeLimitRate");
            return (Criteria) this;
        }

        public Criteria andRefundExchangeLimitRateLessThanOrEqualTo(Double value) {
            addCriterion("REFUND_EXCHANGE_LIMIT_RATE <=", value, "refundExchangeLimitRate");
            return (Criteria) this;
        }

        public Criteria andRefundExchangeLimitRateIn(List<Double> values) {
            addCriterion("REFUND_EXCHANGE_LIMIT_RATE in", values, "refundExchangeLimitRate");
            return (Criteria) this;
        }

        public Criteria andRefundExchangeLimitRateNotIn(List<Double> values) {
            addCriterion("REFUND_EXCHANGE_LIMIT_RATE not in", values, "refundExchangeLimitRate");
            return (Criteria) this;
        }

        public Criteria andRefundExchangeLimitRateBetween(Double value1, Double value2) {
            addCriterion("REFUND_EXCHANGE_LIMIT_RATE between", value1, value2, "refundExchangeLimitRate");
            return (Criteria) this;
        }

        public Criteria andRefundExchangeLimitRateNotBetween(Double value1, Double value2) {
            addCriterion("REFUND_EXCHANGE_LIMIT_RATE not between", value1, value2, "refundExchangeLimitRate");
            return (Criteria) this;
        }

        public Criteria andRefundExchangeExceedRateIsNull() {
            addCriterion("REFUND_EXCHANGE_EXCEED_RATE is null");
            return (Criteria) this;
        }

        public Criteria andRefundExchangeExceedRateIsNotNull() {
            addCriterion("REFUND_EXCHANGE_EXCEED_RATE is not null");
            return (Criteria) this;
        }

        public Criteria andRefundExchangeExceedRateEqualTo(Double value) {
            addCriterion("REFUND_EXCHANGE_EXCEED_RATE =", value, "refundExchangeExceedRate");
            return (Criteria) this;
        }

        public Criteria andRefundExchangeExceedRateNotEqualTo(Double value) {
            addCriterion("REFUND_EXCHANGE_EXCEED_RATE <>", value, "refundExchangeExceedRate");
            return (Criteria) this;
        }

        public Criteria andRefundExchangeExceedRateGreaterThan(Double value) {
            addCriterion("REFUND_EXCHANGE_EXCEED_RATE >", value, "refundExchangeExceedRate");
            return (Criteria) this;
        }

        public Criteria andRefundExchangeExceedRateGreaterThanOrEqualTo(Double value) {
            addCriterion("REFUND_EXCHANGE_EXCEED_RATE >=", value, "refundExchangeExceedRate");
            return (Criteria) this;
        }

        public Criteria andRefundExchangeExceedRateLessThan(Double value) {
            addCriterion("REFUND_EXCHANGE_EXCEED_RATE <", value, "refundExchangeExceedRate");
            return (Criteria) this;
        }

        public Criteria andRefundExchangeExceedRateLessThanOrEqualTo(Double value) {
            addCriterion("REFUND_EXCHANGE_EXCEED_RATE <=", value, "refundExchangeExceedRate");
            return (Criteria) this;
        }

        public Criteria andRefundExchangeExceedRateIn(List<Double> values) {
            addCriterion("REFUND_EXCHANGE_EXCEED_RATE in", values, "refundExchangeExceedRate");
            return (Criteria) this;
        }

        public Criteria andRefundExchangeExceedRateNotIn(List<Double> values) {
            addCriterion("REFUND_EXCHANGE_EXCEED_RATE not in", values, "refundExchangeExceedRate");
            return (Criteria) this;
        }

        public Criteria andRefundExchangeExceedRateBetween(Double value1, Double value2) {
            addCriterion("REFUND_EXCHANGE_EXCEED_RATE between", value1, value2, "refundExchangeExceedRate");
            return (Criteria) this;
        }

        public Criteria andRefundExchangeExceedRateNotBetween(Double value1, Double value2) {
            addCriterion("REFUND_EXCHANGE_EXCEED_RATE not between", value1, value2, "refundExchangeExceedRate");
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