package com.zhylko.secondtask.parser;

import com.zhylko.secondtask.entity.TextElementComposite;
import com.zhylko.secondtask.entity.TextElementLeaf;
import com.zhylko.secondtask.entity.TextElementType;

public class WordParser extends TextAbstractParser{
	
	@Override
	public TextElementComposite parseElement(String word) {
		TextElementComposite result = new TextElementComposite(TextElementType.WORD);
		int length = word.length();
		for(int i = 0; i < length; i++) {
			TextElementLeaf letter = new TextElementLeaf(TextElementType.SYMBOL, word.charAt(i)); 
			result.addComponent(letter);
		}
		return result;
	}
}
