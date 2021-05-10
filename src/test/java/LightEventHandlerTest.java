import event.handlers.LightSensorEventHandler;
import event.handlers.EventHandler;
import org.junit.jupiter.api.Test;
import sensor.events.SensorEvent;
import sensor.events.EventType;
import smarthome.Door;
import smarthome.Light;
import smarthome.Room;
import smarthome.SmartHome;

import java.util.Arrays;

public class LightEventHandlerTest {
    @Test
    public void testChangingLightState() {
        Light light1 = new Light("1", false);
        Light light2 = new Light("2", true);
        Door door1 = new Door(false, "1");
        Room kitchen = new Room(Arrays.asList(light1, light2),
                Arrays.asList(door1),
                "kitchen");
        SmartHome smartHome = new SmartHome(Arrays.asList(kitchen));
        SensorEvent event = new SensorEvent(EventType.LIGHT_ON, "1");
        EventHandler handler = new LightSensorEventHandler(smartHome);
        handler.handleEvent(event);

        assert(light1.isOn());
    }

    @Test
    public void testRemainingLightState() {
        Light light1 = new Light("1", true);
        Light light2 = new Light("2", true);
        Door door1 = new Door(false, "1");
        Room kitchen = new Room(Arrays.asList(light1, light2),
                Arrays.asList(door1),
                "kitchen");
        SmartHome smartHome = new SmartHome(Arrays.asList(kitchen));
        SensorEvent event = new SensorEvent(EventType.LIGHT_ON, "1");
        EventHandler handler = new LightSensorEventHandler(smartHome);
        handler.handleEvent(event);

        assert(light1.isOn());
    }
}
