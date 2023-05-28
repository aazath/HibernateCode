package com.iqrah.controller;

import com.iqrah.dto.Student;

public interface IStudentController {
	String save(Student student); // creating a record

	Student findById(Integer sid); // reading a record

	String updateById(Student student); // Updating a record

	String deleteById(Integer sid); // Deleting a record

}
