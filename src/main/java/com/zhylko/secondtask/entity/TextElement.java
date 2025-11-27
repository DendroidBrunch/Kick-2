package com.zhylko.secondtask.entity;

public abstract class TextElement {
	private TextElementType elementType;
	
	public TextElement(TextElementType elementType) {
		this.elementType = elementType;
	}
	
	public TextElementType getElementType() {
		return elementType;
	}
	
	public void setElementType(TextElementType elementType) {
		this.elementType = elementType;  
	}
	
	public abstract String show();
}
