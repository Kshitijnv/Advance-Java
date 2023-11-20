package dao;

import java.sql.SQLException;


import pojo.Team;

public interface TeamDao {
	Team getTeamDetails(String abbrevation) throws SQLException;
	//servlet --dao---pojo---utils
}
