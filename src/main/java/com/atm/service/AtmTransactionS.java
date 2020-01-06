package com.atm.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.atm.model.AtmAccountM;
import com.atm.model.AtmTransactionM;
import com.atm.model.FixedTermVipModel;
import com.atm.model.MainModel;
import com.atm.repository.IAtmAccountR;
import com.atm.repository.IAtmTransactionR;

import reactor.core.publisher.Mono;

@Service
public class AtmTransactionS implements IAtmTransactionS {
	
	@Autowired
	IAtmTransactionR iAtmTransactionR;
	
	@Autowired
	IAtmAccountR iAtmAccountR;
	
	AtmAccountM atmAccountM;
	
	@Autowired
	@Qualifier("bankAccountMain")
	WebClient client;
	
	@Autowired
	@Qualifier("bankFixedTermAccountVip")
	WebClient client2;
	
	MainModel mainModel = new MainModel();
	
	FixedTermVipModel fixedTermVipModel = new FixedTermVipModel();
	
	/* Microservice that connects */
	  public Mono<MainModel> findAccountNumber(String accountNumber) {
		  Map<String, Object> param = new HashMap<String, Object>();
	    param.put("accountNumber", accountNumber);
	    return client.get()
	.uri("/find-by/{accountNumber}",param)
	.accept(MediaType.APPLICATION_JSON_UTF8)
	.retrieve()
	.bodyToMono(MainModel.class)
	.switchIfEmpty(Mono.empty());
	  }
	  
	  /* Microservice that connects */
	  public Mono<MainModel> updateAtmAmountDeposite(MainModel mainModel) {
	    return client.put()
	.uri("/update-atm-amount-deposite")
	.accept(MediaType.APPLICATION_JSON_UTF8)
	.contentType(MediaType.APPLICATION_JSON_UTF8)
	.syncBody(mainModel)
	.retrieve()
	.bodyToMono(MainModel.class)
	.switchIfEmpty(Mono.empty());
	  }
	  
	  /* Microservice that connects */
	  public Mono<MainModel> updateAtmAmountRetire(MainModel mainModel) {
	    return client.put()
	.uri("/update-atm-amount-retire")
	.accept(MediaType.APPLICATION_JSON_UTF8)
	.contentType(MediaType.APPLICATION_JSON_UTF8)
	.syncBody(mainModel)
	.retrieve()
	.bodyToMono(MainModel.class)
	.switchIfEmpty(Mono.empty());
	  }
	  
	  public Mono<FixedTermVipModel> updateAtmAmountDepositeFtv(FixedTermVipModel fixedTermVipModel) {
		    return client2.put()
		        .uri("/update-atm-amount-deposite-ftv")
		        .accept(MediaType.APPLICATION_JSON_UTF8)
		        .contentType(MediaType.APPLICATION_JSON_UTF8)
		        .syncBody(fixedTermVipModel)
		        .retrieve()
		        .bodyToMono(FixedTermVipModel.class)
		        .switchIfEmpty(Mono.empty());
		  }
	  
	  public Mono<FixedTermVipModel> updateAtmAmountRetireFtv(FixedTermVipModel fixedTermVipModel) {
		    return client2.put()
		        .uri("/update-atm-amount-retire-ftv")
		        .accept(MediaType.APPLICATION_JSON_UTF8)
		        .contentType(MediaType.APPLICATION_JSON_UTF8)
		        .syncBody(fixedTermVipModel)
		        .retrieve()
		        .bodyToMono(FixedTermVipModel.class)
		        .switchIfEmpty(Mono.empty());
		  }
		
	@Override
	public Mono<AtmTransactionM> insertAtmTransaction(AtmTransactionM atmTransactionM) {
		
		return findAccountNumber(atmTransactionM.getAccountNumberSource())
			.flatMap(a -> {
				atmTransactionM.setBeforeAmount(a.getCurrentAmount());
				atmTransactionM.setBankSource(a.getBank().getName());
				atmTransactionM.setMaxOfMovement(5);
				
				mainModel.setAccountNumber(atmTransactionM.getAccountNumberSource());
				fixedTermVipModel.setAccountNumber(atmTransactionM.getAccountNumberSource());
				
				if (atmTransactionM.getMaxOfMovement() >= atmTransactionM.getNumberOfMovement()) {
					atmTransactionM.setChargeMovement(0.0);
				}else {
					atmTransactionM.setChargeMovement(10.0);
				}
				
				if (atmTransactionM.getBankAtm().equalsIgnoreCase(a.getBank().getName())) {
					atmTransactionM.setChargeBank(0.0);
				}else {
					atmTransactionM.setChargeBank(25.0);
				}
				
				if (atmTransactionM.getType().equalsIgnoreCase("D")) {
					
					atmTransactionM.setAfterAmount(a.getCurrentAmount() + atmTransactionM.getAmount() - atmTransactionM.getChargeBank() - atmTransactionM.getChargeMovement());
					mainModel.setCurrentAmount(atmTransactionM.getAfterAmount());
					fixedTermVipModel.setCurrentAmount(mainModel.getCurrentAmount());
					
					return updateAtmAmountDeposite(mainModel).flatMap(b -> {
						
						return updateAtmAmountDepositeFtv(fixedTermVipModel).flatMap(c -> {
							
							return iAtmTransactionR.save(atmTransactionM);
						});
						
					});
						
				}else if (atmTransactionM.getType().equalsIgnoreCase("R")){
					
					atmTransactionM.setAfterAmount(a.getCurrentAmount() - atmTransactionM.getAmount() - atmTransactionM.getChargeBank() - atmTransactionM.getChargeMovement());
					mainModel.setCurrentAmount(atmTransactionM.getAfterAmount());
					fixedTermVipModel.setCurrentAmount(mainModel.getCurrentAmount());
					
					return updateAtmAmountRetire(mainModel).flatMap(b -> {
						
						return updateAtmAmountRetireFtv(fixedTermVipModel).flatMap(c -> {
							
							return iAtmTransactionR.save(atmTransactionM);
						});
					});
				}
				return Mono.empty();
									
				});
				
					
	}

}
