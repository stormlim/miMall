package com.example.bean;

public class CartDetail {
    private Long cartDetailId;

    private Long goodsDetailId;

    private Long cartId;

    private Integer cartDetailGoodsQuantity;

    public CartDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CartDetail(Long cartDetailId, Long goodsDetailId, Long cartId, Integer cartDetailGoodsQuantity) {
		super();
		this.cartDetailId = cartDetailId;
		this.goodsDetailId = goodsDetailId;
		this.cartId = cartId;
		this.cartDetailGoodsQuantity = cartDetailGoodsQuantity;
	}

	public Long getCartDetailId() {
        return cartDetailId;
    }

    public void setCartDetailId(Long cartDetailId) {
        this.cartDetailId = cartDetailId;
    }

    public Long getGoodsDetailId() {
        return goodsDetailId;
    }

    public void setGoodsDetailId(Long goodsDetailId) {
        this.goodsDetailId = goodsDetailId;
    }

    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    public Integer getCartDetailGoodsQuantity() {
        return cartDetailGoodsQuantity;
    }

    public void setCartDetailGoodsQuantity(Integer cartDetailGoodsQuantity) {
        this.cartDetailGoodsQuantity = cartDetailGoodsQuantity;
    }
}