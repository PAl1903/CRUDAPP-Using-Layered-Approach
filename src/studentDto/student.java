package studentDto;

import java.io.Serializable;

public class student implements Serializable{

	private static final long serialVersionUID = 1971408883040833830L;
	
	private Integer sid;
	private String sname;
	private String saddress;
	private Integer sage;
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSaddress() {
		return saddress;
	}
	public void setSaddress(String saddress) {
		this.saddress = saddress;
	}
	public Integer getSage() {
		return sage;
	}
	public void setSage(Integer sage) {
		this.sage = sage;
	}
}
