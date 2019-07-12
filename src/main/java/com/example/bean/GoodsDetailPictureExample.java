package com.example.bean;

import java.util.ArrayList;
import java.util.List;

public class GoodsDetailPictureExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GoodsDetailPictureExample() {
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

        public Criteria andGoodsDetailPictureIdIsNull() {
            addCriterion("goods_detail_picture_id is null");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailPictureIdIsNotNull() {
            addCriterion("goods_detail_picture_id is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailPictureIdEqualTo(Long value) {
            addCriterion("goods_detail_picture_id =", value, "goodsDetailPictureId");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailPictureIdNotEqualTo(Long value) {
            addCriterion("goods_detail_picture_id <>", value, "goodsDetailPictureId");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailPictureIdGreaterThan(Long value) {
            addCriterion("goods_detail_picture_id >", value, "goodsDetailPictureId");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailPictureIdGreaterThanOrEqualTo(Long value) {
            addCriterion("goods_detail_picture_id >=", value, "goodsDetailPictureId");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailPictureIdLessThan(Long value) {
            addCriterion("goods_detail_picture_id <", value, "goodsDetailPictureId");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailPictureIdLessThanOrEqualTo(Long value) {
            addCriterion("goods_detail_picture_id <=", value, "goodsDetailPictureId");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailPictureIdIn(List<Long> values) {
            addCriterion("goods_detail_picture_id in", values, "goodsDetailPictureId");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailPictureIdNotIn(List<Long> values) {
            addCriterion("goods_detail_picture_id not in", values, "goodsDetailPictureId");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailPictureIdBetween(Long value1, Long value2) {
            addCriterion("goods_detail_picture_id between", value1, value2, "goodsDetailPictureId");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailPictureIdNotBetween(Long value1, Long value2) {
            addCriterion("goods_detail_picture_id not between", value1, value2, "goodsDetailPictureId");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailIdIsNull() {
            addCriterion("goods_detail_id is null");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailIdIsNotNull() {
            addCriterion("goods_detail_id is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailIdEqualTo(Long value) {
            addCriterion("goods_detail_id =", value, "goodsDetailId");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailIdNotEqualTo(Long value) {
            addCriterion("goods_detail_id <>", value, "goodsDetailId");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailIdGreaterThan(Long value) {
            addCriterion("goods_detail_id >", value, "goodsDetailId");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailIdGreaterThanOrEqualTo(Long value) {
            addCriterion("goods_detail_id >=", value, "goodsDetailId");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailIdLessThan(Long value) {
            addCriterion("goods_detail_id <", value, "goodsDetailId");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailIdLessThanOrEqualTo(Long value) {
            addCriterion("goods_detail_id <=", value, "goodsDetailId");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailIdIn(List<Long> values) {
            addCriterion("goods_detail_id in", values, "goodsDetailId");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailIdNotIn(List<Long> values) {
            addCriterion("goods_detail_id not in", values, "goodsDetailId");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailIdBetween(Long value1, Long value2) {
            addCriterion("goods_detail_id between", value1, value2, "goodsDetailId");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailIdNotBetween(Long value1, Long value2) {
            addCriterion("goods_detail_id not between", value1, value2, "goodsDetailId");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailPictureUrlIsNull() {
            addCriterion("goods_detail_picture_url is null");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailPictureUrlIsNotNull() {
            addCriterion("goods_detail_picture_url is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailPictureUrlEqualTo(String value) {
            addCriterion("goods_detail_picture_url =", value, "goodsDetailPictureUrl");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailPictureUrlNotEqualTo(String value) {
            addCriterion("goods_detail_picture_url <>", value, "goodsDetailPictureUrl");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailPictureUrlGreaterThan(String value) {
            addCriterion("goods_detail_picture_url >", value, "goodsDetailPictureUrl");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailPictureUrlGreaterThanOrEqualTo(String value) {
            addCriterion("goods_detail_picture_url >=", value, "goodsDetailPictureUrl");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailPictureUrlLessThan(String value) {
            addCriterion("goods_detail_picture_url <", value, "goodsDetailPictureUrl");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailPictureUrlLessThanOrEqualTo(String value) {
            addCriterion("goods_detail_picture_url <=", value, "goodsDetailPictureUrl");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailPictureUrlLike(String value) {
            addCriterion("goods_detail_picture_url like", value, "goodsDetailPictureUrl");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailPictureUrlNotLike(String value) {
            addCriterion("goods_detail_picture_url not like", value, "goodsDetailPictureUrl");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailPictureUrlIn(List<String> values) {
            addCriterion("goods_detail_picture_url in", values, "goodsDetailPictureUrl");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailPictureUrlNotIn(List<String> values) {
            addCriterion("goods_detail_picture_url not in", values, "goodsDetailPictureUrl");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailPictureUrlBetween(String value1, String value2) {
            addCriterion("goods_detail_picture_url between", value1, value2, "goodsDetailPictureUrl");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailPictureUrlNotBetween(String value1, String value2) {
            addCriterion("goods_detail_picture_url not between", value1, value2, "goodsDetailPictureUrl");
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