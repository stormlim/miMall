package com.example.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.example.bean.GoodsDetailPicture;
import com.example.bean.GoodsDetailPictureExample;
import com.example.bean.GoodsDetailPictureExample.Criteria;
import com.example.service.GoodsPictureService;
import com.example.util.dataJson;

/**
 * 
 * @author ¿Ó√À
 * @create 2019-07-10 09:12:12
 */
@Controller
public class GoodsPictureController {
	
	@Autowired
	private GoodsPictureService goodsPictureService;
	
	@RequestMapping("getGoodsPicture")
	@ResponseBody
	public dataJson getGoodsPicture(@RequestParam(defaultValue="") String value, HttpServletRequest request) {
		HttpSession session = request.getSession();
		if(session.getAttribute("logined")==null||session.getAttribute("logined").equals("fail"))
			return null;
		List<GoodsDetailPicture> list = null;
		if(value.equals(""))
			list = goodsPictureService.getGoodsPicture(null);
		else 
			list = goodsPictureService.getGoodsPicture("%"+value+"%");
		dataJson dataJson = new dataJson();
		dataJson.setCount(list.size());
		for(int i=0;i<list.size();i++) {
			HashMap<String, String> map = new HashMap<String, String>();
			map.put("linkId", String.valueOf(list.get(i).getGoodsDetailPictureId()));
			map.put("itemName", list.get(i).getGoodsDetail().getGoodsDetailName());
			map.put("picSrc", list.get(i).getGoodsDetailPictureUrl().replace("mimall", "/miMall"));
			dataJson.addData(map);
		}
		return dataJson;
	}
	
	@RequestMapping(value="/insertGoodsPicture")
	@ResponseBody
	public int insertGoodsPicture(@RequestParam("file")MultipartFile file, String goodsDetailId, HttpServletRequest request) {
		HttpSession session = request.getSession();
		if(session.getAttribute("logined")==null||session.getAttribute("logined").equals("fail"))
			return 400;
		//String basePath = "/tomcat/mailserver/webapps/backssm/mimall/";//windowsœ¬F:\JAVABC\miMall\src\main\webapp\
		String str=file.getOriginalFilename();
		String filename = goodsDetailId+str.substring(str.lastIndexOf("."), str.length());
		//System.out.println(basePath+"images/goodsPicture/"+filename);
		if (file.isEmpty()) {
			return 400;
		} else {
			try {
				//file.transferTo(new File(basePath+"images/goodsPicture/"+filename));
				file.transferTo(new File("/tomcat/fcserver/webapps/miMall/images/goodsPicture/"+filename));
				Files.copy(new File("/tomcat/fcserver/webapps/miMall/images/goodsPicture/"+filename).toPath(),new File("/tomcat/fcserver/webapps/backssm/mimall/images/goodsPicture/"+filename).toPath());
				goodsPictureService.insertGoodsPicture(new GoodsDetailPicture(null,Long.valueOf(goodsDetailId),"mimall/images/goodsPicture/"+filename));
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
				return 400;
			}
		}
		return 200;
	}
	
	@RequestMapping(value="/uploadGoodsPicture")
	@ResponseBody
	public int uploadGoodsPicture(@RequestParam("file")MultipartFile file, String picId,HttpServletRequest request) {
		HttpSession session = request.getSession();
		if(session.getAttribute("logined")==null||session.getAttribute("logined").equals("fail"))
			return 400;
		if (file.isEmpty()) {
			return 400;
		} else {
			try {
				//String basePath = "/tomcat/mailserver/webapps/backssm/mimall/";
				GoodsDetailPicture gp = goodsPictureService.selectGoodsPicture(Long.parseLong(picId));
				new File("/tomcat/fcserver/webapps/miMall/images/goodsPicture/"+gp.getGoodsDetailPictureUrl().replace("mimall/images/goodsPicture/", "")).delete();
				new File("/tomcat/fcserver/webapps/backssm/mimall/images/goodsPicture/"+gp.getGoodsDetailPictureUrl().replace("mimall/images/goodsPicture/", "")).delete();
				String str=file.getOriginalFilename();
				String filename = gp.getGoodsDetailId()+str.substring(str.lastIndexOf("."), str.length());
				//file.transferTo(new File(basePath+"images/goodsPicture/"+pictureName));
				file.transferTo(new File("/tomcat/fcserver/webapps/miMall/images/goodsPicture/"+filename));
				Files.copy(new File("/tomcat/fcserver/webapps/miMall/images/goodsPicture/"+filename).toPath(),new File("/tomcat/fcserver/webapps/backssm/mimall/images/goodsPicture/"+filename).toPath());
				GoodsDetailPictureExample goodsDetailPictureExample = new GoodsDetailPictureExample();
				Criteria criteria = goodsDetailPictureExample.createCriteria();
				criteria.andGoodsDetailPictureIdEqualTo(Long.parseLong(picId));
				goodsPictureService.updatePicture(new GoodsDetailPicture(null, null,"mimall/images/goodsPicture/"+filename), goodsDetailPictureExample);
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
				return 400;
			}
		}
		return 200;
	}

}
