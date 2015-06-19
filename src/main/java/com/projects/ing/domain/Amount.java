package com.projects.ing.domain;

public class Amount {
	
	float value;
	Currency currency;
	public float getValue() {
		return value;
	}
	public void setValue(float value) {
		this.value = value;
	}
	public Currency getCurrency() {
		return currency;
	}
	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

}
