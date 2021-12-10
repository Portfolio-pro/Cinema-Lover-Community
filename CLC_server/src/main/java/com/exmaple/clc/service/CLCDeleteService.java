package com.exmaple.clc.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.exmaple.clc.dao.CLCDao;

public class CLCDeleteService implements ICLCService{

	@Override
	public void execute(Model model) {
		Map<String, Object>map=model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String movie_id=request.getParameter("movie_id");
		String id = request.getParameter("id");
		
		CLCDao dao = new CLCDao();
		
		dao.delete(movie_id, id);
		
	}

}
