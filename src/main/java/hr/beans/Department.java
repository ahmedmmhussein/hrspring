package hr.beans;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Department implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4316174758430067388L;
	private long departmentId;
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
