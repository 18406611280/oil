package com.grainoil.system.domain.example;

import java.util.ArrayList;
import java.util.List;

public class TbQualityCheckResultExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbQualityCheckResultExample() {
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

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

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

        public Criteria andSamplingCodeIsNull() {
            addCriterion("sampling_code is null");
            return (Criteria) this;
        }

        public Criteria andSamplingCodeIsNotNull() {
            addCriterion("sampling_code is not null");
            return (Criteria) this;
        }

        public Criteria andSamplingCodeEqualTo(String value) {
            addCriterion("sampling_code =", value, "samplingCode");
            return (Criteria) this;
        }

        public Criteria andSamplingCodeNotEqualTo(String value) {
            addCriterion("sampling_code <>", value, "samplingCode");
            return (Criteria) this;
        }

        public Criteria andSamplingCodeGreaterThan(String value) {
            addCriterion("sampling_code >", value, "samplingCode");
            return (Criteria) this;
        }

        public Criteria andSamplingCodeGreaterThanOrEqualTo(String value) {
            addCriterion("sampling_code >=", value, "samplingCode");
            return (Criteria) this;
        }

        public Criteria andSamplingCodeLessThan(String value) {
            addCriterion("sampling_code <", value, "samplingCode");
            return (Criteria) this;
        }

        public Criteria andSamplingCodeLessThanOrEqualTo(String value) {
            addCriterion("sampling_code <=", value, "samplingCode");
            return (Criteria) this;
        }

        public Criteria andSamplingCodeLike(String value) {
            addCriterion("sampling_code like", value, "samplingCode");
            return (Criteria) this;
        }

        public Criteria andSamplingCodeNotLike(String value) {
            addCriterion("sampling_code not like", value, "samplingCode");
            return (Criteria) this;
        }

        public Criteria andSamplingCodeIn(List<String> values) {
            addCriterion("sampling_code in", values, "samplingCode");
            return (Criteria) this;
        }

        public Criteria andSamplingCodeNotIn(List<String> values) {
            addCriterion("sampling_code not in", values, "samplingCode");
            return (Criteria) this;
        }

        public Criteria andSamplingCodeBetween(String value1, String value2) {
            addCriterion("sampling_code between", value1, value2, "samplingCode");
            return (Criteria) this;
        }

        public Criteria andSamplingCodeNotBetween(String value1, String value2) {
            addCriterion("sampling_code not between", value1, value2, "samplingCode");
            return (Criteria) this;
        }

        public Criteria andQualityCheckIdIsNull() {
            addCriterion("quality_check_id is null");
            return (Criteria) this;
        }

        public Criteria andQualityCheckIdIsNotNull() {
            addCriterion("quality_check_id is not null");
            return (Criteria) this;
        }

        public Criteria andQualityCheckIdEqualTo(Integer value) {
            addCriterion("quality_check_id =", value, "qualityCheckId");
            return (Criteria) this;
        }

        public Criteria andQualityCheckIdNotEqualTo(Integer value) {
            addCriterion("quality_check_id <>", value, "qualityCheckId");
            return (Criteria) this;
        }

        public Criteria andQualityCheckIdGreaterThan(Integer value) {
            addCriterion("quality_check_id >", value, "qualityCheckId");
            return (Criteria) this;
        }

        public Criteria andQualityCheckIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("quality_check_id >=", value, "qualityCheckId");
            return (Criteria) this;
        }

        public Criteria andQualityCheckIdLessThan(Integer value) {
            addCriterion("quality_check_id <", value, "qualityCheckId");
            return (Criteria) this;
        }

        public Criteria andQualityCheckIdLessThanOrEqualTo(Integer value) {
            addCriterion("quality_check_id <=", value, "qualityCheckId");
            return (Criteria) this;
        }

        public Criteria andQualityCheckIdIn(List<Integer> values) {
            addCriterion("quality_check_id in", values, "qualityCheckId");
            return (Criteria) this;
        }

        public Criteria andQualityCheckIdNotIn(List<Integer> values) {
            addCriterion("quality_check_id not in", values, "qualityCheckId");
            return (Criteria) this;
        }

        public Criteria andQualityCheckIdBetween(Integer value1, Integer value2) {
            addCriterion("quality_check_id between", value1, value2, "qualityCheckId");
            return (Criteria) this;
        }

        public Criteria andQualityCheckIdNotBetween(Integer value1, Integer value2) {
            addCriterion("quality_check_id not between", value1, value2, "qualityCheckId");
            return (Criteria) this;
        }

        public Criteria andQualityCheckResultIsNull() {
            addCriterion("quality_check_result is null");
            return (Criteria) this;
        }

        public Criteria andQualityCheckResultIsNotNull() {
            addCriterion("quality_check_result is not null");
            return (Criteria) this;
        }

        public Criteria andQualityCheckResultEqualTo(String value) {
            addCriterion("quality_check_result =", value, "qualityCheckResult");
            return (Criteria) this;
        }

        public Criteria andQualityCheckResultNotEqualTo(String value) {
            addCriterion("quality_check_result <>", value, "qualityCheckResult");
            return (Criteria) this;
        }

        public Criteria andQualityCheckResultGreaterThan(String value) {
            addCriterion("quality_check_result >", value, "qualityCheckResult");
            return (Criteria) this;
        }

        public Criteria andQualityCheckResultGreaterThanOrEqualTo(String value) {
            addCriterion("quality_check_result >=", value, "qualityCheckResult");
            return (Criteria) this;
        }

        public Criteria andQualityCheckResultLessThan(String value) {
            addCriterion("quality_check_result <", value, "qualityCheckResult");
            return (Criteria) this;
        }

        public Criteria andQualityCheckResultLessThanOrEqualTo(String value) {
            addCriterion("quality_check_result <=", value, "qualityCheckResult");
            return (Criteria) this;
        }

        public Criteria andQualityCheckResultLike(String value) {
            addCriterion("quality_check_result like", value, "qualityCheckResult");
            return (Criteria) this;
        }

        public Criteria andQualityCheckResultNotLike(String value) {
            addCriterion("quality_check_result not like", value, "qualityCheckResult");
            return (Criteria) this;
        }

        public Criteria andQualityCheckResultIn(List<String> values) {
            addCriterion("quality_check_result in", values, "qualityCheckResult");
            return (Criteria) this;
        }

        public Criteria andQualityCheckResultNotIn(List<String> values) {
            addCriterion("quality_check_result not in", values, "qualityCheckResult");
            return (Criteria) this;
        }

        public Criteria andQualityCheckResultBetween(String value1, String value2) {
            addCriterion("quality_check_result between", value1, value2, "qualityCheckResult");
            return (Criteria) this;
        }

        public Criteria andQualityCheckResultNotBetween(String value1, String value2) {
            addCriterion("quality_check_result not between", value1, value2, "qualityCheckResult");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

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