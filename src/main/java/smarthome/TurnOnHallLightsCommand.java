package ru.sbt.mipt.oop;

import java.util.ArrayList;

public class TurnOnHallLightsCommand implements Command{
    private final EventLoopProcessor processor;
    private final ArrayList<String> lights_Id;

    public TurnOnHallLightsCommand(EventLoopProcessor processor, ArrayList<String> lights_Id) {
        this.lights_Id = lights_Id;
        this.processor = processor;
    }

    public void execute() {
        for (String light_Id : lights_Id) {
            processor.processEvent(new SensorEvent(SensorEventType.LIGHT_ON, light_Id));

        }
    }
}
