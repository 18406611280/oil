package com.grainoil.system.domain.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TbQualityApplyDetailedExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbQualityApplyDetailedExample() {
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

        public Criteria andApplyIdIsNull() {
            addCriterion("apply_id is null");
            return (Criteria) this;
        }

        public Criteria andApplyIdIsNotNull() {
            addCriterion("apply_id is not null");
            return (Criteria) this;
        }

        public Criteria andApplyIdEqualTo(Integer value) {
            addCriterion("apply_id =", value, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdNotEqualTo(Integer value) {
            addCriterion("apply_id <>", value, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdGreaterThan(Integer value) {
            addCriterion("apply_id >", value, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("apply_id >=", value, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdLessThan(Integer value) {
            addCriterion("apply_id <", value, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdLessThanOrEqualTo(Integer value) {
            addCriterion("apply_id <=", value, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdIn(List<Integer> values) {
            addCriterion("apply_id in", values, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdNotIn(List<Integer> values) {
            addCriterion("apply_id not in", values, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdBetween(Integer value1, Integer value2) {
            addCriterion("apply_id between", value1, value2, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdNotBetween(Integer value1, Integer value2) {
            addCriterion("apply_id not between", value1, value2, "applyId");
            return (Criteria) this;
        }

        public Criteria andVarietyIdIsNull() {
            addCriterion("variety_id is null");
            return (Criteria) this;
        }

        public Criteria andVarietyIdIsNotNull() {
            addCriterion("variety_id is not null");
            return (Criteria) this;
        }

        public Criteria andVarietyIdEqualTo(Integer value) {
            addCriterion("variety_id =", value, "varietyId");
            return (Criteria) this;
        }

        public Criteria andVarietyIdNotEqualTo(Integer value) {
            addCriterion("variety_id <>", value, "varietyId");
            return (Criteria) this;
        }

        public Criteria andVarietyIdGreaterThan(Integer value) {
            addCriterion("variety_id >", value, "varietyId");
            return (Criteria) this;
        }

        public Criteria andVarietyIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("variety_id >=", value, "varietyId");
            return (Criteria) this;
        }

        public Criteria andVarietyIdLessThan(Integer value) {
            addCriterion("variety_id <", value, "varietyId");
            return (Criteria) this;
        }

        public Criteria andVarietyIdLessThanOrEqualTo(Integer value) {
            addCriterion("variety_id <=", value, "varietyId");
            return (Criteria) this;
        }

        public Criteria andVarietyIdIn(List<Integer> values) {
            addCriterion("variety_id in", values, "varietyId");
            return (Criteria) this;
        }

        public Criteria andVarietyIdNotIn(List<Integer> values) {
            addCriterion("variety_id not in", values, "varietyId");
            return (Criteria) this;
        }

        public Criteria andVarietyIdBetween(Integer value1, Integer value2) {
            addCriterion("variety_id between", value1, value2, "varietyId");
            return (Criteria) this;
        }

        public Criteria andVarietyIdNotBetween(Integer value1, Integer value2) {
            addCriterion("variety_id not between", value1, value2, "varietyId");
            return (Criteria) this;
        }

        public Criteria andSampleCodeIsNull() {
            addCriterion("sample_code is null");
            return (Criteria) this;
        }

        public Criteria andSampleCodeIsNotNull() {
            addCriterion("sample_code is not null");
            return (Criteria) this;
        }

        public Criteria andSampleCodeEqualTo(String value) {
            addCriterion("sample_code =", value, "sampleCode");
            return (Criteria) this;
        }

        public Criteria andSampleCodeNotEqualTo(String value) {
            addCriterion("sample_code <>", value, "sampleCode");
            return (Criteria) this;
        }

        public Criteria andSampleCodeGreaterThan(String value) {
            addCriterion("sample_code >", value, "sampleCode");
            return (Criteria) this;
        }

        public Criteria andSampleCodeGreaterThanOrEqualTo(String value) {
            addCriterion("sample_code >=", value, "sampleCode");
            return (Criteria) this;
        }

        public Criteria andSampleCodeLessThan(String value) {
            addCriterion("sample_code <", value, "sampleCode");
            return (Criteria) this;
        }

        public Criteria andSampleCodeLessThanOrEqualTo(String value) {
            addCriterion("sample_code <=", value, "sampleCode");
            return (Criteria) this;
        }

        public Criteria andSampleCodeLike(String value) {
            addCriterion("sample_code like", value, "sampleCode");
            return (Criteria) this;
        }

        public Criteria andSampleCodeNotLike(String value) {
            addCriterion("sample_code not like", value, "sampleCode");
            return (Criteria) this;
        }

        public Criteria andSampleCodeIn(List<String> values) {
            addCriterion("sample_code in", values, "sampleCode");
            return (Criteria) this;
        }

        public Criteria andSampleCodeNotIn(List<String> values) {
            addCriterion("sample_code not in", values, "sampleCode");
            return (Criteria) this;
        }

        public Criteria andSampleCodeBetween(String value1, String value2) {
            addCriterion("sample_code between", value1, value2, "sampleCode");
            return (Criteria) this;
        }

        public Criteria andSampleCodeNotBetween(String value1, String value2) {
            addCriterion("sample_code not between", value1, value2, "sampleCode");
            return (Criteria) this;
        }

        public Criteria andVarietyIsNull() {
            addCriterion("variety is null");
            return (Criteria) this;
        }

        public Criteria andVarietyIsNotNull() {
            addCriterion("variety is not null");
            return (Criteria) this;
        }

        public Criteria andVarietyEqualTo(String value) {
            addCriterion("variety =", value, "variety");
            return (Criteria) this;
        }

        public Criteria andVarietyNotEqualTo(String value) {
            addCriterion("variety <>", value, "variety");
            return (Criteria) this;
        }

        public Criteria andVarietyGreaterThan(String value) {
            addCriterion("variety >", value, "variety");
            return (Criteria) this;
        }

        public Criteria andVarietyGreaterThanOrEqualTo(String value) {
            addCriterion("variety >=", value, "variety");
            return (Criteria) this;
        }

        public Criteria andVarietyLessThan(String value) {
            addCriterion("variety <", value, "variety");
            return (Criteria) this;
        }

        public Criteria andVarietyLessThanOrEqualTo(String value) {
            addCriterion("variety <=", value, "variety");
            return (Criteria) this;
        }

        public Criteria andVarietyLike(String value) {
            addCriterion("variety like", value, "variety");
            return (Criteria) this;
        }

        public Criteria andVarietyNotLike(String value) {
            addCriterion("variety not like", value, "variety");
            return (Criteria) this;
        }

        public Criteria andVarietyIn(List<String> values) {
            addCriterion("variety in", values, "variety");
            return (Criteria) this;
        }

        public Criteria andVarietyNotIn(List<String> values) {
            addCriterion("variety not in", values, "variety");
            return (Criteria) this;
        }

        public Criteria andVarietyBetween(String value1, String value2) {
            addCriterion("variety between", value1, value2, "variety");
            return (Criteria) this;
        }

        public Criteria andVarietyNotBetween(String value1, String value2) {
            addCriterion("variety not between", value1, value2, "variety");
            return (Criteria) this;
        }

        public Criteria andSampleNameIsNull() {
            addCriterion("sample_name is null");
            return (Criteria) this;
        }

        public Criteria andSampleNameIsNotNull() {
            addCriterion("sample_name is not null");
            return (Criteria) this;
        }

        public Criteria andSampleNameEqualTo(String value) {
            addCriterion("sample_name =", value, "sampleName");
            return (Criteria) this;
        }

        public Criteria andSampleNameNotEqualTo(String value) {
            addCriterion("sample_name <>", value, "sampleName");
            return (Criteria) this;
        }

        public Criteria andSampleNameGreaterThan(String value) {
            addCriterion("sample_name >", value, "sampleName");
            return (Criteria) this;
        }

        public Criteria andSampleNameGreaterThanOrEqualTo(String value) {
            addCriterion("sample_name >=", value, "sampleName");
            return (Criteria) this;
        }

        public Criteria andSampleNameLessThan(String value) {
            addCriterion("sample_name <", value, "sampleName");
            return (Criteria) this;
        }

        public Criteria andSampleNameLessThanOrEqualTo(String value) {
            addCriterion("sample_name <=", value, "sampleName");
            return (Criteria) this;
        }

        public Criteria andSampleNameLike(String value) {
            addCriterion("sample_name like", value, "sampleName");
            return (Criteria) this;
        }

        public Criteria andSampleNameNotLike(String value) {
            addCriterion("sample_name not like", value, "sampleName");
            return (Criteria) this;
        }

        public Criteria andSampleNameIn(List<String> values) {
            addCriterion("sample_name in", values, "sampleName");
            return (Criteria) this;
        }

        public Criteria andSampleNameNotIn(List<String> values) {
            addCriterion("sample_name not in", values, "sampleName");
            return (Criteria) this;
        }

        public Criteria andSampleNameBetween(String value1, String value2) {
            addCriterion("sample_name between", value1, value2, "sampleName");
            return (Criteria) this;
        }

        public Criteria andSampleNameNotBetween(String value1, String value2) {
            addCriterion("sample_name not between", value1, value2, "sampleName");
            return (Criteria) this;
        }

        public Criteria andStorehouseIdIsNull() {
            addCriterion("storehouse_id is null");
            return (Criteria) this;
        }

        public Criteria andStorehouseIdIsNotNull() {
            addCriterion("storehouse_id is not null");
            return (Criteria) this;
        }

        public Criteria andStorehouseIdEqualTo(Integer value) {
            addCriterion("storehouse_id =", value, "storehouseId");
            return (Criteria) this;
        }

        public Criteria andStorehouseIdNotEqualTo(Integer value) {
            addCriterion("storehouse_id <>", value, "storehouseId");
            return (Criteria) this;
        }

        public Criteria andStorehouseIdGreaterThan(Integer value) {
            addCriterion("storehouse_id >", value, "storehouseId");
            return (Criteria) this;
        }

        public Criteria andStorehouseIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("storehouse_id >=", value, "storehouseId");
            return (Criteria) this;
        }

        public Criteria andStorehouseIdLessThan(Integer value) {
            addCriterion("storehouse_id <", value, "storehouseId");
            return (Criteria) this;
        }

        public Criteria andStorehouseIdLessThanOrEqualTo(Integer value) {
            addCriterion("storehouse_id <=", value, "storehouseId");
            return (Criteria) this;
        }

        public Criteria andStorehouseIdIn(List<Integer> values) {
            addCriterion("storehouse_id in", values, "storehouseId");
            return (Criteria) this;
        }

        public Criteria andStorehouseIdNotIn(List<Integer> values) {
            addCriterion("storehouse_id not in", values, "storehouseId");
            return (Criteria) this;
        }

        public Criteria andStorehouseIdBetween(Integer value1, Integer value2) {
            addCriterion("storehouse_id between", value1, value2, "storehouseId");
            return (Criteria) this;
        }

        public Criteria andStorehouseIdNotBetween(Integer value1, Integer value2) {
            addCriterion("storehouse_id not between", value1, value2, "storehouseId");
            return (Criteria) this;
        }

        public Criteria andStorehouseNameIsNull() {
            addCriterion("storehouse_name is null");
            return (Criteria) this;
        }

        public Criteria andStorehouseNameIsNotNull() {
            addCriterion("storehouse_name is not null");
            return (Criteria) this;
        }

        public Criteria andStorehouseNameEqualTo(String value) {
            addCriterion("storehouse_name =", value, "storehouseName");
            return (Criteria) this;
        }

        public Criteria andStorehouseNameNotEqualTo(String value) {
            addCriterion("storehouse_name <>", value, "storehouseName");
            return (Criteria) this;
        }

        public Criteria andStorehouseNameGreaterThan(String value) {
            addCriterion("storehouse_name >", value, "storehouseName");
            return (Criteria) this;
        }

        public Criteria andStorehouseNameGreaterThanOrEqualTo(String value) {
            addCriterion("storehouse_name >=", value, "storehouseName");
            return (Criteria) this;
        }

        public Criteria andStorehouseNameLessThan(String value) {
            addCriterion("storehouse_name <", value, "storehouseName");
            return (Criteria) this;
        }

        public Criteria andStorehouseNameLessThanOrEqualTo(String value) {
            addCriterion("storehouse_name <=", value, "storehouseName");
            return (Criteria) this;
        }

        public Criteria andStorehouseNameLike(String value) {
            addCriterion("storehouse_name like", value, "storehouseName");
            return (Criteria) this;
        }

        public Criteria andStorehouseNameNotLike(String value) {
            addCriterion("storehouse_name not like", value, "storehouseName");
            return (Criteria) this;
        }

        public Criteria andStorehouseNameIn(List<String> values) {
            addCriterion("storehouse_name in", values, "storehouseName");
            return (Criteria) this;
        }

        public Criteria andStorehouseNameNotIn(List<String> values) {
            addCriterion("storehouse_name not in", values, "storehouseName");
            return (Criteria) this;
        }

        public Criteria andStorehouseNameBetween(String value1, String value2) {
            addCriterion("storehouse_name between", value1, value2, "storehouseName");
            return (Criteria) this;
        }

        public Criteria andStorehouseNameNotBetween(String value1, String value2) {
            addCriterion("storehouse_name not between", value1, value2, "storehouseName");
            return (Criteria) this;
        }

        public Criteria andHeapIdIsNull() {
            addCriterion("heap_id is null");
            return (Criteria) this;
        }

        public Criteria andHeapIdIsNotNull() {
            addCriterion("heap_id is not null");
            return (Criteria) this;
        }

        public Criteria andHeapIdEqualTo(Integer value) {
            addCriterion("heap_id =", value, "heapId");
            return (Criteria) this;
        }

        public Criteria andHeapIdNotEqualTo(Integer value) {
            addCriterion("heap_id <>", value, "heapId");
            return (Criteria) this;
        }

        public Criteria andHeapIdGreaterThan(Integer value) {
            addCriterion("heap_id >", value, "heapId");
            return (Criteria) this;
        }

        public Criteria andHeapIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("heap_id >=", value, "heapId");
            return (Criteria) this;
        }

        public Criteria andHeapIdLessThan(Integer value) {
            addCriterion("heap_id <", value, "heapId");
            return (Criteria) this;
        }

        public Criteria andHeapIdLessThanOrEqualTo(Integer value) {
            addCriterion("heap_id <=", value, "heapId");
            return (Criteria) this;
        }

        public Criteria andHeapIdIn(List<Integer> values) {
            addCriterion("heap_id in", values, "heapId");
            return (Criteria) this;
        }

        public Criteria andHeapIdNotIn(List<Integer> values) {
            addCriterion("heap_id not in", values, "heapId");
            return (Criteria) this;
        }

        public Criteria andHeapIdBetween(Integer value1, Integer value2) {
            addCriterion("heap_id between", value1, value2, "heapId");
            return (Criteria) this;
        }

        public Criteria andHeapIdNotBetween(Integer value1, Integer value2) {
            addCriterion("heap_id not between", value1, value2, "heapId");
            return (Criteria) this;
        }

        public Criteria andHeapNameIsNull() {
            addCriterion("heap_name is null");
            return (Criteria) this;
        }

        public Criteria andHeapNameIsNotNull() {
            addCriterion("heap_name is not null");
            return (Criteria) this;
        }

        public Criteria andHeapNameEqualTo(String value) {
            addCriterion("heap_name =", value, "heapName");
            return (Criteria) this;
        }

        public Criteria andHeapNameNotEqualTo(String value) {
            addCriterion("heap_name <>", value, "heapName");
            return (Criteria) this;
        }

        public Criteria andHeapNameGreaterThan(String value) {
            addCriterion("heap_name >", value, "heapName");
            return (Criteria) this;
        }

        public Criteria andHeapNameGreaterThanOrEqualTo(String value) {
            addCriterion("heap_name >=", value, "heapName");
            return (Criteria) this;
        }

        public Criteria andHeapNameLessThan(String value) {
            addCriterion("heap_name <", value, "heapName");
            return (Criteria) this;
        }

        public Criteria andHeapNameLessThanOrEqualTo(String value) {
            addCriterion("heap_name <=", value, "heapName");
            return (Criteria) this;
        }

        public Criteria andHeapNameLike(String value) {
            addCriterion("heap_name like", value, "heapName");
            return (Criteria) this;
        }

        public Criteria andHeapNameNotLike(String value) {
            addCriterion("heap_name not like", value, "heapName");
            return (Criteria) this;
        }

        public Criteria andHeapNameIn(List<String> values) {
            addCriterion("heap_name in", values, "heapName");
            return (Criteria) this;
        }

        public Criteria andHeapNameNotIn(List<String> values) {
            addCriterion("heap_name not in", values, "heapName");
            return (Criteria) this;
        }

        public Criteria andHeapNameBetween(String value1, String value2) {
            addCriterion("heap_name between", value1, value2, "heapName");
            return (Criteria) this;
        }

        public Criteria andHeapNameNotBetween(String value1, String value2) {
            addCriterion("heap_name not between", value1, value2, "heapName");
            return (Criteria) this;
        }

        public Criteria andQuantityIsNull() {
            addCriterion("quantity is null");
            return (Criteria) this;
        }

        public Criteria andQuantityIsNotNull() {
            addCriterion("quantity is not null");
            return (Criteria) this;
        }

        public Criteria andQuantityEqualTo(Double value) {
            addCriterion("quantity =", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityNotEqualTo(Double value) {
            addCriterion("quantity <>", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityGreaterThan(Double value) {
            addCriterion("quantity >", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityGreaterThanOrEqualTo(Double value) {
            addCriterion("quantity >=", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityLessThan(Double value) {
            addCriterion("quantity <", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityLessThanOrEqualTo(Double value) {
            addCriterion("quantity <=", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityIn(List<Double> values) {
            addCriterion("quantity in", values, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityNotIn(List<Double> values) {
            addCriterion("quantity not in", values, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityBetween(Double value1, Double value2) {
            addCriterion("quantity between", value1, value2, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityNotBetween(Double value1, Double value2) {
            addCriterion("quantity not between", value1, value2, "quantity");
            return (Criteria) this;
        }

        public Criteria andProducingAreaIsNull() {
            addCriterion("producing_area is null");
            return (Criteria) this;
        }

        public Criteria andProducingAreaIsNotNull() {
            addCriterion("producing_area is not null");
            return (Criteria) this;
        }

        public Criteria andProducingAreaEqualTo(String value) {
            addCriterion("producing_area =", value, "producingArea");
            return (Criteria) this;
        }

        public Criteria andProducingAreaNotEqualTo(String value) {
            addCriterion("producing_area <>", value, "producingArea");
            return (Criteria) this;
        }

        public Criteria andProducingAreaGreaterThan(String value) {
            addCriterion("producing_area >", value, "producingArea");
            return (Criteria) this;
        }

        public Criteria andProducingAreaGreaterThanOrEqualTo(String value) {
            addCriterion("producing_area >=", value, "producingArea");
            return (Criteria) this;
        }

        public Criteria andProducingAreaLessThan(String value) {
            addCriterion("producing_area <", value, "producingArea");
            return (Criteria) this;
        }

        public Criteria andProducingAreaLessThanOrEqualTo(String value) {
            addCriterion("producing_area <=", value, "producingArea");
            return (Criteria) this;
        }

        public Criteria andProducingAreaLike(String value) {
            addCriterion("producing_area like", value, "producingArea");
            return (Criteria) this;
        }

        public Criteria andProducingAreaNotLike(String value) {
            addCriterion("producing_area not like", value, "producingArea");
            return (Criteria) this;
        }

        public Criteria andProducingAreaIn(List<String> values) {
            addCriterion("producing_area in", values, "producingArea");
            return (Criteria) this;
        }

        public Criteria andProducingAreaNotIn(List<String> values) {
            addCriterion("producing_area not in", values, "producingArea");
            return (Criteria) this;
        }

        public Criteria andProducingAreaBetween(String value1, String value2) {
            addCriterion("producing_area between", value1, value2, "producingArea");
            return (Criteria) this;
        }

        public Criteria andProducingAreaNotBetween(String value1, String value2) {
            addCriterion("producing_area not between", value1, value2, "producingArea");
            return (Criteria) this;
        }

        public Criteria andParticularYearIsNull() {
            addCriterion("particular_year is null");
            return (Criteria) this;
        }

        public Criteria andParticularYearIsNotNull() {
            addCriterion("particular_year is not null");
            return (Criteria) this;
        }

        public Criteria andParticularYearEqualTo(Date value) {
            addCriterionForJDBCDate("particular_year =", value, "particularYear");
            return (Criteria) this;
        }

        public Criteria andParticularYearNotEqualTo(Date value) {
            addCriterionForJDBCDate("particular_year <>", value, "particularYear");
            return (Criteria) this;
        }

        public Criteria andParticularYearGreaterThan(Date value) {
            addCriterionForJDBCDate("particular_year >", value, "particularYear");
            return (Criteria) this;
        }

        public Criteria andParticularYearGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("particular_year >=", value, "particularYear");
            return (Criteria) this;
        }

        public Criteria andParticularYearLessThan(Date value) {
            addCriterionForJDBCDate("particular_year <", value, "particularYear");
            return (Criteria) this;
        }

        public Criteria andParticularYearLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("particular_year <=", value, "particularYear");
            return (Criteria) this;
        }

        public Criteria andParticularYearIn(List<Date> values) {
            addCriterionForJDBCDate("particular_year in", values, "particularYear");
            return (Criteria) this;
        }

        public Criteria andParticularYearNotIn(List<Date> values) {
            addCriterionForJDBCDate("particular_year not in", values, "particularYear");
            return (Criteria) this;
        }

        public Criteria andParticularYearBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("particular_year between", value1, value2, "particularYear");
            return (Criteria) this;
        }

        public Criteria andParticularYearNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("particular_year not between", value1, value2, "particularYear");
            return (Criteria) this;
        }

        public Criteria andStorageDateIsNull() {
            addCriterion("storage_date is null");
            return (Criteria) this;
        }

        public Criteria andStorageDateIsNotNull() {
            addCriterion("storage_date is not null");
            return (Criteria) this;
        }

        public Criteria andStorageDateEqualTo(Date value) {
            addCriterionForJDBCDate("storage_date =", value, "storageDate");
            return (Criteria) this;
        }

        public Criteria andStorageDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("storage_date <>", value, "storageDate");
            return (Criteria) this;
        }

        public Criteria andStorageDateGreaterThan(Date value) {
            addCriterionForJDBCDate("storage_date >", value, "storageDate");
            return (Criteria) this;
        }

        public Criteria andStorageDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("storage_date >=", value, "storageDate");
            return (Criteria) this;
        }

        public Criteria andStorageDateLessThan(Date value) {
            addCriterionForJDBCDate("storage_date <", value, "storageDate");
            return (Criteria) this;
        }

        public Criteria andStorageDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("storage_date <=", value, "storageDate");
            return (Criteria) this;
        }

        public Criteria andStorageDateIn(List<Date> values) {
            addCriterionForJDBCDate("storage_date in", values, "storageDate");
            return (Criteria) this;
        }

        public Criteria andStorageDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("storage_date not in", values, "storageDate");
            return (Criteria) this;
        }

        public Criteria andStorageDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("storage_date between", value1, value2, "storageDate");
            return (Criteria) this;
        }

        public Criteria andStorageDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("storage_date not between", value1, value2, "storageDate");
            return (Criteria) this;
        }

        public Criteria andBatchCodeIsNull() {
            addCriterion("batch_code is null");
            return (Criteria) this;
        }

        public Criteria andBatchCodeIsNotNull() {
            addCriterion("batch_code is not null");
            return (Criteria) this;
        }

        public Criteria andBatchCodeEqualTo(String value) {
            addCriterion("batch_code =", value, "batchCode");
            return (Criteria) this;
        }

        public Criteria andBatchCodeNotEqualTo(String value) {
            addCriterion("batch_code <>", value, "batchCode");
            return (Criteria) this;
        }

        public Criteria andBatchCodeGreaterThan(String value) {
            addCriterion("batch_code >", value, "batchCode");
            return (Criteria) this;
        }

        public Criteria andBatchCodeGreaterThanOrEqualTo(String value) {
            addCriterion("batch_code >=", value, "batchCode");
            return (Criteria) this;
        }

        public Criteria andBatchCodeLessThan(String value) {
            addCriterion("batch_code <", value, "batchCode");
            return (Criteria) this;
        }

        public Criteria andBatchCodeLessThanOrEqualTo(String value) {
            addCriterion("batch_code <=", value, "batchCode");
            return (Criteria) this;
        }

        public Criteria andBatchCodeLike(String value) {
            addCriterion("batch_code like", value, "batchCode");
            return (Criteria) this;
        }

        public Criteria andBatchCodeNotLike(String value) {
            addCriterion("batch_code not like", value, "batchCode");
            return (Criteria) this;
        }

        public Criteria andBatchCodeIn(List<String> values) {
            addCriterion("batch_code in", values, "batchCode");
            return (Criteria) this;
        }

        public Criteria andBatchCodeNotIn(List<String> values) {
            addCriterion("batch_code not in", values, "batchCode");
            return (Criteria) this;
        }

        public Criteria andBatchCodeBetween(String value1, String value2) {
            addCriterion("batch_code between", value1, value2, "batchCode");
            return (Criteria) this;
        }

        public Criteria andBatchCodeNotBetween(String value1, String value2) {
            addCriterion("batch_code not between", value1, value2, "batchCode");
            return (Criteria) this;
        }

        public Criteria andGradeIsNull() {
            addCriterion("grade is null");
            return (Criteria) this;
        }

        public Criteria andGradeIsNotNull() {
            addCriterion("grade is not null");
            return (Criteria) this;
        }

        public Criteria andGradeEqualTo(String value) {
            addCriterion("grade =", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeNotEqualTo(String value) {
            addCriterion("grade <>", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeGreaterThan(String value) {
            addCriterion("grade >", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeGreaterThanOrEqualTo(String value) {
            addCriterion("grade >=", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeLessThan(String value) {
            addCriterion("grade <", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeLessThanOrEqualTo(String value) {
            addCriterion("grade <=", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeLike(String value) {
            addCriterion("grade like", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeNotLike(String value) {
            addCriterion("grade not like", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeIn(List<String> values) {
            addCriterion("grade in", values, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeNotIn(List<String> values) {
            addCriterion("grade not in", values, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeBetween(String value1, String value2) {
            addCriterion("grade between", value1, value2, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeNotBetween(String value1, String value2) {
            addCriterion("grade not between", value1, value2, "grade");
            return (Criteria) this;
        }

        public Criteria andPackingTypeIsNull() {
            addCriterion("packing_type is null");
            return (Criteria) this;
        }

        public Criteria andPackingTypeIsNotNull() {
            addCriterion("packing_type is not null");
            return (Criteria) this;
        }

        public Criteria andPackingTypeEqualTo(String value) {
            addCriterion("packing_type =", value, "packingType");
            return (Criteria) this;
        }

        public Criteria andPackingTypeNotEqualTo(String value) {
            addCriterion("packing_type <>", value, "packingType");
            return (Criteria) this;
        }

        public Criteria andPackingTypeGreaterThan(String value) {
            addCriterion("packing_type >", value, "packingType");
            return (Criteria) this;
        }

        public Criteria andPackingTypeGreaterThanOrEqualTo(String value) {
            addCriterion("packing_type >=", value, "packingType");
            return (Criteria) this;
        }

        public Criteria andPackingTypeLessThan(String value) {
            addCriterion("packing_type <", value, "packingType");
            return (Criteria) this;
        }

        public Criteria andPackingTypeLessThanOrEqualTo(String value) {
            addCriterion("packing_type <=", value, "packingType");
            return (Criteria) this;
        }

        public Criteria andPackingTypeLike(String value) {
            addCriterion("packing_type like", value, "packingType");
            return (Criteria) this;
        }

        public Criteria andPackingTypeNotLike(String value) {
            addCriterion("packing_type not like", value, "packingType");
            return (Criteria) this;
        }

        public Criteria andPackingTypeIn(List<String> values) {
            addCriterion("packing_type in", values, "packingType");
            return (Criteria) this;
        }

        public Criteria andPackingTypeNotIn(List<String> values) {
            addCriterion("packing_type not in", values, "packingType");
            return (Criteria) this;
        }

        public Criteria andPackingTypeBetween(String value1, String value2) {
            addCriterion("packing_type between", value1, value2, "packingType");
            return (Criteria) this;
        }

        public Criteria andPackingTypeNotBetween(String value1, String value2) {
            addCriterion("packing_type not between", value1, value2, "packingType");
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

        public Criteria andContractIdIsNull() {
            addCriterion("contract_id is null");
            return (Criteria) this;
        }

        public Criteria andContractIdIsNotNull() {
            addCriterion("contract_id is not null");
            return (Criteria) this;
        }

        public Criteria andContractIdEqualTo(Integer value) {
            addCriterion("contract_id =", value, "contractId");
            return (Criteria) this;
        }

        public Criteria andContractIdNotEqualTo(Integer value) {
            addCriterion("contract_id <>", value, "contractId");
            return (Criteria) this;
        }

        public Criteria andContractIdGreaterThan(Integer value) {
            addCriterion("contract_id >", value, "contractId");
            return (Criteria) this;
        }

        public Criteria andContractIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("contract_id >=", value, "contractId");
            return (Criteria) this;
        }

        public Criteria andContractIdLessThan(Integer value) {
            addCriterion("contract_id <", value, "contractId");
            return (Criteria) this;
        }

        public Criteria andContractIdLessThanOrEqualTo(Integer value) {
            addCriterion("contract_id <=", value, "contractId");
            return (Criteria) this;
        }

        public Criteria andContractIdIn(List<Integer> values) {
            addCriterion("contract_id in", values, "contractId");
            return (Criteria) this;
        }

        public Criteria andContractIdNotIn(List<Integer> values) {
            addCriterion("contract_id not in", values, "contractId");
            return (Criteria) this;
        }

        public Criteria andContractIdBetween(Integer value1, Integer value2) {
            addCriterion("contract_id between", value1, value2, "contractId");
            return (Criteria) this;
        }

        public Criteria andContractIdNotBetween(Integer value1, Integer value2) {
            addCriterion("contract_id not between", value1, value2, "contractId");
            return (Criteria) this;
        }

        public Criteria andReceiptIdIsNull() {
            addCriterion("receipt_id is null");
            return (Criteria) this;
        }

        public Criteria andReceiptIdIsNotNull() {
            addCriterion("receipt_id is not null");
            return (Criteria) this;
        }

        public Criteria andReceiptIdEqualTo(Integer value) {
            addCriterion("receipt_id =", value, "receiptId");
            return (Criteria) this;
        }

        public Criteria andReceiptIdNotEqualTo(Integer value) {
            addCriterion("receipt_id <>", value, "receiptId");
            return (Criteria) this;
        }

        public Criteria andReceiptIdGreaterThan(Integer value) {
            addCriterion("receipt_id >", value, "receiptId");
            return (Criteria) this;
        }

        public Criteria andReceiptIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("receipt_id >=", value, "receiptId");
            return (Criteria) this;
        }

        public Criteria andReceiptIdLessThan(Integer value) {
            addCriterion("receipt_id <", value, "receiptId");
            return (Criteria) this;
        }

        public Criteria andReceiptIdLessThanOrEqualTo(Integer value) {
            addCriterion("receipt_id <=", value, "receiptId");
            return (Criteria) this;
        }

        public Criteria andReceiptIdIn(List<Integer> values) {
            addCriterion("receipt_id in", values, "receiptId");
            return (Criteria) this;
        }

        public Criteria andReceiptIdNotIn(List<Integer> values) {
            addCriterion("receipt_id not in", values, "receiptId");
            return (Criteria) this;
        }

        public Criteria andReceiptIdBetween(Integer value1, Integer value2) {
            addCriterion("receipt_id between", value1, value2, "receiptId");
            return (Criteria) this;
        }

        public Criteria andReceiptIdNotBetween(Integer value1, Integer value2) {
            addCriterion("receipt_id not between", value1, value2, "receiptId");
            return (Criteria) this;
        }

        public Criteria andSamplingTimeIsNull() {
            addCriterion("sampling_time is null");
            return (Criteria) this;
        }

        public Criteria andSamplingTimeIsNotNull() {
            addCriterion("sampling_time is not null");
            return (Criteria) this;
        }

        public Criteria andSamplingTimeEqualTo(Date value) {
            addCriterion("sampling_time =", value, "samplingTime");
            return (Criteria) this;
        }

        public Criteria andSamplingTimeNotEqualTo(Date value) {
            addCriterion("sampling_time <>", value, "samplingTime");
            return (Criteria) this;
        }

        public Criteria andSamplingTimeGreaterThan(Date value) {
            addCriterion("sampling_time >", value, "samplingTime");
            return (Criteria) this;
        }

        public Criteria andSamplingTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("sampling_time >=", value, "samplingTime");
            return (Criteria) this;
        }

        public Criteria andSamplingTimeLessThan(Date value) {
            addCriterion("sampling_time <", value, "samplingTime");
            return (Criteria) this;
        }

        public Criteria andSamplingTimeLessThanOrEqualTo(Date value) {
            addCriterion("sampling_time <=", value, "samplingTime");
            return (Criteria) this;
        }

        public Criteria andSamplingTimeIn(List<Date> values) {
            addCriterion("sampling_time in", values, "samplingTime");
            return (Criteria) this;
        }

        public Criteria andSamplingTimeNotIn(List<Date> values) {
            addCriterion("sampling_time not in", values, "samplingTime");
            return (Criteria) this;
        }

        public Criteria andSamplingTimeBetween(Date value1, Date value2) {
            addCriterion("sampling_time between", value1, value2, "samplingTime");
            return (Criteria) this;
        }

        public Criteria andSamplingTimeNotBetween(Date value1, Date value2) {
            addCriterion("sampling_time not between", value1, value2, "samplingTime");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(String value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(String value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(String value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(String value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(String value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(String value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLike(String value) {
            addCriterion("state like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotLike(String value) {
            addCriterion("state not like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<String> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<String> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(String value1, String value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(String value1, String value2) {
            addCriterion("state not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andEnclosureIsNull() {
            addCriterion("enclosure is null");
            return (Criteria) this;
        }

        public Criteria andEnclosureIsNotNull() {
            addCriterion("enclosure is not null");
            return (Criteria) this;
        }

        public Criteria andEnclosureEqualTo(String value) {
            addCriterion("enclosure =", value, "enclosure");
            return (Criteria) this;
        }

        public Criteria andEnclosureNotEqualTo(String value) {
            addCriterion("enclosure <>", value, "enclosure");
            return (Criteria) this;
        }

        public Criteria andEnclosureGreaterThan(String value) {
            addCriterion("enclosure >", value, "enclosure");
            return (Criteria) this;
        }

        public Criteria andEnclosureGreaterThanOrEqualTo(String value) {
            addCriterion("enclosure >=", value, "enclosure");
            return (Criteria) this;
        }

        public Criteria andEnclosureLessThan(String value) {
            addCriterion("enclosure <", value, "enclosure");
            return (Criteria) this;
        }

        public Criteria andEnclosureLessThanOrEqualTo(String value) {
            addCriterion("enclosure <=", value, "enclosure");
            return (Criteria) this;
        }

        public Criteria andEnclosureLike(String value) {
            addCriterion("enclosure like", value, "enclosure");
            return (Criteria) this;
        }

        public Criteria andEnclosureNotLike(String value) {
            addCriterion("enclosure not like", value, "enclosure");
            return (Criteria) this;
        }

        public Criteria andEnclosureIn(List<String> values) {
            addCriterion("enclosure in", values, "enclosure");
            return (Criteria) this;
        }

        public Criteria andEnclosureNotIn(List<String> values) {
            addCriterion("enclosure not in", values, "enclosure");
            return (Criteria) this;
        }

        public Criteria andEnclosureBetween(String value1, String value2) {
            addCriterion("enclosure between", value1, value2, "enclosure");
            return (Criteria) this;
        }

        public Criteria andEnclosureNotBetween(String value1, String value2) {
            addCriterion("enclosure not between", value1, value2, "enclosure");
            return (Criteria) this;
        }

        public Criteria andReportNameIsNull() {
            addCriterion("report_name is null");
            return (Criteria) this;
        }

        public Criteria andReportNameIsNotNull() {
            addCriterion("report_name is not null");
            return (Criteria) this;
        }

        public Criteria andReportNameEqualTo(String value) {
            addCriterion("report_name =", value, "reportName");
            return (Criteria) this;
        }

        public Criteria andReportNameNotEqualTo(String value) {
            addCriterion("report_name <>", value, "reportName");
            return (Criteria) this;
        }

        public Criteria andReportNameGreaterThan(String value) {
            addCriterion("report_name >", value, "reportName");
            return (Criteria) this;
        }

        public Criteria andReportNameGreaterThanOrEqualTo(String value) {
            addCriterion("report_name >=", value, "reportName");
            return (Criteria) this;
        }

        public Criteria andReportNameLessThan(String value) {
            addCriterion("report_name <", value, "reportName");
            return (Criteria) this;
        }

        public Criteria andReportNameLessThanOrEqualTo(String value) {
            addCriterion("report_name <=", value, "reportName");
            return (Criteria) this;
        }

        public Criteria andReportNameLike(String value) {
            addCriterion("report_name like", value, "reportName");
            return (Criteria) this;
        }

        public Criteria andReportNameNotLike(String value) {
            addCriterion("report_name not like", value, "reportName");
            return (Criteria) this;
        }

        public Criteria andReportNameIn(List<String> values) {
            addCriterion("report_name in", values, "reportName");
            return (Criteria) this;
        }

        public Criteria andReportNameNotIn(List<String> values) {
            addCriterion("report_name not in", values, "reportName");
            return (Criteria) this;
        }

        public Criteria andReportNameBetween(String value1, String value2) {
            addCriterion("report_name between", value1, value2, "reportName");
            return (Criteria) this;
        }

        public Criteria andReportNameNotBetween(String value1, String value2) {
            addCriterion("report_name not between", value1, value2, "reportName");
            return (Criteria) this;
        }

        public Criteria andCheckResultIsNull() {
            addCriterion("check_result is null");
            return (Criteria) this;
        }

        public Criteria andCheckResultIsNotNull() {
            addCriterion("check_result is not null");
            return (Criteria) this;
        }

        public Criteria andCheckResultEqualTo(String value) {
            addCriterion("check_result =", value, "checkResult");
            return (Criteria) this;
        }

        public Criteria andCheckResultNotEqualTo(String value) {
            addCriterion("check_result <>", value, "checkResult");
            return (Criteria) this;
        }

        public Criteria andCheckResultGreaterThan(String value) {
            addCriterion("check_result >", value, "checkResult");
            return (Criteria) this;
        }

        public Criteria andCheckResultGreaterThanOrEqualTo(String value) {
            addCriterion("check_result >=", value, "checkResult");
            return (Criteria) this;
        }

        public Criteria andCheckResultLessThan(String value) {
            addCriterion("check_result <", value, "checkResult");
            return (Criteria) this;
        }

        public Criteria andCheckResultLessThanOrEqualTo(String value) {
            addCriterion("check_result <=", value, "checkResult");
            return (Criteria) this;
        }

        public Criteria andCheckResultLike(String value) {
            addCriterion("check_result like", value, "checkResult");
            return (Criteria) this;
        }

        public Criteria andCheckResultNotLike(String value) {
            addCriterion("check_result not like", value, "checkResult");
            return (Criteria) this;
        }

        public Criteria andCheckResultIn(List<String> values) {
            addCriterion("check_result in", values, "checkResult");
            return (Criteria) this;
        }

        public Criteria andCheckResultNotIn(List<String> values) {
            addCriterion("check_result not in", values, "checkResult");
            return (Criteria) this;
        }

        public Criteria andCheckResultBetween(String value1, String value2) {
            addCriterion("check_result between", value1, value2, "checkResult");
            return (Criteria) this;
        }

        public Criteria andCheckResultNotBetween(String value1, String value2) {
            addCriterion("check_result not between", value1, value2, "checkResult");
            return (Criteria) this;
        }

        public Criteria andReportCodeIsNull() {
            addCriterion("report_code is null");
            return (Criteria) this;
        }

        public Criteria andReportCodeIsNotNull() {
            addCriterion("report_code is not null");
            return (Criteria) this;
        }

        public Criteria andReportCodeEqualTo(String value) {
            addCriterion("report_code =", value, "reportCode");
            return (Criteria) this;
        }

        public Criteria andReportCodeNotEqualTo(String value) {
            addCriterion("report_code <>", value, "reportCode");
            return (Criteria) this;
        }

        public Criteria andReportCodeGreaterThan(String value) {
            addCriterion("report_code >", value, "reportCode");
            return (Criteria) this;
        }

        public Criteria andReportCodeGreaterThanOrEqualTo(String value) {
            addCriterion("report_code >=", value, "reportCode");
            return (Criteria) this;
        }

        public Criteria andReportCodeLessThan(String value) {
            addCriterion("report_code <", value, "reportCode");
            return (Criteria) this;
        }

        public Criteria andReportCodeLessThanOrEqualTo(String value) {
            addCriterion("report_code <=", value, "reportCode");
            return (Criteria) this;
        }

        public Criteria andReportCodeLike(String value) {
            addCriterion("report_code like", value, "reportCode");
            return (Criteria) this;
        }

        public Criteria andReportCodeNotLike(String value) {
            addCriterion("report_code not like", value, "reportCode");
            return (Criteria) this;
        }

        public Criteria andReportCodeIn(List<String> values) {
            addCriterion("report_code in", values, "reportCode");
            return (Criteria) this;
        }

        public Criteria andReportCodeNotIn(List<String> values) {
            addCriterion("report_code not in", values, "reportCode");
            return (Criteria) this;
        }

        public Criteria andReportCodeBetween(String value1, String value2) {
            addCriterion("report_code between", value1, value2, "reportCode");
            return (Criteria) this;
        }

        public Criteria andReportCodeNotBetween(String value1, String value2) {
            addCriterion("report_code not between", value1, value2, "reportCode");
            return (Criteria) this;
        }

        public Criteria andReportTimeIsNull() {
            addCriterion("report_time is null");
            return (Criteria) this;
        }

        public Criteria andReportTimeIsNotNull() {
            addCriterion("report_time is not null");
            return (Criteria) this;
        }

        public Criteria andReportTimeEqualTo(Date value) {
            addCriterion("report_time =", value, "reportTime");
            return (Criteria) this;
        }

        public Criteria andReportTimeNotEqualTo(Date value) {
            addCriterion("report_time <>", value, "reportTime");
            return (Criteria) this;
        }

        public Criteria andReportTimeGreaterThan(Date value) {
            addCriterion("report_time >", value, "reportTime");
            return (Criteria) this;
        }

        public Criteria andReportTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("report_time >=", value, "reportTime");
            return (Criteria) this;
        }

        public Criteria andReportTimeLessThan(Date value) {
            addCriterion("report_time <", value, "reportTime");
            return (Criteria) this;
        }

        public Criteria andReportTimeLessThanOrEqualTo(Date value) {
            addCriterion("report_time <=", value, "reportTime");
            return (Criteria) this;
        }

        public Criteria andReportTimeIn(List<Date> values) {
            addCriterion("report_time in", values, "reportTime");
            return (Criteria) this;
        }

        public Criteria andReportTimeNotIn(List<Date> values) {
            addCriterion("report_time not in", values, "reportTime");
            return (Criteria) this;
        }

        public Criteria andReportTimeBetween(Date value1, Date value2) {
            addCriterion("report_time between", value1, value2, "reportTime");
            return (Criteria) this;
        }

        public Criteria andReportTimeNotBetween(Date value1, Date value2) {
            addCriterion("report_time not between", value1, value2, "reportTime");
            return (Criteria) this;
        }

        public Criteria andExamineCycleIsNull() {
            addCriterion("examine_cycle is null");
            return (Criteria) this;
        }

        public Criteria andExamineCycleIsNotNull() {
            addCriterion("examine_cycle is not null");
            return (Criteria) this;
        }

        public Criteria andExamineCycleEqualTo(Integer value) {
            addCriterion("examine_cycle =", value, "examineCycle");
            return (Criteria) this;
        }

        public Criteria andExamineCycleNotEqualTo(Integer value) {
            addCriterion("examine_cycle <>", value, "examineCycle");
            return (Criteria) this;
        }

        public Criteria andExamineCycleGreaterThan(Integer value) {
            addCriterion("examine_cycle >", value, "examineCycle");
            return (Criteria) this;
        }

        public Criteria andExamineCycleGreaterThanOrEqualTo(Integer value) {
            addCriterion("examine_cycle >=", value, "examineCycle");
            return (Criteria) this;
        }

        public Criteria andExamineCycleLessThan(Integer value) {
            addCriterion("examine_cycle <", value, "examineCycle");
            return (Criteria) this;
        }

        public Criteria andExamineCycleLessThanOrEqualTo(Integer value) {
            addCriterion("examine_cycle <=", value, "examineCycle");
            return (Criteria) this;
        }

        public Criteria andExamineCycleIn(List<Integer> values) {
            addCriterion("examine_cycle in", values, "examineCycle");
            return (Criteria) this;
        }

        public Criteria andExamineCycleNotIn(List<Integer> values) {
            addCriterion("examine_cycle not in", values, "examineCycle");
            return (Criteria) this;
        }

        public Criteria andExamineCycleBetween(Integer value1, Integer value2) {
            addCriterion("examine_cycle between", value1, value2, "examineCycle");
            return (Criteria) this;
        }

        public Criteria andExamineCycleNotBetween(Integer value1, Integer value2) {
            addCriterion("examine_cycle not between", value1, value2, "examineCycle");
            return (Criteria) this;
        }

        public Criteria andIsOverdueIsNull() {
            addCriterion("is_overdue is null");
            return (Criteria) this;
        }

        public Criteria andIsOverdueIsNotNull() {
            addCriterion("is_overdue is not null");
            return (Criteria) this;
        }

        public Criteria andIsOverdueEqualTo(String value) {
            addCriterion("is_overdue =", value, "isOverdue");
            return (Criteria) this;
        }

        public Criteria andIsOverdueNotEqualTo(String value) {
            addCriterion("is_overdue <>", value, "isOverdue");
            return (Criteria) this;
        }

        public Criteria andIsOverdueGreaterThan(String value) {
            addCriterion("is_overdue >", value, "isOverdue");
            return (Criteria) this;
        }

        public Criteria andIsOverdueGreaterThanOrEqualTo(String value) {
            addCriterion("is_overdue >=", value, "isOverdue");
            return (Criteria) this;
        }

        public Criteria andIsOverdueLessThan(String value) {
            addCriterion("is_overdue <", value, "isOverdue");
            return (Criteria) this;
        }

        public Criteria andIsOverdueLessThanOrEqualTo(String value) {
            addCriterion("is_overdue <=", value, "isOverdue");
            return (Criteria) this;
        }

        public Criteria andIsOverdueLike(String value) {
            addCriterion("is_overdue like", value, "isOverdue");
            return (Criteria) this;
        }

        public Criteria andIsOverdueNotLike(String value) {
            addCriterion("is_overdue not like", value, "isOverdue");
            return (Criteria) this;
        }

        public Criteria andIsOverdueIn(List<String> values) {
            addCriterion("is_overdue in", values, "isOverdue");
            return (Criteria) this;
        }

        public Criteria andIsOverdueNotIn(List<String> values) {
            addCriterion("is_overdue not in", values, "isOverdue");
            return (Criteria) this;
        }

        public Criteria andIsOverdueBetween(String value1, String value2) {
            addCriterion("is_overdue between", value1, value2, "isOverdue");
            return (Criteria) this;
        }

        public Criteria andIsOverdueNotBetween(String value1, String value2) {
            addCriterion("is_overdue not between", value1, value2, "isOverdue");
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