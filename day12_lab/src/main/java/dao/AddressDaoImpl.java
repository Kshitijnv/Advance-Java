package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import pojos.Address;
import pojos.Employee;

import static utils.HibernateUtils.getFactory;

import java.util.ArrayList;
import java.util.List;

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

	@Override
	public String displayDetails(long id) {
		String msg = "No address link to the employee ";
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		Address add = null;
		try {
			Employee e = session.get(Employee.class, id);
			if (e != null) {
				add = session.get(Address.class, id);
				if (add != null)
					msg = add.toString();
			} else
				msg = "No Employee id Found";
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		}
		return msg;
	}

	@Override
	public List<String> displayLastName(String city) {
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		List<String> resultList = new ArrayList<>();
		String jpql = "SELECT e.lastName FROM Employee e WHERE e.id IN (SELECT a.id FROM Address a WHERE a.city = :specifiedCity )";
		try {
			 resultList = session.createQuery(jpql, String.class).setParameter("specifiedCity", city)
					.getResultList();
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		}
		return resultList;
	}

}
