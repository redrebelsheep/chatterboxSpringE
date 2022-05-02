package f73.bredex.chatterbox;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "ChatterBox API", version = "2.0", description = "Chatterbox Information"))
public class ChatterboxApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChatterboxApplication.class, args);
	}

}
