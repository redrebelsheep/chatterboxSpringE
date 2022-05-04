package f73.bredex.chatterbox.chat.chat;

import f73.bredex.chatterbox.HelloControllerTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.StringContains.containsString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = ChatController.class)
class ChatControllerTest {

    private final Logger logger = LoggerFactory.getLogger(HelloControllerTest.class);

    @Autowired
    private MockMvc mockMvc;

    private ChatController chatController;

    @MockBean
    private ChatService chatService;

    @Test
    void getRooms() throws Exception {
        List<String> rooms = Arrays.asList("rot", "blau", "gelb");
        //GIVEN
        given(chatService.getALlRooms()).willReturn(rooms);
        //WHEN
        mockMvc.perform(get("/rooms"))
                //THEN
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("blau")))
                .andExpect(content().string(not(containsString("yellow"))));
    }

    @Test
    void postRoom() {
    }

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