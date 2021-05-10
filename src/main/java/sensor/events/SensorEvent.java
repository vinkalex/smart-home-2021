package sensor.events;

public class SensorEvent implements Event{
    private final EventType type;
    private final String objectId;

    public SensorEvent(EventType type, String objectId) {
        this.type = type;
        this.objectId = objectId;
    }

    @Override
    public EventType getType() {
        return this.type;
    }

    public String getObjectId() {
        return this.objectId;
    }

    @Override
    public String toString() {
        return "SensorEvent{" +
                "type=" + type +
                ", objectId='" + objectId + '\'' +
                '}';
    }
}
