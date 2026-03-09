public class CoffeeShop {

    // ----------------------------
    // Abstract Component
    // ----------------------------
    static abstract class Beverage {
        String description = "Beverage";

        public String getDescription() {
            return description;
        }

        public abstract double cost();
    }

    // ----------------------------
    // Abstract Decorator
    // ----------------------------
    static abstract class CondimentDecorator extends Beverage {
        public abstract String getDescription();
    }

    // ----------------------------
    // Concrete Beverage
    // ----------------------------
    static class DarkRoast extends Beverage {

        public DarkRoast() {
            description = "DarkRoast";
        }

        public double cost() {
            return 1.99;
        }
    }

    static class Espresso extends Beverage {

        public Espresso() {
            description = "Espresso";
        }

        public double cost() {
            return 1.50;
        }
    }

    // ----------------------------
    // Concrete Decorators
    // ----------------------------
    static class Mocha extends CondimentDecorator {

        Beverage beverage;

        public Mocha(Beverage beverage) {
            this.beverage = beverage;
        }

        public String getDescription() {
            return beverage.getDescription() + ", Mocha";
        }

        public double cost() {
            return 0.20 + beverage.cost();
        }
    }

    static class Whip extends CondimentDecorator {

        Beverage beverage;

        public Whip(Beverage beverage) {
            this.beverage = beverage;
        }

        public String getDescription() {
            return beverage.getDescription() + ", Whip";
        }

        public double cost() {
            return 0.10 + beverage.cost();
        }
    }

    // ----------------------------
    // Main Method
    // ----------------------------
    public static void main(String[] args) {

        // Example 1
        Beverage beverage = new DarkRoast();
        System.out.println(beverage.getDescription() + " $" + beverage.cost());

        beverage = new Mocha(beverage);
        beverage = new Whip(beverage);

        System.out.println(beverage.getDescription() + " $" + beverage.cost());

        System.out.println();

        // Example 2
        Beverage beverage2 = new Espresso();
        System.out.println(beverage2.getDescription() + " $" + beverage2.cost());

        beverage2 = new Mocha(beverage2);
        beverage2 = new Mocha(beverage2);
        beverage2 = new Whip(beverage2);

        System.out.println(beverage2.getDescription() + " $" + beverage2.cost());
    }
}
