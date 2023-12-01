package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.PlayerDao;
import com.app.dao.TeamDao;
import com.app.pojos.Player;
import com.app.pojos.Team;

@Service
@Transactional
public class PlayerServiceImpl implements PlayerService {
//dependency: playerDao i/f
	@Autowired
	private PlayerDao playerDao;
	@Autowired
	private TeamDao teamDao;

	@Override
	public String addPlayerToTeam(Player player, String abbreviation) {
		Team team = teamDao.getTeam(abbreviation);
		player.setMyTeam(team);
		String result = playerDao.addPlayerInDB(player, team);
		return result;
	}

}
