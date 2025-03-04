package jdbcboard.model;

import java.io.Serializable;

public class ArticleCriteria implements Serializable {
	
	private static final long serialVersionUID = 2389472839478923L;
	
	private String searchBoard;
	private String searchClass;
	private String searchVal;
	
	public ArticleCriteria() {
	}

	public ArticleCriteria(String searchBoard, String searchClass, String searchVal) {
		super();
		this.searchBoard = searchBoard;
		this.searchClass = searchClass;
		this.searchVal = searchVal;
	}

	public String getSearchBoard() {
		return searchBoard;
	}

	public void setSearchBoard(String searchBoard) {
		this.searchBoard = searchBoard;
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
		return "ArticleCriteria [searchBoard=" + searchBoard + ", searchClass=" + searchClass + ", searchVal="
				+ searchVal + "]";
	}
	
}
