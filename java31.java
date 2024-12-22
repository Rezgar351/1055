import java.net.*;
import java.io.*;
import java.util.*;
import com.google.gson.*;

public class HouseModule {
    private static final String API_URL = "https://api.alibaba.com/houses"; // فرضی

    public List<House> getHouses() throws IOException {
        // ارسال درخواست به API برای دریافت داده‌های خانه‌ها
        URL url = new URL(API_URL);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();
        
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        
        // تجزیه پاسخ JSON به لیست خانه‌ها
        return parseHouses(response.toString());
    }

    private List<House> parseHouses(String jsonResponse) {
        // تبدیل پاسخ JSON به لیست اشیاء House
        Gson gson = new Gson();
        House[] housesArray = gson.fromJson(jsonResponse, House[].class);
        return Arrays.asList(housesArray);
    }

    public static void main(String[] args) throws IOException {
        HouseModule houseModule = new HouseModule();
        List<House> houses = houseModule.getHouses();
        
        // نمایش داده‌ها
        houses.forEach(house -> System.out.println(house));
    }
}
