package com.example.demo.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sim_record")
public class SimRecord {

	private String simCardNo;
	@Id
	private String mobileNo;
	private String status;
	private LocalDate expiryDate;
	private String stateOfRegistration;
	private String kyc;
	private String telecomProvider;
	private String fullName;
	
	public SimRecord(String simCardNo, String mobileNo, String status, LocalDate expiryDate,
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

	public SimRecord() {
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

	public LocalDate getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(LocalDate expiryDate) {
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
		return "SimRecord [simCardNumber=" + simCardNo + ", mobileNo=" + mobileNo + ", status=" + status
				+ ", expiryDate=" + expiryDate + ", stateOfRegistration=" + stateOfRegistration + ", kyc=" + kyc
				+ ", telecomProvider=" + telecomProvider + ", fullName=" + fullName + "]";
	}
	
	
	
}
