package com.ovsoftware.reti.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ovsoftware.reti.domain.User;
import com.ovsoftware.reti.service.TransferService;
import com.ovsoftware.reti.service.UserService;

/**
 * Responsible for processing http requests for Transfers.
 */

@RestController
@CrossOrigin
@RequestMapping("/transfer")
public class TransferController {
	
	@Autowired 
	private UserService userService;
	
	@Autowired 
	private TransferService transferService;
	
	@RequestMapping(value = "{amount}", method = RequestMethod.POST)
    public ResponseEntity<?> transferRetiToUser(@PathVariable("amount") int amount, @RequestBody String username) {
		User user = userService.getUser(username);
		transferService.transferToUser(user.getWalletAdress(), amount);
		return ResponseEntity.ok().build();
    }
	
	@RequestMapping(value = "monthly", method = RequestMethod.POST)
    public ResponseEntity<?> transferMonthlyReti() {
		transferService.executeMonthlyTransfers();
		return ResponseEntity.ok().build();
    }
}
