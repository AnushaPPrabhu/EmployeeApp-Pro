package com.capg.empapp.exception;

import java.util.*;

public class InvalidEmployeeIdException extends Exception{

	private int empId;

	public InvalidEmployeeIdException(int empId) {
		super();
		this.empId = empId;
	}

	@Override
	public String toString() {
		return "InvalidEmployeeIdException [empId=" + empId + "]";
	}
	
	

	
}
