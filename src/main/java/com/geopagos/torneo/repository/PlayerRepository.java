package com.geopagos.torneo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.geopagos.torneo.model.Player;

@Repository
public interface PlayerRepository extends MongoRepository<Player, Long>{

	List<Player> findByGender(String gender);
}
