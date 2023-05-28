package com.iqrah.dao;

import com.iqrah.dto.Student;

public interface IStudentDao {
	String save(Student student); // creating a record

	Student findById(Integer sid); // reading a record

	String updateById(Student student); // Updating a record

	String deleteById(Integer sid); // Deleting a record
}
