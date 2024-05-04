// JobTitleNormalizerTest.java
package com.company.normalizer;

import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class JobTitleNormalizerTest {
    @Test
    void testNormalize() {
        Map<String, String> idealTitles = new HashMap<>();
        idealTitles.put("Architect", "Architect");
        idealTitles.put("Software engineer", "Software engineer");
        idealTitles.put("Quantity surveyor", "Quantity surveyor");
        idealTitles.put("Accountant", "Accountant");

        JobTitleNormalizer normalizer = new JobTitleNormalizer(idealTitles);

        // Test cases for normalization
        assertEquals("Software engineer", normalizer.normalize("Java engineer"));
        assertEquals("Software engineer", normalizer.normalize("C# engineer"));
        assertEquals("Accountant", normalizer.normalize("Accountant"));
        assertEquals("Accountant", normalizer.normalize("Chief Accountant"));

        // Test case for empty input
        assertNull(normalizer.normalize(""));

        // Test cases for edge and special characters
        assertEquals("Architect", normalizer.normalize("Architect"));
        assertEquals("Quantity surveyor", normalizer.normalize("Quantity surveyor"));
        assertEquals("Software engineer", normalizer.normalize("software engineer"));
        assertEquals("Accountant", normalizer.normalize("Accountant"));

        // Test case for null input
        assertNull(normalizer.normalize(null));

        // Test case for ideal titles map with only one entry
        Map<String, String> singleTitleMap = new HashMap<>();
        singleTitleMap.put("Engineer", "Engineer");
        normalizer = new JobTitleNormalizer(singleTitleMap);
        assertEquals("Engineer", normalizer.normalize("Java engineer"));
    }
}
