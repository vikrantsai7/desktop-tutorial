package com.vikrant.example.demo.service;



import static org.junit.Assert.assertTrue;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

 
@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
public class PhoneNumberServiceTest 
{
	@InjectMocks
    PhoneNumberService phoneNumberService;
     
    @Test
    public void testGetPhoneNumber() {
       
        List<String> responseList = phoneNumberService.getCombinations("6029039841");
         assertTrue(responseList.contains("6029039841"));
        
    }
     
    
}