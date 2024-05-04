package com.company.normalizer;

import java.util.Map;

public class JobTitleNormalizer {
    private final Map<String, String> idealTitles;

    public JobTitleNormalizer(Map<String, String> idealTitles) {
        this.idealTitles = idealTitles;
    }

    public String normalize(String inputTitle) {
        double maxScore = 0.0;
        String bestMatch = null;

        if (inputTitle == null || inputTitle.isEmpty()) {
            return null;
        }

        for (Map.Entry<String, String> entry : idealTitles.entrySet()) {
            String idealTitle = entry.getKey();
            double score = calculateScore(inputTitle, idealTitle);

            if (score > maxScore) {
                maxScore = score;
                bestMatch = entry.getValue();
            }
        }

        return bestMatch != null ? bestMatch : inputTitle;
    }

    private double calculateScore(String inputTitle, String idealTitle) {

        String normalizedInputTitle = inputTitle.trim().toLowerCase();
        String normalizedIdealTitle = idealTitle.trim().toLowerCase();

        String[] inputWords = normalizedInputTitle.split("\\s+");
        String[] idealWords = normalizedIdealTitle.split("\\s+");

        int commonWords = 0;
        for (String inputWord : inputWords) {
            for (String idealWord : idealWords) {
                if (inputWord.equalsIgnoreCase(idealWord)) {
                    commonWords++;
                    break;
                }
            }
        }

        double inputLength = inputWords.length;
        double idealLength = idealWords.length;
        return commonWords / Math.max(inputLength, idealLength);
    }
}

