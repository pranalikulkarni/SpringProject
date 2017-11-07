package com.cg.assetmanagement.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cg.assetmanagement.bean.Login;
import com.cg.assetmanagement.service.IAssetAllocationService;

@Controller
public class LoginController {

	
	@Autowired
	IAssetAllocationService service;
	
	@RequestMapping("/index")
	public String goToIndex(Model model){
		

		model.addAttribute("user", new String());
		model.addAttribute("pass", new String());
		model.addAttribute("message", new String());
		
		return "login";
	}
	
	
	
	@RequestMapping("/checkLogin")
	public String check(@RequestParam("userName") String username, @RequestParam("userPassword") String password,Model model,HttpServletRequest request){

		try{
	
			Login log = service.getLoginDetails(username, password);
				
				HttpSession session = request.getSession(true);
				session.setAttribute("valid",true);
				
				session.setAttribute("username", username);
				session.setAttribute("password", password);
				session.setAttribute("empNo", log.getEmpNo());
				return "redirect:Asset/Home.asset";
		}
		catch(Exception e){
			model.addAttribute("user", "*Invalid Username");
			model.addAttribute("pass", "*Invalid Password");
			model.addAttribute("msg",new String());
			
		}
		return "login";
	}

	
	@RequestMapping("/index2")
	public String againToIndex(Model model){
		
		model.addAttribute("user", new String());
		model.addAttribute("pass", new String());
		model.addAttribute("message", "Login Details should be entered first");
		return "login";
	}
	
}