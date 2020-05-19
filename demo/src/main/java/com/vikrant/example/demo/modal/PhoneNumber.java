package com.vikrant.example.demo.modal;

import java.util.Arrays;

public class PhoneNumber {
	
	String phoneNumber;
	char[] combination;
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public char[] getCombination() {
		return combination;
	}
	public void setCombination(char[] combination) {
		this.combination = combination;
	}
	
	
	@Override
	public String toString() {
		return "PhoneNumber [phoneNumber=" + phoneNumber + ", combination=" + Arrays.toString(combination) + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(combination);
		result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PhoneNumber other = (PhoneNumber) obj;
		if (!Arrays.equals(combination, other.combination))
			return false;
		if (phoneNumber == null) {
			if (other.phoneNumber != null)
				return false;
		} else if (!phoneNumber.equals(other.phoneNumber))
			return false;
		return true;
	}
	
	

}
