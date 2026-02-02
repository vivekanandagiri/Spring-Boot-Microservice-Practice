package com.example.Exception;

public class EmployeeNotFoundException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EmployeeNotFoundException(Long id) {
		super("Employee Not found with this id"+id);
	}

}
