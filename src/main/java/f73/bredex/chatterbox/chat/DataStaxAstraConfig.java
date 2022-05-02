package f73.bredex.chatterbox.chat;

import com.datastax.oss.driver.api.core.CqlSession;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.nio.file.Paths;

@Configuration
public class DataStaxAstraConfig {

    @Bean
    public CqlSession cqlSession() {
        return CqlSession.builder().withKeyspace("chat") .withCloudSecureConnectBundle(Paths.get("secure-connect-chatterbox.zip")) .withAuthCredentials("mNgCIERQaFNBrGrUUvEmIRnx",
                "CsZkbw8TGgj5n,rH2ZZSWnnMAKHYd-sIkD-oydXiebhaYOyNMQMFY4zySa-NA6Xt6ftJmHZMNoleQuqyAI1rcJtRzfKm8T9Zp8rFv3N6ExXuIbEhnoZhnCPCPyrQ1xDw")
                        .build();
    }
}
