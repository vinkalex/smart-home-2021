package ru.sbt.mipt.oop;

public class DoorSensorEventHandler implements SensorEventHandler {
    @Override
    public void handleEvent(SmartHome smartHome, SensorEvent event) {
        if (isDoorEvent(event)) {
            changeDoorState(smartHome, event);
        }
    }

    private void changeDoorState(SmartHome smartHome, SensorEvent event) {
        Door door = HomeUtils.findDoor(smartHome, event.getObjectId());
        if (door != null) {
            updateDoorState(event, door);
        }
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
