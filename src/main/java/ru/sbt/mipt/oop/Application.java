package ru.sbt.mipt.oop;

import java.io.IOException;

public class Application {

    public static void main(String... args) throws IOException {
        // считываем состояние дома из файла
        HomeReaderFromFile reader = new HomeReaderFromFile("smart-home-1.js");
        SmartHome smartHome = reader.createSmartHome();
        // запускаем цикл обработки событий
        EventLoopProcessor processor = new EventLoopProcessor(smartHome);
        processor.run();
    }
}
