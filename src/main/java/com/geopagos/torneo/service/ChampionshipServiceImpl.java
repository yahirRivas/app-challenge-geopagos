package com.geopagos.torneo.service;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geopagos.torneo.service.dto.PlayerServiceDTO;

@Service
public class ChampionshipServiceImpl implements ChampionshipService {

	@Autowired
	private PlayerService playerService;
	
	@Override
	public Map<String, List<Map<String, String>>> simulate(String gender, boolean showDetails) {
		
		List<PlayerServiceDTO> players = playerService.findAllPlayers();

		Collections.shuffle(players);

		Map<String, List<PlayerServiceDTO>> groupByGender = players.stream()
		.collect(Collectors.groupingBy(PlayerServiceDTO::getGender, 
				Collectors.toList()));
		
		List<PlayerServiceDTO> playersByGender = groupByGender.get(gender);
		if (playersByGender == null) {
			return Collections.emptyMap();
		}

		Map<String, List<Map<String, String>>> championship = ChampionshipType.getChampionship(gender).run(playersByGender);

		if(!showDetails && !championship.isEmpty()) {
			List<Map<String, String>> finalResult = championship.get("Final");
			championship.clear();
			championship.put("Champion", finalResult);
		}
		
		return championship;
	}
}
