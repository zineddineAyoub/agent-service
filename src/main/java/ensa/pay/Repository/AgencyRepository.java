package ensa.pay.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;

import ensa.pay.models.Agency;

public interface AgencyRepository extends MongoRepository<Agency, String> {

}
