package com.deli.builder;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.deli.model.Item;
import com.deli.model.Sandwich;

public class SandwichBuilder {

    public static Item build(Scanner scanner) {
        List<String> sizes = Arrays.asList("4", "8", "12");
        List<String> breads = Arrays.asList("White", "Wheat", "Rye", "Wrap");
        List<String> meats = Arrays.asList("Steak", "Ham", "Salami", "Roast Beef", "Chicken", "Bacon");
        List<String> cheeses = Arrays.asList("American", "Cheddar", "Provolone", "Swiss");
        List<String> toppings = Arrays.asList("Lettuce", "Peppers", "Onions", "Tomatoes", "Jalapeños", "Cucumbers", "Pickles", "Guacamole", "Mushrooms");
        List<String> sauces = Arrays.asList("Mayo", "Mustard", "Ketchup", "Ranch", "Thousand Island", "Vinaigrette");

        System.out.println("Choose sandwich size:");
        printOptions(sizes);
        String size = sizes.get(getUserChoice(scanner, sizes.size()));

        System.out.println("Choose bread type:");
        printOptions(breads);
        String bread = breads.get(getUserChoice(scanner, breads.size()));

        Sandwich sandwich = new Sandwich(size, bread);

        System.out.println("Choose meats (enter numbers separated by commas):");
        printOptions(meats);
        for (int index : getMultipleChoices(scanner)) {
            String meat = meats.get(index);
            if (askYesNo(scanner, "Add extra " + meat + "?")) {
                sandwich.addExtraMeat(meat);
            } else {
                sandwich.addMeat(meat);
            }
        }

        System.out.println("Choose cheeses (enter numbers separated by commas):");
        printOptions(cheeses);
        for (int index : getMultipleChoices(scanner)) {
            String cheese = cheeses.get(index);
            if (askYesNo(scanner, "Add extra " + cheese + "?")) {
                sandwich.addExtraCheese(cheese);
            } else {
                sandwich.addCheese(cheese);
            }
        }

        if (askYesNo(scanner, "Toasted?")) {
            sandwich.setToasted(true);
        }

        System.out.println("Choose toppings (enter numbers separated by commas):");
        printOptions(toppings);
        for (int index : getMultipleChoices(scanner)) {
            sandwich.addTopping(toppings.get(index));
        }

        System.out.println("Choose sauces (enter numbers separated by commas):");
        printOptions(sauces);
        for (int index : getMultipleChoices(scanner)) {
            sandwich.addSauce(sauces.get(index));
        }

        return sandwich;
    }

    private static void printOptions(List<String> options) {
        for (int i = 0; i < options.size(); i++) {
            System.out.printf("  %d) %s%n", i + 1, options.get(i));
        }
    }

    private static int getUserChoice(Scanner scanner, int max) {
        while (true) {
            try {
                int choice = Integer.parseInt(scanner.nextLine().trim()) - 1;
                if (choice >= 0 && choice < max) return choice;
            } catch (NumberFormatException ignored) {}
            System.out.print("Invalid. Try again: ");
        }
    }

    private static List<Integer> getMultipleChoices(Scanner scanner) {
        while (true) {
            try {
                String input = scanner.nextLine().trim();
                return Arrays.stream(input.split(","))
                        .map(s -> Integer.parseInt(s.trim()) - 1)
                        .filter(i -> i >= 0)
                        .toList();
            } catch (Exception e) {
                System.out.print("Invalid input. Try again (e.g., 1,3,5): ");
            }
        }
    }

    private static boolean askYesNo(Scanner scanner, String message) {
        System.out.print(message + " (y/n): ");
        String input = scanner.nextLine().trim().toLowerCase();
        return input.equals("y");
    }
}