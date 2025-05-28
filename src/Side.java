
import java.util.ArrayList;
import java.util.List;

public class Side implements Item {
    private List<String> sideItems = new ArrayList<>();

    public void addSide(String item) {
        sideItems.add(item);
    }

    @Override
    public double getPrice() {
        return 0; // sides are free
    }

    @Override
    public String getDescription() {
        return "Sides: " + ItemUtils.formatWithCounts(sideItems);
    }

    public String getSummaryDescription() {
        return "Sides: " + ItemUtils.formatWithCounts(sideItems);
    }
}
