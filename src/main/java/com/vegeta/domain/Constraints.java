package com.vegeta.domain;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Constraints implements Iterable<Constraint> {

	private List<Constraint> constraints = new LinkedList<Constraint>();

	public boolean add(Constraint constraint) {
		if (constraint != null && !this.constraints.contains(constraint)) {
			return this.constraints.add(constraint);
		}
		return false;
	}

	public boolean remove(Constraint constraint) {
		return this.constraints.remove(constraint);
	}

	public List<Constraint> constraints() {
		return Collections.unmodifiableList(this.constraints);
	}

	@Override
	public Iterator<Constraint> iterator() {
		return constraints.iterator();
	}
}