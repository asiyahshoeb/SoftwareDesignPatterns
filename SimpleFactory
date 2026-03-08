import java.util.ArrayList;

// ---------------------------
// Simple Pizza Factory
// ---------------------------
class SimplePizzaFactory {

    public Pizza createPizza(String type) {
        Pizza pizza = null;

        if (type.equals("cheese")) {
            pizza = new CheesePizza();
        } 
        else if (type.equals("pepperoni")) {
            pizza = new PepperoniPizza();
        } 
        else if (type.equals("clam")) {
            pizza = new ClamPizza();
        } 
        else if (type.equals("veggie")) {
            pizza = new VeggiePizza();
        }

        return pizza;
    }
}

// ---------------------------
// Pizza Store
// ---------------------------
class PizzaStore {

    SimplePizzaFactory factory;

    public PizzaStore(SimplePizzaFactory factory) {
        this.factory = factory;
    }

    public Pizza orderPizza(String type) {

        Pizza pizza;

        pizza = factory.createPizza(type);

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }
}

// ---------------------------
// Abstract Pizza Class
// ---------------------------
abstract class Pizza {

    String name;
    String dough;
    String sauce;
    ArrayList<String> toppings = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void prepare() {
        System.out.println("Preparing " + name);
    }

    public void bake() {
        System.out.println("Baking " + name);
    }

    public void cut() {
        System.out.println("Cutting " + name);
    }

    public void box() {
        System.out.println("Boxing " + name);
    }
}

// ---------------------------
// Pizza Types
// ---------------------------
class CheesePizza extends Pizza {

    public CheesePizza() {
        name = "Cheese Pizza";
        dough = "Regular Crust";
        sauce = "Marinara Pizza Sauce";

        toppings.add("Fresh Mozzarella");
        toppings.add("Parmesan");
    }
}

class PepperoniPizza extends Pizza {

    public PepperoniPizza() {
        name = "Pepperoni Pizza";
        dough = "Regular Crust";
        sauce = "Marinara Sauce";

        toppings.add("Pepperoni");
        toppings.add("Mozzarella");
    }
}

class ClamPizza extends Pizza {

    public ClamPizza() {
        name = "Clam Pizza";
        dough = "Thin Crust";
        sauce = "Garlic Sauce";

        toppings.add("Clams");
        toppings.add("Parmesan");
    }
}

class VeggiePizza extends Pizza {

    public VeggiePizza() {
        name = "Veggie Pizza";
        dough = "Thin Crust";
        sauce = "Marinara Sauce";

        toppings.add("Mushrooms");
        toppings.add("Onions");
        toppings.add("Peppers");
    }
}

// ---------------------------
// Main Application
// ---------------------------
public class PizzaApp {

    public static void main(String[] args) {

        SimplePizzaFactory factory = new SimplePizzaFactory();
        PizzaStore store = new PizzaStore(factory);

        Pizza pizza = store.orderPizza("cheese");
        System.out.println("We ordered a " + pizza.getName() + "\n");

        pizza = store.orderPizza("veggie");
        System.out.println("We ordered a " + pizza.getName() + "\n");
    }
}
