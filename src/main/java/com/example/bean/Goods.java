package com.example.bean;

import java.util.Date;

public class Goods {
    private Long goodsId;

    private Long kindId;

    private String goodsName;

    private String goodsIntroduction;

    private Integer goodsSaleQuantity;

    private Date goodsDate;
    
    private GoodsDetail goodsDetail;
    
    private Kind kind;

    public Goods() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Goods(Long goodsId, Long kindId, String goodsName, String goodsIntroduction, Integer goodsSaleQuantity,
			Date goodsDate) {
		super();
		this.goodsId = goodsId;
		this.kindId = kindId;
		this.goodsName = goodsName;
		this.goodsIntroduction = goodsIntroduction;
		this.goodsSaleQuantity = goodsSaleQuantity;
		this.goodsDate = goodsDate;
	}
	
	public GoodsDetail getGoodsDetail() {
		return goodsDetail;
	}

	public void setGoodsDetail(GoodsDetail goodsDetail) {
		this.goodsDetail = goodsDetail;
	}

	public Kind getKind() {
		return kind;
	}

	public void setKind(Kind kind) {
		this.kind = kind;
	}

	public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Long getKindId() {
        return kindId;
    }

    public void setKindId(Long kindId) {
        this.kindId = kindId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName == null ? null : goodsName.trim();
    }

    public String getGoodsIntroduction() {
        return goodsIntroduction;
    }

    public void setGoodsIntroduction(String goodsIntroduction) {
        this.goodsIntroduction = goodsIntroduction == null ? null : goodsIntroduction.trim();
    }

    public Integer getGoodsSaleQuantity() {
        return goodsSaleQuantity;
    }

    public void setGoodsSaleQuantity(Integer goodsSaleQuantity) {
        this.goodsSaleQuantity = goodsSaleQuantity;
    }

    public Date getGoodsDate() {
        return goodsDate;
    }

    public void setGoodsDate(Date goodsDate) {
        this.goodsDate = goodsDate;
    }
}