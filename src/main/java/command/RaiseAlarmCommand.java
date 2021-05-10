package command;

import decorator.EventHandlerDecorator;
import sensor.events.EventType;
import sensor.events.SignalizationEvent;

public class RaiseAlarmCommand implements Command{
    private final EventHandlerDecorator eventHandlerDecorator;

    public RaiseAlarmCommand(EventHandlerDecorator eventHandlerDecorator) {
        this.eventHandlerDecorator = eventHandlerDecorator;
    }

    @Override
    public void execute() {
        this.eventHandlerDecorator.handleEvent(new SignalizationEvent(EventType.RAISE_ALARM, null));
    }
}
