package f73.bredex.chatterbox.chat.chat;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import java.util.List;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@RestController
@Validated
public class ChatController {
    ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @GetMapping("/rooms")
    public List<String> getRooms(){
        return chatService.getALlRooms();
    }

    @PostMapping("/rooms/{room}")
    public Chat postChat(@PathVariable String room, @RequestBody String message, @RequestParam String sender){
        return chatService.postChat(room, message, sender);
    }
//    @PostMapping("/rooms/{rooms}")
//    public ResponseEntity<HttpStatus> postRoom(@ValidRoom String room){
//        return new ResponseEntity<HttpStatus>(HttpStatus.CREATED);

//    }

    @GetMapping("/rooms/{room}/messages")
    public List<Chat> getMessages(@PathVariable @ValidRoom String room){
        return chatService.getChats(room);
    }



    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    public String handleValidationExceptions(ConstraintViolationException ex) {
        return "Dieser Raum gibt es nicht!";
    }


}
