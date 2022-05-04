package f73.bredex.chatterbox;

import f73.bredex.chatterbox.hello.HelloController;
import f73.bredex.chatterbox.hello.Mail;
import f73.bredex.chatterbox.hello.MailBuilder;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = HelloController.class)
public class HelloControllerTest {

    private final Logger logger = LoggerFactory.getLogger(HelloControllerTest.class);

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private HelloController controller;

    private Mail mailTest;
    private String json;
    private ObjectMapper mapper = new ObjectMapper();

    @BeforeEach
    void setUp() throws JsonProcessingException {
        mailTest = new MailBuilder().setMsg("Hallo").setSender("Marian").createMail();
        json = mapper.writeValueAsString(mailTest);
    }

    @Test
    public void contextLoad() {
        assertThat(controller).isNotNull();
    }

    @Test
    public void getHello() throws Exception {
        logger.info("test 1");
        mockMvc.perform(MockMvcRequestBuilders.get("/api/hello").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("Hello Superman")));
    }

    @Test
    public void getHelloWithQueryTest() throws Exception {
        logger.info("test 2");
        //Arrange
        String test = "Moin";
        //Act
        mockMvc.perform(MockMvcRequestBuilders.get("/api/hello?greeting=Moin")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("Moin Superman")));
    }

    @Test
    public void postMailTest() throws Exception {
        // Arrange
        Object mapper = new ObjectMapper();
        String test = "hello";
        // Act
        mockMvc.perform(post("/api/mail")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(test))

                .andExpect(status().isOk())
                .andExpect(content().string(equalTo(test)));
    }

    @Test
    public void postMailAsObjectTest() throws Exception {
        // Arrange

        // Act
        mockMvc.perform(post("/api/mailObject")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))

                .andExpect(status().isOk())
                .andExpect(content().json(json));
    }
}