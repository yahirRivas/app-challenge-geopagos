package com.geopagos.torneo.service.factory;

import java.util.Collections;
import java.util.stream.Stream;

public enum ChampionshipType {

	WOMEN("F") {
		@Override
		public Championship championship() {
			return new WomenChampionship();
		}
	},
	MEN("M") {
		@Override
		public Championship championship() {
			return new MenChampionship();
		}
	},
	DEAFULT("") {
		@Override
		public Championship championship() {
			return c -> Collections.emptyMap();
		}
	};
	
   public abstract Championship championship();
   private String gender;
   
   private ChampionshipType(String gender) { 
	   this.gender = gender;
   }
   
   public static Championship getChampionship(String gender) {
	 return Stream.of(values()).filter(val -> val.getGender().equalsIgnoreCase(gender))
			 .findFirst()
			 .orElse(DEAFULT)
			 .championship();
   }
   
   public String getGender() {
	   return gender;
   }
}
