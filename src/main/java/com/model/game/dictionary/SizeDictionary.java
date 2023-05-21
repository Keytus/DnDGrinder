package com.model.game.dictionary;

import com.model.game.category.SizeCategory;

import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Map;

public class SizeDictionary {
    public static final Map<SizeCategory, Float> sizeMap;
    static {
        Map<SizeCategory, Float> sizes = new EnumMap<>(SizeCategory.class);

        sizes.put(SizeCategory.Tiny, 2.5f);
        sizes.put(SizeCategory.Small, 5f);
        sizes.put(SizeCategory.Medium, 5f);
        sizes.put(SizeCategory.Large, 10f);
        sizes.put(SizeCategory.Huge, 15f);
        sizes.put(SizeCategory.Gargantuan, 20f);

        if (!sizes.keySet().equals(EnumSet.allOf(SizeCategory.class))) {
            throw new RuntimeException(
                    "Map does not have entries for all Size constants!");
        }

        sizeMap = Collections.unmodifiableMap(sizes);
    }
}


