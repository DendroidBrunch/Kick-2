package com.zhylko.secondtask.parser;

import com.zhylko.secondtask.entity.TextElementComposite;

public abstract class TextAbstractParser {
	private TextAbstractParser nextParser;
	
	public void setNextParser(TextAbstractParser nextParser) { 
		this.nextParser = nextParser;
	}
	
	public TextAbstractParser getNextParser() {
		return nextParser;
	}
	
	public abstract TextElementComposite parseElement(String elementToParse);
}
