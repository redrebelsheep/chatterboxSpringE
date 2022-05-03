package f73.bredex.chatterbox.chat;

import org.springframework.data.cassandra.core.cql.Ordering;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.time.Instant;

@Table
public class Chat {

    @Column
    private String message;
    @PrimaryKeyColumn(ordinal = 2, type = PrimaryKeyType.CLUSTERED, ordering = Ordering.DESCENDING)
    private String sender;
    @PrimaryKeyColumn(ordinal = 1, type = PrimaryKeyType.CLUSTERED, ordering = Ordering.ASCENDING)
    private Instant posted;
    @PrimaryKeyColumn(ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    private String room;

    public Chat(String message, String sender, Instant posted, String room) {
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

    public String getRoom() {
        return room;
    }
}
