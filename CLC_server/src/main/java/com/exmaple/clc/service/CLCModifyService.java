package com.exmaple.clc.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.exmaple.clc.dao.CLCDao;

public class CLCModifyService implements ICLCService{

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
		
		CLCDao dao = new CLCDao();
		dao.modify(movie_id, movie_id, password, rating, subject, content, id);
		
	}

}
