package dao;

import pojos.Employee;
import pojos.Project;

public interface ProjectDao {
	//add a method to launch a project
	String addproject(Project proj);

	Employee assignEmplToProj(long nextLong, long nextLong2);
}
