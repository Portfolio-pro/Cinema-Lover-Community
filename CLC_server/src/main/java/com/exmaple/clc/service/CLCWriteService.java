package com.exmaple.clc.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.exmaple.clc.dao.CLCDao;

public class CLCWriteService implements ICLCService{

	@Override
	public void execute(Model model) {
		Map<String, Object>map=model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String movie_id = request.getParameter("movie_id");
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String rating = request.getParameter("rating");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		
		if(movie_id !=null && movie_id !="" && id !=null && id !="") { // 다른 조건? 많은데 일단 생략
			CLCDao dao = new CLCDao();
			dao.write(movie_id, id, password, rating, subject, content);
		}
	}

}
