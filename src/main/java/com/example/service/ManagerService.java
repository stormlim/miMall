package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bean.Manager;
import com.example.dao.ManagerMapper;

@Service
public class ManagerService {
	
	@Autowired
	private ManagerMapper managerMapper;
	
	public Manager getManager(String managerName) {
		return managerMapper.getManager(managerName).size()==0?null:managerMapper.getManager(managerName).get(0);
	}
	
	public void updateManager(Manager manager) {
		managerMapper.updateManagerByName(manager);
	}

}
