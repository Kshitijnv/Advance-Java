package tester;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.AadharCardDao;
import pojos.AdhaarCard;

import static utils.HibernateUtils.getFactory;
public class AssignAadhaarCardToEmp {

	public static void main(String[] args) {
		SessionFactory sf = getFactory();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter employee id: ");
		Long id = sc.nextLong();
		System.out.println("Enter aadhar card details: cardNumber, created On date, location ");
		AdhaarCard card = new AdhaarCard(sc.next(), LocalDate.parse(sc.next()), sc.next());
		AadharCardDao card = new AadharCardDaoImpl();
		card.LinkAadharCard(id,card);
		sc.close();
		sf.close();
	}

}
