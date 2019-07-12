package com.example.bean;

import java.util.ArrayList;
import java.util.List;

public class OrderDetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderDetailExample() {
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

        public Criteria andOrderDetailIdIsNull() {
            addCriterion("order_detail_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderDetailIdIsNotNull() {
            addCriterion("order_detail_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderDetailIdEqualTo(Long value) {
            addCriterion("order_detail_id =", value, "orderDetailId");
            return (Criteria) this;
        }

        public Criteria andOrderDetailIdNotEqualTo(Long value) {
            addCriterion("order_detail_id <>", value, "orderDetailId");
            return (Criteria) this;
        }

        public Criteria andOrderDetailIdGreaterThan(Long value) {
            addCriterion("order_detail_id >", value, "orderDetailId");
            return (Criteria) this;
        }

        public Criteria andOrderDetailIdGreaterThanOrEqualTo(Long value) {
            addCriterion("order_detail_id >=", value, "orderDetailId");
            return (Criteria) this;
        }

        public Criteria andOrderDetailIdLessThan(Long value) {
            addCriterion("order_detail_id <", value, "orderDetailId");
            return (Criteria) this;
        }

        public Criteria andOrderDetailIdLessThanOrEqualTo(Long value) {
            addCriterion("order_detail_id <=", value, "orderDetailId");
            return (Criteria) this;
        }

        public Criteria andOrderDetailIdIn(List<Long> values) {
            addCriterion("order_detail_id in", values, "orderDetailId");
            return (Criteria) this;
        }

        public Criteria andOrderDetailIdNotIn(List<Long> values) {
            addCriterion("order_detail_id not in", values, "orderDetailId");
            return (Criteria) this;
        }

        public Criteria andOrderDetailIdBetween(Long value1, Long value2) {
            addCriterion("order_detail_id between", value1, value2, "orderDetailId");
            return (Criteria) this;
        }

        public Criteria andOrderDetailIdNotBetween(Long value1, Long value2) {
            addCriterion("order_detail_id not between", value1, value2, "orderDetailId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNull() {
            addCriterion("order_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("order_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(Long value) {
            addCriterion("order_id =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(Long value) {
            addCriterion("order_id <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(Long value) {
            addCriterion("order_id >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(Long value) {
            addCriterion("order_id >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(Long value) {
            addCriterion("order_id <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(Long value) {
            addCriterion("order_id <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<Long> values) {
            addCriterion("order_id in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<Long> values) {
            addCriterion("order_id not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(Long value1, Long value2) {
            addCriterion("order_id between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(Long value1, Long value2) {
            addCriterion("order_id not between", value1, value2, "orderId");
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

        public Criteria andOrderDetailGoodsQuantityIsNull() {
            addCriterion("order_detail_goods_quantity is null");
            return (Criteria) this;
        }

        public Criteria andOrderDetailGoodsQuantityIsNotNull() {
            addCriterion("order_detail_goods_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andOrderDetailGoodsQuantityEqualTo(Integer value) {
            addCriterion("order_detail_goods_quantity =", value, "orderDetailGoodsQuantity");
            return (Criteria) this;
        }

        public Criteria andOrderDetailGoodsQuantityNotEqualTo(Integer value) {
            addCriterion("order_detail_goods_quantity <>", value, "orderDetailGoodsQuantity");
            return (Criteria) this;
        }

        public Criteria andOrderDetailGoodsQuantityGreaterThan(Integer value) {
            addCriterion("order_detail_goods_quantity >", value, "orderDetailGoodsQuantity");
            return (Criteria) this;
        }

        public Criteria andOrderDetailGoodsQuantityGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_detail_goods_quantity >=", value, "orderDetailGoodsQuantity");
            return (Criteria) this;
        }

        public Criteria andOrderDetailGoodsQuantityLessThan(Integer value) {
            addCriterion("order_detail_goods_quantity <", value, "orderDetailGoodsQuantity");
            return (Criteria) this;
        }

        public Criteria andOrderDetailGoodsQuantityLessThanOrEqualTo(Integer value) {
            addCriterion("order_detail_goods_quantity <=", value, "orderDetailGoodsQuantity");
            return (Criteria) this;
        }

        public Criteria andOrderDetailGoodsQuantityIn(List<Integer> values) {
            addCriterion("order_detail_goods_quantity in", values, "orderDetailGoodsQuantity");
            return (Criteria) this;
        }

        public Criteria andOrderDetailGoodsQuantityNotIn(List<Integer> values) {
            addCriterion("order_detail_goods_quantity not in", values, "orderDetailGoodsQuantity");
            return (Criteria) this;
        }

        public Criteria andOrderDetailGoodsQuantityBetween(Integer value1, Integer value2) {
            addCriterion("order_detail_goods_quantity between", value1, value2, "orderDetailGoodsQuantity");
            return (Criteria) this;
        }

        public Criteria andOrderDetailGoodsQuantityNotBetween(Integer value1, Integer value2) {
            addCriterion("order_detail_goods_quantity not between", value1, value2, "orderDetailGoodsQuantity");
            return (Criteria) this;
        }

        public Criteria andGoodsRealPaymentIsNull() {
            addCriterion("goods_real_payment is null");
            return (Criteria) this;
        }

        public Criteria andGoodsRealPaymentIsNotNull() {
            addCriterion("goods_real_payment is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsRealPaymentEqualTo(Float value) {
            addCriterion("goods_real_payment =", value, "goodsRealPayment");
            return (Criteria) this;
        }

        public Criteria andGoodsRealPaymentNotEqualTo(Float value) {
            addCriterion("goods_real_payment <>", value, "goodsRealPayment");
            return (Criteria) this;
        }

        public Criteria andGoodsRealPaymentGreaterThan(Float value) {
            addCriterion("goods_real_payment >", value, "goodsRealPayment");
            return (Criteria) this;
        }

        public Criteria andGoodsRealPaymentGreaterThanOrEqualTo(Float value) {
            addCriterion("goods_real_payment >=", value, "goodsRealPayment");
            return (Criteria) this;
        }

        public Criteria andGoodsRealPaymentLessThan(Float value) {
            addCriterion("goods_real_payment <", value, "goodsRealPayment");
            return (Criteria) this;
        }

        public Criteria andGoodsRealPaymentLessThanOrEqualTo(Float value) {
            addCriterion("goods_real_payment <=", value, "goodsRealPayment");
            return (Criteria) this;
        }

        public Criteria andGoodsRealPaymentIn(List<Float> values) {
            addCriterion("goods_real_payment in", values, "goodsRealPayment");
            return (Criteria) this;
        }

        public Criteria andGoodsRealPaymentNotIn(List<Float> values) {
            addCriterion("goods_real_payment not in", values, "goodsRealPayment");
            return (Criteria) this;
        }

        public Criteria andGoodsRealPaymentBetween(Float value1, Float value2) {
            addCriterion("goods_real_payment between", value1, value2, "goodsRealPayment");
            return (Criteria) this;
        }

        public Criteria andGoodsRealPaymentNotBetween(Float value1, Float value2) {
            addCriterion("goods_real_payment not between", value1, value2, "goodsRealPayment");
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