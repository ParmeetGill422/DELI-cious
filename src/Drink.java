import java.util.ArrayList;
import java.util.List;

public class Drink implements Item {
    private List<String> sizes = new ArrayList<>();

    public void addSize(String size) {
        sizes.add(size);
    }

    @Override
    public double getPrice() {
        double total = 0;
        for (String size : sizes) {
            switch (size) {
                case "Small" -> total += 2.00;
                case "Medium" -> total += 2.50;
                case "Large" -> total += 3.00;
            }
        }
        return total;
    }

    @Override
    public String getDescription() {
        return "Drinks: " + ItemUtils.formatWithCounts(sizes);
    }
}