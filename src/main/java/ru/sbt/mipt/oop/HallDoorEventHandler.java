package ru.sbt.mipt.oop;

public class HallDoorEventHandler implements SensorEventHandler {
    @Override
    public void handleEvent(SmartHome smartHome, SensorEvent event) {
        if (isHallDoorEvent(smartHome, event)) {
            changeDoorAndLightState(smartHome, event);
        }
    }

    public void changeDoorAndLightState(SmartHome smartHome, SensorEvent event) {
        Door door = HomeUtils.findDoor(smartHome, event.getObjectId());
        if (door != null) {
            closeTheDoor(door);
            turnOffAllLights(smartHome);
        }
    }

    private void closeTheDoor(Door door) {
        door.setOpen(false);
        System.out.println("Door " + door.getId() + " was " +  " closed.");
    }

    private void turnOffAllLights(SmartHome smartHome) {
        for (Room room : smartHome.getRooms()) {
            for (Light light : room.getLights()) {
                light.setOn(false);
                SensorCommand command = new SensorCommand(CommandType.LIGHT_OFF, light.getId());
                CommandSender sender = new CommandSender();
                sender.sendCommand(command);
            }
        }
    }

    private boolean isHallDoorEvent(SmartHome smartHome, SensorEvent event) {
        return (event.getType().equals(SensorEventType.DOOR_CLOSED))
                && (HomeUtils.isHallDoor(smartHome, event.getObjectId()));
    }

}
