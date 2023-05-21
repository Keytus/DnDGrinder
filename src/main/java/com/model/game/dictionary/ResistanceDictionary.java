package com.model.game.dictionary;

import com.model.game.category.ResistanceCategory;

import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Map;

public class ResistanceDictionary {
    public static final Map<ResistanceCategory, Float> resistanceMap;
    static {
        Map<ResistanceCategory, Float> resistance = new EnumMap<>(ResistanceCategory.class);

        resistance.put(ResistanceCategory.Vulnerability, 2f);
        resistance.put(ResistanceCategory.Normal, 1f);
        resistance.put(ResistanceCategory.Resistance, 0.5f);
        resistance.put(ResistanceCategory.Immune, 0f);

        if (!resistance.keySet().equals(EnumSet.allOf(ResistanceCategory.class))) {
            throw new RuntimeException(
                    "Map does not have entries for all Resistance constants!");
        }

        resistanceMap = Collections.unmodifiableMap(resistance);
    }
}
