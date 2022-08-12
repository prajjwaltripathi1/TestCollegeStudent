package com.mindtree.Collegeapplication.VO;

public class Student {
	
	private long id;
	private String stream;
	private String name;
	private String gender;
	private int age ;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getStream() {
		return stream;
	}
	public void setStream(String stream) {
		this.stream = stream;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Student(long id, String stream, String name, String gender, int age) {
		super();
		this.id = id;
		this.stream = stream;
		this.name = name;
		this.gender = gender;
		this.age = age;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
