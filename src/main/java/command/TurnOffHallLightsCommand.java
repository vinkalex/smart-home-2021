package command;

import decorator.EventHandlerDecorator;
import sensor.events.EventType;
import sensor.events.SensorEvent;

import java.util.ArrayList;

public class TurnOffHallLightsCommand implements Command{
    private final EventHandlerDecorator eventHandlerDecorator;
    private final ArrayList<String> lights_Id;

    public TurnOffHallLightsCommand(EventHandlerDecorator eventHandlerDecorator, ArrayList<String> lights_Id) {
        this.lights_Id = lights_Id;
        this.eventHandlerDecorator = eventHandlerDecorator;
    }

    @Override
    public void execute() {
        for (String light : lights_Id) {
            this.eventHandlerDecorator.handleEvent(new SensorEvent(EventType.LIGHT_OFF, light));
        }
    }
}
