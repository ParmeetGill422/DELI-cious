import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Order {
    private List<Item> cart = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);

    public void addItem(Item item) {
        cart.add(0, item); // newest item first
    }

    public void viewCart() {
        System.out.println("\n🛒 Current Cart:");
        if (cart.isEmpty()) {
            System.out.println("Your cart is empty.");
        } else {
            for (Item item : cart) {
                if (item instanceof Sandwich sandwich) {
                    System.out.println(sandwich.getSummaryDescription());
                } else if (item instanceof Drink drink) {
                    System.out.println(drink.getSummaryDescription());
                } else if (item instanceof Chips chips) {
                    System.out.println(chips.getSummaryDescription());
                } else if (item instanceof Side sides) {
                    System.out.println(sides.getSummaryDescription());
                } else {
                    System.out.println(item.getDescription());
                }
            }
        }
        System.out.println();
    }

    public void checkout() {
        if (cart.isEmpty()) {
            System.out.println("Your cart is empty.");
            return;
        }

        System.out.println("\n💳 Checkout:");
        double total = 0.0;
        for (Item item : cart) {
            System.out.println(item.getDescription());
            System.out.println(); // spacing between items
            total += item.getPrice();
        }

        System.out.printf("Total: $%.2f%n", total);
        System.out.print("Confirm order? (y/n): ");
        if (scanner.nextLine().trim().equalsIgnoreCase("y")) {
            saveReceipt();
            System.out.println("✅ Order confirmed! Receipt saved.");
            cart.clear();
        } else {
            System.out.println("❌ Order cancelled.");
        }
    }

    private void saveReceipt() {
        String timestamp = new SimpleDateFormat("yyyyMMdd-HHmmss").format(new Date());
        String filename = "receipts/" + timestamp + ".txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Item item : cart) {
                writer.write(item.getDescription());
                writer.newLine();
                writer.newLine();
            }
            double total = cart.stream().mapToDouble(Item::getPrice).sum();
            writer.write(String.format("Total: $%.2f", total));
        } catch (IOException e) {
            System.out.println("Error saving receipt: " + e.getMessage());
        }
    }
}
