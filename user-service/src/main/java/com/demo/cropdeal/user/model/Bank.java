package com.demo.cropdeal.user.model;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Document("bank")
public class Bank {
	
	@Id
	private String id;
	private Long accountNo;
	
	private String accountHolderName;
	
	private String bankName;
	
	private String bankBranch;
	
	private String bankIFSC;
	
	
	public Bank(Long accountNo, String accountHolderName, String bankName, String bankBranch, String bankIFSC) {
		super();
		this.accountNo = accountNo;
		this.accountHolderName = accountHolderName;
		this.bankName = bankName;
		this.bankBranch = bankBranch;
		this.bankIFSC = bankIFSC;
	}
	
	public Bank() {
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public Long getAccountNo() {
		return accountNo;
	}
	
	public void setAccountNo(Long accountNo) {
		this.accountNo = accountNo;
	}
	
	public String getAccountHolderName() {
		return accountHolderName;
	}
	
	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}
	
	public String getBankName() {
		return bankName;
	}
	
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	
	public String getBankBranch() {
		return bankBranch;
	}
	
	public void setBankBranch(String bankBranch) {
		this.bankBranch = bankBranch;
	}
	
	public String getBankIFSC() {
		return bankIFSC;
	}
	
	public void setBankIFSC(String bankIFSC) {
		this.bankIFSC = bankIFSC;
	}
	
	
	@Override
	public String toString() {
		return "Bank [accountNo=" + accountNo + ", accountHolderName=" + accountHolderName + ", bankName=" + bankName
			+ ", bankBranch=" + bankBranch + ", bankIFSC=" + bankIFSC + "]";
	}
}
