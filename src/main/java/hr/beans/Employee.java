package hr.beans;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.validator.constraints.Email;

public class Employee {
	private int id;
	@NotNull
	@Size(min = 2, max = 20, message = "{name.size}")
	private String name;
	@NotNull
	private int age;
	@NotNull
	@Size(min = 4, max = 20, message = "{salary.size}")
	private long salary;
	@NotNull
	@Size(min = 4, max = 20, message = "{jobTitle.size}")
	private String jobTitle;
	@NotNull
	@Past(message = "{dataofBirth.date}")
	private Date dataofBirth;
	@NotNull
	private String department;
	@NotNull
	@Email(message = "{email.valid}")
	private String email;

	public Employee(String name2, String email2, String jobTitle2, Long salary2, String department2, int age,
			Date dataofBirth) {
		name = name2;
		email = email2;
		salary = salary2;
		jobTitle = jobTitle2;
		department = department2;
		this.age = age;
		this.dataofBirth = dataofBirth;
	}

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
