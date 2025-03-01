package jdbcboard.model;

import java.io.Serializable;

public class Board implements Serializable {

	private static final long serialVersionUID = 3429572389487223L;

	private int bid;
	private String bname;
	private int bacnt;

	public Board() {
	}

	public Board(int bid, String bname, int bacnt) {
		super();
		this.bid = bid;
		this.bname = bname;
		this.bacnt = bacnt;
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public int getBacnt() {
		return bacnt;
	}

	public void setBacnt(int bacnt) {
		this.bacnt = bacnt;
	}

	@Override
	public String toString() {
		return "Board [bid=" + bid + ", bname=" + bname + ", bacnt=" + bacnt + "]";
	}

}
