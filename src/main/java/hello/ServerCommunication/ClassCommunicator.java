/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hello.ServerCommunication;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import hello.Utilities.LocalRepo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public class ClassCommunicator {
   public static void createClass(String name, String description) {
       try {
           description = URLEncoder.encode(description, "UTF-8");
           name = URLEncoder.encode(name, "UTF-8");
            String urlStr = "http://localhost:8888/createclassserver?name="+
                    name+"&description=" + description;
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

            conn.disconnect();

      } catch (MalformedURLException e) {

            e.printStackTrace();

      } catch (IOException e) {

            e.printStackTrace();

      }
    }
   
   public static JSONArray getClasses(String token) {
       JSONArray result = new JSONArray();
       try {
            String urlStr = "http://localhost:8888/getclasses?&token=" +
                    token;
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
            result = obj.getJSONArray("classes");
            
             

            conn.disconnect();

      } catch (MalformedURLException e) {

            e.printStackTrace();

      } catch (IOException e) {

            e.printStackTrace();

      } finally {
           return result;
       }
    }
} 
