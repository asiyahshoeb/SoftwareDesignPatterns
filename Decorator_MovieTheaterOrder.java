import java.util.*;

// ---------------- COMPONENT ----------------
abstract class PackageItem {
    public abstract double cost();
    public abstract void printReceipt();
}

// ---------------- CONCRETE COMPONENT ----------------
class Ticket extends PackageItem {

    private String type;
    private double price;

    public Ticket(String type) {
        this.type = type;

        if(type.equalsIgnoreCase("Adult"))
            price = 10;
        else
            price = 8;
    }

    public double cost() {
        return price;
    }

    public void printReceipt() {
        System.out.printf("%-15s qty:1  unit:$%.2f  cost:$%.2f\n",
                type + " Ticket", price, price);
    }
}

// ---------------- DECORATOR ----------------
abstract class ItemDecorator extends PackageItem {
    protected PackageItem item;

    public ItemDecorator(PackageItem item) {
        this.item = item;
    }
}

// ---------------- POPCORN ----------------
class Popcorn extends ItemDecorator {

    private double quantity;
    private double unitPrice = 6;

    public Popcorn(PackageItem item, double quantity) {
        super(item);
        this.quantity = quantity;
    }

    public double cost() {
        return item.cost() + (unitPrice * quantity);
    }

    public void printReceipt() {
        item.printReceipt();
        double itemCost = unitPrice * quantity;

        System.out.printf("%-15s qty:%.2f unit:$%.2f cost:$%.2f\n",
                "Popcorn", quantity, unitPrice, itemCost);
    }
}

// ---------------- CHIPS ----------------
class Chips extends ItemDecorator {

    private double quantity;
    private double unitPrice = 4;

    public Chips(PackageItem item, double quantity) {
        super(item);
        this.quantity = quantity;
    }

    public double cost() {
        return item.cost() + (unitPrice * quantity);
    }

    public void printReceipt() {
        item.printReceipt();
        double itemCost = unitPrice * quantity;

        System.out.printf("%-15s qty:%.2f unit:$%.2f cost:$%.2f\n",
                "Chips", quantity, unitPrice, itemCost);
    }
}

// ---------------- DRINK ----------------
class Drink extends ItemDecorator {

    private double quantity;
    private String type;
    private double unitPrice = 2;

    public Drink(PackageItem item, String type, double quantity) {
        super(item);
        this.type = type;
        this.quantity = quantity;
    }

    public double cost() {
        return item.cost() + (unitPrice * quantity);
    }

    public void printReceipt() {
        item.printReceipt();
        double itemCost = unitPrice * quantity;

        System.out.printf("%-15s qty:%.2f unit:$%.2f cost:$%.2f\n",
                type, quantity, unitPrice, itemCost);
    }
}

// ---------------- SINGLETON ----------------
class GiftManager {

    private static GiftManager instance = new GiftManager();
    private boolean giftTaken = false;

    private GiftManager(){}

    public static GiftManager getInstance() {
        return instance;
    }

    public boolean giveGift() {
        if(!giftTaken) {
            giftTaken = true;
            return true;
        }
        return false;
    }
}

// ---------------- GIFT DECORATOR ----------------
class Gift extends ItemDecorator {

    public Gift(PackageItem item) {
        super(item);
    }

    public double cost() {
        return item.cost();
    }

    public void printReceipt() {
        item.printReceipt();

        if(GiftManager.getInstance().giveGift()) {
            System.out.printf("%-15s qty:1 unit:$0.00 cost:$0.00\n", "Free Gift");
        }
        else {
            System.out.println("Gift already used for this order.");
        }
    }
}

// ---------------- CLIENT ----------------
public class MovieTheaterOrder {

    public static void main(String[] args) {

        // Order: 1 student ticket
        PackageItem order = new Ticket("Student");

        // Decorate order
        order = new Popcorn(order, 0.6);
        order = new Chips(order, 0.4);
        order = new Drink(order, "Coke", 2);
        order = new Gift(order);

        System.out.println("------- RECEIPT -------");

        // Print Adult ticket separately
        Ticket adult = new Ticket("Adult");
        adult.printReceipt();

        // Print decorated order
        order.printReceipt();

        double total = adult.cost() + order.cost();

        System.out.println("-----------------------");
        System.out.printf("TOTAL COST: $%.2f\n", total);
    }
}
