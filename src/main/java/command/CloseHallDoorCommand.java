package command;

import decorator.EventHandlerDecorator;
import sensor.events.EventType;
import sensor.events.SensorEvent;

public class CloseHallDoorCommand implements Command{
    private final EventHandlerDecorator eventHandlerDecorator;
    private final String doorId;

    public CloseHallDoorCommand(EventHandlerDecorator eventHandlerDecorator, String doorId) {
        this.eventHandlerDecorator = eventHandlerDecorator;
        this.doorId = doorId;
    }

    @Override
    public void execute() {
        this.eventHandlerDecorator.handleEvent(new SensorEvent(EventType.DOOR_CLOSED, doorId)); }
}
