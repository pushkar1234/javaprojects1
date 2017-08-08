package com.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

@Entity
@Table(name="userinfo")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int userid;
	@Column
	private String userName;
	@Column
	private String userPassword;
	@Column
	private String userConformPassword;
	@Column
	private String usermobile;
	@Column
	private String userAddress;
	@Column
	private String userEmailaddress;
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
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
	
	public String getUserConformPassword() {
		return userConformPassword;
	}
	public void setUserConformPassword(String userConformPassword) {
		this.userConformPassword = userConformPassword;
	}
	public String getUsermobile() {
		return usermobile;
	}
	public void setUsermobile(String usermobile) {
		this.usermobile = usermobile;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	public String getUserEmailaddress() {
		return userEmailaddress;
	}
	public void setUserEmailaddress(String userEmailaddress) {
		this.userEmailaddress = userEmailaddress;
	}
	
	/*public User(int userid, String userName, String userPassword, long usermobile, String userAddress,
			String userEmailaddress) {
		super();
		this.userid = userid;
		this.userName = userName;
		this.userPassword = userPassword;
		this.usermobile = usermobile;
		this.userAddress = userAddress;
		this.userEmailaddress = userEmailaddress;
	}
	@Override
	public String toString() {
		return "User [userid=" + userid + ", userName=" + userName + ", userPassword=" + userPassword + ", usermobile="
				+ usermobile + ", userAddress=" + userAddress + ", userEmailaddress=" + userEmailaddress + "]";
	}
    */
}
