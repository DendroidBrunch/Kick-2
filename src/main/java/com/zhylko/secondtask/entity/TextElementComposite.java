package com.zhylko.secondtask.entity;

import java.util.ArrayList;
import java.util.List;

import com.zhylko.secondtask.exception.TextCompositeException;

public class TextElementComposite extends TextElement{

	List<TextElement> components = new ArrayList<>();
	
	public TextElementComposite(TextElementType elementType) {
		super(elementType);
	}

	public void addComponent(TextElement component) {
		components.add(component);
	}
	
	public TextElement getComponent(int index) throws TextCompositeException {
		if(index < 0 || index >= components.size()) {
			throw new TextCompositeException("Index out of bounds for getComponent:" + index);
		}
		return components.get(index);
	}
	
	public List<TextElement> getComponents(){
		return components;
	}
	
	public void setComponent(int index, TextElement component) throws TextCompositeException {
		if(index < 0 || index >= components.size()) {
			throw new TextCompositeException("Index out of bounds for setComponent:" + index);
		}
		components.set(index, component);
	}
	
	@Override
	public String show() {
		StringBuilder builder = new StringBuilder();
		for(TextElement component : components) {
			builder.append(component.toString());
		}
		return builder.toString();
	}
}
