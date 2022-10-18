package com.geopagos.torneo.service;

import java.util.List;
import java.util.Map;

public interface ChampionshipService {

	Map<String, List<Map<String, String>>> simulate(String gender, boolean showDetails);
}
