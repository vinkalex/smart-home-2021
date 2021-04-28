package smarthome;

import action.Action;
import action.Actionable;

import java.util.Collection;

public class Room implements Actionable {
    private Collection<Light> lights;
    private Collection<Door> doors;
    private String name;

    public Room(Collection<Light> lights, Collection<Door> doors, String name) {
        this.lights = lights;
        this.doors = doors;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean doorExists(String objectId) {
        for (Door door: doors) {
            if (door.getId().equals(objectId)) {
                return true;
            }
        }
        return false;
    }

    public void handle(Action action) {
        action.doAction(this);

        for(Light light : lights)
            light.handle(action);

        for (Door door : doors)
            door.handle(action);
    }
}
