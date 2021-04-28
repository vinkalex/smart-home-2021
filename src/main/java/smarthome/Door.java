package smarthome;

import action.Action;
import action.Actionable;

public class Door implements Actionable {
    private final String id;
    private boolean isOpen;

    public Door(boolean isOpen, String id) {
        this.isOpen = isOpen;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public boolean isOpen() {
        return this.isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    @Override
    public void handle(Action action) {
        action.doAction(this);
    }
}
