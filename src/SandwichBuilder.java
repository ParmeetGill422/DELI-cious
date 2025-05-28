import java.util.Scanner;

public class SandwichBuilder {

    public static Sandwich build(Scanner scanner) {
        String size = askOption(scanner, "Choose sandwich size:",
                new String[]{"4", "8", "12"});

        String bread = askOption(scanner, "Choose bread type:",
                new String[]{"White", "Wheat", "Rye", "Wrap"});

        Sandwich sandwich = new Sandwich(size, bread);

        // Meat
        String[] meats = {"Steak", "Ham", "Salami", "Roast Beef", "Chicken", "Bacon"};
        boolean addMore = true;
        while (addMore) {
            String meat = askOption(scanner, "Choose meat:", meats);
            sandwich.addMeat(meat);
            addMore = askYesNo(scanner, "Add extra meat?");
            if (addMore) sandwich.addExtraMeat();
            addMore = askYesNo(scanner, "Add another meat?");
        }

        // Cheese
        String[] cheeses = {"American", "Cheddar", "Provolone", "Swiss"};
        addMore = true;
        while (addMore) {
            String cheese = askOption(scanner, "Choose cheese:", cheeses);
            sandwich.addCheese(cheese);
            addMore = askYesNo(scanner, "Add extra cheese?");
            if (addMore) sandwich.addExtraCheese();
            addMore = askYesNo(scanner, "Add another cheese?");
        }

        // Toast
        sandwich.setToasted(askYesNo(scanner, "Do you want the sandwich toasted?"));

        // Toppings (multi-choice)
        String[] toppings = {"Lettuce", "Peppers", "Onions", "Tomatoes", "Jalapeños", "Cucumbers", "Pickles", "Guacamole", "Mushrooms"};
        String[] selectedToppings = askMultiOptions(scanner, "Choose toppings (e.g. 1,3,5):", toppings);
        for (String topping : selectedToppings) {
            sandwich.addTopping(topping);
        }

        // Sauces (multi-choice)
        String[] sauces = {"Mayo", "Mustard", "Ketchup", "Ranch", "Thousand Island", "Vinaigrette"};
        String[] selectedSauces = askMultiOptions(scanner, "Choose sauces (e.g. 1,2,4):", sauces);
        for (String sauce : selectedSauces) {
            sandwich.addSauce(sauce);
        }

        return sandwich;
    }

    private static String askOption(Scanner scanner, String prompt, String[] options) {
        while (true) {
            System.out.println(prompt);
            for (int i = 0; i < options.length; i++) {
                System.out.printf("%d) %s%n", i + 1, options[i]);
            }
            System.out.print("Select: ");
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                if (choice >= 1 && choice <= options.length) {
                    return options[choice - 1];
                }
            } catch (NumberFormatException ignored) {}
            System.out.println("Invalid choice. Try again.");
        }
    }

    private static boolean askYesNo(Scanner scanner, String prompt) {
        System.out.print(prompt + " (y/n): ");
        String input = scanner.nextLine().trim().toLowerCase();
        return input.equals("y");
    }

    private static String[] askMultiOptions(Scanner scanner, String prompt, String[] options) {
        while (true) {
            System.out.println(prompt);
            for (int i = 0; i < options.length; i++) {
                System.out.printf("%d) %s%n", i + 1, options[i]);
            }
            System.out.print("Enter choices separated by commas: ");
            String input = scanner.nextLine();
            String[] indices = input.split(",");
            try {
                String[] results = new String[indices.length];
                for (int i = 0; i < indices.length; i++) {
                    int index = Integer.parseInt(indices[i].trim());
                    if (index >= 1 && index <= options.length) {
                        results[i] = options[index - 1];
                    } else {
                        throw new NumberFormatException();
                    }
                }
                return results;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Try again.");
            }
        }
    }
}
