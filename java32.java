import java.util.*;
import java.util.stream.*;
import java.io.IOException;

public class FilterModule {

    public List<House> filterHousesByPrice(List<House> houses, double maxPrice) {
        // فیلتر خانه‌ها بر اساس قیمت
        return houses.stream()
                     .filter(house -> house.getPrice() <= maxPrice)
                     .collect(Collectors.toList());
    }

    public List<House> filterHousesByLocation(List<House> houses, String location) {
        // فیلتر خانه‌ها بر اساس مکان
        return houses.stream()
                     .filter(house -> house.getLocation().equalsIgnoreCase(location))
                     .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        // نمونه‌سازی فیلتر
        HouseModule houseModule = new HouseModule();
        try {
            List<House> houses = houseModule.getHouses();
            FilterModule filterModule = new FilterModule();

            // فیلتر خانه‌ها بر اساس قیمت
            List<House> affordableHouses = filterModule.filterHousesByPrice(houses, 500);
            affordableHouses.forEach(house -> System.out.println(house));

            // فیلتر خانه‌ها بر اساس مکان
            List<House> locationHouses = filterModule.filterHousesByLocation(houses, "Shanghai");
            locationHouses.forEach(house -> System.out.println(house));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
