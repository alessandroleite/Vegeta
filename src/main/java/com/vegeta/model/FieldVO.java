package com.vegeta.model;

import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Types;

public class FieldVO {

	private String name;
	private int typeCod;
	private String typeName;
	private int size;
	private int precision;
	private int scale;
	private int nullable;
		
	public FieldVO(ResultSetMetaData rs, int field) throws SQLException {
		this.name = rs.getColumnName(field);
		this.typeCod = rs.getColumnType(field);
		this.typeName = rs.getColumnTypeName(field);
		this.size = rs.getColumnDisplaySize(field);
		this.precision = rs.getPrecision(field);
		this.scale = rs.getScale(field);
		this.nullable = rs.isNullable(field);
	}
	
	public String toXML() {
		StringBuilder txt = new StringBuilder();
		txt.append("	<field id=\"" + name + "\">\n");
		txt.append("		<type-cod>" + typeCod + "</type-cod>\n");
		txt.append("		<type-name>" + typeName + "</type-name>\n");
		if (Types.DECIMAL == typeCod || Types.DOUBLE == typeCod || 
				Types.FLOAT == typeCod || Types.NUMERIC == typeCod) {
			txt.append("		<size>" + precision + "." + scale + "</size>\n");
		} else {
			txt.append("		<size>" + size + "</size>\n");
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

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
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

}
