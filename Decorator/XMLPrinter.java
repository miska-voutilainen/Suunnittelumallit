public class XMLPrinter implements Printer {
    private final Printer printer;

    public XMLPrinter(Printer printer) {
        this.printer = printer;
    }

    @Override
    public void print(String message) {
        String xml = "<message>" + message + "</message>";

        printer.print(xml);
    }
}
