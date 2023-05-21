package com.model.entity;

import com.model.game.category.DamageType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "damage")
public class Damage {
    @Id
    @Column(name="damageid")
    private Integer damageID;

    @Column(name="dicecount")
    private Integer diceCount;

    @Column(name="dice")
    private Integer dice;

    @Column(name="damagetype")
    private DamageType damageType;

    public Integer getDamageID() {
        return damageID;
    }

    public void setDamageID(Integer damageID) {
        this.damageID = damageID;
    }

    public Integer getDiceCount() {
        return diceCount;
    }

    public void setDiceCount(Integer diceCount) {
        this.diceCount = diceCount;
    }

    public Integer getDice() {
        return dice;
    }

    public void setDice(Integer dice) {
        this.dice = dice;
    }

    public DamageType getDamageType() {
        return damageType;
    }

    public void setDamageType(DamageType damageType) {
        this.damageType = damageType;
    }
}
