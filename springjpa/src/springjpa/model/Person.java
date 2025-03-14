package springjpa.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Person")
public class Person implements Serializable{

	private static final long serialVersionUID = 1236554321364321L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int pid;

	@Column(name = "pname")
	private String pname;

	@Column(name = "page")
	private int page;

	@Temporal(TemporalType.DATE)
	@Column(name = "pregdate")
	private Date pregdate;

	public Person() {
	}

	public Person(int pid, String pname, int page, Date pregdate) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.page = page;
		this.pregdate = pregdate;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public Date getPregdate() {
		return pregdate;
	}

	public void setPregdate(Date pregdate) {
		this.pregdate = pregdate;
	}

	@Override
	public String toString() {
		return "Person [pid=" + pid + ", pname=" + pname + ", page=" + page + ", pregdate=" + pregdate + "]";
	}

}
