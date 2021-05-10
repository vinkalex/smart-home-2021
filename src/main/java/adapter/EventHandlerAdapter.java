package adapter;

import com.coolcompany.smarthome.events.CCSensorEvent;
import com.coolcompany.smarthome.events.EventHandler;
import sensor.events.EventType;
import sensor.events.SensorEvent;

import java.util.Map;

public class EventHandlerAdapter implements EventHandler {
    private final event.handlers.EventHandler eventHandler;
    private final Map<String, EventType> stringToEvent;

    public EventHandlerAdapter(event.handlers.EventHandler eventHandler, Map<String, EventType> stringToEvent) {
        this.eventHandler = eventHandler;
        this.stringToEvent = stringToEvent;
    }

    @Override
    public void handleEvent(CCSensorEvent event) {
        EventType type = this.stringToEvent.get(event.getEventType());
        String objectId = event.getObjectId();
        this.eventHandler.handleEvent(new SensorEvent(type, objectId));
    }
}
