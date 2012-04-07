package com.vegeta.domain;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "columns")
public class Columns implements Iterable<ColumnVO> {

	private final List<ColumnVO> columns = new LinkedList<ColumnVO>();

	/**
	 * Adiciona uma {@link ColumnVO} desde que a mesma não seja
	 * <code>null</code> ou já seja conhecida.
	 * 
	 * @param column
	 *            coluna a ser adicionada. Não pode ser <code>null</code>
	 * @return <code>true</code> se a coluna fornecida estiver sido adicionada
	 *         ou <code>false</code> caso contrário.
	 */
	public boolean add(ColumnVO column) {
		if (column != null && !columns.contains(column)) {
			return this.columns.add(column);
		}
		return false;
	}

	/**
	 * Remove uma dada {@link ColumnVO}
	 * 
	 * @param column
	 *            Coluna a ser removida.
	 * @return <code>true</code> se a coluna fornecida estiver sido removida ou
	 *         <code>false</code> caso contrário.
	 */
	public boolean remove(ColumnVO column) {
		return this.columns.remove(column);
	}

	/**
	 * Retorna uma lista não modificável de colunas.
	 * 
	 * @return Uma {@link List} não modificável com as colunas.
	 */
	public List<ColumnVO> columns() {
		return Collections.unmodifiableList(columns);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Iterator<ColumnVO> iterator() {
		return this.columns.iterator();
	}
}