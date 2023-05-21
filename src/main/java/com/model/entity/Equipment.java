package com.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "equipment")
public class Equipment {
    @Id
    @Column(name="equipmentID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer equipmentID;

    @ManyToOne
    @JoinColumn(name = "characterid")
    private Character character;

    @ManyToOne
    @JoinColumn(name = "itemid")
    private Item item;

    @Column(name="isequip")
    private Boolean isEquip;

    public Integer getEquipmentID() {
        return equipmentID;
    }

    public void setEquipmentID(Integer equipmentID) {
        this.equipmentID = equipmentID;
    }

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Boolean getEquip() {
        return isEquip;
    }

    public void setEquip(Boolean equip) {
        isEquip = equip;
    }
}
