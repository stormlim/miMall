package com.example.bean;

public class Cart {
    private Long cartId;

    private Long customerId;

    public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cart(Long cartId, Long customerId) {
		super();
		this.cartId = cartId;
		this.customerId = customerId;
	}

	public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
}