package event.loop.processor;

import sensor.events.SensorEvent;

public interface SensorEventQueue {
    //интерфейс для генерации событий
    SensorEvent getNextSensorEvent();
}
