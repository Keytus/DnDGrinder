package com.model.entity;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;

@Entity
@Table(name = "coins")
public class Coins {
    @Id
    @Column(name="characterid")
    private Integer characterID;

    @Column(name="copper")
    private Integer copper;

    @Column(name="silver")
    private Integer silver;

    @Column(name="electrum")
    private Integer electrum;

    @Column(name="gold")
    private Integer gold;

    @Column(name="platinum")
    private Integer platinum;

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

    public Integer getCopper() {
        return copper;
    }

    public void setCopper(Integer copper) {
        this.copper = copper;
    }

    public Integer getSilver() {
        return silver;
    }

    public void setSilver(Integer silver) {
        this.silver = silver;
    }

    public Integer getElectrum() {
        return electrum;
    }

    public void setElectrum(Integer electrum) {
        this.electrum = electrum;
    }

    public Integer getGold() {
        return gold;
    }

    public void setGold(Integer gold) {
        this.gold = gold;
    }

    public Integer getPlatinum() {
        return platinum;
    }

    public void setPlatinum(Integer platinum) {
        this.platinum = platinum;
    }
}
