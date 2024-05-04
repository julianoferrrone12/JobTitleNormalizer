package com.company.normalizer;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, String> idealTitles = getIdealTitles();
        JobTitleNormalizer normalizer = new JobTitleNormalizer(idealTitles);

        String jt = "Java engineer";
        String normalizedTitle = normalizer.normalize(jt);
        System.out.println("Input: " + jt + ", Normalized: " + normalizedTitle);

        jt = "C# engineer";
        normalizedTitle = normalizer.normalize(jt);
        System.out.println("Input: " + jt + ", Normalized: " + normalizedTitle);

        jt = "Building architect";
        normalizedTitle = normalizer.normalize(jt);
        System.out.println("Input: " + jt + ", Normalized: " + normalizedTitle);

        jt = "Chief Accountant";
        normalizedTitle = normalizer.normalize(jt);
        System.out.println("Input: " + jt + ", Normalized: " + normalizedTitle);
    }

    private static Map<String, String> getIdealTitles() {
        Map<String, String> idealTitles = new HashMap<>();
        idealTitles.put("Architect", "Architect");
        idealTitles.put("Software engineer", "Software engineer");
        idealTitles.put("Quantity surveyor", "Quantity surveyor");
        idealTitles.put("Accountant", "Accountant");
        return idealTitles;
    }
}