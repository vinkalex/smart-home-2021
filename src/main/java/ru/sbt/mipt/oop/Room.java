package ru.sbt.mipt.oop;

import java.util.Collection;

public class Room implements Actionable{
    private Collection<Light> lights;
    private Collection<Door> doors;
    private String name;

    public Room(Collection<Light> lights, Collection<Door> doors, String name) {
        this.lights = lights;
        this.doors = doors;
        this.name = name;
    }

    public boolean isDoorOpen(String doorId) {
        for (Door door: doors) {
            if (door.getId().equals(doorId)) {
                return door.isOpen();
            }
        }
        return true;
    }

    public boolean isLightOn(String lightId) {
        for (Light light: lights) {
            if (light.getId().equals(lightId)) {
                return light.isOn();
            }
        }
        return true;
    }

    public boolean allLightsOff() {
        for (Light light: lights) {
            if (light.isOn()) {
                return false;
            }
        }
        return true;
    }

    public String getName() {
        return name;
    }

    public void handle(Action action) {
        action.doAction(this);

        for(Light light : lights)
            light.handle(action);

        for (Door door : doors)
            door.handle(action);
    }
}
