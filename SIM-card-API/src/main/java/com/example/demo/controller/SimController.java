package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.payload.SimRecordDto;
import com.example.demo.service.SimService;

@RestController
public class SimController {
	
	@Autowired
	private SimService simService;

	@RequestMapping("/")
	public ResponseEntity<String> home() {
		return new ResponseEntity<String>("API is working...",HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<SimRecordDto> add(@RequestBody SimRecordDto recorddto) {
		SimRecordDto record=this.simService.add(recorddto);
		return new ResponseEntity<SimRecordDto>(record,HttpStatus.CREATED);
	}
	
	@GetMapping("/listall")
	public ResponseEntity<List<SimRecordDto>> listAll() {
		List<SimRecordDto> records=this.simService.listAll();
		return new ResponseEntity<List<SimRecordDto>>(records,HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<SimRecordDto> update(@RequestBody SimRecordDto recorddto,@PathVariable("id") String id){
		SimRecordDto record=this.simService.update(recorddto,id);
		return new ResponseEntity<SimRecordDto>(record,HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") String id){
		this.simService.delete(id);
		return new ResponseEntity<String>("Record Deleted Successfully...",HttpStatus.OK);
	}
	
	@GetMapping("/to-renew")
	public ResponseEntity<List<SimRecordDto>> getToBeRenewRecord(){
		List<SimRecordDto> records=this.simService.getToBeRenewRecord();
		return new ResponseEntity<List<SimRecordDto>>(records,HttpStatus.OK);
	}
	
	
	
}
