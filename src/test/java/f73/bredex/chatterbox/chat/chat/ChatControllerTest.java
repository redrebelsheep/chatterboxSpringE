package f73.bredex.chatterbox.chat.chat;

import com.fasterxml.jackson.databind.ObjectMapper;
import f73.bredex.chatterbox.HelloControllerTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.boot.test.mock.mockito.MockBean;


import java.time.Instant;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.StringContains.containsString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = ChatController.class)
class ChatControllerTest {

    private final Logger logger = LoggerFactory.getLogger(HelloControllerTest.class);

    @Autowired
    private MockMvc mvc;

    private ChatController chatController;

    @MockBean
    private ChatService chatService;

    @Autowired
    private ObjectMapper mapper;


    @BeforeEach
    void setUp() {

    }
    @Test
    void getRooms() throws Exception {
        List<String> rooms = Arrays.asList("rot", "blau", "gelb");
        //GIVEN
        given(chatService.getALlRooms()).willReturn(rooms);
        //WHEN
        mvc.perform(get("/rooms"))
                //THEN
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("blau")))
                .andExpect(content().string(not(containsString("yellow"))));
    }

    @Test
    void postRoom() throws Exception {
        //Given
        Chat tmpTest = new Chat("Test", "testSender", Instant.now(), "testroom");
        given(chatService.postChat(tmpTest.getMessage(),tmpTest.getSender(), tmpTest.getRoom())).willReturn(tmpTest);
        String json = mapper.writeValueAsString(tmpTest);
        //When
        mvc.perform(post("/rooms/testroom/sender?=testSender")
                .content("Test"))
                //Then
                .andExpect(status().isOk())
                .andExpect(content().json(json));
    }

//    @Test
//    void testSendMessagesByRoom() throws Exception {
//        given(this.chatService.sendMessagesByRoom("Ich", "Java", "Hello World")).willReturn((this.msg));
//        this.mvc
//                .perform(post("/chat/messages/{room}/send", this.msg.getRoom()).param("sender", "Ich")
//                        .param("message", "Hello World"))
//                .andExpect(status().isOk()).andExpect(jsonPath("$..message").value(this.msg.getMessage()))
//                .andExpect(jsonPath("$..room").value(this.msg.getRoom()))
//                .andExpect(jsonPath("$..sender").value(this.msg.getSender()));
//    }


    @Test
    void getMessages() {
    }

    @Test
    void postChat() {
    }

    @Test
    void handleValidationExceptions() {
    }
}