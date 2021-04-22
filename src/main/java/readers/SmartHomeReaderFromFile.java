package readers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SmartHomeReaderFromFile implements SmartHomeReader {
    private final String fileName;

    public SmartHomeReaderFromFile(String fileName) {
        this.fileName = fileName;
    }

    //переводим то, что считали в строку
    @Override
    public String convertToString() {
        try {
            return new String(Files.readAllBytes(Paths.get(this.fileName)));
        } catch (IOException e) {
            throw new RuntimeException("Could not read from file" + this.fileName, e);
        }
    }
}
