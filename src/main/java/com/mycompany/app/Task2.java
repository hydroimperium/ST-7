package com.mycompany.app;

import org.json.JSONObject;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Task2 {
    public static void getIpAddress() {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://api.ipify.org/?format=json"))
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            JSONObject json = new JSONObject(response.body());
            System.out.println("IP Address: " + json.getString("ip"));
        } catch (Exception e) {
            System.out.println("Error in Task 2: " + e.toString());
        }
    }
}
