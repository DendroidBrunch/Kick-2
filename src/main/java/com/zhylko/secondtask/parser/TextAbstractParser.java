package com.zhylko.secondtask.parser;

import com.zhylko.secondtask.entity.TextElementComposite;

public abstract class TextAbstractParser {
	TextAbstractParser nextParser;
	
	public void setNextParser(TextAbstractParser nextParser) { 
		this.nextParser = nextParser;
	}
	
	public TextAbstractParser getNextPAaser() {
		return nextParser;
	}
	
	public abstract TextElementComposite parseElement(String elementToParse);
}
