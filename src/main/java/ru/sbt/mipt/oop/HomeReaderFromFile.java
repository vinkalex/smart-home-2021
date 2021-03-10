package ru.sbt.mipt.oop;

import com.google.gson.Gson;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class HomeReaderFromFile implements HomeReader{
    private final String fileName;

    public HomeReaderFromFile(String fileName) {
        this.fileName = fileName;
    }

    //считываем дом из файла
    @Override
    public SmartHome createSmartHome() throws IOException {
        Gson gson = new Gson();
        String json = new String(Files.readAllBytes(Paths.get(fileName)));
        return gson.fromJson(json, SmartHome.class);
    }
}
