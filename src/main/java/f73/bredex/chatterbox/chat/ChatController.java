package f73.bredex.chatterbox.chat;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ChatController {
    ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @GetMapping("/rooms")
    public List<String> getRooms(){
        return chatService.getALlRooms();
    }

    @PostMapping("/rooms/{rooms}")
    public ResponseEntity<HttpStatus> postRoom(String room){
        return new ResponseEntity<HttpStatus>(HttpStatus.CREATED);
    }

    @GetMapping("/rooms/messages")
    public <T> List<T> getMessages(String room){
        return null;
    }

}
