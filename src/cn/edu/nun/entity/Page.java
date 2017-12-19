package cn.edu.nun.entity;

import java.io.Serializable;
import java.util.List;

import cn.edu.nun.tools.Constant;

public class Page <T> implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2994689119465313614L;
	//总记录数
	private int totalRecords;
	//每页显示多少记录
	private int pageSize;
	//总页数
	private int totalPages;
	//当前页
	private int currentPage;
	//首页
	private int firstPage;
	//尾页
	private int lastPage;
	//要显示的数据
	private List<T> datalist;
	//是否有上一页(hasPrePage)  
    private boolean hasPrePage;  
    //是否有下一页(hasNextPage)  
    private boolean hasNextPage;
    //前一页
    private int prePage;
	//后一页
    private int nextPage;
    //从第几页开始    默认第一页开始
    private int startPage = Constant.startPage;
    //从第几页结束
    private int endPage = Constant.endPage;
    //显示几页
    private int showTotalpages = Constant.showTotalpages;
    
	public Page() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Page(int totalRecords, int pageSize, int currentPage, List<T> datalist) {
		super();
		//总记录
		this.totalRecords = totalRecords;
		//每页显示多少条记录
		this.pageSize = pageSize;
		//计算总页数
		this.totalPages = (this.totalRecords % this.pageSize == 0) ? this.totalRecords/this.pageSize : this.totalRecords/this.pageSize + 1;
		//计算当前页
		this.currentPage = (currentPage <= 0 || currentPage > totalPages)? 1 : currentPage;
		//设置首页为1
		this.firstPage = 1;
		//设置尾页
		this.lastPage = this.totalPages;
		//设置结果集
		this.datalist = datalist;
		//设置是否有上一页
		this.hasPrePage = this.currentPage == 1 ? false : true;
		//设置是否有下一页
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
		//总记录
		this.totalRecords = totalRecords;
		//每页显示多少条记录
		this.pageSize = pageSize;
		//计算总页数
		this.totalPages = (this.totalRecords % this.pageSize == 0) ? this.totalRecords/this.pageSize : this.totalRecords/this.pageSize + 1;
		//计算当前页
		this.currentPage = (currentPage <= 0 || currentPage > totalPages)? 1 : currentPage;
		//设置首页为1
		this.firstPage = 1;
		//设置尾页
		this.lastPage = this.totalPages;
		//设置结果集
		this.datalist = datalist;
		//设置是否有上一页
		this.hasPrePage = this.currentPage == 1 ? false : true;
		//设置是否有下一页
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
