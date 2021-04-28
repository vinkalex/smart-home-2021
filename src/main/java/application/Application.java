package application;

import event.handlers.*;
import event.loop.processor.EventLoopProcessor;
import readers.SmartHomeDeserializerFromString;
import readers.SmartHomeReaderFromFile;
import smarthome.SmartHome;

import java.util.Arrays;
import java.util.Collection;

public class Application {

    public static void main(String... args) {
        // считываем состояние дома из файла
        SmartHomeReaderFromFile reader = new SmartHomeReaderFromFile("smart-home-1.js");
        SmartHomeDeserializerFromString deserializer = new SmartHomeDeserializerFromString(reader.convertToString());
        SmartHome smartHome = deserializer.createSmartHome();

        //создаем список обработчиков
        Collection<EventHandler> eventHandlers = Arrays.asList(new DoorSensorEventHandler(),
                new LightSensorEventHandler(), new HallDoorEventHandler(), new SignalizationEventHandler());

        // запускаем цикл обработки событий
        EventLoopProcessor eventLoop = new EventLoopProcessor(smartHome, eventHandlers);
        eventLoop.run();
    }
}
