package com.iqrah.main;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.iqrah.controller.IStudentController;
import com.iqrah.dto.Student;
import com.iqrah.factory.StudentControllerFactory;

public class TestApp {	

	public static void main(String[] args) {
		
		IStudentController studentController = null;
		String status = null, name =null, address =null;
		Integer age, id = null;
		Student studentRecord = null;
		try {
			while(true)
			{
				//create a bufferedReader object to get input from the user
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				System.out.println("1. CREATE");
				System.out.println("2. READ");
				System.out.println("3. UPDATE");
				System.out.println("4. DELETE");
				System.out.println("5. EXIT");
				System.out.print("Enter your option :: ");
				
				
				//take the input from the user as Integer option
				Integer option = Integer.parseInt(br.readLine());
				studentController = StudentControllerFactory.getStudentController();
				
				switch (option) {
				case 1:
					//create/save operation
					System.out.println("Enter the Name of the Student ;");
					 name = br.readLine();
					
					System.out.println("Enter the Age of the Student ;");
					 age = Integer.parseInt(br.readLine());
					
					System.out.println("Enter the Address of the Student ;");
					 address = br.readLine();
					
					Student student = new Student();
					student.setSname(name);
					student.setSage(age);
					student.setSaddr(address);
					
					status = studentController.save(student);
					if(status.equalsIgnoreCase("success"))
					{
						System.out.println("A new record added succesfully...");
					}
					else if(status.equalsIgnoreCase("failure")){
						System.out.println("Record insertion failed...");
					}
					else {
						System.out.println("Some error occured...");
					}
					
					break;
					
				case 2:
					//read operation
					System.out.println("Enter the ID of the Student ;");
					 id = Integer.parseInt(br.readLine());
					 studentRecord = studentController.findById(id);
					 if(studentRecord !=null)
						 System.out.println(studentRecord);
					 else
						 System.out.println("Record not available for the given ID :"+id);
					break;
					
				case 3:
					//update operation
					System.out.println("Enter the ID of the Student to be updated :");
					 id = Integer.parseInt(br.readLine());
					 studentRecord = studentController.findById(id);
					 Student newStudent = null;
					 if(studentRecord !=null) {
						 newStudent = new Student();
						 newStudent.setSid(id);
						 System.out.println("Student Name : [Old Name is :"+studentRecord.getSname() + "] :");
						 String newName = br.readLine();
						 if(newName ==null ||newName.equals("")) {
							 newStudent.setSname(studentRecord.getSname());
						 }
						 else
							 newStudent.setSname(newName);
						 
						 System.out.println("Student Age : [Old age is :"+studentRecord.getSage() + "] :");
						 Integer newAge = Integer.parseInt(br.readLine());
						 if(newAge ==null ||newAge.equals("")) {
							 newStudent.setSage(studentRecord.getSage());;
						 }
						 else
							 newStudent.setSage(newAge);
						 
						 System.out.println("Student Address : [Old address is :"+studentRecord.getSaddr() + "] :");
						 String newAddr = br.readLine();
						 if(newAddr ==null ||newAddr.equals("")) {
							 newStudent.setSaddr(studentRecord.getSaddr());;
						 }
						 else
							 newStudent.setSaddr(newAddr);
						 status = studentController.updateById(newStudent);
						 if(status.equalsIgnoreCase("success"))
							{
								System.out.println("Record updated succesfully...");
							}
							else if(status.equalsIgnoreCase("failure")){
								System.out.println("Record updation failed...");
							}
							else {
								System.out.println("Some error occured...");
							}
						 
					 }
					 else
						 System.out.println("Record not available for the given ID :"+id);
					break;
				case 4:
					//delete operation
					System.out.println("Enter the ID of the Student ;");
					 id = Integer.parseInt(br.readLine());
					 status = studentController.deleteById(id);
					 					 		
						if (status.equalsIgnoreCase("success"))
						{
							System.out.println("Record deleted succesfully...");
						}
						else if(status.equalsIgnoreCase("failure")){
							System.out.println("Record deletion failed...");
						}
						else {
							System.out.println("Record not available");
						}
					break;
				case 5:
					System.out.println("Thanks for using the application");
					System.exit(0);
					break;

				default:System.out.println("Please enter your option correctly [1,2,3,4,5]");
					break;
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

}
