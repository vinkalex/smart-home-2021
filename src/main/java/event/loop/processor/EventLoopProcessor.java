package event.loop.processor;

import decorator.EventHandlerDecorator;
import decorator.SignalizationEventHandlerDecorator;
import event.handlers.EventHandler;
import message.sender.SmsSender;
import sensor.events.Event;
import smarthome.SmartHome;

import java.util.Collection;

public class EventLoopProcessor {
    private final SmartHome smartHome;
    private final EventQueue eventQueue;
    private final Collection<EventHandler> eventHandlers;

    public EventLoopProcessor(SmartHome smartHome, Collection<EventHandler> eventHandlers) {
        this.smartHome = smartHome;
        this.eventQueue = new RandomEventQueue();
        this.eventHandlers = eventHandlers;
    }

    public void run() {
        //запускаем главный цикл обработки событий, делегируем по сценариям
        Event event = this.eventQueue.getNextEvent();
        while (event != null) {
            System.out.println("Got event: " + event);
            this.handleAnyEvent(event);
            event = this.eventQueue.getNextEvent();
        }
    }

    private void handleAnyEvent(Event event) {
        for (EventHandler eventHandler: eventHandlers) {
            EventHandlerDecorator decorator = new SignalizationEventHandlerDecorator(this.smartHome.getSignalization(), eventHandler, new SmsSender());
            decorator.handleEvent(event);
        }
    }

}