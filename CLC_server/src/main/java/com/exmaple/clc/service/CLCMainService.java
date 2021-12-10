package com.exmaple.clc.service;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.exmaple.clc.dao.CLCDao;
import com.exmaple.clc.dto.CLCMovieDto;

public class CLCMainService implements ICLCService {

	@Override
	public void execute(Model model) {
		Map<String, Object>map=model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		String movie_id = request.getParameter("movie_id");
		String title = request.getParameter("title");
		String genres = request.getParameter("genres");
		String summary = request.getParameter("summary");
		String runtime = request.getParameter("runtime");
		String year = request.getParameter("year");
		String image = request.getParameter("image");
		
		CLCDao dao = new CLCDao();
		ArrayList<CLCMovieDto>dtos = dao.main(movie_id, title, genres, summary, runtime, year, image);
		
		model.addAttribute("main", dtos);
	}

}
