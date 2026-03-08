import java.util.ArrayList;

// ---------------------------
// Abstract Factory
// ---------------------------
abstract class PizzaFactory {
    abstract Pizza createPizza(String type);
}

// ---------------------------
// NY Pizza Factory
// ---------------------------
class NYPizzaFactory extends PizzaFactory {

    Pizza createPizza(String item) {

        if (item.equals("cheese")) {
            return new NYStyleCheesePizza();
        } 
        else if (item.equals("veggie")) {
            return new NYStyleVeggiePizza();
        } 
        else if (item.equals("clam")) {
            return new NYStyleClamPizza();
        } 
        else if (item.equals("pepperoni")) {
            return new NYStylePepperoniPizza();
        }

        return null;
    }
}

// ---------------------------
// Chicago Pizza Factory
// ---------------------------
class ChicagoPizzaFactory extends PizzaFactory {

    Pizza createPizza(String item) {

        if (item.equals("cheese")) {
            return new ChicagoStyleCheesePizza();
        } 
        else if (item.equals("veggie")) {
            return new ChicagoStyleVeggiePizza();
        } 
        else if (item.equals("clam")) {
            return new ChicagoStyleClamPizza();
        } 
        else if (item.equals("pepperoni")) {
            return new ChicagoStylePepperoniPizza();
        }

        return null;
    }
}

// ---------------------------
// Abstract Pizza
// ---------------------------
abstract class Pizza {

    String name;
    String dough;
    String sauce;
    ArrayList<String> toppings = new ArrayList<>();

    void prepare() {
        System.out.println("Preparing " + name);
        System.out.println("Tossing dough...");
        System.out.println("Adding sauce...");
        System.out.println("Adding toppings:");

        for (String topping : toppings) {
            System.out.println(" " + topping);
        }
    }

    void bake() {
        System.out.println("Bake for 25 minutes at 350");
    }

    void cut() {
        System.out.println("Cutting the pizza into diagonal slices");
    }

    void box() {
        System.out.println("Place pizza in official PizzaStore box");
    }

    public String getName() {
        return name;
    }

    public String toString() {

        StringBuilder display = new StringBuilder();

        display.append("---- " + name + " ----\n");
        display.append(dough + "\n");
        display.append(sauce + "\n");

        for (String topping : toppings) {
            display.append(topping + "\n");
        }

        return display.toString();
    }
}

// ---------------------------
// NY Pizza Types
// ---------------------------
class NYStyleCheesePizza extends Pizza {
    public NYStyleCheesePizza() {
        name = "NY Style Cheese Pizza";
        dough = "Thin Crust Dough";
        sauce = "Marinara Sauce";

        toppings.add("Grated Reggiano Cheese");
    }
}

class NYStyleVeggiePizza extends Pizza {
    public NYStyleVeggiePizza() {
        name = "NY Style Veggie Pizza";
        dough = "Thin Crust Dough";
        sauce = "Marinara Sauce";

        toppings.add("Grated Reggiano Cheese");
        toppings.add("Garlic");
        toppings.add("Onions");
    }
}

class NYStyleClamPizza extends Pizza {
    public NYStyleClamPizza() {
        name = "NY Style Clam Pizza";
        dough = "Thin Crust Dough";
        sauce = "Marinara Sauce";

        toppings.add("Grated Reggiano Cheese");
        toppings.add("Fresh Clams from Long Island Sound");
    }
}

class NYStylePepperoniPizza extends Pizza {
    public NYStylePepperoniPizza() {
        name = "NY Style Pepperoni Pizza";
        dough = "Thin Crust Dough";
        sauce = "Marinara Sauce";

        toppings.add("Grated Reggiano Cheese");
        toppings.add("Pepperoni");
    }
}

// ---------------------------
// Chicago Pizza Types
// ---------------------------
class ChicagoStyleCheesePizza extends Pizza {
    public ChicagoStyleCheesePizza() {
        name = "Chicago Style Cheese Pizza";
        dough = "Extra Thick Crust Dough";
        sauce = "Plum Tomato Sauce";

        toppings.add("Shredded Mozzarella");
    }

    void cut() {
        System.out.println("Cutting the pizza into square slices");
    }
}

class ChicagoStyleVeggiePizza extends Pizza {
    public ChicagoStyleVeggiePizza() {
        name = "Chicago Style Veggie Pizza";
        dough = "Extra Thick Crust Dough";
        sauce = "Plum Tomato Sauce";

        toppings.add("Shredded Mozzarella");
        toppings.add("Black Olives");
    }
}

class ChicagoStyleClamPizza extends Pizza {
    public ChicagoStyleClamPizza() {
        name = "Chicago Style Clam Pizza";
        dough = "Extra Thick Crust Dough";
        sauce = "Plum Tomato Sauce";

        toppings.add("Shredded Mozzarella");
        toppings.add("Frozen Clams");
    }
}

class ChicagoStylePepperoniPizza extends Pizza {
    public ChicagoStylePepperoniPizza() {
        name = "Chicago Style Pepperoni Pizza";
        dough = "Extra Thick Crust Dough";
        sauce = "Plum Tomato Sauce";

        toppings.add("Shredded Mozzarella");
        toppings.add("Pepperoni");
    }
}

// ---------------------------
// Main Program
// ---------------------------
public class PizzaApp {

    public static void main(String[] args) {

        PizzaFactory nyFactory = new NYPizzaFactory();
        PizzaFactory chiFactory = new ChicagoPizzaFactory();

        Pizza pizza = nyFactory.createPizza("clam");

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        System.out.println("Ethan ordered a " + pizza.getName() + "\n");
    }
}
