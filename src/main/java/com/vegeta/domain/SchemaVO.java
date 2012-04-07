package com.vegeta.domain;

import java.io.Serializable;

public class SchemaVO implements Serializable {

	/**
	 * Serial code version <code>serialVersionUID</code>
	 */
	private static final long serialVersionUID = -4220743363923242050L;

	/**
	 * Nome do schema.
	 */
	private final String name;

	/**
	 * Cria um Schema dado o seu nome.
	 * 
	 * @param name
	 *            Nome do schema. Não pode ser <code>null</code>.
	 */
	public SchemaVO(String name) {
		this.name = name;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
}