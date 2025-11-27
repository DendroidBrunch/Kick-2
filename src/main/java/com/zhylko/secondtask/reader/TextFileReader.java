package com.zhylko.secondtask.reader;

import com.zhylko.secondtask.exception.TextCompositeException;

public interface TextFileReader {
	String readFile(String filepath) throws TextCompositeException;
}
