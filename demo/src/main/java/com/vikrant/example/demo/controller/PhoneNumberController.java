package com.vikrant.example.demo.controller;


import java.util.List;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.annotation.JsonView;
import com.vikrant.example.demo.service.PhoneNumberService;


@RestController
@RequestMapping("/phone")
@Validated
public class PhoneNumberController {
	
    private static final Logger logger = LoggerFactory.getLogger(PhoneNumberController.class);

	
	@Autowired
	private PhoneNumberService phoneNumberService;
	/**
	 * 
	 * @param phoneNumber
	 * @return
	 */
	@CrossOrigin
	@ExceptionHandler(value = { ConstraintViolationException.class })
	@RequestMapping(value = "/{phoneNumber}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<String> getPhoneNumberCombinations(
			@PathVariable  @Valid  @NonNull  
			@Size(max = 10, min = 7, message = "Phone number should have between 7 and 10 characters") 
	String phoneNumber) {
		
		logger.info("getPhoneNumberCombinations called");
		return phoneNumberService.getCombinations(phoneNumber);
	}
		

	
	
}
