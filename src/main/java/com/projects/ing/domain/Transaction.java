package com.projects.ing.domain;

public class Transaction {
	
	String productId;
	TransactionType transactionType;
	TransactionSubType transactionSubType;
	Direction direction;
	String counterpartProductId;
	Currency currency;
	Amount amount;
	EffectiveDate effectiveDate;
	AccountingDate accountingDate;
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public TransactionType getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}
	public TransactionSubType getTransactionSubType() {
		return transactionSubType;
	}
	public void setTransactionSubType(TransactionSubType transactionSubType) {
		this.transactionSubType = transactionSubType;
	}
	public Direction getDirection() {
		return direction;
	}
	public void setDirection(Direction direction) {
		this.direction = direction;
	}
	public String getCounterpartProductId() {
		return counterpartProductId;
	}
	public void setCounterpartProductId(String counterpartProductId) {
		this.counterpartProductId = counterpartProductId;
	}
	public Currency getCurrency() {
		return currency;
	}
	public void setCurrency(Currency currency) {
		this.currency = currency;
	}
	public Amount getAmount() {
		return amount;
	}
	public void setAmount(Amount amount) {
		this.amount = amount;
	}
	public EffectiveDate getEffectiveDate() {
		return effectiveDate;
	}
	public void setEffectiveDate(EffectiveDate effectiveDate) {
		this.effectiveDate = effectiveDate;
	}
	public AccountingDate getAccountingDate() {
		return accountingDate;
	}
	public void setAccountingDate(AccountingDate accountingDate) {
		this.accountingDate = accountingDate;
	}
}
