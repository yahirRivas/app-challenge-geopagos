package com.geopagos.torneo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.geopagos.torneo.controller.dto.PlayerResponse;
import com.geopagos.torneo.dto.mapper.PlayerMapper;
import com.geopagos.torneo.service.PlayerService;
import com.geopagos.torneo.util.Constants;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(Constants.URL_BASE_PLAYER)
public class PlayerController {

	@Autowired
	private PlayerService playerService;
	
	@Autowired
	private PlayerMapper playerMapper;
	
	
	@GetMapping
	public List<PlayerResponse> list(@RequestParam(value = "gender", required = false)
										String gender) {
		log.info("call service list()");

		return playerMapper.serviceDtosToReponseDtos(playerService.findPlayersByGender(gender));
	}
}
