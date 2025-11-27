package com.zhylko.secondtask.parser;

import com.zhylko.secondtask.entity.TextElementComposite;
import com.zhylko.secondtask.entity.TextElementType;

public class LexemeParser extends TextAbstractParser{
	private static final String SENTENCE_TO_LEXEME_REGEX = "(?<=[//p+])\\s+";
	
	@Override
	public TextElementComposite parseElement(String sentence) {
		TextElementComposite result = new TextElementComposite(TextElementType.SENTENCE);
		String[] lexemes = sentence.split(SENTENCE_TO_LEXEME_REGEX);
		for(String lexeme : lexemes) {
			TextElementComposite lexemComposite = nextParser.parseElement(lexeme);
			result.addComponent(lexemComposite);
		}
		return result;
	}
}
