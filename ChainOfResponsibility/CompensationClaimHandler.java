public class CompensationClaimHandler implements Handler {
    private Handler next;

    @Override
    public void setNext(Handler next) {
        this.next = next;
    }

    @Override
    public void handle(Message message) {
        if (message.messageType == MessageType.EMAIL) { // Replace with correct type for compensation claim
            System.out.println("Compensation claim reviewed: " + message.messageContent);
            // Add approval/rejection logic here
        } else if (next != null) {
            next.handle(message);
        } else {
            System.out.println("No handler found for message type: " + message.messageType);
        }
    }
}
