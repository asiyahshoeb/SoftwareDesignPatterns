public class AdapterExample {

    // ----------------------------
    // Target class
    // ----------------------------
    static abstract class TS {

        public TS() {
        }

        // Client expects temperature in Fahrenheit
        public abstract double getTemp();
    }

    // ----------------------------
    // Adaptee (existing system)
    // ----------------------------
    static class TS3Adptee {

        public TS3Adptee() {
        }

        // Returns temperature in Celsius
        public double getTSTemp() {
            return 25.0; // Example temperature in Celsius
        }
    }

    // ----------------------------
    // Adapter
    // ----------------------------
    static class TSAdapter extends TS {

        private TS3Adptee ts3;

        public TSAdapter() {
            ts3 = new TS3Adptee();
        }

        @Override
        public double getTemp() {

            double celsius = ts3.getTSTemp();

            // Convert Celsius to Fahrenheit
            double fahrenheit = (celsius * 9 / 5) + 32;

            return fahrenheit;
        }
    }

    // ----------------------------
    // Client
    // ----------------------------
    public static void main(String[] args) {

        TS temperatureSensor = new TSAdapter();

        double temp = temperatureSensor.getTemp();

        System.out.println("Temperature in Fahrenheit: " + temp);
    }
}
