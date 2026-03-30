public interface Handler {
    void setNext(Handler next);
    void handle(Message message);
}