package com.geopagos.torneo.repository.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlayerRepositoryDTO {

	private String name;
	private String gender;
	private Integer speed;
	private Integer strength;
	private Integer reactionTime;
}
