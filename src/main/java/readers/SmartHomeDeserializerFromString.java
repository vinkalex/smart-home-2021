package readers;
import com.google.gson.Gson;
import smarthome.SmartHome;

public class SmartHomeDeserializerFromString implements SmartHomeDeserializer {
    private final String string;

    public SmartHomeDeserializerFromString(String string) {
        this.string = string;
    }

    @Override
    public SmartHome createSmartHome() {
        Gson gson = new Gson();
        return gson.fromJson(string, SmartHome.class);
    }
}
