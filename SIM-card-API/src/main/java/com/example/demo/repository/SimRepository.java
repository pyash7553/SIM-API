package com.example.demo.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.SimRecord;

public interface SimRepository extends JpaRepository<SimRecord, String>{

	@Query("select new com.example.demo.entity.SimRecord(sr.simCardNo, sr.mobileNo, sr.status, sr.expiryDate, sr.stateOfRegistration"
			+ ", sr.kyc, sr.telecomProvider, sr.fullName) from SimRecord sr "
			+ "where sr.expiryDate >=:todaysDate and sr.expiryDate <=:dateAfter30Day")
	List<SimRecord> getToBeRenewed(@Param("todaysDate") LocalDate todaysDate,@Param("dateAfter30Day") LocalDate dateAfter30Day);
	
}
