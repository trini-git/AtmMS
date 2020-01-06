package com.atm.service;

import org.springframework.stereotype.Service;

import com.atm.model.AtmAccountM;

import reactor.core.publisher.Mono;

@Service
public interface IAtmAccountS {

	Mono<AtmAccountM> insertAtmAccount (AtmAccountM atmAccountM);
	Mono<AtmAccountM> updateAtmAccount (AtmAccountM atmAccountM);
}
