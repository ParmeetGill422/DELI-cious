import java.io.*;
import java.nio.file.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class Order {
    private Deque<Item> cart = new ArrayDeque<>();

    public void addItem(Item item) {
        cart.addFirst(item);
    }

    public void printCartSummary() {
        System.out.println("--- Current Order ---");
        if (cart.isEmpty()) {
            System.out.println("No items yet.");
        } else {
            int i = 1;
            for (Item item : cart) {
                System.out.println(i++ + ". " + item.getDescription());
            }
        }
    }

    public void printFullCheckout() {
        double total = 0.0;
        System.out.println("==== Checkout ====");

        Map<String, List<Item>> categorized = new LinkedHashMap<>();
        categorized.put("Sandwiches", new ArrayList<>());
        categorized.put("Drinks", new ArrayList<>());
        categorized.put("Chips", new ArrayList<>());
        categorized.put("Sides", new ArrayList<>());

        for (Item item : cart) {
            if (item instanceof Sandwich) categorized.get("Sandwiches").add(item);
            else if (item instanceof Drink) categorized.get("Drinks").add(item);
            else if (item instanceof Chips) categorized.get("Chips").add(item);
            else if (item instanceof Side) categorized.get("Sides").add(item);
        }

        for (Map.Entry<String, List<Item>> entry : categorized.entrySet()) {
            if (!entry.getValue().isEmpty()) {
                System.out.println(entry.getKey() + ":");
                for (Item item : entry.getValue()) {
                    if (item instanceof Side) {
                        System.out.println("- " + item.getDescription());
                    } else {
                        System.out.printf("- %-40s $%.2f\n", item.getDescription(), item.getPrice());
                        total += item.getPrice();
                    }
                }
            }
        }

        System.out.printf("TOTAL: $%.2f\n", total);
    }

    public void saveReceipt() {
        if (cart.isEmpty()) return;

        String timestamp = new SimpleDateFormat("yyyyMMdd-HHmmss").format(new Date());
        Path folder = Paths.get("receipts");
        Path file = folder.resolve(timestamp + ".txt");

        try {
            if (!Files.exists(folder)) Files.createDirectories(folder);
            BufferedWriter writer = Files.newBufferedWriter(file);

            double total = 0.0;
            writer.write("==== DELI-cious Receipt ====\n");

            Map<String, List<Item>> categorized = new LinkedHashMap<>();
            categorized.put("Sandwiches", new ArrayList<>());
            categorized.put("Drinks", new ArrayList<>());
            categorized.put("Chips", new ArrayList<>());
            categorized.put("Sides", new ArrayList<>());

            for (Item item : cart) {
                if (item instanceof Sandwich) categorized.get("Sandwiches").add(item);
                else if (item instanceof Drink) categorized.get("Drinks").add(item);
                else if (item instanceof Chips) categorized.get("Chips").add(item);
                else if (item instanceof Side) categorized.get("Sides").add(item);
            }

            for (Map.Entry<String, List<Item>> entry : categorized.entrySet()) {
                if (!entry.getValue().isEmpty()) {
                    writer.write("\n" + entry.getKey() + ":\n");
                    for (Item item : entry.getValue()) {
                        if (item instanceof Side) {
                            writer.write("- " + item.getDescription() + "\n");
                        } else {
                            writer.write(String.format("- %-40s $%.2f\n", item.getDescription(), item.getPrice()));
                            total += item.getPrice();
                        }
                    }
                }
            }

            writer.write(String.format("\nTOTAL: $%.2f\n", total));
            writer.close();

            System.out.println("Receipt saved to: " + file.toAbsolutePath());
        } catch (IOException e) {
            System.out.println("Error saving receipt: " + e.getMessage());
        }
    }

    public void clear() { cart.clear(); }

    public boolean isEmpty() { return cart.isEmpty(); }
}
