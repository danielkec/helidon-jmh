package io.helidon.reactive.jmh;

import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

public class Histogram {
    private Map<String, Double> rowMap = new HashMap<>();
    private double minVal;
    private double maxVal;
    private int maxLengthLabel;

    public static Histogram create() {
        return new Histogram();
    }

    public Histogram add(String label, double score) {
        this.rowMap.put(label, score);
        this.maxVal = Math.max(this.maxVal, score);
        this.minVal = Math.min(this.minVal, score);
        this.maxLengthLabel = Math.max(this.maxLengthLabel, label.length());
        return this;
    }

    public String render() {
        StringJoiner joiner = new StringJoiner("\n");
        rowMap.entrySet().stream()
                .sorted((o1, o2) -> {
                    var sb1 = new StringBuilder(o1.getKey()).reverse();
                    var sb2 = new StringBuilder(o2.getKey()).reverse();
                    return sb1.compareTo(sb2);
                })
                .forEach(e -> {
                    String label = e.getKey();
                    double score = e.getValue();
                    int percentage = Math.toIntExact(Math.round(score * 100 / maxVal));
                    joiner.add(String
                            .format("%" + maxLengthLabel + "s %s %.3f",
                                    label,
                                    "█".repeat(percentage),
                                    score
                            ));

                });
        return joiner.toString();
    }
}
