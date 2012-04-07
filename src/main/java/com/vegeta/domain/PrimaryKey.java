package com.vegeta.domain;


public class PrimaryKey extends Constraint {

	private final Columns columns;

	public PrimaryKey(String name, Columns columns, TableVO table) {
		super(name, table);
		this.columns = columns;
	}

	/**
	 * @return the columns
	 */
	public Columns getColumns() {
		return columns;
	}
}