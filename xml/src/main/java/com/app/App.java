package com.app;

public class App {
    public static void main(String[] args) {
        try {
            XmlParser xmlParser = new XmlParser("xml/src/main/java/com/app/config.xml");
            // Add a new RRU
            xmlParser.addElement("RRU", "3", "SN", "2", "SRN", "2", "RCN", "2");

            // Modify the SRN of the new RRU
            xmlParser.modifyElement("RRU", "2", "SRN", "3");

            // Add a new attribute to the new RRU
            xmlParser.addAttribute("RRU", "3", "newAttribute", "newValue");

            // Remove the new attribute
            xmlParser.removeAttribute("RRU", "2", "newAttribute");

            // Remove the new RRU
            // xmlParser.removeElement("RRU", "2");

            // Save changes
            xmlParser.save("xml/src/main/java/com/app/outConfig.xml");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
