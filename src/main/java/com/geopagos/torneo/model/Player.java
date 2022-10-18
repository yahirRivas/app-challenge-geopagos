package com.geopagos.torneo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Player {

	@Id
	private String id;
	private String name;
	private String gender;
	private Integer speed;
	private Integer strength;
	private Integer reactionTime;
	
}
