package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.service.TeamService;

@Controller
public class TeamController {
	@Autowired
	private TeamService teamService;
	


	public TeamController() {
		// TODO Auto-generated constructor stub
		System.out.println("in team controller CTOR");
	}

	@RequestMapping("/")
	public String getTeamAbb(Model m) {
		System.out.println("in method ..Team abbre");
		m.addAttribute("teams_abbr", teamService.getTeamsAbbreviation());
		return "/teams/add_player_form";
	}
}
