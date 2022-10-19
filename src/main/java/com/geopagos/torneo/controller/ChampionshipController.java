package com.geopagos.torneo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.geopagos.torneo.service.ChampionshipService;
import com.geopagos.torneo.util.Constants;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(Constants.URL_BASE_CHAMPIONSHIP)
@Tag(name = "Championship", description = "Championship API")
public class ChampionshipController {

	@Autowired
	private ChampionshipService championshipService;
	
	@Operation(summary = "Simulate")
    @ApiResponses(value = {
    			@ApiResponse(responseCode = "200", content = { 
    	                @Content(mediaType = "application/json", 
    	                		schema = @Schema(implementation = HashMap.class),
    	                		examples = @ExampleObject(value = "{\"Quarterfinals\":[{\"Match\":\"Rafael Nadal vs Casper Ruud\",\"Winner\":\"Rafael Nadal\"}, ... ],\"Semifinals\":[{\"Match\":\"Rafael Nadal vs Novak Djokovic\",\"Winner\":\"Rafael Nadal\"}, ...],\"Final\":[{\"Match\":\"Rafael Nadal vs Carlos Alcaraz\",\"Winner\":\"Carlos Alcaraz\"}]}" ))
    	        })	
    	    }
    )
	@GetMapping
	public Map<String, List<Map<String, String>>> simulate(
										@Parameter(example = "F | M", required = false)
										@RequestParam(value = "gender", required = false, defaultValue = "M") String gender) {
		log.info("call service simulate()");
		return championshipService.simulate(gender);
	}
	
	@Operation(summary = "Get winner")
    @ApiResponses(value = {
			@ApiResponse(responseCode = "200", content = { 
	                @Content(mediaType = "application/json", 
	                		schema = @Schema(implementation = HashMap.class),
	                		examples = @ExampleObject(value = "{\"Winner\":\"Carlos Alcaraz\"}" ))
	        })	
	    }
    )
	@GetMapping("/winner")
	public Map<String, String> getWinner(
			@Parameter(example = "F | M", required = false)
			@RequestParam(value = "gender", required = false, defaultValue = "M") String gender){
		log.info("call service getWinner()");
		return championshipService.getWinner(gender);
	}
	
}
