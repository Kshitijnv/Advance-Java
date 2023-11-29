package tester;

import static utils.HibernateUtils.getFactory;

import java.util.List;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.AddressDao;
import dao.AddressDaoImpl;

public class DisplayLastNameOfAllEmpByCity {

	public static void main(String[] args) {
		SessionFactory sf = getFactory();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the city name : ");
		AddressDao dao = new AddressDaoImpl();
		List<String> emps = dao.displayLastName(sc.next());
		for (String e : emps)
			System.out.println(e);
		sc.close();
		sf.close();
	}

}
