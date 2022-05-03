package f73.bredex.chatterbox.chat;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/rooms/{room}/messages")
    public List<Chat> getMessages(@PathVariable String room){
        return chatService.getChats(room);
    }

    @PostMapping("/rooms/{room}/message")
    public Chat postChat(@PathVariable String room, @RequestBody String message, @RequestParam String sender){
        return chatService.postChat(room, message, sender);
    }
}
