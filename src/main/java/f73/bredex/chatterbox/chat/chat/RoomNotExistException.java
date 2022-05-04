package f73.bredex.chatterbox.chat.chat;

public class RoomNotExistException extends RuntimeException {

    public RoomNotExistException(String message) {
        super(message);
    }
}
