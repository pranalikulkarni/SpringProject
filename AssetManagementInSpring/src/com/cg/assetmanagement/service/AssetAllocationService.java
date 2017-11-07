package com.cg.assetmanagement.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.assetmanagement.bean.AssetAllocation;
import com.cg.assetmanagement.bean.Login;
import com.cg.assetmanagement.dao.IAssetDao;

@Service
@Transactional
public class AssetAllocationService implements IAssetAllocationService {
		
		@Autowired
		private IAssetDao dao;
		
		
		public IAssetDao getDao() {
			return dao;
		}


		public void setDao(IAssetDao dao) {
			this.dao = dao;
		}


		public AssetAllocation addAssetRequest(AssetAllocation assetRequest,String mgrId)
		{
			assetRequest.setAllocationDate(null);
			assetRequest.setReleaseDate(null);
			assetRequest.setStatus("PENDING");
			assetRequest.setMgrId(mgrId);
			return dao.addAssetRequest(assetRequest,mgrId);
		}


		@Override
		public List<String> getAssetIds() {
			
			return dao.getAssetIds();
		}


		@Override
		public List<String> getEmpIds(String mgrId) {
			// TODO Auto-generated method stub
			return dao.getEmpIds(mgrId);
		}


		@Override
		public Login getLoginDetails(String username, String password) {
			// TODO Auto-generated method stub
			return dao.getLoginDetails(username, password);
		}


		@Override
		public ArrayList<AssetAllocation> viewRequestIds(String empno) {
			return dao.viewRequestIds(empno);
		}
		
		public String checkQuantity(String assetNo){
			return dao.checkQuantity(assetNo);
		}
		public List<AssetAllocation> viewStatus(int allocationId)
		{
			return dao.viewStatus(allocationId);
		}
		
	}



