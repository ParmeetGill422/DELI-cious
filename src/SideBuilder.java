import java.util.Scanner;

public class SideBuilder {
    public static Side build(Scanner scanner) {
        Side sides = new Side();

        System.out.println("Choose a side:");
        System.out.println("1) Au Jus");
        System.out.println("2) Sauce");
        System.out.print("Enter your choice (or anything else to skip): ");
        String input = scanner.nextLine().trim();

        if (input.equals("1")) {
            sides.addSide("Au Jus");

        } else if (input.equals("2")) {
            String[] sauces = {"Mayo", "Mustard", "Ketchup", "Ranch", "Thousand Island", "Vinaigrette"};
            System.out.println("Select a sauce:");
            for (int i = 0; i < sauces.length; i++) {
                System.out.println((i + 1) + ") " + sauces[i]);
            }

            System.out.print("Your choice: ");
            try {
                int choice = Integer.parseInt(scanner.nextLine().trim());
                if (choice >= 1 && choice <= sauces.length) {
                    sides.addSide("Sauce (" + sauces[choice - 1] + ")");
                } else {
                    System.out.println("Invalid sauce choice. Skipping.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Skipping sauce.");
            }
        } else {
            System.out.println("No side selected.");
        }

        return sides;
    }
}