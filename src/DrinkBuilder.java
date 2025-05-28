import java.util.Scanner;

public class DrinkBuilder {
    public static Drink build(Scanner scanner) {
        String[] sizes = {"Small ($2.00)", "Medium ($2.50)", "Large ($3.00)"};
        String size = askOption(scanner, "Choose drink size:", sizes);
        size = size.split(" ")[0];

        String[] types = {"Coke", "Diet Coke", "Sprite", "Hansen’s Diet"};
        String type = askOption(scanner, "Choose drink type:", types);

        Drink drink = new Drink();
        drink.addSize(size);
        return drink;
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
