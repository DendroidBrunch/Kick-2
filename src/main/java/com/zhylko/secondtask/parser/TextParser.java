package com.zhylko.secondtask.parser;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.zhylko.secondtask.entity.TextElementComposite;
import com.zhylko.secondtask.entity.TextElementType;

public class TextParser extends TextAbstractParser{
	private static final Logger logger  = LogManager.getLogger();
	private static final String TEXT_TO_PARAGRAPHS_REGEX = "\n+";
	
	@Override
	public TextElementComposite parseElement(String text) {
		TextElementComposite result = new TextElementComposite(TextElementType.TEXT);
		String[] paragraphs = text.split(TEXT_TO_PARAGRAPHS_REGEX);
		for(String paragraph : paragraphs) {
			TextAbstractParser nextParser = this.getNextParser();
			TextElementComposite paragraphComposite = nextParser.parseElement(paragraph);
			result.addComponent(paragraphComposite);
		}
		logger.log(Level.INFO, "Text parsed");
		return result;
	}
}
