package ru.sbt.mipt.oop;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class LightSensorEventHandlerTest {
    @Test
    public void testChangingLightState() {
        Room kitchen = new Room(Arrays.asList(new Light("1", false), new Light("2", true)),
                Arrays.asList(new Door(false, "1")),
                "kitchen");
        SmartHome smartHome = new SmartHome(Arrays.asList(kitchen));
        SensorEvent event = new SensorEvent(SensorEventType.LIGHT_ON, "1");
        SensorEventHandler handler = new LightSensorEventHandler();
        handler.handleEvent(smartHome, event);

        assertTrue(kitchen.getLight("1").isOn());
    }

    @Test
    public void testRemainingLightState() {
        Room kitchen = new Room(Arrays.asList(new Light("1", true), new Light("2", true)),
                Arrays.asList(new Door(true, "1")),
                "kitchen");
        SmartHome smartHome = new SmartHome(Arrays.asList(kitchen));
        SensorEvent event = new SensorEvent(SensorEventType.LIGHT_ON, "1");
        SensorEventHandler handler = new LightSensorEventHandler();
        handler.handleEvent(smartHome, event);

        assertTrue(kitchen.getLight("1").isOn());
    }
}