package com.atm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atm.model.AtmAccountM;
import com.atm.repository.IAtmAccountR;

import reactor.core.publisher.Mono;

@Service
public class AtmAccountS implements IAtmAccountS {
	
	@Autowired
	IAtmAccountR iAtmAccountR;
	
	@Override
	public Mono<AtmAccountM> insertAtmAccount(AtmAccountM atmAccountM) {
		
		return iAtmAccountR.save(atmAccountM);
	}

	@Override
	public Mono<AtmAccountM> updateAtmAccount(AtmAccountM atmAccountM) {
		
		return iAtmAccountR.findByNumberAccountSource(atmAccountM.getNumberAccountSource())
			.flatMap(a -> {
				a.setNumberOfMovement(atmAccountM.getNumberOfMovement());
				return iAtmAccountR.save(a);
			});
	}

	
	public Mono<Void> deleteById(AtmAccountM atmAccountM) {
		
		return iAtmAccountR.findByNumberAccountSource(atmAccountM.getNumberAccountSource())
			.flatMap(a -> {
				return iAtmAccountR.deleteById(a.getId());
			});
		
	}

}
