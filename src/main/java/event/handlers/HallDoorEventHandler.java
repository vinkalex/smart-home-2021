package event.handlers;

import action.Action;
import command.CommandSender;
import command.CommandType;
import command.SensorCommand;
import sensor.events.Event;
import sensor.events.EventType;
import sensor.events.SensorEvent;
import smarthome.Light;
import smarthome.Room;
import smarthome.SmartHome;

public class HallDoorEventHandler implements EventHandler {
    private final SmartHome smartHome;
    private boolean isHallDoor;

    public HallDoorEventHandler(SmartHome smartHome) {
        this.smartHome = smartHome;
        this.isHallDoor = false;
    }

    private void set(boolean value) {
        this.isHallDoor = value;
    }

    @Override
    public void handleEvent(Event event) {
        if (isHallDoorEvent(event)) {
            changeDoorAndLightState(event);
        }
    }

    public void changeDoorAndLightState(Event event) {
        Action turnOff = (obj) -> {
            if (obj instanceof Light)
                updateLightState(event, (Light) obj);
        };

        smartHome.handle(turnOff);
    }

    private void updateLightState(Event event, Light light) {
        boolean newState = event.getType().equals(EventType.LIGHT_ON);
        light.setOn(newState);
        SensorCommand command = new SensorCommand(CommandType.LIGHT_OFF, light.getId());
        CommandSender sender = new CommandSender();
        sender.sendCommand(command);
    }

    private boolean isHallDoorEvent(Event event) {
        Action isHallDoorAction = (obj) -> {
            if (obj instanceof Room && ((Room) obj).getName().equals("hall") &&
                    (((Room)obj).doorExists(((SensorEvent)event).getObjectId()))) {
                this.set(true);
            }
        };

        if (event.getType().equals(EventType.DOOR_CLOSED)) {
            smartHome.handle(isHallDoorAction);
            return this.isHallDoor;
        } else return false;
    }
}
