package com.capg.empapp.dao;

import com.capg.empapp.dto.Employee;
import com.capg.empapp.exception.InvalidEmployeeIdException;
import com.capg.empapp.exception.WrongSalaryException;

public interface IEmployeeDAO {
	
	 public boolean addEmployee(Employee e) throws WrongSalaryException;
	 
	 public boolean editSalaryByEmployeeId(Employee e)throws InvalidEmployeeIdException, WrongSalaryException;
	 
	 public Employee[] getAllEmployees();
	 
	 public Employee[] getEmployeeBySalary(int salary);
	 
	 public Employee[] getEmployessBySalaryRange(int salaryRangeMin,int salaryRangeMax);

}