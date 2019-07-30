package com.example.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.bean.Manager;
import com.example.service.ManagerService;

/**
 * 
 * @author уетц
 * @create 2019-07-10 10:53:15
 */
@Controller
public class ManagerController {
	
	@Autowired
	private ManagerService managerService;
	
	@RequestMapping("/login")
	@ResponseBody
	public int login(HttpServletRequest request, HttpServletResponse response){
		String managerName = request.getParameter("username");
		Manager manager = managerService.getManager(managerName);
		if(manager == null)
			return 400;
		else {
			String password = request.getParameter("password");
			if(manager.getManagerPassword().equals(password)) {
				HttpSession session = request.getSession();
				session.setAttribute("logined", "success");
				session.setAttribute("username", managerName);
				session.setAttribute("password", password);
				session.setMaxInactiveInterval(60*2);
				return 200;
			}
			return 400;
		}
	}
	

	@RequestMapping("/keeplive")
	@ResponseBody
	public int keeplive(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(60*2);
		return 200;
	}
	
	@RequestMapping("/getName")
	@ResponseBody
	public String getName(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		return session.getAttribute("username")!=null?session.getAttribute("username").toString():"error:404";
	}
	
	@RequestMapping("/getPassword")
	@ResponseBody
	public String getPassword(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		return session.getAttribute("password").toString()!=null?session.getAttribute("password").toString():null;
	}
	
	@RequestMapping("/changePassword")
	@ResponseBody
	public int changePassword(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String username = session.getAttribute("username").toString();
		String password = request.getParameter("password");
		managerService.updateManager(new Manager(null, username, password, null, null));
		session.setAttribute("password", password);
		return 200;
	}
	
	@RequestMapping("/logout")
	@ResponseBody
	public int logout(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		session.setAttribute("logined", "fail");
		session.setAttribute("username", null);
		session.setAttribute("password", null);
		session.setMaxInactiveInterval(60);
		return 200;
	}
	

	@RequestMapping("/getAdmin")
	@ResponseBody
	public Manager getAdmin(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		if(session.getAttribute("logined")==null||session.getAttribute("logined").equals("fail"))
			return null;
		String username = session.getAttribute("username").toString();
		return managerService.getManager(username);
	}
	
	@RequestMapping("/changeAdminInfo")
	@ResponseBody
	public int changeAdminInfo(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		if(session.getAttribute("logined")==null||session.getAttribute("logined").equals("fail"))
			return 400;
		String tel = request.getParameter("tel");
		String address = request.getParameter("address");
		String username = session.getAttribute("username").toString();
		managerService.updateManager(new Manager(null, username, null, tel, address));
		return 200;
	}

}
