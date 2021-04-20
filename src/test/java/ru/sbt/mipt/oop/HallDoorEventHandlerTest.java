package ru.sbt.mipt.oop;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class HallDoorEventHandlerTest {
    @Test
    public void testAllLightsOffAndDoorClosed() {
        Room hall = new Room(Arrays.asList(new Light("1", false), new Light("2", true)),
                Arrays.asList(new Door(false, "1")),
                "hall");
        Room bedroom = new Room(Arrays.asList(new Light("4", true), new Light("5", false), new Light("6", false)),
                Arrays.asList(new Door(true, "3")),
                "bedroom");
        SmartHome smartHome = new SmartHome(Arrays.asList(hall, bedroom));
        SensorEvent event = new SensorEvent(SensorEventType.DOOR_CLOSED, "1");
        SensorEventHandler handler = new HallDoorEventHandler();
        handler.handleEvent(smartHome, event);

        assertTrue(smartHome.isAllLightsOff());

        assertFalse(hall.isDoorOpen("1"));
    }

    @Test
    public void testDoNotHandleDoorExceptForHallDoor() {
        Room hall = new Room(Arrays.asList(new Light("1", false), new Light("2", true)),
                Arrays.asList(new Door(false, "1")),
                "hall");
        Room bedroom = new Room(Arrays.asList(new Light("4", true), new Light("5", false), new Light("6", false)),
                Arrays.asList(new Door(true, "3")),
                "bedroom");
        SmartHome smartHome = new SmartHome(Arrays.asList(hall, bedroom));
        SensorEvent event = new SensorEvent(SensorEventType.DOOR_CLOSED, "3");

        SensorEventHandler handler = new HallDoorEventHandler();
        handler.handleEvent(smartHome, event);

        assertTrue(bedroom.isDoorOpen("3"));
    }
}