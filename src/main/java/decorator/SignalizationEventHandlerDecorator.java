package decorator;

import event.handlers.EventHandler;
import message.sender.SmsSender;
import sensor.events.Event;
import signalization.Signalization;
import smarthome.SmartHome;

public class SignalizationEventHandlerDecorator implements EventHandler {
    private final Signalization signalization;
    private final EventHandler eventHandler;
    private final SmsSender smsSender;

    public SignalizationEventHandlerDecorator(Signalization signalization, EventHandler eventHandler, SmsSender smsSender) {
        this.signalization = signalization;
        this.eventHandler = eventHandler;
        this.smsSender = smsSender;
    }

    @Override
    public void handleEvent(SmartHome smartHome, Event event) {
        if (this.signalization.isActivated()) {
            this.signalization.alarm();
        } else
        if (this.signalization.isAlarmed()) {
            this.smsSender.send("Sending sms!");
        } else {
            this.eventHandler.handleEvent(smartHome, event);
        }
    }
}
