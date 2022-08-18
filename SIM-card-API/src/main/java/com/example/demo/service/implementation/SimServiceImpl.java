package com.example.demo.service.implementation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.SimRecord;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.payload.SimRecordDto;
import com.example.demo.repository.SimRepository;
import com.example.demo.service.SimService;

@Service
public class SimServiceImpl implements SimService{
	
	@Autowired
	private SimRepository simRepository;

	@Override
	public SimRecordDto add(SimRecordDto recorddto) {
		
		SimRecord simRecord=dtoToObject(recorddto);
		
		return objectToDto(simRepository.save(simRecord));
	}
	
	@Override
	public List<SimRecordDto> listAll() {
		
		List<SimRecord> records=this.simRepository.findAll();
		
		List<SimRecordDto> recordsDto=records.stream().map((record)-> objectToDto(record)).collect(Collectors.toList());
		
		return recordsDto;
	}
	
	@Override
	public SimRecordDto update(SimRecordDto recorddto,String id) {
		
		SimRecord simRecord=this.simRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException(id));
		
		simRecord.setSimCardNo(recorddto.getSimCardNo());
		simRecord.setStatus(recorddto.getStatus());
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
		LocalDate expiryDate = LocalDate.parse(recorddto.getExpiryDate(), formatter);
		simRecord.setExpiryDate(expiryDate);
		
		simRecord.setStateOfRegistration(recorddto.getStateOfRegistration());
		simRecord.setKyc(recorddto.getKyc());
		simRecord.setTelecomProvider(recorddto.getTelecomProvider());
		simRecord.setFullName(recorddto.getFullName());
		
		return objectToDto(simRepository.save(simRecord));
	}
	
	@Override
	public void delete(String id) {
		SimRecord simRecord=this.simRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException(id));
		this.simRepository.delete(simRecord);
	}
	
	@Override
	public List<SimRecordDto> getToBeRenewRecord() {
		
		LocalDate todaysDate=LocalDate.now();
		LocalDate dateAfter30Day=todaysDate.plusDays(30);
		
		List<SimRecord> records=this.simRepository.getToBeRenewed(todaysDate,dateAfter30Day);
		
		List<SimRecordDto> recordsDto=records.stream().map((record)-> objectToDto(record)).collect(Collectors.toList());
		return recordsDto;
	}

	private SimRecord dtoToObject(SimRecordDto dto) {
		SimRecord record=new SimRecord();
		
		record.setSimCardNo(dto.getSimCardNo());
		record.setMobileNo(dto.getMobileNo());
		record.setStatus(dto.getStatus());
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
		LocalDate expiryDate = LocalDate.parse(dto.getExpiryDate(), formatter);
		record.setExpiryDate(expiryDate);
		
		record.setStateOfRegistration(dto.getStateOfRegistration());
		record.setKyc(dto.getKyc());
		record.setTelecomProvider(dto.getTelecomProvider());
		record.setFullName(dto.getFullName());
		
		return record;
	}
	
	private SimRecordDto objectToDto(SimRecord object) {
		SimRecordDto dto=new SimRecordDto();
		
		dto.setSimCardNo(object.getSimCardNo());
		dto.setMobileNo(object.getMobileNo());
		dto.setStatus(object.getStatus());

		dto.setExpiryDate(object.getExpiryDate().toString());
		
		dto.setStateOfRegistration(object.getStateOfRegistration());
		dto.setKyc(object.getKyc());
		dto.setTelecomProvider(object.getTelecomProvider());
		dto.setFullName(object.getFullName());
		
		return dto;
	}

	

	
}
