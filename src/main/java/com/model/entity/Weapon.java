package com.model.entity;

import com.model.game.category.WeaponCategory;

import javax.persistence.*;

@Entity
@Table(name = "weapon")
public class Weapon {
    @Id
    @Column(name="itemid")
    private Integer itemID;

    @Column(name="category")
    private WeaponCategory category;

    @Column(name="minrange")
    private Integer minRange;

    @Column(name="maxrange")
    private Integer maxRange;

    @Column(name="twohanded")
    private Boolean twoHanded;

    @Column(name="thrown")
    private Boolean thrown;

    @Column(name="loading")
    private Boolean loading;

    @Column(name="light")
    private Boolean light;

    @Column(name="heavy")
    private Boolean heavy;

    @Column(name="finesse")
    private Boolean finesse;

    @ManyToOne
    @JoinColumn(name = "damage")
    private Damage damage;

    @ManyToOne
    @JoinColumn(name = "versatile")
    private Damage versatile;

    @OneToOne
    @JoinColumn(name = "ammunition")
    private Item ammunition;

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

    public WeaponCategory getCategory() {
        return category;
    }

    public void setCategory(WeaponCategory category) {
        this.category = category;
    }

    public Integer getMinRange() {
        return minRange;
    }

    public void setMinRange(Integer minRange) {
        this.minRange = minRange;
    }

    public Integer getMaxRange() {
        return maxRange;
    }

    public void setMaxRange(Integer maxRange) {
        this.maxRange = maxRange;
    }

    public Boolean getTwoHanded() {
        return twoHanded;
    }

    public void setTwoHanded(Boolean twoHanded) {
        this.twoHanded = twoHanded;
    }

    public Boolean getThrown() {
        return thrown;
    }

    public void setThrown(Boolean thrown) {
        this.thrown = thrown;
    }

    public Boolean getLoading() {
        return loading;
    }

    public void setLoading(Boolean loading) {
        this.loading = loading;
    }

    public Boolean getLight() {
        return light;
    }

    public void setLight(Boolean light) {
        this.light = light;
    }

    public Boolean getHeavy() {
        return heavy;
    }

    public void setHeavy(Boolean heavy) {
        this.heavy = heavy;
    }

    public Boolean getFinesse() {
        return finesse;
    }

    public void setFinesse(Boolean finesse) {
        this.finesse = finesse;
    }

    public Damage getDamage() {
        return damage;
    }

    public void setDamage(Damage damage) {
        this.damage = damage;
    }

    public Damage getVersatile() {
        return versatile;
    }

    public void setVersatile(Damage versatile) {
        this.versatile = versatile;
    }

    public Item getAmmunition() {
        return ammunition;
    }

    public void setAmmunition(Item ammunition) {
        this.ammunition = ammunition;
    }
}
