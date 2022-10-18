package com.geopagos.torneo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.geopagos.torneo.service.ChampionshipService;
import com.geopagos.torneo.util.Constants;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(Constants.URL_BASE_CHAMPIONSHIP)
public class ChampionshipController {

	@Autowired
	private ChampionshipService championshipService;
	
	@GetMapping
	public Map<String, List<Map<String, String>>> simulate(@RequestParam(value = "gender", required = false, defaultValue = "M") String gender,
										@RequestParam(value = "showDetails", required = false, defaultValue = "false") String showDetails) {
		log.info("call service simulate()");
		return championshipService.simulate(gender);
	}
	
	@GetMapping("/winner")
	public Map<String, String> getWinner(@RequestParam(value = "gender", required = false, defaultValue = "M") String gender){
		log.info("call service getWinner()");
		return championshipService.getWinner(gender);
	}
	
}
