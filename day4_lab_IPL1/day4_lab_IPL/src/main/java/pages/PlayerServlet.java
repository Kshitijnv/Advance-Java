package pages;

import static utils.DBUtils.closeConnection;
import static utils.DBUtils.openConnection;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PlayerDaoImple;
import dao.TeamDaoImple;
import pojo.Team;

/**
 * Servlet implementation class PlayerServlet
 */
@WebServlet("/AddPlayerFormServlet")
public class PlayerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TeamDaoImple dao;
	private PlayerDaoImple pdao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PlayerServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init() throws ServletException {
		System.out.println("in init " + getClass());

		try {
			openConnection();
			dao = new TeamDaoImple();
			pdao = new PlayerDaoImple();
		} catch (SQLException e) {
			throw new ServletException("Exception in " + getClass(), e);
		}
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("in destroy " + getClass());
		try {
			dao.cleanup();
			pdao.cleanup();
			closeConnection();
		} catch (SQLException e) {
			throw new RuntimeException("Error in destroy of " + getClass(), e);
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		String abbr = request.getParameter("abbreviation");
		String firstName = request.getParameter("fname");
		String lastName = request.getParameter("lname");

		String date = request.getParameter("dob");
		int age = Period.between(LocalDate.parse(date), LocalDate.now()).getYears();
		Date sqlDate = Date.valueOf(date);

		String batAvg = request.getParameter("batAvg");
		double avg = Double.parseDouble(batAvg);

		String wic = request.getParameter("wicket");
		int wicket = Integer.parseInt(wic);

		try (PrintWriter pw = response.getWriter()) {
			// TeamDaoImple Method call to get the details from DB
			Team team = dao.getTeamDetails(abbr);

			if (team != null) {
				if (age > team.getMaxAge()) {
					pw.print("<h3>Rejected, Age Must be less than or equal to " + team.getMaxAge() + "</h3>");
					return;
				}
				if (avg < team.getBattingAverage()) {
					pw.print("<h3>Rejected,Batting Average must be greator than or equal to " + team.getBattingAverage()
							+ "</h3>");
					return;
				}
				if (wicket < team.getWicketsTaken()) {
					pw.print("<h3>Rejected,Wicket must be taken " + team.getWicketsTaken() + "</h3>");
					return;
				}
				pw.print("Player Accepted!!!");

				pdao.addPlayer(abbr, firstName, lastName, sqlDate, avg, wicket);
			} else {
				pw.print("<h4>No IPL team Found!!!!</h4>");
			}

			dao.getTeamDetails(abbr);
		} catch (Exception e) {
			throw new RuntimeException("error" + getClass());
		}
	}

}
