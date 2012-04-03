package com.vegeta.model;

import java.util.HashMap;
import java.util.Map;

public class PrimaryKey {
	
	private TableVO table;	
	private String name;
	private Map<Integer, FieldVO> fields = new HashMap<Integer, FieldVO>();
	
	public PrimaryKey(TableVO table) {
		this.table = table;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Map<Integer, FieldVO> getFields() {
		return fields;
	}
	public void setFields(Map<Integer, FieldVO> fields) {
		this.fields = fields;
	}
	public TableVO getTable() {
		return table;
	}
	public void setTable(TableVO table) {
		this.table = table;
	}

}
