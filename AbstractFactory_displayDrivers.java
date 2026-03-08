// ---------------------------
// Product Interfaces
// ---------------------------
interface DisplayDriver {
    void draw();
}

interface PrintDriver {
    void print();
}

// ---------------------------
// Concrete Display Drivers
// ---------------------------
class LRDD implements DisplayDriver {
    public void draw() {
        System.out.println("Drawing in low resolution display.");
    }
}

class HRDD implements DisplayDriver {
    public void draw() {
        System.out.println("Drawing in high resolution display.");
    }
}

// ---------------------------
// Concrete Print Drivers
// ---------------------------
class LRPD implements PrintDriver {
    public void print() {
        System.out.println("Printing in low resolution.");
    }
}

class HRPD implements PrintDriver {
    public void print() {
        System.out.println("Printing in high resolution.");
    }
}

// ---------------------------
// Abstract Factory
// ---------------------------
abstract class ResFactory {
    public abstract DisplayDriver getDispDriver();
    public abstract PrintDriver getPrtDriver();
}

// ---------------------------
// Concrete Factories
// ---------------------------
class LowResFact extends ResFactory {
    public DisplayDriver getDispDriver() {
        return new LRDD();
    }

    public PrintDriver getPrtDriver() {
        return new LRPD();
    }
}

class HighResFact extends ResFactory {
    public DisplayDriver getDispDriver() {
        return new HRDD();
    }

    public PrintDriver getPrtDriver() {
        return new HRPD();
    }
}

// ---------------------------
// Application Control
// ---------------------------
class ApControl {
    private DisplayDriver myDisplayDriver;
    private PrintDriver myPrintDriver;

    public ApControl(ResFactory factory) {
        myDisplayDriver = factory.getDispDriver();
        myPrintDriver = factory.getPrtDriver();
    }

    public void doDraw() {
        myDisplayDriver.draw();
    }

    public void doPrint() {
        myPrintDriver.print();
    }
}

// ---------------------------
// Main Application
// ---------------------------
public class AbstractFactoryExample {
    public static void main(String[] args) {

        // Low Resolution
        ResFactory lowFactory = new LowResFact();
        ApControl lowApp = new ApControl(lowFactory);
        System.out.println("Low Resolution:");
        lowApp.doDraw();
        lowApp.doPrint();

        System.out.println();

        // High Resolution
        ResFactory highFactory = new HighResFact();
        ApControl highApp = new ApControl(highFactory);
        System.out.println("High Resolution:");
        highApp.doDraw();
        highApp.doPrint();
    }
}
