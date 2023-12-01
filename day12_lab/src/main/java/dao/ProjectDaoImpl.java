package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import pojos.Employee;
import pojos.Project;
import static utils.HibernateUtils.getFactory;
public class ProjectDaoImpl implements ProjectDao {

	@Override
	public String addproject(Project proj) {
		String msg="Project added failed";
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.save(proj);
			tx.commit();
			msg="Project added successfully";
		}catch(RuntimeException e) {
			if(tx!=null)
				tx.rollback();
			e.printStackTrace();
		}
		return msg;
	}

	@Override
	public Employee assignEmplToProj(long empId, long projId) {
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		Employee employee = null;
		try {
			 employee = session.get(Employee.class, empId);
			if(employee!=null) {
				Project project = session.get(Project.class, projId);
				if(project!=null)
					project.addEmployee(employee);
			}
			tx.commit();
		}catch(RuntimeException e) {
			if(tx!=null)
				tx.rollback();
			e.printStackTrace();
		}
		return employee;
		
	}

}
