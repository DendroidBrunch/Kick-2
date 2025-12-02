package com.zhylko.secondtask.entity;

public class TextElementLeaf extends TextElement{
	private char leaf;
	
	public TextElementLeaf(TextElementType elementType, char leaf) {
		super(elementType);
		this.leaf = leaf;
	}
	
	@Override
	public int count() {
		int result = 0;
		TextElementType elementType = this.getElementType();
		if(elementType == TextElementType.SYMBOL) {
			result = 1;
		}
		return result;
	}
	
	@Override
	public String toString() {
		return String.valueOf(leaf);
	}
}
