package f73.bredex.chatterbox.chat;

import org.springframework.stereotype.Service;

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

    public Chat postChat(Chat chat) {
        return chatRepository.save(chat);
    }


}
