package com.vegeta.domain;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "table", propOrder = { "name", "columns", "constraints" })
public class TableVO implements Serializable {

	/**
	 * Serial code version <code>serialVersionUID</code>
	 */
	private static final long serialVersionUID = -6458152247752141451L;

	/**
	 * Nome da tabela.
	 */
	private final String name;

	/**
	 * Colunas que compõem a tabela.
	 */
	private final Columns columns;

	/**
	 * Constraits da tabela.
	 */
	private final Constraints constraints;

	public TableVO(String name, Columns columns, Constraints constraints) {
		this.name = name;
		this.columns = columns;
		this.constraints = constraints;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the columns
	 */
	public Columns getColumns() {
		return columns;
	}

	/**
	 * @return the constraints
	 */
	public Constraints getConstraints() {
		return constraints;
	}
	
	
}