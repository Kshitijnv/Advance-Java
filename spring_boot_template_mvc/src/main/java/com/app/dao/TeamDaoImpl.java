package com.app.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Team;

@Repository
public class TeamDaoImpl implements TeamDao {

	@Autowired
	private EntityManager mgr;

	@Override
	public List<String> getTeamAbbreviation() {
		System.out.println("in dao impl");
		String jpql = "select t.abbreviation from Team t";
		return mgr.createQuery(jpql, String.class).getResultList();
	}

	@Override
	public Team getTeam(String abbreviation) {
		String jpql = "select t from Team t where t.abbreviation=:abbr";
		return mgr.createQuery(jpql, Team.class)
				.setParameter("abbr", abbreviation)
				.getSingleResult();
	}

}
