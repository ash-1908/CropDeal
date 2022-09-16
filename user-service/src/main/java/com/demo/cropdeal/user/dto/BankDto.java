package com.demo.cropdeal.user.dto;

import com.demo.cropdeal.user.model.Bank;

public class BankDto {
	
	private Long accountNo;
	
	private String accountHolderName;
	
	private String bankName;
	
	private String bankBranch;
	
	private String bankIFSC;
	
	
	public BankDto(Long accountNo, String accountHolderName, String bankName, String bankBranch, String bankIFSC) {
		super();
		this.accountNo = accountNo;
		this.accountHolderName = accountHolderName;
		this.bankName = bankName;
		this.bankBranch = bankBranch;
		this.bankIFSC = bankIFSC;
	}
	
	public BankDto() {
		
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
	
	public Bank getBankFromBankDto(BankDto bankdto) {
		
		var bank1 = new Bank();
		bank1.setAccountHolderName(bankdto.getAccountHolderName());
		bank1.setAccountNo(bankdto.getAccountNo());
		bank1.setBankBranch(bankdto.getBankBranch());
		bank1.setBankIFSC(bankdto.getBankIFSC());
		bank1.setBankName(bankdto.getBankName());
		return bank1;
	}
	
	
}
