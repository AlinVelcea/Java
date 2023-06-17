package com.app;

import org.w3c.dom.*;

import java.io.File;

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;

public class XmlParser {
    private Document doc;

    public XmlParser(String filePath) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc = builder.parse(filePath);
    }

    public void addElement(String tag, String id, String... attrsAndValues) {
        Element newElement = doc.createElement(tag);
        newElement.setAttribute("id", id);
        for (int i = 0; i < attrsAndValues.length; i += 2) {
            Element attr = doc.createElement(attrsAndValues[i]);
            attr.appendChild(doc.createTextNode(attrsAndValues[i + 1]));
            newElement.appendChild(attr);
        }
        doc.getDocumentElement().appendChild(newElement);
    }

    public void modifyElement(String tag, String id, String attr, String newValue) {
        NodeList elements = doc.getElementsByTagName(tag);
        for (int i = 0; i < elements.getLength(); i++) {
            Node element = elements.item(i);
            if (element.getNodeType() == Node.ELEMENT_NODE) {
                Element elementNode = (Element) element;
                if (elementNode.getAttribute("id").equals(id)) {
                    NodeList attrNodes = elementNode.getElementsByTagName(attr);
                    for (int j = 0; j < attrNodes.getLength(); j++) {
                        Node attrNode = attrNodes.item(j);
                        if (attrNode.getNodeType() == Node.ELEMENT_NODE) {
                            attrNode.setTextContent(newValue);
                        }
                    }
                }
            }
        }
    }

    public void removeElement(String tag, String id) {
        NodeList elements = doc.getElementsByTagName(tag);
        for (int i = 0; i < elements.getLength(); i++) {
            Node element = elements.item(i);
            if (element.getNodeType() == Node.ELEMENT_NODE) {
                Element elementNode = (Element) element;
                if (elementNode.getAttribute("id").equals(id)) {
                    elementNode.getParentNode().removeChild(elementNode);
                }
            }
        }
    }

    public void addAttribute(String tag, String id, String attr, String value) {
        NodeList elements = doc.getElementsByTagName(tag);
        for (int i = 0; i < elements.getLength(); i++) {
            Node element = elements.item(i);
            if (element.getNodeType() == Node.ELEMENT_NODE) {
                Element elementNode = (Element) element;
                if (elementNode.getAttribute("id").equals(id)) {
                    elementNode.setAttribute(attr, value);
                }
            }
        }
    }

    public void removeAttribute(String tag, String id, String attr) {
        NodeList elements = doc.getElementsByTagName(tag);
        for (int i = 0; i < elements.getLength(); i++) {
            Node element = elements.item(i);
            if (element.getNodeType() == Node.ELEMENT_NODE) {
                Element elementNode = (Element) element;
                if (elementNode.getAttribute("id").equals(id)) {
                    elementNode.removeAttribute(attr);
                }
            }
        }
    }

    public void save(String filePath) throws TransformerException {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "1");
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File(filePath));
        transformer.transform(source, result);
    }
}
