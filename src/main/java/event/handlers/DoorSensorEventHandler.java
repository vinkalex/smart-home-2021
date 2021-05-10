package event.handlers;

import action.Action;
import sensor.events.Event;
import sensor.events.SensorEvent;
import sensor.events.EventType;
import smarthome.Door;
import smarthome.SmartHome;

public class DoorSensorEventHandler implements EventHandler {
    private final SmartHome smartHome;

    public DoorSensorEventHandler(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void handleEvent(Event event) {
        if (isDoorEvent(event)) {
            changeDoorState(event);
        }
    }

    private void changeDoorState(Event event) {
        Action doorAction = (obj)->{
            if(obj instanceof Door && ((Door) obj).getId().equals(((SensorEvent)event).getObjectId()))
                updateDoorState(event, (Door) obj);
        };
        smartHome.handle(doorAction);
    }

    private void updateDoorState(Event event, Door door) {
        boolean newState = event.getType().equals(EventType.DOOR_OPEN);
        door.setOpen(newState);
        System.out.println("Door " + door.getId() + " was " + (newState ? " opened." : " closed."));
    }

    private boolean isDoorEvent(Event event) {
        return(event.getType().equals(EventType.DOOR_OPEN) || (event.getType().equals(EventType.DOOR_CLOSED)));
    }
}
