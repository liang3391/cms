package com.qianqian.common.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CategoryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CategoryExample() {
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

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andParentIdIsNull() {
            addCriterion("parent_id is null");
            return (Criteria) this;
        }

        public Criteria andParentIdIsNotNull() {
            addCriterion("parent_id is not null");
            return (Criteria) this;
        }

        public Criteria andParentIdEqualTo(Long value) {
            addCriterion("parent_id =", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotEqualTo(Long value) {
            addCriterion("parent_id <>", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThan(Long value) {
            addCriterion("parent_id >", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThanOrEqualTo(Long value) {
            addCriterion("parent_id >=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThan(Long value) {
            addCriterion("parent_id <", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThanOrEqualTo(Long value) {
            addCriterion("parent_id <=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdIn(List<Long> values) {
            addCriterion("parent_id in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotIn(List<Long> values) {
            addCriterion("parent_id not in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdBetween(Long value1, Long value2) {
            addCriterion("parent_id between", value1, value2, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotBetween(Long value1, Long value2) {
            addCriterion("parent_id not between", value1, value2, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentCategoryNameIsNull() {
            addCriterion("parent_category_name is null");
            return (Criteria) this;
        }

        public Criteria andParentCategoryNameIsNotNull() {
            addCriterion("parent_category_name is not null");
            return (Criteria) this;
        }

        public Criteria andParentCategoryNameEqualTo(String value) {
            addCriterion("parent_category_name =", value, "parentCategoryName");
            return (Criteria) this;
        }

        public Criteria andParentCategoryNameNotEqualTo(String value) {
            addCriterion("parent_category_name <>", value, "parentCategoryName");
            return (Criteria) this;
        }

        public Criteria andParentCategoryNameGreaterThan(String value) {
            addCriterion("parent_category_name >", value, "parentCategoryName");
            return (Criteria) this;
        }

        public Criteria andParentCategoryNameGreaterThanOrEqualTo(String value) {
            addCriterion("parent_category_name >=", value, "parentCategoryName");
            return (Criteria) this;
        }

        public Criteria andParentCategoryNameLessThan(String value) {
            addCriterion("parent_category_name <", value, "parentCategoryName");
            return (Criteria) this;
        }

        public Criteria andParentCategoryNameLessThanOrEqualTo(String value) {
            addCriterion("parent_category_name <=", value, "parentCategoryName");
            return (Criteria) this;
        }

        public Criteria andParentCategoryNameLike(String value) {
            addCriterion("parent_category_name like", value, "parentCategoryName");
            return (Criteria) this;
        }

        public Criteria andParentCategoryNameNotLike(String value) {
            addCriterion("parent_category_name not like", value, "parentCategoryName");
            return (Criteria) this;
        }

        public Criteria andParentCategoryNameIn(List<String> values) {
            addCriterion("parent_category_name in", values, "parentCategoryName");
            return (Criteria) this;
        }

        public Criteria andParentCategoryNameNotIn(List<String> values) {
            addCriterion("parent_category_name not in", values, "parentCategoryName");
            return (Criteria) this;
        }

        public Criteria andParentCategoryNameBetween(String value1, String value2) {
            addCriterion("parent_category_name between", value1, value2, "parentCategoryName");
            return (Criteria) this;
        }

        public Criteria andParentCategoryNameNotBetween(String value1, String value2) {
            addCriterion("parent_category_name not between", value1, value2, "parentCategoryName");
            return (Criteria) this;
        }

        public Criteria andRootIdIsNull() {
            addCriterion("root_id is null");
            return (Criteria) this;
        }

        public Criteria andRootIdIsNotNull() {
            addCriterion("root_id is not null");
            return (Criteria) this;
        }

        public Criteria andRootIdEqualTo(Long value) {
            addCriterion("root_id =", value, "rootId");
            return (Criteria) this;
        }

        public Criteria andRootIdNotEqualTo(Long value) {
            addCriterion("root_id <>", value, "rootId");
            return (Criteria) this;
        }

        public Criteria andRootIdGreaterThan(Long value) {
            addCriterion("root_id >", value, "rootId");
            return (Criteria) this;
        }

        public Criteria andRootIdGreaterThanOrEqualTo(Long value) {
            addCriterion("root_id >=", value, "rootId");
            return (Criteria) this;
        }

        public Criteria andRootIdLessThan(Long value) {
            addCriterion("root_id <", value, "rootId");
            return (Criteria) this;
        }

        public Criteria andRootIdLessThanOrEqualTo(Long value) {
            addCriterion("root_id <=", value, "rootId");
            return (Criteria) this;
        }

        public Criteria andRootIdIn(List<Long> values) {
            addCriterion("root_id in", values, "rootId");
            return (Criteria) this;
        }

        public Criteria andRootIdNotIn(List<Long> values) {
            addCriterion("root_id not in", values, "rootId");
            return (Criteria) this;
        }

        public Criteria andRootIdBetween(Long value1, Long value2) {
            addCriterion("root_id between", value1, value2, "rootId");
            return (Criteria) this;
        }

        public Criteria andRootIdNotBetween(Long value1, Long value2) {
            addCriterion("root_id not between", value1, value2, "rootId");
            return (Criteria) this;
        }

        public Criteria andRootCategoryNameIsNull() {
            addCriterion("root_category_name is null");
            return (Criteria) this;
        }

        public Criteria andRootCategoryNameIsNotNull() {
            addCriterion("root_category_name is not null");
            return (Criteria) this;
        }

        public Criteria andRootCategoryNameEqualTo(String value) {
            addCriterion("root_category_name =", value, "rootCategoryName");
            return (Criteria) this;
        }

        public Criteria andRootCategoryNameNotEqualTo(String value) {
            addCriterion("root_category_name <>", value, "rootCategoryName");
            return (Criteria) this;
        }

        public Criteria andRootCategoryNameGreaterThan(String value) {
            addCriterion("root_category_name >", value, "rootCategoryName");
            return (Criteria) this;
        }

        public Criteria andRootCategoryNameGreaterThanOrEqualTo(String value) {
            addCriterion("root_category_name >=", value, "rootCategoryName");
            return (Criteria) this;
        }

        public Criteria andRootCategoryNameLessThan(String value) {
            addCriterion("root_category_name <", value, "rootCategoryName");
            return (Criteria) this;
        }

        public Criteria andRootCategoryNameLessThanOrEqualTo(String value) {
            addCriterion("root_category_name <=", value, "rootCategoryName");
            return (Criteria) this;
        }

        public Criteria andRootCategoryNameLike(String value) {
            addCriterion("root_category_name like", value, "rootCategoryName");
            return (Criteria) this;
        }

        public Criteria andRootCategoryNameNotLike(String value) {
            addCriterion("root_category_name not like", value, "rootCategoryName");
            return (Criteria) this;
        }

        public Criteria andRootCategoryNameIn(List<String> values) {
            addCriterion("root_category_name in", values, "rootCategoryName");
            return (Criteria) this;
        }

        public Criteria andRootCategoryNameNotIn(List<String> values) {
            addCriterion("root_category_name not in", values, "rootCategoryName");
            return (Criteria) this;
        }

        public Criteria andRootCategoryNameBetween(String value1, String value2) {
            addCriterion("root_category_name between", value1, value2, "rootCategoryName");
            return (Criteria) this;
        }

        public Criteria andRootCategoryNameNotBetween(String value1, String value2) {
            addCriterion("root_category_name not between", value1, value2, "rootCategoryName");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andEnglishNameIsNull() {
            addCriterion("english_name is null");
            return (Criteria) this;
        }

        public Criteria andEnglishNameIsNotNull() {
            addCriterion("english_name is not null");
            return (Criteria) this;
        }

        public Criteria andEnglishNameEqualTo(String value) {
            addCriterion("english_name =", value, "englishName");
            return (Criteria) this;
        }

        public Criteria andEnglishNameNotEqualTo(String value) {
            addCriterion("english_name <>", value, "englishName");
            return (Criteria) this;
        }

        public Criteria andEnglishNameGreaterThan(String value) {
            addCriterion("english_name >", value, "englishName");
            return (Criteria) this;
        }

        public Criteria andEnglishNameGreaterThanOrEqualTo(String value) {
            addCriterion("english_name >=", value, "englishName");
            return (Criteria) this;
        }

        public Criteria andEnglishNameLessThan(String value) {
            addCriterion("english_name <", value, "englishName");
            return (Criteria) this;
        }

        public Criteria andEnglishNameLessThanOrEqualTo(String value) {
            addCriterion("english_name <=", value, "englishName");
            return (Criteria) this;
        }

        public Criteria andEnglishNameLike(String value) {
            addCriterion("english_name like", value, "englishName");
            return (Criteria) this;
        }

        public Criteria andEnglishNameNotLike(String value) {
            addCriterion("english_name not like", value, "englishName");
            return (Criteria) this;
        }

        public Criteria andEnglishNameIn(List<String> values) {
            addCriterion("english_name in", values, "englishName");
            return (Criteria) this;
        }

        public Criteria andEnglishNameNotIn(List<String> values) {
            addCriterion("english_name not in", values, "englishName");
            return (Criteria) this;
        }

        public Criteria andEnglishNameBetween(String value1, String value2) {
            addCriterion("english_name between", value1, value2, "englishName");
            return (Criteria) this;
        }

        public Criteria andEnglishNameNotBetween(String value1, String value2) {
            addCriterion("english_name not between", value1, value2, "englishName");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("description like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("description not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("description not between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andMarkIsNull() {
            addCriterion("mark is null");
            return (Criteria) this;
        }

        public Criteria andMarkIsNotNull() {
            addCriterion("mark is not null");
            return (Criteria) this;
        }

        public Criteria andMarkEqualTo(String value) {
            addCriterion("mark =", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkNotEqualTo(String value) {
            addCriterion("mark <>", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkGreaterThan(String value) {
            addCriterion("mark >", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkGreaterThanOrEqualTo(String value) {
            addCriterion("mark >=", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkLessThan(String value) {
            addCriterion("mark <", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkLessThanOrEqualTo(String value) {
            addCriterion("mark <=", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkLike(String value) {
            addCriterion("mark like", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkNotLike(String value) {
            addCriterion("mark not like", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkIn(List<String> values) {
            addCriterion("mark in", values, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkNotIn(List<String> values) {
            addCriterion("mark not in", values, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkBetween(String value1, String value2) {
            addCriterion("mark between", value1, value2, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkNotBetween(String value1, String value2) {
            addCriterion("mark not between", value1, value2, "mark");
            return (Criteria) this;
        }

        public Criteria andSortValueIsNull() {
            addCriterion("sort_value is null");
            return (Criteria) this;
        }

        public Criteria andSortValueIsNotNull() {
            addCriterion("sort_value is not null");
            return (Criteria) this;
        }

        public Criteria andSortValueEqualTo(Integer value) {
            addCriterion("sort_value =", value, "sortValue");
            return (Criteria) this;
        }

        public Criteria andSortValueNotEqualTo(Integer value) {
            addCriterion("sort_value <>", value, "sortValue");
            return (Criteria) this;
        }

        public Criteria andSortValueGreaterThan(Integer value) {
            addCriterion("sort_value >", value, "sortValue");
            return (Criteria) this;
        }

        public Criteria andSortValueGreaterThanOrEqualTo(Integer value) {
            addCriterion("sort_value >=", value, "sortValue");
            return (Criteria) this;
        }

        public Criteria andSortValueLessThan(Integer value) {
            addCriterion("sort_value <", value, "sortValue");
            return (Criteria) this;
        }

        public Criteria andSortValueLessThanOrEqualTo(Integer value) {
            addCriterion("sort_value <=", value, "sortValue");
            return (Criteria) this;
        }

        public Criteria andSortValueIn(List<Integer> values) {
            addCriterion("sort_value in", values, "sortValue");
            return (Criteria) this;
        }

        public Criteria andSortValueNotIn(List<Integer> values) {
            addCriterion("sort_value not in", values, "sortValue");
            return (Criteria) this;
        }

        public Criteria andSortValueBetween(Integer value1, Integer value2) {
            addCriterion("sort_value between", value1, value2, "sortValue");
            return (Criteria) this;
        }

        public Criteria andSortValueNotBetween(Integer value1, Integer value2) {
            addCriterion("sort_value not between", value1, value2, "sortValue");
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

        public Criteria andLastModiftyTimeIsNull() {
            addCriterion("last_modifty_time is null");
            return (Criteria) this;
        }

        public Criteria andLastModiftyTimeIsNotNull() {
            addCriterion("last_modifty_time is not null");
            return (Criteria) this;
        }

        public Criteria andLastModiftyTimeEqualTo(Date value) {
            addCriterion("last_modifty_time =", value, "lastModiftyTime");
            return (Criteria) this;
        }

        public Criteria andLastModiftyTimeNotEqualTo(Date value) {
            addCriterion("last_modifty_time <>", value, "lastModiftyTime");
            return (Criteria) this;
        }

        public Criteria andLastModiftyTimeGreaterThan(Date value) {
            addCriterion("last_modifty_time >", value, "lastModiftyTime");
            return (Criteria) this;
        }

        public Criteria andLastModiftyTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("last_modifty_time >=", value, "lastModiftyTime");
            return (Criteria) this;
        }

        public Criteria andLastModiftyTimeLessThan(Date value) {
            addCriterion("last_modifty_time <", value, "lastModiftyTime");
            return (Criteria) this;
        }

        public Criteria andLastModiftyTimeLessThanOrEqualTo(Date value) {
            addCriterion("last_modifty_time <=", value, "lastModiftyTime");
            return (Criteria) this;
        }

        public Criteria andLastModiftyTimeIn(List<Date> values) {
            addCriterion("last_modifty_time in", values, "lastModiftyTime");
            return (Criteria) this;
        }

        public Criteria andLastModiftyTimeNotIn(List<Date> values) {
            addCriterion("last_modifty_time not in", values, "lastModiftyTime");
            return (Criteria) this;
        }

        public Criteria andLastModiftyTimeBetween(Date value1, Date value2) {
            addCriterion("last_modifty_time between", value1, value2, "lastModiftyTime");
            return (Criteria) this;
        }

        public Criteria andLastModiftyTimeNotBetween(Date value1, Date value2) {
            addCriterion("last_modifty_time not between", value1, value2, "lastModiftyTime");
            return (Criteria) this;
        }

        public Criteria andSponsorBrandIdIsNull() {
            addCriterion("sponsor_brand_id is null");
            return (Criteria) this;
        }

        public Criteria andSponsorBrandIdIsNotNull() {
            addCriterion("sponsor_brand_id is not null");
            return (Criteria) this;
        }

        public Criteria andSponsorBrandIdEqualTo(Integer value) {
            addCriterion("sponsor_brand_id =", value, "sponsorBrandId");
            return (Criteria) this;
        }

        public Criteria andSponsorBrandIdNotEqualTo(Integer value) {
            addCriterion("sponsor_brand_id <>", value, "sponsorBrandId");
            return (Criteria) this;
        }

        public Criteria andSponsorBrandIdGreaterThan(Integer value) {
            addCriterion("sponsor_brand_id >", value, "sponsorBrandId");
            return (Criteria) this;
        }

        public Criteria andSponsorBrandIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("sponsor_brand_id >=", value, "sponsorBrandId");
            return (Criteria) this;
        }

        public Criteria andSponsorBrandIdLessThan(Integer value) {
            addCriterion("sponsor_brand_id <", value, "sponsorBrandId");
            return (Criteria) this;
        }

        public Criteria andSponsorBrandIdLessThanOrEqualTo(Integer value) {
            addCriterion("sponsor_brand_id <=", value, "sponsorBrandId");
            return (Criteria) this;
        }

        public Criteria andSponsorBrandIdIn(List<Integer> values) {
            addCriterion("sponsor_brand_id in", values, "sponsorBrandId");
            return (Criteria) this;
        }

        public Criteria andSponsorBrandIdNotIn(List<Integer> values) {
            addCriterion("sponsor_brand_id not in", values, "sponsorBrandId");
            return (Criteria) this;
        }

        public Criteria andSponsorBrandIdBetween(Integer value1, Integer value2) {
            addCriterion("sponsor_brand_id between", value1, value2, "sponsorBrandId");
            return (Criteria) this;
        }

        public Criteria andSponsorBrandIdNotBetween(Integer value1, Integer value2) {
            addCriterion("sponsor_brand_id not between", value1, value2, "sponsorBrandId");
            return (Criteria) this;
        }

        public Criteria andLogoUrlIsNull() {
            addCriterion("logo_url is null");
            return (Criteria) this;
        }

        public Criteria andLogoUrlIsNotNull() {
            addCriterion("logo_url is not null");
            return (Criteria) this;
        }

        public Criteria andLogoUrlEqualTo(String value) {
            addCriterion("logo_url =", value, "logoUrl");
            return (Criteria) this;
        }

        public Criteria andLogoUrlNotEqualTo(String value) {
            addCriterion("logo_url <>", value, "logoUrl");
            return (Criteria) this;
        }

        public Criteria andLogoUrlGreaterThan(String value) {
            addCriterion("logo_url >", value, "logoUrl");
            return (Criteria) this;
        }

        public Criteria andLogoUrlGreaterThanOrEqualTo(String value) {
            addCriterion("logo_url >=", value, "logoUrl");
            return (Criteria) this;
        }

        public Criteria andLogoUrlLessThan(String value) {
            addCriterion("logo_url <", value, "logoUrl");
            return (Criteria) this;
        }

        public Criteria andLogoUrlLessThanOrEqualTo(String value) {
            addCriterion("logo_url <=", value, "logoUrl");
            return (Criteria) this;
        }

        public Criteria andLogoUrlLike(String value) {
            addCriterion("logo_url like", value, "logoUrl");
            return (Criteria) this;
        }

        public Criteria andLogoUrlNotLike(String value) {
            addCriterion("logo_url not like", value, "logoUrl");
            return (Criteria) this;
        }

        public Criteria andLogoUrlIn(List<String> values) {
            addCriterion("logo_url in", values, "logoUrl");
            return (Criteria) this;
        }

        public Criteria andLogoUrlNotIn(List<String> values) {
            addCriterion("logo_url not in", values, "logoUrl");
            return (Criteria) this;
        }

        public Criteria andLogoUrlBetween(String value1, String value2) {
            addCriterion("logo_url between", value1, value2, "logoUrl");
            return (Criteria) this;
        }

        public Criteria andLogoUrlNotBetween(String value1, String value2) {
            addCriterion("logo_url not between", value1, value2, "logoUrl");
            return (Criteria) this;
        }

        public Criteria andMoreLinkIsNull() {
            addCriterion("more_link is null");
            return (Criteria) this;
        }

        public Criteria andMoreLinkIsNotNull() {
            addCriterion("more_link is not null");
            return (Criteria) this;
        }

        public Criteria andMoreLinkEqualTo(String value) {
            addCriterion("more_link =", value, "moreLink");
            return (Criteria) this;
        }

        public Criteria andMoreLinkNotEqualTo(String value) {
            addCriterion("more_link <>", value, "moreLink");
            return (Criteria) this;
        }

        public Criteria andMoreLinkGreaterThan(String value) {
            addCriterion("more_link >", value, "moreLink");
            return (Criteria) this;
        }

        public Criteria andMoreLinkGreaterThanOrEqualTo(String value) {
            addCriterion("more_link >=", value, "moreLink");
            return (Criteria) this;
        }

        public Criteria andMoreLinkLessThan(String value) {
            addCriterion("more_link <", value, "moreLink");
            return (Criteria) this;
        }

        public Criteria andMoreLinkLessThanOrEqualTo(String value) {
            addCriterion("more_link <=", value, "moreLink");
            return (Criteria) this;
        }

        public Criteria andMoreLinkLike(String value) {
            addCriterion("more_link like", value, "moreLink");
            return (Criteria) this;
        }

        public Criteria andMoreLinkNotLike(String value) {
            addCriterion("more_link not like", value, "moreLink");
            return (Criteria) this;
        }

        public Criteria andMoreLinkIn(List<String> values) {
            addCriterion("more_link in", values, "moreLink");
            return (Criteria) this;
        }

        public Criteria andMoreLinkNotIn(List<String> values) {
            addCriterion("more_link not in", values, "moreLink");
            return (Criteria) this;
        }

        public Criteria andMoreLinkBetween(String value1, String value2) {
            addCriterion("more_link between", value1, value2, "moreLink");
            return (Criteria) this;
        }

        public Criteria andMoreLinkNotBetween(String value1, String value2) {
            addCriterion("more_link not between", value1, value2, "moreLink");
            return (Criteria) this;
        }

        public Criteria andLastModiftyUserIdIsNull() {
            addCriterion("last_modifty_user_id is null");
            return (Criteria) this;
        }

        public Criteria andLastModiftyUserIdIsNotNull() {
            addCriterion("last_modifty_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andLastModiftyUserIdEqualTo(Long value) {
            addCriterion("last_modifty_user_id =", value, "lastModiftyUserId");
            return (Criteria) this;
        }

        public Criteria andLastModiftyUserIdNotEqualTo(Long value) {
            addCriterion("last_modifty_user_id <>", value, "lastModiftyUserId");
            return (Criteria) this;
        }

        public Criteria andLastModiftyUserIdGreaterThan(Long value) {
            addCriterion("last_modifty_user_id >", value, "lastModiftyUserId");
            return (Criteria) this;
        }

        public Criteria andLastModiftyUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("last_modifty_user_id >=", value, "lastModiftyUserId");
            return (Criteria) this;
        }

        public Criteria andLastModiftyUserIdLessThan(Long value) {
            addCriterion("last_modifty_user_id <", value, "lastModiftyUserId");
            return (Criteria) this;
        }

        public Criteria andLastModiftyUserIdLessThanOrEqualTo(Long value) {
            addCriterion("last_modifty_user_id <=", value, "lastModiftyUserId");
            return (Criteria) this;
        }

        public Criteria andLastModiftyUserIdIn(List<Long> values) {
            addCriterion("last_modifty_user_id in", values, "lastModiftyUserId");
            return (Criteria) this;
        }

        public Criteria andLastModiftyUserIdNotIn(List<Long> values) {
            addCriterion("last_modifty_user_id not in", values, "lastModiftyUserId");
            return (Criteria) this;
        }

        public Criteria andLastModiftyUserIdBetween(Long value1, Long value2) {
            addCriterion("last_modifty_user_id between", value1, value2, "lastModiftyUserId");
            return (Criteria) this;
        }

        public Criteria andLastModiftyUserIdNotBetween(Long value1, Long value2) {
            addCriterion("last_modifty_user_id not between", value1, value2, "lastModiftyUserId");
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