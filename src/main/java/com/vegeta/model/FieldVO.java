package com.vegeta.model;

import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class FieldVO {

	private TableVO table;
	private int seq;
	private String name;
	private int typeCod;
	private String typeName;
	private int precision;
	private int scale;
	private int nullable;
	
	public FieldVO(TableVO table) {
		this.table = table;
	}
		
	public FieldVO(TableVO table, ResultSetMetaData rs, int field) throws SQLException {
		this.table = table;
		this.name = rs.getColumnName(field);
		this.typeCod = rs.getColumnType(field);
		this.typeName = rs.getColumnTypeName(field);		
		this.precision = rs.getPrecision(field);
		this.scale = rs.getScale(field);
		this.nullable = rs.isNullable(field);
	}
	
	public String toXML() {
		StringBuilder txt = new StringBuilder();
		txt.append("	<field id=\"" + name + "\">\n");
		txt.append("		<type-cod>" + typeCod + "</type-cod>\n");
		txt.append("		<type-name>" + typeName + "</type-name>\n");
		if (scale > 0) {
			txt.append("		<size>" + precision + "." + scale + "</size>\n");
		} else if (precision > 0) {
			txt.append("		<size>" + precision + "</size>\n");
		}
		if (nullable == 0) {
			txt.append("		<not-null>true</not-null>\n");
		}
		txt.append("	</field>\n");
		return txt.toString();
	}
	
	public int getType() {
		return typeCod;
	}

	public void setType(int type) {
		this.typeCod = type;
	}

	public int getPrecision() {
		return precision;
	}

	public void setPrecision(int precision) {
		this.precision = precision;
	}

	public int getScale() {
		return scale;
	}

	public void setScale(int scale) {
		this.scale = scale;
	}

	public int getNullable() {
		return nullable;
	}

	public void setNullable(int nullable) {
		this.nullable = nullable;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public TableVO getTable() {
		return table;
	}

	public void setTable(TableVO table) {
		this.table = table;
	}

	public int getTypeCod() {
		return typeCod;
	}

	public void setTypeCod(int typeCod) {
		this.typeCod = typeCod;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

}
