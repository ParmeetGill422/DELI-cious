import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Order order = new Order();

        while (true) {
            System.out.println("\n=== Welcome to DELI-cious ===");
            System.out.println("1) New Order");
            System.out.println("2) Exit");
            System.out.print("Select: ");
            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                order.clear();
                boolean ordering = true;

                while (ordering) {
                    order.printCartSummary();
                    System.out.println("\n--- Order Menu ---");
                    System.out.println("1) Add Sandwich");
                    System.out.println("2) Add Drink");
                    System.out.println("3) Add Chips");
                    System.out.println("4) Signature Sandwiches");
                    System.out.println("5) Add Sides");
                    System.out.println("6) Checkout");
                    System.out.println("7) Cancel Order");
                    System.out.print("Select: ");
                    String option = scanner.nextLine();

                    switch (option) {
                        case "1":
                            order.addItem(SandwichBuilder.build(scanner));
                            break;
                        case "2":
                            order.addItem(DrinkBuilder.build(scanner));
                            break;
                        case "3":
                            order.addItem(ChipsBuilder.build(scanner));
                            break;
                        case "4":
                            Sandwich signature = SignatureSandwichBuilder.build(scanner);
                            if (signature != null) {
                                order.addItem(signature);
                            }
                            break;
                        case "5":
                            order.addItem(SideBuilder.build(scanner));
                            break;
                        case "6":
                            order.printFullCheckout();
                            System.out.print("Confirm order? (y/n): ");
                            if (scanner.nextLine().equalsIgnoreCase("y")) {
                                order.saveReceipt();
                                ordering = false;
                            } else {
                                order.clear();
                                System.out.println("Order cancelled.");
                            }
                            break;
                        case "7":
                            order.clear();
                            ordering = false;
                            break;
                        default:
                            System.out.println("Invalid option. Try again.");
                    }
                }
            } else if (choice.equals("2")) {
                System.out.println("Goodbye!");
                break;
            }
        }
    }
}
