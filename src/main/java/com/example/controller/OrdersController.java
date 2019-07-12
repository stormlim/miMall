package com.example.controller;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.bean.Orders;
import com.example.bean.OrdersExample;
import com.example.bean.OrdersExample.Criteria;
import com.example.service.CustomerService;
import com.example.service.GoodsService;
import com.example.service.KindService;
import com.example.service.OrderService;
import com.example.util.dataJson;

@Controller
public class OrdersController {
	@Autowired
	private OrderService orderService;
	@Autowired
	private GoodsService goodsService;
	@Autowired
	private KindService kindService;
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("/getOrders")
	@ResponseBody
	public dataJson getOrders(@RequestParam(defaultValue="") String key, HttpServletRequest request) {
		HttpSession session = request.getSession();
		if(session.getAttribute("logined")==null||session.getAttribute("logined").equals("fail"))
			return null;
		List<Orders> list = null;
		if(key.equals(""))
			list = orderService.getOrders(null);
		else
			list = orderService.getOrders("%"+key+"%");
		dataJson dataJson = new dataJson();
		dataJson.setCount(list.size());
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		for(Orders order:list) {
			HashMap<String, String> map = new HashMap<String,String>();
			map.put("usersId", String.valueOf(order.getOrderId()));
			map.put("orderNum", order.getOrderNo());
			map.put("orderStatus", order.getOrderStatus());
			map.put("orderTime",format.format(order.getOrderTime()));
			map.put("orderPrice",String.valueOf(order.getOrderTotalPayment()));
			try{
				map.put("itemName",order.getGoodsDetail().getGoodsDetailName());
			}catch (Exception e) {
				
			}
			map.put("itemNum",String.valueOf(order.getOrderDetail().getOrderDetailGoodsQuantity()));
			map.put("buyer", order.getCustomer().getCustomerName());
			map.put("address", order.getCustomer().getCustomerAddress());
			dataJson.addData(map);
		}
		return dataJson;
	}
	
	@RequestMapping("/deleteOrders")
	@ResponseBody
	public int deleteOrders(@RequestParam(value = "ordersId[]")String[] ordersId,HttpServletRequest request) {
		HttpSession session = request.getSession();
		if(session.getAttribute("logined")==null||session.getAttribute("logined").equals("fail"))
			return 400;
		int flag=0;
		for(int i=0; i<ordersId.length;i++) {
			try {
				orderService.deleteOrders(Long.parseLong(ordersId[i]));
			}catch (Exception e) {
				e.printStackTrace();
				flag++;
			}
		}
		return flag;
	}
	
	@RequestMapping("/uploadOrders")
	@ResponseBody
	public int uploadOrders(String ordersNum, String orderStatus, HttpServletRequest request) {
		HttpSession session = request.getSession();
		if(session.getAttribute("logined")==null||session.getAttribute("logined").equals("fail"))
			return 400;
		System.out.println(ordersNum+":"+orderStatus);
		OrdersExample ordersExample = new OrdersExample();
		Criteria criteria = ordersExample.createCriteria();
		criteria.andOrderNoEqualTo(ordersNum);
		if(orderStatus.equals("0"))
			orderStatus="未发货";
		else if(orderStatus.equals("1"))
			orderStatus="已发货";
		else if(orderStatus.equals("2"))
			orderStatus="已收货";
		orderService.uploadOrders(new Orders(null, null, ordersNum, orderStatus, null, null, null), ordersExample);
		return 200;
	}
	
	@RequestMapping("/getInfo")
	@ResponseBody
	public HashMap<String,String> getInfo(HttpServletRequest request,HttpServletResponse response){
		HttpSession session = request.getSession();
		if(session.getAttribute("logined")==null||session.getAttribute("logined").equals("fail"))
			return null;
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("order", String.valueOf(orderService.getCount()));
		map.put("item",String.valueOf(goodsService.getCount()));
		map.put("kind",String.valueOf(kindService.getCount()));
		map.put("user",String.valueOf(customerService.getCount()));
		return map;
	}

}
