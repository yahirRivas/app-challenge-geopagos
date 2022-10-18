package com.geopagos.torneo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.geopagos.torneo.model.Player;
import com.geopagos.torneo.repository.PlayerRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class AppChallengeGeopagosApplication {

	@Autowired
	private PlayerRepository playerRepository;

	@Bean
	CommandLineRunner preLoadMongo() throws Exception {
	    return args -> {
	        log.info("Start load data players");  
	    	playerRepository.deleteAll();
	    	
	    	List<Player> players = new ArrayList<>();
	    	players.add(new Player("1", "Carlos Alcaraz", "M",90,80,0));
	    	players.add(new Player("2", "Casper Ruud","M", 95, 72, 0));
	    	players.add(new Player("3", "Stefanos Tsitsipas", "M", 88, 78, 0));
	    	players.add(new Player("4", "Novak Djokovic", "M", 83, 78, 0));
	    	players.add(new Player("5", "Rafael Nadal", "M", 88, 80, 0));
	    	players.add(new Player("6", "Daniil Medvedev", "M", 70, 90, 0));
	    	players.add(new Player("7", "Alexander Zverev", "M", 87, 72, 0));
	    	players.add(new Player("8", "Taylor Fritz", "M", 81, 72, 0));
	    	
	    	players.add(new Player("9", "Serena Williams","F", 0, 0, 81));
	    	players.add(new Player("10", "Ons Jabeur", "F", 0, 0, 79));
	    	players.add(new Player("11", "Paula Badosa", "F", 0, 0, 75));
	    	players.add(new Player("12", "Jessica Pegula", "F", 0, 0, 72));
	    	players.add(new Player("13", "Iga Swiatek", "F", 0, 0, 82));
	    	players.add(new Player("14", "Anett Kontaveit", "F", 0, 0, 76));
	    	players.add(new Player("15", "Aryna Sabalenka", "F", 0, 0, 73));
	    	players.add(new Player("16", "Maria Sakkari", "F", 0, 0, 70));

	    	log.info("rows -> {}", playerRepository.saveAll(players).size());  
	    	log.info("Finish load data players");  
	    };
	}
	
	public static void main(String[] args) {
		SpringApplication.run(AppChallengeGeopagosApplication.class, args);
	}
}