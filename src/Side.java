import java.util.ArrayList;
import java.util.List;

public class Side implements Item {
    private List<String> sideItems = new ArrayList<>();

    public void addSide(String item) {
        sideItems.add(item.trim());
    }

    public List<String> getSideItems() {
        return sideItems;
    }

    @Override
    public double getPrice() {
        return 0;
    }

    @Override
    public String getDescription() {
        return "\uD83C\uDF6FSides: " + ItemUtils.formatWithCounts(sideItems);
    }

    public String getSummaryDescription() {
        return "\uD83C\uDF6FSides: " + ItemUtils.formatWithCounts(sideItems);
    }
}
