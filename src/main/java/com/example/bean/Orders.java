package com.example.bean;

import java.util.Date;

public class Orders {
    private Long orderId;

    private Long customerId;

    private String orderNo;

    private String orderStatus;

    private String orderEvaluation;

    private Date orderTime;

    private Float orderTotalPayment;
    
    private Customer customer;
    
    private OrderDetail orderDetail;
    
    private GoodsDetail goodsDetail;

    public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Orders(Long orderId, Long customerId, String orderNo, String orderStatus, String orderEvaluation,
			Date orderTime, Float orderTotalPayment) {
		super();
		this.orderId = orderId;
		this.customerId = customerId;
		this.orderNo = orderNo;
		this.orderStatus = orderStatus;
		this.orderEvaluation = orderEvaluation;
		this.orderTime = orderTime;
		this.orderTotalPayment = orderTotalPayment;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public OrderDetail getOrderDetail() {
		return orderDetail;
	}

	public void setOrderDetail(OrderDetail orderDetail) {
		this.orderDetail = orderDetail;
	}

	public GoodsDetail getGoodsDetail() {
		return goodsDetail;
	}

	public void setGoodsDetail(GoodsDetail goodsDetail) {
		this.goodsDetail = goodsDetail;
	}

	public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus == null ? null : orderStatus.trim();
    }

    public String getOrderEvaluation() {
        return orderEvaluation;
    }

    public void setOrderEvaluation(String orderEvaluation) {
        this.orderEvaluation = orderEvaluation == null ? null : orderEvaluation.trim();
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public Float getOrderTotalPayment() {
        return orderTotalPayment;
    }

    public void setOrderTotalPayment(Float orderTotalPayment) {
        this.orderTotalPayment = orderTotalPayment;
    }
}