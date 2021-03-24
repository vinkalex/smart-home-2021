package ru.sbt.mipt.oop;

import java.util.ArrayList;
import java.util.Collection;

public class SmartHome implements Actionable{
    Collection<Room> rooms;

    public SmartHome() {
        rooms = new ArrayList<>();
    }

    public SmartHome(Collection<Room> rooms) {
        this.rooms = rooms;
    }

    public boolean isAllLightsOff() {
        for (Room room: rooms) {
            if (!room.allLightsOff()) {
                return false;
            }
        }
        return true;
    }

    public void handle(Action action) {
        action.doAction(this);

        for(Room room : rooms)
            room.handle(action);
    }

}
