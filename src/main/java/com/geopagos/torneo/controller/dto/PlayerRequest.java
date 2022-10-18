package com.geopagos.torneo.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlayerRequest {
	
	private String name;
	private String gender;
	private Integer speed;
	private Integer strength;
	private Integer reactionTime;
}
