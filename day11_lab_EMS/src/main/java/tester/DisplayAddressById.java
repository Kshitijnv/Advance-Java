package tester;

import static utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.AddressDao;
import dao.AddressDaoImpl;

public class DisplayAddressById {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory sf = getFactory();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter employee id: ");
		AddressDao dao = new AddressDaoImpl();
		String result = dao.displayDetails(sc.nextLong());
		System.out.println(result);
		sc.close();
		sf.close();
	}

}
