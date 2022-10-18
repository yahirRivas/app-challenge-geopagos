package com.geopagos.torneo.service;

import java.util.List;

import com.geopagos.torneo.service.dto.PlayerServiceDTO;

public interface PlayerService {

	List<PlayerServiceDTO> findPlayersByGender(String gender);
	List<PlayerServiceDTO> findAllPlayers();
}
