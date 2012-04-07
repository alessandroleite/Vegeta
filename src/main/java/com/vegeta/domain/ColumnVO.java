package com.vegeta.domain;

import java.io.Serializable;

public class ColumnVO implements Serializable{

	private Integer seq;
	private String name;
	private Integer type;
	private String typeName;
	private Integer precision;
	private Integer scale;
	private Integer nullable;
	private TableVO table;
	
	public ColumnVO(TableVO table) {
		this.table = table;
	}
	
	
}
