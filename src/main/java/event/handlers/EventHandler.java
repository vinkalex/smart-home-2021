package event.handlers;

import sensor.events.Event;
import smarthome.SmartHome;

public interface EventHandler {
    //обработка сценариев событий
    void handleEvent(Event event);
}
