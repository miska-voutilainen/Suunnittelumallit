package Observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WeatherStation extends Thread {
    private List<WeatherObserver> observers = new ArrayList<>(); // Changed to WeatherObserver type list from WeatherObserver class list
    private int temperature = 34; // Example temperature value
    private final int MIN_TEMPERATURE = -10;
    private final int MAX_TEMPERATURE = 40;
    private Random random = new Random();

    public void addObserver (WeatherObserver observer) { 
        observers.add(observer);
    }

    public void removeObserver (WeatherObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (WeatherObserver observer : observers) {
            observer.update(temperature); // Call update method on each observer from WeatherObserver interface since it now implements the interface
        }
    }

    
    // Simulate temperature changes every 5 seconds 
    private void changeTemperature() {
        int change = random.nextBoolean() ? 1 : -1;
        temperature += change;

        if (temperature > MAX_TEMPERATURE) temperature = MAX_TEMPERATURE;
        if (temperature < MIN_TEMPERATURE) temperature = MIN_TEMPERATURE;

        notifyObservers();
}

    @Override
    public void run() {
        while (true) {
            changeTemperature();
            try {
                Thread.sleep((random.nextInt(5) + 1) * 1000);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
