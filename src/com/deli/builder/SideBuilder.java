package com.deli.builder;
import com.deli.model.Item;
import com.deli.model.Side;
import com.deli.util.ConsoleColors;

import java.util.Scanner;

public class SideBuilder {
    public static Item build(Scanner scanner) {
        Side sides = new Side();
        System.out.println("Select a side:");
        ConsoleColors.printColored("1) Au Jus",ConsoleColors.BRIGHT_YELLOW);
        ConsoleColors.printColored("2) Sauce",ConsoleColors.BRIGHT_YELLOW);
        System.out.print("Your choice: ");
        int choice = Integer.parseInt(scanner.nextLine().trim());

        if (choice == 1) {
            sides.addSide("Au Jus");
        } else if (choice == 2) {
            String[] sauces = {"Mayo", "Mustard", "Ketchup", "Ranch", "Thousand Island", "Vinaigrette"};
            System.out.println("Select a sauce:");
            for (int i = 0; i < sauces.length; i++) {
                System.out.println((i + 1) + ") "+ConsoleColors.BRIGHT_YELLOW + sauces[i]+ConsoleColors.RESET);
            }
            System.out.print("Your choice: ");
            int sauceChoice = Integer.parseInt(scanner.nextLine().trim());
            if (sauceChoice >= 1 && sauceChoice <= sauces.length) {
                sides.addSide(("Sauce (" + sauces[sauceChoice - 1] + ")").trim());
            }
        } else {
            ConsoleColors.printColored("Invalid selection. Skipping side.",ConsoleColors.RED);
        }
        return sides;
    }
}
