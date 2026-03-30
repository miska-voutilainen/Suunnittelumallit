public class Main {
    public static void main(String[] args) {
        // Create handlers
        CompensationClaimHandler compensationHandler = new CompensationClaimHandler();
        ContactRequestHandler contactHandler = new ContactRequestHandler();
        DevelopmentSuggestionHandler devHandler = new DevelopmentSuggestionHandler();
        GeneralFeedbackHandler generalHandler = new GeneralFeedbackHandler();

        // Chain handlers
        compensationHandler.setNext(contactHandler);
        contactHandler.setNext(devHandler);
        devHandler.setNext(generalHandler);

        // Test messages for each type
        Message compensationMsg = new Message();
        compensationMsg.messageType = MessageType.EMAIL; 
        compensationMsg.messageContent = "Requesting compensation for delayed delivery.";
        compensationMsg.senderEmail = "customer1@example.com";

        Message contactMsg = new Message();
        contactMsg.messageType = MessageType.SMS;
        contactMsg.messageContent = "Please contact me about my order.";
        contactMsg.senderEmail = "customer2@example.com";

        Message devSuggestionMsg = new Message();
        devSuggestionMsg.messageType = MessageType.PUSH_NOTIFICATION; 
        devSuggestionMsg.messageContent = "Add more payment options.";
        devSuggestionMsg.senderEmail = "customer3@example.com";

        Message generalMsg = new Message();
        generalMsg.messageType = MessageType.EMAIL;
        generalMsg.messageContent = "Great service, thank you!";
        generalMsg.senderEmail = "customer4@example.com";

        // Send messages through the chain
        System.out.println("--- Compensation Claim ---");
        compensationHandler.handle(compensationMsg);
        System.out.println("--- Contact Request ---");
        compensationHandler.handle(contactMsg);
        System.out.println("--- Development Suggestion ---");
        compensationHandler.handle(devSuggestionMsg);
        System.out.println("--- General Feedback ---");
        compensationHandler.handle(generalMsg);
    }
}
