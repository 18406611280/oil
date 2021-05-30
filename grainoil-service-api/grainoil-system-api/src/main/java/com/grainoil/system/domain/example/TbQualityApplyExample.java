package com.grainoil.system.domain.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TbQualityApplyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbQualityApplyExample() {
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

        public Criteria andGrainOwnerIdIsNull() {
            addCriterion("grain_owner_id is null");
            return (Criteria) this;
        }

        public Criteria andGrainOwnerIdIsNotNull() {
            addCriterion("grain_owner_id is not null");
            return (Criteria) this;
        }

        public Criteria andGrainOwnerIdEqualTo(Integer value) {
            addCriterion("grain_owner_id =", value, "grainOwnerId");
            return (Criteria) this;
        }

        public Criteria andGrainOwnerIdNotEqualTo(Integer value) {
            addCriterion("grain_owner_id <>", value, "grainOwnerId");
            return (Criteria) this;
        }

        public Criteria andGrainOwnerIdGreaterThan(Integer value) {
            addCriterion("grain_owner_id >", value, "grainOwnerId");
            return (Criteria) this;
        }

        public Criteria andGrainOwnerIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("grain_owner_id >=", value, "grainOwnerId");
            return (Criteria) this;
        }

        public Criteria andGrainOwnerIdLessThan(Integer value) {
            addCriterion("grain_owner_id <", value, "grainOwnerId");
            return (Criteria) this;
        }

        public Criteria andGrainOwnerIdLessThanOrEqualTo(Integer value) {
            addCriterion("grain_owner_id <=", value, "grainOwnerId");
            return (Criteria) this;
        }

        public Criteria andGrainOwnerIdIn(List<Integer> values) {
            addCriterion("grain_owner_id in", values, "grainOwnerId");
            return (Criteria) this;
        }

        public Criteria andGrainOwnerIdNotIn(List<Integer> values) {
            addCriterion("grain_owner_id not in", values, "grainOwnerId");
            return (Criteria) this;
        }

        public Criteria andGrainOwnerIdBetween(Integer value1, Integer value2) {
            addCriterion("grain_owner_id between", value1, value2, "grainOwnerId");
            return (Criteria) this;
        }

        public Criteria andGrainOwnerIdNotBetween(Integer value1, Integer value2) {
            addCriterion("grain_owner_id not between", value1, value2, "grainOwnerId");
            return (Criteria) this;
        }

        public Criteria andGrainOwnerNameIsNull() {
            addCriterion("grain_owner_name is null");
            return (Criteria) this;
        }

        public Criteria andGrainOwnerNameIsNotNull() {
            addCriterion("grain_owner_name is not null");
            return (Criteria) this;
        }

        public Criteria andGrainOwnerNameEqualTo(String value) {
            addCriterion("grain_owner_name =", value, "grainOwnerName");
            return (Criteria) this;
        }

        public Criteria andGrainOwnerNameNotEqualTo(String value) {
            addCriterion("grain_owner_name <>", value, "grainOwnerName");
            return (Criteria) this;
        }

        public Criteria andGrainOwnerNameGreaterThan(String value) {
            addCriterion("grain_owner_name >", value, "grainOwnerName");
            return (Criteria) this;
        }

        public Criteria andGrainOwnerNameGreaterThanOrEqualTo(String value) {
            addCriterion("grain_owner_name >=", value, "grainOwnerName");
            return (Criteria) this;
        }

        public Criteria andGrainOwnerNameLessThan(String value) {
            addCriterion("grain_owner_name <", value, "grainOwnerName");
            return (Criteria) this;
        }

        public Criteria andGrainOwnerNameLessThanOrEqualTo(String value) {
            addCriterion("grain_owner_name <=", value, "grainOwnerName");
            return (Criteria) this;
        }

        public Criteria andGrainOwnerNameLike(String value) {
            addCriterion("grain_owner_name like", value, "grainOwnerName");
            return (Criteria) this;
        }

        public Criteria andGrainOwnerNameNotLike(String value) {
            addCriterion("grain_owner_name not like", value, "grainOwnerName");
            return (Criteria) this;
        }

        public Criteria andGrainOwnerNameIn(List<String> values) {
            addCriterion("grain_owner_name in", values, "grainOwnerName");
            return (Criteria) this;
        }

        public Criteria andGrainOwnerNameNotIn(List<String> values) {
            addCriterion("grain_owner_name not in", values, "grainOwnerName");
            return (Criteria) this;
        }

        public Criteria andGrainOwnerNameBetween(String value1, String value2) {
            addCriterion("grain_owner_name between", value1, value2, "grainOwnerName");
            return (Criteria) this;
        }

        public Criteria andGrainOwnerNameNotBetween(String value1, String value2) {
            addCriterion("grain_owner_name not between", value1, value2, "grainOwnerName");
            return (Criteria) this;
        }

        public Criteria andApplyTypeIsNull() {
            addCriterion("apply_type is null");
            return (Criteria) this;
        }

        public Criteria andApplyTypeIsNotNull() {
            addCriterion("apply_type is not null");
            return (Criteria) this;
        }

        public Criteria andApplyTypeEqualTo(String value) {
            addCriterion("apply_type =", value, "applyType");
            return (Criteria) this;
        }

        public Criteria andApplyTypeNotEqualTo(String value) {
            addCriterion("apply_type <>", value, "applyType");
            return (Criteria) this;
        }

        public Criteria andApplyTypeGreaterThan(String value) {
            addCriterion("apply_type >", value, "applyType");
            return (Criteria) this;
        }

        public Criteria andApplyTypeGreaterThanOrEqualTo(String value) {
            addCriterion("apply_type >=", value, "applyType");
            return (Criteria) this;
        }

        public Criteria andApplyTypeLessThan(String value) {
            addCriterion("apply_type <", value, "applyType");
            return (Criteria) this;
        }

        public Criteria andApplyTypeLessThanOrEqualTo(String value) {
            addCriterion("apply_type <=", value, "applyType");
            return (Criteria) this;
        }

        public Criteria andApplyTypeLike(String value) {
            addCriterion("apply_type like", value, "applyType");
            return (Criteria) this;
        }

        public Criteria andApplyTypeNotLike(String value) {
            addCriterion("apply_type not like", value, "applyType");
            return (Criteria) this;
        }

        public Criteria andApplyTypeIn(List<String> values) {
            addCriterion("apply_type in", values, "applyType");
            return (Criteria) this;
        }

        public Criteria andApplyTypeNotIn(List<String> values) {
            addCriterion("apply_type not in", values, "applyType");
            return (Criteria) this;
        }

        public Criteria andApplyTypeBetween(String value1, String value2) {
            addCriterion("apply_type between", value1, value2, "applyType");
            return (Criteria) this;
        }

        public Criteria andApplyTypeNotBetween(String value1, String value2) {
            addCriterion("apply_type not between", value1, value2, "applyType");
            return (Criteria) this;
        }

        public Criteria andApplyCodeIsNull() {
            addCriterion("apply_code is null");
            return (Criteria) this;
        }

        public Criteria andApplyCodeIsNotNull() {
            addCriterion("apply_code is not null");
            return (Criteria) this;
        }

        public Criteria andApplyCodeEqualTo(String value) {
            addCriterion("apply_code =", value, "applyCode");
            return (Criteria) this;
        }

        public Criteria andApplyCodeNotEqualTo(String value) {
            addCriterion("apply_code <>", value, "applyCode");
            return (Criteria) this;
        }

        public Criteria andApplyCodeGreaterThan(String value) {
            addCriterion("apply_code >", value, "applyCode");
            return (Criteria) this;
        }

        public Criteria andApplyCodeGreaterThanOrEqualTo(String value) {
            addCriterion("apply_code >=", value, "applyCode");
            return (Criteria) this;
        }

        public Criteria andApplyCodeLessThan(String value) {
            addCriterion("apply_code <", value, "applyCode");
            return (Criteria) this;
        }

        public Criteria andApplyCodeLessThanOrEqualTo(String value) {
            addCriterion("apply_code <=", value, "applyCode");
            return (Criteria) this;
        }

        public Criteria andApplyCodeLike(String value) {
            addCriterion("apply_code like", value, "applyCode");
            return (Criteria) this;
        }

        public Criteria andApplyCodeNotLike(String value) {
            addCriterion("apply_code not like", value, "applyCode");
            return (Criteria) this;
        }

        public Criteria andApplyCodeIn(List<String> values) {
            addCriterion("apply_code in", values, "applyCode");
            return (Criteria) this;
        }

        public Criteria andApplyCodeNotIn(List<String> values) {
            addCriterion("apply_code not in", values, "applyCode");
            return (Criteria) this;
        }

        public Criteria andApplyCodeBetween(String value1, String value2) {
            addCriterion("apply_code between", value1, value2, "applyCode");
            return (Criteria) this;
        }

        public Criteria andApplyCodeNotBetween(String value1, String value2) {
            addCriterion("apply_code not between", value1, value2, "applyCode");
            return (Criteria) this;
        }

        public Criteria andQualityOrgIsNull() {
            addCriterion("quality_org is null");
            return (Criteria) this;
        }

        public Criteria andQualityOrgIsNotNull() {
            addCriterion("quality_org is not null");
            return (Criteria) this;
        }

        public Criteria andQualityOrgEqualTo(Integer value) {
            addCriterion("quality_org =", value, "qualityOrg");
            return (Criteria) this;
        }

        public Criteria andQualityOrgNotEqualTo(Integer value) {
            addCriterion("quality_org <>", value, "qualityOrg");
            return (Criteria) this;
        }

        public Criteria andQualityOrgGreaterThan(Integer value) {
            addCriterion("quality_org >", value, "qualityOrg");
            return (Criteria) this;
        }

        public Criteria andQualityOrgGreaterThanOrEqualTo(Integer value) {
            addCriterion("quality_org >=", value, "qualityOrg");
            return (Criteria) this;
        }

        public Criteria andQualityOrgLessThan(Integer value) {
            addCriterion("quality_org <", value, "qualityOrg");
            return (Criteria) this;
        }

        public Criteria andQualityOrgLessThanOrEqualTo(Integer value) {
            addCriterion("quality_org <=", value, "qualityOrg");
            return (Criteria) this;
        }

        public Criteria andQualityOrgIn(List<Integer> values) {
            addCriterion("quality_org in", values, "qualityOrg");
            return (Criteria) this;
        }

        public Criteria andQualityOrgNotIn(List<Integer> values) {
            addCriterion("quality_org not in", values, "qualityOrg");
            return (Criteria) this;
        }

        public Criteria andQualityOrgBetween(Integer value1, Integer value2) {
            addCriterion("quality_org between", value1, value2, "qualityOrg");
            return (Criteria) this;
        }

        public Criteria andQualityOrgNotBetween(Integer value1, Integer value2) {
            addCriterion("quality_org not between", value1, value2, "qualityOrg");
            return (Criteria) this;
        }

        public Criteria andOrganizeIdIsNull() {
            addCriterion("organize_id is null");
            return (Criteria) this;
        }

        public Criteria andOrganizeIdIsNotNull() {
            addCriterion("organize_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrganizeIdEqualTo(Integer value) {
            addCriterion("organize_id =", value, "organizeId");
            return (Criteria) this;
        }

        public Criteria andOrganizeIdNotEqualTo(Integer value) {
            addCriterion("organize_id <>", value, "organizeId");
            return (Criteria) this;
        }

        public Criteria andOrganizeIdGreaterThan(Integer value) {
            addCriterion("organize_id >", value, "organizeId");
            return (Criteria) this;
        }

        public Criteria andOrganizeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("organize_id >=", value, "organizeId");
            return (Criteria) this;
        }

        public Criteria andOrganizeIdLessThan(Integer value) {
            addCriterion("organize_id <", value, "organizeId");
            return (Criteria) this;
        }

        public Criteria andOrganizeIdLessThanOrEqualTo(Integer value) {
            addCriterion("organize_id <=", value, "organizeId");
            return (Criteria) this;
        }

        public Criteria andOrganizeIdIn(List<Integer> values) {
            addCriterion("organize_id in", values, "organizeId");
            return (Criteria) this;
        }

        public Criteria andOrganizeIdNotIn(List<Integer> values) {
            addCriterion("organize_id not in", values, "organizeId");
            return (Criteria) this;
        }

        public Criteria andOrganizeIdBetween(Integer value1, Integer value2) {
            addCriterion("organize_id between", value1, value2, "organizeId");
            return (Criteria) this;
        }

        public Criteria andOrganizeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("organize_id not between", value1, value2, "organizeId");
            return (Criteria) this;
        }

        public Criteria andOrganizeNameIsNull() {
            addCriterion("organize_name is null");
            return (Criteria) this;
        }

        public Criteria andOrganizeNameIsNotNull() {
            addCriterion("organize_name is not null");
            return (Criteria) this;
        }

        public Criteria andOrganizeNameEqualTo(String value) {
            addCriterion("organize_name =", value, "organizeName");
            return (Criteria) this;
        }

        public Criteria andOrganizeNameNotEqualTo(String value) {
            addCriterion("organize_name <>", value, "organizeName");
            return (Criteria) this;
        }

        public Criteria andOrganizeNameGreaterThan(String value) {
            addCriterion("organize_name >", value, "organizeName");
            return (Criteria) this;
        }

        public Criteria andOrganizeNameGreaterThanOrEqualTo(String value) {
            addCriterion("organize_name >=", value, "organizeName");
            return (Criteria) this;
        }

        public Criteria andOrganizeNameLessThan(String value) {
            addCriterion("organize_name <", value, "organizeName");
            return (Criteria) this;
        }

        public Criteria andOrganizeNameLessThanOrEqualTo(String value) {
            addCriterion("organize_name <=", value, "organizeName");
            return (Criteria) this;
        }

        public Criteria andOrganizeNameLike(String value) {
            addCriterion("organize_name like", value, "organizeName");
            return (Criteria) this;
        }

        public Criteria andOrganizeNameNotLike(String value) {
            addCriterion("organize_name not like", value, "organizeName");
            return (Criteria) this;
        }

        public Criteria andOrganizeNameIn(List<String> values) {
            addCriterion("organize_name in", values, "organizeName");
            return (Criteria) this;
        }

        public Criteria andOrganizeNameNotIn(List<String> values) {
            addCriterion("organize_name not in", values, "organizeName");
            return (Criteria) this;
        }

        public Criteria andOrganizeNameBetween(String value1, String value2) {
            addCriterion("organize_name between", value1, value2, "organizeName");
            return (Criteria) this;
        }

        public Criteria andOrganizeNameNotBetween(String value1, String value2) {
            addCriterion("organize_name not between", value1, value2, "organizeName");
            return (Criteria) this;
        }

        public Criteria andApplyDateIsNull() {
            addCriterion("apply_date is null");
            return (Criteria) this;
        }

        public Criteria andApplyDateIsNotNull() {
            addCriterion("apply_date is not null");
            return (Criteria) this;
        }

        public Criteria andApplyDateEqualTo(Date value) {
            addCriterion("apply_date =", value, "applyDate");
            return (Criteria) this;
        }

        public Criteria andApplyDateNotEqualTo(Date value) {
            addCriterion("apply_date <>", value, "applyDate");
            return (Criteria) this;
        }

        public Criteria andApplyDateGreaterThan(Date value) {
            addCriterion("apply_date >", value, "applyDate");
            return (Criteria) this;
        }

        public Criteria andApplyDateGreaterThanOrEqualTo(Date value) {
            addCriterion("apply_date >=", value, "applyDate");
            return (Criteria) this;
        }

        public Criteria andApplyDateLessThan(Date value) {
            addCriterion("apply_date <", value, "applyDate");
            return (Criteria) this;
        }

        public Criteria andApplyDateLessThanOrEqualTo(Date value) {
            addCriterion("apply_date <=", value, "applyDate");
            return (Criteria) this;
        }

        public Criteria andApplyDateIn(List<Date> values) {
            addCriterion("apply_date in", values, "applyDate");
            return (Criteria) this;
        }

        public Criteria andApplyDateNotIn(List<Date> values) {
            addCriterion("apply_date not in", values, "applyDate");
            return (Criteria) this;
        }

        public Criteria andApplyDateBetween(Date value1, Date value2) {
            addCriterion("apply_date between", value1, value2, "applyDate");
            return (Criteria) this;
        }

        public Criteria andApplyDateNotBetween(Date value1, Date value2) {
            addCriterion("apply_date not between", value1, value2, "applyDate");
            return (Criteria) this;
        }

        public Criteria andSamplersIsNull() {
            addCriterion("samplers is null");
            return (Criteria) this;
        }

        public Criteria andSamplersIsNotNull() {
            addCriterion("samplers is not null");
            return (Criteria) this;
        }

        public Criteria andSamplersEqualTo(String value) {
            addCriterion("samplers =", value, "samplers");
            return (Criteria) this;
        }

        public Criteria andSamplersNotEqualTo(String value) {
            addCriterion("samplers <>", value, "samplers");
            return (Criteria) this;
        }

        public Criteria andSamplersGreaterThan(String value) {
            addCriterion("samplers >", value, "samplers");
            return (Criteria) this;
        }

        public Criteria andSamplersGreaterThanOrEqualTo(String value) {
            addCriterion("samplers >=", value, "samplers");
            return (Criteria) this;
        }

        public Criteria andSamplersLessThan(String value) {
            addCriterion("samplers <", value, "samplers");
            return (Criteria) this;
        }

        public Criteria andSamplersLessThanOrEqualTo(String value) {
            addCriterion("samplers <=", value, "samplers");
            return (Criteria) this;
        }

        public Criteria andSamplersLike(String value) {
            addCriterion("samplers like", value, "samplers");
            return (Criteria) this;
        }

        public Criteria andSamplersNotLike(String value) {
            addCriterion("samplers not like", value, "samplers");
            return (Criteria) this;
        }

        public Criteria andSamplersIn(List<String> values) {
            addCriterion("samplers in", values, "samplers");
            return (Criteria) this;
        }

        public Criteria andSamplersNotIn(List<String> values) {
            addCriterion("samplers not in", values, "samplers");
            return (Criteria) this;
        }

        public Criteria andSamplersBetween(String value1, String value2) {
            addCriterion("samplers between", value1, value2, "samplers");
            return (Criteria) this;
        }

        public Criteria andSamplersNotBetween(String value1, String value2) {
            addCriterion("samplers not between", value1, value2, "samplers");
            return (Criteria) this;
        }

        public Criteria andGrainDepotIdIsNull() {
            addCriterion("grain_depot_id is null");
            return (Criteria) this;
        }

        public Criteria andGrainDepotIdIsNotNull() {
            addCriterion("grain_depot_id is not null");
            return (Criteria) this;
        }

        public Criteria andGrainDepotIdEqualTo(Integer value) {
            addCriterion("grain_depot_id =", value, "grainDepotId");
            return (Criteria) this;
        }

        public Criteria andGrainDepotIdNotEqualTo(Integer value) {
            addCriterion("grain_depot_id <>", value, "grainDepotId");
            return (Criteria) this;
        }

        public Criteria andGrainDepotIdGreaterThan(Integer value) {
            addCriterion("grain_depot_id >", value, "grainDepotId");
            return (Criteria) this;
        }

        public Criteria andGrainDepotIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("grain_depot_id >=", value, "grainDepotId");
            return (Criteria) this;
        }

        public Criteria andGrainDepotIdLessThan(Integer value) {
            addCriterion("grain_depot_id <", value, "grainDepotId");
            return (Criteria) this;
        }

        public Criteria andGrainDepotIdLessThanOrEqualTo(Integer value) {
            addCriterion("grain_depot_id <=", value, "grainDepotId");
            return (Criteria) this;
        }

        public Criteria andGrainDepotIdIn(List<Integer> values) {
            addCriterion("grain_depot_id in", values, "grainDepotId");
            return (Criteria) this;
        }

        public Criteria andGrainDepotIdNotIn(List<Integer> values) {
            addCriterion("grain_depot_id not in", values, "grainDepotId");
            return (Criteria) this;
        }

        public Criteria andGrainDepotIdBetween(Integer value1, Integer value2) {
            addCriterion("grain_depot_id between", value1, value2, "grainDepotId");
            return (Criteria) this;
        }

        public Criteria andGrainDepotIdNotBetween(Integer value1, Integer value2) {
            addCriterion("grain_depot_id not between", value1, value2, "grainDepotId");
            return (Criteria) this;
        }

        public Criteria andGrainDepotNameIsNull() {
            addCriterion("grain_depot_name is null");
            return (Criteria) this;
        }

        public Criteria andGrainDepotNameIsNotNull() {
            addCriterion("grain_depot_name is not null");
            return (Criteria) this;
        }

        public Criteria andGrainDepotNameEqualTo(String value) {
            addCriterion("grain_depot_name =", value, "grainDepotName");
            return (Criteria) this;
        }

        public Criteria andGrainDepotNameNotEqualTo(String value) {
            addCriterion("grain_depot_name <>", value, "grainDepotName");
            return (Criteria) this;
        }

        public Criteria andGrainDepotNameGreaterThan(String value) {
            addCriterion("grain_depot_name >", value, "grainDepotName");
            return (Criteria) this;
        }

        public Criteria andGrainDepotNameGreaterThanOrEqualTo(String value) {
            addCriterion("grain_depot_name >=", value, "grainDepotName");
            return (Criteria) this;
        }

        public Criteria andGrainDepotNameLessThan(String value) {
            addCriterion("grain_depot_name <", value, "grainDepotName");
            return (Criteria) this;
        }

        public Criteria andGrainDepotNameLessThanOrEqualTo(String value) {
            addCriterion("grain_depot_name <=", value, "grainDepotName");
            return (Criteria) this;
        }

        public Criteria andGrainDepotNameLike(String value) {
            addCriterion("grain_depot_name like", value, "grainDepotName");
            return (Criteria) this;
        }

        public Criteria andGrainDepotNameNotLike(String value) {
            addCriterion("grain_depot_name not like", value, "grainDepotName");
            return (Criteria) this;
        }

        public Criteria andGrainDepotNameIn(List<String> values) {
            addCriterion("grain_depot_name in", values, "grainDepotName");
            return (Criteria) this;
        }

        public Criteria andGrainDepotNameNotIn(List<String> values) {
            addCriterion("grain_depot_name not in", values, "grainDepotName");
            return (Criteria) this;
        }

        public Criteria andGrainDepotNameBetween(String value1, String value2) {
            addCriterion("grain_depot_name between", value1, value2, "grainDepotName");
            return (Criteria) this;
        }

        public Criteria andGrainDepotNameNotBetween(String value1, String value2) {
            addCriterion("grain_depot_name not between", value1, value2, "grainDepotName");
            return (Criteria) this;
        }

        public Criteria andGrainDepotPositionIsNull() {
            addCriterion("grain_depot_position is null");
            return (Criteria) this;
        }

        public Criteria andGrainDepotPositionIsNotNull() {
            addCriterion("grain_depot_position is not null");
            return (Criteria) this;
        }

        public Criteria andGrainDepotPositionEqualTo(String value) {
            addCriterion("grain_depot_position =", value, "grainDepotPosition");
            return (Criteria) this;
        }

        public Criteria andGrainDepotPositionNotEqualTo(String value) {
            addCriterion("grain_depot_position <>", value, "grainDepotPosition");
            return (Criteria) this;
        }

        public Criteria andGrainDepotPositionGreaterThan(String value) {
            addCriterion("grain_depot_position >", value, "grainDepotPosition");
            return (Criteria) this;
        }

        public Criteria andGrainDepotPositionGreaterThanOrEqualTo(String value) {
            addCriterion("grain_depot_position >=", value, "grainDepotPosition");
            return (Criteria) this;
        }

        public Criteria andGrainDepotPositionLessThan(String value) {
            addCriterion("grain_depot_position <", value, "grainDepotPosition");
            return (Criteria) this;
        }

        public Criteria andGrainDepotPositionLessThanOrEqualTo(String value) {
            addCriterion("grain_depot_position <=", value, "grainDepotPosition");
            return (Criteria) this;
        }

        public Criteria andGrainDepotPositionLike(String value) {
            addCriterion("grain_depot_position like", value, "grainDepotPosition");
            return (Criteria) this;
        }

        public Criteria andGrainDepotPositionNotLike(String value) {
            addCriterion("grain_depot_position not like", value, "grainDepotPosition");
            return (Criteria) this;
        }

        public Criteria andGrainDepotPositionIn(List<String> values) {
            addCriterion("grain_depot_position in", values, "grainDepotPosition");
            return (Criteria) this;
        }

        public Criteria andGrainDepotPositionNotIn(List<String> values) {
            addCriterion("grain_depot_position not in", values, "grainDepotPosition");
            return (Criteria) this;
        }

        public Criteria andGrainDepotPositionBetween(String value1, String value2) {
            addCriterion("grain_depot_position between", value1, value2, "grainDepotPosition");
            return (Criteria) this;
        }

        public Criteria andGrainDepotPositionNotBetween(String value1, String value2) {
            addCriterion("grain_depot_position not between", value1, value2, "grainDepotPosition");
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

        public Criteria andActualSamplingDateIsNull() {
            addCriterion("actual_sampling_date is null");
            return (Criteria) this;
        }

        public Criteria andActualSamplingDateIsNotNull() {
            addCriterion("actual_sampling_date is not null");
            return (Criteria) this;
        }

        public Criteria andActualSamplingDateEqualTo(Date value) {
            addCriterionForJDBCDate("actual_sampling_date =", value, "actualSamplingDate");
            return (Criteria) this;
        }

        public Criteria andActualSamplingDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("actual_sampling_date <>", value, "actualSamplingDate");
            return (Criteria) this;
        }

        public Criteria andActualSamplingDateGreaterThan(Date value) {
            addCriterionForJDBCDate("actual_sampling_date >", value, "actualSamplingDate");
            return (Criteria) this;
        }

        public Criteria andActualSamplingDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("actual_sampling_date >=", value, "actualSamplingDate");
            return (Criteria) this;
        }

        public Criteria andActualSamplingDateLessThan(Date value) {
            addCriterionForJDBCDate("actual_sampling_date <", value, "actualSamplingDate");
            return (Criteria) this;
        }

        public Criteria andActualSamplingDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("actual_sampling_date <=", value, "actualSamplingDate");
            return (Criteria) this;
        }

        public Criteria andActualSamplingDateIn(List<Date> values) {
            addCriterionForJDBCDate("actual_sampling_date in", values, "actualSamplingDate");
            return (Criteria) this;
        }

        public Criteria andActualSamplingDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("actual_sampling_date not in", values, "actualSamplingDate");
            return (Criteria) this;
        }

        public Criteria andActualSamplingDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("actual_sampling_date between", value1, value2, "actualSamplingDate");
            return (Criteria) this;
        }

        public Criteria andActualSamplingDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("actual_sampling_date not between", value1, value2, "actualSamplingDate");
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

        public Criteria andCreateByIsNull() {
            addCriterion("create_by is null");
            return (Criteria) this;
        }

        public Criteria andCreateByIsNotNull() {
            addCriterion("create_by is not null");
            return (Criteria) this;
        }

        public Criteria andCreateByEqualTo(String value) {
            addCriterion("create_by =", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotEqualTo(String value) {
            addCriterion("create_by <>", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByGreaterThan(String value) {
            addCriterion("create_by >", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByGreaterThanOrEqualTo(String value) {
            addCriterion("create_by >=", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLessThan(String value) {
            addCriterion("create_by <", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLessThanOrEqualTo(String value) {
            addCriterion("create_by <=", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLike(String value) {
            addCriterion("create_by like", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotLike(String value) {
            addCriterion("create_by not like", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByIn(List<String> values) {
            addCriterion("create_by in", values, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotIn(List<String> values) {
            addCriterion("create_by not in", values, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByBetween(String value1, String value2) {
            addCriterion("create_by between", value1, value2, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotBetween(String value1, String value2) {
            addCriterion("create_by not between", value1, value2, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateIdIsNull() {
            addCriterion("create_id is null");
            return (Criteria) this;
        }

        public Criteria andCreateIdIsNotNull() {
            addCriterion("create_id is not null");
            return (Criteria) this;
        }

        public Criteria andCreateIdEqualTo(Integer value) {
            addCriterion("create_id =", value, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdNotEqualTo(Integer value) {
            addCriterion("create_id <>", value, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdGreaterThan(Integer value) {
            addCriterion("create_id >", value, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("create_id >=", value, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdLessThan(Integer value) {
            addCriterion("create_id <", value, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdLessThanOrEqualTo(Integer value) {
            addCriterion("create_id <=", value, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdIn(List<Integer> values) {
            addCriterion("create_id in", values, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdNotIn(List<Integer> values) {
            addCriterion("create_id not in", values, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdBetween(Integer value1, Integer value2) {
            addCriterion("create_id between", value1, value2, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdNotBetween(Integer value1, Integer value2) {
            addCriterion("create_id not between", value1, value2, "createId");
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

        public Criteria andUpdateByIsNull() {
            addCriterion("update_by is null");
            return (Criteria) this;
        }

        public Criteria andUpdateByIsNotNull() {
            addCriterion("update_by is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateByEqualTo(String value) {
            addCriterion("update_by =", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotEqualTo(String value) {
            addCriterion("update_by <>", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByGreaterThan(String value) {
            addCriterion("update_by >", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByGreaterThanOrEqualTo(String value) {
            addCriterion("update_by >=", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByLessThan(String value) {
            addCriterion("update_by <", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByLessThanOrEqualTo(String value) {
            addCriterion("update_by <=", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByLike(String value) {
            addCriterion("update_by like", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotLike(String value) {
            addCriterion("update_by not like", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByIn(List<String> values) {
            addCriterion("update_by in", values, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotIn(List<String> values) {
            addCriterion("update_by not in", values, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByBetween(String value1, String value2) {
            addCriterion("update_by between", value1, value2, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotBetween(String value1, String value2) {
            addCriterion("update_by not between", value1, value2, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateIdIsNull() {
            addCriterion("update_id is null");
            return (Criteria) this;
        }

        public Criteria andUpdateIdIsNotNull() {
            addCriterion("update_id is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateIdEqualTo(Integer value) {
            addCriterion("update_id =", value, "updateId");
            return (Criteria) this;
        }

        public Criteria andUpdateIdNotEqualTo(Integer value) {
            addCriterion("update_id <>", value, "updateId");
            return (Criteria) this;
        }

        public Criteria andUpdateIdGreaterThan(Integer value) {
            addCriterion("update_id >", value, "updateId");
            return (Criteria) this;
        }

        public Criteria andUpdateIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("update_id >=", value, "updateId");
            return (Criteria) this;
        }

        public Criteria andUpdateIdLessThan(Integer value) {
            addCriterion("update_id <", value, "updateId");
            return (Criteria) this;
        }

        public Criteria andUpdateIdLessThanOrEqualTo(Integer value) {
            addCriterion("update_id <=", value, "updateId");
            return (Criteria) this;
        }

        public Criteria andUpdateIdIn(List<Integer> values) {
            addCriterion("update_id in", values, "updateId");
            return (Criteria) this;
        }

        public Criteria andUpdateIdNotIn(List<Integer> values) {
            addCriterion("update_id not in", values, "updateId");
            return (Criteria) this;
        }

        public Criteria andUpdateIdBetween(Integer value1, Integer value2) {
            addCriterion("update_id between", value1, value2, "updateId");
            return (Criteria) this;
        }

        public Criteria andUpdateIdNotBetween(Integer value1, Integer value2) {
            addCriterion("update_id not between", value1, value2, "updateId");
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

        public Criteria andDelFlagIsNull() {
            addCriterion("del_flag is null");
            return (Criteria) this;
        }

        public Criteria andDelFlagIsNotNull() {
            addCriterion("del_flag is not null");
            return (Criteria) this;
        }

        public Criteria andDelFlagEqualTo(String value) {
            addCriterion("del_flag =", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagNotEqualTo(String value) {
            addCriterion("del_flag <>", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagGreaterThan(String value) {
            addCriterion("del_flag >", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagGreaterThanOrEqualTo(String value) {
            addCriterion("del_flag >=", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagLessThan(String value) {
            addCriterion("del_flag <", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagLessThanOrEqualTo(String value) {
            addCriterion("del_flag <=", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagLike(String value) {
            addCriterion("del_flag like", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagNotLike(String value) {
            addCriterion("del_flag not like", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagIn(List<String> values) {
            addCriterion("del_flag in", values, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagNotIn(List<String> values) {
            addCriterion("del_flag not in", values, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagBetween(String value1, String value2) {
            addCriterion("del_flag between", value1, value2, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagNotBetween(String value1, String value2) {
            addCriterion("del_flag not between", value1, value2, "delFlag");
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