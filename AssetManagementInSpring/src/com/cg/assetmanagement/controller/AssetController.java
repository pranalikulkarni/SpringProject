package com.cg.assetmanagement.controller;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cg.assetmanagement.bean.AssetAllocation;
import com.cg.assetmanagement.service.IAssetAllocationService;

@Controller
@RequestMapping("Asset")
public class AssetController {
	@Autowired
	private IAssetAllocationService service;
	
	public IAssetAllocationService getService() {
		return service;
	}
	public void setService(IAssetAllocationService service) {
		this.service = service;
	}

	@RequestMapping("/Home")
	public String Home(HttpServletRequest request,Model model)
	{
		HttpSession session = request.getSession();
		if(session.getAttribute("username")!=null && session.getAttribute("password")!=null){
			String mgrId= (String) session.getAttribute("empNo");
			System.out.println(mgrId);
			ArrayList<AssetAllocation> allocId=service.viewRequestIds(mgrId);
			model.addAttribute("allocId",allocId);
		return "views/HomePage";
		}
		else{
			return "redirect:../index2.asset";
		}
		
		
	}
	
	@RequestMapping("/raiseRequest")
	public ModelAndView RaiseRequest(HttpServletRequest request,Model model)
	{
		HttpSession session = request.getSession(false);
		List<String> assetIds = service.getAssetIds();
		String mgrId= session.getAttribute("empNo").toString();
		List<String> empIds = service.getEmpIds(mgrId);
		System.out.println(empIds);
		model.addAttribute("assetIds", assetIds);
		model.addAttribute("empIds", empIds);

		return new ModelAndView("views/RequestForm","allocation",new AssetAllocation());
	}
	
	@RequestMapping("/insertRequest")
	public String InsertRequest(@ModelAttribute("allocation") @Valid AssetAllocation assetRequest ,BindingResult result,Model model,HttpServletRequest request)
	{
		if(result.hasErrors()){
			return "views/RequestForm";
		}else{
			HttpSession session = request.getSession(false);
			String mgrId= (String) session.getAttribute("empNo");
			String quantity=service.checkQuantity(assetRequest.getAssetId());
			System.out.println(quantity);
			if(quantity.equals("0"))
			{
				String display="Insufficient Quantity. Request cannot be raised";
				model.addAttribute("errorMessage",display);
			
		}else{
			AssetAllocation assetRequestSuccess=service.addAssetRequest(assetRequest,mgrId);
			model.addAttribute("requestId",assetRequestSuccess.getAllocationId());
			String successMessage="Request No :";
			model.addAttribute("successMessage",successMessage);
		}
		return "views/RequestForm";
		}
	}
	@RequestMapping("/viewStatus")
	public ModelAndView ViewStatus(@RequestParam("allocationId") int allocationId, HttpServletRequest request)
	{
		List<AssetAllocation> status=service.viewStatus(allocationId);
		return new ModelAndView("views/Status","status",status);
	}
	
	
	@RequestMapping("/logout")
	public String logoutAction(HttpServletRequest req,Model m){
		System.out.println("in logout ");
		HttpSession session = req.getSession(false);

			session.setAttribute("valid", false);
			session.setAttribute("username", null);
			session.setAttribute("password", null);
			
			session.invalidate();
			
			
		return "redirect:../index.asset";
	}


}