package com.cg.assetmanagement.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="asset_allocation")
@NamedQueries(
		{
			@NamedQuery(name="getStatus" ,query="SELECT a FROM AssetAllocation a where mgrId =:mgrCode")
		}
		)
public class AssetAllocation {
	
	@Override
	public String toString() {
		return "AssetAllocation [allocationId=" + allocationId + ", assetId="
				+ assetId + ", empNo=" + empNo + ", AllocationDate="
				+ AllocationDate + ", releaseDate=" + releaseDate + ", status="
				+ status + ", mgrId=" + mgrId + ", requestedQuantity="
				+ requestedQuantity + "]";
	}


	@Id
	@SequenceGenerator(name="asset_sequence",sequenceName="asset_sequence")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "asset_sequence")
	private int allocationId;
	@NotEmpty
	private String assetId;
	@NotEmpty
	private String empNo;
	@Column(name="allocation_date")
	private String AllocationDate;
	@Column(name="release_date")
	private String releaseDate;
	private String status;
	private String mgrId;
	@NotEmpty
	@Pattern(regexp = "[0-9]", message = "Quantity should be less than 10")
	private String requestedQuantity;


	
	public int getAllocationId() {
		return allocationId;
	}

	public String getAssetId() {
		return assetId;
	}


	public void setAssetId(String assetId) {
		this.assetId = assetId;
	}



	public void setAllocationId(int allocationId) {
		this.allocationId = allocationId;
	}



	public String getEmpNo() {
		return empNo;
	}


	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}


	public String getAllocationDate() {
		return AllocationDate;
	}


	public void setAllocationDate(String allocationDate) {
		AllocationDate = allocationDate;
	}


	public String getReleaseDate() {
		return releaseDate;
	}


	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getMgrId() {
		return mgrId;
	}


	public void setMgrId(String mgrId) {
		this.mgrId = mgrId;
	}


	public String getRequestedQuantity() {
		return requestedQuantity;
	}


	public void setRequestedQuantity(String requestedQuantity) {
		this.requestedQuantity = requestedQuantity;
	}

	public AssetAllocation(int allocationId, String assetId, String empNo,
			String allocationDate, String releaseDate, String status,
			String mgrId, String requestedQuantity) {
		super();
		this.allocationId = allocationId;
		this.assetId = assetId;
		this.empNo = empNo;
		AllocationDate = allocationDate;
		this.releaseDate = releaseDate;
		this.status = status;
		this.mgrId = mgrId;
		this.requestedQuantity = requestedQuantity;
	}

	public AssetAllocation() {
		// TODO Auto-generated constructor stub
	}
	
	
}
