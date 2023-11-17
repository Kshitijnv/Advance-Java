package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.jni.Local;

import dao.UserDaoImpl;
import pojos.User;

/**
 * Servlet implementation class RegisterPage
 */
@WebServlet("/signup")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDaoImpl userDao;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init() throws ServletException {
		// create dao instance
		try {
			userDao = new UserDaoImpl();
		} catch (SQLException e) {
			throw new ServletException("error in init" + getClass(), e);
		}
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("in destroy of " + getClass());
		try {
			userDao.cleanUp();
		} catch (Exception e) {
			// inform WC about the err : OPTIONAL !
			throw new RuntimeException("err in destroy of " + getClass(), e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. set resp cont type
		response.setContentType("text/html");

		try (PrintWriter pw = response.getWriter()) {
			// String firstName, String lastName, String email, Date dob
			String firstName = request.getParameter("fname");
			String lastName = request.getParameter("lname");
			String email = request.getParameter("em");

			String pass = request.getParameter("pass");
			String date = request.getParameter("dob");
			LocalDate dob1 = LocalDate.parse(date);
			int years = Period.between(dob1, LocalDate.now()).getYears();
			Date dob = Date.valueOf(date);

			if (userDao.validateEmail(email))
				pw.print("<h3>Email is already registered</h3>");
			else if (years < 21)
				pw.print("<h4>Age MUST be 21 </h4>");
			else {
				String message = userDao.registerNewVoter(new User(firstName, lastName, email, pass, dob));
				response.sendRedirect("candidate_list");
			}
		} catch (Exception e) {
			throw new RuntimeException("err in destroy of " + getClass(), e);
		}
	}

}
