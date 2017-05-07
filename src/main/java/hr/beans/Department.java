package hr.beans;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Entity
public class Department implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4316174758430067388L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "departmentId")
	private long departmentId;
	@Column(name = "departmentName")
	private String departmentName;

	@Override
	public boolean equals(Object that) {
		return EqualsBuilder.reflectionEquals(this, that, "departmentId", "departmentName");
	}

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this, "departmentId", "departmentName");
	}

	@Override
	public String toString() {
		return departmentName;
	}

	public long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(long departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
}
