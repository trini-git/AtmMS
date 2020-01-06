package com.atm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.atm.model.AtmAccountM;
import com.atm.model.AtmTransactionM;
import com.atm.service.AtmAccountS;
import com.atm.service.AtmTransactionS;

import reactor.core.publisher.Mono;

@RestController
public class AtmC {
	
	/*Model AtmAccount*/
	
	@Autowired
	AtmAccountS atmAccountS;
		
	@PostMapping("/insert-atm-account")
	public Mono<AtmAccountM> insertAtmAccount(@RequestBody AtmAccountM atmAccountM) {

	    return atmAccountS.insertAtmAccount(atmAccountM);
	}
	
	@PutMapping("/update-atm-account")
	public Mono<AtmAccountM> updateAtmAccount(@RequestBody AtmAccountM atmAccountM) {

	    return atmAccountS.updateAtmAccount(atmAccountM);
	}
	
	@DeleteMapping("/delete-atm-account/")
	public Mono<Void> deleteById(@RequestBody AtmAccountM atmAccountM) {

	    return atmAccountS.deleteById(atmAccountM);
	}
	
	/*Model AtmTransaction*/
	
	@Autowired
	AtmTransactionS atmTransactionS;
	
	@PostMapping("/insert-atm-transaction")
	public Mono<AtmTransactionM> insertAtmTransacion(@RequestBody AtmTransactionM atmTransactionM) {

	    return atmTransactionS.insertAtmTransaction(atmTransactionM);
	}
}
