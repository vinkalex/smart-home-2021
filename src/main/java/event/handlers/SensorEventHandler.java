package event.handlers;

import sensor.events.SensorEvent;
import smarthome.SmartHome;

public interface SensorEventHandler {
    //обработка сценариев событий
    void handleEvent(SmartHome smartHome, SensorEvent event);
}
