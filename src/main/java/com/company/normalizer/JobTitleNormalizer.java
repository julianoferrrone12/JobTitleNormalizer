// JobTitleNormalizer.java
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
            return null; // Tratar entrada vazia ou nula
        }

        for (Map.Entry<String, String> entry : idealTitles.entrySet()) {
            String idealTitle = entry.getKey();
            double score = calculateScore(inputTitle, idealTitle);

            if (score > maxScore) {
                maxScore = score;
                bestMatch = entry.getValue();
            }
        }

        return bestMatch != null ? bestMatch : inputTitle; // Retorna o próprio título de entrada se não houver match adequado
    }

    private double calculateScore(String inputTitle, String idealTitle) {
        // Normalizar títulos para comparar
        String normalizedInputTitle = inputTitle.trim().toLowerCase();
        String normalizedIdealTitle = idealTitle.trim().toLowerCase();

        // Contar o número de palavras em comum entre os títulos
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

        // Calcular a pontuação com base no número de palavras em comum e no comprimento dos títulos
        double inputLength = inputWords.length;
        double idealLength = idealWords.length;
        return commonWords / Math.max(inputLength, idealLength);
    }
}

