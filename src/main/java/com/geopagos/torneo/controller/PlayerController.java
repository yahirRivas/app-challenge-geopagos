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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(Constants.URL_BASE_PLAYER)
@Tag(name = "Player", description = "Player API")
public class PlayerController {

	@Autowired
	private PlayerService playerService;
	
	@Autowired
	private PlayerMapper playerMapper;
	
	@Operation(summary = "List players")
    @ApiResponses(value = {
    			@ApiResponse(responseCode = "200", content = { 
    	                @Content(mediaType = "application/json", 
    	                		array = @ArraySchema(schema = @Schema(implementation = PlayerResponse.class)),
    	                		examples = @ExampleObject(value = "[{\"id\":\"1\",\"name\":\"Carlos Alcaraz\",\"gender\":\"M\",\"speed\":90,\"strength\":80,\"reactionTime\":0},{\"id\":\"14\",\"name\":\"Anett Kontaveit\",\"gender\":\"F\",\"speed\":0,\"strength\":0,\"reactionTime\":76}, ... ]" ))
    	        })	
    	    }
    )
	@GetMapping
	public List<PlayerResponse> list(
			@Parameter(example = "F | M", required = false)
			@RequestParam(value = "gender", required = false)
										String gender) {
		log.info("call service list()");

		return playerMapper.serviceDtosToReponseDtos(playerService.findPlayersByGender(gender));
	}
}
