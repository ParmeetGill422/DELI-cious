import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Order order = new Order();

        while (true) {
            System.out.println("≻───── ⋆✦Welcome to The Deli✦⋆ ─────≺");
            System.out.println("1) New Order");
            System.out.println("2) Exit");
            System.out.print("Select option: ");
            String input = scanner.nextLine().trim();

            if (input.equals("1")) {
                handleOrder(scanner, order);
            } else if (input.equals("2")) {
                System.out.println("Goodbye!\nDon’t let the door hit you on the way out.");
                break;
            } else {
                System.out.println("Invalid choice.");
            }
        }

        scanner.close();
    }

    private static void handleOrder(Scanner scanner, Order order) {
        while (true) {
            System.out.println("\n--- Order Menu --- \n━◦○◦━◦○◦━◦○◦━◦○◦━");
            order.viewCart();
            System.out.println("╔══════════╗");
            System.out.println("1) Add Sandwich");
            System.out.println("2) Add Drink");
            System.out.println("3) Add Chips");
            System.out.println("4) Add Sides");
            System.out.println("5) Add Signature Sandwich");
            System.out.println("6) Checkout");
            System.out.println("7) Cancel Order");
            System.out.println("╚══════════╝");
            System.out.print("Select option: ");
            String input = scanner.nextLine().trim();

            switch (input) {
                case "1" -> order.addItem(SandwichBuilder.build(scanner));
                case "2" -> order.addItem(DrinkBuilder.build(scanner));
                case "3" -> order.addItem(ChipsBuilder.build(scanner));
                case "4" -> order.addItem(SideBuilder.build(scanner));
                case "5" -> order.addItem(SignatureSandwichBuilder.build(scanner));
                case "6" -> {
                    order.checkout();
                    return;
                }
                case "7" -> {
                    System.out.println("Thank you for canceling — now we can focus on real customers.");
                    return;
                }
                default -> System.out.println("Invalid selection.");
            }
        }
    }
}
