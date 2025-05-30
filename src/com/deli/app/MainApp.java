package com.deli.app;
import java.util.Scanner;
import com.deli.builder.*;
import com.deli.util.ConsoleColors;

public class MainApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Order order = new Order();

        while (true) {
            System.out.println("\n*✲*´*。.❄¯*✲。❄。*¨`*✲´*  。*´✲*`¨*。❄。✲*¯❄.。*´*✲*\n" +
                    "    *╔════════════ ༺❀༻༺❀༻ ════════════╗*\n" +
                    ConsoleColors.PURPLE+"               WELCOME TO THE DELI\n"+ ConsoleColors.RESET +
                    "    *╚════════════ ༺❀༻༺❀༻ ════════════╝*\n" +
                    "*✲*´*。.❄¯*✲。❄。*¨`*✲´*  。*´✲*`¨*。❄。✲*¯❄.。*´*✲*");
            System.out.println("1)"+ConsoleColors.PURPLE+"\uD83D\uDCF2 New Order"+ConsoleColors.RESET);
            System.out.println("2)"+ConsoleColors.PURPLE+"\uD83D\uDC4B Exit"+ConsoleColors.RESET);
            System.out.print("Select option: ");
            String input = scanner.nextLine().trim();

            if (input.equals("1")) {
                handleOrder(scanner, order);
            } else if (input.equals("2")) {
                System.out.println(ConsoleColors.BRIGHT_YELLOW+ConsoleColors.UNDERLINE+"Goodbye! Don’t let the door hit you on the way out."+ConsoleColors.RESET);
                break;
            } else {
                System.out.println(ConsoleColors.RED+"Invalid selection."+ConsoleColors.RESET);
            }
        }
    }


    private static void handleOrder(Scanner scanner, Order order) {
        while (true) {
            System.out.println(ConsoleColors.BLUE+"\n--- Order Menu --- \n━◦○◦━◦○◦━◦○◦━◦○◦━"+ConsoleColors.RESET);
            order.viewCart();
            System.out.println("╔════════════════╗");
            ConsoleColors.printColored("1) Add Sandwich\uD83E\uDD6A",ConsoleColors.PURPLE);
            ConsoleColors.printColored("2) Add Drink\uD83E\uDD64",ConsoleColors.PURPLE);
            ConsoleColors.printColored("3) Add Chips\uD83C\uDF5F",ConsoleColors.PURPLE);
            ConsoleColors.printColored("4) Add Sides\uD83C\uDF6F",ConsoleColors.PURPLE);
            ConsoleColors.printColored("5) Add Signature Sandwich\uD83E\uDD6A",ConsoleColors.PURPLE);
            ConsoleColors.printColored("6) Checkout\uD83D\uDECD\uFE0F",ConsoleColors.PURPLE);
            ConsoleColors.printColored("7) Cancel Order",ConsoleColors.PURPLE);
            System.out.println("╚════════════════╝");
            System.out.print("Select option: ");
            String input = scanner.nextLine().trim();

            switch (input) {
                case "1" -> order.addItem(SandwichBuilder.build(scanner));
                case "2" -> order.addItem(DrinkBuilder.build(scanner));
                case "3" -> order.addItem(ChipsBuilder.build(scanner));
                case "4" -> order.addItem(SideBuilder.build(scanner));
                case "5" -> order.addItem(SignatureSandwichBuilder.build(scanner));
                case "6" -> {
                    order.checkout();
                    return;
                }
                case "7" -> {
                    System.out.println(ConsoleColors.UNDERLINE+ConsoleColors.BRIGHT_YELLOW+"\nThank you for canceling — now we can focus on real customers."+ConsoleColors.RESET);
                    return;
                }
                default -> System.out.println(ConsoleColors.RED+"Invalid selection."+ConsoleColors.RESET);
            }
        }
    }
}
