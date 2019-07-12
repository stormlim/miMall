package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bean.Customer;
import com.example.bean.CustomerExample;
import com.example.dao.CustomerMapper;

@Service
public class CustomerService {
	@Autowired
	private CustomerMapper customerMapper;
	
	public List<Customer> selectCustomer(CustomerExample customerExample){
		return customerMapper.selectByExample(customerExample);
	}
	
	public List<Customer> getCustomer(String likeValue){
		return customerMapper.getCustomer(likeValue);
	}
	
	public void deleteCustomer(long customerId) {
		customerMapper.deleteByPrimaryKey(customerId);
	}
	
	public long getCount() {
		return customerMapper.countByExample(null);
	}
	
	public void changeCustomer(Customer customer, CustomerExample customerExample) {
		customerMapper.updateByExampleSelective(customer, customerExample);
	}

}
