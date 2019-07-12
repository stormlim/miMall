package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bean.GoodsDetail;
import com.example.bean.GoodsDetailExample;
import com.example.dao.GoodsDetailMapper;

@Service
public class GoodsDetailService {
	@Autowired
	private GoodsDetailMapper goodsDetailMapper;
	
	public void deleteGoodsDetail(long goodsDetailId) {
		goodsDetailMapper.deleteByPrimaryKey(goodsDetailId);
	}
	
	public List<GoodsDetail> getGoodsDetail(String likeValue) {
		return goodsDetailMapper.selectWithAll(likeValue);
	}
	
	public List<GoodsDetail> selectGoodsDetail(GoodsDetailExample goodsDetailExample){
		return goodsDetailMapper.selectByExample(goodsDetailExample);
	}
	
	public List<GoodsDetail> selectWithNoPicture(){
		return goodsDetailMapper.selectWithNoPicture();
	}
	
	public void insertGoodsDetail(GoodsDetail goodsDetail) {
		goodsDetailMapper.insert(goodsDetail);
	}
	
	public void uploadGoodsDetail(GoodsDetail goodsDetail, GoodsDetailExample goodsDetailExample) {
		goodsDetailMapper.updateByExample(goodsDetail, goodsDetailExample);
	}

}
