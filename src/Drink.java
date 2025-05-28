import java.util.ArrayList;
import java.util.List;

public class Drink implements Item {
    private List<String> drinks = new ArrayList<>();

    public void addDrink(String drink) {
        drinks.add(drink.trim());
    }

    public List<String> getDrinks() {
        return drinks;
    }

    @Override
    public double getPrice() {
        double total = 0;
        for (String entry : drinks) {
            if (entry.startsWith("Small")) total += 2.00;
            else if (entry.startsWith("Medium")) total += 2.50;
            else if (entry.startsWith("Large")) total += 3.00;
        }
        return total;
    }

    @Override
    public String getDescription() {
        return "\uD83E\uDD64Drinks: " + ItemUtils.formatWithCounts(drinks);
    }

    public String getSummaryDescription() {
        return "\uD83E\uDD64Drinks: " + ItemUtils.formatWithCounts(drinks);
    }
}
