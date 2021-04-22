package event.handlers;

import action.Action;
import sensor.events.SensorEvent;
import sensor.events.SensorEventType;
import smarthome.Door;
import smarthome.SmartHome;

public class DoorSensorEventHandler implements SensorEventHandler {
    @Override
    public void handleEvent(SmartHome smartHome, SensorEvent event) {
        if (isDoorEvent(event)) {
            changeDoorState(smartHome, event);
        }
    }

    private void changeDoorState(SmartHome smartHome, SensorEvent event) {
        Action doorAction = (obj)->{
            if(obj instanceof Door && ((Door) obj).getId().equals(event.getObjectId()))
                updateDoorState(event, (Door) obj);
        };
        smartHome.handle(doorAction);
    }

    private void updateDoorState(SensorEvent event, Door door) {
        boolean newState = event.getType().equals(SensorEventType.DOOR_OPEN);
        door.setOpen(newState);
        System.out.println("Door " + door.getId() + " was " + (newState ? " opened." : " closed."));
    }

    private boolean isDoorEvent(SensorEvent event) {
        return(event.getType().equals(SensorEventType.DOOR_OPEN) || (event.getType().equals(SensorEventType.DOOR_CLOSED)));
    }
}
