package event.loop.processor;

import sensor.events.Event;

public interface EventQueue {
    //интерфейс для генерации событий
    Event getNextEvent();
}
