package com.zhylko.secondtask.parser;

import com.zhylko.secondtask.entity.TextElementComposite;
import com.zhylko.secondtask.entity.TextElementType;

public class SentenceParser extends TextAbstractParser{
	private static final String SENTENCE_TO_LEXEMES_REGEX = "\\s+";
	
	@Override
	public TextElementComposite parseElement(String sentence) {
		TextElementComposite result = new TextElementComposite(TextElementType.SENTENCE);
		String[] lexemes = sentence.split(SENTENCE_TO_LEXEMES_REGEX);
		for(String lexeme : lexemes) {
			TextAbstractParser nextParser = this.getNextParser();
			TextElementComposite lexemeComposite = nextParser.parseElement(lexeme);
			result.addComponent(lexemeComposite);
		}
		return result;
	}
}
