package com.javarush.task.task32.task3212;

import com.javarush.task.task32.task3212.service.Service;

import java.util.Arrays;
import java.util.List;
// import com.fasterxml.jackson.core.*;        // manual import and add to classpath with popup

/* 
Service Locator
*/


public class Solution {
    public static void main(String[] args) {
        Service service = ServiceLocator.getService("EJBService");
        service.execute();
        System.out.println();
        service = ServiceLocator.getService("JMSService");

        List m = Arrays.asList(1,3,18, 45,'c', "roma", null); // дичь немного
        System.out.println(m.toString());

        service.execute();
        System.out.println();
        service = ServiceLocator.getService("EJBService");
        service.execute();
        System.out.println();
        service = ServiceLocator.getService("JMSService");
        service.execute();
    }
}
