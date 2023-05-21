package com.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "skills")
public class Skills {
    @Id
    @Column(name="characterid")
    private Integer characterID;

    @Column(name="acrobatics")
    private Integer acrobatics;

    @Column(name="animalhandling")
    private Integer animalHandling;

    @Column(name="arcana")
    private Integer arcana;

    @Column(name="athletics")
    private Integer athletics;

    @Column(name="deception")
    private Integer deception;

    @Column(name="history")
    private Integer history;

    @Column(name="insight")
    private Integer insight;

    @Column(name="intimidation")
    private Integer intimidation;

    @Column(name="investigation")
    private Integer investigation;

    @Column(name="nature")
    private Integer nature;

    @Column(name="medicine")
    private Integer medicine;

    @Column(name="perception")
    private Integer perception;

    @Column(name="performance")
    private Integer performance;

    @Column(name="persuasion")
    private Integer persuasion;

    @Column(name="religion")
    private Integer religion;

    @Column(name="sleightofhand")
    private Integer sleightOfHand;

    @Column(name="stealth")
    private Integer stealth;

    @Column(name="survival")
    private Integer survival;

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

    public Integer getAcrobatics() {
        return acrobatics;
    }

    public void setAcrobatics(Integer acrobatics) {
        this.acrobatics = acrobatics;
    }

    public Integer getAnimalHandling() {
        return animalHandling;
    }

    public void setAnimalHandling(Integer animalHandling) {
        this.animalHandling = animalHandling;
    }

    public Integer getArcana() {
        return arcana;
    }

    public void setArcana(Integer arcana) {
        this.arcana = arcana;
    }

    public Integer getAthletics() {
        return athletics;
    }

    public void setAthletics(Integer athletics) {
        this.athletics = athletics;
    }

    public Integer getDeception() {
        return deception;
    }

    public void setDeception(Integer deception) {
        this.deception = deception;
    }

    public Integer getHistory() {
        return history;
    }

    public void setHistory(Integer history) {
        this.history = history;
    }

    public Integer getInsight() {
        return insight;
    }

    public void setInsight(Integer insight) {
        this.insight = insight;
    }

    public Integer getIntimidation() {
        return intimidation;
    }

    public void setIntimidation(Integer intimidation) {
        this.intimidation = intimidation;
    }

    public Integer getInvestigation() {
        return investigation;
    }

    public void setInvestigation(Integer investigation) {
        this.investigation = investigation;
    }

    public Integer getNature() {
        return nature;
    }

    public void setNature(Integer nature) {
        this.nature = nature;
    }

    public Integer getMedicine() {
        return medicine;
    }

    public void setMedicine(Integer medicine) {
        this.medicine = medicine;
    }

    public Integer getPerception() {
        return perception;
    }

    public void setPerception(Integer perception) {
        this.perception = perception;
    }

    public Integer getPerformance() {
        return performance;
    }

    public void setPerformance(Integer performance) {
        this.performance = performance;
    }

    public Integer getPersuasion() {
        return persuasion;
    }

    public void setPersuasion(Integer persuasion) {
        this.persuasion = persuasion;
    }

    public Integer getReligion() {
        return religion;
    }

    public void setReligion(Integer religion) {
        this.religion = religion;
    }

    public Integer getSleightOfHand() {
        return sleightOfHand;
    }

    public void setSleightOfHand(Integer sleightOfHand) {
        this.sleightOfHand = sleightOfHand;
    }

    public Integer getStealth() {
        return stealth;
    }

    public void setStealth(Integer stealth) {
        this.stealth = stealth;
    }

    public Integer getSurvival() {
        return survival;
    }

    public void setSurvival(Integer survival) {
        this.survival = survival;
    }
}
