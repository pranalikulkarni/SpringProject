package com.cg.assetmanagement.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.cg.assetmanagement.bean.AssetAllocation;
import com.cg.assetmanagement.bean.Login;

@Repository
public class AssetDao implements IAssetDao{
	@PersistenceContext
	private EntityManager entityManager;
	
	/**********************************************************************************************
	 *Function Name     :
	 *Input Parameters  :
	 *Return Type       :
	 *Author            :
	 *Creation Date     :
	 *Description       :
	 ********************************************************************************************/
	
	public AssetAllocation addAssetRequest(AssetAllocation assetRequest,String mgrId)
	{
	
		entityManager.persist(assetRequest);
		return assetRequest;
     
		
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<String> getAssetIds() {
		
		
		Query q = entityManager.createNamedQuery("getAssetIds", String.class);
		return q.getResultList();
		
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> getEmpIds(String mgrId) {
		Query q = entityManager.createNamedQuery("getEmpIds", String.class);
		q.setParameter("mgrId", mgrId);
		return q.getResultList();
	}

	
	public Login getLoginDetails(String username, String password) {
		Query query = entityManager.createNamedQuery("getLogin", Login.class);
		query.setParameter("user", username);
		query.setParameter("pass", password);
		Login log = (Login) query.getSingleResult();
		return log;
	}

	@Override
	public ArrayList<AssetAllocation> viewRequestIds(String empno) {
		
		Query q = entityManager.createNamedQuery("getStatus", AssetAllocation.class);
		q.setParameter("mgrCode", empno);
		@SuppressWarnings("unchecked")
		ArrayList<AssetAllocation> list = (ArrayList<AssetAllocation>) q.getResultList();
		return list ;
	}
		
	
	public String checkQuantity(String assetNo)
	{
	Query q=entityManager.createNamedQuery("checkQuantity",String.class);
	q.setParameter("assetNo",assetNo);
	String quantity= (String) q.getSingleResult();
	return quantity;
	}
	
	@SuppressWarnings("unchecked")
	public List<AssetAllocation> viewStatus(int allocationId)
	{
		Query q=entityManager.createQuery("Select a from AssetAllocation a where allocationId=:allocId",AssetAllocation.class);
		q.setParameter("allocId",allocationId);
		return q.getResultList();
	}
}



