package f73.bredex.chatterbox.chat;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.googleapis.services.CommonGoogleClientRequestInitializer;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.Lists;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.ValueRange;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ChatService {

    private final Logger logger = LoggerFactory.getLogger(ChatService.class);

    public List<String> findALlRooms() {
//        ArrayList<String> tmpList = new ArrayList<String>();
//        tmpList.add("BlackRoom");
//        tmpList.add("RedRoom");

        List<String> rooms = Lists.newArrayList();
        try {
            NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
            final String spreadsheetId = "1pkqKtvOehWy_yVicPz8qveiMtZIgUAfXTj7SGQBmusM";
            final String range = "Rooms";
            final String API_KEY = "AIzaSyALQbwRvK4RATIQg96Knbipk0LqS1KxGdM";
            GoogleClientRequestInitializer KEY_INITIALIZER = CommonGoogleClientRequestInitializer.newBuilder().setKey(API_KEY).build();
            Sheets service = new Sheets.Builder(HTTP_TRANSPORT, JacksonFactory.getDefaultInstance(), null).setGoogleClientRequestInitializer(KEY_INITIALIZER).build();
            ValueRange result = service.spreadsheets().values().get(spreadsheetId, range).setMajorDimension("COLUMNS").execute();
            List<Object> values = result.getValues().get(0);
            rooms = values.stream().map(Object::toString).collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (GeneralSecurityException e) {
            logger.error("Something went wrong when I tried to retrieve the rooms from Google Sheets", e);
        }
        return rooms;
    }


}
