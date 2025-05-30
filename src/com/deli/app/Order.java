package com.deli.app;
import com.deli.model.*;
import com.deli.util.ConsoleColors;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.io.File;

public class Order {
    private List<Item> cart = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);

    public void addItem(Item item) {
        if (item instanceof Drink newDrink) {
            for (Item existing : cart) {
                if (existing instanceof Drink existingDrink) {
                    for (String d : newDrink.getDrinks()) {
                        existingDrink.addDrink(d);
                    }
                    return;
                }
            }
        } else if (item instanceof Chips newChips) {
            for (Item existing : cart) {
                if (existing instanceof Chips existingChips) {
                    for (String f : newChips.getFlavors()) {
                        existingChips.addFlavor(f);
                    }
                    return;
                }
            }
        } else if (item instanceof Side newSides) {
            for (Item existing : cart) {
                if (existing instanceof Side existingSides) {
                    for (String s : newSides.getSideItems()) {
                        existingSides.addSide(s);
                    }
                    return;
                }
            }
        }

        // Sandwiches and anything else
        cart.add(0, item);
    }

    public void viewCart() {
        System.out.println(ConsoleColors.CYAN+"\n🛒 Current Cart\n┄┄┄┄┄┄┄┄┄┄┄┄┄┄"+ ConsoleColors.RESET);
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

        System.out.println(ConsoleColors.GREEN+"\n    💳 Checkout\n≿━━━━━━༺❀༻━━━━━━≾"+ConsoleColors.RESET);
        double total = 0.0;
        for (Item item : cart) {
            System.out.println(item.getDescription());
            System.out.println();
            total += item.getPrice();
        }

        System.out.printf("Total:\uD83D\uDCB5 $%.2f%n", total);
        System.out.print("\nConfirm order? (y/n): ");
        if (scanner.nextLine().trim().equalsIgnoreCase("y")) {
            saveReceipt();
            System.out.println(ConsoleColors.GREEN +"\n✅ Order Confirmed. \uD83E\uDDFEReceipt saved."+ ConsoleColors.RESET);
            cart.clear();
        } else {
            System.out.println(ConsoleColors.RED +"\n❌ Order cancelled.Go waste someone else’s time."+ ConsoleColors.RESET);
        }
    }

    private void saveReceipt() {
        String timestamp = new SimpleDateFormat("yyyyMMdd-HHmmss").format(new Date());
        String filename = "receipts/" + timestamp + ".txt";

        // Ensure the receipts directory exists
        File directory = new File("receipts");
        if (!directory.exists()) {
            directory.mkdirs();  // Create the directory if it doesn't exist
        }

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
