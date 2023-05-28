package com.iqrah.factory;

import com.iqrah.service.IStudentService;
import com.iqrah.service.StudentServiceImpl;

public class StudentServiceFactory {

	private static StudentServiceImpl studentServiceImpl;

	private StudentServiceFactory()
	{
		
	}
	
	public static IStudentService getStudentService()
	{
		if (studentServiceImpl == null) {
			studentServiceImpl = new StudentServiceImpl();			
		}
		return studentServiceImpl;
	}
}
