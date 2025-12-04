package com.zhylko.secondtask.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.zhylko.secondtask.entity.TextElementComposite;
import com.zhylko.secondtask.parser.LexemeParser;
import com.zhylko.secondtask.parser.ParagraphParser;
import com.zhylko.secondtask.parser.SentenceParser;
import com.zhylko.secondtask.parser.TextParser;
import com.zhylko.secondtask.parser.WordParser;
import com.zhylko.secondtask.reader.impl.TextFileReaderImpl;

class TextElementServiceImplTest {

	static String filepath = "resources/text.txt";
	static TextParser parser;
	TextElementComposite text;
	
	@BeforeAll
	static void setUpParser() {
		parser = new TextParser();
    ParagraphParser paragraphParser = new ParagraphParser();
    SentenceParser sentenceParser = new SentenceParser();
    LexemeParser lexemeParser = new LexemeParser();
    WordParser wordParser = new WordParser();
    parser.setNextParser(paragraphParser);
    paragraphParser.setNextParser(sentenceParser);
    sentenceParser.setNextParser(lexemeParser);
    lexemeParser.setNextParser(wordParser);
	}
	
	@BeforeEach
	void setUp() throws Exception {
		TextFileReaderImpl reader = new TextFileReaderImpl();
		String textString = reader.readFile(filepath);
    text = parser.parseElement(textString);
	}

	@AfterEach
	void tearDown() {
		text = null;
	}

	@Test
	void countMaxSentencesWithSameWord() {
		TextElementServiceImpl service = new TextElementServiceImpl();
		int expected = 4;
		int actual = service.countMaxSentencesWithSameWord(text);
		assertEquals(expected, actual);
	}
	
	@Test
	void sortSentencesByLexemNumber() throws IOException {
		TextElementServiceImpl service = new TextElementServiceImpl();
		String pathToExpected = "resources/sorted.txt";
		Path path = Path.of(pathToExpected);
		List<String> expected = Files.readAllLines(path);
		List<TextElementComposite> result = service.sortSentencesByLexemNumber(text);
		List<String> actual = new ArrayList<>();
		for(TextElementComposite composite : result) {
			String sentence = composite.toString();
			actual.add(sentence);
		}
		assertEquals(expected, actual);
	}
	
	@Test
	void switchFirstLastLexemInSentence() throws IOException {
		TextElementServiceImpl service = new TextElementServiceImpl();
		String pathToExpected = "resources/switched.txt";
		Path path = Path.of(pathToExpected);
		String expected = Files.readString(path);
		service.switchFirstLastLexemInSentences(text);
		String actual = text.toString();
		assertEquals(expected, actual);
	}
}
