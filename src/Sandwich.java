import java.util.*;

public class Sandwich implements Item {
    private String size;
    private String breadType;
    private List<String> meats = new ArrayList<>();
    private int extraMeat = 0;
    private List<String> cheeses = new ArrayList<>();
    private int extraCheese = 0;
    private List<String> toppings = new ArrayList<>();
    private List<String> sauces = new ArrayList<>();
    private boolean toasted;

    public Sandwich(String size, String breadType) {
        this.size = size;
        this.breadType = breadType;
    }

    public void addMeat(String meat) { meats.add(meat); }
    public void addExtraMeat() { extraMeat++; }
    public void addCheese(String cheese) { cheeses.add(cheese); }
    public void addExtraCheese() { extraCheese++; }
    public void addTopping(String topping) { toppings.add(topping); }
    public void addSauce(String sauce) { sauces.add(sauce); }
    public void setToasted(boolean toasted) { this.toasted = toasted; }

    private double getRate(String size, double s, double m, double l) {
        switch (size) {
            case "4": return s;
            case "8": return m;
            case "12": return l;
            default: return 0;
        }
    }

    @Override
    public double getPrice() {
        double base = getRate(size, 5.50, 7.00, 8.50);
        double meatCost = meats.size() * getRate(size, 1.00, 2.00, 3.00) +
                extraMeat * getRate(size, 0.50, 1.00, 1.50);
        double cheeseCost = cheeses.size() * getRate(size, 0.75, 1.50, 2.25) +
                extraCheese * getRate(size, 0.30, 0.60, 0.90);
        return Math.round((base + meatCost + cheeseCost) * 100.0) / 100.0;
    }

    @Override
    public String getDescription() {
        return size + "\" " + breadType + " Sandwich (" + meats.size() + " meats, " +
                cheeses.size() + " cheese" + (toasted ? ", toasted" : "") + ")";
    }
}
