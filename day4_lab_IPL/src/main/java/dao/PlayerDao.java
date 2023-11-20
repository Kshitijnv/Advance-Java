package dao;

import java.sql.Date;
import java.sql.SQLException;

import pojo.Team;

public interface PlayerDao {
	void addPlayer(Team team, String firstName, String lastName, Date dob, double battingAverage, int wicketsTaken) throws SQLException;
}
