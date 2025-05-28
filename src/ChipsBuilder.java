import java.util.Scanner;

public class ChipsBuilder {

    public static Chips build(Scanner scanner) {
        String[] flavors = {
                "BBQ",
                "Original",
                "Salt and Vinegar",
                "Sour Cream & Onion",
                "Jalapeño"
        };

        System.out.println("\n Choose a chip flavor:");
        for (int i = 0; i < flavors.length; i++) {
            System.out.printf("  %d) %s%n", i + 1, flavors[i]);
        }

        while (true) {
            System.out.print("Select: ");
            try {
                int choice = Integer.parseInt(scanner.nextLine().trim());
                if (choice >= 1 && choice <= flavors.length) {
                    return new Chips(flavors[choice - 1]);
                }
            } catch (NumberFormatException ignored) {}
            System.out.println(" Invalid input. Try again.");
        }
    }
}