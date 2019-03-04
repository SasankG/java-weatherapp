package weather;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;


/**
 * Connects to the weather API
 * Using AccuWeather free trial
 * API Key: 634qUJdiIKnqvCAbEfYwg7wCGnZrWdlc
 */
public class API {

    /**
     * Converts API response to string
     *
     * @param r
     * @return sb -> Response in form of String
     * @throws IOException
     */
    private String reader(Reader r) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = r.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    /**
     * Connect method - WORKS
     * Retrieves response from API in the form of a JSONObject and sends to filter method
     *
     * @param -> The location we want to get weather from area key : 48229_PC
     *           url = http://dataservice.accuweather.com/locations/v1/postalcodes/search?apikey=634qUJdiIKnqvCAbEfYwg7wCGnZrWdlc&q=L6C2V1
     * @throws Exception
     */
    public JSONObject connection() throws Exception, JSONException {

        // API key
        String key = "634qUJdiIKnqvCAbEfYwg7wCGnZrWdlc";

        // Location key
        String locKey = "48229_PC";

        // URL -> we are searching by postal code
        String url = "http://dataservice.accuweather.com/forecasts/v1/daily/1day/48229_PC?apikey=" + key;

        // Connect to URL
        InputStream ip = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(ip, Charset.forName("UTF-8")));

            // Response to string
            String jsonText = reader(rd);

            // Fixes JSONObject error
            int i = jsonText.indexOf("{");
            jsonText = jsonText.substring(i);

            // String to JSONObject
            JSONObject json = new JSONObject(jsonText);

            // Return JSONObject
            return json;

        } finally {
            ip.close();
        }
    }

    /**
     * Filter the response
     *
     * @param json -> Takes in JSONObject from previous method
     * @return -> Return the values we want as Strings
     * @throws JSONException
     */
    public String[] respFilter(JSONObject json) throws JSONException {


        // Take the JSONObject and return
        //  - Headline: Text
        //  - DailyForeCasts: Temperature: Minimum, Maximum: Value

        // The header part of the response
        JSONObject headline = json.getJSONObject("Headline");
        String text = headline.getString("Text");
        String category = headline.getString("Category");
        String link = headline.getString("Link");

        // The forecast
        JSONArray fcast = json.getJSONArray("DailyForecasts");

        JSONObject temp = fcast.getJSONObject(0).getJSONObject("Temperature");
        String mintemp = temp.getJSONObject("Minimum").getString("Value");
        String maxtemp = temp.getJSONObject("Maximum").getString("Value");

        // Store values in an array
        String[] data = {text, category, link, mintemp, maxtemp};

        return data;

    }

}
