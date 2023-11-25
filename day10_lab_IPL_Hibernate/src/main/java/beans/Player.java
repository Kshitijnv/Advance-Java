package beans;

import java.time.LocalDate;

import dao.PlayerDaoImple;
import dao.TeamDaoImple;
import pojos.PlayerPojo;

public class Player {
	private PlayerDaoImple pDao; // Dependeny
	private TeamDaoImple tDao;
	private String teamabbreviation;
	private String fname;
	private String lname;
	private String dob;
	private String batAvg;
	private String wicket;

	public Player() {
		super();
		this.pDao = new PlayerDaoImple();
		this.tDao = new TeamDaoImple();
	}

	public String getTeamabbreviation() {
		return teamabbreviation;
	}

	public void setTeamabbreviation(String teamabbreviation) {
		System.out.println("in setter abbre");
		this.teamabbreviation = teamabbreviation;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		System.out.println("in setter fname");
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		System.out.println("in setter lname");
		this.lname = lname;
	}

	public String getBatAvg() {
		return batAvg;
	}

	public void setBatAvg(String batAvg) {
		System.out.println("in setter batavg");
		this.batAvg = batAvg;
	}

	public String getWicket() {
		return wicket;
	}

	public void setWicket(String wicket) {
		System.out.println("in setter wicket");
		this.wicket = wicket;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		System.out.println("in setter dob");
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "Player [pDao=" + pDao + ", teamabbreviation=" + teamabbreviation + ", fname=" + fname + ", lname="
				+ lname + ", dob=" + dob + ", batAvg=" + batAvg + ", wicket=" + wicket + "]";
	}

	// B.L.
	public String addPlayer() {
		PlayerPojo p = new PlayerPojo(fname, lname, LocalDate.parse(dob), Double.parseDouble(batAvg),
				Integer.parseInt(wicket));
		String addedPlayer = pDao.addPlayer(p, teamabbreviation);
		return addedPlayer;
	}
}
