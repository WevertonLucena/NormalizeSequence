package com.lucena.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lucena.domain.SequenceRequest;
import com.lucena.repository.SequenceResquestRepository;
import com.lucena.service.Normalize;

@RestController
public class NormalizeController {
	
	@Autowired
	private Normalize normalize;
	
	@Autowired
	private SequenceResquestRepository repository;
	
	
	@GetMapping("/normalize")
	public ResponseEntity<List<Integer>>  normalizeSequences(@RequestBody String sequence) {
		
		List<Integer> list = new ArrayList<>();
		
		SequenceRequest result = repository.findFirstByRequest(sequence);

		if(result == null) {
			ObjectMapper mapper = new ObjectMapper();
			
			String[] sequences;
			
			try {
				sequences = mapper.readValue(sequence, String[].class);
				
				for(String s : sequences) {
					int x = normalize.normalizeSequence(s, 0, 0);
					list.add(x);
				}
				
			} catch (IOException e) {
				e.printStackTrace();
				return ResponseEntity.badRequest().body(list);
			}
			repository.save(new SequenceRequest(sequence,list));
		}else {
			list = result.getResponse();
		}

		return ResponseEntity.ok(list) ;
		
	}
	

}
