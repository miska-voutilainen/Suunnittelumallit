package Builder;

public class Computer {
    private String processor;
    private int ramGB;
    private String hardDrive;
    private String graphicsCard;
    private String operatingSystem;

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public void setRamGB(int ramGB) {
        this.ramGB = ramGB;
    }

    public void setHardDrive(String hardDrive) {
        this.hardDrive = hardDrive;
    }

    public void setGraphicsCard(String graphicsCard) {
        this.graphicsCard = graphicsCard;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    @Override
    public String toString() {
        return "Computer Configuration: " +
        "\n Processor: " + processor +
        "\n RAM:" + ramGB +
        "\n Hard Drive: " + hardDrive +
        "\n Graphics Card: " + graphicsCard +
        "\n Operating System: " + operatingSystem;
    }
}
