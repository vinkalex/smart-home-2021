package event.handlers;

import sensor.events.Event;
import sensor.events.EventType;
import sensor.events.SignalizationEvent;
import signalization.Signalization;
import smarthome.SmartHome;

public class SignalizationEventHandler implements EventHandler {
    @Override
    public void handleEvent(SmartHome smartHome, Event event) {
        if (isSignalizationEvent(event)) {
            changeSignalizationState(smartHome.getSignalization(), event);
        }
    }

    private void changeSignalizationState(Signalization signalization, Event event) {
        if (event.getType().equals(EventType.ALARM_ACTIVATE)) {
            signalization.activate(((SignalizationEvent)event).getCode());
        }
        if (event.getType().equals(EventType.ALARM_DEACTIVATE)) {
            signalization.deactivate(((SignalizationEvent)event).getCode());
        }
    }

    private boolean isSignalizationEvent(Event event) {
        return (event.getType().equals(EventType.ALARM_ACTIVATE))
                || (event.getType().equals(EventType.ALARM_DEACTIVATE));
    }
}
