public class Main {
    public static void main(String[] args) {
        UIFactory factory = new AFactory();

        Button button = factory.createButton("OK");
        TextField textField = factory.createTextField("Enter name");
        Checkbox checkbox = factory.createCheckbox("Accept terms");

        button.display();
        textField.display();
        checkbox.display();

        System.out.println("\n-- Päivitetään tekstit --\n");

        button.setText("Cancel");
        textField.setText("Enter email");
        checkbox.setText("Subscribe");

        button.display();
        textField.display();
        checkbox.display();
    }
}
