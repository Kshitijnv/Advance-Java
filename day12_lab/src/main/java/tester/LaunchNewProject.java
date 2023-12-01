package tester;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.ProjectDao;
import dao.ProjectDaoImpl;
import pojos.Project;

import static utils.HibernateUtils.getFactory;
public class LaunchNewProject {

	public static void main(String[] args) {
		SessionFactory sf = getFactory();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter project details: title, startDate, endDate");
		Project project = new Project(sc.next(), LocalDate.parse(sc.next()),  LocalDate.parse(sc.next()));
		
		ProjectDao projDao = new ProjectDaoImpl();
		String addproject = projDao.addproject(project);
		System.out.println(addproject);
		sc.close();
		sf.close();
	}

}
