package com.els.runhe.statisticAnalysis.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.els.base.core.entity.AbstractExample;
import com.els.base.core.entity.PageView;

public class OrderStatisticAnalysisExample extends AbstractExample<OrderStatisticAnalysis> implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;
    
    private String categoryId;
    
    private String companyId;
    
    private String orderTime;
    
    private String companyIds;
    
    private String id;

    protected PageView<OrderStatisticAnalysis> pageView = new PageView<OrderStatisticAnalysis>(1, 10);

    private static final long serialVersionUID = 1L;

    
    
    public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}

	public OrderStatisticAnalysisExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public String getCompanyIds() {
		return companyIds;
	}

	public void setCompanyIds(String companyIds) {
		this.companyIds = companyIds;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
    public PageView<OrderStatisticAnalysis> getPageView() {
        return pageView;
    }

    @Override
    public void setPageView(PageView<OrderStatisticAnalysis> pageView) {
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
        
        public Criteria andCompanyIdEqualTo(String value) {
        	if(StringUtils.isNotEmpty(value) && !"null".equals(value)){
        		addCriterion("top.company_id =", value, "companyId");
        		addCriterion("tbc.id =", value, "companyId");
        	}
            return (Criteria) this;
        }
        public Criteria andIdIn(List<String> values) {
        		addCriterion("tbc.id in", values, "id");
            return (Criteria) this;
        }
        public Criteria andPurCompanyIdIn(List<String> values) {
	    	addCriterion("tos.pur_company_id in", values, "purCompanyId");
	        return (Criteria) this;
	    }
        public Criteria andOrderTimeEqualTo(String value) {
        	if(StringUtils.isNotEmpty(value) && !"null".equals(value)){
        		addCriterion("DATE_FORMAT(tos.add_time,'%Y-%m') =", value, "orderTime");
        	}
            return (Criteria) this;
        }
        //
        public Criteria andCategoryIdEqualTo(String value) {
        	if(StringUtils.isNotEmpty(value) && !"null".equals(value)){
        		addCriterion("top.category_id =", value, "categoryId");
        	}
            return (Criteria) this;
        }
        public Criteria andQueryDateEqualTo(String value) {
        	if("1".equals(value)){
        		// 周
        		addCriterion("tos.add_time >= date_sub(curdate(),INTERVAL WEEKDAY(curdate()) DAY) and tos.add_time <= date_sub(curdate(),INTERVAL WEEKDAY(curdate()) - 6 DAY)");
        	}else if ("2".equals(value)){
        		// 月
        		addCriterion("tos.add_time >= concat(date_format(LAST_DAY(now()),'%Y-%m-'),'01') and tos.add_time <= LAST_DAY(now())");
        	}else if ("3".equals(value)){
        		//季度
        		addCriterion("tos.add_time >= concat(date_format(LAST_DAY(MAKEDATE(EXTRACT(YEAR FROM  CURDATE()),1) + interval QUARTER(CURDATE())*3-3 month),'%Y-%m-'),'01') and tos.add_time <= LAST_DAY(MAKEDATE(EXTRACT(YEAR  FROM CURDATE()),1) + interval QUARTER(CURDATE())*3-1 month)");
        	}else if ("4".equals(value)){
        		//天
        		addCriterion("tos.add_time >= concat(date_format(LAST_DAY(MAKEDATE(EXTRACT(YEAR FROM  CURDATE()),1) + interval QUARTER(CURDATE())*3-3 month),'%Y-%m-'),'01') and tos.add_time <= LAST_DAY(MAKEDATE(EXTRACT(YEAR  FROM CURDATE()),1) + interval QUARTER(CURDATE())*3-1 month)");
        	}
        	return (Criteria) this;
        }
        public Criteria andDeliveryTimeEqualTo(String value) {
    		addCriterion("date_format(tos.delivery_time,'%Y-%m-%d') = '" + value + "'");
        	return (Criteria) this;
        }
        public Criteria andDeliveryStatusEqualTo(String value) {
    		addCriterion("tos.delivery_status = '400' ");
        	return (Criteria) this;
        }
        public Criteria andProvinceEqualTo(String value) {
        	if(StringUtils.isNotEmpty(value) && !"null".equals(value)){
        		addCriterion("tbc.province =", value, "province");
        	}
        	return (Criteria) this;
        }
        public Criteria andCityEqualTo(String value) {
        	if(StringUtils.isNotEmpty(value) && !"null".equals(value)){
        		addCriterion("tbc.city =", value, "city");
        	}
        	return (Criteria) this;
        }
        public Criteria andDistrictEqualTo(String value) {
        	if(StringUtils.isNotEmpty(value) && !"null".equals(value)){
        		addCriterion("tbc.district =", value, "district");
        	}
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