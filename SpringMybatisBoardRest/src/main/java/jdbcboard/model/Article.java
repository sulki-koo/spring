package jdbcboard.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class Article implements Serializable {
	
	private static final long serialVersionUID = 29348729343289438L;
	
	private int aid;
	private String asubject;
	private String acontent;
	private int avcnt;
	private Timestamp aregdate;
	private String adelyn;
	private int aafcnt;
	private int arcnt;
	private int bid;
	private String mid;
	private String bname;
	
	public Article() {
	}

	public Article(int aid, String asubject, String acontent, int avcnt, Timestamp aregdate, String adelyn, int aafcnt,
			int arcnt, int bid, String mid, String bname) {
		super();
		this.aid = aid;
		this.asubject = asubject;
		this.acontent = acontent;
		this.avcnt = avcnt;
		this.aregdate = aregdate;
		this.adelyn = adelyn;
		this.aafcnt = aafcnt;
		this.arcnt = arcnt;
		this.bid = bid;
		this.mid = mid;
		this.bname = bname;
	}

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public String getAsubject() {
		return asubject;
	}

	public void setAsubject(String asubject) {
		this.asubject = asubject;
	}

	public String getAcontent() {
		return acontent;
	}

	public void setAcontent(String acontent) {
		this.acontent = acontent;
	}

	public int getAvcnt() {
		return avcnt;
	}

	public void setAvcnt(int avcnt) {
		this.avcnt = avcnt;
	}

	public Timestamp getAregdate() {
		return aregdate;
	}

	public void setAregdate(Timestamp aregdate) {
		this.aregdate = aregdate;
	}

	public String getAdelyn() {
		return adelyn;
	}

	public void setAdelyn(String adelyn) {
		this.adelyn = adelyn;
	}

	public int getAafcnt() {
		return aafcnt;
	}

	public void setAafcnt(int aafcnt) {
		this.aafcnt = aafcnt;
	}

	public int getArcnt() {
		return arcnt;
	}

	public void setArcnt(int arcnt) {
		this.arcnt = arcnt;
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}
	
	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	@Override
	public String toString() {
		return "Article [aid=" + aid + ", asubject=" + asubject + ", acontent=" + acontent + ", avcnt=" + avcnt
				+ ", aregdate=" + aregdate + ", adelyn=" + adelyn + ", aafcnt=" + aafcnt + ", arcnt=" + arcnt + ", bid="
				+ bid + ", mid=" + mid + ", bname=" + bname + "]";
	}

}
