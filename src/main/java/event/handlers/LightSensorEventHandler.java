package event.handlers;

import action.Action;
import sensor.events.Event;
import sensor.events.SensorEvent;
import sensor.events.EventType;
import smarthome.Light;
import smarthome.SmartHome;

public class LightSensorEventHandler implements EventHandler {
    @Override
    public void handleEvent(SmartHome smartHome, Event event) {
        if (isLightEvent(event)) {
            changeLightState(smartHome, event);
        }
    }

    private void changeLightState(SmartHome smartHome, Event event) {
        Action lightAction = (obj) -> {
            if (obj instanceof Light && ((Light) obj).getId().equals(((SensorEvent)event).getObjectId()))
                updateLightState(event, (Light) obj);
        };

        smartHome.handle(lightAction);
    }


    private void updateLightState(Event event, Light light) {
        boolean newState = event.getType().equals(EventType.LIGHT_ON);
        light.setOn(newState);
        System.out.println("Light " + light.getId() + " was turned " + (newState ? " on." : " off."));
    }

    private boolean isLightEvent(Event event) {
        return (event.getType().equals(EventType.LIGHT_ON) || (event.getType().equals(EventType.LIGHT_OFF)));
    }
}
