package com.els.runhe.market.entity.promotional;

import com.els.base.core.entity.AbstractExample;
import com.els.base.core.entity.PageView;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PromotionalCostProjectExample extends AbstractExample<PromotionalCostProject> implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected PageView<PromotionalCostProject> pageView = new PageView<PromotionalCostProject>(1, 10);

    private static final long serialVersionUID = 1L;

    public PromotionalCostProjectExample() {
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
    public PageView<PromotionalCostProject> getPageView() {
        return pageView;
    }

    @Override
    public void setPageView(PageView<PromotionalCostProject> pageView) {
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

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andLineIsNull() {
            addCriterion("line is null");
            return (Criteria) this;
        }

        public Criteria andLineIsNotNull() {
            addCriterion("line is not null");
            return (Criteria) this;
        }

        public Criteria andLineEqualTo(String value) {
            addCriterion("line =", value, "line");
            return (Criteria) this;
        }

        public Criteria andLineNotEqualTo(String value) {
            addCriterion("line <>", value, "line");
            return (Criteria) this;
        }

        public Criteria andLineGreaterThan(String value) {
            addCriterion("line >", value, "line");
            return (Criteria) this;
        }

        public Criteria andLineGreaterThanOrEqualTo(String value) {
            addCriterion("line >=", value, "line");
            return (Criteria) this;
        }

        public Criteria andLineLessThan(String value) {
            addCriterion("line <", value, "line");
            return (Criteria) this;
        }

        public Criteria andLineLessThanOrEqualTo(String value) {
            addCriterion("line <=", value, "line");
            return (Criteria) this;
        }

        public Criteria andLineLike(String value) {
            addCriterion("line like", value, "line");
            return (Criteria) this;
        }

        public Criteria andLineNotLike(String value) {
            addCriterion("line not like", value, "line");
            return (Criteria) this;
        }

        public Criteria andLineIn(List<String> values) {
            addCriterion("line in", values, "line");
            return (Criteria) this;
        }

        public Criteria andLineNotIn(List<String> values) {
            addCriterion("line not in", values, "line");
            return (Criteria) this;
        }

        public Criteria andLineBetween(String value1, String value2) {
            addCriterion("line between", value1, value2, "line");
            return (Criteria) this;
        }

        public Criteria andLineNotBetween(String value1, String value2) {
            addCriterion("line not between", value1, value2, "line");
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
        
        public Criteria andSaleCostIsNull() {
            addCriterion("sale_cost is null");
            return (Criteria) this;
        }

        public Criteria andSaleCostIsNotNull() {
            addCriterion("sale_cost is not null");
            return (Criteria) this;
        }

        public Criteria andSaleCostEqualTo(BigDecimal value) {
            addCriterion("sale_cost =", value, "saleCost");
            return (Criteria) this;
        }

        public Criteria andSaleCostNotEqualTo(BigDecimal value) {
            addCriterion("sale_cost <>", value, "saleCost");
            return (Criteria) this;
        }

        public Criteria andSaleCostGreaterThan(BigDecimal value) {
            addCriterion("sale_cost >", value, "saleCost");
            return (Criteria) this;
        }

        public Criteria andSaleCostGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("sale_cost >=", value, "saleCost");
            return (Criteria) this;
        }

        public Criteria andSaleCostLessThan(BigDecimal value) {
            addCriterion("sale_cost <", value, "saleCost");
            return (Criteria) this;
        }

        public Criteria andSaleCostLessThanOrEqualTo(BigDecimal value) {
            addCriterion("sale_cost <=", value, "saleCost");
            return (Criteria) this;
        }

        public Criteria andSaleCostIn(List<BigDecimal> values) {
            addCriterion("sale_cost in", values, "saleCost");
            return (Criteria) this;
        }

        public Criteria andSaleCostNotIn(List<BigDecimal> values) {
            addCriterion("sale_cost not in", values, "saleCost");
            return (Criteria) this;
        }

        public Criteria andSaleCostBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sale_cost between", value1, value2, "saleCost");
            return (Criteria) this;
        }

        public Criteria andSaleCostNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sale_cost not between", value1, value2, "saleCost");
            return (Criteria) this;
        }

        public Criteria andSaleProportIsNull() {
            addCriterion("sale_proport is null");
            return (Criteria) this;
        }

        public Criteria andSaleProportIsNotNull() {
            addCriterion("sale_proport is not null");
            return (Criteria) this;
        }

        public Criteria andSaleProportEqualTo(BigDecimal value) {
            addCriterion("sale_proport =", value, "saleProport");
            return (Criteria) this;
        }

        public Criteria andSaleProportNotEqualTo(BigDecimal value) {
            addCriterion("sale_proport <>", value, "saleProport");
            return (Criteria) this;
        }

        public Criteria andSaleProportGreaterThan(BigDecimal value) {
            addCriterion("sale_proport >", value, "saleProport");
            return (Criteria) this;
        }

        public Criteria andSaleProportGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("sale_proport >=", value, "saleProport");
            return (Criteria) this;
        }

        public Criteria andSaleProportLessThan(BigDecimal value) {
            addCriterion("sale_proport <", value, "saleProport");
            return (Criteria) this;
        }

        public Criteria andSaleProportLessThanOrEqualTo(BigDecimal value) {
            addCriterion("sale_proport <=", value, "saleProport");
            return (Criteria) this;
        }

        public Criteria andSaleProportIn(List<BigDecimal> values) {
            addCriterion("sale_proport in", values, "saleProport");
            return (Criteria) this;
        }

        public Criteria andSaleProportNotIn(List<BigDecimal> values) {
            addCriterion("sale_proport not in", values, "saleProport");
            return (Criteria) this;
        }

        public Criteria andSaleProportBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sale_proport between", value1, value2, "saleProport");
            return (Criteria) this;
        }

        public Criteria andSaleProportNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sale_proport not between", value1, value2, "saleProport");
            return (Criteria) this;
        }

        public Criteria andSaleProjectIsNull() {
            addCriterion("sale_project is null");
            return (Criteria) this;
        }

        public Criteria andSaleProjectIsNotNull() {
            addCriterion("sale_project is not null");
            return (Criteria) this;
        }

        public Criteria andSaleProjectEqualTo(String value) {
            addCriterion("sale_project =", value, "saleProject");
            return (Criteria) this;
        }

        public Criteria andSaleProjectNotEqualTo(String value) {
            addCriterion("sale_project <>", value, "saleProject");
            return (Criteria) this;
        }

        public Criteria andSaleProjectGreaterThan(String value) {
            addCriterion("sale_project >", value, "saleProject");
            return (Criteria) this;
        }

        public Criteria andSaleProjectGreaterThanOrEqualTo(String value) {
            addCriterion("sale_project >=", value, "saleProject");
            return (Criteria) this;
        }

        public Criteria andSaleProjectLessThan(String value) {
            addCriterion("sale_project <", value, "saleProject");
            return (Criteria) this;
        }

        public Criteria andSaleProjectLessThanOrEqualTo(String value) {
            addCriterion("sale_project <=", value, "saleProject");
            return (Criteria) this;
        }

        public Criteria andSaleProjectLike(String value) {
            addCriterion("sale_project like", value, "saleProject");
            return (Criteria) this;
        }

        public Criteria andSaleProjectNotLike(String value) {
            addCriterion("sale_project not like", value, "saleProject");
            return (Criteria) this;
        }

        public Criteria andSaleProjectIn(List<String> values) {
            addCriterion("sale_project in", values, "saleProject");
            return (Criteria) this;
        }

        public Criteria andSaleProjectNotIn(List<String> values) {
            addCriterion("sale_project not in", values, "saleProject");
            return (Criteria) this;
        }

        public Criteria andSaleProjectBetween(String value1, String value2) {
            addCriterion("sale_project between", value1, value2, "saleProject");
            return (Criteria) this;
        }

        public Criteria andSaleProjectNotBetween(String value1, String value2) {
            addCriterion("sale_project not between", value1, value2, "saleProject");
            return (Criteria) this;
        }

        public Criteria andSaleAmountIsNull() {
            addCriterion("sale_amount is null");
            return (Criteria) this;
        }

        public Criteria andSaleAmountIsNotNull() {
            addCriterion("sale_amount is not null");
            return (Criteria) this;
        }

        public Criteria andSaleAmountEqualTo(BigDecimal value) {
            addCriterion("sale_amount =", value, "saleAmount");
            return (Criteria) this;
        }

        public Criteria andSaleAmountNotEqualTo(BigDecimal value) {
            addCriterion("sale_amount <>", value, "saleAmount");
            return (Criteria) this;
        }

        public Criteria andSaleAmountGreaterThan(BigDecimal value) {
            addCriterion("sale_amount >", value, "saleAmount");
            return (Criteria) this;
        }

        public Criteria andSaleAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("sale_amount >=", value, "saleAmount");
            return (Criteria) this;
        }

        public Criteria andSaleAmountLessThan(BigDecimal value) {
            addCriterion("sale_amount <", value, "saleAmount");
            return (Criteria) this;
        }

        public Criteria andSaleAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("sale_amount <=", value, "saleAmount");
            return (Criteria) this;
        }

        public Criteria andSaleAmountIn(List<BigDecimal> values) {
            addCriterion("sale_amount in", values, "saleAmount");
            return (Criteria) this;
        }

        public Criteria andSaleAmountNotIn(List<BigDecimal> values) {
            addCriterion("sale_amount not in", values, "saleAmount");
            return (Criteria) this;
        }

        public Criteria andSaleAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sale_amount between", value1, value2, "saleAmount");
            return (Criteria) this;
        }

        public Criteria andSaleAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sale_amount not between", value1, value2, "saleAmount");
            return (Criteria) this;
        }

        public Criteria andOurCostIsNull() {
            addCriterion("our_cost is null");
            return (Criteria) this;
        }

        public Criteria andOurCostIsNotNull() {
            addCriterion("our_cost is not null");
            return (Criteria) this;
        }

        public Criteria andOurCostEqualTo(BigDecimal value) {
            addCriterion("our_cost =", value, "ourCost");
            return (Criteria) this;
        }

        public Criteria andOurCostNotEqualTo(BigDecimal value) {
            addCriterion("our_cost <>", value, "ourCost");
            return (Criteria) this;
        }

        public Criteria andOurCostGreaterThan(BigDecimal value) {
            addCriterion("our_cost >", value, "ourCost");
            return (Criteria) this;
        }

        public Criteria andOurCostGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("our_cost >=", value, "ourCost");
            return (Criteria) this;
        }

        public Criteria andOurCostLessThan(BigDecimal value) {
            addCriterion("our_cost <", value, "ourCost");
            return (Criteria) this;
        }

        public Criteria andOurCostLessThanOrEqualTo(BigDecimal value) {
            addCriterion("our_cost <=", value, "ourCost");
            return (Criteria) this;
        }

        public Criteria andOurCostIn(List<BigDecimal> values) {
            addCriterion("our_cost in", values, "ourCost");
            return (Criteria) this;
        }

        public Criteria andOurCostNotIn(List<BigDecimal> values) {
            addCriterion("our_cost not in", values, "ourCost");
            return (Criteria) this;
        }

        public Criteria andOurCostBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("our_cost between", value1, value2, "ourCost");
            return (Criteria) this;
        }

        public Criteria andOurCostNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("our_cost not between", value1, value2, "ourCost");
            return (Criteria) this;
        }

        public Criteria andOurProportIsNull() {
            addCriterion("our_proport is null");
            return (Criteria) this;
        }

        public Criteria andOurProportIsNotNull() {
            addCriterion("our_proport is not null");
            return (Criteria) this;
        }

        public Criteria andOurProportEqualTo(BigDecimal value) {
            addCriterion("our_proport =", value, "ourProport");
            return (Criteria) this;
        }

        public Criteria andOurProportNotEqualTo(BigDecimal value) {
            addCriterion("our_proport <>", value, "ourProport");
            return (Criteria) this;
        }

        public Criteria andOurProportGreaterThan(BigDecimal value) {
            addCriterion("our_proport >", value, "ourProport");
            return (Criteria) this;
        }

        public Criteria andOurProportGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("our_proport >=", value, "ourProport");
            return (Criteria) this;
        }

        public Criteria andOurProportLessThan(BigDecimal value) {
            addCriterion("our_proport <", value, "ourProport");
            return (Criteria) this;
        }

        public Criteria andOurProportLessThanOrEqualTo(BigDecimal value) {
            addCriterion("our_proport <=", value, "ourProport");
            return (Criteria) this;
        }

        public Criteria andOurProportIn(List<BigDecimal> values) {
            addCriterion("our_proport in", values, "ourProport");
            return (Criteria) this;
        }

        public Criteria andOurProportNotIn(List<BigDecimal> values) {
            addCriterion("our_proport not in", values, "ourProport");
            return (Criteria) this;
        }

        public Criteria andOurProportBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("our_proport between", value1, value2, "ourProport");
            return (Criteria) this;
        }

        public Criteria andOurProportNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("our_proport not between", value1, value2, "ourProport");
            return (Criteria) this;
        }

        public Criteria andOurProjectIsNull() {
            addCriterion("our_project is null");
            return (Criteria) this;
        }

        public Criteria andOurProjectIsNotNull() {
            addCriterion("our_project is not null");
            return (Criteria) this;
        }

        public Criteria andOurProjectEqualTo(String value) {
            addCriterion("our_project =", value, "ourProject");
            return (Criteria) this;
        }

        public Criteria andOurProjectNotEqualTo(String value) {
            addCriterion("our_project <>", value, "ourProject");
            return (Criteria) this;
        }

        public Criteria andOurProjectGreaterThan(String value) {
            addCriterion("our_project >", value, "ourProject");
            return (Criteria) this;
        }

        public Criteria andOurProjectGreaterThanOrEqualTo(String value) {
            addCriterion("our_project >=", value, "ourProject");
            return (Criteria) this;
        }

        public Criteria andOurProjectLessThan(String value) {
            addCriterion("our_project <", value, "ourProject");
            return (Criteria) this;
        }

        public Criteria andOurProjectLessThanOrEqualTo(String value) {
            addCriterion("our_project <=", value, "ourProject");
            return (Criteria) this;
        }

        public Criteria andOurProjectLike(String value) {
            addCriterion("our_project like", value, "ourProject");
            return (Criteria) this;
        }

        public Criteria andOurProjectNotLike(String value) {
            addCriterion("our_project not like", value, "ourProject");
            return (Criteria) this;
        }

        public Criteria andOurProjectIn(List<String> values) {
            addCriterion("our_project in", values, "ourProject");
            return (Criteria) this;
        }

        public Criteria andOurProjectNotIn(List<String> values) {
            addCriterion("our_project not in", values, "ourProject");
            return (Criteria) this;
        }

        public Criteria andOurProjectBetween(String value1, String value2) {
            addCriterion("our_project between", value1, value2, "ourProject");
            return (Criteria) this;
        }

        public Criteria andOurProjectNotBetween(String value1, String value2) {
            addCriterion("our_project not between", value1, value2, "ourProject");
            return (Criteria) this;
        }

        public Criteria andOurAmountIsNull() {
            addCriterion("our_amount is null");
            return (Criteria) this;
        }

        public Criteria andOurAmountIsNotNull() {
            addCriterion("our_amount is not null");
            return (Criteria) this;
        }

        public Criteria andOurAmountEqualTo(BigDecimal value) {
            addCriterion("our_amount =", value, "ourAmount");
            return (Criteria) this;
        }

        public Criteria andOurAmountNotEqualTo(BigDecimal value) {
            addCriterion("our_amount <>", value, "ourAmount");
            return (Criteria) this;
        }

        public Criteria andOurAmountGreaterThan(BigDecimal value) {
            addCriterion("our_amount >", value, "ourAmount");
            return (Criteria) this;
        }

        public Criteria andOurAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("our_amount >=", value, "ourAmount");
            return (Criteria) this;
        }

        public Criteria andOurAmountLessThan(BigDecimal value) {
            addCriterion("our_amount <", value, "ourAmount");
            return (Criteria) this;
        }

        public Criteria andOurAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("our_amount <=", value, "ourAmount");
            return (Criteria) this;
        }

        public Criteria andOurAmountIn(List<BigDecimal> values) {
            addCriterion("our_amount in", values, "ourAmount");
            return (Criteria) this;
        }

        public Criteria andOurAmountNotIn(List<BigDecimal> values) {
            addCriterion("our_amount not in", values, "ourAmount");
            return (Criteria) this;
        }

        public Criteria andOurAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("our_amount between", value1, value2, "ourAmount");
            return (Criteria) this;
        }

        public Criteria andOurAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("our_amount not between", value1, value2, "ourAmount");
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