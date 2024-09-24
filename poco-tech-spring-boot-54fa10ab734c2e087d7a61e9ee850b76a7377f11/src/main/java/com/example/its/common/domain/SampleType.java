package com.example.its.common.domain;

import org.seasar.doma.Domain;

@Domain(factoryMethod = "of",valueType = Integer.class)
public enum SampleType {
	SAMPLE_1			(1, "1のvalueです"),
	SAMPLE_2			(2, "2のvalueです"),
	SAMPLE_5			( 5, "5のvalueです");

	private final Integer id;
	private final String name;

	SampleType(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	public static SampleType of(Integer id){
		for(SampleType value : SampleType.values()){
			if(value.id.equals(id)){
				return value;
			}
		}
		throw new IllegalArgumentException(id + "");
	}

	public static SampleType of(String id){
		return of(Integer.parseInt(id));
	}

	public Integer getValue(){
		return id;
	}

	public String getName(){
		return name;
	}

}
