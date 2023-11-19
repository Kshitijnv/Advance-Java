package dao;

import java.sql.Date;
import java.sql.SQLException;

public interface PlayerDao {
	void addPlayer(String abbreviation, String firstName, String lastName, Date dob, double battingAverage, int wicketsTaken) throws SQLException;
}
