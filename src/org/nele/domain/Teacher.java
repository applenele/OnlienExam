package org.nele.domain;

public class Teacher {
    private long tid;
    private String tuserName;
    private  String tpassword;
    private String email;
    private int majorId;
	public int getMajorId() {
		return majorId;
	}
	public void setMajorId(int majorId) {
		this.majorId = majorId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getTid() {
		return tid;
	}
	public void setTid(long tid) {
		this.tid = tid;
	}
	public String getTuserName() {
		return tuserName;
	}
	public void setTuserName(String tuserName) {
		this.tuserName = tuserName;
	}
	public String getTpassword() {
		return tpassword;
	}
	public void setTpassword(String tpassword) {
		this.tpassword = tpassword;
	}
}
