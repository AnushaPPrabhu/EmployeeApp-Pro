package com.capg.empapp.service;

import com.capg.empapp.dao.EmployeeDAOImpl;
import com.capg.empapp.dao.IEmployeeDAO;
import com.capg.empapp.db.EmployeeDB;
import com.capg.empapp.dto.Employee;
import com.capg.empapp.exception.InvalidEmployeeIdException;
import com.capg.empapp.exception.WrongSalaryException;

public class EmployeeServiceImpl implements IEmployeeService {
  
	IEmployeeDAO dao;

	public EmployeeServiceImpl() {
		dao = new EmployeeDAOImpl();
	}

	public boolean addEmployee(Employee e) throws WrongSalaryException {
		
		
			if(e.getSalary()> 50000)
			{
				throw new WrongSalaryException(e.getSalary());
			}
			else if(e.getExp()<3 && e.getSalary()>10000) {
				throw new WrongSalaryException(e.getSalary());
			}
			else return dao.addEmployee(e);		
		
	}

	public Employee[] getAllEmployees() {

		return dao.getAllEmployees();
	}
	
	

	public boolean editSalaryByEmployeeId(Employee e) throws InvalidEmployeeIdException, WrongSalaryException {

		if(e.getSalary()> 50000)
		{
			throw new WrongSalaryException(e.getSalary());
		}
		else if(e.getExp()<3 && e.getSalary()>10000) {
			throw new WrongSalaryException(e.getSalary());
		}
		else return dao.editSalaryByEmployeeId(e);	
		
	}

	public Employee[] getEmployeeBySalary(int salary) {
		return dao.getEmployeeBySalary(salary);
	}

	public Employee[] getEmployessBySalaryRange(int salaryRangeMin, int salaryRangeMax) {
		return dao.getEmployessBySalaryRange(salaryRangeMin, salaryRangeMax);
	}

}