package ru.sbt.mipt.oop;

public class TurnOffAllLightsCommand implements Command{
    private final EventLoopProcessor processor;

    public TurnOffAllLightsCommand(EventLoopProcessor processor) {
        this.processor = processor;
    }

    public void execute() {
        processor.processEvent(new SensorEvent(SensorEventType.LIGHT_OFF, null));
    }
}
