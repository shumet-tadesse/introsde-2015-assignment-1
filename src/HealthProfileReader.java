import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


import java.util.Scanner;
//this file consists of solutions that 
//implements getWeight and getHeight methods
// prints all people in the list with detail
// accepts id as parameter and prints the HealthProfile of the person with that id
//accepts a weight and an operator (=, > , <) as parameters and prints people that fulfill that condition 


//the xml file used to implement the xpath is people2.xml


public class HealthProfileReader {

    Document doc;
    XPath xpath;
    static Scanner input=new Scanner(System.in);
    public void loadXML() throws ParserConfigurationException, SAXException, IOException {

        DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
        domFactory.setNamespaceAware(true);
        DocumentBuilder builder = domFactory.newDocumentBuilder();
        doc = builder.parse("people2.xml");

        //creating xpath object
        getXPathObj();
    }

    public XPath getXPathObj() {

        XPathFactory factory = XPathFactory.newInstance();
        xpath = factory.newXPath();
        return xpath;
    }
    public Node getWeight(String id) throws XPathExpressionException {

    	XPathExpression expr = xpath.compile("/people/person[@id='" + id + "']/healthprofile/weight");
    	//XPathExpression expr = xpath.compile("//person[firstname='" + firstname + "']|//person[lastname='"+lastname+"']//weight");
        Node node = (Node) expr.evaluate(doc, XPathConstants.NODE);
        return node;
       
    }

    public Node getHeight(String id) throws XPathExpressionException {

        XPathExpression expr = xpath.compile("/people/person[@id='" + id + "']/healthprofile/height");
    	//XPathExpression expr = xpath.compile("//person[firstname='" + firstname +"']| //person[lastname='" + lastname +"'] //height");
        Node node = (Node) expr.evaluate(doc, XPathConstants.NODE);
        return node;
       
    }
    public NodeList getWeightCondition(String condition, String weight) throws XPathExpressionException {

        XPathExpression expr = xpath.compile("/people/person/*[following-sibling::healthprofile[weight " + condition + "'" + weight + "']]");
        NodeList nodes = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
        return nodes;

    }
    public Node getHealthProfile(String ID) throws XPathExpressionException {

        XPathExpression expr = xpath.compile("/people/person[@id='" + ID + "']/healthprofile");
        Node nodes = (Node) expr.evaluate(doc, XPathConstants.NODE);
        return nodes;
    }
    public NodeList getAllDetails() throws XPathExpressionException {

        XPathExpression expr = xpath.compile("//person[position() <= 20 ]");
        NodeList nodes = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
        return nodes;

    }
        
    public static void main(String[] args) throws ParserConfigurationException, SAXException,
            IOException, XPathExpressionException {

    	HealthProfileReader test = new HealthProfileReader();
       test.loadXML();
       //print all people in the list with detail
    
       NodeList nodes5 = test.getAllDetails();
       System.out.println("People in the data base with all details");
       for (int n = 0; n < nodes5.getLength(); n++) {
       	System.out.println(nodes5.item(n).getTextContent());
       }
       // accepts id as parameter and prints the HealthProfile of the person with that id
       System.out.println("Health Profile of  person with id=5 :");
       Node nodes4 = test.getHealthProfile("005");
       System.out.println(nodes4.getTextContent());
       
       NodeList nodes = test.getWeightCondition(">", "90");
       System.out.println("People having weight > 90 Kg:");
       for (int i = 0; i < nodes.getLength(); i++) {
       	System.out.println(nodes.item(i).getTextContent());
       }
     /*
       //the solutions in this file are organized in such a way that the user selects options 1-4
       System.out.println("What do you want to do?");
       System.out.println("1. Get Height and GetWeight");
       System.out.println("2. Display Health Profile  ");
       System.out.println("3. Display People based on Weight and Operator condition ");
       System.out.println("4. Print All People with Details ");
       System.out.println("Enter your choice 1-4");
        
        int status=input.nextInt();
        switch (status) {
        case 1:
        	// e.g. firstname=Andualem lastname=Getenet 
        System.out.println("Enter First name:");
    	String firstname=input.next();
    	System.out.println("Enter Last name:");
    	String lastname=input.next();
        Node node = test.getHeight(firstname,lastname);
        System.out.println("Height and Weight of "+ firstname+" "+lastname+" are: "+ node.getTextContent()+"M");
            Node node7 = test.getWeight(firstname, lastname);
            System.out.println(" and  " + node7.getTextContent()+"Kg,  respectively");
        break;
        case 2:
        	//health profile based on ID
        	System.out.println("Enter  ID NO to display Health Profile: ");
    		
        	String id2=input.next();
           
            System.out.println("Health Profile of this person is :");
            Node nodes4 = test.getHealthProfile(id2);
            System.out.println("ID NO:"+id2+nodes4.getTextContent());
            break;
        case 3:
        	//needs to enter weight of individuals and an operator
        	System.out.println("Enter  Weight: ");
    		String w=input.next();
    		System.out.println("Enter an Operator: ");
    		String op=input.next();
            NodeList nodes = test.getWeightCondition(w, op);
            System.out.println("People having weight"+ op+w+ " Kg");
            for (int i = 0; i < nodes.getLength(); i++) {
            	System.out.println(nodes.item(i).getTextContent());
            }
            break;
        case 4:
        	//displays all people from people2.xml file
        	NodeList nodes5 = test.getAllDetails();
            System.out.println("People in the data base with all details");
            for (int n = 0; n < nodes5.getLength(); n++) {
            	System.out.println(nodes5.item(n).getTextContent());
            } 
            break;
        default: System.out.println("Error: invalid input");
        System.exit(1);
        }*/
            
        
        
    }
}



