package com.model.entity;

import com.model.game.category.ItemType;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "item")
public class Item {
    @Id
    @Column(name="itemid")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer itemID;

    @Column(name="name")
    private String itemName;

    @Column(name="weight")
    private Float weight;

    @Column(name="cost")
    private Float cost;

    @Column(name="type")
    private ItemType itemType;

    @OneToOne(mappedBy = "item", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Armor armor;

    @OneToOne(mappedBy = "item", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Weapon weapon;

    @OneToMany(mappedBy = "item", fetch = FetchType.EAGER)
    private Set<ItemStatusEffect> itemStatusEffectSet;

    public Integer getItemID() {
        return itemID;
    }

    public void setItemID(Integer itemID) {
        this.itemID = itemID;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public Float getCost() {
        return cost;
    }

    public void setCost(Float cost) {
        this.cost = cost;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    public ItemType getItemType() {
        return itemType;
    }

    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Set<ItemStatusEffect> getItemStatusEffectSet() {
        return itemStatusEffectSet;
    }

    public void setItemStatusEffectSet(Set<ItemStatusEffect> itemStatusEffectSet) {
        this.itemStatusEffectSet = itemStatusEffectSet;
    }
}
