package com.zhylko.secondtask.parser;

import com.zhylko.secondtask.entity.TextElementComposite;
import com.zhylko.secondtask.entity.TextElementType;

public class TextParser extends TextAbstractParser{
	private static final String TEXT_TO_PARAGRAPH_REGEX = "//s+";
	
	@Override
	public TextElementComposite parseElement(String text) {
		TextElementComposite result = new TextElementComposite(TextElementType.TEXT);
		String[] paragraphs = text.split(TEXT_TO_PARAGRAPH_REGEX);
		for(String paragraph : paragraphs) {
			TextElementComposite paragraphComposite = nextParser.parseElement(paragraph);
			result.addComponent(paragraphComposite);
		}
		return result;
	}
}
