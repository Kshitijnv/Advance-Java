package dao;

import static utils.DBUtils.*;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import pojo.Team;

public class PlayerDaoImple implements PlayerDao {
	private Connection conn;
	private PreparedStatement pst1;

	public PlayerDaoImple() throws SQLException {
		conn = getCn();
		pst1 = conn.prepareStatement("insert into players values(default,?,?,?,?,?,?)");
		System.out.println("player Dao Created");
	}

	@Override
	public void addPlayer(Team team, String firstName, String lastName, Date dob, double battingAverage,
			int wicketsTaken) throws SQLException {
		System.out.println("in playerDAO imple");
		pst1.setString(1, firstName);
		pst1.setString(2, lastName);
		pst1.setDate(3, dob);
		pst1.setDouble(4, battingAverage);
		pst1.setInt(5, wicketsTaken);
		pst1.setInt(6, team.getTeamId());

		pst1.executeUpdate();

	}
	public void cleanup() throws SQLException{
		if(pst1!=null)
			pst1.close();
		System.out.println("PlayerDao Cleaned up");
	}

}
