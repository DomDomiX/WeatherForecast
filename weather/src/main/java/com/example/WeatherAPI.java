package com.example;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONObject;

public class WeatherAPI {
    private static final String API_KEY = "2ff4f42e02fe4cff890130205252802"; // Nahraď vlastním API klíčem
    private static final String BASE_URL = "http://api.weatherapi.com/v1/current.json";

    public static String getWeather(String city) {
        OkHttpClient client = new OkHttpClient();
        String url = BASE_URL + "?key=" + API_KEY + "&q=" + city + "&aqi=no";

        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) throw new RuntimeException("HTTP error: " + response.code());

            // Zpracování JSON odpovědi
            JSONObject jsonResponse = new JSONObject(response.body().string());
            JSONObject current = jsonResponse.getJSONObject("current");

            // Vrátíme teplotu a podmínky
            String temperature = current.get("temp_c").toString();
            String condition = current.getJSONObject("condition").getString("text");

            return "Teplota: " + temperature + "°C, " + condition;
        } catch (Exception e) {
            e.printStackTrace();
            return "Chyba při načítání dat";
        }
    }
}
