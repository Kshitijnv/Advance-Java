package pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/*
 * team_id | name| abbrevation | owner  | max_age | batting_avg | wickets_taken
 */
@Entity // mandatory cls level annotation , to tell hibernate ,
//following is the entity
		// class , whose life cycle to be managed by hibernate
@Table(name="teams_tbl")
public class Team {
	@Id //mandatory anno , to place PK constraint
	//for auto id generation , using auto increment constraint
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="team_id")
	private Integer teamId;// as per the founder(Gavin King) , till hib 5 , use id prop : explicitly
							// serializable
	private String name;
	private String abbreviation;
	private String owner;
	private int maxAge;
	private double minBattingAvg;
	private int minWicketsTaken;
	@OneToMany(mappedBy = "myTeam")
	private List<PlayerPojo>players =new ArrayList<>();
	public Team() {
		// TODO Auto-generated constructor stub
	}

	public Team(String name, String abbreviation, String owner, int maxAge, double minBattingAvg,
			int minWicketsTaken) {
		super();		
		this.name = name;
		this.abbreviation = abbreviation;
		this.owner = owner;
		this.maxAge = maxAge;
		this.minBattingAvg = minBattingAvg;
		this.minWicketsTaken = minWicketsTaken;
	}

	public Team(double minBattingAvg, int minWicketsTaken) {
		super();
		this.minBattingAvg = minBattingAvg;
		this.minWicketsTaken = minWicketsTaken;
	}

	public Team(String teamabbreviation) {
		this.abbreviation = teamabbreviation;
	}

	public Integer getTeamId() {
		return teamId;
	}

	public void setTeamId(Integer teamId) {
		this.teamId = teamId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAbbreviation() {
		return abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public int getMaxAge() {
		return maxAge;
	}

	public void setMaxAge(int maxAge) {
		this.maxAge = maxAge;
	}

	public double getMinBattingAvg() {
		return minBattingAvg;
	}

	public void setMinBattingAvg(double minBattingAvg) {
		this.minBattingAvg = minBattingAvg;
	}

	public int getMinWicketsTaken() {
		return minWicketsTaken;
	}

	public void setMinWicketsTaken(int minWicketsTaken) {
		this.minWicketsTaken = minWicketsTaken;
	}

	@Override
	public String toString() {
		return "Team [teamId=" + teamId + ", name=" + name + ", abbreviation=" + abbreviation + ", owner=" + owner
				+ ", maxAge=" + maxAge + ", minBattingAvg=" + minBattingAvg + ", minWicketsTaken=" + minWicketsTaken
				+ "]";
	}
	//add helper method to establish a bi dir asso between entities
		public void addPlayer(PlayerPojo player) {
			players.add(player);//Team->player
			player.setMyTeam(this);//player->Team
		}
	//add helper method to De-link a bi dir asso between entities
		public void removerPlayer(PlayerPojo player) {
			players.remove(player);//Team->player
			player.setMyTeam(null);//player->Team
		}
}
