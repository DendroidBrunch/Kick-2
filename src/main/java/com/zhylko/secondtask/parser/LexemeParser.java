package com.zhylko.secondtask.parser;

import com.zhylko.secondtask.entity.TextElementComposite;
import com.zhylko.secondtask.entity.TextElementLeaf;
import com.zhylko.secondtask.entity.TextElementType;

public class LexemeParser extends TextAbstractParser{
	private static final String LEXEME_TO_WORD_AND_PUNCTUATION_REGEX = "(?<=\\p{Punct})(?<!['-])|(?=\\p{Punct})(?!['-])|(\\s+)";
	private static final String PUNCTUATION_REGEX = "\\p{Punct}";
	
	@Override
	public TextElementComposite parseElement(String lexeme) {
		TextElementComposite result = new TextElementComposite(TextElementType.LEXEME);
		String[] components = lexeme.split(LEXEME_TO_WORD_AND_PUNCTUATION_REGEX);
		for(String component : components) {
			if(component.matches(PUNCTUATION_REGEX)) {
				TextElementLeaf punctuation = new TextElementLeaf(TextElementType.PUNCTUATION, component.charAt(0));
				result.addComponent(punctuation);
			} else {
				TextElementComposite wordComposite = nextParser.parseElement(component);
				result.addComponent(wordComposite);
			}
		}
		return result;
	}
}
