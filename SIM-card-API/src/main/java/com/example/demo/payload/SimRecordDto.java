package com.example.demo.payload;

import java.time.LocalDate;

import javax.persistence.Id;

public class SimRecordDto {

	private String simCardNo;
	private String mobileNo;
	private String status;
	private String expiryDate;
	private String stateOfRegistration;
	private String kyc;
	private String telecomProvider;
	private String fullName;
	
	public SimRecordDto(String simCardNo, String mobileNo, String status, String expiryDate,
			String stateOfRegistration, String kyc, String telecomProvider, String fullName) {
		super();
		this.simCardNo = simCardNo;
		this.mobileNo = mobileNo;
		this.status = status;
		this.expiryDate = expiryDate;
		this.stateOfRegistration = stateOfRegistration;
		this.kyc = kyc;
		this.telecomProvider = telecomProvider;
		this.fullName = fullName;
	}

	public SimRecordDto() {
		super();
	}

	public String getSimCardNo() {
		return simCardNo;
	}

	public void setSimCardNo(String simCardNo) {
		this.simCardNo = simCardNo;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getStateOfRegistration() {
		return stateOfRegistration;
	}

	public void setStateOfRegistration(String stateOfRegistration) {
		this.stateOfRegistration = stateOfRegistration;
	}

	public String getKyc() {
		return kyc;
	}

	public void setKyc(String kyc) {
		this.kyc = kyc;
	}

	public String getTelecomProvider() {
		return telecomProvider;
	}

	public void setTelecomProvider(String telecomProvider) {
		this.telecomProvider = telecomProvider;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	@Override
	public String toString() {
		return "SimPayload [simCardNumber=" + simCardNo + ", mobileNo=" + mobileNo + ", status=" + status
				+ ", expiryDate=" + expiryDate + ", stateOfRegistration=" + stateOfRegistration + ", kyc=" + kyc
				+ ", telecomProvider=" + telecomProvider + ", fullName=" + fullName + "]";
	}
	
	
	
}
