package com.deli.builder;
import java.util.Scanner;
import com.deli.model.Drink;
import com.deli.model.Item;
import com.deli.util.ConsoleColors;

public class DrinkBuilder {
    public static Item build(Scanner scanner) {
        Drink drink = new Drink();

        String[] sizes = {"Small", "Medium", "Large"};
        String[] types = {"Coke", "Sprite", "Pepsi", "Root Beer", "Lemonade"};

        System.out.println("Select a drink size:");
        for (int i = 0; i < sizes.length; i++) {
            System.out.println((i + 1) + ") "+ConsoleColors.BRIGHT_BLUE + sizes[i]+ConsoleColors.RESET);
        }
        System.out.print("Your choice: ");
        int sizeChoice = Integer.parseInt(scanner.nextLine().trim());

        System.out.println("Select a drink type:");
        for (int i = 0; i < types.length; i++) {
            System.out.println((i + 1) + ") "+ConsoleColors.BRIGHT_BLUE + types[i]+ConsoleColors.RESET);
        }
        System.out.print("Your choice: ");
        int typeChoice = Integer.parseInt(scanner.nextLine().trim());

        if (sizeChoice >= 1 && sizeChoice <= sizes.length && typeChoice >= 1 && typeChoice <= types.length) {
            String finalDrink = (sizes[sizeChoice - 1] + " " + types[typeChoice - 1]).trim();
            drink.addDrink(finalDrink);
        } else {
            ConsoleColors.printColored("Invalid selection. Skipping drink.",ConsoleColors.RED);
        }
        return drink;
    }
}
