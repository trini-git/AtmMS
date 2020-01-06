package com.atm.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.atm.model.AtmAccountM;

import reactor.core.publisher.Mono;

@Repository
public interface IAtmAccountR extends ReactiveMongoRepository<AtmAccountM, String>{
	
	Mono<AtmAccountM> findByNumberAccountSource(String numberAccountSource);

}
