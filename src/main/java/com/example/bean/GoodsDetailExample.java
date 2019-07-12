package com.example.bean;

import java.util.ArrayList;
import java.util.List;

public class GoodsDetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GoodsDetailExample() {
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

        public Criteria andGoodsIdIsNull() {
            addCriterion("goods_id is null");
            return (Criteria) this;
        }

        public Criteria andGoodsIdIsNotNull() {
            addCriterion("goods_id is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsIdEqualTo(Long value) {
            addCriterion("goods_id =", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotEqualTo(Long value) {
            addCriterion("goods_id <>", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdGreaterThan(Long value) {
            addCriterion("goods_id >", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdGreaterThanOrEqualTo(Long value) {
            addCriterion("goods_id >=", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdLessThan(Long value) {
            addCriterion("goods_id <", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdLessThanOrEqualTo(Long value) {
            addCriterion("goods_id <=", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdIn(List<Long> values) {
            addCriterion("goods_id in", values, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotIn(List<Long> values) {
            addCriterion("goods_id not in", values, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdBetween(Long value1, Long value2) {
            addCriterion("goods_id between", value1, value2, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotBetween(Long value1, Long value2) {
            addCriterion("goods_id not between", value1, value2, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailNameIsNull() {
            addCriterion("goods_detail_name is null");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailNameIsNotNull() {
            addCriterion("goods_detail_name is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailNameEqualTo(String value) {
            addCriterion("goods_detail_name =", value, "goodsDetailName");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailNameNotEqualTo(String value) {
            addCriterion("goods_detail_name <>", value, "goodsDetailName");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailNameGreaterThan(String value) {
            addCriterion("goods_detail_name >", value, "goodsDetailName");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailNameGreaterThanOrEqualTo(String value) {
            addCriterion("goods_detail_name >=", value, "goodsDetailName");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailNameLessThan(String value) {
            addCriterion("goods_detail_name <", value, "goodsDetailName");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailNameLessThanOrEqualTo(String value) {
            addCriterion("goods_detail_name <=", value, "goodsDetailName");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailNameLike(String value) {
            addCriterion("goods_detail_name like", value, "goodsDetailName");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailNameNotLike(String value) {
            addCriterion("goods_detail_name not like", value, "goodsDetailName");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailNameIn(List<String> values) {
            addCriterion("goods_detail_name in", values, "goodsDetailName");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailNameNotIn(List<String> values) {
            addCriterion("goods_detail_name not in", values, "goodsDetailName");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailNameBetween(String value1, String value2) {
            addCriterion("goods_detail_name between", value1, value2, "goodsDetailName");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailNameNotBetween(String value1, String value2) {
            addCriterion("goods_detail_name not between", value1, value2, "goodsDetailName");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailPriceIsNull() {
            addCriterion("goods_detail_price is null");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailPriceIsNotNull() {
            addCriterion("goods_detail_price is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailPriceEqualTo(Float value) {
            addCriterion("goods_detail_price =", value, "goodsDetailPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailPriceNotEqualTo(Float value) {
            addCriterion("goods_detail_price <>", value, "goodsDetailPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailPriceGreaterThan(Float value) {
            addCriterion("goods_detail_price >", value, "goodsDetailPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailPriceGreaterThanOrEqualTo(Float value) {
            addCriterion("goods_detail_price >=", value, "goodsDetailPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailPriceLessThan(Float value) {
            addCriterion("goods_detail_price <", value, "goodsDetailPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailPriceLessThanOrEqualTo(Float value) {
            addCriterion("goods_detail_price <=", value, "goodsDetailPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailPriceIn(List<Float> values) {
            addCriterion("goods_detail_price in", values, "goodsDetailPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailPriceNotIn(List<Float> values) {
            addCriterion("goods_detail_price not in", values, "goodsDetailPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailPriceBetween(Float value1, Float value2) {
            addCriterion("goods_detail_price between", value1, value2, "goodsDetailPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailPriceNotBetween(Float value1, Float value2) {
            addCriterion("goods_detail_price not between", value1, value2, "goodsDetailPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailQuantityIsNull() {
            addCriterion("goods_detail_quantity is null");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailQuantityIsNotNull() {
            addCriterion("goods_detail_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailQuantityEqualTo(Integer value) {
            addCriterion("goods_detail_quantity =", value, "goodsDetailQuantity");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailQuantityNotEqualTo(Integer value) {
            addCriterion("goods_detail_quantity <>", value, "goodsDetailQuantity");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailQuantityGreaterThan(Integer value) {
            addCriterion("goods_detail_quantity >", value, "goodsDetailQuantity");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailQuantityGreaterThanOrEqualTo(Integer value) {
            addCriterion("goods_detail_quantity >=", value, "goodsDetailQuantity");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailQuantityLessThan(Integer value) {
            addCriterion("goods_detail_quantity <", value, "goodsDetailQuantity");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailQuantityLessThanOrEqualTo(Integer value) {
            addCriterion("goods_detail_quantity <=", value, "goodsDetailQuantity");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailQuantityIn(List<Integer> values) {
            addCriterion("goods_detail_quantity in", values, "goodsDetailQuantity");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailQuantityNotIn(List<Integer> values) {
            addCriterion("goods_detail_quantity not in", values, "goodsDetailQuantity");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailQuantityBetween(Integer value1, Integer value2) {
            addCriterion("goods_detail_quantity between", value1, value2, "goodsDetailQuantity");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailQuantityNotBetween(Integer value1, Integer value2) {
            addCriterion("goods_detail_quantity not between", value1, value2, "goodsDetailQuantity");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailDiscountIsNull() {
            addCriterion("goods_detail_discount is null");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailDiscountIsNotNull() {
            addCriterion("goods_detail_discount is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailDiscountEqualTo(Float value) {
            addCriterion("goods_detail_discount =", value, "goodsDetailDiscount");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailDiscountNotEqualTo(Float value) {
            addCriterion("goods_detail_discount <>", value, "goodsDetailDiscount");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailDiscountGreaterThan(Float value) {
            addCriterion("goods_detail_discount >", value, "goodsDetailDiscount");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailDiscountGreaterThanOrEqualTo(Float value) {
            addCriterion("goods_detail_discount >=", value, "goodsDetailDiscount");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailDiscountLessThan(Float value) {
            addCriterion("goods_detail_discount <", value, "goodsDetailDiscount");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailDiscountLessThanOrEqualTo(Float value) {
            addCriterion("goods_detail_discount <=", value, "goodsDetailDiscount");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailDiscountIn(List<Float> values) {
            addCriterion("goods_detail_discount in", values, "goodsDetailDiscount");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailDiscountNotIn(List<Float> values) {
            addCriterion("goods_detail_discount not in", values, "goodsDetailDiscount");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailDiscountBetween(Float value1, Float value2) {
            addCriterion("goods_detail_discount between", value1, value2, "goodsDetailDiscount");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailDiscountNotBetween(Float value1, Float value2) {
            addCriterion("goods_detail_discount not between", value1, value2, "goodsDetailDiscount");
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