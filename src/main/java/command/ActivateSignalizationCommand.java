package command;

import decorator.EventHandlerDecorator;
import sensor.events.EventType;
import sensor.events.SignalizationEvent;

public class ActivateSignalizationCommand implements Command {
    private final EventHandlerDecorator eventHandlerDecorator;
    private final String code;

    public ActivateSignalizationCommand(EventHandlerDecorator eventHandlerDecorator, String code) {
        this.code = code;
        this.eventHandlerDecorator = eventHandlerDecorator;
    }

    @Override
    public void execute() {
        this.eventHandlerDecorator.handleEvent(new SignalizationEvent(EventType.ALARM_ACTIVATE, this.code));
    }
}
