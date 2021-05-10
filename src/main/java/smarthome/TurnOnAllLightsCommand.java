package ru.sbt.mipt.oop;

public class TurnOnAllLightsCommand implements Command{
    private final EventLoopProcessor processor;

    public TurnOnAllLightsCommand(EventLoopProcessor processor) {
        this.processor = processor;
    }

    public void execute() {
        processor.processEvent(new SensorEvent(SensorEventType.LIGHT_ON, null));
    }
}
