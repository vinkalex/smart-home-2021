package application;

import adapter.EventHandlerAdapter;
import com.coolcompany.smarthome.events.SensorEventsManager;
import decorator.SignalizationEventHandlerDecorator;
import event.handlers.DoorSensorEventHandler;
import event.handlers.EventHandler;
import event.handlers.HallDoorEventHandler;
import event.handlers.LightSensorEventHandler;
import message.sender.SmsSender;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import readers.SmartHomeDeserializerFromString;
import readers.SmartHomeReaderFromFile;
import sensor.events.EventType;
import signalization.Signalization;
import smarthome.SmartHome;

import java.util.ArrayList;
import java.util.Map;

@Configuration
public class ApplicationConfiguration {
    @Bean
    SmartHome smartHome() {
        return new SmartHomeDeserializerFromString(new SmartHomeReaderFromFile("smart-home-1.js").convertToString()).createSmartHome();
    }

    @Bean
    Signalization signalization() {
        return new Signalization();
    }

    @Bean
    Map<String, EventType> stringToEvent() {
        return Map.of(
                "LightIsOn", EventType.LIGHT_ON,
                "LightIsOff", EventType.LIGHT_OFF,
                "DoorIsOpen", EventType.DOOR_OPEN,
                "DoorIsClosed", EventType.DOOR_CLOSED,
                "DoorIsLocked", EventType.DOOR_LOCKED,
                "DoorIsUnlocked", EventType.DOOR_UNLOCKED
        );
    }

    @Bean
    com.coolcompany.smarthome.events.EventHandler lightEventHandler() {
        return new EventHandlerAdapter((EventHandler) new SignalizationEventHandlerDecorator(signalization(),
                new LightSensorEventHandler(smartHome()), new SmsSender()), stringToEvent());
    }

    @Bean
    com.coolcompany.smarthome.events.EventHandler doorEventHandler() {
        return new EventHandlerAdapter((EventHandler) new SignalizationEventHandlerDecorator(signalization(),
                new DoorSensorEventHandler(smartHome()), new SmsSender()), stringToEvent());
    }

    @Bean
    com.coolcompany.smarthome.events.EventHandler hallDoorEventHandler() {
        return new EventHandlerAdapter((EventHandler) new SignalizationEventHandlerDecorator(signalization(),
                new HallDoorEventHandler(smartHome()), new SmsSender()), stringToEvent());
    }

    @Bean
    SensorEventsManager sensorEventsManager(ArrayList<com.coolcompany.smarthome.events.EventHandler> eventHandlers) {
        SensorEventsManager sensorEventsManager = new SensorEventsManager();
        for (com.coolcompany.smarthome.events.EventHandler eventHandler : eventHandlers) {
            sensorEventsManager.registerEventHandler(eventHandler);
        }
        return sensorEventsManager;
    }

}
