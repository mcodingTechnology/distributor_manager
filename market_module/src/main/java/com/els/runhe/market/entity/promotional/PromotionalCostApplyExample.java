package com.els.runhe.market.entity.promotional;

import com.els.base.core.entity.AbstractExample;
import com.els.base.core.entity.PageView;
import com.els.runhe.market.entity.promotional.PromotionalCostApplyExample.Criteria;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PromotionalCostApplyExample extends AbstractExample<PromotionalCostApply> implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected PageView<PromotionalCostApply> pageView = new PageView<PromotionalCostApply>(1, 10);

    private static final long serialVersionUID = 1L;

    public PromotionalCostApplyExample() {
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
    public PageView<PromotionalCostApply> getPageView() {
        return pageView;
    }

    @Override
    public void setPageView(PageView<PromotionalCostApply> pageView) {
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

        public Criteria andPromotionalCostNoIsNull() {
            addCriterion("promotional_cost_no is null");
            return (Criteria) this;
        }

        public Criteria andPromotionalCostNoIsNotNull() {
            addCriterion("promotional_cost_no is not null");
            return (Criteria) this;
        }

        public Criteria andPromotionalCostNoEqualTo(String value) {
            addCriterion("promotional_cost_no =", value, "promotionalCostNo");
            return (Criteria) this;
        }

        public Criteria andPromotionalCostNoNotEqualTo(String value) {
            addCriterion("promotional_cost_no <>", value, "promotionalCostNo");
            return (Criteria) this;
        }

        public Criteria andPromotionalCostNoGreaterThan(String value) {
            addCriterion("promotional_cost_no >", value, "promotionalCostNo");
            return (Criteria) this;
        }

        public Criteria andPromotionalCostNoGreaterThanOrEqualTo(String value) {
            addCriterion("promotional_cost_no >=", value, "promotionalCostNo");
            return (Criteria) this;
        }

        public Criteria andPromotionalCostNoLessThan(String value) {
            addCriterion("promotional_cost_no <", value, "promotionalCostNo");
            return (Criteria) this;
        }

        public Criteria andPromotionalCostNoLessThanOrEqualTo(String value) {
            addCriterion("promotional_cost_no <=", value, "promotionalCostNo");
            return (Criteria) this;
        }

        public Criteria andPromotionalCostNoLike(String value) {
            addCriterion("promotional_cost_no like", value, "promotionalCostNo");
            return (Criteria) this;
        }

        public Criteria andPromotionalCostNoNotLike(String value) {
            addCriterion("promotional_cost_no not like", value, "promotionalCostNo");
            return (Criteria) this;
        }

        public Criteria andPromotionalCostNoIn(List<String> values) {
            addCriterion("promotional_cost_no in", values, "promotionalCostNo");
            return (Criteria) this;
        }

        public Criteria andPromotionalCostNoNotIn(List<String> values) {
            addCriterion("promotional_cost_no not in", values, "promotionalCostNo");
            return (Criteria) this;
        }

        public Criteria andPromotionalCostNoBetween(String value1, String value2) {
            addCriterion("promotional_cost_no between", value1, value2, "promotionalCostNo");
            return (Criteria) this;
        }

        public Criteria andPromotionalCostNoNotBetween(String value1, String value2) {
            addCriterion("promotional_cost_no not between", value1, value2, "promotionalCostNo");
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

        public Criteria andDistrictIsNull() {
            addCriterion("district is null");
            return (Criteria) this;
        }

        public Criteria andDistrictIsNotNull() {
            addCriterion("district is not null");
            return (Criteria) this;
        }

        public Criteria andDistrictEqualTo(String value) {
            addCriterion("district =", value, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictNotEqualTo(String value) {
            addCriterion("district <>", value, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictGreaterThan(String value) {
            addCriterion("district >", value, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictGreaterThanOrEqualTo(String value) {
            addCriterion("district >=", value, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictLessThan(String value) {
            addCriterion("district <", value, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictLessThanOrEqualTo(String value) {
            addCriterion("district <=", value, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictLike(String value) {
            addCriterion("district like", value, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictNotLike(String value) {
            addCriterion("district not like", value, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictIn(List<String> values) {
            addCriterion("district in", values, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictNotIn(List<String> values) {
            addCriterion("district not in", values, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictBetween(String value1, String value2) {
            addCriterion("district between", value1, value2, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictNotBetween(String value1, String value2) {
            addCriterion("district not between", value1, value2, "district");
            return (Criteria) this;
        }

        public Criteria andProvinceIsNull() {
            addCriterion("province is null");
            return (Criteria) this;
        }

        public Criteria andProvinceIsNotNull() {
            addCriterion("province is not null");
            return (Criteria) this;
        }

        public Criteria andProvinceEqualTo(String value) {
            addCriterion("province =", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotEqualTo(String value) {
            addCriterion("province <>", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceGreaterThan(String value) {
            addCriterion("province >", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceGreaterThanOrEqualTo(String value) {
            addCriterion("province >=", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLessThan(String value) {
            addCriterion("province <", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLessThanOrEqualTo(String value) {
            addCriterion("province <=", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLike(String value) {
            addCriterion("province like", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotLike(String value) {
            addCriterion("province not like", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceIn(List<String> values) {
            addCriterion("province in", values, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotIn(List<String> values) {
            addCriterion("province not in", values, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceBetween(String value1, String value2) {
            addCriterion("province between", value1, value2, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotBetween(String value1, String value2) {
            addCriterion("province not between", value1, value2, "province");
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

        public Criteria andAreaManagerIsNull() {
            addCriterion("area_manager is null");
            return (Criteria) this;
        }

        public Criteria andAreaManagerIsNotNull() {
            addCriterion("area_manager is not null");
            return (Criteria) this;
        }

        public Criteria andAreaManagerEqualTo(String value) {
            addCriterion("area_manager =", value, "areaManager");
            return (Criteria) this;
        }

        public Criteria andAreaManagerNotEqualTo(String value) {
            addCriterion("area_manager <>", value, "areaManager");
            return (Criteria) this;
        }

        public Criteria andAreaManagerGreaterThan(String value) {
            addCriterion("area_manager >", value, "areaManager");
            return (Criteria) this;
        }

        public Criteria andAreaManagerGreaterThanOrEqualTo(String value) {
            addCriterion("area_manager >=", value, "areaManager");
            return (Criteria) this;
        }

        public Criteria andAreaManagerLessThan(String value) {
            addCriterion("area_manager <", value, "areaManager");
            return (Criteria) this;
        }

        public Criteria andAreaManagerLessThanOrEqualTo(String value) {
            addCriterion("area_manager <=", value, "areaManager");
            return (Criteria) this;
        }

        public Criteria andAreaManagerLike(String value) {
            addCriterion("area_manager like", value, "areaManager");
            return (Criteria) this;
        }

        public Criteria andAreaManagerNotLike(String value) {
            addCriterion("area_manager not like", value, "areaManager");
            return (Criteria) this;
        }

        public Criteria andAreaManagerIn(List<String> values) {
            addCriterion("area_manager in", values, "areaManager");
            return (Criteria) this;
        }

        public Criteria andAreaManagerNotIn(List<String> values) {
            addCriterion("area_manager not in", values, "areaManager");
            return (Criteria) this;
        }

        public Criteria andAreaManagerBetween(String value1, String value2) {
            addCriterion("area_manager between", value1, value2, "areaManager");
            return (Criteria) this;
        }

        public Criteria andAreaManagerNotBetween(String value1, String value2) {
            addCriterion("area_manager not between", value1, value2, "areaManager");
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

        public Criteria andContactIsNull() {
            addCriterion("contact is null");
            return (Criteria) this;
        }

        public Criteria andContactIsNotNull() {
            addCriterion("contact is not null");
            return (Criteria) this;
        }

        public Criteria andContactEqualTo(String value) {
            addCriterion("contact =", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactNotEqualTo(String value) {
            addCriterion("contact <>", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactGreaterThan(String value) {
            addCriterion("contact >", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactGreaterThanOrEqualTo(String value) {
            addCriterion("contact >=", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactLessThan(String value) {
            addCriterion("contact <", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactLessThanOrEqualTo(String value) {
            addCriterion("contact <=", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactLike(String value) {
            addCriterion("contact like", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactNotLike(String value) {
            addCriterion("contact not like", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactIn(List<String> values) {
            addCriterion("contact in", values, "contact");
            return (Criteria) this;
        }

        public Criteria andContactNotIn(List<String> values) {
            addCriterion("contact not in", values, "contact");
            return (Criteria) this;
        }

        public Criteria andContactBetween(String value1, String value2) {
            addCriterion("contact between", value1, value2, "contact");
            return (Criteria) this;
        }

        public Criteria andContactNotBetween(String value1, String value2) {
            addCriterion("contact not between", value1, value2, "contact");
            return (Criteria) this;
        }
        
        
        public Criteria andCostTypeIsNull() {
            addCriterion("cost_type is null");
            return (Criteria) this;
        }

        public Criteria andCostTypeIsNotNull() {
            addCriterion("cost_type is not null");
            return (Criteria) this;
        }

        public Criteria andCostTypeEqualTo(String value) {
            addCriterion("cost_type =", value, "costType");
            return (Criteria) this;
        }

        public Criteria andCostTypeNotEqualTo(String value) {
            addCriterion("cost_type <>", value, "costType");
            return (Criteria) this;
        }

        public Criteria andCostTypeGreaterThan(String value) {
            addCriterion("cost_type >", value, "costType");
            return (Criteria) this;
        }

        public Criteria andCostTypeGreaterThanOrEqualTo(String value) {
            addCriterion("cost_type >=", value, "costType");
            return (Criteria) this;
        }

        public Criteria andCostTypeLessThan(String value) {
            addCriterion("cost_type <", value, "costType");
            return (Criteria) this;
        }

        public Criteria andCostTypeLessThanOrEqualTo(String value) {
            addCriterion("cost_type <=", value, "costType");
            return (Criteria) this;
        }

        public Criteria andCostTypeLike(String value) {
            addCriterion("cost_type like", value, "costType");
            return (Criteria) this;
        }

        public Criteria andCostTypeNotLike(String value) {
            addCriterion("cost_type not like", value, "costType");
            return (Criteria) this;
        }

        public Criteria andCostTypeIn(List<String> values) {
            addCriterion("cost_type in", values, "costType");
            return (Criteria) this;
        }

        public Criteria andCostTypeNotIn(List<String> values) {
            addCriterion("cost_type not in", values, "costType");
            return (Criteria) this;
        }

        public Criteria andCostTypeBetween(String value1, String value2) {
            addCriterion("cost_type between", value1, value2, "costType");
            return (Criteria) this;
        }

        public Criteria andCostTypeNotBetween(String value1, String value2) {
            addCriterion("cost_type not between", value1, value2, "costType");
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

        public Criteria andStoreNumsIsNull() {
            addCriterion("store_nums is null");
            return (Criteria) this;
        }

        public Criteria andStoreNumsIsNotNull() {
            addCriterion("store_nums is not null");
            return (Criteria) this;
        }

        public Criteria andStoreNumsEqualTo(Integer value) {
            addCriterion("store_nums =", value, "storeNums");
            return (Criteria) this;
        }

        public Criteria andStoreNumsNotEqualTo(Integer value) {
            addCriterion("store_nums <>", value, "storeNums");
            return (Criteria) this;
        }

        public Criteria andStoreNumsGreaterThan(Integer value) {
            addCriterion("store_nums >", value, "storeNums");
            return (Criteria) this;
        }

        public Criteria andStoreNumsGreaterThanOrEqualTo(Integer value) {
            addCriterion("store_nums >=", value, "storeNums");
            return (Criteria) this;
        }

        public Criteria andStoreNumsLessThan(Integer value) {
            addCriterion("store_nums <", value, "storeNums");
            return (Criteria) this;
        }

        public Criteria andStoreNumsLessThanOrEqualTo(Integer value) {
            addCriterion("store_nums <=", value, "storeNums");
            return (Criteria) this;
        }

        public Criteria andStoreNumsIn(List<Integer> values) {
            addCriterion("store_nums in", values, "storeNums");
            return (Criteria) this;
        }

        public Criteria andStoreNumsNotIn(List<Integer> values) {
            addCriterion("store_nums not in", values, "storeNums");
            return (Criteria) this;
        }

        public Criteria andStoreNumsBetween(Integer value1, Integer value2) {
            addCriterion("store_nums between", value1, value2, "storeNums");
            return (Criteria) this;
        }

        public Criteria andStoreNumsNotBetween(Integer value1, Integer value2) {
            addCriterion("store_nums not between", value1, value2, "storeNums");
            return (Criteria) this;
        }

        public Criteria andJoinStoreNumsIsNull() {
            addCriterion("join_store_nums is null");
            return (Criteria) this;
        }

        public Criteria andJoinStoreNumsIsNotNull() {
            addCriterion("join_store_nums is not null");
            return (Criteria) this;
        }

        public Criteria andJoinStoreNumsEqualTo(Integer value) {
            addCriterion("join_store_nums =", value, "joinStoreNums");
            return (Criteria) this;
        }

        public Criteria andJoinStoreNumsNotEqualTo(Integer value) {
            addCriterion("join_store_nums <>", value, "joinStoreNums");
            return (Criteria) this;
        }

        public Criteria andJoinStoreNumsGreaterThan(Integer value) {
            addCriterion("join_store_nums >", value, "joinStoreNums");
            return (Criteria) this;
        }

        public Criteria andJoinStoreNumsGreaterThanOrEqualTo(Integer value) {
            addCriterion("join_store_nums >=", value, "joinStoreNums");
            return (Criteria) this;
        }

        public Criteria andJoinStoreNumsLessThan(Integer value) {
            addCriterion("join_store_nums <", value, "joinStoreNums");
            return (Criteria) this;
        }

        public Criteria andJoinStoreNumsLessThanOrEqualTo(Integer value) {
            addCriterion("join_store_nums <=", value, "joinStoreNums");
            return (Criteria) this;
        }

        public Criteria andJoinStoreNumsIn(List<Integer> values) {
            addCriterion("join_store_nums in", values, "joinStoreNums");
            return (Criteria) this;
        }

        public Criteria andJoinStoreNumsNotIn(List<Integer> values) {
            addCriterion("join_store_nums not in", values, "joinStoreNums");
            return (Criteria) this;
        }

        public Criteria andJoinStoreNumsBetween(Integer value1, Integer value2) {
            addCriterion("join_store_nums between", value1, value2, "joinStoreNums");
            return (Criteria) this;
        }

        public Criteria andJoinStoreNumsNotBetween(Integer value1, Integer value2) {
            addCriterion("join_store_nums not between", value1, value2, "joinStoreNums");
            return (Criteria) this;
        }

        public Criteria andJoinRateIsNull() {
            addCriterion("join_rate is null");
            return (Criteria) this;
        }

        public Criteria andJoinRateIsNotNull() {
            addCriterion("join_rate is not null");
            return (Criteria) this;
        }

        public Criteria andJoinRateEqualTo(Integer value) {
            addCriterion("join_rate =", value, "joinRate");
            return (Criteria) this;
        }

        public Criteria andJoinRateNotEqualTo(Integer value) {
            addCriterion("join_rate <>", value, "joinRate");
            return (Criteria) this;
        }

        public Criteria andJoinRateGreaterThan(Integer value) {
            addCriterion("join_rate >", value, "joinRate");
            return (Criteria) this;
        }

        public Criteria andJoinRateGreaterThanOrEqualTo(Integer value) {
            addCriterion("join_rate >=", value, "joinRate");
            return (Criteria) this;
        }

        public Criteria andJoinRateLessThan(Integer value) {
            addCriterion("join_rate <", value, "joinRate");
            return (Criteria) this;
        }

        public Criteria andJoinRateLessThanOrEqualTo(Integer value) {
            addCriterion("join_rate <=", value, "joinRate");
            return (Criteria) this;
        }

        public Criteria andJoinRateIn(List<Integer> values) {
            addCriterion("join_rate in", values, "joinRate");
            return (Criteria) this;
        }

        public Criteria andJoinRateNotIn(List<Integer> values) {
            addCriterion("join_rate not in", values, "joinRate");
            return (Criteria) this;
        }

        public Criteria andJoinRateBetween(Integer value1, Integer value2) {
            addCriterion("join_rate between", value1, value2, "joinRate");
            return (Criteria) this;
        }

        public Criteria andJoinRateNotBetween(Integer value1, Integer value2) {
            addCriterion("join_rate not between", value1, value2, "joinRate");
            return (Criteria) this;
        }

        public Criteria andFirstCompeteGoodsIsNull() {
            addCriterion("first_compete_goods is null");
            return (Criteria) this;
        }

        public Criteria andFirstCompeteGoodsIsNotNull() {
            addCriterion("first_compete_goods is not null");
            return (Criteria) this;
        }

        public Criteria andFirstCompeteGoodsEqualTo(String value) {
            addCriterion("first_compete_goods =", value, "firstCompeteGoods");
            return (Criteria) this;
        }

        public Criteria andFirstCompeteGoodsNotEqualTo(String value) {
            addCriterion("first_compete_goods <>", value, "firstCompeteGoods");
            return (Criteria) this;
        }

        public Criteria andFirstCompeteGoodsGreaterThan(String value) {
            addCriterion("first_compete_goods >", value, "firstCompeteGoods");
            return (Criteria) this;
        }

        public Criteria andFirstCompeteGoodsGreaterThanOrEqualTo(String value) {
            addCriterion("first_compete_goods >=", value, "firstCompeteGoods");
            return (Criteria) this;
        }

        public Criteria andFirstCompeteGoodsLessThan(String value) {
            addCriterion("first_compete_goods <", value, "firstCompeteGoods");
            return (Criteria) this;
        }

        public Criteria andFirstCompeteGoodsLessThanOrEqualTo(String value) {
            addCriterion("first_compete_goods <=", value, "firstCompeteGoods");
            return (Criteria) this;
        }

        public Criteria andFirstCompeteGoodsLike(String value) {
            addCriterion("first_compete_goods like", value, "firstCompeteGoods");
            return (Criteria) this;
        }

        public Criteria andFirstCompeteGoodsNotLike(String value) {
            addCriterion("first_compete_goods not like", value, "firstCompeteGoods");
            return (Criteria) this;
        }

        public Criteria andFirstCompeteGoodsIn(List<String> values) {
            addCriterion("first_compete_goods in", values, "firstCompeteGoods");
            return (Criteria) this;
        }

        public Criteria andFirstCompeteGoodsNotIn(List<String> values) {
            addCriterion("first_compete_goods not in", values, "firstCompeteGoods");
            return (Criteria) this;
        }

        public Criteria andFirstCompeteGoodsBetween(String value1, String value2) {
            addCriterion("first_compete_goods between", value1, value2, "firstCompeteGoods");
            return (Criteria) this;
        }

        public Criteria andFirstCompeteGoodsNotBetween(String value1, String value2) {
            addCriterion("first_compete_goods not between", value1, value2, "firstCompeteGoods");
            return (Criteria) this;
        }

        public Criteria andCategoryRankIsNull() {
            addCriterion("category_rank is null");
            return (Criteria) this;
        }

        public Criteria andCategoryRankIsNotNull() {
            addCriterion("category_rank is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryRankEqualTo(String value) {
            addCriterion("category_rank =", value, "categoryRank");
            return (Criteria) this;
        }

        public Criteria andCategoryRankNotEqualTo(String value) {
            addCriterion("category_rank <>", value, "categoryRank");
            return (Criteria) this;
        }

        public Criteria andCategoryRankGreaterThan(String value) {
            addCriterion("category_rank >", value, "categoryRank");
            return (Criteria) this;
        }

        public Criteria andCategoryRankGreaterThanOrEqualTo(String value) {
            addCriterion("category_rank >=", value, "categoryRank");
            return (Criteria) this;
        }

        public Criteria andCategoryRankLessThan(String value) {
            addCriterion("category_rank <", value, "categoryRank");
            return (Criteria) this;
        }

        public Criteria andCategoryRankLessThanOrEqualTo(String value) {
            addCriterion("category_rank <=", value, "categoryRank");
            return (Criteria) this;
        }

        public Criteria andCategoryRankLike(String value) {
            addCriterion("category_rank like", value, "categoryRank");
            return (Criteria) this;
        }

        public Criteria andCategoryRankNotLike(String value) {
            addCriterion("category_rank not like", value, "categoryRank");
            return (Criteria) this;
        }

        public Criteria andCategoryRankIn(List<String> values) {
            addCriterion("category_rank in", values, "categoryRank");
            return (Criteria) this;
        }

        public Criteria andCategoryRankNotIn(List<String> values) {
            addCriterion("category_rank not in", values, "categoryRank");
            return (Criteria) this;
        }

        public Criteria andCategoryRankBetween(String value1, String value2) {
            addCriterion("category_rank between", value1, value2, "categoryRank");
            return (Criteria) this;
        }

        public Criteria andCategoryRankNotBetween(String value1, String value2) {
            addCriterion("category_rank not between", value1, value2, "categoryRank");
            return (Criteria) this;
        }

        public Criteria andSalesIsNull() {
            addCriterion("sales is null");
            return (Criteria) this;
        }

        public Criteria andSalesIsNotNull() {
            addCriterion("sales is not null");
            return (Criteria) this;
        }

        public Criteria andSalesEqualTo(BigDecimal value) {
            addCriterion("sales =", value, "sales");
            return (Criteria) this;
        }

        public Criteria andSalesNotEqualTo(BigDecimal value) {
            addCriterion("sales <>", value, "sales");
            return (Criteria) this;
        }

        public Criteria andSalesGreaterThan(BigDecimal value) {
            addCriterion("sales >", value, "sales");
            return (Criteria) this;
        }

        public Criteria andSalesGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("sales >=", value, "sales");
            return (Criteria) this;
        }

        public Criteria andSalesLessThan(BigDecimal value) {
            addCriterion("sales <", value, "sales");
            return (Criteria) this;
        }

        public Criteria andSalesLessThanOrEqualTo(BigDecimal value) {
            addCriterion("sales <=", value, "sales");
            return (Criteria) this;
        }

        public Criteria andSalesIn(List<BigDecimal> values) {
            addCriterion("sales in", values, "sales");
            return (Criteria) this;
        }

        public Criteria andSalesNotIn(List<BigDecimal> values) {
            addCriterion("sales not in", values, "sales");
            return (Criteria) this;
        }

        public Criteria andSalesBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sales between", value1, value2, "sales");
            return (Criteria) this;
        }

        public Criteria andSalesNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sales not between", value1, value2, "sales");
            return (Criteria) this;
        }

        public Criteria andPlanStartTimeIsNull() {
            addCriterion("plan_start_time is null");
            return (Criteria) this;
        }

        public Criteria andPlanStartTimeIsNotNull() {
            addCriterion("plan_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andPlanStartTimeEqualTo(Date value) {
            addCriterion("plan_start_time =", value, "planStartTime");
            return (Criteria) this;
        }

        public Criteria andPlanStartTimeNotEqualTo(Date value) {
            addCriterion("plan_start_time <>", value, "planStartTime");
            return (Criteria) this;
        }

        public Criteria andPlanStartTimeGreaterThan(Date value) {
            addCriterion("plan_start_time >", value, "planStartTime");
            return (Criteria) this;
        }

        public Criteria andPlanStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("plan_start_time >=", value, "planStartTime");
            return (Criteria) this;
        }

        public Criteria andPlanStartTimeLessThan(Date value) {
            addCriterion("plan_start_time <", value, "planStartTime");
            return (Criteria) this;
        }

        public Criteria andPlanStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("plan_start_time <=", value, "planStartTime");
            return (Criteria) this;
        }

        public Criteria andPlanStartTimeIn(List<Date> values) {
            addCriterion("plan_start_time in", values, "planStartTime");
            return (Criteria) this;
        }

        public Criteria andPlanStartTimeNotIn(List<Date> values) {
            addCriterion("plan_start_time not in", values, "planStartTime");
            return (Criteria) this;
        }

        public Criteria andPlanStartTimeBetween(Date value1, Date value2) {
            addCriterion("plan_start_time between", value1, value2, "planStartTime");
            return (Criteria) this;
        }

        public Criteria andPlanStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("plan_start_time not between", value1, value2, "planStartTime");
            return (Criteria) this;
        }

        public Criteria andPlanEndTimeIsNull() {
            addCriterion("plan_end_time is null");
            return (Criteria) this;
        }

        public Criteria andPlanEndTimeIsNotNull() {
            addCriterion("plan_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andPlanEndTimeEqualTo(Date value) {
            addCriterion("plan_end_time =", value, "planEndTime");
            return (Criteria) this;
        }

        public Criteria andPlanEndTimeNotEqualTo(Date value) {
            addCriterion("plan_end_time <>", value, "planEndTime");
            return (Criteria) this;
        }

        public Criteria andPlanEndTimeGreaterThan(Date value) {
            addCriterion("plan_end_time >", value, "planEndTime");
            return (Criteria) this;
        }

        public Criteria andPlanEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("plan_end_time >=", value, "planEndTime");
            return (Criteria) this;
        }

        public Criteria andPlanEndTimeLessThan(Date value) {
            addCriterion("plan_end_time <", value, "planEndTime");
            return (Criteria) this;
        }

        public Criteria andPlanEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("plan_end_time <=", value, "planEndTime");
            return (Criteria) this;
        }

        public Criteria andPlanEndTimeIn(List<Date> values) {
            addCriterion("plan_end_time in", values, "planEndTime");
            return (Criteria) this;
        }

        public Criteria andPlanEndTimeNotIn(List<Date> values) {
            addCriterion("plan_end_time not in", values, "planEndTime");
            return (Criteria) this;
        }

        public Criteria andPlanEndTimeBetween(Date value1, Date value2) {
            addCriterion("plan_end_time between", value1, value2, "planEndTime");
            return (Criteria) this;
        }

        public Criteria andPlanEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("plan_end_time not between", value1, value2, "planEndTime");
            return (Criteria) this;
        }

        public Criteria andPlanDaysIsNull() {
            addCriterion("plan_days is null");
            return (Criteria) this;
        }

        public Criteria andPlanDaysIsNotNull() {
            addCriterion("plan_days is not null");
            return (Criteria) this;
        }

        public Criteria andPlanDaysEqualTo(Integer value) {
            addCriterion("plan_days =", value, "planDays");
            return (Criteria) this;
        }

        public Criteria andPlanDaysNotEqualTo(Integer value) {
            addCriterion("plan_days <>", value, "planDays");
            return (Criteria) this;
        }

        public Criteria andPlanDaysGreaterThan(Integer value) {
            addCriterion("plan_days >", value, "planDays");
            return (Criteria) this;
        }

        public Criteria andPlanDaysGreaterThanOrEqualTo(Integer value) {
            addCriterion("plan_days >=", value, "planDays");
            return (Criteria) this;
        }

        public Criteria andPlanDaysLessThan(Integer value) {
            addCriterion("plan_days <", value, "planDays");
            return (Criteria) this;
        }

        public Criteria andPlanDaysLessThanOrEqualTo(Integer value) {
            addCriterion("plan_days <=", value, "planDays");
            return (Criteria) this;
        }

        public Criteria andPlanDaysIn(List<Integer> values) {
            addCriterion("plan_days in", values, "planDays");
            return (Criteria) this;
        }

        public Criteria andPlanDaysNotIn(List<Integer> values) {
            addCriterion("plan_days not in", values, "planDays");
            return (Criteria) this;
        }

        public Criteria andPlanDaysBetween(Integer value1, Integer value2) {
            addCriterion("plan_days between", value1, value2, "planDays");
            return (Criteria) this;
        }

        public Criteria andPlanDaysNotBetween(Integer value1, Integer value2) {
            addCriterion("plan_days not between", value1, value2, "planDays");
            return (Criteria) this;
        }

        public Criteria andActualStartTimeIsNull() {
            addCriterion("actual_start_time is null");
            return (Criteria) this;
        }

        public Criteria andActualStartTimeIsNotNull() {
            addCriterion("actual_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andActualStartTimeEqualTo(Date value) {
            addCriterion("actual_start_time =", value, "actualStartTime");
            return (Criteria) this;
        }

        public Criteria andActualStartTimeNotEqualTo(Date value) {
            addCriterion("actual_start_time <>", value, "actualStartTime");
            return (Criteria) this;
        }

        public Criteria andActualStartTimeGreaterThan(Date value) {
            addCriterion("actual_start_time >", value, "actualStartTime");
            return (Criteria) this;
        }

        public Criteria andActualStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("actual_start_time >=", value, "actualStartTime");
            return (Criteria) this;
        }

        public Criteria andActualStartTimeLessThan(Date value) {
            addCriterion("actual_start_time <", value, "actualStartTime");
            return (Criteria) this;
        }

        public Criteria andActualStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("actual_start_time <=", value, "actualStartTime");
            return (Criteria) this;
        }

        public Criteria andActualStartTimeIn(List<Date> values) {
            addCriterion("actual_start_time in", values, "actualStartTime");
            return (Criteria) this;
        }

        public Criteria andActualStartTimeNotIn(List<Date> values) {
            addCriterion("actual_start_time not in", values, "actualStartTime");
            return (Criteria) this;
        }

        public Criteria andActualStartTimeBetween(Date value1, Date value2) {
            addCriterion("actual_start_time between", value1, value2, "actualStartTime");
            return (Criteria) this;
        }

        public Criteria andActualStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("actual_start_time not between", value1, value2, "actualStartTime");
            return (Criteria) this;
        }

        public Criteria andActualEndTimeIsNull() {
            addCriterion("actual_end_time is null");
            return (Criteria) this;
        }

        public Criteria andActualEndTimeIsNotNull() {
            addCriterion("actual_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andActualEndTimeEqualTo(Date value) {
            addCriterion("actual_end_time =", value, "actualEndTime");
            return (Criteria) this;
        }

        public Criteria andActualEndTimeNotEqualTo(Date value) {
            addCriterion("actual_end_time <>", value, "actualEndTime");
            return (Criteria) this;
        }

        public Criteria andActualEndTimeGreaterThan(Date value) {
            addCriterion("actual_end_time >", value, "actualEndTime");
            return (Criteria) this;
        }

        public Criteria andActualEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("actual_end_time >=", value, "actualEndTime");
            return (Criteria) this;
        }

        public Criteria andActualEndTimeLessThan(Date value) {
            addCriterion("actual_end_time <", value, "actualEndTime");
            return (Criteria) this;
        }

        public Criteria andActualEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("actual_end_time <=", value, "actualEndTime");
            return (Criteria) this;
        }

        public Criteria andActualEndTimeIn(List<Date> values) {
            addCriterion("actual_end_time in", values, "actualEndTime");
            return (Criteria) this;
        }

        public Criteria andActualEndTimeNotIn(List<Date> values) {
            addCriterion("actual_end_time not in", values, "actualEndTime");
            return (Criteria) this;
        }

        public Criteria andActualEndTimeBetween(Date value1, Date value2) {
            addCriterion("actual_end_time between", value1, value2, "actualEndTime");
            return (Criteria) this;
        }

        public Criteria andActualEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("actual_end_time not between", value1, value2, "actualEndTime");
            return (Criteria) this;
        }

        public Criteria andActualDaysIsNull() {
            addCriterion("actual_days is null");
            return (Criteria) this;
        }

        public Criteria andActualDaysIsNotNull() {
            addCriterion("actual_days is not null");
            return (Criteria) this;
        }

        public Criteria andActualDaysEqualTo(Integer value) {
            addCriterion("actual_days =", value, "actualDays");
            return (Criteria) this;
        }

        public Criteria andActualDaysNotEqualTo(Integer value) {
            addCriterion("actual_days <>", value, "actualDays");
            return (Criteria) this;
        }

        public Criteria andActualDaysGreaterThan(Integer value) {
            addCriterion("actual_days >", value, "actualDays");
            return (Criteria) this;
        }

        public Criteria andActualDaysGreaterThanOrEqualTo(Integer value) {
            addCriterion("actual_days >=", value, "actualDays");
            return (Criteria) this;
        }

        public Criteria andActualDaysLessThan(Integer value) {
            addCriterion("actual_days <", value, "actualDays");
            return (Criteria) this;
        }

        public Criteria andActualDaysLessThanOrEqualTo(Integer value) {
            addCriterion("actual_days <=", value, "actualDays");
            return (Criteria) this;
        }

        public Criteria andActualDaysIn(List<Integer> values) {
            addCriterion("actual_days in", values, "actualDays");
            return (Criteria) this;
        }

        public Criteria andActualDaysNotIn(List<Integer> values) {
            addCriterion("actual_days not in", values, "actualDays");
            return (Criteria) this;
        }

        public Criteria andActualDaysBetween(Integer value1, Integer value2) {
            addCriterion("actual_days between", value1, value2, "actualDays");
            return (Criteria) this;
        }

        public Criteria andActualDaysNotBetween(Integer value1, Integer value2) {
            addCriterion("actual_days not between", value1, value2, "actualDays");
            return (Criteria) this;
        }

        public Criteria andPlanSaleTargetIsNull() {
            addCriterion("plan_sale_target is null");
            return (Criteria) this;
        }

        public Criteria andPlanSaleTargetIsNotNull() {
            addCriterion("plan_sale_target is not null");
            return (Criteria) this;
        }

        public Criteria andPlanSaleTargetEqualTo(BigDecimal value) {
            addCriterion("plan_sale_target =", value, "planSaleTarget");
            return (Criteria) this;
        }

        public Criteria andPlanSaleTargetNotEqualTo(BigDecimal value) {
            addCriterion("plan_sale_target <>", value, "planSaleTarget");
            return (Criteria) this;
        }

        public Criteria andPlanSaleTargetGreaterThan(BigDecimal value) {
            addCriterion("plan_sale_target >", value, "planSaleTarget");
            return (Criteria) this;
        }

        public Criteria andPlanSaleTargetGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("plan_sale_target >=", value, "planSaleTarget");
            return (Criteria) this;
        }

        public Criteria andPlanSaleTargetLessThan(BigDecimal value) {
            addCriterion("plan_sale_target <", value, "planSaleTarget");
            return (Criteria) this;
        }

        public Criteria andPlanSaleTargetLessThanOrEqualTo(BigDecimal value) {
            addCriterion("plan_sale_target <=", value, "planSaleTarget");
            return (Criteria) this;
        }

        public Criteria andPlanSaleTargetIn(List<BigDecimal> values) {
            addCriterion("plan_sale_target in", values, "planSaleTarget");
            return (Criteria) this;
        }

        public Criteria andPlanSaleTargetNotIn(List<BigDecimal> values) {
            addCriterion("plan_sale_target not in", values, "planSaleTarget");
            return (Criteria) this;
        }

        public Criteria andPlanSaleTargetBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("plan_sale_target between", value1, value2, "planSaleTarget");
            return (Criteria) this;
        }

        public Criteria andPlanSaleTargetNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("plan_sale_target not between", value1, value2, "planSaleTarget");
            return (Criteria) this;
        }

        public Criteria andPlanActivityCostIsNull() {
            addCriterion("plan_activity_cost is null");
            return (Criteria) this;
        }

        public Criteria andPlanActivityCostIsNotNull() {
            addCriterion("plan_activity_cost is not null");
            return (Criteria) this;
        }

        public Criteria andPlanActivityCostEqualTo(BigDecimal value) {
            addCriterion("plan_activity_cost =", value, "planActivityCost");
            return (Criteria) this;
        }

        public Criteria andPlanActivityCostNotEqualTo(BigDecimal value) {
            addCriterion("plan_activity_cost <>", value, "planActivityCost");
            return (Criteria) this;
        }

        public Criteria andPlanActivityCostGreaterThan(BigDecimal value) {
            addCriterion("plan_activity_cost >", value, "planActivityCost");
            return (Criteria) this;
        }

        public Criteria andPlanActivityCostGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("plan_activity_cost >=", value, "planActivityCost");
            return (Criteria) this;
        }

        public Criteria andPlanActivityCostLessThan(BigDecimal value) {
            addCriterion("plan_activity_cost <", value, "planActivityCost");
            return (Criteria) this;
        }

        public Criteria andPlanActivityCostLessThanOrEqualTo(BigDecimal value) {
            addCriterion("plan_activity_cost <=", value, "planActivityCost");
            return (Criteria) this;
        }

        public Criteria andPlanActivityCostIn(List<BigDecimal> values) {
            addCriterion("plan_activity_cost in", values, "planActivityCost");
            return (Criteria) this;
        }

        public Criteria andPlanActivityCostNotIn(List<BigDecimal> values) {
            addCriterion("plan_activity_cost not in", values, "planActivityCost");
            return (Criteria) this;
        }

        public Criteria andPlanActivityCostBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("plan_activity_cost between", value1, value2, "planActivityCost");
            return (Criteria) this;
        }

        public Criteria andPlanActivityCostNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("plan_activity_cost not between", value1, value2, "planActivityCost");
            return (Criteria) this;
        }

        public Criteria andPlanActivityProportIsNull() {
            addCriterion("plan_activity_proport is null");
            return (Criteria) this;
        }

        public Criteria andPlanActivityProportIsNotNull() {
            addCriterion("plan_activity_proport is not null");
            return (Criteria) this;
        }

        public Criteria andPlanActivityProportEqualTo(String value) {
            addCriterion("plan_activity_proport =", value, "planActivityProport");
            return (Criteria) this;
        }

        public Criteria andPlanActivityProportNotEqualTo(String value) {
            addCriterion("plan_activity_proport <>", value, "planActivityProport");
            return (Criteria) this;
        }

        public Criteria andPlanActivityProportGreaterThan(String value) {
            addCriterion("plan_activity_proport >", value, "planActivityProport");
            return (Criteria) this;
        }

        public Criteria andPlanActivityProportGreaterThanOrEqualTo(String value) {
            addCriterion("plan_activity_proport >=", value, "planActivityProport");
            return (Criteria) this;
        }

        public Criteria andPlanActivityProportLessThan(String value) {
            addCriterion("plan_activity_proport <", value, "planActivityProport");
            return (Criteria) this;
        }

        public Criteria andPlanActivityProportLessThanOrEqualTo(String value) {
            addCriterion("plan_activity_proport <=", value, "planActivityProport");
            return (Criteria) this;
        }

        public Criteria andPlanActivityProportLike(String value) {
            addCriterion("plan_activity_proport like", value, "planActivityProport");
            return (Criteria) this;
        }

        public Criteria andPlanActivityProportNotLike(String value) {
            addCriterion("plan_activity_proport not like", value, "planActivityProport");
            return (Criteria) this;
        }

        public Criteria andPlanActivityProportIn(List<String> values) {
            addCriterion("plan_activity_proport in", values, "planActivityProport");
            return (Criteria) this;
        }

        public Criteria andPlanActivityProportNotIn(List<String> values) {
            addCriterion("plan_activity_proport not in", values, "planActivityProport");
            return (Criteria) this;
        }

        public Criteria andPlanActivityProportBetween(String value1, String value2) {
            addCriterion("plan_activity_proport between", value1, value2, "planActivityProport");
            return (Criteria) this;
        }

        public Criteria andPlanActivityProportNotBetween(String value1, String value2) {
            addCriterion("plan_activity_proport not between", value1, value2, "planActivityProport");
            return (Criteria) this;
        }

        public Criteria andActualSaleTargetIsNull() {
            addCriterion("actual_sale_target is null");
            return (Criteria) this;
        }

        public Criteria andActualSaleTargetIsNotNull() {
            addCriterion("actual_sale_target is not null");
            return (Criteria) this;
        }

        public Criteria andActualSaleTargetEqualTo(BigDecimal value) {
            addCriterion("actual_sale_target =", value, "actualSaleTarget");
            return (Criteria) this;
        }

        public Criteria andActualSaleTargetNotEqualTo(BigDecimal value) {
            addCriterion("actual_sale_target <>", value, "actualSaleTarget");
            return (Criteria) this;
        }

        public Criteria andActualSaleTargetGreaterThan(BigDecimal value) {
            addCriterion("actual_sale_target >", value, "actualSaleTarget");
            return (Criteria) this;
        }

        public Criteria andActualSaleTargetGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("actual_sale_target >=", value, "actualSaleTarget");
            return (Criteria) this;
        }

        public Criteria andActualSaleTargetLessThan(BigDecimal value) {
            addCriterion("actual_sale_target <", value, "actualSaleTarget");
            return (Criteria) this;
        }

        public Criteria andActualSaleTargetLessThanOrEqualTo(BigDecimal value) {
            addCriterion("actual_sale_target <=", value, "actualSaleTarget");
            return (Criteria) this;
        }

        public Criteria andActualSaleTargetIn(List<BigDecimal> values) {
            addCriterion("actual_sale_target in", values, "actualSaleTarget");
            return (Criteria) this;
        }

        public Criteria andActualSaleTargetNotIn(List<BigDecimal> values) {
            addCriterion("actual_sale_target not in", values, "actualSaleTarget");
            return (Criteria) this;
        }

        public Criteria andActualSaleTargetBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("actual_sale_target between", value1, value2, "actualSaleTarget");
            return (Criteria) this;
        }

        public Criteria andActualSaleTargetNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("actual_sale_target not between", value1, value2, "actualSaleTarget");
            return (Criteria) this;
        }

        public Criteria andActualActivityCostIsNull() {
            addCriterion("actual_activity_cost is null");
            return (Criteria) this;
        }

        public Criteria andActualActivityCostIsNotNull() {
            addCriterion("actual_activity_cost is not null");
            return (Criteria) this;
        }

        public Criteria andActualActivityCostEqualTo(BigDecimal value) {
            addCriterion("actual_activity_cost =", value, "actualActivityCost");
            return (Criteria) this;
        }

        public Criteria andActualActivityCostNotEqualTo(BigDecimal value) {
            addCriterion("actual_activity_cost <>", value, "actualActivityCost");
            return (Criteria) this;
        }

        public Criteria andActualActivityCostGreaterThan(BigDecimal value) {
            addCriterion("actual_activity_cost >", value, "actualActivityCost");
            return (Criteria) this;
        }

        public Criteria andActualActivityCostGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("actual_activity_cost >=", value, "actualActivityCost");
            return (Criteria) this;
        }

        public Criteria andActualActivityCostLessThan(BigDecimal value) {
            addCriterion("actual_activity_cost <", value, "actualActivityCost");
            return (Criteria) this;
        }

        public Criteria andActualActivityCostLessThanOrEqualTo(BigDecimal value) {
            addCriterion("actual_activity_cost <=", value, "actualActivityCost");
            return (Criteria) this;
        }

        public Criteria andActualActivityCostIn(List<BigDecimal> values) {
            addCriterion("actual_activity_cost in", values, "actualActivityCost");
            return (Criteria) this;
        }

        public Criteria andActualActivityCostNotIn(List<BigDecimal> values) {
            addCriterion("actual_activity_cost not in", values, "actualActivityCost");
            return (Criteria) this;
        }

        public Criteria andActualActivityCostBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("actual_activity_cost between", value1, value2, "actualActivityCost");
            return (Criteria) this;
        }

        public Criteria andActualActivityCostNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("actual_activity_cost not between", value1, value2, "actualActivityCost");
            return (Criteria) this;
        }

        public Criteria andActualActivityProportIsNull() {
            addCriterion("actual_activity_proport is null");
            return (Criteria) this;
        }

        public Criteria andActualActivityProportIsNotNull() {
            addCriterion("actual_activity_proport is not null");
            return (Criteria) this;
        }

        public Criteria andActualActivityProportEqualTo(String value) {
            addCriterion("actual_activity_proport =", value, "actualActivityProport");
            return (Criteria) this;
        }

        public Criteria andActualActivityProportNotEqualTo(String value) {
            addCriterion("actual_activity_proport <>", value, "actualActivityProport");
            return (Criteria) this;
        }

        public Criteria andActualActivityProportGreaterThan(String value) {
            addCriterion("actual_activity_proport >", value, "actualActivityProport");
            return (Criteria) this;
        }

        public Criteria andActualActivityProportGreaterThanOrEqualTo(String value) {
            addCriterion("actual_activity_proport >=", value, "actualActivityProport");
            return (Criteria) this;
        }

        public Criteria andActualActivityProportLessThan(String value) {
            addCriterion("actual_activity_proport <", value, "actualActivityProport");
            return (Criteria) this;
        }

        public Criteria andActualActivityProportLessThanOrEqualTo(String value) {
            addCriterion("actual_activity_proport <=", value, "actualActivityProport");
            return (Criteria) this;
        }

        public Criteria andActualActivityProportLike(String value) {
            addCriterion("actual_activity_proport like", value, "actualActivityProport");
            return (Criteria) this;
        }

        public Criteria andActualActivityProportNotLike(String value) {
            addCriterion("actual_activity_proport not like", value, "actualActivityProport");
            return (Criteria) this;
        }

        public Criteria andActualActivityProportIn(List<String> values) {
            addCriterion("actual_activity_proport in", values, "actualActivityProport");
            return (Criteria) this;
        }

        public Criteria andActualActivityProportNotIn(List<String> values) {
            addCriterion("actual_activity_proport not in", values, "actualActivityProport");
            return (Criteria) this;
        }

        public Criteria andActualActivityProportBetween(String value1, String value2) {
            addCriterion("actual_activity_proport between", value1, value2, "actualActivityProport");
            return (Criteria) this;
        }

        public Criteria andActualActivityProportNotBetween(String value1, String value2) {
            addCriterion("actual_activity_proport not between", value1, value2, "actualActivityProport");
            return (Criteria) this;
        }
        
        public Criteria andTargetCompleteRateIsNull() {
            addCriterion("target_complete_rate is null");
            return (Criteria) this;
        }

        public Criteria andTargetCompleteRateIsNotNull() {
            addCriterion("target_complete_rate is not null");
            return (Criteria) this;
        }

        public Criteria andTargetCompleteRateEqualTo(BigDecimal value) {
            addCriterion("target_complete_rate =", value, "targetCompleteRate");
            return (Criteria) this;
        }

        public Criteria andTargetCompleteRateNotEqualTo(BigDecimal value) {
            addCriterion("target_complete_rate <>", value, "targetCompleteRate");
            return (Criteria) this;
        }

        public Criteria andTargetCompleteRateGreaterThan(BigDecimal value) {
            addCriterion("target_complete_rate >", value, "targetCompleteRate");
            return (Criteria) this;
        }

        public Criteria andTargetCompleteRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("target_complete_rate >=", value, "targetCompleteRate");
            return (Criteria) this;
        }

        public Criteria andTargetCompleteRateLessThan(BigDecimal value) {
            addCriterion("target_complete_rate <", value, "targetCompleteRate");
            return (Criteria) this;
        }

        public Criteria andTargetCompleteRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("target_complete_rate <=", value, "targetCompleteRate");
            return (Criteria) this;
        }

        public Criteria andTargetCompleteRateIn(List<BigDecimal> values) {
            addCriterion("target_complete_rate in", values, "targetCompleteRate");
            return (Criteria) this;
        }

        public Criteria andTargetCompleteRateNotIn(List<BigDecimal> values) {
            addCriterion("target_complete_rate not in", values, "targetCompleteRate");
            return (Criteria) this;
        }

        public Criteria andTargetCompleteRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("target_complete_rate between", value1, value2, "targetCompleteRate");
            return (Criteria) this;
        }

        public Criteria andTargetCompleteRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("target_complete_rate not between", value1, value2, "targetCompleteRate");
            return (Criteria) this;
        }
        
        public Criteria andCostUsageIsNull() {
            addCriterion("cost_usage is null");
            return (Criteria) this;
        }

        public Criteria andCostUsageIsNotNull() {
            addCriterion("cost_usage is not null");
            return (Criteria) this;
        }

        public Criteria andCostUsageEqualTo(BigDecimal value) {
            addCriterion("cost_usage =", value, "costUsage");
            return (Criteria) this;
        }

        public Criteria andCostUsageNotEqualTo(BigDecimal value) {
            addCriterion("cost_usage <>", value, "costUsage");
            return (Criteria) this;
        }

        public Criteria andCostUsageGreaterThan(BigDecimal value) {
            addCriterion("cost_usage >", value, "costUsage");
            return (Criteria) this;
        }

        public Criteria andCostUsageGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("cost_usage >=", value, "costUsage");
            return (Criteria) this;
        }

        public Criteria andCostUsageLessThan(BigDecimal value) {
            addCriterion("cost_usage <", value, "costUsage");
            return (Criteria) this;
        }

        public Criteria andCostUsageLessThanOrEqualTo(BigDecimal value) {
            addCriterion("cost_usage <=", value, "costUsage");
            return (Criteria) this;
        }

        public Criteria andCostUsageIn(List<BigDecimal> values) {
            addCriterion("cost_usage in", values, "costUsage");
            return (Criteria) this;
        }

        public Criteria andCostUsageNotIn(List<BigDecimal> values) {
            addCriterion("cost_usage not in", values, "costUsage");
            return (Criteria) this;
        }

        public Criteria andCostUsageBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cost_usage between", value1, value2, "costUsage");
            return (Criteria) this;
        }

        public Criteria andCostUsageNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cost_usage not between", value1, value2, "costUsage");
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