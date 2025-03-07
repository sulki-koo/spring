package jdbcboard.model;

import java.io.Serializable;

public class ArticleCriteria implements Serializable {
	
	private static final long serialVersionUID = 2389472839478923L;
	
	private String bid;
	private String searchClass;
	private String searchVal;
	
	public ArticleCriteria() {
	}

	public ArticleCriteria(String bid, String searchClass, String searchVal) {
		super();
		this.bid = bid;
		this.searchClass = searchClass;
		this.searchVal = searchVal;
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

	@Override
	public String toString() {
		return "ArticleCriteria [bid=" + bid + ", searchClass=" + searchClass + ", searchVal="
				+ searchVal + "]";
	}
	
}
