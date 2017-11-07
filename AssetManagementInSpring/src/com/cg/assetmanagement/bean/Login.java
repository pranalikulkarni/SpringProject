package com.cg.assetmanagement.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "user_master")
@NamedQueries(@NamedQuery(name = "getLogin", 
	query = "SELECT log FROM Login log WHERE log.userName=:user AND log.userPassword=:pass"))
public class Login {
	
	@Id
	private String userId;
	@NotEmpty(message = "Invalid Username")
	private String userName;
	@NotEmpty(message = "Invalid Password")
	private String userPassword;
	private String userType;
	private String empNo;
	
	
	
	
	@Override
	public String toString() {
		return "Login [userName=" + userName + ", userPassword=" + userPassword
				+ "]";
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getEmpNo() {
		return empNo;
	}

	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}

	Login()
	{
		super();
	}
	
}


