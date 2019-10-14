package com.lucena.repository;

import com.lucena.domain.SequenceRequest;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SequenceResquestRepository extends MongoRepository<SequenceRequest, String> {
	
	SequenceRequest findFirstByRequest(String request);

}
