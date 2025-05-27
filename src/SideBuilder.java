import java.util.Scanner;

public class SideBuilder {
    public static Side build(Scanner scanner) {
        String[] sides = {"Sauce", "Au-Jus"};
        return new Side(askOption(scanner, "Choose a side (free):", sides));
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
