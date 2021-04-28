package smarthome;

import action.Action;
import action.Actionable;
import signalization.Signalization;

import java.util.ArrayList;
import java.util.Collection;

public class SmartHome implements Actionable {
    private Signalization signalization;

    Collection<Room> rooms;

    public SmartHome() {
        this.signalization = new Signalization();
        this.rooms = new ArrayList<>();
    }

    public SmartHome(Collection<Room> rooms) {
        this.rooms = rooms;
    }

    public Signalization getSignalization() {
        return this.signalization;
    }

    public void handle(Action action) {
        action.doAction(this);

        for(Room room : rooms)
            room.handle(action);
    }
}
