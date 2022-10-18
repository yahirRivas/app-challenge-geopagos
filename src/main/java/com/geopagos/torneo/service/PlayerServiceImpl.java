package com.geopagos.torneo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import com.geopagos.torneo.dto.mapper.PlayerMapper;
import com.geopagos.torneo.repository.PlayerRepository;
import com.geopagos.torneo.service.dto.PlayerServiceDTO;

@Service
public class PlayerServiceImpl implements PlayerService {

	@Autowired
	private PlayerRepository playerRepository;
	
	@Autowired
	private PlayerMapper playerMapper;
	

	@Override
	public List<PlayerServiceDTO> findPlayersByGender(String gender) {
		
		return Optional.ofNullable(gender)
				.filter(StringUtils::hasLength)
				.map(gp -> playerMapper.modelsToDtos(playerRepository.findByGender(gp.toUpperCase())))
				.orElseGet(this::findAllPlayers);
	}

	@Override
	public List<PlayerServiceDTO> findAllPlayers() {
		return playerMapper.modelsToDtos(playerRepository.findAll());
	}
}
