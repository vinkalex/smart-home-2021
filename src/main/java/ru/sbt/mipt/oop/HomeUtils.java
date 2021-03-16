package ru.sbt.mipt.oop;

public class HomeUtils {

    public static Light findLight(SmartHome smartHome, String lightId) {
        for (Room room : smartHome.getRooms()) {
            for (Light light : room.getLights()) {
                if (light.getId().equals(lightId)) {
                    return light;
                }
            }
        }
        return null;
    }

    public static Door findDoor(SmartHome smartHome, String doorId) {
        for (Room room : smartHome.getRooms()) {
            for (Door door : room.getDoors()) {
                if (door.getId().equals(doorId)) {
                    return door;
                }
            }
        }
        return null;
    }

    public static boolean isHallDoor(SmartHome smartHome, String doorId) {
        for (Room room : smartHome.getRooms()) {
            for (Door door : room.getDoors()) {
                if (door.getId().equals(doorId)) {
                    if (room.getName().equals("hall")) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
