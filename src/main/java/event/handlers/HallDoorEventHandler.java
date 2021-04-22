package event.handlers;

import action.Action;
import command.CommandSender;
import command.CommandType;
import command.SensorCommand;
import sensor.events.SensorEvent;
import sensor.events.SensorEventType;
import smarthome.Light;
import smarthome.Room;
import smarthome.SmartHome;

public class HallDoorEventHandler implements SensorEventHandler {
    @Override
    public void handleEvent(SmartHome smartHome, SensorEvent event) {
        if (isHallDoorEvent(smartHome, event)) {
            changeDoorAndLightState(smartHome, event);
        }
    }

    public void changeDoorAndLightState(SmartHome smartHome, SensorEvent event) {
        Action turnOff = (obj) -> {
            if (obj instanceof Light)
                updateLightState(event, (Light) obj);
        };

        Action findDoorAndTurnOffAllLights = (obj) -> {
            if (obj instanceof Room && ((Room) obj).getName().equals("hall")) {
                smartHome.handle(turnOff);
            }
        };

        smartHome.handle(findDoorAndTurnOffAllLights);
    }

    private void updateLightState(SensorEvent event, Light light) {
        boolean newState = event.getType().equals(SensorEventType.LIGHT_ON);
        light.setOn(newState);
        SensorCommand command = new SensorCommand(CommandType.LIGHT_OFF, light.getId());
        CommandSender sender = new CommandSender();
        sender.sendCommand(command);
    }

    private boolean isHallDoorEvent(SmartHome smartHome, SensorEvent event) {
        return (event.getType().equals(SensorEventType.DOOR_CLOSED));
    }
}
