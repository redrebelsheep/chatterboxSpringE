package f73.bredex.chatterbox.chat;

import java.time.Instant;

public class ChatMessage {

    private String message;
    private String sender;
    private Instant posted;
    private Room room;

    public ChatMessage(String message, String sender, Instant posted, Room room) {
        this.message = message;
        this.sender = sender;
        this.posted = posted;
        this.room = room;
    }

    public String getMessage() {
        return message;
    }

    public String getSender() {
        return sender;
    }

    public Instant getPosted() {
        return posted;
    }

    public Room getRoom() {
        return room;
    }
}
