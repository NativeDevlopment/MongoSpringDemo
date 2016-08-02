package com.test.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "sequence")
public class SequenceId {

	@Id
	private String id;

	private long seq;

	public long getSeq() {
		// TODO Auto-generated method stub
		return seq;
	}

	//get, set, toString...
}