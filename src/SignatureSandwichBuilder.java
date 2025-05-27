import java.util.Scanner;

public class SignatureSandwichBuilder {
    public static Sandwich build(Scanner scanner) {
        String[] options = {"BLT", "Philly Cheese Steak"};
        String choice = askOption(scanner, "Choose a signature sandwich:", options);

        if (choice.equals("BLT")) {
            Sandwich blt = new Sandwich("8", "White");
            blt.addMeat("Bacon");
            blt.addCheese("Cheddar");
            blt.addTopping("Lettuce");
            blt.addTopping("Tomatoes");
            blt.addSauce("Ranch");
            blt.setToasted(true);
            return blt;
        } else if (choice.equals("Philly Cheese Steak")) {
            Sandwich philly = new Sandwich("8", "White");
            philly.addMeat("Steak");
            philly.addCheese("American");
            philly.addTopping("Peppers");
            philly.addSauce("Mayo");
            philly.setToasted(true);
            return philly;
        }

        return null;
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
