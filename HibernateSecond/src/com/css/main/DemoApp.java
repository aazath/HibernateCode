package com.css.main;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.css.Model.Employee;
import com.css.Util.HibernateUtil;

public class DemoApp {

	public static void main(String[] args) {
		Session session = null;
		Transaction transaction = null;
		boolean flag = false;

		try {
			session = HibernateUtil.getSession();

			if (session != null)
				transaction = session.beginTransaction();

			if (transaction != null) {
				Employee employee = new Employee();
				employee.setEmpId(10);
				employee.setEmpName("sachin");
				employee.setEmpSal(4534.5);

				session.save(employee);
				flag = true;
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			if(flag == true)
				transaction.commit();
			else
				transaction.rollback();
			
			HibernateUtil.closeSession(session);
		}

	}

}
