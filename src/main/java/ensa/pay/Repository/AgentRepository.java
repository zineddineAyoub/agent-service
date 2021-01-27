package ensa.pay.Repository;
import ensa.pay.models.Files;
import org.springframework.data.mongodb.repository.MongoRepository;

import ensa.pay.models.Agent;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface AgentRepository extends MongoRepository<Agent,String> {

    @Query("{ 'phone_number' : ?0 }")
    public Agent findByPhoneNumber(String phoneNumber);
}
