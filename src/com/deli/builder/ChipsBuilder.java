package com.deli.builder;
import java.util.Scanner;
import com.deli.model.Chips;
import com.deli.model.Item;

public class ChipsBuilder {
    public static Item build(Scanner scanner) {
        Chips chips = new Chips();
        String[] flavors = {"BBQ", "Original", "Salt and Vinegar", "Sour Cream"};

        System.out.println("Select chip flavor:");
        for (int i = 0; i < flavors.length; i++) {
            System.out.println((i + 1) + ") " + flavors[i]);
        }
        System.out.print("Your choice: ");
        int choice = Integer.parseInt(scanner.nextLine().trim());

        if (choice >= 1 && choice <= flavors.length) {
            chips.addFlavor(flavors[choice - 1].trim());
        } else {
            System.out.println("Invalid selection. Skipping chips.");
        }

        return chips;
    }
}
