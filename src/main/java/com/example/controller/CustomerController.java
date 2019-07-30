package com.example.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.bean.Customer;
import com.example.bean.OrdersExample;
import com.example.service.CustomerService;
import com.example.service.OrderService;
import com.example.util.dataJson;

/**
 * 
 * @author уетц
 * @create 2019-07-11 17:54:05
 */
@Controller
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	@Autowired
	private OrderService orderService;
	
	@RequestMapping("/getCustomer")
	@ResponseBody
	public dataJson getCustomer(@RequestParam(defaultValue="") String key, HttpServletRequest request) {
		HttpSession session = request.getSession();
		if(session.getAttribute("logined")==null||session.getAttribute("logined").equals("fail"))
			return null;
		List<Customer> list = null;
		if(key.equals(""))
			list = customerService.getCustomer(null);
		else
			list = customerService.getCustomer("%"+key+"%");
		dataJson dJson = new dataJson();
		dJson.setCount(list.size());
		for(Customer customer : list) {
			long customerId = customer.getCustomerId();
			OrdersExample ordersExample = new OrdersExample();
			com.example.bean.OrdersExample.Criteria criteria = ordersExample.createCriteria();
			criteria.andCustomerIdEqualTo(customerId);
			HashMap<String, String> map = new HashMap<String,String>();
			long num = orderService.OrderCount(ordersExample);
			map.put("usersId", String.valueOf(customer.getCustomerId()));
			map.put("userName", String.valueOf(customer.getCustomerName()));
			map.put("userPhone", customer.getCustomerPhone());
			map.put("address", customer.getCustomerAddress());
			map.put("orderNum", String.valueOf(num));
			dJson.addData(map);
		}
		return dJson;
	}
	
	@RequestMapping("/deleteCustomer")
	@ResponseBody
	public int deleteCustomer(@RequestParam(value = "usersId[]")String[] usersId, HttpServletRequest request) {
		HttpSession session = request.getSession();
		if(session.getAttribute("logined")==null||session.getAttribute("logined").equals("fail"))
			return 400;
		int flag=0;
		for(int i=0; i<usersId.length;i++) {
			try {
				customerService.deleteCustomer(Long.parseLong(usersId[i]));
			}catch (Exception e) {
				e.printStackTrace();
				flag++;
			}
		}
		return flag;
	}

}
