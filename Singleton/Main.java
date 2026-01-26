package singleton;

public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();

        logger.setFileName("new_log.txt");

        logger.write("Simulaatio käynnistetty");
        logger.write("Käsitellään dataa...");
        logger.write("Simulaatio päättyi");

        logger.close();
    }
}
