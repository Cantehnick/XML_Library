package by.htp.domParser;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class MainApp {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		// TODO Auto-generated method stub

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder document = factory.newDocumentBuilder();
		Document doc = document.parse(new File("resources/menu.xml"));

		String titleEl = doc.getDocumentElement().getNodeName();
		System.out.println(titleEl);

		NodeList nodeList = doc.getElementsByTagName("food");

		String name;
		String price;
		String description, id;
		int calories;

		for (int i = 0; i < nodeList.getLength(); i++) {

			Element element = (Element) nodeList.item(i);
			name = element.getElementsByTagName("name").item(0).getChildNodes().item(0).getNodeValue();
			price = element.getElementsByTagName("price").item(0).getChildNodes().item(0).getNodeValue();
			description = element.getElementsByTagName("description").item(0).getChildNodes().item(0).getNodeValue();
			calories = Integer
					.parseInt(element.getElementsByTagName("calories").item(0).getChildNodes().item(0).getNodeValue());
			id = element.getAttribute("id");

			System.out.println(id + "    " + name + "    " + price + "    " + "    " + description + "    " + calories);
		}

	}
}