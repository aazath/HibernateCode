package com.iqrah.factory;

import com.iqrah.controller.IStudentController;
import com.iqrah.controller.StudentControllerImpl;

public class StudentControllerFactory {

	private static StudentControllerImpl studentController =null;

	private StudentControllerFactory() {
		
	}
	
	public static IStudentController getStudentController() {
		if(studentController == null)
			studentController = new StudentControllerImpl();
		
		return studentController;
	}
}
