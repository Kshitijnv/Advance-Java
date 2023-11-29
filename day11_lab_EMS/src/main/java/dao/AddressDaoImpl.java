package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import pojos.Address;
import pojos.Employee;

import static utils.HibernateUtils.getFactory;

public class AddressDaoImpl implements AddressDao {

	@Override
	public String addEmpAddress(Long empId, Address add) {
		String msg = "Linking Address  to employee failed!!!";
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			Employee emp = session.get(Employee.class, empId);
			if (emp != null) {
				add.setEmp(emp);
				session.persist(add);
				tx.commit();
				msg = "Employee" + emp.getFirstName() + "has Linked its Address successfully!!!";
			}
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		}
		return msg;
	}

}
