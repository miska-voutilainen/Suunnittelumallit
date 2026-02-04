// Tyyli A:n nappi – simppeli laatikko
public class ButtonA extends Button {
    public ButtonA(String text) {
        super(text);
    }

    public void display() {
        System.out.println("+------------+");
        System.out.println("| " + text + " |");
        System.out.println("+------------+");
    }
}
