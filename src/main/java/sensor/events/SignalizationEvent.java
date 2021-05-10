package sensor.events;

public class SignalizationEvent implements Event{
    private final EventType type;
    private final String code;

    public SignalizationEvent(EventType type, String code) {
        this.type = type;
        this.code = code;
    }

    @Override
    public EventType getType() {
        return this.type;
    }

    public String getCode() {
        return this.code;
    }

    @Override
    public String toString() {
        return "SignalizationEvent{" +
                "type=" + type +
                ", code='" + code+ '\'' +
                '}';
    }

}
