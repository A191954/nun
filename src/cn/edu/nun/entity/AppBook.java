package cn.edu.nun.entity;

import java.sql.Clob;

public class AppBook implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5441869730065027137L;
	private int id;
	private Clob textBody;
	//��Ӧ һ����Ŀ������ һ��һ
	private Applicant applicant;
	public AppBook() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Clob getTextBody() {
		return textBody;
	}
	public void setTextBody(Clob textBody) {
		this.textBody = textBody;
	}
	public Applicant getApplicant() {
		return applicant;
	}
	public void setApplicant(Applicant applicant) {
		this.applicant = applicant;
	}
	
	
}
