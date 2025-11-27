package com.zhylko.secondtask.entity;

public class TextElementLeaf extends TextElement{
	private char leaf;
	
	public TextElementLeaf(TextElementType elementType, char leaf) {
		super(elementType);
		this.leaf = leaf;
	}
	
	@Override
	public String show() {
		return String.valueOf(leaf);
	}
}
