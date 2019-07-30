package com.example.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.bean.Goods;
import com.example.bean.GoodsDetail;
import com.example.bean.GoodsDetailExample;
import com.example.bean.GoodsExample;
import com.example.bean.GoodsDetailExample.Criteria;
import com.example.bean.Kind;
import com.example.bean.KindExample;
import com.example.service.GoodsDetailService;
import com.example.service.GoodsService;
import com.example.service.KindService;
import com.example.util.dataJson;

/**
 * 
 * @author ¿Ó√À
 * @create 2019-07-09 14:14:38
 */
@Controller
public class GoodsController {
	@Autowired
	private GoodsDetailService goodsDetailService;
	@Autowired
	private KindService kindService;
	@Autowired
	private GoodsService goodsService;
	
	@RequestMapping("/getGoods")
	@ResponseBody
	public dataJson getGoods(@RequestParam(defaultValue="") String key, HttpServletRequest request) {
		HttpSession session = request.getSession();
		if(session.getAttribute("logined")==null||session.getAttribute("logined").equals("fail"))
			return null;
		List<GoodsDetail> list = null;
		if(key.equals(""))
			list = goodsDetailService.getGoodsDetail(null);
		else 
			list = goodsDetailService.getGoodsDetail("%"+key+"%");
		dataJson dataJson = new dataJson();
		dataJson.setCount(list.size());
		for(int i=0;i<list.size();i++) {
			HashMap<String, String> map = new HashMap<String, String>();
			map.put("itemId", String.valueOf(list.get(i).getGoodsDetailId()));
			map.put("itemName", list.get(i).getGoodsDetailName());
			map.put("itemKind", list.get(i).getKind().getKindName());
			map.put("introduce", list.get(i).getGoods().getGoodsIntroduction());
			map.put("status",list.get(i).getGoodsDetailStatus()==1?"∆ €":"Õ£ €");
			map.put("price", String.valueOf(list.get(i).getGoodsDetailPrice()));
			String discount;
			if(list.get(i).getGoodsDetailDiscount()==0)
				discount = "7’€";
			else if(list.get(i).getGoodsDetailDiscount()==1.0)
				discount = "8’€";
			else
				discount = "9’€";
			map.put("discount", discount);
			map.put("sail", String.valueOf(list.get(i).getGoods().getGoodsSaleQuantity()));
			map.put("remain", String.valueOf(list.get(i).getGoodsDetailQuantity()));
			map.put("releaseTime", new SimpleDateFormat("yyyy-MM-dd").format(list.get(i).getGoods().getGoodsDate()));
			dataJson.addData(map);
		}
		return dataJson;
	}
	
	@RequestMapping("/deleteGoods")
	@ResponseBody
	public int deleteGoods(@RequestParam(value = "itemIds[]")String[] itemIds, HttpServletRequest request) {
		HttpSession session = request.getSession();
		if(session.getAttribute("logined")==null||session.getAttribute("logined").equals("fail"))
			return 400;
		for(int i=0;i<itemIds.length;i++) {
			goodsDetailService.deleteGoodsDetail(Long.parseLong(itemIds[i]));
		}
		return 200;
	}
	
	@RequestMapping("/uploadGoods")
	@ResponseBody
	public int uploadGoods(String itemName,String itemKind,String introduce,String price,String discount,String remain,String date,HttpServletRequest request) {
		HttpSession session = request.getSession();
		if(session.getAttribute("logined")==null||session.getAttribute("logined").equals("fail"))
			return 400;
		GoodsDetailExample goodsDetailExample = new GoodsDetailExample();
		Criteria criteria = goodsDetailExample.createCriteria();
		criteria.andGoodsDetailNameEqualTo(itemName);
		List<GoodsDetail> list = goodsDetailService.selectGoodsDetail(goodsDetailExample);
		KindExample kindExample = new KindExample();
		com.example.bean.KindExample.Criteria criteria2 = kindExample.createCriteria();
		criteria2.andKindNameEqualTo(itemKind);
		List<Kind> list2 = kindService.getKind(kindExample);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date2 = null;
		try {
			date2 = format.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 400;
		}
		float disCount = 0;
		if(discount.equals("7’€"))
			disCount=0;
		else if(discount.equals("8’€"))
			disCount=1;
		else if(discount.equals("9’€"))
			disCount=2;
		if(list.size()==0) {
			long goodsId = goodsService.insertGoods(new Goods(null,list2.get(0).getKindId(),itemName,introduce,0,date2));
			goodsDetailService.insertGoodsDetail(new GoodsDetail(null, goodsId, itemName, Float.parseFloat(price), Integer.valueOf(remain), disCount, introduce));
		}else {
			long goodsId = list.get(0).getGoodsId();
			GoodsExample goodsExample = new GoodsExample();
			com.example.bean.GoodsExample.Criteria criteria3 = goodsExample.createCriteria();
			criteria3.andGoodsIdEqualTo(goodsId);
			System.out.println(date2);
			goodsService.uploadGoods(new Goods(goodsId,list2.get(0).getKindId(),itemName,introduce,Integer.valueOf(remain),date2), goodsExample);
			goodsDetailService.uploadGoodsDetail(new GoodsDetail(list.get(0).getGoodsDetailId(), goodsId, itemName, Float.parseFloat(price), Integer.valueOf(remain), disCount, introduce),goodsDetailExample);
		}
		return 200;
	}
	
	@RequestMapping("/getGoodsDetail")
	@ResponseBody
	public List<GoodsDetail> getNoPicGoodsDetail(HttpServletRequest request){
		HttpSession session = request.getSession();
		if(session.getAttribute("logined")==null||session.getAttribute("logined").equals("fail"))
			return null;
		return goodsDetailService.selectGoodsDetail(null);
	}
}
