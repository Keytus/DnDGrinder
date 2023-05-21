package com.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "abilities")
public class Abilities {
    @Id
    @Column(name="characterid")
    private Integer characterID;

    @Column(name="strength")
    private Integer strength;

    @Column(name="dexterity")
    private Integer dexterity;

    @Column(name="constitution")
    private Integer constitution;

    @Column(name="intelligence")
    private Integer intelligence;

    @Column(name="wisdom")
    private Integer wisdom;

    @Column(name="charisma")
    private Integer charisma;

    @OneToOne
    @MapsId
    @JoinColumn(name = "characterid")
    private Character character;

    public Abilities() {
    }

    public Abilities(Abilities abilities){
        this.charisma = abilities.charisma;
        this.constitution = abilities.constitution;
        this.intelligence = abilities.intelligence;
        this.wisdom = abilities.wisdom;
        this.strength = abilities.strength;
        this.dexterity = abilities.dexterity;
    }

    public Integer getCharacterID() {
        return characterID;
    }

    public void setCharacterID(Integer characterID) {
        this.characterID = characterID;
    }

    public Integer getStrength() {
        return strength;
    }

    public void setStrength(Integer strength) {
        this.strength = strength;
    }

    public Integer getDexterity() {
        return dexterity;
    }

    public void setDexterity(Integer dexterity) {
        this.dexterity = dexterity;
    }

    public Integer getConstitution() {
        return constitution;
    }

    public void setConstitution(Integer constitution) {
        this.constitution = constitution;
    }

    public Integer getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(Integer intelligence) {
        this.intelligence = intelligence;
    }

    public Integer getWisdom() {
        return wisdom;
    }

    public void setWisdom(Integer wisdom) {
        this.wisdom = wisdom;
    }

    public Integer getCharisma() {
        return charisma;
    }

    public void setCharisma(Integer charisma) {
        this.charisma = charisma;
    }
}
