package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.SensorEventType.LIGHT_ON;

public class DoLightEvent implements DoSensorEvent {
    private final SmartHome smartHome;

    public DoLightEvent(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    //модификация дома по событию со светом
    @Override
    public void doSensorEvent(SensorEvent event) {
        for (Room room : this.smartHome.getRooms()) {
            for (Light light : room.getLights()) {
                if (light.getId().equals(event.getObjectId())) {
                    if (event.getType() == LIGHT_ON) {
                        turnOnLight(light);
                        System.out.println("Light " + light.getId() + " in room " + room.getName() + " was turned on.");
                    } else {
                        turnOffLight(light);
                        System.out.println("Light " + light.getId() + " in room " + room.getName() + " was turned off.");
                    }
                }
            }
        }
    }

    private void turnOnLight(Light light) {
        light.setOn(true);
    }

    private void turnOffLight(Light light) {
        light.setOn(false);
    }
}