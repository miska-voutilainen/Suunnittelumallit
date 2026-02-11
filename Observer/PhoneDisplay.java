package Observer;

public class PhoneDisplay implements WeatherObserver {

    private String name;

    // Constructor to set the name of the PhoneDisplay who is observing
    public PhoneDisplay(String name) {
        this.name = name;
    }

    @Override
    public void update(int temperature) {
        System.out.println(name +  " Phone Display: Temperature is updated to " + temperature + "°C");
    }
}
