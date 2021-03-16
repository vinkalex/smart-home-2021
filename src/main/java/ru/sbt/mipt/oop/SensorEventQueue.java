package ru.sbt.mipt.oop;

public interface SensorEventQueue {
    //интерфейс для генерации событий
    SensorEvent getNextSensorEvent();
}
