package tester;

import java.util.Scanner;
import static utils.HibernateUtils.getFactory;
import org.hibernate.SessionFactory;

public class RemoveEmpFromDept {

	public static void main(String[] args) {
		try(Scanner sc=new Scanner(System.in);SessionFactory sf=getFactory())
		{
			System.out.println();
		}catch(Exception e)
		{
			e.printStackTrace();
		}

	}

}
