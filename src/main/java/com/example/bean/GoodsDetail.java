package com.example.bean;

public class GoodsDetail {
    private Long goodsDetailId;

    private Long goodsId;

    private String goodsDetailName;

    private Float goodsDetailPrice;

    private Integer goodsDetailQuantity;

    private Float goodsDetailDiscount;
    
    private String goodsDetailIntroduction;
    
    private Integer goodsDetailStatus;
    
    private Kind kind;
    
    private Goods goods;

    public GoodsDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GoodsDetail(Long goodsDetailId, Long goodsId, String goodsDetailName, Float goodsDetailPrice,
			Integer goodsDetailQuantity, Float goodsDetailDiscount, String goodsDetailIntroduction) {
		super();
		this.goodsDetailId = goodsDetailId;
		this.goodsId = goodsId;
		this.goodsDetailName = goodsDetailName;
		this.goodsDetailPrice = goodsDetailPrice;
		this.goodsDetailQuantity = goodsDetailQuantity;
		this.goodsDetailDiscount = goodsDetailDiscount;
		this.goodsDetailIntroduction = goodsDetailIntroduction;
	
	}

	public Kind getKind() {
		return kind;
	}

	public void setKind(Kind kind) {
		this.kind = kind;
	}

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public Long getGoodsDetailId() {
        return goodsDetailId;
    }

    public void setGoodsDetailId(Long goodsDetailId) {
        this.goodsDetailId = goodsDetailId;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsDetailName() {
        return goodsDetailName;
    }

    public void setGoodsDetailName(String goodsDetailName) {
        this.goodsDetailName = goodsDetailName == null ? null : goodsDetailName.trim();
    }

    public Float getGoodsDetailPrice() {
        return goodsDetailPrice;
    }

    public void setGoodsDetailPrice(Float goodsDetailPrice) {
        this.goodsDetailPrice = goodsDetailPrice;
    }

    public Integer getGoodsDetailQuantity() {
        return goodsDetailQuantity;
    }

    public void setGoodsDetailQuantity(Integer goodsDetailQuantity) {
        this.goodsDetailQuantity = goodsDetailQuantity;
    }

    public Float getGoodsDetailDiscount() {
        return goodsDetailDiscount;
    }

    public void setGoodsDetailDiscount(Float goodsDetailDiscount) {
        this.goodsDetailDiscount = goodsDetailDiscount;
    }

	public Integer getGoodsDetailStatus() {
		return goodsDetailStatus;
	}

	public String getGoodsDetailIntroduction() {
		return goodsDetailIntroduction;
	}

	public void setGoodsDetailIntroduction(String goodsDetailIntroduction) {
		this.goodsDetailIntroduction = goodsDetailIntroduction;
	}

	public void setGoodsDetailStatus(Integer goodsDetailStatus) {
		this.goodsDetailStatus = goodsDetailStatus;
	}
    
}