package smarthome;

import action.Action;
import action.Actionable;

import java.util.ArrayList;
import java.util.Collection;

public class SmartHome implements Actionable {
    Collection<Room> rooms;

    public SmartHome() {
        rooms = new ArrayList<>();
    }

    public SmartHome(Collection<Room> rooms) {
        this.rooms = rooms;
    }

    public void handle(Action action) {
        action.doAction(this);

        for(Room room : rooms)
            room.handle(action);
    }

}
