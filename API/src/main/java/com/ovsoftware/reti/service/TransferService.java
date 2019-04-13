package com.ovsoftware.reti.service;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
import com.ovsoftware.reti.domain.User;

/**
 * Responsible for processing Transfer actions.
 */

@Component
public class TransferService {
	
	@Autowired
	private UserService userService;
	
	@Value("${contract.owner.private.key}")
	private String privateKey;
	
	@Value("${reti.monthly.amount}")
	private Integer monthlyAmount;

	@Value("${reti.default.gas.price}")
	private Integer defaultGasPrice;
	
	@Value("${reti.default.gas.limit}")
	private Integer defaultGasLimit;

	@SuppressWarnings("deprecation")
	public void executeMonthlyTransfers() {
		Web3j web3 = Web3j.build(new HttpService("https://mainnet.infura.io/[your contract]"));  
        	
    	BigInteger key = new BigInteger(privateKey,16); 	
    	ECKeyPair ecKeyPair = ECKeyPair.create(key.toByteArray()); 
    	Credentials credentials = Credentials.create(ecKeyPair); 
    	
    	TransactionReceiptProcessor transactionReceiptProcessor = new NoOpProcessor(web3);
    	TransactionManager transactionManager = new RawTransactionManager(web3, credentials, ChainId.MAINNET, transactionReceiptProcessor);

    	BigInteger gasPrice = BigInteger.valueOf(defaultGasPrice);
    	BigInteger gasLimit = BigInteger.valueOf(defaultGasLimit);
    	
		Reti contract = Reti.load("[Your contract address]", web3, transactionManager, gasPrice, gasLimit);
    	BigInteger _value = BigInteger.valueOf((long) (monthlyAmount *Math.pow(10, 8)) );
    	
    	List<User> users = userService.getActiveUsers();
    	for(User user : users) {
    		try {
        		contract.transfer(user.getWalletAdress(), _value).sendAsync().get();
        	} catch (Exception e) {
        		System.out.println("Exception occurred while transferring " + e.getMessage());
        	}
    	}
	}
	
	@SuppressWarnings("deprecation")
	public void transferToUser(String toWallet, int amount) {
		Web3j web3 = Web3j.build(new HttpService("https://mainnet.infura.io/[your contract]"));  
        	
    	BigInteger key = new BigInteger(privateKey,16); 	
    	ECKeyPair ecKeyPair = ECKeyPair.create(key.toByteArray()); 
    	Credentials credentials = Credentials.create(ecKeyPair); 
    	
    	TransactionReceiptProcessor transactionReceiptProcessor = new NoOpProcessor(web3);
    	TransactionManager transactionManager = new RawTransactionManager(web3, credentials, ChainId.MAINNET, transactionReceiptProcessor);

    	BigInteger gasPrice = BigInteger.valueOf(defaultGasPrice);
    	BigInteger gasLimit = BigInteger.valueOf(defaultGasLimit);
    	
		Reti contract = Reti.load("[Your contract address]", web3, transactionManager, gasPrice, gasLimit);
    	BigInteger _value = BigInteger.valueOf((long) (amount *Math.pow(10, 8)) );
    	try {
    		contract.transfer(toWallet, _value).sendAsync().get();
    	} catch (Exception e) {
    		System.out.println("Exception occurred while transferring " + e.getMessage());
    	}
	}
}
