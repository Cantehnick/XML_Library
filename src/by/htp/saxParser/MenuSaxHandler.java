package by.htp.saxParser;
import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

public class MenuSaxHandler extends DefaultHandler {

private List<Food> foodList=new ArrayList<Food>	();
private Food food;
private StringBuilder text;


@Override
public void startDocument() throws SAXException {
	System.out.println("parsing started.");
}

public List<Food> getFoodList(){
	return foodList;
}

@Override
public void endDocument() throws SAXException {
	System.out.println("parsing ended");

}
@Override
public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
System.out.println("startElement ->"+ "uri:"+uri+", localName :"+localName+" qName: "+qName);
text=new StringBuilder();
if (qName.equals("food")) {
	food=new Food();
	food.setId(Integer.parseInt(attributes.getValue("id")));
}

}
@Override
public void endElement(String uri, String localName, String qName) throws SAXException {
MenuTagName tagName= MenuTagName.valueOf(qName.toUpperCase().replace("-", "_"));
switch (tagName){
case NAME:
	food.setName(text.toString());
	break;
case PRICE:
	food.setPrice(text.toString());
	break;
case DESCRIPTION:
food.setDescription(text.toString());	
break;
case CALORIES:
	food.setCalories(Integer.parseInt(text.toString()));
	break;
case FOOD:
foodList.add(food);
food=null;
break;
}

}

@Override
public void characters(char[] buffer, int start, int length) throws SAXException {
	text.append(buffer,start,length);
}

@Override
public void warning(SAXParseException e) throws SAXException {
System.err.println("WARNING : Line "+e.getLineNumber()+": "+e.getMessage());
}

@Override
public void error(SAXParseException e) throws SAXException {
	System.err.println("ERROR : Line "+e.getLineNumber()+": "+e.getMessage());
}

@Override
public void fatalError(SAXParseException e) throws SAXException {
	System.err.println("FATAL : Line "+e.getLineNumber()+": "+e.getMessage());
throw (e);
}













}
