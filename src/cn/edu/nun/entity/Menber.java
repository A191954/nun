package cn.edu.nun.entity;

/**
 * Menber entity. @author MyEclipse Persistence Tools
 */

public class Menber implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	//成员没有用户名和密码
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
	// Constructors
	
	//成员的队长是组长 一对一
	private Applicant applicant;

	public Menber() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Menber(String brief, String usertype, String name, Integer age, String telephone, String email,
			Applicant applicant) {
		super();
		this.brief = brief;
		this.usertype = usertype;
		this.name = name;
		this.age = age;
		this.telephone = telephone;
		this.email = email;
		this.applicant = applicant;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Applicant getApplicant() {
		return applicant;
	}

	public void setApplicant(Applicant applicant) {
		this.applicant = applicant;
	}

	@Override
	public String toString() {
		return "Menber [id=" + id + ", brief=" + brief + ", usertype=" + usertype + ", name=" + name + ", age=" + age
				+ ", telephone=" + telephone + ", email=" + email + ", applicant=" + applicant + "]";
	}

}