package com.zhylko.secondtask.parser;

import com.zhylko.secondtask.entity.TextElementComposite;
import com.zhylko.secondtask.entity.TextElementType;

public class LexemeParser extends TextAbstractParser{
	private static final String LEXEME_TO_WORDS_REGEX = "\\s+";
	
	@Override
	public TextElementComposite parseElement(String lexeme) {
		TextElementComposite result = new TextElementComposite(TextElementType.LEXEME);
		String[] words = lexeme.split(LEXEME_TO_WORDS_REGEX);
		for(String word : words) {
			TextElementComposite wordComposite = nextParser.parseElement(word);
			result.addComponent(wordComposite);
		}
		return result;
	}
}
