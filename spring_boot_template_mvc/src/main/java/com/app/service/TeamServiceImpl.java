package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.TeamDao;

@Service
@Transactional
public class TeamServiceImpl implements TeamService {
	@Autowired
	private TeamDao teamDao;

	public TeamServiceImpl() {
		// TODO Auto-generated constructor stub
		System.out.println("in ctor team service impls");
	}

	@Override
	public List<String> getTeamsAbbreviation() {
		System.out.println("in team dao method");
		return teamDao.getTeamAbbreviation();
	}

}
