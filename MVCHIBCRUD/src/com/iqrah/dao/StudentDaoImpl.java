package com.iqrah.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.iqrah.dto.Student;
import com.iqrah.util.HibernateUtil;

public class StudentDaoImpl implements IStudentDao{

	Session session = null;
	Transaction transaction = null;
	Student student = null;
	boolean flag = false;
	String status = null;
	
	@Override
	public String save(Student student) {
		try {
			session = HibernateUtil.getSession();
			
			if(session != null) {
				transaction = session.beginTransaction();
			}
			
			if(transaction !=null) {
				student = new Student();
				student.setSname("Nilam");
				student.setSage(14);
				student.setSaddr("Sainthamaruthu");
				
				session.save(student);
				flag = true;
				status = "Success";
			}
			else
				status = "Failure";
			
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		finally {
			if(flag == true) {
				transaction.commit();
			}
			else
				transaction.rollback();
			
			HibernateUtil.closeSession(session);
		}
		return status;
	}

	@Override
	public Student findById(Integer sid) {
	
		try {
			session = HibernateUtil.getSession();
			
			if(session != null) {
				transaction = session.beginTransaction();
			}
			
			if(transaction !=null) {
				Student student = session.get(Student.class, sid);
				if(student!=null)
				{
					flag = true;	
					status = "Success";
				}
				else
					status = "Failure";
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		finally {
			if(flag == true) {
				transaction.commit();
			}
			else
				transaction.rollback();
			HibernateUtil.closeSession(session);
		}
		return student;
	}

	@Override
	public String updateById(Student student) {
		try {
			session = HibernateUtil.getSession();
			
			if(session != null) {
				transaction = session.beginTransaction();
			}
			
			if(transaction !=null) {
				Student oldStd = session.get(Student.class, student.getSid());
				if(oldStd!=null)
				{
					oldStd.setSid(student.getSid());
					oldStd.setSname(student.getSname());
					oldStd.setSage(student.getSage());
					oldStd.setSaddr(student.getSaddr());
					
					session.save(oldStd);
					flag = true;	
					status = "Success";
				}
				else
					status = "Failure";
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		finally {
			if(flag == true) {
				transaction.commit();
			}
			else
				transaction.rollback();
			HibernateUtil.closeSession(session);
		}
		
		return status;
	}

	@Override
	public String deleteById(Integer sid) {
		try {
			session = HibernateUtil.getSession();
			
			if(session != null) {
				transaction = session.beginTransaction();
			}
			
			if(transaction !=null) {
				Student student = session.get(Student.class, sid);
				if(student!=null)
				{
					session.delete(student);
					flag = true;	
					status = "Success";
				}
				else
					status = "Failure";
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		finally {
			if(flag == true) {
				transaction.commit();
			}
			else
				transaction.rollback();
			HibernateUtil.closeSession(session);
		}
		
		return status;
	}
}
