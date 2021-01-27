package ensa.pay.Repository;


import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import ensa.pay.models.Agent;
import ensa.pay.models.Files;

public interface FilesRepository extends MongoRepository<Files, String> {
	
	@Query("{ 'id_agent' : ?0 }")
	public List<Files> findById_agent(String descripon);
	 
	
	@Query(value="{ 'id_agent' : ?0 }",delete = true)
	public void deleteById_agent(String id_agent);
	// @Query("select u from Files u where u.description = ?1")
	// public List<Files> findByDescription2(String description);
}
