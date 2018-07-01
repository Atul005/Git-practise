package pojoStudent;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
public class Student {
	
	private String name;
	private int age;
	private int className;
	private int id;
	private int roll;
	List<Subject> subjects;
	
	public Student() {
		super();
	}
	
	public List<Subject> getSubjects() {
		return subjects;
	}

	@XmlElement
	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}

	public Student(String name, int age, int className, int id, int roll, List<Subject> subjects) {
		super();
		this.name = name;
		this.age = age;
		this.className = className;
		this.id = id;
		this.roll = roll;
		this.subjects = subjects;
	}
	
	public String getName() {
		return name;
	}
	
	@XmlElement
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	
	@XmlTransient
	public void setAge(int age) {
		this.age = age;
	}
	public int getClassName() {
		return className;
	}
	
	@XmlElement
	public void setClassName(int className) {
		this.className = className;
	}
	public int getId() {
		return id;
	}
	
	@XmlElement
	public void setId(int id) {
		this.id = id;
	}
	public int getRoll() {
		return roll;
	}
	
	@XmlAttribute
	public void setRoll(int roll) {
		this.roll = roll;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", className=" + className + ", id=" + id + ", roll=" + roll
				+ ", subjects=" + subjects + "]";
	}

}
