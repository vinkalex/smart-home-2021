package ru.sbt.mipt.oop;

public class SignalizationHandler implements SensorEventHandler{
    @Override
    public void handleEvent(SmartHome smartHome, SensorEvent event) {
        if (isSignalizationEvent(event)) {
            changeSignalizationState(smartHome.getSignalization(), event);
        }
    }

    private void changeSignalizationState(Signalization signalization, SensorEvent event) {
        if (event.getType().equals(SensorEventType.ALARM_ACTIVATE)) {
            signalization.activate(signalization.getCode());
        }
        if (event.getType().equals(SensorEventType.ALARM_DEACTIVATE)) {
            signalization.deactivate(signalization.getCode());
        }
    }

    private boolean isSignalizationEvent(SensorEvent event) {
        return (event.getType().equals(SensorEventType.ALARM_ACTIVATE))
                || (event.getType().equals(SensorEventType.ALARM_DEACTIVATE));
    }
}
