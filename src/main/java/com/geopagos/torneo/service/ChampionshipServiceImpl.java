package com.geopagos.torneo.service;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geopagos.torneo.service.dto.PlayerServiceDTO;
import com.geopagos.torneo.service.factory.ChampionshipType;
import static com.geopagos.torneo.util.Constants.FINAL;
import static com.geopagos.torneo.util.Constants.WINNER;

@Service
public class ChampionshipServiceImpl implements ChampionshipService {

	@Autowired
	private PlayerService playerService;
	
	@Override
	public Map<String, List<Map<String, String>>> simulate(String gender) {
		
		List<PlayerServiceDTO> players = playerService.findAllPlayers();

		Collections.shuffle(players);

		Map<String, List<PlayerServiceDTO>> groupByGender = players.stream()
		.collect(Collectors.groupingBy(PlayerServiceDTO::getGender, 
				Collectors.toList()));
		
		List<PlayerServiceDTO> playersByGender = groupByGender.get(gender);
		
		if (playersByGender == null) {
			return Collections.emptyMap();
		}

		return ChampionshipType.getChampionship(gender).run(playersByGender);
	}

	@Override
	public Map<String, String> getWinner(String gender) {
		
		Map<String, String> winnerMap = new HashMap<>();
		Map<String, List<Map<String, String>>> championshipSimulate = simulate(gender);
		
		if(!championshipSimulate.isEmpty()) {
			List<Map<String, String>> finalResult = championshipSimulate.get(FINAL);
	
			String winner = finalResult.get(0).get(WINNER);
			
			winnerMap.put(WINNER, winner);
		}

		return winnerMap;
	}
}
