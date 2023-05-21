package com.model.entity;

import com.model.game.DiceThrower;
import com.model.game.category.EffectOriginCategory;
import com.model.game.Characteristic;
import com.model.game.category.StatusEffectCategory;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "statuseffect")
public class StatusEffect {
    @Id
    @Column(name="statuseffectid")
    private Integer statusEffectID;

    @Column(name="name")
    private String name;

    @Column(name="duration")
    private Integer duration;

    @Column(name="category")
    private StatusEffectCategory category;

    @Column(name="dice")
    private Integer dice;

    @Column(name="dicecount")
    private Integer diceCount;

    @Column(name="purevalue")
    private Integer pureValue;

    @Column(name="characteristic")
    private Integer characteristic;

    @Column(name="origin")
    private EffectOriginCategory origin;

    public StatusEffect() {
    }

    public StatusEffect(Integer duration, StatusEffectCategory category, Integer dice, Integer diceCount,
                        Integer pureValue, Integer characteristic, EffectOriginCategory origin) {
        this.duration = duration;
        this.category = category;
        this.dice = dice;
        this.diceCount = diceCount;
        this.pureValue = pureValue;
        this.characteristic = characteristic;
        this.origin = origin;
    }

    public Integer getValue(){
        Integer value = 0;
        if (this.getDice() != null) {
            value += DiceThrower.throwSum(this.getDice(), this.getDiceCount());
        }
        if (this.getPureValue() != null) {
            value += this.getPureValue();
        }
        return value;
    }

    public Integer getStatusEffectID() {
        return statusEffectID;
    }

    public void setStatusEffectID(Integer statusEffectID) {
        this.statusEffectID = statusEffectID;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public StatusEffectCategory getCategory() {
        return category;
    }

    public void setCategory(StatusEffectCategory category) {
        this.category = category;
    }

    public Integer getDice() {
        return dice;
    }

    public void setDice(Integer dice) {
        this.dice = dice;
    }

    public Integer getDiceCount() {
        return diceCount;
    }

    public void setDiceCount(Integer diceCount) {
        this.diceCount = diceCount;
    }

    public Integer getPureValue() {
        return pureValue;
    }

    public void setPureValue(Integer pureValue) {
        this.pureValue = pureValue;
    }

    public Integer getCharacteristic() {
        return characteristic;
    }

    public void setCharacteristic(Integer characteristic) {
        this.characteristic = characteristic;
    }

    public EffectOriginCategory getOrigin() {
        return origin;
    }

    public void setOrigin(EffectOriginCategory origin) {
        this.origin = origin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
