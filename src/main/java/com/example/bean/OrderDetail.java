package com.example.bean;

public class OrderDetail {
    private Long orderDetailId;

    private Long orderId;

    private Long goodsDetailId;

    private Integer orderDetailGoodsQuantity;

    private Float goodsRealPayment;

    public OrderDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderDetail(Long orderDetailId, Long orderId, Long goodsDetailId, Integer orderDetailGoodsQuantity,
			Float goodsRealPayment) {
		super();
		this.orderDetailId = orderDetailId;
		this.orderId = orderId;
		this.goodsDetailId = goodsDetailId;
		this.orderDetailGoodsQuantity = orderDetailGoodsQuantity;
		this.goodsRealPayment = goodsRealPayment;
	}

	public Long getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(Long orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getGoodsDetailId() {
        return goodsDetailId;
    }

    public void setGoodsDetailId(Long goodsDetailId) {
        this.goodsDetailId = goodsDetailId;
    }

    public Integer getOrderDetailGoodsQuantity() {
        return orderDetailGoodsQuantity;
    }

    public void setOrderDetailGoodsQuantity(Integer orderDetailGoodsQuantity) {
        this.orderDetailGoodsQuantity = orderDetailGoodsQuantity;
    }

    public Float getGoodsRealPayment() {
        return goodsRealPayment;
    }

    public void setGoodsRealPayment(Float goodsRealPayment) {
        this.goodsRealPayment = goodsRealPayment;
    }
}