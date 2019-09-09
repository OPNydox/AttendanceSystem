
package hello.ServerCommunication;

import hello.Utilities.LocalRepo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import org.json.JSONObject;

public class ProfessorCommunicator {
       public static String registerProfessor(String name, String password) {
       try {
           name = URLEncoder.encode(name, "UTF-8");
           password = URLEncoder.encode(password, "UTF-8");
           
            String urlStr = "http://localhost:8888/registerprofessor?name="+
                    name+"&password=" + password;
            
            URL url = new URL(urlStr);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

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
            String accToken = obj.getString("accToken");
            
            conn.disconnect();
            return accToken;

      } catch (MalformedURLException e) {

            e.printStackTrace();

      } catch (IOException e) {

            e.printStackTrace();

      } 
       
       return null;
    }

}
