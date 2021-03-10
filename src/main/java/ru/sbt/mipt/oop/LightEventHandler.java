package ru.sbt.mipt.oop;

public class LightEventHandler implements EventHandler{
    //обработка событий со светом - делегация модификации другому классу
    @Override
    public void handleSensorEvent(SmartHome smartHome, SensorEvent event) {
        DoLightEvent handler = new DoLightEvent(smartHome);
        handler.doSensorEvent(event);
    }
}
