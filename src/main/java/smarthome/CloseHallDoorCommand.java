package ru.sbt.mipt.oop;

public class CloseHallDoorCommand implements Command{
    private final EventLoopProcessor processor;
    private final String doorId;

    public CloseHallDoorCommand(EventLoopProcessor processor, String doorId) {
        this.processor = processor;
        this.doorId = doorId;
    }

    public void execute() {
        processor.processEvent(new SensorEvent(SensorEventType.DOOR_CLOSED, doorId));
    }
}
