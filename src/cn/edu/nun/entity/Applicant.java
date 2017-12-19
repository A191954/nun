package cn.edu.nun.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Applicant entity. @author MyEclipse Persistence Tools
 */

public class Applicant implements java.io.Serializable {

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
	//��ʷ��Ŀ����
	private Integer historyItemCount;
	//�Ƿ�����������Ŀ
	private boolean isRequest;
	
	//���������Ŀ���Ƿ������
	private boolean isChecked;
	//�������, ���״̬(���)
	private String checkedState; //ͨ��   ��ͨ��
	//ûͨ����ԭ��
	private String noPassReason; //��ͨ����ԭ��
	//��Ŀ������ľ���
	private int usedMoney;
	//ʣ�ྭ���ʽ�
	private int remainMoney;
	//���������Ŀ�Ƿ�ɹ�����
	private boolean isSucessEnd;
	//�����µ���Ŀ ֻ������һ��
	private ItemNew itemNew;
	//����� һ����Ŀ�����˶�Ӧһ����Ŀ�����
	private Checkor checkor;
	//��ʷ�������Ŀ
	private Set<ItemOld> itemOlds = new HashSet<ItemOld>(0);
	//ӵ�ж����Ա
	private Set<Menber> menbers = new HashSet<Menber>();
	//��Ŀ��
	private AppBook appBook;
	public Applicant() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Applicant(Integer id, String username, String password, String brief, String usertype, String name,
			Integer age, String telephone, String email, Integer historyItemCount, boolean isRequest, boolean isChecked,
			String checkedState, String noPassReason, int usedMoney, int remainMoney, boolean isSucessEnd,
			ItemNew itemNew, Checkor checkor, Set<ItemOld> itemOlds, Set<Menber> menbers, AppBook appBook) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.brief = brief;
		this.usertype = usertype;
		this.name = name;
		this.age = age;
		this.telephone = telephone;
		this.email = email;
		this.historyItemCount = historyItemCount;
		this.isRequest = isRequest;
		this.isChecked = isChecked;
		this.checkedState = checkedState;
		this.noPassReason = noPassReason;
		this.usedMoney = usedMoney;
		this.remainMoney = remainMoney;
		this.isSucessEnd = isSucessEnd;
		this.itemNew = itemNew;
		this.checkor = checkor;
		this.itemOlds = itemOlds;
		this.menbers = menbers;
		this.appBook = appBook;
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
	public Integer getHistoryItemCount() {
		return historyItemCount;
	}
	public void setHistoryItemCount(Integer historyItemCount) {
		this.historyItemCount = historyItemCount;
	}
	public boolean isRequest() {
		return isRequest;
	}
	public void setRequest(boolean isRequest) {
		this.isRequest = isRequest;
	}
	public boolean isChecked() {
		return isChecked;
	}
	public void setChecked(boolean isChecked) {
		this.isChecked = isChecked;
	}
	public String getCheckedState() {
		return checkedState;
	}
	public void setCheckedState(String checkedState) {
		this.checkedState = checkedState;
	}
	public String getNoPassReason() {
		return noPassReason;
	}
	public void setNoPassReason(String noPassReason) {
		this.noPassReason = noPassReason;
	}
	public int getUsedMoney() {
		return usedMoney;
	}
	public void setUsedMoney(int usedMoney) {
		this.usedMoney = usedMoney;
	}
	public int getRemainMoney() {
		return remainMoney;
	}
	public void setRemainMoney(int remainMoney) {
		this.remainMoney = remainMoney;
	}
	public boolean isSucessEnd() {
		return isSucessEnd;
	}
	public void setSucessEnd(boolean isSucessEnd) {
		this.isSucessEnd = isSucessEnd;
	}
	public ItemNew getItemNew() {
		return itemNew;
	}
	public void setItemNew(ItemNew itemNew) {
		this.itemNew = itemNew;
	}
	public Checkor getCheckor() {
		return checkor;
	}
	public void setCheckor(Checkor checkor) {
		this.checkor = checkor;
	}
	public Set<ItemOld> getItemOlds() {
		return itemOlds;
	}
	public void setItemOlds(Set<ItemOld> itemOlds) {
		this.itemOlds = itemOlds;
	}
	public Set<Menber> getMenbers() {
		return menbers;
	}
	public void setMenbers(Set<Menber> menbers) {
		this.menbers = menbers;
	}
	public AppBook getAppBook() {
		return appBook;
	}
	public void setAppBook(AppBook appBook) {
		this.appBook = appBook;
	}
	
}