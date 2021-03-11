package com.capg.empapp.dao;

import com.capg.empapp.db.EmployeeDB;
import com.capg.empapp.dto.Employee;
import com.capg.empapp.exception.InvalidEmployeeIdException;
import com.capg.empapp.exception.WrongSalaryException;

public class EmployeeDAOImpl implements IEmployeeDAO {

	public boolean addEmployee(Employee e) throws WrongSalaryException{
         
		return EmployeeDB.addEmployee(e);
	}

	public Employee[] getAllEmployees() {

		return EmployeeDB.employees;
	}
	
	
	public boolean editSalaryByEmployeeId(Employee e) throws InvalidEmployeeIdException, WrongSalaryException {
		
		return EmployeeDB.editEmployee(e);
	}

	public Employee[] getEmployessBySalaryRange(int salaryRangeMin, int salaryRangeMax) {
		return EmployeeDB.employees;
	}

	public Employee[] getEmployeeBySalary(int salary) {
		return EmployeeDB.employees;
	}

}