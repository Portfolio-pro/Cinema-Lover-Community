package com.example.clc.clc_server;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.exmaple.clc.service.CLCContentService;
import com.exmaple.clc.service.CLCListService;
import com.exmaple.clc.service.CLCMainService;
import com.exmaple.clc.service.CLCWriteService;
import com.exmaple.clc.service.ICLCService;

@RestController
@SpringBootApplication
public class ClcServerApplication {

	ICLCService service;

	public static void main(String[] args) {
		SpringApplication.run(ClcServerApplication.class, args);
	}
	
	@RequestMapping("/")
	public String home(){
		return "home";
	}
/*	
	@RequestMapping("/main") // 메인에서 데이터를 저장해야되는데 그럼 HttpServletRequest 필요한가?
	public String main(HttpServletRequest request, Model model){
		System.out.println("------ main() ------");
		service  = new CLCMainService();
		service.execute(model);
		return "main";
	}
	
	@RequestMapping("/list")
	public String list(HttpServletRequest request, Model model){
		System.out.println("------ list() ------");
		model.addAttribute("request", request);
		service=new CLCListService();
		service.execute(model);
		return "list";
	}
	
	@RequestMapping("/content_view")
	public String content_view(HttpServletRequest request, Model model){
		System.out.println("------ content_view() ------");
		model.addAttribute("request", request);
		service=new CLCContentService();
		service.execute(model);		
		return "content_view";
	}
	
	@RequestMapping("/write_view")
	public String write_view(Model model){
		System.out.println("------ write_view() ------");
		return "write_view";
	}
	
	@RequestMapping("/write")
	public String write(HttpServletRequest request, Model model){
		System.out.println("------ write() ------");
		model.addAttribute("request", request);
		service=new CLCWriteService();
		service.execute(model);	
		return "redirect:list";
	}
	
	@RequestMapping(method= RequestMethod.POST, value ="/modify")
	public String modify(HttpServletRequest request, Model model){
		System.out.println("------ modify() ------");
		model.addAttribute("request", request);
		service=new CLCWriteService();
		service.execute(model);		
		return "redirect:list";
	}
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model){
		System.out.println("------ delte() ------");
		model.addAttribute("request", request);
		service=new CLCWriteService();
		service.execute(model);	
		return "redirect:list";
	}
*/
}
