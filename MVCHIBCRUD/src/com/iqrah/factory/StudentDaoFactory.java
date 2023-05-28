package com.iqrah.factory;

import com.iqrah.dao.IStudentDao;
import com.iqrah.dao.StudentDaoImpl;

public class StudentDaoFactory {
	static IStudentDao studentDao = null;
	
	private StudentDaoFactory(){
		
	}
	
	public static IStudentDao getStudentDao() {
		if(studentDao == null)
			studentDao = new StudentDaoImpl();
		
		return studentDao;
	}

}
