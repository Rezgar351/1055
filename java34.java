import java.io.IOException;
import java.util.List;

public class DisplayModule {
    
    public void displayHouses(List<House> houses) {
        houses.forEach(house -> System.out.println(house));
    }

    public static void main(String[] args) {
        // نمایش خانه‌های فیلتر شده
        HouseModule houseModule = new HouseModule();
        try {
            List<House> houses = houseModule.getHouses();
            FilterModule filterModule = new FilterModule();
            List<House> affordableHouses = filterModule.filterHousesByPrice(houses, 500);

            DisplayModule displayModule = new DisplayModule();
            displayModule.displayHouses(affordableHouses);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
