package by.htp.saxParser;

import java.io.IOException;
import java.util.List;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class MainApp {

	public static void main(String[] args) throws SAXException, IOException {

		XMLReader reader = XMLReaderFactory.createXMLReader();
		MenuSaxHandler handler = new MenuSaxHandler();
		reader.setContentHandler(handler);
		reader.parse(new InputSource("resources/menu.xml"));

	
		List<Food> menu = handler.getFoodList();

		for (Food food : menu) {
			System.out.println(food.getName());
			System.out.println(food.getCalories());
		}
	}

}
