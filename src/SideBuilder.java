import java.util.Scanner;

public class SideBuilder {

    public static Side build(Scanner scanner) {
        System.out.println("\n Choose a side:");
        System.out.println("  1) Sauce");
        System.out.println("  2) Au Jus");

        while (true) {
            System.out.print("Select: ");
            String input = scanner.nextLine().trim();

            if (input.equals("1")) {
                String[] sauces = {
                        "Mayo", "Mustard", "Ketchup",
                        "Ranch", "Thousand Island", "Vinaigrette"
                };

                System.out.println("\n Choose a sauce flavor:");
                for (int i = 0; i < sauces.length; i++) {
                    System.out.printf("  %d) %s%n", i + 1, sauces[i]);
                }

                while (true) {
                    System.out.print("Select: ");
                    try {
                        int choice = Integer.parseInt(scanner.nextLine().trim());
                        if (choice >= 1 && choice <= sauces.length) {
                            return new Side("Sauce (" + sauces[choice - 1] + ")");
                        }
                    } catch (NumberFormatException ignored) {}
                    System.out.println(" Invalid input. Try again.");
                }

            } else if (input.equals("2")) {
                return new Side("Au Jus");
            }

            System.out.println(" Invalid input. Try again.");
        }
    }
}