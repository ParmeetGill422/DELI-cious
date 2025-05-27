import java.util.*;

public class SandwichBuilder {
    private static final String[] breadTypes = {"White", "Wheat", "Rye", "Wrap"};
    private static final String[] meatOptions = {"Steak", "Ham", "Salami", "Roast Beef", "Chicken", "Bacon"};
    private static final String[] cheeseOptions = {"American", "Cheddar", "Provolone", "Swiss"};
    private static final String[] toppingOptions = {"Lettuce", "Peppers", "Onions", "Tomatoes", "Jalapeños", "Cucumbers", "Pickles", "Guacamole", "Mushrooms"};
    private static final String[] sauceOptions = {"Mayo", "Mustard", "Ketchup", "Ranch", "Thousand Island", "Vinaigrette"};

    public static Sandwich build(Scanner scanner) {
        System.out.println("=== Build Your Sandwich ===");

        // Ask for size first
        String[] sizes = {"4\" ($5.50)", "8\" ($7.00)", "12\" ($8.50)"};
        String sizeInput = askOption(scanner, "Choose sandwich size:", sizes);
        String size = sizeInput.split("\"")[0];

        Sandwich sandwich = new Sandwich(size, "");

        boolean done = false;
        while (!done) {
            System.out.println("\n=== Sandwich Menu ===");
            System.out.println("1) Bread");
            System.out.println("2) Meat");
            System.out.println("3) Cheese");
            System.out.println("4) Toast");
            System.out.println("5) Toppings");
            System.out.println("6) Sauce");
            System.out.println("7) Done (Back to Order Menu)");
            System.out.print("Select: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1": // Bread
                    sandwich = new Sandwich(size, askOption(scanner, "Choose bread type:", breadTypes));
                    break;
                case "2": // Meat
                    do {
                        sandwich.addMeat(askOption(scanner, "Add meat:", meatOptions));
                        System.out.print("Add extra meat? (y/n): ");
                        if (scanner.nextLine().equalsIgnoreCase("y")) {
                            sandwich.addExtraMeat();
                        } else break;
                    } while (true);
                    break;
                case "3": // Cheese
                    do {
                        sandwich.addCheese(askOption(scanner, "Add cheese:", cheeseOptions));
                        System.out.print("Add extra cheese? (y/n): ");
                        if (scanner.nextLine().equalsIgnoreCase("y")) {
                            sandwich.addExtraCheese();
                        } else break;
                    } while (true);
                    break;
                case "4": // Toast
                    System.out.print("Toasted? (y/n): ");
                    sandwich.setToasted(scanner.nextLine().equalsIgnoreCase("y"));
                    break;
                case "5": // Toppings
                    do {
                        sandwich.addTopping(askOption(scanner, "Add topping:", toppingOptions));
                        System.out.print("Add another topping? (y/n): ");
                    } while (scanner.nextLine().equalsIgnoreCase("y"));
                    break;
                case "6": // Sauce
                    do {
                        sandwich.addSauce(askOption(scanner, "Add sauce:", sauceOptions));
                        System.out.print("Add another sauce? (y/n): ");
                    } while (scanner.nextLine().equalsIgnoreCase("y"));
                    break;
                case "7":
                    done = true;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }

        return sandwich;
    }

    private static String askOption(Scanner scanner, String prompt, String[] options) {
        while (true) {
            System.out.println(prompt);
            for (int i = 0; i < options.length; i++) {
                System.out.println((i + 1) + ") " + options[i]);
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
}
