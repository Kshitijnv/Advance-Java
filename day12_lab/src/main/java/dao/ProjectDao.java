package dao;

import pojos.Project;

public interface ProjectDao {
	//add a method to launch a project
	String addproject(Project proj);

	String assignEmplToProj(long nextLong, long nextLong2);
}
