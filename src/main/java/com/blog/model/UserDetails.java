package com.blog.model;

import java.io.File;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import com.blog.validator.UserValidator;

@Entity
public class UserDetails{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int userId;
	@NotNull(message="User Name cann't be EMPTY")//The CharSequence, Collection, Map or Array object is not null, but can be empty
	private String userName;
	@NotEmpty(message="Email can't be EMPTY")//The CharSequence, Collection, Map or Array object is not null and size > 0
	@Email(message="Enter valid e-mail")
	private String email;
	@NotBlank(message="Password can't be EMPTY")//The string is not null and the trimmed length is greater than zero
	private String password;
	//private String imgpath;
	@DateTimeFormat(pattern="dd/MM/yyyy")
   // @NotNull(message="Password can't be EMPTY")
	private Date creationDate;
    @NotNull (message="Date o birth can't be EMPTY")
	private String dob;
	@NotNull(message="Gendeer can't be EMPTY")
	private String gender;
	//@NotEmpty(message="phoneNo. can't be EMPTY")
    @Size(min = 10,max = 12)
	private String phone;
	private String enable;
	
	
	@Transient
	private String reTypePass;
	
	/*@Transient
	private File file;*/

	
	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}
 
	public String isEnable() {
	return enable;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

/*	public String getImgpath() {
		return imgpath;
	}

	public void setImgpath(String imgpath) {
		this.imgpath = imgpath;
	}*/

	public String getReTypePass() {
		return reTypePass;
	}

	public void setReTypePass(String reTypePass) {
		this.reTypePass = reTypePass;
	}

	public String getEnable() {
		return enable;
	}

	public void setEnable(String enable) {
		this.enable = enable;
	}

/*	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}*/
	

}
