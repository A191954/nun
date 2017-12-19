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
	//��Ŀ id
	private int id;
	//��Ŀ����
	private String itemName;
	//��Ŀ����
	private String content;
	//��Ŀ����
	private int money;
	//��Ŀ����ʱ��
	private Date publishTime;
	
	//������ һ����Ŀ������ֻ�ܷ���һ������Ŀ
	private Publisher publisher;
	//��Ŀ������  һ����Ŀ���Ա������Ŀ����������
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