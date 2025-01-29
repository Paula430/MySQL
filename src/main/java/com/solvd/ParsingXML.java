package com.solvd;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.TestMethodOrder;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.io.IOException;
import javax.xml.validation.Validator;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ParsingXML {

    private Document doc;

    public ParsingXML() {
        try {
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            doc = builder.parse(new File("src/main/resources/myxml.xml"));
            doc.getDocumentElement().normalize();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    //validate doc with schema
    @Test
    @Order(1)
    public void validateDoc(){
        File xsdFile=new File("src/main/resources/schema.xsd");
        try{
            SchemaFactory factory=SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema=factory.newSchema(xsdFile);
            Validator validator= schema.newValidator();

            DocumentBuilderFactory dbFactory=DocumentBuilderFactory.newInstance();
            dbFactory.setNamespaceAware(true);
            dbFactory.setSchema(schema);

            validator.validate(new DOMSource(doc));

            System.out.println("File is valid against the schema");
        }catch(SAXException e){
            System.out.println(e.getMessage());
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    //check if doc has two clients
    @Test
    @Order(2)
    public void whenGetElementByTag_thenSuccess() {
        NodeList nodeList = doc.getElementsByTagName("client");
        Node first = nodeList.item(0);

        assertEquals(2, nodeList.getLength());
        assertEquals(Node.ELEMENT_NODE, first.getNodeType());
        assertEquals("client", first.getNodeName());
    }

    //check if first client has one attribute id=1
    @Test
    @Order(3)
    public void whenGetFirstElementAttributes_thenSuccess() {
        Node first = doc.getElementsByTagName("client").item(0);
        NamedNodeMap attrList = first.getAttributes();

        assertEquals(1, attrList.getLength());

        assertEquals("id", attrList.item(0).getNodeName());
        assertEquals("1", attrList.item(0).getNodeValue());

    }

    //print first client
    @Test
    @Order(4)
    public void whenTraverseChildNodes_thenSuccess() {
        Node first = doc.getElementsByTagName("client").item(0);
        NodeList nodeList = first.getChildNodes();
        int n = nodeList.getLength();
        Node current;
        for (int i=0; i<n; i++) {
            current = nodeList.item(i);
            if(current.getNodeType() == Node.ELEMENT_NODE) {
                System.out.println(
                        current.getNodeName() + ": " + current.getTextContent());
            }
        }
    }

    //modify user role and print him
    @Test
    @Order(5)
    public void whenModifyDocument_thenModified() {

        NodeList nodeList = doc.getElementsByTagName("user");
        Element first = (Element) nodeList.item(0);

        assertEquals("1", first.getAttribute("id"));

        first.setAttribute("id", "2");
        assertEquals("2", first.getAttribute("id"));


         //Print attributes of the node
        System.out.println("After modify: ");
        NamedNodeMap attributes = first.getAttributes();
        for (int i = 0; i < attributes.getLength(); i++) {
            Node attr = attributes.item(i);
            System.out.println(attr.getNodeName() + ": " + attr.getNodeValue());
        }

         //Traverse and print child nodes
        NodeList ChildNodeList = first.getChildNodes();
        int n = ChildNodeList.getLength();
        Node current;
        for (int i = 0; i < n; i++) {
            current = ChildNodeList.item(i);
            if (current.getNodeType() == Node.ELEMENT_NODE) {
                System.out.println(current.getNodeName() + ": " + current.getTextContent());
            }
        }

    }

    @Test
    @Order(6)
    public void whenCreateNewDocument_thenCreated() throws Exception {
        DocumentBuilder builder=DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document newDoc = builder.newDocument();
        Element root = newDoc.createElement("users");
        newDoc.appendChild(root);

        Element first = newDoc.createElement("user");
        root.appendChild(first);
        first.setAttribute("id", "1");

        Element email = newDoc.createElement("email");
        email.appendChild(newDoc.createTextNode("john@example.com"));
        first.appendChild(email);

        assertEquals(1, newDoc.getChildNodes().getLength());
        assertEquals("users", newDoc.getChildNodes().item(0).getNodeName());
        saveDomToFile(newDoc,"src/main/resources/generated.xml");
    }

    private void saveDomToFile(Document document,String fileName)
            throws Exception {

        DOMSource dom = new DOMSource(document);
        Transformer transformer = TransformerFactory.newInstance()
                .newTransformer();

        StreamResult result = new StreamResult(new File(fileName));
        transformer.transform(dom, result);
    }






}





