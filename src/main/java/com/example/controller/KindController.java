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

import com.example.bean.Kind;
import com.example.bean.KindExample;
import com.example.bean.KindExample.Criteria;
import com.example.service.KindService;
import com.example.util.dataJson;

/**
 * 
 * @author ¿Ó√À
 * @create 2019-07-11 20:34:45
 */
@Controller
public class KindController {
	@Autowired
	private KindService kindService;
	
	@RequestMapping("/kind")
	@ResponseBody
	public dataJson getKind(@RequestParam(defaultValue="") String key, HttpServletRequest request) {
		HttpSession session = request.getSession();
		if(session.getAttribute("logined")==null||session.getAttribute("logined").equals("fail"))
			return null;
		List<Kind> list = null;
		if(key.equals(""))
			list = kindService.getKind(null);
		else {
			KindExample kindExample = new KindExample();
			Criteria criteria = kindExample.createCriteria();
			criteria.andKindNameLike("%"+key+"%");
			list = kindService.getKind(kindExample);
		}
		dataJson dataJson = new dataJson();
		dataJson.setCount(list.size());
		for(int i=0;i<list.size();i++) {
			HashMap<String, String> map = new HashMap<String, String>();
			map.put("kindId", String.valueOf(list.get(i).getKindId()));
			map.put("kindName", list.get(i).getKindName());
			dataJson.addData(map);
		}
		return dataJson;
	}
	
	@RequestMapping("/addKind")
	@ResponseBody
	public int addKind(String kindName,HttpServletRequest request) {
		HttpSession session = request.getSession();
		if(session.getAttribute("logined")==null||session.getAttribute("logined").equals("fail"))
			return 400;
		kindService.insertKind(new Kind(null,kindName));
		return 200;
	}
	
	@RequestMapping("/deleteKind")
	@ResponseBody
	public int deleteKind(@RequestParam(value = "kindIds[]")String[] kindIds,HttpServletRequest request) {
		HttpSession session = request.getSession();
		if(session.getAttribute("logined")==null||session.getAttribute("logined").equals("fail"))
			return 400;
		for(int i=0;i<kindIds.length;i++)
			kindService.deleteKind(Long.parseLong(kindIds[i]));
		return 200;
	}

}
