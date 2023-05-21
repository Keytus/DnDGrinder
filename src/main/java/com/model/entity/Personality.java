package com.model.entity;

import com.model.game.category.AlignmentCategory;

import javax.persistence.*;

@Entity
@Table(name = "personality")
public class Personality {
    @Id
    @Column(name="characterid")
    private Integer characterID;

    @Column(name="age")
    private Integer Age;

    @Column(name="alignment")
    private AlignmentCategory alignment;

    @Column(name="background")
    private String background;

    @Column(name="bonds")
    private String bonds;

    @Column(name="eyes")
    private String eyes;

    @Column(name="flaws")
    private String flaws;

    @Column(name="hair")
    private String hair;

    @Column(name="weight")
    private Float weight;

    @Column(name="height")
    private Float height;

    @Column(name="ideals")
    private String ideals;

    @Column(name="personalitytraits")
    private String personalityTraits;

    @Column(name="skin")
    private String skin;

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

    public Integer getAge() {
        return Age;
    }

    public void setAge(Integer age) {
        Age = age;
    }

    public AlignmentCategory getAlignment() {
        return alignment;
    }

    public void setAlignment(AlignmentCategory alignment) {
        this.alignment = alignment;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public String getBonds() {
        return bonds;
    }

    public void setBonds(String bonds) {
        this.bonds = bonds;
    }

    public String getEyes() {
        return eyes;
    }

    public void setEyes(String eyes) {
        this.eyes = eyes;
    }

    public String getFlaws() {
        return flaws;
    }

    public void setFlaws(String flaws) {
        this.flaws = flaws;
    }

    public String getHair() {
        return hair;
    }

    public void setHair(String hair) {
        this.hair = hair;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public Float getHeight() {
        return height;
    }

    public void setHeight(Float height) {
        this.height = height;
    }

    public String getIdeals() {
        return ideals;
    }

    public void setIdeals(String ideals) {
        this.ideals = ideals;
    }

    public String getPersonalityTraits() {
        return personalityTraits;
    }

    public void setPersonalityTraits(String personalityTraits) {
        this.personalityTraits = personalityTraits;
    }

    public String getSkin() {
        return skin;
    }

    public void setSkin(String skin) {
        this.skin = skin;
    }
}
