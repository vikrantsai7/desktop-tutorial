package com.vikrant.example.demo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.vikrant.example.demo.modal.PhoneNumber;
@Service
public class PhoneNumberService {
	

	 /**
	  * 
	  * @param phoneNumber
	  * @return
	  */
	public List<String> getCombinations(String phoneNumber) {
		return alphaNumericCombinations(phoneNumber);
	}
	
	/**
	 * 
	 * @param digits
	 * @return
	 */
	public List<String> alphaNumericCombinations(String digits) {
	    HashMap<Character, char[]> phoneKeyMapping = new HashMap<Character, char[]>();
	    phoneKeyMapping.put('0',new char[]{'0'});
	    phoneKeyMapping.put('1',new char[]{'1'});
	    phoneKeyMapping.put('2',new char[]{'2','a','b','c'});
	    phoneKeyMapping.put('3',new char[]{'3','d','e','f'});
	    phoneKeyMapping.put('4',new char[]{'4','g','h','i'});
	    phoneKeyMapping.put('5',new char[]{'5','j','k','l'});
	    phoneKeyMapping.put('6',new char[]{'6','m','n','o'});
	    phoneKeyMapping.put('7',new char[]{'7','p','q','r','s'});
	    phoneKeyMapping.put('8',new char[]{'8','t','u','v'});
	    phoneKeyMapping.put('9',new char[]{'9','w','x','y','z'});
	 
	    List<String> result = new ArrayList<String>();
	    if(digits==null||digits.length()==0){
	        return null;
	    }
	 
	    char[] arr = new char[digits.length()];
	    helper(digits, 0, phoneKeyMapping, result, arr);
	    
	    return result;
	}
	 
	/**
	 * 
	 * @param digits
	 * @param index
	 * @param dict
	 * @param result
	 * @param arr
	 */
	private void helper(String digits, int index, HashMap<Character, char[]> dict, 
	                        List<String> result, char[] arr){
	    if(index==digits.length()){
	        result.add(new String(arr));
	        return;
	    }
	 
	    char number = digits.charAt(index);
	    char[] candidates = dict.get(number);
	    for(int i=0; i<candidates.length; i++){
	        arr[index]=candidates[i];
	        helper(digits, index+1, dict, result, arr);
	    }
	}

}
