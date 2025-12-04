package com.zhylko.secondtask.parser;

import com.zhylko.secondtask.entity.TextElementComposite;
import com.zhylko.secondtask.entity.TextElementType;

public class ParagraphParser extends TextAbstractParser{
	private static final String PARAGRAPH_TO_SENTENCES_REGEX = "(?<=[.!?])\\s+";
	
	@Override
	public TextElementComposite parseElement(String paragraph) {
		TextElementComposite result = new TextElementComposite(TextElementType.PARAGRAPH);
		String[] sentences = paragraph.split(PARAGRAPH_TO_SENTENCES_REGEX);
		for(String sentence : sentences) {
			TextAbstractParser nextParser = this.getNextParser();
			TextElementComposite sentenceComposite = nextParser.parseElement(sentence);
			result.addComponent(sentenceComposite);
		}
		return result;
	}
}
