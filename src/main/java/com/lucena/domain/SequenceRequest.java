package com.lucena.domain;

import java.util.List;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

@Document(collection = "sequences")
public class SequenceRequest {
	
	@Id
	public ObjectId _id;
	
	@Indexed(unique = true)
    private String request;
	
	private List<Integer> response;

	public String getRequest() {
		return request;
	}

	public void setRequest(String request) {
		this.request = request;
	}

	public List<Integer> getResponse() {
		return response;
	}

	public void setResponse(List<Integer> response) {
		this.response = response;
	}

	public SequenceRequest(String request, List<Integer> response) {
		this.request = request;
		this.response = response;
	}
	
	public SequenceRequest() {
	}
	
}
