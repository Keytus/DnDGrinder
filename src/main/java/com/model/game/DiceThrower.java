package com.model.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DiceThrower {
    public static int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    public static Integer throwSum(Integer dice, Integer diceCount){
        Integer result = 0;
        for(int i=0;i<diceCount;i++){
            result += getRandomNumber(1, dice);
        }
        return dice;
    }

    public static Integer throwWithAdvantage(Integer dice, Integer diceCount){
        List<Integer> values = new ArrayList<>();
        for(int i=0;i<diceCount;i++){
            values.add(getRandomNumber(1, dice));
        }
        return Collections.max(values);
    }

    public static Integer throwWithDisadvantage(Integer dice, Integer diceCount){
        List<Integer> values = new ArrayList<>();
        for(int i=0;i<diceCount;i++){
            values.add(getRandomNumber(1, dice));
        }
        return Collections.min(values);
    }
}
