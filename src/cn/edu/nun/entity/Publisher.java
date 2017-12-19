package cn.edu.nun.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Publisher entity. @author MyEclipse Persistence Tools
 */

public class Publisher implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	//�û���
	private String username;
	//����
	private String password;
	//���
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
	
	//��������
	//��Ŀ�����˷���������Ŀ
	private ItemNew itemNew;
	//��Ŀ��������ʷ��������Ŀ
	private Set<ItemOld> itemOlds = new HashSet<ItemOld>(0);
	public Publisher() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Publisher(String username, String password, String brief, String usertype, String name, Integer age,
			String telephone, String email, ItemNew itemNew, Set<ItemOld> itemOlds) {
		super();
		this.username = username;
		this.password = password;
		this.brief = brief;
		this.usertype = usertype;
		this.name = name;
		this.age = age;
		this.telephone = telephone;
		this.email = email;
		this.itemNew = itemNew;
		this.itemOlds = itemOlds;
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
	public ItemNew getItemNew() {
		return itemNew;
	}
	public void setItemNew(ItemNew itemNew) {
		this.itemNew = itemNew;
	}
	public Set<ItemOld> getItemOlds() {
		return itemOlds;
	}
	public void setItemOlds(Set<ItemOld> itemOlds) {
		this.itemOlds = itemOlds;
	}
	
}