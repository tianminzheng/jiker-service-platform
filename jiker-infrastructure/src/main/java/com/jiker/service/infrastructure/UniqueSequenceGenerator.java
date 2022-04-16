package com.jiker.service.infrastructure;

import java.util.UUID;

public class UniqueSequenceGenerator {

	private static UniqueSequenceGenerator instance = new UniqueSequenceGenerator();
	
	public String getUniqueSequence(){

		return UUID.randomUUID().toString().replace("-", "").toLowerCase();
	}
	
	public static UniqueSequenceGenerator getInstance(){
		return instance;
	}
}
