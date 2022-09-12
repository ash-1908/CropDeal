package com.demo.cropdeal.user.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Bank {
	
	@Id
	@Column(nullable=false,unique=true,name="account_no")
	private Long accountNo ;
	
	@Column(nullable=false)
	 private String accountHolderName ;
	
	@Column(nullable=false)
     private String bankName ; 
	
	@Column(nullable=false)
     private String bankBranch; 
	
	@Column(nullable=false)
     private String bankIFSC ;
 

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
