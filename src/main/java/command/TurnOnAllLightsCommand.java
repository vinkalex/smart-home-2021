package command;

import decorator.EventHandlerDecorator;
import sensor.events.EventType;
import sensor.events.SensorEvent;

public class TurnOnAllLightsCommand implements Command{
    private final EventHandlerDecorator eventHandlerDecorator;

    public TurnOnAllLightsCommand(EventHandlerDecorator eventHandlerDecorator) {
        this.eventHandlerDecorator = eventHandlerDecorator;
    }

    @Override
    public void execute() {
        this.eventHandlerDecorator.handleEvent(new SensorEvent(EventType.LIGHT_ON, null));
    }
}
