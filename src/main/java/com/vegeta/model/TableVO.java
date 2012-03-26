package com.vegeta.model;

import java.util.ArrayList;
import java.util.List;

public class TableVO {
	
	private String name;
		
	private List<FieldVO> fields = new ArrayList<FieldVO>();
		
	public String toXML() {
		StringBuilder txt = new StringBuilder();
		txt.append("<table id=\"" + name + "\">\n");
		for (FieldVO field : fields) {
			txt.append(field.toXML());
		}
		txt.append("</table>\n");
		return txt.toString();
	}

	public String getName() {
		return name;
	}

	public List<FieldVO> getFields() {
		return fields;
	}

	public void setFields(List<FieldVO> fields) {
		this.fields = fields;
	}

	public void setName(String name) {
		this.name = name;
	}

}
