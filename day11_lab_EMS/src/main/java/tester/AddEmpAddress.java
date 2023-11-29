package tester;

import static utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.AddressDao;
import dao.AddressDaoImpl;
import pojos.Address;

public class AddEmpAddress {

	public static void main(String[] args) {
		SessionFactory sf = getFactory();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Employee id: ");
		Long id = sc.nextLong();
		System.out.println("Enter Address details: lane1, lane2, city, country, state, pincode");
		Address add = new Address(sc.next(), sc.next(), sc.next(), sc.next(), sc.next(), sc.nextInt());
		AddressDao dao = new AddressDaoImpl();
		String result = dao.addEmpAddress(id, add);
		System.out.println(result);
		sc.close();
		sf.close();
		
	}

}
