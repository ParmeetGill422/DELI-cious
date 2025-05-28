import java.util.ArrayList;
import java.util.List;

public class Chips implements Item {
    private List<String> flavors = new ArrayList<>();

    public void addFlavor(String flavor) {
        flavors.add(flavor);
    }

    @Override
    public double getPrice() {
        return flavors.size() * 1.50;
    }

    @Override
    public String getDescription() {
        return "Chips: " + ItemUtils.formatWithCounts(flavors);
    }

    public String getSummaryDescription() {
        return "Chips: " + ItemUtils.formatWithCounts(flavors);
    }
}
