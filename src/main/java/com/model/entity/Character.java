package com.model.entity;

import com.model.game.category.CharacterClassCategory;
import com.model.game.category.RaceCategory;
import com.model.game.category.SubclassCategory;
import com.model.game.category.SubraceCategory;

import javax.persistence.*;

@Entity
@Table(name = "character")
public class Character {
    @Id
    @Column(name="characterid")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer characterID;

    @ManyToOne
    @JoinColumn(name = "playerid")
    private Player player;

    @Column(name="name")
    private String name;

    @Column(name="characterclass")
    private CharacterClassCategory characterClass;

    @Column(name="subclass")
    private SubclassCategory subclass;

    @Column(name="level")
    private Integer level;

    @Column(name="race")
    private RaceCategory race;

    @Column(name="subrace")
    private SubraceCategory subrace;

    @Column(name="inventory")
    private String inventory;

    @Column(name="notes")
    private String notes;

    @OneToOne(mappedBy = "character", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Abilities abilities;

    @OneToOne(mappedBy = "character", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Stats stats;

    @OneToOne(mappedBy = "character", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Skills skills;

    @OneToOne(mappedBy = "character", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Personality personality;

    @OneToOne(mappedBy = "character", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Coins coins;

    @OneToOne(mappedBy = "character", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Conditions conditions;


    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }


    public String getInventory() {
        return inventory;
    }

    public void setInventory(String inventory) {
        this.inventory = inventory;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Integer getCharacterID() {
        return characterID;
    }

    public void setCharacterID(Integer characterID) {
        this.characterID = characterID;
    }

    public Abilities getAbilities() {
        return abilities;
    }

    public void setAbilities(Abilities abilities) {
        this.abilities = abilities;
    }

    public Stats getStats() {
        return stats;
    }

    public void setStats(Stats stats) {
        this.stats = stats;
    }

    public Skills getSkills() {
        return skills;
    }

    public void setSkills(Skills skills) {
        this.skills = skills;
    }

    public Personality getPersonality() {
        return personality;
    }

    public void setPersonality(Personality personality) {
        this.personality = personality;
    }

    public Coins getCoins() {
        return coins;
    }

    public void setCoins(Coins coins) {
        this.coins = coins;
    }

    public Conditions getConditions() {
        return conditions;
    }

    public void setConditions(Conditions conditions) {
        this.conditions = conditions;
    }

    public CharacterClassCategory getCharacterClass() {
        return characterClass;
    }

    public void setCharacterClass(CharacterClassCategory characterClass) {
        this.characterClass = characterClass;
    }

    public SubclassCategory getSubclass() {
        return subclass;
    }

    public void setSubclass(SubclassCategory subclass) {
        this.subclass = subclass;
    }

    public RaceCategory getRace() {
        return race;
    }

    public void setRace(RaceCategory race) {
        this.race = race;
    }

    public SubraceCategory getSubrace() {
        return subrace;
    }

    public void setSubrace(SubraceCategory subrace) {
        this.subrace = subrace;
    }
}
