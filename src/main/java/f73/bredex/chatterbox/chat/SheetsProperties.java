package f73.bredex.chatterbox.chat;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("google.sheets.rooms")
public class SheetsProperties {

    private String spreadsheetId;
    private String range;
    private String apiKey;

    public void setSpreadsheetId(String spreadsheetId) {
        this.spreadsheetId = spreadsheetId;
    }

    public void setRange(String range) {
        this.range = range;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getSpreadsheetId() {
        return spreadsheetId;
    }

    public String getRange() {
        return range;
    }

    public String getApiKey() {
        return apiKey;
    }
}
