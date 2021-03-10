package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.SensorEventType.DOOR_OPEN;

public class DoorEventHandler implements EventHandler {
    //обработка событий с дверями - делегация модификации другому классу
    @Override
    public void handleSensorEvent(SmartHome smartHome, SensorEvent event) {
        DoDoorEvent handler = new DoDoorEvent(smartHome);
        handler.doSensorEvent(event);
    }
}
