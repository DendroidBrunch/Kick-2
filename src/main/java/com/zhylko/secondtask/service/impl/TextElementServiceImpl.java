package com.zhylko.secondtask.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.zhylko.secondtask.entity.TextElement;
import com.zhylko.secondtask.entity.TextElementComposite;
import com.zhylko.secondtask.entity.TextElementType;
import com.zhylko.secondtask.service.TextElementService;

public class TextElementServiceImpl implements TextElementService {
	private static final Logger logger  = LogManager.getLogger();
	
	@Override
	  public int countMaxSentencesWithSameWord(TextElementComposite text) {
	    List<TextElementComposite> sentences = getAllSentences(text);
	    Map<String, Integer> wordCount = new HashMap<>();
	    for (TextElementComposite sentence : sentences) {
	      List<String> words = getWordsFromSentence(sentence);
	      for (String word : words) {
	        wordCount.merge(word, 1, Integer::sum);
	      }
	    }
	    int result = 0;
	    for (int count : wordCount.values()) {
        result = Math.max(result, count);
	    }
	    logger.log(Level.INFO, "Maximum sentences with the same word: " + result);
	    return result;
	  }

	 @Override
	 public List<TextElementComposite> sortSentencesByLexemNumber(TextElementComposite text) {
		 List<TextElementComposite> sentences = getAllSentences(text);
		 sentences.sort((s1, s2) -> Integer.compare(countLexemes(s1), countLexemes(s2)));
		 logger.log(Level.INFO, "Sentences sorted by lexem amount");
		 return sentences;
	 }

	@Override
	public void switchFirstLastLexemInSentences(TextElementComposite text) {
	  List<TextElement> components = text.getComponents();
	  for (TextElement component : components) {
	    TextElementComposite paragraph = (TextElementComposite) component;
	    List<TextElement> sentencesInParagraph = paragraph.getComponents();
	    for(TextElement sentence : sentencesInParagraph) {
	    	TextElementComposite sentenceComposite = (TextElementComposite) sentence;
	    	switchFirstLastLexemInSentence(sentenceComposite);
	    }
	  }
	  logger.log(Level.INFO, "First and last lexems in each sentance are switched");
 	}

	private List<TextElementComposite> getAllSentences(TextElementComposite text) {
    List<TextElementComposite> sentences = new ArrayList<>();
    List<TextElement> paragraphs = text.getComponents();
    for (TextElement component : paragraphs) {
      TextElementComposite paragraph = (TextElementComposite) component;
      List<TextElement> sentencesInParagraph = paragraph.getComponents();
      for(TextElement sentence : sentencesInParagraph) {
      	TextElementComposite sentenceComposite = (TextElementComposite) sentence;
      	sentences.add(sentenceComposite);
      }
    }
    return sentences;
  }

  private List<String> getWordsFromSentence(TextElementComposite sentence) {
    List<String> words = new ArrayList<>();
    List<TextElement> lexemes = sentence.getComponents();
    for(TextElement lexeme : lexemes) {
    	TextElementComposite lexemeComposite = (TextElementComposite) lexeme;
    	List<TextElement> components = lexemeComposite.getComponents();
    	for(TextElement component : components) {
    		if(component.getElementType() == TextElementType.WORD) {
    			String word = component.toString();
    			if(!words.contains(word)) {
    				words.add(word);
    			}
    		}
    	}
    }
    return words;
  }

  private int countLexemes(TextElementComposite sentence) {
    List<TextElement> lexemes = sentence.getComponents();
    int result = lexemes.size();
    return result;
  }

  private void switchFirstLastLexemInSentence(TextElementComposite sentence) {
    List<TextElement> components = sentence.getComponents();
    int firstLexemIndex = 0;
    int lastLexemIndex = components.size() - 1;
    Collections.swap(components, firstLexemIndex, lastLexemIndex);
  }
}
