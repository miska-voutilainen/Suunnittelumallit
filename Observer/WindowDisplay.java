package Observer;

public class WindowDisplay implements WeatherObserver {
    
    @Override
    public void update(int temperature) {
        System.out.println("Window Display: Weather Temperature is updated to " + temperature + "°C" + "\n");
    }
}
