package f73.bredex.chatterbox.chat;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatService {

    private final RoomRepository roomRepository;

    public ChatService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public List<String> getALlRooms() {
        return roomRepository.findALlRooms();
    }


}
