package ru.sbt.mipt.oop;

import java.util.Collection;

public class EventLoopProcessor {
    private final SmartHome smartHome;
    private final SensorEventQueue eventQueue;
    private final Collection<SensorEventHandler> eventHandlers;

    public EventLoopProcessor(SmartHome smartHome, Collection<SensorEventHandler> eventHandlers) {
        this.smartHome = smartHome;
        this.eventQueue = new RandomSensorEventQueue();
        this.eventHandlers = eventHandlers;
    }

    public void run() {
        //запускаем главный цикл обработки событий, делегируем по сценариям
        SensorEvent event = this.eventQueue.getNextSensorEvent();
        while (event != null) {
            System.out.println("Got event: " + event);
            this.handleSensorEvent(event);
            event = this.eventQueue.getNextSensorEvent();
        }
    }

    private void handleSensorEvent(SensorEvent event) {
        for (SensorEventHandler eventHandler: eventHandlers) {
            eventHandler.handleEvent(this.smartHome, event);
        }
    }

}