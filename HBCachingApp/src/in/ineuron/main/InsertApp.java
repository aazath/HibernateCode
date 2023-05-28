package in.ineuron.main;

import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.Model.InsurancePolicy;
import in.ineuron.util.HibernateUtil;

public class InsertApp {

	public static void main(String[] args) {

		Session session = null;
		Transaction transaction = null;
		boolean flag = false;
		InsurancePolicy policy;

		session = HibernateUtil.getSession();

		
		
		try {
			policy = new InsurancePolicy();
			policy.setCompany("AIA");
			policy.setPolicyName("Motor Insurance");
			policy.setPolicyType("Yearly");
			policy.setTenure(12);
			transaction = session.beginTransaction();
			session.save(policy);
			flag = true;

		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		} finally {
			if (flag) {
				transaction.commit();
			} else {
//				transaction.rollback();
			}
			HibernateUtil.closeSession(session);
		}
	}
}
