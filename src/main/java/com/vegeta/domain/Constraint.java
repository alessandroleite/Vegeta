package com.vegeta.domain;

public abstract class Constraint {

	private final TableVO table;

	private final String name;

	public Constraint(String name, TableVO table) {
		this.name = name;
		this.table = table;
	}

	/**
	 * @return the table
	 */
	public TableVO getTable() {
		return table;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
}