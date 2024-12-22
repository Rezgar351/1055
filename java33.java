public class House {
    private String id;
    private String name;
    private double price;
    private String location;

    // Constructor
    public House(String id, String name, double price, String location) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.location = location;
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return "House{id='" + id + "', name='" + name + "', price=" + price + ", location='" + location + "'}";
    }
}
