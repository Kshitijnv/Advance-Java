package pojo;

import java.time.LocalDate;

public class Player {
//	//player_id     | int         | NO   | PRI | NULL    | auto_increment |
//	| first_name    | varchar(20) | YES  |     | NULL    |                |
//	| last_name     | varchar(20) | YES  |     | NULL    |                |
//	| dob           | date        | YES  |     | NULL    |                |
//	| batting_avg   | double      | YES  |     | NULL    |                |
//	| wickets_taken | int         | YES  |     | NULL    |                |
//	| team_id
	private int playerId;
	private String firstName;
	private String lastName;
	private LocalDate dob;
	private double battingAverage;
	private int wicketsTaken;
	private int teamId;
	public Player(String firstName, String lastName, LocalDate dob, double battingAverage, int wicketsTaken,
			int teamId) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.battingAverage = battingAverage;
		this.wicketsTaken = wicketsTaken;
		this.teamId = teamId;
	}
	public int getPlayerId() {
		return playerId;
	}
	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public double getBattingAverage() {
		return battingAverage;
	}
	public void setBattingAverage(double battingAverage) {
		this.battingAverage = battingAverage;
	}
	public int getWicketsTaken() {
		return wicketsTaken;
	}
	public void setWicketsTaken(int wicketsTaken) {
		this.wicketsTaken = wicketsTaken;
	}
	public int getTeamId() {
		return teamId;
	}
	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}
	@Override
	public String toString() {
		return "Player [playerId=" + playerId + ", firstName=" + firstName + ", lastName=" + lastName + ", dob=" + dob
				+ ", battingAverage=" + battingAverage + ", wicketsTaken=" + wicketsTaken + ", teamId=" + teamId + "]";
	}
	
	
}
