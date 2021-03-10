package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.SensorEventType.*;
import static ru.sbt.mipt.oop.SensorEventType.DOOR_CLOSED;

public class EventLoopProcessor {
    private final SmartHome smarthome;
    private final EventCreator eventCreator = new EventCreatorImpl();

    public EventLoopProcessor(SmartHome smartHome) {
        this.smarthome = smartHome;
    }

    public void run() {
        //запускаем главный цикл обработки событий, делегируем по сценариям
        SensorEvent event = this.eventCreator.getNextSensorEvent();
        while (event != null) {
            System.out.println("Got event: " + event);
            if (isLightEvent(event)) {
                EventHandler handler = new LightEventHandler();
                handler.handleSensorEvent(this.smarthome, event);
            }
            if (isDoorEvent(event)) {
                EventHandler handler = new DoorEventHandler();
                handler.handleSensorEvent(this.smarthome, event);
            }
            event = this.eventCreator.getNextSensorEvent();
        }
    }

    private boolean isLightEvent(SensorEvent event) {
        return event.getType() == LIGHT_ON || event.getType() == LIGHT_OFF;
    }

    private boolean isDoorEvent(SensorEvent event) {
        return event.getType() == DOOR_OPEN || event.getType() == DOOR_CLOSED;
    }
}