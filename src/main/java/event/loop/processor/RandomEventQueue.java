package event.loop.processor;

import sensor.events.Event;
import sensor.events.SensorEvent;
import sensor.events.EventType;
import sensor.events.SignalizationEvent;

public class RandomEventQueue implements EventQueue {
    //главная реализация генератора событий
    @Override
    public Event getNextEvent() {
        // pretend like we're getting the events from physical world, but here we're going to just generate some random events
        if (Math.random() < 0.05) return null; // null means end of event stream
        if (Math.random() < 0.8) {
            return getNextSensorEvent();
        } else return getNextSignalizationEvent();
    }

    private SensorEvent getNextSensorEvent() {
        EventType sensorEventType = EventType.values()[(int) (4 * Math.random())];
        String objectId = "";
        if (sensorEventType.equals(EventType.LIGHT_ON) || sensorEventType.equals((EventType.LIGHT_OFF))) {
            objectId += ((int) (9 * Math.random()));
        } else objectId += ((int) (4 * Math.random()));
        return new SensorEvent(sensorEventType, objectId);
    }

    private SignalizationEvent getNextSignalizationEvent() {
        EventType eventType = EventType.values()[(int) (4 + 2 * Math.random())];
        if (Math.random() < 0.8) {
            return new SignalizationEvent(eventType, "aba");
        }
        else {
            return new SignalizationEvent(eventType, "abacaba");
        }

    }
}
