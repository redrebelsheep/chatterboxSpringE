package f73.bredex.chatterbox.chat;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class ChatService {

    private final RoomRepository roomRepository;

    private final ChatRepository chatRepository;

    public ChatService(RoomRepository roomRepository, ChatRepository chatRepository) {
        this.roomRepository = roomRepository;
        this.chatRepository = chatRepository;
    }

    public List<String> getALlRooms() {
        return roomRepository.findALlRooms();
    }



    public Chat postChat(String room, String message, String sender) {
        Chat chatTmp = new Chat(message,sender, Instant.now(),room);
        return chatRepository.save(chatTmp);
    }

    public List<Chat> getChats(String room){
        return chatRepository.findByRoom(room);
    }

}
