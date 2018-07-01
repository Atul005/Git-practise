package pojoStudent;

public class Subject {
	
	private String subName;
	private String subTeacher;
	private int subId;
	
	public String getSubName() {
		return subName;
	}
	public void setSubName(String subName) {
		this.subName = subName;
	}
	public String getSubTeacher() {
		return subTeacher;
	}
	public void setSubTeacher(String subTeacher) {
		this.subTeacher = subTeacher;
	}
	public int getSubId() {
		return subId;
	}
	public void setSubId(int subId) {
		this.subId = subId;
	}
	
	public Subject(String subName, String subTeacher, int subId) {
		super();
		this.subName = subName;
		this.subTeacher = subTeacher;
		this.subId = subId;
	}
	
	public Subject() {
		super();
	}
	@Override
	public String toString() {
		return "Subject [subName=" + subName + ", subTeacher=" + subTeacher + ", subId=" + subId + "]";
	}
	
}
