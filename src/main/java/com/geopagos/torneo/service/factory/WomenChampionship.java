package com.geopagos.torneo.service.factory;

import static com.geopagos.torneo.util.Constants.FINAL;
import static com.geopagos.torneo.util.Constants.MATCH;
import static com.geopagos.torneo.util.Constants.QUARTERFINALS;
import static com.geopagos.torneo.util.Constants.SEMIFINALS;
import static com.geopagos.torneo.util.Constants.WINNER;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.geopagos.torneo.service.dto.PlayerServiceDTO;

public class WomenChampionship implements Championship {

	@Override
	public Map<String, List<Map<String, String>>> run(List<PlayerServiceDTO> players) {

		Map<String, List<Map<String, String>>> result = new HashMap<>();

		Map<PlayerServiceDTO, Map<String, String>> quarterfinals = game(players);	
		result.put(QUARTERFINALS, new ArrayList<>(quarterfinals.values()));
		
		Map<PlayerServiceDTO, Map<String, String>> semifinales = game(quarterfinals.keySet());
		result.put(SEMIFINALS, new ArrayList<>(semifinales.values()));
		
		Map<PlayerServiceDTO, Map<String, String>> finalGame = game(semifinales.keySet());
		result.put(FINAL, new ArrayList<>(finalGame.values()));

		return result;
	}
	
	private Map<PlayerServiceDTO, Map<String, String>> game(Collection<PlayerServiceDTO> players) {

		Map<PlayerServiceDTO, Map<String, String>> matches = new HashMap<>();

		PlayerServiceDTO playerOther = null;

		PlayerServiceDTO[] playersArray = players.toArray(new PlayerServiceDTO[players.size()]);
		
		for (int i = 1; i <= playersArray.length; i++) {
			PlayerServiceDTO player = playersArray[i-1];
			
			if (i % 2 == 0) {
				Map<String, String> match = new HashMap<>();
				match.put(MATCH, String.format("%s vs %s", playerOther.getName(), player.getName()));
				int skillOther = playerOther.getReactionTime();
				int skill = player.getReactionTime();
				
				if(skillOther > skill) {
					match.put(WINNER, playerOther.getName());
					matches.put(playerOther, match);
				} else {
					match.put(WINNER, player.getName());
					matches.put(player, match);
				}
				playerOther = null;
			} else {
				playerOther = player;
			}
		}
		
		return matches;
	}
}
