package jdbcboard.model;

import java.io.Serializable;

public class Member implements Serializable {
	
	private static final long serialVersionUID = 32894783927489234L;
	
	private String mid;
	private String mname;
	private String malias;
	private String mpass;
	private String memail;
	private String mcp;
	private String mdelyn;
	
	public Member() {
	}

	public Member(String mid, String mname, String mpass, String malias, String memail, String mcp, String mdelyn) {
		super();
		this.mid = mid;
		this.mname = mname;
		this.mpass = mpass;
		this.malias = malias;
		this.memail = memail;
		this.mcp = mcp;
		this.mdelyn = mdelyn;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getMalias() {
		return malias;
	}

	public void setMalias(String malias) {
		this.malias = malias;
	}

	public String getMpass() {
		return mpass;
	}

	public void setMpass(String mpass) {
		this.mpass = mpass;
	}

	public String getMemail() {
		return memail;
	}

	public void setMemail(String memail) {
		this.memail = memail;
	}

	public String getMcp() {
		return mcp;
	}

	public void setMcp(String mcp) {
		this.mcp = mcp;
	}

	public String getMdelyn() {
		return mdelyn;
	}

	public void setMdelyn(String mdelyn) {
		this.mdelyn = mdelyn;
	}

	@Override
	public String toString() {
		return "Member [mid=" + mid + ", mname=" + mname + ", malias=" + malias + ", mpass=" + mpass + ", memail="
				+ memail + ", mcp=" + mcp + ", mdelyn=" + mdelyn + "]";
	}

}
