package ru.sbt.mipt.oop;

import org.junit.jupiter.api.Test;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class DoorSensorEventHandlerTest {
    @Test
    public void testChangingDoorState() {
        Room kitchen = new Room(Arrays.asList(new Light("1", false), new Light("2", true)),
                Arrays.asList(new Door(false, "1")),
                "kitchen");
        SmartHome smartHome = new SmartHome(Arrays.asList(kitchen));
        SensorEvent event = new SensorEvent(SensorEventType.DOOR_OPEN, "1");
        SensorEventHandler handler = new DoorSensorEventHandler();
        handler.handleEvent(smartHome, event);

        assertTrue(kitchen.getDoor("1").isOpen());
    }

    @Test
    public void testRemainingDoorState() {
        Room kitchen = new Room(Arrays.asList(new Light("1", false), new Light("2", true)),
                Arrays.asList(new Door(true, "1")),
                "kitchen");
        SmartHome smartHome = new SmartHome(Arrays.asList(kitchen));
        SensorEvent event = new SensorEvent(SensorEventType.DOOR_OPEN, "1");
        SensorEventHandler handler = new DoorSensorEventHandler();
        handler.handleEvent(smartHome, event);

        assertTrue(kitchen.getDoor("1").isOpen());
    }
}