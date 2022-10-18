package com.geopagos.torneo.dto.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.geopagos.torneo.controller.dto.PlayerResponse;
import com.geopagos.torneo.model.Player;
import com.geopagos.torneo.service.dto.PlayerServiceDTO;

@Mapper(componentModel = "spring")
public interface PlayerMapper {
	
	PlayerMapper INSTANCE = Mappers.getMapper(PlayerMapper.class);
	
	List<PlayerServiceDTO> modelsToDtos(List<Player> players);
	
	List<PlayerResponse> serviceDtosToReponseDtos(List<PlayerServiceDTO> players);
}
