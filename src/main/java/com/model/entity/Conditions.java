package com.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "conditions")
public class Conditions {
    @Id
    @Column(name="characterid")
    private Integer characterID;

    @Column(name="blinded")
    private Boolean blinded;

    @Column(name="charmed")
    private Boolean charmed;

    @Column(name="deafened")
    private Boolean deafened;

    @Column(name="frightened")
    private Boolean frightened;

    @Column(name="grappled")
    private Boolean grappled;

    @Column(name="incapacitated")
    private Boolean incapacitated;

    @Column(name="invisible")
    private Boolean invisible;

    @Column(name="paralyzed")
    private Boolean paralyzed;

    @Column(name="petrified")
    private Boolean petrified;

    @Column(name="poisoned")
    private Boolean poisoned;

    @Column(name="prone")
    private Boolean prone;

    @Column(name="restrained")
    private Boolean restrained;

    @Column(name="stunned")
    private Boolean stunned;

    @Column(name="unconscious")
    private Boolean unconscious;

    @Column(name="exhaustion")
    private Integer exhaustion;

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

    public Boolean getBlinded() {
        return blinded;
    }

    public void setBlinded(Boolean blinded) {
        this.blinded = blinded;
    }

    public Boolean getCharmed() {
        return charmed;
    }

    public void setCharmed(Boolean charmed) {
        this.charmed = charmed;
    }

    public Boolean getDeafened() {
        return deafened;
    }

    public void setDeafened(Boolean deafened) {
        this.deafened = deafened;
    }

    public Boolean getFrightened() {
        return frightened;
    }

    public void setFrightened(Boolean frightened) {
        this.frightened = frightened;
    }

    public Boolean getGrappled() {
        return grappled;
    }

    public void setGrappled(Boolean grappled) {
        this.grappled = grappled;
    }

    public Boolean getIncapacitated() {
        return incapacitated;
    }

    public void setIncapacitated(Boolean incapacitated) {
        this.incapacitated = incapacitated;
    }

    public Boolean getInvisible() {
        return invisible;
    }

    public void setInvisible(Boolean invisible) {
        this.invisible = invisible;
    }

    public Boolean getParalyzed() {
        return paralyzed;
    }

    public void setParalyzed(Boolean paralyzed) {
        this.paralyzed = paralyzed;
    }

    public Boolean getPetrified() {
        return petrified;
    }

    public void setPetrified(Boolean petrified) {
        this.petrified = petrified;
    }

    public Boolean getPoisoned() {
        return poisoned;
    }

    public void setPoisoned(Boolean poisoned) {
        this.poisoned = poisoned;
    }

    public Boolean getProne() {
        return prone;
    }

    public void setProne(Boolean prone) {
        this.prone = prone;
    }

    public Boolean getRestrained() {
        return restrained;
    }

    public void setRestrained(Boolean restrained) {
        this.restrained = restrained;
    }

    public Boolean getStunned() {
        return stunned;
    }

    public void setStunned(Boolean stunned) {
        this.stunned = stunned;
    }

    public Boolean getUnconscious() {
        return unconscious;
    }

    public void setUnconscious(Boolean unconscious) {
        this.unconscious = unconscious;
    }

    public Integer getExhaustion() {
        return exhaustion;
    }

    public void setExhaustion(Integer exhaustion) {
        this.exhaustion = exhaustion;
    }
}
