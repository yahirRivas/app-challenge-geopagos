package com.geopagos.torneo.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlayerServiceDTO {

	private String id;
	private String name;
	private String gender;
	private Integer speed;
	private Integer strength;
	private Integer reactionTime;
}
