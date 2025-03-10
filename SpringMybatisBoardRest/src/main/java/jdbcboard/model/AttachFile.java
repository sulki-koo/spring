package jdbcboard.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class AttachFile implements Serializable {

	private static final long serialVersionUID = 1321346546854621L;

	private int afid;
	private String afcname;
	private String afsname;
	private Timestamp afregdate;
	private int aid;

	public AttachFile() {
	}

	public AttachFile(int afid, String afcname, String afsname, Timestamp afregdate, int aid) {
		super();
		this.afid = afid;
		this.afcname = afcname;
		this.afsname = afsname;
		this.afregdate = afregdate;
		this.aid = aid;
	}

	public int getAfid() {
		return afid;
	}

	public void setAfid(int afid) {
		this.afid = afid;
	}

	public String getAfcname() {
		return afcname;
	}

	public void setAfcname(String afcname) {
		this.afcname = afcname;
	}

	public String getAfsname() {
		return afsname;
	}

	public void setAfsname(String afsname) {
		this.afsname = afsname;
	}

	public Timestamp getAfregdate() {
		return afregdate;
	}

	public void setAfregdate(Timestamp afregdate) {
		this.afregdate = afregdate;
	}

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	@Override
	public String toString() {
		return "Attachfile [afid=" + afid + ", afcname=" + afcname + ", afsname=" + afsname + ", afregdate=" + afregdate
				+ ", aid=" + aid + "]";
	}

}
