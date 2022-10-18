package com.geopagos.torneo.service;

import java.util.List;
import java.util.Map;

import com.geopagos.torneo.service.dto.PlayerServiceDTO;

public interface Championship {

	public Map<String, List<Map<String, String>>> run(List<PlayerServiceDTO> players);
}
