package com.model.game;

import com.model.entity.StatusEffect;

import java.util.ArrayList;
import java.util.List;

public class Race {
    private String name;

    private final List<StatusEffect> raceBuffs = new ArrayList<>();

    public Race(String name) {
        this.name = name;
    }

    public Race() {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<StatusEffect> getRaceBuffs() {
        return raceBuffs;
    }
}
