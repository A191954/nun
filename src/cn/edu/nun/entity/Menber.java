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
	//��Աû���û���������
	private String brief;
	//�û�����
	private String usertype;
	//����
	private String name;
	//����
	private Integer age;
	//�绰
	private String telephone;
	//����
	private String email;
	// Constructors
	
	//��Ա�Ķӳ����鳤 һ��һ
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