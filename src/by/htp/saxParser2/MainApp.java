package by.htp.saxParser2;




import java.io.File;
import java.io.IOException;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class MainApp {

	public static void main(String[] args) throws ParserConfigurationException, SAXException {

SAXParserFactory factoryP=SAXParserFactory.newInstance();
SAXParser parserSax=factoryP.newSAXParser();
Handler handler=new Handler();
try {
	
	try {
		parserSax.parse(new File("resources/menu.xml"), handler);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
} catch (SAXException e) {

	e.printStackTrace();
}

Map <Integer,String > data= handler.getData();
for (Map.Entry<Integer, String> entry: data.entrySet()) {
	System.out.println(entry.getValue()+"   "+entry.getKey());
}
		
	}

}
