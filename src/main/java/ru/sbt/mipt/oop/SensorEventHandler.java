package ru.sbt.mipt.oop;

public interface SensorEventHandler {
    //обработка сценариев событий
    void handleEvent(SmartHome smartHome, SensorEvent event);
}
