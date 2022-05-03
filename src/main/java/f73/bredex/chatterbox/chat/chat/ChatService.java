package f73.bredex.chatterbox.chat.chat;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class ChatService {

    private final ChatRoomRepository chatRoomRepository;

    private final ChatRepository chatRepository;

    public ChatService(ChatRoomRepository chatRoomRepository, ChatRepository chatRepository) {
        this.chatRoomRepository = chatRoomRepository;
        this.chatRepository = chatRepository;
    }

    public List<String> getALlRooms() {
        return chatRoomRepository.findALlRooms();
    }

    public Chat postChat(String room, String message, String sender) {
        Chat chatTmp = new Chat(message,sender, Instant.now(),room);
        return chatRepository.save(chatTmp);
    }

    public List<Chat> getChats(String room){
        return chatRepository.findByRoom(room);
    }

}
