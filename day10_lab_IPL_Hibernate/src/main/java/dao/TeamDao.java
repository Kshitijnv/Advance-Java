package dao;

import java.util.List;

import pojos.Team;

public interface TeamDao {
	//add a method to get abbrevation
	List<Team> getAbrevation();
	//add a method to get team details
	Team getTeamDetails(String abbrevation) ;
	//servlet --dao---pojo---utils
}
