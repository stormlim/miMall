package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.bean.Goods;
import com.example.bean.GoodsExample;
import com.example.dao.GoodsMapper;

@Controller
public class GoodsService {
	@Autowired
	private GoodsMapper goodsMapper;
	
	public List<Goods> getGoods(String likeValue){
		return goodsMapper.selectWithAll(likeValue);
	}
	
	public List<Goods> selectGoods(GoodsExample goodsExample){
		return goodsMapper.selectByExample(goodsExample);
	}

	public long insertGoods(Goods goods) {
		goodsMapper.insert(goods);
		return goods.getGoodsId();
	}
	
	public void uploadGoods(Goods goods, GoodsExample goodsExample) {
		goodsMapper.updateByExample(goods, goodsExample);
	}
	
	public long getCount() {
		return goodsMapper.countByExample(null);
	}
}
