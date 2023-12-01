package com.app.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.pojos.Player;
import com.app.service.PlayerService;

@Controller
@RequestMapping("/players")
public class PlayerController {
	// dependency: playerService i/f
	@Autowired
	private PlayerService playerService;

	public PlayerController() {
		// TODO Auto-generated constructor stub
		System.out.println("in player controller CTOR");
	}

	@PostMapping("/add")
	public String addPlayer(@RequestParam String myTeam, @RequestParam String fn, @RequestParam String ln,
			@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dob, @RequestParam double avg,
			@RequestParam int wickets, Model map) {

		System.out.println("in method:add player controller");
		Player p = new Player(fn, ln, dob, avg, wickets);
		String addPlayerToTeam = playerService.addPlayerToTeam(p, myTeam);
		map.addAttribute("playerAdded", addPlayerToTeam);
		return "/players/display";
	}
}
