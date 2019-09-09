
package hello.ServerCommunication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import jdk.nashorn.internal.parser.JSONParser;
import org.json.JSONArray;
import org.json.JSONObject;

public class QRCommunicator {
    public static String generateCode(String name, String description, String id) {
        try {
            name = URLEncoder.encode(name, "UTF-8");
            description = URLEncoder.encode(description, "UTF-8");
            String urlStr = "http://localhost:8888/generateCode?name="+
                    name+"&description=" + description + "&classid=" + id;
            URLEncoder.encode(urlStr, "UTF-8");
            URL url = new URL(urlStr);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            
            //conn.addRequestProperty("name", name);
            //conn.addRequestProperty("description", description);

            if (conn.getResponseCode() != 200) {
                int err = conn.getResponseCode();
                    throw new RuntimeException("Failed : HTTP error code : "
                                    + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            String output;
            System.out.println("Output from Server .... \n");
            output = br.readLine();
            
            JSONObject obj = new JSONObject(output);

            conn.disconnect();
            
            return obj.getString("code");

      } catch (MalformedURLException e) {

            e.printStackTrace();

      } catch (IOException e) {

            e.printStackTrace();

      }
        return null;
    }
}