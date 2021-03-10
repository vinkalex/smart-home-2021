package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.SensorEventType.DOOR_OPEN;

public class DoDoorEvent implements DoSensorEvent {
    private final SmartHome smartHome;

    public DoDoorEvent(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    //модификация дома по событию с дверьми
    @Override
    public void doSensorEvent(SensorEvent event) {
        for (Room room : this.smartHome.getRooms()) {
            for (Door door : room.getDoors()) {
                if (door.getId().equals(event.getObjectId())) {
                    if (event.getType() == DOOR_OPEN) {
                        openTheDoor(door);
                        System.out.println("Door " + door.getId() + " in room " + room.getName() + " was opened.");
                    } else {
                        closeTheDoor(door);
                        System.out.println("Door " + door.getId() + " in room " + room.getName() + " was closed.");
                        if (room.getName().equals("hall")) {
                            turnOffAllLights();
                        }
                    }
                }
            }
        }
    }

    private void closeTheDoor(Door door) {
        door.setOpen(false);
    }

    private void openTheDoor(Door door) {
        door.setOpen(true);
    }

    private void turnOffAllLights() {
        for (Room homeRoom : this.smartHome.getRooms()) {
            for (Light light : homeRoom.getLights()) {
                light.setOn(false);
                SensorCommand command = new SensorCommand(CommandType.LIGHT_OFF, light.getId());
                CommandSender sender = new CommandSender();
                sender.sendCommand(command);
            }
        }
    }
}
