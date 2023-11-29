package dao;

import pojos.Department;
import pojos.Employee;

import static utils.HibernateUtils.getFactory;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class DepartmentDaoImpl implements DepartmentDao {

	@Override
	public String addDepartmentInDb(Department dept) {
		String msg = "Department adding failed!!!";
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.persist(dept);
			tx.commit();
			msg = "Department adding successfull";
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return msg;
	}

	@Override
	public Department getDepartmentDetailsById(long id) {
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		Department department;
		try {
			department = session.load(Department.class, id);
//			department.getDeptName();
			if (department != null)
				tx.commit();

		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}

		return department;
	}

	@Override
	public String deleteDepartmentDetails(String deptName) {
		String msg = "Department deletion failed!!!";
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		String jpql = "select d from Department d where d.deptName =:dept";
		try {
			Department result = session.createQuery(jpql, Department.class).setParameter("dept", deptName)
					.getSingleResult();
			session.delete(result);
			msg = "department delete successfully!!" + result.getDeptName() + " ";
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		}
		return msg;
	}

	@Override
	public Department displayDepartmentDetailswithEmployee(String deptName) {
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
//		String jpql = "select d from Department d where d.deptName =:dept"; ---Occurs LAZY initialize exc
		String jpql = "select d from Department d where d.deptName =:dept";
		Department result = null;
		try {
			result = session.createQuery(jpql, Department.class).setParameter("dept", deptName).getSingleResult();
			result.getEmployees().size();
			session.persist(result);
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Department displayDepartmentDetailswithEmployeeWithJoin(String deptName) {
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		String jpql = "select d from Department d left join fetch d.employees where d.deptName =:dept ";
		Department result = null;
		try {
			result = session.createQuery(jpql, Department.class).setParameter("dept", deptName).getSingleResult();
			result.getEmployees().size();
			session.persist(result);
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public String addDepartmentWithEmp(Department dept, Employee[] emp) {
		String msg = "Department added failed!!!";
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			for (int i = 0; i < emp.length; i++) {
				dept.addEmployee(emp[i]);
			}
			session.persist(dept);
			tx.commit();
			msg = "department added successfully!!";
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		}
		return msg;
	}

}
