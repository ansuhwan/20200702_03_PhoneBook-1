package codes.datas;

import java.util.Calendar;

public class User {

	private String name;
	private String phoneNum;
	private int birthYear;
	
	public int getKoreanAge() {
		
		Calendar now = Calendar.getInstance();
		
		return now.get(Calendar.YEAR) - this.birthYear + 1;
		
	}
	
	@Override
	public String toString() {
		return String.format("%s(%d세) : %s", this.name, this.getKoreanAge(), this.phoneNum);  
	}
	
	
	public User(String name, String phoneNum, int birthYear) {
		super();
		this.name = name;
		this.phoneNum = phoneNum;
		this.birthYear = birthYear;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public int getBirthYear() {
		return birthYear;
	}
	public void setBirthYear(int birthYear) {
		this.birthYear = birthYear;
	}
	
	
	
}
