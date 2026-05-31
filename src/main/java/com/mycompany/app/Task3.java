package com.mycompany.app;

import org.json.JSONObject;
import org.json.JSONArray;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Task3 {
    public static void getWeatherForecast() {
        String url = "https://api.open-meteo.com/v1/forecast?latitude=56&longitude=44&hourly=temperature_2m,rain&current=cloud_cover&timezone=Europe%2FMoscow&forecast_days=1&wind_speed_unit=ms";
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            JSONObject json = new JSONObject(response.body());
            
            JSONObject hourly = json.getJSONObject("hourly");
            JSONArray timeArray = hourly.getJSONArray("time");
            JSONArray tempArray = hourly.getJSONArray("temperature_2m");
            JSONArray rainArray = hourly.getJSONArray("rain");

            System.out.println("| № | Дата/время | Температура | Осадки (мм) |");
            System.out.println("|---|------------|-------------|-------------|");
            
            StringBuilder sb = new StringBuilder();
            sb.append("| № | Дата/время | Температура | Осадки (мм) |\n");
            sb.append("|---|------------|-------------|-------------|\n");
            
            for (int i = 0; i < timeArray.length(); i++) {
                String time = timeArray.getString(i);
                double temp = tempArray.getDouble(i);
                double rain = rainArray.getDouble(i);
                
                String line = String.format("| %d | %s | %.1f | %.2f |", i + 1, time, temp, rain);
                System.out.println(line);
                sb.append(line).append("\n");
            }
            
            Files.createDirectories(Paths.get("result"));
            PrintWriter writer = new PrintWriter(new FileWriter("result/forecast.txt"));
            writer.print(sb.toString());
            writer.close();
            
        } catch (Exception e) {
            System.out.println("Error in Task 3: " + e.toString());
        }
    }
}
