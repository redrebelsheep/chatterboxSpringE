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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class RoomRepository {

    private final Logger logger = LoggerFactory.getLogger(RoomRepository.class);

    @Autowired
    private GoogleSheetsConfig configurationData;


    public List<String> findALlRooms() {
        List<String> rooms = Lists.newArrayList();
        try {

            ValueRange result = configurationData.getConnectionsGoogleSheets().spreadsheets().values().get(this.configurationData.getSheetsProperties().getSpreadsheetId(), this.configurationData.getSheetsProperties().getRange()).setMajorDimension("COLUMNS").execute();
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
