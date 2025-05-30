package com.deli.util;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import com.deli.model.*;

public class ItemUtils {
    public static String formatWithCounts(List<String> items) {
        Map<String, Long> counts = items.stream()
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()));
        return counts.entrySet().stream()
                .map(e -> e.getValue() > 1 ? e.getKey() + " x" + e.getValue() : e.getKey())
                .collect(Collectors.joining(", "));
    }
}
