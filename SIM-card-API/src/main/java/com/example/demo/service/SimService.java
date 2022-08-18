package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.payload.SimRecordDto;

@Service
public interface SimService {
	
	public SimRecordDto add(SimRecordDto recorddto);
	public List<SimRecordDto> listAll();
	public SimRecordDto update(SimRecordDto recorddto,String id);
	public void delete(String id);
	
	public List<SimRecordDto> getToBeRenewRecord();

	
}
