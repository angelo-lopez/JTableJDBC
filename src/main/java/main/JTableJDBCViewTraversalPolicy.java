package main;

import java.awt.Component;
import java.awt.Container;
import java.awt.FocusTraversalPolicy;
import java.util.Vector;

public class JTableJDBCViewTraversalPolicy extends FocusTraversalPolicy {
	
	private Vector<Component> vector = new Vector<Component>();
	
	public JTableJDBCViewTraversalPolicy(Vector<Component> vector) {
		this.vector = vector;
		this.vector.addAll(vector);
	}

	@Override
	public Component getComponentAfter(Container aContainer, Component aComponent) {
		int index = (vector.indexOf(aComponent) + 1 ) % vector.size();
		return vector.get(index);
	}

	@Override
	public Component getComponentBefore(Container aContainer, Component aComponent) {
		int index = vector.indexOf(aComponent) - 1;
		
		if(index < 0) {
			index = vector.size() - 1;
		}
		
		return vector.get(index);
	}

	@Override
	public Component getFirstComponent(Container aContainer) {
		return vector.get(0);
	}

	@Override
	public Component getLastComponent(Container aContainer) {
		return vector.lastElement();
	}

	@Override
	public Component getDefaultComponent(Container aContainer) {
		return vector.get(0);
	}

}
