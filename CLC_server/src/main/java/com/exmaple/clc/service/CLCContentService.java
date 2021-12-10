package com.exmaple.clc.service;

import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.exmaple.clc.dao.CLCDao;
import com.exmaple.clc.dto.CLCListDto;
import com.exmaple.clc.dto.CLCMovieDto;

public class CLCContentService implements ICLCService{

	@Override
	public void execute(Model model) {
		Map<String, Object>map=model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String movie_id=request.getParameter("movie_id");
		String id = request.getParameter("id");
		
		CLCDao dao = new CLCDao();
		CLCMovieDto mdto;
		try {
			mdto = dao.content_movie(movie_id);
			model.addAttribute("content_movie", mdto);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		
		CLCListDto ldto;
		try {
			ldto = dao.contentview(movie_id, id);
			model.addAttribute("contentview", ldto);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		
	}

}
