package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.bean.OrderDetailExample;
import com.example.bean.Orders;
import com.example.bean.OrdersExample;
import com.example.bean.OrdersExample.Criteria;
import com.example.dao.OrderDetailMapper;
import com.example.dao.OrdersMapper;

@Controller
public class OrderService {
	@Autowired
	private OrdersMapper ordersMapper;
	@Autowired
	private OrderDetailMapper orderDetailMapper;
	
	public long OrderCount(OrdersExample ordersExample) {
		return ordersMapper.countByExample(ordersExample);
	}
	
	public List<Orders> getOrders(String likeValue){
		return ordersMapper.selectWithAll(likeValue);
	}
	
	public void deleteOrders(long ordersId) {
		OrdersExample ordersExample = new OrdersExample();
		Criteria criteria = ordersExample.createCriteria();
		criteria.andOrderIdEqualTo(ordersId);
		OrderDetailExample orderDetailExample = new OrderDetailExample();
		com.example.bean.OrderDetailExample.Criteria criteria2 = orderDetailExample.createCriteria();
		criteria2.andOrderIdEqualTo(ordersId);
		orderDetailMapper.deleteByExample(orderDetailExample);
		ordersMapper.deleteByExample(ordersExample);
	}
	
	public void uploadOrders(Orders orders, OrdersExample ordersExample) {
		ordersMapper.updateByExampleSelective(orders, ordersExample);
	}
	
	public long getCount() {
		return ordersMapper.countByExample(null);
	}

}
