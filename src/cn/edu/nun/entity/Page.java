package cn.edu.nun.entity;

import java.io.Serializable;
import java.util.List;

import cn.edu.nun.tools.Constant;

public class Page <T> implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2994689119465313614L;
	//�ܼ�¼��
	private int totalRecords;
	//ÿҳ��ʾ���ټ�¼
	private int pageSize;
	//��ҳ��
	private int totalPages;
	//��ǰҳ
	private int currentPage;
	//��ҳ
	private int firstPage;
	//βҳ
	private int lastPage;
	//Ҫ��ʾ������
	private List<T> datalist;
	//�Ƿ�����һҳ(hasPrePage)  
    private boolean hasPrePage;  
    //�Ƿ�����һҳ(hasNextPage)  
    private boolean hasNextPage;
    //ǰһҳ
    private int prePage;
	//��һҳ
    private int nextPage;
    //�ӵڼ�ҳ��ʼ    Ĭ�ϵ�һҳ��ʼ
    private int startPage = Constant.startPage;
    //�ӵڼ�ҳ����
    private int endPage = Constant.endPage;
    //��ʾ��ҳ
    private int showTotalpages = Constant.showTotalpages;
    
	public Page() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Page(int totalRecords, int pageSize, int currentPage, List<T> datalist) {
		super();
		//�ܼ�¼
		this.totalRecords = totalRecords;
		//ÿҳ��ʾ��������¼
		this.pageSize = pageSize;
		//������ҳ��
		this.totalPages = (this.totalRecords % this.pageSize == 0) ? this.totalRecords/this.pageSize : this.totalRecords/this.pageSize + 1;
		//���㵱ǰҳ
		this.currentPage = (currentPage <= 0 || currentPage > totalPages)? 1 : currentPage;
		//������ҳΪ1
		this.firstPage = 1;
		//����βҳ
		this.lastPage = this.totalPages;
		//���ý����
		this.datalist = datalist;
		//�����Ƿ�����һҳ
		this.hasPrePage = this.currentPage == 1 ? false : true;
		//�����Ƿ�����һҳ
		this.hasNextPage = this.currentPage == this.totalPages || this.totalPages == 0 ? false : true;
		if(this.hasPrePage){
			this.prePage = this.currentPage - 1;
		}
		if(this.hasNextPage){
			this.nextPage = this.currentPage + 1;
		}
	}

	

	public Page(int totalRecords, int pageSize, int currentPage, List<T> datalist, int startPage, int endPage) {
		super();
		//�ܼ�¼
		this.totalRecords = totalRecords;
		//ÿҳ��ʾ��������¼
		this.pageSize = pageSize;
		//������ҳ��
		this.totalPages = (this.totalRecords % this.pageSize == 0) ? this.totalRecords/this.pageSize : this.totalRecords/this.pageSize + 1;
		//���㵱ǰҳ
		this.currentPage = (currentPage <= 0 || currentPage > totalPages)? 1 : currentPage;
		//������ҳΪ1
		this.firstPage = 1;
		//����βҳ
		this.lastPage = this.totalPages;
		//���ý����
		this.datalist = datalist;
		//�����Ƿ�����һҳ
		this.hasPrePage = this.currentPage == 1 ? false : true;
		//�����Ƿ�����һҳ
		this.hasNextPage = this.currentPage == this.totalPages || this.totalPages == 0 ? false : true;
		if(this.hasPrePage){
			this.prePage = this.currentPage - 1;
		}
		if(this.hasNextPage){
			this.nextPage = this.currentPage + 1;
		}
		
		this.showTotalpages = Constant.showTotalpages;
		
//		this.startPage = (this.totalPages >= 1 && startPage >= 1 && startPage <= this.totalPages) ? startPage : 1;
//		this.endPage = (this.totalPages >= 1 && endPage >= 1 && endPage <= this.totalPages && endPage >= startPage) ? endPage : this.totalPages;
		this.startPage = this.currentPage;
		this.endPage = ((this.currentPage + this.pageSize) <= this.totalPages)?(this.currentPage + this.pageSize):this.totalPages;
		this.startPage = (this.totalPages >= 1) ? this.startPage : 0;
		this.endPage = (this.totalPages >= 1)? this.endPage : 0;
		this.showTotalpages = this.endPage - this.startPage;
		
		
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getShowTotalpages() {
		return showTotalpages;
	}

	public void setShowTotalpages(int showTotalpages) {
		this.showTotalpages = showTotalpages;
	}

	public int getTotalRecords() {
		return totalRecords;
	}

	public void setTotalRecords(int totalRecords) {
		this.totalRecords = totalRecords;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getFirstPage() {
		return firstPage;
	}

	public void setFirstPage(int firstPage) {
		this.firstPage = firstPage;
	}

	public int getLastPage() {
		return lastPage;
	}

	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}

	public List<T> getDatalist() {
		return datalist;
	}

	public void setDatalist(List<T> datalist) {
		this.datalist = datalist;
	}

	public boolean isHasPrePage() {
		return hasPrePage;
	}

	public void setHasPrePage(boolean hasPrePage) {
		this.hasPrePage = hasPrePage;
	}

	public boolean isHasNextPage() {
		return hasNextPage;
	}

	public void setHasNextPage(boolean hasNextPage) {
		this.hasNextPage = hasNextPage;
	}

	public int getPrePage() {
		return prePage;
	}

	public void setPrePage(int prePage) {
		this.prePage = prePage;
	}

	public int getNextPage() {
		return nextPage;
	}

	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}

	
	
}
