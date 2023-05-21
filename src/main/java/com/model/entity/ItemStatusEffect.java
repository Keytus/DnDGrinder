package com.model.entity;

import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "itemstatuseffect")
public class ItemStatusEffect {
    @Id
    @Column(name="itemstatuseffectid")
    private Integer itemStatusEffectID;

    @ManyToOne
    @JoinColumn(name = "itemid")
    private Item item;

    @ManyToOne
    @JoinColumn(name = "statuseffectid")
    private StatusEffect statusEffect;

    public Integer getItemStatusEffectID() {
        return itemStatusEffectID;
    }

    public void setItemStatusEffectID(Integer itemStatusEffectID) {
        this.itemStatusEffectID = itemStatusEffectID;
    }

    public StatusEffect getStatusEffect() {
        return statusEffect;
    }

    public void setStatusEffect(StatusEffect statusEffect) {
        this.statusEffect = statusEffect;
    }
}
