package com.atm.service;

import com.atm.model.AtmTransactionM;

import reactor.core.publisher.Mono;

public interface IAtmTransactionS {

	Mono<AtmTransactionM> insertAtmTransaction (AtmTransactionM atmTransactionM);
}
