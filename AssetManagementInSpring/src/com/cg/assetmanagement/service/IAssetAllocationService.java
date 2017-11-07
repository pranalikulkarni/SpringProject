package com.cg.assetmanagement.service;


import java.util.ArrayList;
import java.util.List;

import com.cg.assetmanagement.bean.AssetAllocation;
import com.cg.assetmanagement.bean.Login;


public interface IAssetAllocationService {
	public AssetAllocation addAssetRequest(AssetAllocation assetRequest, String mgrId);

	public List<String> getAssetIds();

	public List<String> getEmpIds(String mgrId);

	public Login getLoginDetails(String username, String password);


	public ArrayList<AssetAllocation> viewRequestIds(String mgrId);

	public List<AssetAllocation> viewStatus(int allocationId);
	public String checkQuantity(String assetNo);
}
