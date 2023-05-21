package com.model.entity;

import com.model.game.category.ArmorCategory;

import javax.persistence.*;

@Entity
@Table(name = "armor")
public class Armor {
    @Id
    @Column(name="itemid")
    private Integer itemID;

    @Column(name="armorclass")
    private Integer armorClass;

    @Column(name="strength")
    private Integer strength;

    @Column(name="category")
    private ArmorCategory category;

    @Column(name="stealth")
    private Boolean stealth;

    @OneToOne
    @MapsId
    @JoinColumn(name = "itemid")
    private Item item;

    public Integer getItemID() {
        return itemID;
    }

    public void setItemID(Integer itemID) {
        this.itemID = itemID;
    }

    public Integer getArmorClass() {
        return armorClass;
    }

    public void setArmorClass(Integer armorClass) {
        this.armorClass = armorClass;
    }

    public Integer getStrength() {
        return strength;
    }

    public void setStrength(Integer strength) {
        this.strength = strength;
    }

    public Boolean getStealth() {
        return stealth;
    }

    public void setStealth(Boolean stealth) {
        this.stealth = stealth;
    }

    public ArmorCategory getCategory() {
        return category;
    }

    public void setCategory(ArmorCategory category) {
        this.category = category;
    }
}
