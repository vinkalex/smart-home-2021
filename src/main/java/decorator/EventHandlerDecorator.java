package decorator;

import sensor.events.Event;

public interface EventHandlerDecorator {
    void handleEvent(Event event);
}
