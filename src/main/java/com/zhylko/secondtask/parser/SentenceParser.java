package com.zhylko.secondtask.parser;

import com.zhylko.secondtask.entity.TextElementComposite;
import com.zhylko.secondtask.entity.TextElementLeaf;
import com.zhylko.secondtask.entity.TextElementType;

public class SentenceParser extends TextAbstractParser{
	private static final String SENTENCE_TO_LEXEMES_AND_PUNCTUATIONS_REGEX = "(?<=[//p+])\\s+";
	private static final String PUNCTUATION_REGEX = "\\p{Punct}";
	
	@Override
	public TextElementComposite parseElement(String sentence) {
		TextElementComposite result = new TextElementComposite(TextElementType.SENTENCE);
		String[] lexemes = sentence.split(SENTENCE_TO_LEXEMES_AND_PUNCTUATIONS_REGEX);
		for(String lexeme : lexemes) {
			if(lexeme.matches(PUNCTUATION_REGEX)) {
				TextElementLeaf punctuation = new TextElementLeaf(TextElementType.SYMBOL, lexeme.charAt(0));
				result.addComponent(punctuation);
			} else {
				TextElementComposite lexemeComposite = nextParser.parseElement(lexeme);
				result.addComponent(lexemeComposite);
			}
		}
		return result;
	}
}
