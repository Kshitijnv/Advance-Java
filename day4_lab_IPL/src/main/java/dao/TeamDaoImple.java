package dao;

import static utils.DBUtils.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import pojo.Team;

public class TeamDaoImple implements TeamDao {
	private Connection conn;
	private PreparedStatement pst1;

	public TeamDaoImple() throws SQLException {
		conn = getCn();
		pst1 = conn.prepareStatement("Select * from teams where abbrevation = ?");
		System.out.println("Team Dao Created");
	}

	@Override
	public Team getTeamDetails(String abbrevation) throws SQLException {
		//setting the IN parameter
		pst1.setString(1, abbrevation);

		try (ResultSet rst = pst1.executeQuery()) {
			// team_id | name | abbrevation | owner | max_age | batting_avg | wickets_taken
			if (rst.next()) {

				return new Team(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getInt(5),
						rst.getDouble(6), rst.getInt(7));
			} else
				return null;
		}

	}
	public void cleanup() throws SQLException{
		if(pst1!=null)
			pst1.close();
		System.out.println("Teamdao Cleaned up");
	}

}
