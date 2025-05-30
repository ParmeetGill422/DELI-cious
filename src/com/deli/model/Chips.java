package com.deli.model;
import java.util.ArrayList;
import java.util.List;
import com.deli.util.ItemUtils;

public class Chips implements Item {
    private List<String> flavors = new ArrayList<>();

    public void addFlavor(String flavor) {
        flavors.add(flavor.trim());
    }

    public List<String> getFlavors() {
        return flavors;
    }

    @Override
    public double getPrice() {
        return flavors.size() * 1.50;
    }

    @Override
    public String getDescription() {
        return "\uD83C\uDF5FChips: " + ItemUtils.formatWithCounts(flavors);
    }

    public String getSummaryDescription() {
        return "\uD83C\uDF5FChips: " + ItemUtils.formatWithCounts(flavors);
    }
}
