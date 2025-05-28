import java.util.ArrayList;
import java.util.List;

public class Sandwich implements Item {
    private String size;
    private String bread;
    private List<String> meats = new ArrayList<>();
    private List<String> cheeses = new ArrayList<>();
    private List<String> toppings = new ArrayList<>();
    private List<String> sauces = new ArrayList<>();
    private boolean toasted = false;
    private List<String> extraMeats = new ArrayList<>();
    private List<String> extraCheeses = new ArrayList<>();

    public Sandwich(String size, String bread) {
        this.size = size;
        this.bread = bread;
    }

    public void addMeat(String meat) {
        meats.add(meat);
    }

    public void addExtraMeat(String meat) {
        extraMeats.add(meat + " (extra)");
    }

    public void addCheese(String cheese) {
        cheeses.add(cheese);
    }

    public void addExtraCheese(String cheese) {
        extraCheeses.add(cheese + " (extra)");
    }

    public void addTopping(String topping) {
        toppings.add(topping);
    }

    public void addSauce(String sauce) {
        sauces.add(sauce);
    }

    public void setToasted(boolean toasted) {
        this.toasted = toasted;
    }

    @Override
    public double getPrice() {
        double base = switch (size) {
            case "4" -> 5.50;
            case "8" -> 7.00;
            case "12" -> 8.50;
            default -> 0;
        };
        double meatPrice = switch (size) {
            case "4" -> meats.size() * 1.00 + extraMeats.size() * 0.50;
            case "8" -> meats.size() * 2.00 + extraMeats.size() * 1.00;
            case "12" -> meats.size() * 3.00 + extraMeats.size() * 1.50;
            default -> 0;
        };
        double cheesePrice = switch (size) {
            case "4" -> cheeses.size() * 0.75 + extraCheeses.size() * 0.30;
            case "8" -> cheeses.size() * 1.50 + extraCheeses.size() * 0.60;
            case "12" -> cheeses.size() * 2.25 + extraCheeses.size() * 0.90;
            default -> 0;
        };
        return base + meatPrice + cheesePrice;
    }

    @Override
    public String getDescription() {
        StringBuilder sb = new StringBuilder();
        sb.append(size).append("\uD83E\uDD6A\" ").append(bread).append("\n");

        List<String> allMeats = new ArrayList<>(meats);
        allMeats.addAll(extraMeats);
        if (!allMeats.isEmpty()) sb.append("  Meats: ").append(ItemUtils.formatWithCounts(allMeats)).append("\n");

        List<String> allCheeses = new ArrayList<>(cheeses);
        allCheeses.addAll(extraCheeses);
        if (!allCheeses.isEmpty()) sb.append("  Cheeses: ").append(ItemUtils.formatWithCounts(allCheeses)).append("\n");

        if (!toppings.isEmpty()) sb.append("  Toppings: ").append(ItemUtils.formatWithCounts(toppings)).append("\n");

        if (!sauces.isEmpty()) sb.append("  Sauces: ").append(ItemUtils.formatWithCounts(sauces)).append("\n");

        sb.append("  Toasted: ").append(toasted ? "Yes" : "No");

        return sb.toString();
    }

    public String getSummaryDescription() {
        int totalMeats = meats.size() + extraMeats.size();
        int totalCheeses = cheeses.size() + extraCheeses.size();
        int totalToppings = toppings.size();
        int totalSauces = sauces.size();

        return String.format("\uD83E\uDD6A%s\" %s - %d meats, %d cheeses, %d toppings, %d sauces",
                size, bread, totalMeats, totalCheeses, totalToppings, totalSauces);
    }
}
