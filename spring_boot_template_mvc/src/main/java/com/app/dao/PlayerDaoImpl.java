package com.app.dao;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Player;
import com.app.pojos.Team;
@Repository
public class PlayerDaoImpl implements PlayerDao {
//Dependency: EntityManager
	@Autowired
	private EntityManager mgr;

	@Override
	public String addPlayerInDB(Player p,Team t) {
		// TODO Auto-generated method stub
		t.addPlayer(p);
		return "Player added successfully";
	}

}
