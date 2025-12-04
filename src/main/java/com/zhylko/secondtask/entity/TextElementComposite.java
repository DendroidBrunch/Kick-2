package com.zhylko.secondtask.entity;

import java.util.ArrayList;
import java.util.List;

import com.zhylko.secondtask.exception.TextCompositeException;

public class TextElementComposite extends TextElement{

	private static final String LEXEME_APPENDER = " ";
	private static final String SENTENCE_APPENDER = " ";
	private static final String PARAGRAPH_APPENDER = "\n";
	
	List<TextElement> components = new ArrayList<>();
	
	public TextElementComposite(TextElementType elementType) {
		super(elementType);
	}

	public void addComponent(TextElement component) {
		components.add(component);
	}
	
	public TextElement getComponent(int index) throws TextCompositeException {
		if(index < 0 || index >= components.size()) {
			throw new TextCompositeException("Index out of bounds for getComponent:" + index);
		}
		return components.get(index);
	}
	
	public List<TextElement> getComponents(){
		return components;
	}
	
	public void setComponent(int index, TextElement component) throws TextCompositeException {
		if(index < 0 || index >= components.size()) {
			throw new TextCompositeException("Index out of bounds for setComponent:" + index);
		}
		components.set(index, component);
	}
	
	@Override
  public String toString() {
		StringBuilder builder = new StringBuilder();
    for (int i = 0; i < components.size(); i++) {
      TextElement component = components.get(i);
      builder.append(component.toString());
      TextElementType elementType = component.getElementType();
      if(i < components.size() - 1) {
      	switch (elementType) {
	      	case TextElementType.SENTENCE: builder.append(SENTENCE_APPENDER); break;
	      	case TextElementType.LEXEME: builder.append(LEXEME_APPENDER); break;
	      	case TextElementType.PARAGRAPH: builder.append(PARAGRAPH_APPENDER); break;
	      	default: break;
      	}
      }
    }
    return builder.toString();
  }

	@Override
	public int count() {
		int result = 0;
		for(TextElement component : components) {
			result += component.count();
		}
		return result;
	}
}
