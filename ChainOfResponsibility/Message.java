public class Message {

    MessageType messageType;
    String messageContent;
    String senderEmail;

    public static void main(String[] args) {
        
    }
}

enum MessageType {
    EMAIL,
    SMS,
    PUSH_NOTIFICATION
}
