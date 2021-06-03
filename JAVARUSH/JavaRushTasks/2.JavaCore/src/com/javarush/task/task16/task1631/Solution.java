package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.ImageReader;
import com.javarush.task.task16.task1631.common.ImageTypes;

/* 
Factory method pattern
*/

public class Solution {
    public static void main(String[] args) {
        ImageReader reader;
        reader = ImageReaderFactory.getImageReader(ImageTypes.JPG);
        reader.read();
        reader = ImageReaderFactory.getImageReader(ImageTypes.PNG);
        reader.read();
        reader = ImageReaderFactory.getImageReader(ImageTypes.BMP);
        reader.read();
        reader = ImageReaderFactory.getImageReader(null);
    }
}
