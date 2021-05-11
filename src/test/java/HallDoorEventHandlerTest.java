import event.handlers.HallDoorEventHandler;
import event.handlers.EventHandler;
import org.junit.jupiter.api.Test;
import sensor.events.SensorEvent;
import sensor.events.EventType;
import smarthome.Door;
import smarthome.Light;
import smarthome.Room;
import smarthome.SmartHome;

import java.util.Arrays;

public class HallDoorEventHandlerTest {
    @Test
    public void testAllLightsOffAndDoorClosed() {
        Light light1 = new Light("1", false);
        Light light2 = new Light("2", true);
        Light light3 = new Light("3", true);
        Light light4 = new Light("4", false);
        Light light5 = new Light("5", false);
        Door door1 = new Door(false, "1");
        Door door2 = new Door(true, "2");
        Room hall = new Room(Arrays.asList(light1, light2),
                Arrays.asList(door1),
                "hall");
        Room bedroom = new Room(Arrays.asList(light3, light4, light5),
                Arrays.asList(door2),
                "bedroom");
        SmartHome smartHome = new SmartHome(Arrays.asList(hall, bedroom));
        SensorEvent event = new SensorEvent(EventType.DOOR_CLOSED, "1");
        EventHandler handler = new HallDoorEventHandler(smartHome);
        handler.handleEvent(event);

        assert(!light1.isOn());
        assert(!light2.isOn());
        assert(!light3.isOn());
        assert(!light4.isOn());
        assert(!light5.isOn());
        assert(!door1.isOpen());
    }

    @Test
    public void testDoNotHandleDoorExceptForHallDoor() {
        Light light1 = new Light("1", false);
        Light light2 = new Light("2", true);
        Light light3 = new Light("3", true);
        Light light4 = new Light("4", false);
        Light light5 = new Light("5", false);
        Door door1 = new Door(false, "1");
        Door door2 = new Door(true, "2");
        Room hall = new Room(Arrays.asList(light1, light2),
                Arrays.asList(door1),
                "hall");
        Room bedroom = new Room(Arrays.asList(light3, light4, light5),
                Arrays.asList(door2),
                "bedroom");
        SmartHome smartHome = new SmartHome(Arrays.asList(hall, bedroom));
        SensorEvent event = new SensorEvent(EventType.DOOR_CLOSED, "2");

        EventHandler handler = new HallDoorEventHandler(smartHome);
        handler.handleEvent(event);

        assert(door2.isOpen());
    }
}
