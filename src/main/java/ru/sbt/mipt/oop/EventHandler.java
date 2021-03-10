package ru.sbt.mipt.oop;

public interface EventHandler {
    //обработка сценариев событий
    public void handleSensorEvent(SmartHome smartHome, SensorEvent event);
}
