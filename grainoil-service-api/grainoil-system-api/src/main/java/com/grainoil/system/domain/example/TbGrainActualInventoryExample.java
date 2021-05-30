package com.grainoil.system.domain.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TbGrainActualInventoryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbGrainActualInventoryExample() {
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

        public Criteria andChildHeapIdIsNull() {
            addCriterion("child_heap_id is null");
            return (Criteria) this;
        }

        public Criteria andChildHeapIdIsNotNull() {
            addCriterion("child_heap_id is not null");
            return (Criteria) this;
        }

        public Criteria andChildHeapIdEqualTo(Integer value) {
            addCriterion("child_heap_id =", value, "childHeapId");
            return (Criteria) this;
        }

        public Criteria andChildHeapIdNotEqualTo(Integer value) {
            addCriterion("child_heap_id <>", value, "childHeapId");
            return (Criteria) this;
        }

        public Criteria andChildHeapIdGreaterThan(Integer value) {
            addCriterion("child_heap_id >", value, "childHeapId");
            return (Criteria) this;
        }

        public Criteria andChildHeapIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("child_heap_id >=", value, "childHeapId");
            return (Criteria) this;
        }

        public Criteria andChildHeapIdLessThan(Integer value) {
            addCriterion("child_heap_id <", value, "childHeapId");
            return (Criteria) this;
        }

        public Criteria andChildHeapIdLessThanOrEqualTo(Integer value) {
            addCriterion("child_heap_id <=", value, "childHeapId");
            return (Criteria) this;
        }

        public Criteria andChildHeapIdIn(List<Integer> values) {
            addCriterion("child_heap_id in", values, "childHeapId");
            return (Criteria) this;
        }

        public Criteria andChildHeapIdNotIn(List<Integer> values) {
            addCriterion("child_heap_id not in", values, "childHeapId");
            return (Criteria) this;
        }

        public Criteria andChildHeapIdBetween(Integer value1, Integer value2) {
            addCriterion("child_heap_id between", value1, value2, "childHeapId");
            return (Criteria) this;
        }

        public Criteria andChildHeapIdNotBetween(Integer value1, Integer value2) {
            addCriterion("child_heap_id not between", value1, value2, "childHeapId");
            return (Criteria) this;
        }

        public Criteria andChildHeapCodeIsNull() {
            addCriterion("child_heap_code is null");
            return (Criteria) this;
        }

        public Criteria andChildHeapCodeIsNotNull() {
            addCriterion("child_heap_code is not null");
            return (Criteria) this;
        }

        public Criteria andChildHeapCodeEqualTo(String value) {
            addCriterion("child_heap_code =", value, "childHeapCode");
            return (Criteria) this;
        }

        public Criteria andChildHeapCodeNotEqualTo(String value) {
            addCriterion("child_heap_code <>", value, "childHeapCode");
            return (Criteria) this;
        }

        public Criteria andChildHeapCodeGreaterThan(String value) {
            addCriterion("child_heap_code >", value, "childHeapCode");
            return (Criteria) this;
        }

        public Criteria andChildHeapCodeGreaterThanOrEqualTo(String value) {
            addCriterion("child_heap_code >=", value, "childHeapCode");
            return (Criteria) this;
        }

        public Criteria andChildHeapCodeLessThan(String value) {
            addCriterion("child_heap_code <", value, "childHeapCode");
            return (Criteria) this;
        }

        public Criteria andChildHeapCodeLessThanOrEqualTo(String value) {
            addCriterion("child_heap_code <=", value, "childHeapCode");
            return (Criteria) this;
        }

        public Criteria andChildHeapCodeLike(String value) {
            addCriterion("child_heap_code like", value, "childHeapCode");
            return (Criteria) this;
        }

        public Criteria andChildHeapCodeNotLike(String value) {
            addCriterion("child_heap_code not like", value, "childHeapCode");
            return (Criteria) this;
        }

        public Criteria andChildHeapCodeIn(List<String> values) {
            addCriterion("child_heap_code in", values, "childHeapCode");
            return (Criteria) this;
        }

        public Criteria andChildHeapCodeNotIn(List<String> values) {
            addCriterion("child_heap_code not in", values, "childHeapCode");
            return (Criteria) this;
        }

        public Criteria andChildHeapCodeBetween(String value1, String value2) {
            addCriterion("child_heap_code between", value1, value2, "childHeapCode");
            return (Criteria) this;
        }

        public Criteria andChildHeapCodeNotBetween(String value1, String value2) {
            addCriterion("child_heap_code not between", value1, value2, "childHeapCode");
            return (Criteria) this;
        }

        public Criteria andHeapStateIsNull() {
            addCriterion("heap_state is null");
            return (Criteria) this;
        }

        public Criteria andHeapStateIsNotNull() {
            addCriterion("heap_state is not null");
            return (Criteria) this;
        }

        public Criteria andHeapStateEqualTo(String value) {
            addCriterion("heap_state =", value, "heapState");
            return (Criteria) this;
        }

        public Criteria andHeapStateNotEqualTo(String value) {
            addCriterion("heap_state <>", value, "heapState");
            return (Criteria) this;
        }

        public Criteria andHeapStateGreaterThan(String value) {
            addCriterion("heap_state >", value, "heapState");
            return (Criteria) this;
        }

        public Criteria andHeapStateGreaterThanOrEqualTo(String value) {
            addCriterion("heap_state >=", value, "heapState");
            return (Criteria) this;
        }

        public Criteria andHeapStateLessThan(String value) {
            addCriterion("heap_state <", value, "heapState");
            return (Criteria) this;
        }

        public Criteria andHeapStateLessThanOrEqualTo(String value) {
            addCriterion("heap_state <=", value, "heapState");
            return (Criteria) this;
        }

        public Criteria andHeapStateLike(String value) {
            addCriterion("heap_state like", value, "heapState");
            return (Criteria) this;
        }

        public Criteria andHeapStateNotLike(String value) {
            addCriterion("heap_state not like", value, "heapState");
            return (Criteria) this;
        }

        public Criteria andHeapStateIn(List<String> values) {
            addCriterion("heap_state in", values, "heapState");
            return (Criteria) this;
        }

        public Criteria andHeapStateNotIn(List<String> values) {
            addCriterion("heap_state not in", values, "heapState");
            return (Criteria) this;
        }

        public Criteria andHeapStateBetween(String value1, String value2) {
            addCriterion("heap_state between", value1, value2, "heapState");
            return (Criteria) this;
        }

        public Criteria andHeapStateNotBetween(String value1, String value2) {
            addCriterion("heap_state not between", value1, value2, "heapState");
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

        public Criteria andChildVarietiesIsNull() {
            addCriterion("child_varieties is null");
            return (Criteria) this;
        }

        public Criteria andChildVarietiesIsNotNull() {
            addCriterion("child_varieties is not null");
            return (Criteria) this;
        }

        public Criteria andChildVarietiesEqualTo(String value) {
            addCriterion("child_varieties =", value, "childVarieties");
            return (Criteria) this;
        }

        public Criteria andChildVarietiesNotEqualTo(String value) {
            addCriterion("child_varieties <>", value, "childVarieties");
            return (Criteria) this;
        }

        public Criteria andChildVarietiesGreaterThan(String value) {
            addCriterion("child_varieties >", value, "childVarieties");
            return (Criteria) this;
        }

        public Criteria andChildVarietiesGreaterThanOrEqualTo(String value) {
            addCriterion("child_varieties >=", value, "childVarieties");
            return (Criteria) this;
        }

        public Criteria andChildVarietiesLessThan(String value) {
            addCriterion("child_varieties <", value, "childVarieties");
            return (Criteria) this;
        }

        public Criteria andChildVarietiesLessThanOrEqualTo(String value) {
            addCriterion("child_varieties <=", value, "childVarieties");
            return (Criteria) this;
        }

        public Criteria andChildVarietiesLike(String value) {
            addCriterion("child_varieties like", value, "childVarieties");
            return (Criteria) this;
        }

        public Criteria andChildVarietiesNotLike(String value) {
            addCriterion("child_varieties not like", value, "childVarieties");
            return (Criteria) this;
        }

        public Criteria andChildVarietiesIn(List<String> values) {
            addCriterion("child_varieties in", values, "childVarieties");
            return (Criteria) this;
        }

        public Criteria andChildVarietiesNotIn(List<String> values) {
            addCriterion("child_varieties not in", values, "childVarieties");
            return (Criteria) this;
        }

        public Criteria andChildVarietiesBetween(String value1, String value2) {
            addCriterion("child_varieties between", value1, value2, "childVarieties");
            return (Criteria) this;
        }

        public Criteria andChildVarietiesNotBetween(String value1, String value2) {
            addCriterion("child_varieties not between", value1, value2, "childVarieties");
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

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(Double value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(Double value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(Double value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(Double value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(Double value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(Double value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<Double> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<Double> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(Double value1, Double value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(Double value1, Double value2) {
            addCriterion("price not between", value1, value2, "price");
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

        public Criteria andPackingIsNull() {
            addCriterion("packing is null");
            return (Criteria) this;
        }

        public Criteria andPackingIsNotNull() {
            addCriterion("packing is not null");
            return (Criteria) this;
        }

        public Criteria andPackingEqualTo(String value) {
            addCriterion("packing =", value, "packing");
            return (Criteria) this;
        }

        public Criteria andPackingNotEqualTo(String value) {
            addCriterion("packing <>", value, "packing");
            return (Criteria) this;
        }

        public Criteria andPackingGreaterThan(String value) {
            addCriterion("packing >", value, "packing");
            return (Criteria) this;
        }

        public Criteria andPackingGreaterThanOrEqualTo(String value) {
            addCriterion("packing >=", value, "packing");
            return (Criteria) this;
        }

        public Criteria andPackingLessThan(String value) {
            addCriterion("packing <", value, "packing");
            return (Criteria) this;
        }

        public Criteria andPackingLessThanOrEqualTo(String value) {
            addCriterion("packing <=", value, "packing");
            return (Criteria) this;
        }

        public Criteria andPackingLike(String value) {
            addCriterion("packing like", value, "packing");
            return (Criteria) this;
        }

        public Criteria andPackingNotLike(String value) {
            addCriterion("packing not like", value, "packing");
            return (Criteria) this;
        }

        public Criteria andPackingIn(List<String> values) {
            addCriterion("packing in", values, "packing");
            return (Criteria) this;
        }

        public Criteria andPackingNotIn(List<String> values) {
            addCriterion("packing not in", values, "packing");
            return (Criteria) this;
        }

        public Criteria andPackingBetween(String value1, String value2) {
            addCriterion("packing between", value1, value2, "packing");
            return (Criteria) this;
        }

        public Criteria andPackingNotBetween(String value1, String value2) {
            addCriterion("packing not between", value1, value2, "packing");
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

        public Criteria andBagsCountIsNull() {
            addCriterion("bags_count is null");
            return (Criteria) this;
        }

        public Criteria andBagsCountIsNotNull() {
            addCriterion("bags_count is not null");
            return (Criteria) this;
        }

        public Criteria andBagsCountEqualTo(Integer value) {
            addCriterion("bags_count =", value, "bagsCount");
            return (Criteria) this;
        }

        public Criteria andBagsCountNotEqualTo(Integer value) {
            addCriterion("bags_count <>", value, "bagsCount");
            return (Criteria) this;
        }

        public Criteria andBagsCountGreaterThan(Integer value) {
            addCriterion("bags_count >", value, "bagsCount");
            return (Criteria) this;
        }

        public Criteria andBagsCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("bags_count >=", value, "bagsCount");
            return (Criteria) this;
        }

        public Criteria andBagsCountLessThan(Integer value) {
            addCriterion("bags_count <", value, "bagsCount");
            return (Criteria) this;
        }

        public Criteria andBagsCountLessThanOrEqualTo(Integer value) {
            addCriterion("bags_count <=", value, "bagsCount");
            return (Criteria) this;
        }

        public Criteria andBagsCountIn(List<Integer> values) {
            addCriterion("bags_count in", values, "bagsCount");
            return (Criteria) this;
        }

        public Criteria andBagsCountNotIn(List<Integer> values) {
            addCriterion("bags_count not in", values, "bagsCount");
            return (Criteria) this;
        }

        public Criteria andBagsCountBetween(Integer value1, Integer value2) {
            addCriterion("bags_count between", value1, value2, "bagsCount");
            return (Criteria) this;
        }

        public Criteria andBagsCountNotBetween(Integer value1, Integer value2) {
            addCriterion("bags_count not between", value1, value2, "bagsCount");
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

        public Criteria andParticularYearEqualTo(String value) {
            addCriterion("particular_year =", value, "particularYear");
            return (Criteria) this;
        }

        public Criteria andParticularYearNotEqualTo(String value) {
            addCriterion("particular_year <>", value, "particularYear");
            return (Criteria) this;
        }

        public Criteria andParticularYearGreaterThan(String value) {
            addCriterion("particular_year >", value, "particularYear");
            return (Criteria) this;
        }

        public Criteria andParticularYearGreaterThanOrEqualTo(String value) {
            addCriterion("particular_year >=", value, "particularYear");
            return (Criteria) this;
        }

        public Criteria andParticularYearLessThan(String value) {
            addCriterion("particular_year <", value, "particularYear");
            return (Criteria) this;
        }

        public Criteria andParticularYearLessThanOrEqualTo(String value) {
            addCriterion("particular_year <=", value, "particularYear");
            return (Criteria) this;
        }

        public Criteria andParticularYearLike(String value) {
            addCriterion("particular_year like", value, "particularYear");
            return (Criteria) this;
        }

        public Criteria andParticularYearNotLike(String value) {
            addCriterion("particular_year not like", value, "particularYear");
            return (Criteria) this;
        }

        public Criteria andParticularYearIn(List<String> values) {
            addCriterion("particular_year in", values, "particularYear");
            return (Criteria) this;
        }

        public Criteria andParticularYearNotIn(List<String> values) {
            addCriterion("particular_year not in", values, "particularYear");
            return (Criteria) this;
        }

        public Criteria andParticularYearBetween(String value1, String value2) {
            addCriterion("particular_year between", value1, value2, "particularYear");
            return (Criteria) this;
        }

        public Criteria andParticularYearNotBetween(String value1, String value2) {
            addCriterion("particular_year not between", value1, value2, "particularYear");
            return (Criteria) this;
        }

        public Criteria andWarehousingTypeIsNull() {
            addCriterion("warehousing_type is null");
            return (Criteria) this;
        }

        public Criteria andWarehousingTypeIsNotNull() {
            addCriterion("warehousing_type is not null");
            return (Criteria) this;
        }

        public Criteria andWarehousingTypeEqualTo(String value) {
            addCriterion("warehousing_type =", value, "warehousingType");
            return (Criteria) this;
        }

        public Criteria andWarehousingTypeNotEqualTo(String value) {
            addCriterion("warehousing_type <>", value, "warehousingType");
            return (Criteria) this;
        }

        public Criteria andWarehousingTypeGreaterThan(String value) {
            addCriterion("warehousing_type >", value, "warehousingType");
            return (Criteria) this;
        }

        public Criteria andWarehousingTypeGreaterThanOrEqualTo(String value) {
            addCriterion("warehousing_type >=", value, "warehousingType");
            return (Criteria) this;
        }

        public Criteria andWarehousingTypeLessThan(String value) {
            addCriterion("warehousing_type <", value, "warehousingType");
            return (Criteria) this;
        }

        public Criteria andWarehousingTypeLessThanOrEqualTo(String value) {
            addCriterion("warehousing_type <=", value, "warehousingType");
            return (Criteria) this;
        }

        public Criteria andWarehousingTypeLike(String value) {
            addCriterion("warehousing_type like", value, "warehousingType");
            return (Criteria) this;
        }

        public Criteria andWarehousingTypeNotLike(String value) {
            addCriterion("warehousing_type not like", value, "warehousingType");
            return (Criteria) this;
        }

        public Criteria andWarehousingTypeIn(List<String> values) {
            addCriterion("warehousing_type in", values, "warehousingType");
            return (Criteria) this;
        }

        public Criteria andWarehousingTypeNotIn(List<String> values) {
            addCriterion("warehousing_type not in", values, "warehousingType");
            return (Criteria) this;
        }

        public Criteria andWarehousingTypeBetween(String value1, String value2) {
            addCriterion("warehousing_type between", value1, value2, "warehousingType");
            return (Criteria) this;
        }

        public Criteria andWarehousingTypeNotBetween(String value1, String value2) {
            addCriterion("warehousing_type not between", value1, value2, "warehousingType");
            return (Criteria) this;
        }

        public Criteria andWarehouseStartDateIsNull() {
            addCriterion("warehouse_start_date is null");
            return (Criteria) this;
        }

        public Criteria andWarehouseStartDateIsNotNull() {
            addCriterion("warehouse_start_date is not null");
            return (Criteria) this;
        }

        public Criteria andWarehouseStartDateEqualTo(Date value) {
            addCriterionForJDBCDate("warehouse_start_date =", value, "warehouseStartDate");
            return (Criteria) this;
        }

        public Criteria andWarehouseStartDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("warehouse_start_date <>", value, "warehouseStartDate");
            return (Criteria) this;
        }

        public Criteria andWarehouseStartDateGreaterThan(Date value) {
            addCriterionForJDBCDate("warehouse_start_date >", value, "warehouseStartDate");
            return (Criteria) this;
        }

        public Criteria andWarehouseStartDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("warehouse_start_date >=", value, "warehouseStartDate");
            return (Criteria) this;
        }

        public Criteria andWarehouseStartDateLessThan(Date value) {
            addCriterionForJDBCDate("warehouse_start_date <", value, "warehouseStartDate");
            return (Criteria) this;
        }

        public Criteria andWarehouseStartDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("warehouse_start_date <=", value, "warehouseStartDate");
            return (Criteria) this;
        }

        public Criteria andWarehouseStartDateIn(List<Date> values) {
            addCriterionForJDBCDate("warehouse_start_date in", values, "warehouseStartDate");
            return (Criteria) this;
        }

        public Criteria andWarehouseStartDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("warehouse_start_date not in", values, "warehouseStartDate");
            return (Criteria) this;
        }

        public Criteria andWarehouseStartDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("warehouse_start_date between", value1, value2, "warehouseStartDate");
            return (Criteria) this;
        }

        public Criteria andWarehouseStartDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("warehouse_start_date not between", value1, value2, "warehouseStartDate");
            return (Criteria) this;
        }

        public Criteria andWarehouseEndDateIsNull() {
            addCriterion("warehouse_end_date is null");
            return (Criteria) this;
        }

        public Criteria andWarehouseEndDateIsNotNull() {
            addCriterion("warehouse_end_date is not null");
            return (Criteria) this;
        }

        public Criteria andWarehouseEndDateEqualTo(Date value) {
            addCriterionForJDBCDate("warehouse_end_date =", value, "warehouseEndDate");
            return (Criteria) this;
        }

        public Criteria andWarehouseEndDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("warehouse_end_date <>", value, "warehouseEndDate");
            return (Criteria) this;
        }

        public Criteria andWarehouseEndDateGreaterThan(Date value) {
            addCriterionForJDBCDate("warehouse_end_date >", value, "warehouseEndDate");
            return (Criteria) this;
        }

        public Criteria andWarehouseEndDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("warehouse_end_date >=", value, "warehouseEndDate");
            return (Criteria) this;
        }

        public Criteria andWarehouseEndDateLessThan(Date value) {
            addCriterionForJDBCDate("warehouse_end_date <", value, "warehouseEndDate");
            return (Criteria) this;
        }

        public Criteria andWarehouseEndDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("warehouse_end_date <=", value, "warehouseEndDate");
            return (Criteria) this;
        }

        public Criteria andWarehouseEndDateIn(List<Date> values) {
            addCriterionForJDBCDate("warehouse_end_date in", values, "warehouseEndDate");
            return (Criteria) this;
        }

        public Criteria andWarehouseEndDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("warehouse_end_date not in", values, "warehouseEndDate");
            return (Criteria) this;
        }

        public Criteria andWarehouseEndDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("warehouse_end_date between", value1, value2, "warehouseEndDate");
            return (Criteria) this;
        }

        public Criteria andWarehouseEndDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("warehouse_end_date not between", value1, value2, "warehouseEndDate");
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
            addCriterionForJDBCDate("apply_date =", value, "applyDate");
            return (Criteria) this;
        }

        public Criteria andApplyDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("apply_date <>", value, "applyDate");
            return (Criteria) this;
        }

        public Criteria andApplyDateGreaterThan(Date value) {
            addCriterionForJDBCDate("apply_date >", value, "applyDate");
            return (Criteria) this;
        }

        public Criteria andApplyDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("apply_date >=", value, "applyDate");
            return (Criteria) this;
        }

        public Criteria andApplyDateLessThan(Date value) {
            addCriterionForJDBCDate("apply_date <", value, "applyDate");
            return (Criteria) this;
        }

        public Criteria andApplyDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("apply_date <=", value, "applyDate");
            return (Criteria) this;
        }

        public Criteria andApplyDateIn(List<Date> values) {
            addCriterionForJDBCDate("apply_date in", values, "applyDate");
            return (Criteria) this;
        }

        public Criteria andApplyDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("apply_date not in", values, "applyDate");
            return (Criteria) this;
        }

        public Criteria andApplyDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("apply_date between", value1, value2, "applyDate");
            return (Criteria) this;
        }

        public Criteria andApplyDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("apply_date not between", value1, value2, "applyDate");
            return (Criteria) this;
        }

        public Criteria andDueDateIsNull() {
            addCriterion("due_date is null");
            return (Criteria) this;
        }

        public Criteria andDueDateIsNotNull() {
            addCriterion("due_date is not null");
            return (Criteria) this;
        }

        public Criteria andDueDateEqualTo(Date value) {
            addCriterionForJDBCDate("due_date =", value, "dueDate");
            return (Criteria) this;
        }

        public Criteria andDueDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("due_date <>", value, "dueDate");
            return (Criteria) this;
        }

        public Criteria andDueDateGreaterThan(Date value) {
            addCriterionForJDBCDate("due_date >", value, "dueDate");
            return (Criteria) this;
        }

        public Criteria andDueDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("due_date >=", value, "dueDate");
            return (Criteria) this;
        }

        public Criteria andDueDateLessThan(Date value) {
            addCriterionForJDBCDate("due_date <", value, "dueDate");
            return (Criteria) this;
        }

        public Criteria andDueDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("due_date <=", value, "dueDate");
            return (Criteria) this;
        }

        public Criteria andDueDateIn(List<Date> values) {
            addCriterionForJDBCDate("due_date in", values, "dueDate");
            return (Criteria) this;
        }

        public Criteria andDueDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("due_date not in", values, "dueDate");
            return (Criteria) this;
        }

        public Criteria andDueDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("due_date between", value1, value2, "dueDate");
            return (Criteria) this;
        }

        public Criteria andDueDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("due_date not between", value1, value2, "dueDate");
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
            addCriterionForJDBCDate("report_time =", value, "reportTime");
            return (Criteria) this;
        }

        public Criteria andReportTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("report_time <>", value, "reportTime");
            return (Criteria) this;
        }

        public Criteria andReportTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("report_time >", value, "reportTime");
            return (Criteria) this;
        }

        public Criteria andReportTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("report_time >=", value, "reportTime");
            return (Criteria) this;
        }

        public Criteria andReportTimeLessThan(Date value) {
            addCriterionForJDBCDate("report_time <", value, "reportTime");
            return (Criteria) this;
        }

        public Criteria andReportTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("report_time <=", value, "reportTime");
            return (Criteria) this;
        }

        public Criteria andReportTimeIn(List<Date> values) {
            addCriterionForJDBCDate("report_time in", values, "reportTime");
            return (Criteria) this;
        }

        public Criteria andReportTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("report_time not in", values, "reportTime");
            return (Criteria) this;
        }

        public Criteria andReportTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("report_time between", value1, value2, "reportTime");
            return (Criteria) this;
        }

        public Criteria andReportTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("report_time not between", value1, value2, "reportTime");
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