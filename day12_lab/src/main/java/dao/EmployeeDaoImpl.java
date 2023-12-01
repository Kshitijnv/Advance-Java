package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import static utils.HibernateUtils.getFactory;

import pojos.Department;
import pojos.Employee;

public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public String addEmployeeInDept(Employee emp, Long deptId) {
		String msg = "Employee adding failed";
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		String jpql = "select d from Department d where d.id=:departId";
		try {
			Department result = session.createQuery(jpql, Department.class).setParameter("departId", deptId)
					.getSingleResult();
			// Invoking helper method of Deparment class
			result.addEmployee(emp);
			// insert the employee in Db and make persistent
			session.persist(emp);
			tx.commit();
			msg = "Employee adding successfull";
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return msg;
	}

}
