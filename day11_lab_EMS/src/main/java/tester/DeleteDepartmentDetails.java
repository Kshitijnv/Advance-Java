package tester;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.DepartmentDao;
import dao.DepartmentDaoImpl;
import static utils.HibernateUtils.getFactory;
public class DeleteDepartmentDetails {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory sf = getFactory();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter department name: ");
		DepartmentDao dao = new DepartmentDaoImpl();
		String result = dao.deleteDepartmentDetails(sc.next());
		System.out.println(result);
		sc.close();
		sf.close();
	}

}
