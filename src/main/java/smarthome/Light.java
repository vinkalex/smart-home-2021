package smarthome;

import action.Action;
import action.Actionable;

public class Light implements Actionable {
    private boolean isOn;
    private final String id;

    public Light(String id, boolean isOn) {
        this.id = id;
        this.isOn = isOn;
    }

    public String getId() {
        return id;
    }

    public boolean isOn() {
        return this.isOn;
    }

    public void setOn(boolean on) {
        isOn = on;
    }

    @Override
    public void handle(Action action) {
        action.doAction(this);
    }
}