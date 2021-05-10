package com.coolcompany.smarthome.events;

import smarthome.SmartHome;

public interface EventHandler {

    void handleEvent(CCSensorEvent event);
}
