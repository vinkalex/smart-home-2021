package ru.sbt.mipt.oop;
import com.google.gson.Gson;

public class SmartHomeDeserializerFromString implements SmartHomeDeserializer {
    private final String string;

    SmartHomeDeserializerFromString(String string) {
        this.string = string;
    }

    @Override
    public SmartHome createSmartHome() {
        Gson gson = new Gson();
        return gson.fromJson(string, SmartHome.class);
    }
}
