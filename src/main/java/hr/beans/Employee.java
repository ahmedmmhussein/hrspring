package hr.beans;

import java.util.Date;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Employee {
	private int id;
	private String name;
	private int age;
	private long salary;
	private String jobTitle;
	private Date dataofBirth;
	private String department;
	private String email;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public Date getDataofBirth() {
		return dataofBirth;
	}

	public void setDataofBirth(Date dataofBirth) {
		this.dataofBirth = dataofBirth;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	  @Override
	  public boolean equals(Object that) {
		return EqualsBuilder.reflectionEquals(this, that, "id", "dataofBirth");
	  }
	  
	  @Override
	  public int hashCode() {
	    return HashCodeBuilder.reflectionHashCode(this, "id", "dataofBirth");
	  }
	  

}
