package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.*;

public class ImageReaderFactory {
    public static ImageReader getImageReader(ImageTypes type) {
        ImageReader result;

        if (type == null)
            throw new IllegalArgumentException("Неизвестный тип картинки");

        switch (type) {
            case BMP:
                result = new BmpReader();
                break;
            case JPG:
                result = new JpgReader();
                break;
            case PNG:
                result = new PngReader();
                break;
            default:
                throw new IllegalArgumentException("Неизвестный тип картинки");
        }

        return result;
    }
}
