package f73.bredex.chatterbox.chat.google;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.googleapis.services.CommonGoogleClientRequestInitializer;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.sheets.v4.Sheets;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.security.GeneralSecurityException;

@Configuration
@EnableConfigurationProperties(GoogleSheetsProperties.class)
public class GoogleSheetsConfig {

    private GoogleSheetsProperties sheetsProperties;

    public GoogleSheetsConfig(GoogleSheetsProperties sheetsProperties) {
        this.sheetsProperties = sheetsProperties;
    }

    public Sheets getConnectionsGoogleSheets() throws GeneralSecurityException, IOException {
        NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
        GoogleClientRequestInitializer KEY_INITIALIZER = CommonGoogleClientRequestInitializer.newBuilder().setKey(this.sheetsProperties.getApiKey()).build();
        return new Sheets.Builder(HTTP_TRANSPORT, JacksonFactory.getDefaultInstance(), null).setGoogleClientRequestInitializer(KEY_INITIALIZER).build();
    }

    public GoogleSheetsProperties getSheetsProperties() {
        return sheetsProperties;
    }
}
