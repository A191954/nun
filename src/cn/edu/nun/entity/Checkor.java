package cn.edu.nun.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Checkor entity. @author MyEclipse Persistence Tools
 */

public class Checkor implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	//用户名
	private String username;
	//密码
	private String password;
	//简介
	private String brief;
	//用户类型
	private String usertype;
	//姓名
	private String name;
	//年龄
	private Integer age;
	//电话
	private String telephone;
	//邮箱
	private String email;
	
	//额外属性
	//一个审核人可以审核多个项目申请人
	private Set<Applicant> applicants = new HashSet<Applicant>(0);

	public Checkor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Checkor(String username, String password, String brief, String usertype, String name, Integer age,
			String telephone, String email, Set<Applicant> applicants) {
		super();
		this.username = username;
		this.password = password;
		this.brief = brief;
		this.usertype = usertype;
		this.name = name;
		this.age = age;
		this.telephone = telephone;
		this.email = email;
		this.applicants = applicants;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getBrief() {
		return brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	public String getUsertype() {
		return usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Applicant> getApplicants() {
		return applicants;
	}

	public void setApplicants(Set<Applicant> applicants) {
		this.applicants = applicants;
	}
	
}