// ---------------------------
// Director
// ---------------------------
class AerospaceEngineer {

    public void constructAirplane(AirplaneBuilder airplaneBuilder) {
        airplaneBuilder.buildWings();
        airplaneBuilder.buildPowerplant();
        airplaneBuilder.buildSeats();
    }
}

// ---------------------------
// Abstract Builder
// ---------------------------
abstract class AirplaneBuilder {

    public abstract void buildWings();
    public abstract void buildPowerplant();
    public abstract void buildSeats();
    public abstract Airplane getAirplane();
}

// ---------------------------
// Product
// ---------------------------
class Airplane {

    float wingspan;
    String powerplant;
    int crewSeats;
    int passengerSeats;

    public void show() {
        System.out.println("Wingspan: " + wingspan);
        System.out.println("Powerplant: " + powerplant);
        System.out.println("Crew Seats: " + crewSeats);
        System.out.println("Passenger Seats: " + passengerSeats);
        System.out.println();
    }
}

// ---------------------------
// Concrete Builder - CropDuster
// ---------------------------
class CropDuster extends AirplaneBuilder {

    private Airplane airplane = new Airplane();

    public void buildWings() {
        airplane.wingspan = 9f;
    }

    public void buildPowerplant() {
        airplane.powerplant = "Single piston engine";
    }

    public void buildSeats() {
        airplane.crewSeats = 1;
        airplane.passengerSeats = 1;
    }

    public Airplane getAirplane() {
        return airplane;
    }
}

// ---------------------------
// Concrete Builder - FighterJet
// ---------------------------
class FighterJet extends AirplaneBuilder {

    private Airplane airplane = new Airplane();

    public void buildWings() {
        airplane.wingspan = 35f;
    }

    public void buildPowerplant() {
        airplane.powerplant = "Dual thrust vectoring engines";
    }

    public void buildSeats() {
        airplane.crewSeats = 1;
        airplane.passengerSeats = 0;
    }

    public Airplane getAirplane() {
        return airplane;
    }
}

// ---------------------------
// Concrete Builder - Glider
// ---------------------------
class Glider extends AirplaneBuilder {

    private Airplane airplane = new Airplane();

    public void buildWings() {
        airplane.wingspan = 57.1f;
    }

    public void buildPowerplant() {
        airplane.powerplant = "No engine";
    }

    public void buildSeats() {
        airplane.crewSeats = 1;
        airplane.passengerSeats = 0;
    }

    public Airplane getAirplane() {
        return airplane;
    }
}

// ---------------------------
// Application
// ---------------------------
public class BuilderExample {

    public static void main(String[] args) {

        // Director
        AerospaceEngineer director = new AerospaceEngineer();

        // Builders
        AirplaneBuilder crop = new CropDuster();
        AirplaneBuilder fighter = new FighterJet();
        AirplaneBuilder glider = new Glider();

        // Build CropDuster
        director.constructAirplane(crop);
        Airplane completedCropDuster = crop.getAirplane();
        completedCropDuster.show();

        // Build FighterJet
        director.constructAirplane(fighter);
        Airplane completedFighterJet = fighter.getAirplane();
        completedFighterJet.show();

        // Build Glider
        director.constructAirplane(glider);
        Airplane completedGlider = glider.getAirplane();
        completedGlider.show();
    }
}
