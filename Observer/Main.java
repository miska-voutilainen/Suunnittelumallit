package Observer;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        // Create WeatherStation instance with concrete class (interface List<WeatherObserver>) only the classes which implemented the  interface will be in the listnas Observers المراقبين هم شاشات العرض.
        WeatherStation weatherStation = new WeatherStation(); 


        // Create observers instances with concrete classes from WeatherObserver interface.
        PhoneDisplay phoneDisplay = new PhoneDisplay("Taif");
        PhoneDisplay phoneDisplay2 = new PhoneDisplay("Lama");
        WindowDisplay windowDisplay = new WindowDisplay();


        // Register observers to the weather station in the observers interface list:
        weatherStation.addObserver(phoneDisplay);
        weatherStation.addObserver(phoneDisplay2);
        weatherStation.addObserver(windowDisplay);
        

        // Thread run():
        weatherStation.start(); // Start the weather station thread
        // Let it run for 15 seconds:
        Thread.sleep(15000);


        System.out.println("\nRemoving Lama observer...\n");
        weatherStation.removeObserver(phoneDisplay2); // Remove Lama observer

        // Continue running after removing an observer
        Thread.sleep(15000);
    }
}
