package tester;

import static utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.ProjectDao;
import dao.ProjectDaoImpl;
import pojos.Employee;
public class AssignExistingEmpToProject {

	public static void main(String[] args) {
		SessionFactory sf = getFactory();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the employee id & project id");
		
		ProjectDao projDao = new ProjectDaoImpl();
		 Employee result = projDao.assignEmplToProj(sc.nextLong(),sc.nextLong());
		System.out.println(result);
		sc.close();
		sf.close();

	}

}
