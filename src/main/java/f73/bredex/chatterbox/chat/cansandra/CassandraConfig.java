package f73.bredex.chatterbox.chat.cansandra;

import com.datastax.oss.driver.api.core.CqlSession;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.nio.file.Paths;

@Configuration
@EnableConfigurationProperties(CassandraProperties.class)
public class CassandraConfig {

    private final CassandraProperties cassandraProperties;

    public CassandraConfig(CassandraProperties cassandraProperties) {
        this.cassandraProperties = cassandraProperties;
    }

    @Bean
    public CqlSession cqlSession() {
        return CqlSession.builder().withKeyspace("chat") .withCloudSecureConnectBundle(Paths.get(cassandraProperties.getPath())) .withAuthCredentials(cassandraProperties.getUsername(),cassandraProperties.getPassword()).build();
    }
}
