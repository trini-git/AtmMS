package com.atm.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.atm.model.AtmTransactionM;

import reactor.core.publisher.Mono;

@Repository
public interface IAtmTransactionR extends ReactiveMongoRepository<AtmTransactionM, String>{

	Mono<AtmTransactionM> findByAccountNumberSource(String accountNumberSource);
}
