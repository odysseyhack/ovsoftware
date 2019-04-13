package com.ovsoftware.reti.service;

import java.math.BigInteger;

import org.springframework.stereotype.Component;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.ECKeyPair;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.ChainId;
import org.web3j.tx.RawTransactionManager;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.response.NoOpProcessor;
import org.web3j.tx.response.TransactionReceiptProcessor;

import com.ovsoftware.reti.domain.Reti;

/**
 * Responsible for processing Transfer actions.
 */

@Component
public class TransferService {
	
	private static final BigInteger GAS_PRICE = BigInteger.valueOf(1000);
	private static final BigInteger GAS_LIMIT = BigInteger.valueOf(1000);
	
	@SuppressWarnings("deprecation")
	public void transferToUser(String toWallet, int amount) {
		Web3j web3 = Web3j.build(new HttpService("https://mainnet.infura.io/[your contract]"));  
        	
		String privateKey = "[ contract owner privateKey ]";
    	BigInteger key = new BigInteger(privateKey,16); 	
    	ECKeyPair ecKeyPair = ECKeyPair.create(key.toByteArray()); 
    	Credentials credentials = Credentials.create(ecKeyPair); 
    	
    	TransactionReceiptProcessor transactionReceiptProcessor = new NoOpProcessor(web3);
    	TransactionManager transactionManager = new RawTransactionManager(web3, credentials, ChainId.MAINNET, transactionReceiptProcessor);

		Reti contract = Reti.load("[Your contract address]", web3, transactionManager, GAS_PRICE, GAS_LIMIT);
    	BigInteger _value = BigInteger.valueOf((long) (amount *Math.pow(10, 8)) );
    	try {
    		contract.transfer(toWallet, _value).sendAsync().get();
    	} catch (Exception e) {
    		System.out.println("Exception occurred while transferring " + e.getMessage());
    	}
	}
}
