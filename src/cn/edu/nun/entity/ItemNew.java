package cn.edu.nun.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Newitem entity. @author MyEclipse Persistence Tools
 */

public class  ItemNew implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//项目 id
	private int id;
	//项目名称
	private String itemName;
	//项目内容
	private String content;
	//项目经费
	private int money;
	//项目发布时间
	private Date publishTime;
	
	//发布人 一个项目发布人只能发布一个新项目
	private Publisher publisher;
	//项目申请人  一个项目可以被多个项目申请人申请
	private Set<Applicant> applicants = new HashSet<Applicant>(0);
	public ItemNew() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ItemNew(String itemName, String content, int money, Date publishTime, Publisher publisher,
			Set<Applicant> applicants) {
		super();
		this.itemName = itemName;
		this.content = content;
		this.money = money;
		this.publishTime = publishTime;
		this.publisher = publisher;
		this.applicants = applicants;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public Date getPublishTime() {
		return publishTime;
	}
	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}
	public Publisher getPublisher() {
		return publisher;
	}
	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}
	public Set<Applicant> getApplicants() {
		return applicants;
	}
	public void setApplicants(Set<Applicant> applicants) {
		this.applicants = applicants;
	}

}