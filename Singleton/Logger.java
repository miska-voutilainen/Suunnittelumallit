package singleton;

import java.io.FileWriter;
import java.io.IOException;

public class Logger {
    private static Logger instance = null;

    private FileWriter writer;

    private String fileName = "default_log.txt";

    private Logger() {
        try {
            writer = new FileWriter(fileName, true);
        } catch (IOException e) {
            System.out.println("Virhe tiedoston avaamisessa: " + e.getMessage());
        }
    }

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void setFileName(String newFileName) {
        try {
            if (writer != null) {
                writer.close(); 
            }
            fileName = newFileName;
            writer = new FileWriter(fileName, true);
        } catch (IOException e) {
            System.out.println("Virhe tiedoston vaihtamisessa: " + e.getMessage());
        }
    }

public void write(String message) {
    try {
        writer.write(message + "\n");
        writer.flush();
        System.out.println("LOG: " + message);
    } catch (IOException e) {
        System.out.println("Virhe kirjoitettaessa: " + e.getMessage());
    }
}

    public void close() {
        try {
            if (writer != null) {
                writer.close();
            }
        } catch (IOException e) {
            System.out.println("Virhe suljettaessa: " + e.getMessage());
        }
    }
}