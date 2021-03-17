package ru.sbt.mipt.oop;

import java.util.Arrays;
import java.util.Collection;

public class Application {

    public static void main(String... args) {
        // считываем состояние дома из файла
        SmartHomeReaderFromFile reader = new SmartHomeReaderFromFile("smart-home-1.js");
        SmartHomeDeserializerFromString deserializer = new SmartHomeDeserializerFromString(reader.convertToString());
        SmartHome smartHome = deserializer.createSmartHome();

        //создаем список обработчиков
        Collection<SensorEventHandler> eventHandlers = Arrays.asList(new DoorSensorEventHandler(),
                new LightSensorEventHandler(), new HallDoorEventHandler());

        // запускаем цикл обработки событий
        EventLoopProcessor eventLoop = new EventLoopProcessor(smartHome, eventHandlers);
        eventLoop.run();
    }
}
