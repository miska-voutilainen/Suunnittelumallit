package Builder;

public class GamingComputerBuilder implements  ComputerBuilder {
    private Computer computer = new Computer();

    public void buildProcessor() {
        computer.setProcessor("Intel Core i9");
    }

    public void buildRAM() {
        computer.setRamGB(32);
    }

    public void buildHardDrive() {
        computer.setHardDrive("2 TB NVMe SSD");
    }
    
    public void buildGraphicsCard() {
        computer.setGraphicsCard("NVIDIA RTX 4090");
    }

    public void buildOperatingSystem() {
        computer.setOperatingSystem("Windows 11");
    }

    public Computer getComputer() {
        return computer;
    }

}
