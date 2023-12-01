package com.app.dao;

import com.app.pojos.Player;
import com.app.pojos.Team;

public interface PlayerDao {
	String addPlayerInDB(Player p,Team t);
}
