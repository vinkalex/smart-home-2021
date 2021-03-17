package ru.sbt.mipt.oop;

public class LightSensorEventHandler implements SensorEventHandler {
    @Override
    public void handleEvent(SmartHome smartHome, SensorEvent event) {
        if (isLightEvent(event)) {
            changeLightState(smartHome, event);
        }
    }

    private void changeLightState(SmartHome smartHome, SensorEvent event) {
        Action lightAction = (obj) -> {
            if (obj instanceof Light && ((Light) obj).getId().equals(event.getObjectId()))
                updateLightState(event, (Light) obj);
        };

        smartHome.handle(lightAction);
    }


    private void updateLightState(SensorEvent event, Light light) {
        boolean newState = event.getType().equals(SensorEventType.LIGHT_ON);
        light.setOn(newState);
        System.out.println("Light " + light.getId() + " was turned " + (newState ? " on." : " off."));
    }

    private boolean isLightEvent(SensorEvent event) {
        return (event.getType().equals(SensorEventType.LIGHT_ON) || (event.getType().equals(SensorEventType.LIGHT_OFF)));
    }
}
