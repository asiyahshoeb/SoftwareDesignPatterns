public class AbstractFactoryExample {

    // -----------------------------
    // Abstract Factory
    // -----------------------------
    static abstract class AbstractFactoryWidget {
        public abstract AbstractTextField createTextField();
        public abstract AbstractPushButton createPushButton();
    }

    // -----------------------------
    // Concrete Factories
    // -----------------------------
    static class ConcreteWindow extends AbstractFactoryWidget {

        @Override
        public AbstractTextField createTextField() {
            return new TextFieldWindow();
        }

        @Override
        public AbstractPushButton createPushButton() {
            return new PushButtonWindow();
        }
    }

    static class ConcreteMac extends AbstractFactoryWidget {

        @Override
        public AbstractTextField createTextField() {
            return new TextFieldMac();
        }

        @Override
        public AbstractPushButton createPushButton() {
            return new PushButtonMac();
        }
    }

    // -----------------------------
    // Abstract Products
    // -----------------------------
    static abstract class AbstractTextField {
        public abstract void displayName(AbstractTextField a);
    }

    static abstract class AbstractPushButton {
        public abstract void displayName(AbstractPushButton a);
    }

    // -----------------------------
    // Windows Products
    // -----------------------------
    static class TextFieldWindow extends AbstractTextField {

        @Override
        public void displayName(AbstractTextField a) {
            System.out.println("This is Window Text Field as " + a.getClass().getSimpleName());
        }
    }

    static class PushButtonWindow extends AbstractPushButton {

        @Override
        public void displayName(AbstractPushButton a) {
            System.out.println("This is Window Button as " + a.getClass().getSimpleName());
        }
    }

    // -----------------------------
    // Mac Products
    // -----------------------------
    static class TextFieldMac extends AbstractTextField {

        @Override
        public void displayName(AbstractTextField a) {
            System.out.println("This is Mac Text Field as " + a.getClass().getSimpleName());
        }
    }

    static class PushButtonMac extends AbstractPushButton {

        @Override
        public void displayName(AbstractPushButton a) {
            System.out.println("This is Mac Button as " + a.getClass().getSimpleName());
        }
    }

    // -----------------------------
    // Client
    // -----------------------------
    static class Client {

        private AbstractTextField textField;
        private AbstractPushButton pushButton;

        public Client(AbstractFactoryWidget factory) {
            pushButton = factory.createPushButton();
            textField = factory.createTextField();
        }

        public void run() {
            pushButton.displayName(pushButton);
            textField.displayName(textField);
        }
    }

    // -----------------------------
    // Main Method
    // -----------------------------
    public static void main(String[] args) {

        // Windows UI
        AbstractFactoryWidget factoryWindow = new ConcreteWindow();
        Client c1 = new Client(factoryWindow);
        c1.run();

        System.out.println();

        // Mac UI
        AbstractFactoryWidget factoryMac = new ConcreteMac();
        Client c2 = new Client(factoryMac);
        c2.run();
    }
}
