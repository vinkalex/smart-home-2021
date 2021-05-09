package adapter;

import com.coolcompany.smarthome.events.CCSensorEvent;
import com.coolcompany.smarthome.events.EventHandler;
import sensor.events.EventType;
import sensor.events.SensorEvent;

import java.util.HashMap;
import java.util.Map;

public class EventHandlerAdapter implements EventHandler {
    private final event.handlers.EventHandler eventHandler;
    private final Map<String, EventType> stringToEvent = new HashMap<String, EventType>();

    public EventHandlerAdapter(event.handlers.EventHandler eventHandler) {
        this.eventHandler = eventHandler;
        this.stringToEvent.put("LightIsOn", EventType.LIGHT_ON);
        this.stringToEvent.put("LightIsOff", EventType.LIGHT_OFF);
        this.stringToEvent.put("DoorIsOpen", EventType.DOOR_OPEN);
        this.stringToEvent.put("DoorIsClosed", EventType.DOOR_CLOSED);
        this.stringToEvent.put("DoorIsLocked", EventType.DOOR_LOCKED);
        this.stringToEvent.put("DoorIsUnlocked", EventType.DOOR_UNLOCKED);
    }

    @Override
    public void handleEvent(CCSensorEvent event) {
        EventType type = this.stringToEvent.get(event.getEventType());
        String objectId = event.getObjectId();
        this.eventHandler.handleEvent(new SensorEvent(type, objectId));
    }
}
