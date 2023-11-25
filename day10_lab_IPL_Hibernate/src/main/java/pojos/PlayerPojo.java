package pojos;

import java.time.LocalDate;
import javax.persistence.*;
@Entity
@Table(name="player_tbl")
public class PlayerPojo extends BaseEntity {
//	//player_id     | int         | NO   | PRI | NULL    | auto_increment |
//	| first_name    | varchar(20) | YES  |     | NULL    |                |
//	| last_name     | varchar(20) | YES  |     | NULL    |                |
//	| dob           | date        | YES  |     | NULL    |                |
//	| batting_avg   | double      | YES  |     | NULL    |                |
//	| wickets_taken | int         | YES  |     | NULL    |                |
//	| team_id
	@Column(name="first_name",length=20)
	private String firstName;
	@Column(name="last_name",length=20)
	private String lastName;
	@Column(name="Date_of_birth")
	private LocalDate dob;
	@Column(name="batting_avg")
	private double battingAverage;
	@Column(name="wickets_taken")
	private int wicketsTaken;
	@ManyToOne
	@JoinColumn(name="Owning_team")
	private Team myTeam;

	public PlayerPojo() {
		// TODO Auto-generated constructor stub
	}
	public PlayerPojo(String firstName, String lastName, LocalDate dob, double battingAverage, int wicketsTaken) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.battingAverage = battingAverage;
		this.wicketsTaken = wicketsTaken;
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
	public Team getMyTeam() {
		return myTeam;
	}
	public void setMyTeam(Team myTeam) {
		this.myTeam = myTeam;
	}
	@Override
	public String toString() {
		return "Player [firstName=" + firstName + ", lastName=" + lastName + ", dob=" + dob + ", battingAverage="
				+ battingAverage + ", wicketsTaken=" + wicketsTaken + ", myTeam=" + myTeam + "]";
	}
	
}
