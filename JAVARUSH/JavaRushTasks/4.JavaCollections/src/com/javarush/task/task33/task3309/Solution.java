package com.javarush.task.task33.task3309;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.ByteArrayInputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.sql.DriverManager;

/* 
Комментарий внутри xml
*/

public class Solution {
    public static String toXmlWithComment(Object obj, String tagName, String comment) throws JAXBException {
        StringWriter writer = new StringWriter();
        JAXBContext context = JAXBContext.newInstance(obj.getClass());
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(obj, writer);

        List<String> list = new ArrayList<>();
        list.addAll(Arrays.asList(writer.toString().split("\n")));
        List<String> copy = new ArrayList<>(list);

        for (int i = 0; i < copy.size(); i++) {
            if (copy.get(i).contains(tagName) && !copy.get(i + 1).contains(tagName))
                list.add(i - 1, "\t<!--" + comment + "-->");
            else if (copy.get(i).contains(tagName) && copy.get(i + 1).contains(tagName))
                list.add(i + 1, "\t<!--" + comment + "-->");
        }

//        for (String el : copy) {
//            System.out.println(el);
//        }
//
//        for (String el : list) {
//            System.out.println(el);
//        }

        for (String str : list) {
            System.out.println(str);
        }

        return list.toString();
    }

    public static void main(String[] args) throws JAXBException {
        Dog dog = new Dog();
        dog.age = 8;
        dog.first = "someData";
        dog.second = new String[]{"commentedData1", "commentedData2"};
        dog.etc = 'C';

        String result = toXmlWithComment(dog, "second", "COMMENT");
    }

    @XmlRootElement
    @XmlType(name = "dog")
    public static class Dog {
        public int age;
        public String first;
        public String[] second;
        public char etc;
    }
}
