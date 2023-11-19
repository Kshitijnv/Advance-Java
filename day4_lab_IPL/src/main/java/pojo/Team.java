package pojo;

public class Team {
	//team_id | name | abbrevation | owner  | max_age | batting_avg | wickets_taken
	private int teamId;
	private String name;
	private String abbrevation;
	private String owner;
	private int maxAge;
	private double battingAverage;
	private int wicketsTaken;
	public Team(int teamId, String name, String abbrevation, String owner, int maxAge, double battingAverage,
			int wicketsTaken) {
		super();
		this.teamId = teamId;
		this.name = name;
		this.abbrevation = abbrevation;
		this.owner = owner;
		this.maxAge = maxAge;
		this.battingAverage = battingAverage;
		this.wicketsTaken = wicketsTaken;
	}
	public int getTeamId() {
		return teamId;
	}
	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAbbrevation() {
		return abbrevation;
	}
	public void setAbbrevation(String abbrevation) {
		this.abbrevation = abbrevation;
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
	@Override
	public String toString() {
		return "Team [teamId=" + teamId + ", name=" + name + ", abbrevation=" + abbrevation + ", owner=" + owner
				+ ", maxAge=" + maxAge + ", battingAverage=" + battingAverage + ", wicketsTaken=" + wicketsTaken + "]";
	}
	
}
