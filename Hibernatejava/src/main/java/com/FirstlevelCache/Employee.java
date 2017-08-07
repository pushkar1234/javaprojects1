package com.FirstlevelCache;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name="Emp_table")
@Cacheable
@Cache(usage =CacheConcurrencyStrategy.READ_ONLY)
public class Employee {
	@Id
	@GeneratedValue
	@Column
	private int EmpId;
	@Column(name="emp_name")
	private String Emp_name;
	@Column(name="emp_salary")
	private int salary;
	
	public int getEmpId() {
		return EmpId;
	}
	public void setEmpId(int empId) {
		EmpId = empId;
	}
	public String getEmp_name() {
		return Emp_name;
	}
	public void setEmp_name(String emp_name) {
		Emp_name = emp_name;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [EmpId=" + EmpId + ", Emp_name=" + Emp_name + ", salary=" + salary + "]";
	}
	

}
