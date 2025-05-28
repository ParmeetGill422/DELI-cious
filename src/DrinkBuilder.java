import java.util.Scanner;

public class DrinkBuilder {
    public static Drink build(Scanner scanner) {
        Drink drink = new Drink();

        String[] sizes = {"Small", "Medium", "Large"};
        String[] types = {"Coke", "Sprite", "Pepsi", "Root Beer", "Lemonade"};

        System.out.println("Select a drink size:");
        for (int i = 0; i < sizes.length; i++) {
            System.out.println((i + 1) + ") " + sizes[i]);
        }
        System.out.print("Your choice: ");
        int sizeChoice = Integer.parseInt(scanner.nextLine().trim());

        System.out.println("Select a drink type:");
        for (int i = 0; i < types.length; i++) {
            System.out.println((i + 1) + ") " + types[i]);
        }
        System.out.print("Your choice: ");
        int typeChoice = Integer.parseInt(scanner.nextLine().trim());

        if (sizeChoice >= 1 && sizeChoice <= sizes.length && typeChoice >= 1 && typeChoice <= types.length) {
            String finalDrink = (sizes[sizeChoice - 1] + " " + types[typeChoice - 1]).trim();
            drink.addDrink(finalDrink);
        } else {
            System.out.println("Invalid selection. Skipping drink.");
        }

        return drink;
    }
}
