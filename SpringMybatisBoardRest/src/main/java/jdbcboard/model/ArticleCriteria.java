package jdbcboard.model;

import java.io.Serializable;

public class ArticleCriteria implements Serializable {

	private static final long serialVersionUID = 2389472839478923L;

	private String bid;
	private String searchClass;
	private String searchVal;
	private int endRow;
	private int startRow;
	private int pageNum;
	private int pageSize;
	private int totalRowCount;
	private int totalPageCount;

	public ArticleCriteria() {
	}

	public ArticleCriteria(String bid, String searchClass, String searchVal, int endRow, int startRow, int pageNum,
			int pageSize, int totalRowCount, int totalPageCount) {
		super();
		this.bid = bid;
		this.searchClass = searchClass;
		this.searchVal = searchVal;
		this.endRow = endRow;
		this.startRow = startRow;
		this.pageNum = pageNum;
		this.pageSize = pageSize;
		this.totalRowCount = totalRowCount;
		this.totalPageCount = totalPageCount;
	}

	public String getBid() {
		return bid;
	}

	public void setBid(String bid) {
		this.bid = bid;
	}

	public String getSearchClass() {
		return searchClass;
	}

	public void setSearchClass(String searchClass) {
		this.searchClass = searchClass;
	}

	public String getSearchVal() {
		return searchVal;
	}

	public void setSearchVal(String searchVal) {
		this.searchVal = searchVal;
	}

	public int getEndRow() {
		return endRow;
	}

	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}

	public int getStartRow() {
		return startRow;
	}

	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalRowCount() {
		return totalRowCount;
	}

	public void setTotalRowCount(int totalRowCount) {
		this.totalRowCount = totalRowCount;
	}

	public int getTotalPageCount() {
		return totalPageCount;
	}

	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}

	@Override
	public String toString() {
		return "ArticleCriteria [bid=" + bid + ", searchClass=" + searchClass + ", searchVal=" + searchVal + ", endRow="
				+ endRow + ", startRow=" + startRow + ", pageNum=" + pageNum + ", pageSize=" + pageSize
				+ ", totalRowCount=" + totalRowCount + ", totalPageCount=" + totalPageCount + "]";
	}

}