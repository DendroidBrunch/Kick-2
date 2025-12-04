package com.zhylko.secondtask.reader.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.zhylko.secondtask.exception.TextCompositeException;
import com.zhylko.secondtask.reader.TextFileReader;

public class TextFileReaderImpl implements TextFileReader {

	private static final Logger logger  = LogManager.getLogger();
	
	@Override
	public String readFile(String filepath) throws TextCompositeException {
		Path path = Paths.get(filepath);
		if(!Files.exists(path)) {
			throw new TextCompositeException("Cannot access file: " + filepath);
		}
		String text;
		try {
			text = Files.readString(path);
		} catch(IOException e){
			logger.log(Level.ERROR, "File error: " + e);
			throw new TextCompositeException("File error: ", e);
		}
		return text;
	}

}
