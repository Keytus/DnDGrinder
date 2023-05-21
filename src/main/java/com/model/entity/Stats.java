package com.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "stats")
public class Stats {
    @Id
    @Column(name="characterid")
    private Integer characterID;

    @Column(name="maxhp")
    private Integer maxHP;

    @Column(name="currenthp")
    private Integer currentHP;

    @Column(name="temporaryhp")
    private Integer temporaryHP;

    @Column(name="hitdice")
    private Integer hitDice;

    @OneToOne
    @MapsId
    @JoinColumn(name = "characterid")
    private Character character;

    public Integer getCharacterID() {
        return characterID;
    }

    public void setCharacterID(Integer characterID) {
        this.characterID = characterID;
    }

    public Integer getMaxHP() {
        return maxHP;
    }

    public void setMaxHP(Integer maxHP) {
        this.maxHP = maxHP;
    }

    public Integer getCurrentHP() {
        return currentHP;
    }

    public void setCurrentHP(Integer currentHP) {
        this.currentHP = currentHP;
    }

    public Integer getTemporaryHP() {
        return temporaryHP;
    }

    public void setTemporaryHP(Integer temporaryHP) {
        this.temporaryHP = temporaryHP;
    }

    public Integer getHitDice() {
        return hitDice;
    }

    public void setHitDice(Integer hitDice) {
        this.hitDice = hitDice;
    }
}
