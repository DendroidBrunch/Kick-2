package com.zhylko.secondtask.service;

import java.util.List;

import com.zhylko.secondtask.entity.TextElementComposite;

public interface TextElementService {
	int countMaxSentencesWithSameWord(TextElementComposite text);
	List<TextElementComposite> sortSentencesByLexemNumber(TextElementComposite text);
	void switchFirstLastLexemInSentences(TextElementComposite text);
}
