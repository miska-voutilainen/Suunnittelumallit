public class ContactRequestHandler implements Handler {
    private Handler next;

    @Override
    public void setNext(Handler next) {
        this.next = next;
    }

    @Override
    public void handle(Message message) {
        if (message.messageType == MessageType.SMS) { // Replace with correct type for contact request
            System.out.println("Contact request forwarded: " + message.messageContent);
            // Add forwarding logic here
        } else if (next != null) {
            next.handle(message);
        } else {
            System.out.println("No handler found for message type: " + message.messageType);
        }
    }
}
