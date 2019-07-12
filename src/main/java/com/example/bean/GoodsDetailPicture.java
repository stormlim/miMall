package com.example.bean;

public class GoodsDetailPicture {
    private Long goodsDetailPictureId;

    private Long goodsDetailId;

    private String goodsDetailPictureUrl;
    
    private GoodsDetail goodsDetail;

    public GoodsDetailPicture() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GoodsDetailPicture(Long goodsDetailPictureId, Long goodsDetailId, String goodsDetailPictureUrl) {
		super();
		this.goodsDetailPictureId = goodsDetailPictureId;
		this.goodsDetailId = goodsDetailId;
		this.goodsDetailPictureUrl = goodsDetailPictureUrl;
	}

	public GoodsDetail getGoodsDetail() {
		return goodsDetail;
	}

	public void setGoodsDetail(GoodsDetail goodsDetail) {
		this.goodsDetail = goodsDetail;
	}

	public Long getGoodsDetailPictureId() {
        return goodsDetailPictureId;
    }

    public void setGoodsDetailPictureId(Long goodsDetailPictureId) {
        this.goodsDetailPictureId = goodsDetailPictureId;
    }

    public Long getGoodsDetailId() {
        return goodsDetailId;
    }

    public void setGoodsDetailId(Long goodsDetailId) {
        this.goodsDetailId = goodsDetailId;
    }

    public String getGoodsDetailPictureUrl() {
        return goodsDetailPictureUrl;
    }

    public void setGoodsDetailPictureUrl(String goodsDetailPictureUrl) {
        this.goodsDetailPictureUrl = goodsDetailPictureUrl == null ? null : goodsDetailPictureUrl.trim();
    }
}