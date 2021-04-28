import event.handlers.DoorSensorEventHandler;
import event.handlers.EventHandler;
import org.junit.jupiter.api.Test;
import sensor.events.SensorEvent;
import sensor.events.EventType;
import smarthome.Door;
import smarthome.Light;
import smarthome.Room;
import smarthome.SmartHome;

import java.util.Arrays;

public class DoorEventHandlerTest {
    @Test
    public void testChangingDoorState() {
        Light light1 = new Light("1", false);
        Light light2 = new Light("2", true);
        Door door1 = new Door(false, "1");
        Room kitchen = new Room(Arrays.asList(light1, light2),
                Arrays.asList(door1),
                "kitchen");
        SmartHome smartHome = new SmartHome(Arrays.asList(kitchen));
        SensorEvent event = new SensorEvent(EventType.DOOR_OPEN, "1");
        EventHandler handler = new DoorSensorEventHandler();
        handler.handleEvent(smartHome, event);

        assert(door1.isOpen());
    }

    @Test
    public void testRemainingDoorState() {
        Light light1 = new Light("1", false);
        Light light2 = new Light("2", true);
        Door door1 = new Door(true, "1");
        Room kitchen = new Room(Arrays.asList(light1, light2),
                Arrays.asList(door1),
                "kitchen");
        SmartHome smartHome = new SmartHome(Arrays.asList(kitchen));
        SensorEvent event = new SensorEvent(EventType.DOOR_OPEN, "1");
        EventHandler handler = new DoorSensorEventHandler();
        handler.handleEvent(smartHome, event);

        assert(door1.isOpen());
    }
}
