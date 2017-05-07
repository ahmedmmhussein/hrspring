package hr.beans;

import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.validator.constraints.Email;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Employee")

public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@NotNull
	@Size(min = 2, max = 20, message = "{name.size}")
	@Column(name = "name")
	private String name;
	@Transient
	private int age;
	@Column(name = "salary")
	private long salary;
	@NotNull
	@Size(min = 4, max = 20, message = "{jobTitle.size}")
	@Column(name = "jobTitle")
	private String jobTitle;
	@NotNull
	@Past(message = "{dataofBirth.date}")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "dataofBirth")
	private Date dataofBirth;
	@ManyToOne
	@JoinColumn(name = "departmentId")
	private Department department;
	@NotNull
	@Email(message = "{email.valid}")
	@Column(name = "email")
	private String email;
	@Transient
	private long departmentId;

	public Employee() {
		super();
	}

	public Employee(int id, String name2, String email2, String jobTitle2, Long salary2, Department department2,
			Date dataofBirth) {
		this.id = id;
		name = name2;
		email = email2;
		salary = salary2;
		jobTitle = jobTitle2;
		department = department2;
		this.dataofBirth = dataofBirth;
		LocalDate today = LocalDate.now();
		Period p = Period.between(LocalDate.parse(dataofBirth.toString()), today);
		age = p.getYears();
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

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setDepartmentId(long departmentId) {
		this.department = new Department();
		this.department.setDepartmentId(departmentId);
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
