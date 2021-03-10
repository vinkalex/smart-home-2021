package ru.sbt.mipt.oop;

public interface EventCreator {
    //интерфейс для генерации событий
    public SensorEvent getNextSensorEvent();
}
