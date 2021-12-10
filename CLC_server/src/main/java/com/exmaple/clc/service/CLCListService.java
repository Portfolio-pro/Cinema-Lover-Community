package com.exmaple.clc.service;

import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.exmaple.clc.dao.CLCDao;
import com.exmaple.clc.dto.CLCListDto;
import com.exmaple.clc.dto.CLCMovieDto;

public class CLCListService implements ICLCService{

	@Override
	public void execute(Model model) {
		Map<String, Object>map=model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String movie_id=request.getParameter("movie_id");
		
		CLCDao dao = new CLCDao();
		CLCMovieDto mdto;
		try {
			mdto = dao.list_movie(movie_id);
			model.addAttribute("list_movie", mdto);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		ArrayList<CLCListDto> ldto;
		try {
			ldto = dao.list(movie_id);
			model.addAttribute("list", ldto);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		
	}

}
