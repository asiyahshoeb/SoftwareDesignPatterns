import java.util.ArrayList;

// ---------------------------
// Product
// ---------------------------
class Vehicle {
    private ArrayList<String> parts = new ArrayList<>();

    public void add(String part) {
        parts.add(part);
    }

    public void show() {
        for (String part : parts) {
            System.out.println(part);
        }
    }
}

// ---------------------------
// Abstract Builder
// ---------------------------
abstract class VehicleBuilder {
    public abstract void buildDoors();
    public abstract void buildSeat();
    public abstract void buildWheel();
    public abstract Vehicle getResult();
}

// ---------------------------
// Concrete Builder - MiniVan
// ---------------------------
class MiniVan extends VehicleBuilder {
    private Vehicle vehicle = new Vehicle();

    public void buildDoors() {
        vehicle.add("Doors: 4 Doors");
    }

    public void buildSeat() {
        vehicle.add("Seats: 7 Seats");
    }

    public void buildWheel() {
        vehicle.add("Wheels: 4 Wheels");
    }

    public Vehicle getResult() {
        return vehicle;
    }
}

// ---------------------------
// Concrete Builder - SportsCar
// ---------------------------
class SportsCar extends VehicleBuilder {
    private Vehicle vehicle = new Vehicle();

    public void buildDoors() {
        vehicle.add("Doors: 2 Doors");
    }

    public void buildSeat() {
        vehicle.add("Seats: 4 Seats");
    }

    public void buildWheel() {
        vehicle.add("Wheels: 4 Wheels");
    }

    public Vehicle getResult() {
        return vehicle;
    }
}

// ---------------------------
// Concrete Builder - Motorcycle
// ---------------------------
class Motorcycle extends VehicleBuilder {
    private Vehicle vehicle = new Vehicle();

    public void buildDoors() {
        vehicle.add("Doors: 0 Doors");
    }

    public void buildSeat() {
        vehicle.add("Seats: 2 Seats");
    }

    public void buildWheel() {
        vehicle.add("Wheels: 2 Wheels");
    }

    public Vehicle getResult() {
        return vehicle;
    }
}

// ---------------------------
// Director
// ---------------------------
class Shop {
    public void construct(VehicleBuilder builder) {
        builder.buildDoors();
        builder.buildSeat();
        builder.buildWheel();
    }
}

// ---------------------------
// Main Application
// ---------------------------
public class BuilderExample {
    public static void main(String[] args) {
        Shop shop = new Shop();

        VehicleBuilder miniVanBuilder = new MiniVan();
        VehicleBuilder sportsCarBuilder = new SportsCar();
        VehicleBuilder motorcycleBuilder = new Motorcycle();

        // Construct MiniVan
        shop.construct(miniVanBuilder);
        Vehicle miniVan = miniVanBuilder.getResult();
        System.out.println("\nMiniVan -------");
        miniVan.show();

        // Construct SportsCar
        shop.construct(sportsCarBuilder);
        Vehicle sportsCar = sportsCarBuilder.getResult();
        System.out.println("\nSportsCar -------");
        sportsCar.show();

        // Construct Motorcycle
        shop.construct(motorcycleBuilder);
        Vehicle motorcycle = motorcycleBuilder.getResult();
        System.out.println("\nMotorcycle -------");
        motorcycle.show();
    }
}
