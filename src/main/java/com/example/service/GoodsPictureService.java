package com.example.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bean.GoodsDetailPicture;
import com.example.bean.GoodsDetailPictureExample;
import com.example.dao.GoodsDetailPictureMapper;

@Service
public class GoodsPictureService {

	@Autowired
	private GoodsDetailPictureMapper goodsDetailPictureMapper;
	
	public List<GoodsDetailPicture> getGoodsPicture(String likeValue){
		return goodsDetailPictureMapper.selectWithAll(likeValue);
	}
	
	public void insertGoodsPicture(GoodsDetailPicture goodsDetailPicture) {
		goodsDetailPictureMapper.insert(goodsDetailPicture);
		Map paramMap = new HashMap();
		paramMap.put("picUrl", goodsDetailPicture.getGoodsDetailPictureUrl());
		paramMap.put("goodsDetailId", goodsDetailPicture.getGoodsDetailId());
		goodsDetailPictureMapper.updateGoods(paramMap);
	}
	
	public GoodsDetailPicture selectGoodsPicture(long goodsDetailPictureId){
		return goodsDetailPictureMapper.selectByPrimaryKey(goodsDetailPictureId);
	}
	
	public void updatePicture(GoodsDetailPicture goodsDetailPicture, GoodsDetailPictureExample goodsDetailPictureExample) {
		goodsDetailPictureMapper.updateByExampleSelective(goodsDetailPicture, goodsDetailPictureExample);
	}
}
