public class DevelopmentSuggestionHandler implements Handler {
    private Handler next;

    @Override
    public void setNext(Handler next) {
        this.next = next;
    }

    @Override
    public void handle(Message message) {
        if (message.messageType == MessageType.PUSH_NOTIFICATION) { // Replace with correct type for development suggestion
            System.out.println("Development suggestion logged: " + message.messageContent);
            // Add logging/prioritization logic here
        } else if (next != null) {
            next.handle(message);
        } else {
            System.out.println("No handler found for message type: " + message.messageType);
        }
    }
}
