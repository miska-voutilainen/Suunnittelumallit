import java.util.Base64;

public class EncryptedPrinter implements Printer {
    private final Printer printer;

    public EncryptedPrinter(Printer printer) {
        this.printer = printer;
    }

    @Override
    public void print(String message) {
        String encryptedMessage = Base64.getEncoder().encodeToString(message.getBytes());
        printer.print(encryptedMessage);
    }
}

