package com.model.game;

import com.basic.GameBasic;
import com.model.entity.Character;
import com.model.entity.*;
import com.model.game.category.StatusEffectCategory;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CharacterInfo {

    private Character character;

    private List<Equipment> equipmentList;

    private CharacterItemSet characterItemSet;

    private final int[] characteristics = new int[Characteristic.values().length];

    private int[] defaultCharacteristics;

    private List<Integer>[] throwAdvantages = new List[ThrowAdvantage.values().length];

    private final List<StatusEffect> statusEffects = new ArrayList<>();

    public CharacterInfo(Character character, List<Equipment> equipmentList) {
        this.character = character;
        this.equipmentList = equipmentList;
        characterItemSet = new CharacterItemSet(this.equipmentList);
        for(List<Integer> throwAdvantage: throwAdvantages){
            throwAdvantage = new ArrayList<>();
        }

        //Setting unbuff characteristics
        characteristics[Characteristic.ProficiencyBonus.ordinal()] = 2 + ((character.getLevel()-1)/4);
        setAbilities(character.getAbilities());
        setStats(character.getStats());
        setSkills(character.getSkills());
        characteristics[Characteristic.ArmorClass.ordinal()] = 10 +
                GameBasic.getAbilityModifier(characteristics[Characteristic.Dexterity.ordinal()]);
        characteristics[Characteristic.Initiative.ordinal()] =
                GameBasic.getAbilityModifier(characteristics[Characteristic.Dexterity.ordinal()]);
        defaultCharacteristics = characteristics.clone();

        //Collecting buffs
        statusEffects.addAll(GameBasic.races[character.getRace().ordinal()].getRaceBuffs());
        if (character.getSubrace() != null){
            statusEffects.addAll(GameBasic.subRaces[character.getSubrace().ordinal()].getRaceBuffs());
        }
        statusEffects.addAll(collectEquipmentEffects());

        //Applying all buffs
        applyEffects(statusEffects);
        applyArmor();
        characteristics[Characteristic.Initiative.ordinal()] =
                GameBasic.getAbilityModifier(characteristics[Characteristic.Dexterity.ordinal()]);

        equipAndApplyItem(equipmentList.get(3));

        System.out.println(toStringCharacteristics());
    }

    public void setAbilities(Abilities abilities){
        characteristics[Characteristic.Strength.ordinal()] = abilities.getStrength();
        characteristics[Characteristic.Dexterity.ordinal()] = abilities.getDexterity();
        characteristics[Characteristic.Constitution.ordinal()] = abilities.getConstitution();
        characteristics[Characteristic.Intelligence.ordinal()] = abilities.getIntelligence();
        characteristics[Characteristic.Wisdom.ordinal()] = abilities.getWisdom();
        characteristics[Characteristic.Charisma.ordinal()] = abilities.getCharisma();
    }

    public void setStats(Stats stats){
        characteristics[Characteristic.MaxHP.ordinal()] = stats.getMaxHP();
        characteristics[Characteristic.CurrentHP.ordinal()] = stats.getCurrentHP();
        characteristics[Characteristic.HitDice.ordinal()] = stats.getHitDice();
        characteristics[Characteristic.TemporaryHP.ordinal()] = stats.getTemporaryHP();
    }

    public void setSkills(Skills skills){
        characteristics[Characteristic.Acrobatics.ordinal()] = skills.getAcrobatics();
        characteristics[Characteristic.AnimalHandling.ordinal()] = skills.getAnimalHandling();
        characteristics[Characteristic.Athletics.ordinal()] = skills.getAthletics();
        characteristics[Characteristic.Arcana.ordinal()] = skills.getArcana();
        characteristics[Characteristic.Deception.ordinal()] = skills.getDeception();
        characteristics[Characteristic.History.ordinal()] = skills.getHistory();
        characteristics[Characteristic.Insight.ordinal()] = skills.getInsight();
        characteristics[Characteristic.Intimidation.ordinal()] = skills.getIntimidation();
        characteristics[Characteristic.Investigation.ordinal()] = skills.getInvestigation();
        characteristics[Characteristic.Medicine.ordinal()] = skills.getMedicine();
        characteristics[Characteristic.Perception.ordinal()] = skills.getPerception();
        characteristics[Characteristic.Performance.ordinal()] = skills.getPerformance();
        characteristics[Characteristic.Persuasion.ordinal()] = skills.getPersuasion();
        characteristics[Characteristic.Religion.ordinal()] = skills.getReligion();
        characteristics[Characteristic.SleightOfHand.ordinal()] = skills.getSleightOfHand();
        characteristics[Characteristic.Stealth.ordinal()] = skills.getStealth();
        characteristics[Characteristic.Survival.ordinal()] = skills.getSurvival();
    }

    public List<StatusEffect> collectEquipmentEffects(){
        List<StatusEffect> effects = new ArrayList<>();
        for (Item item : characterItemSet.getItemSet()){
            if (item != null){
                Set<ItemStatusEffect> itemStatusEffectSet = item.getItemStatusEffectSet();
                for (ItemStatusEffect itemStatusEffect : itemStatusEffectSet){
                    effects.add(itemStatusEffect.getStatusEffect());
                }
            }
        }
        return effects;
    }

    public List<StatusEffect> getEffectsByCharacteristic(Characteristic characteristic){
        return statusEffects.stream()
                .filter(statusEffect -> (Characteristic.values()[statusEffect.getCharacteristic()] == characteristic))
                .collect(Collectors.toList());
    }

    public void applyArmor(){
        Item armor = characterItemSet.getItemSet()[CharacterItemSet.SetSlot.Torso.ordinal()];
        if (armor != null){
            int dexterityBonus = GameBasic.getAbilityModifier(characteristics[Characteristic.Dexterity.ordinal()]);
            switch (armor.getArmor().getCategory()){
                case LightArmor -> characteristics[Characteristic.ArmorClass.ordinal()] =
                        armor.getArmor().getArmorClass() + dexterityBonus;
                case MediumArmor ->  characteristics[Characteristic.ArmorClass.ordinal()] =
                        armor.getArmor().getArmorClass() + Math.min(dexterityBonus, 2);
                case HeavyArmor -> characteristics[Characteristic.ArmorClass.ordinal()] =
                        armor.getArmor().getArmorClass();
            }
            applyEffects(getEffectsByCharacteristic(Characteristic.ArmorClass));
        }
    }

    public void applyEffects(List<StatusEffect> statusEffects) {
        for (StatusEffect statusEffect : statusEffects) {
            if (statusEffect.getCategory() == StatusEffectCategory.BuffUpp) {
                characteristics[statusEffect.getCharacteristic()] += statusEffect.getValue();
            }
            if (statusEffect.getCategory() == StatusEffectCategory.DebuffDown) {
                characteristics[statusEffect.getCharacteristic()] -= statusEffect.getValue();
            }
            if (statusEffect.getCategory() == StatusEffectCategory.Advantage){
                throwAdvantages[statusEffect.getCharacteristic()].add(statusEffect.getValue());
            }
        }
        for (StatusEffect statusEffect : statusEffects) {
            Integer value = statusEffect.getValue();
            if (statusEffect.getCategory() == StatusEffectCategory.BuffSet) {
                if (characteristics[statusEffect.getCharacteristic()] < value){
                    characteristics[statusEffect.getCharacteristic()] = value;
                }
            }
            if (statusEffect.getCategory() == StatusEffectCategory.DebuffSet) {
                if (characteristics[statusEffect.getCharacteristic()] > value){
                    characteristics[statusEffect.getCharacteristic()] = value;
                }
            }

        }
    }

    public void cancelEffects(List<StatusEffect> statusEffects){
        for (StatusEffect statusEffect : statusEffects){
            if (statusEffect.getCategory() == StatusEffectCategory.BuffUpp) {
                characteristics[statusEffect.getCharacteristic()] -= statusEffect.getValue();
            }
            if (statusEffect.getCategory() == StatusEffectCategory.DebuffDown) {
                characteristics[statusEffect.getCharacteristic()] += statusEffect.getValue();
            }
            if (statusEffect.getCategory() == StatusEffectCategory.Advantage){
                throwAdvantages[statusEffect.getCharacteristic()].remove(statusEffect.getValue());
            }
            if (statusEffect.getCategory() == StatusEffectCategory.BuffSet
                    || statusEffect.getCategory() == StatusEffectCategory.DebuffSet){
                recountEffectsByCharacteristic(Characteristic.values()[statusEffect.getCharacteristic()]);
            }
        }
    }

    public void recountEffectsByCharacteristic(Characteristic characteristic){
        List<StatusEffect> effects = getEffectsByCharacteristic(characteristic);
        characteristics[characteristic.ordinal()] = defaultCharacteristics[characteristic.ordinal()];
        applyEffects(effects);
    }

    public void equipAndApplyItem(Equipment newEquipped){
        List<Item> oldItems;
        try {
            oldItems = characterItemSet.equipItem(newEquipped.getItem());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        //Confirm unequipemts previous items and remove buffs
        for (Item oldItem: oldItems){
            for(Equipment equip: equipmentList){
                if(equip.getItem() == oldItem){
                    equip.setEquip(false);
                }
            }
            Set<ItemStatusEffect> itemStatusEffectSet = oldItem.getItemStatusEffectSet();
            List<StatusEffect> statusEffectList = new ArrayList<>();
            for (ItemStatusEffect itemStatusEffect : itemStatusEffectSet){
                statusEffects.remove(itemStatusEffect.getStatusEffect());
                statusEffectList.add(itemStatusEffect.getStatusEffect());
            }
            cancelEffects(statusEffectList);
        }
        //Confirm equipment new item and apply buffs
        newEquipped.setEquip(true);
        Set<ItemStatusEffect> itemStatusEffectSet = newEquipped.getItem().getItemStatusEffectSet();
        List<StatusEffect> statusEffectList = new ArrayList<>();
        for (ItemStatusEffect itemStatusEffect : itemStatusEffectSet){
            statusEffects.add(itemStatusEffect.getStatusEffect());
            statusEffectList.add(itemStatusEffect.getStatusEffect());
        }
        applyEffects(statusEffectList);
    }

    public void unequipAndCancelItem(CharacterItemSet.SetSlot setSlot){
        Item oldItem;
        try {
            oldItem = characterItemSet.unequipItem(setSlot);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        if (oldItem != null){
            for (Equipment equipment : equipmentList){
                if (equipment.getItem() == oldItem){
                    equipment.setEquip(false);
                }
            }
            Set<ItemStatusEffect> itemStatusEffectSet = oldItem.getItemStatusEffectSet();
            List<StatusEffect> statusEffectList = new ArrayList<>();
            for (ItemStatusEffect itemStatusEffect : itemStatusEffectSet){
                statusEffects.remove(itemStatusEffect.getStatusEffect());
                statusEffectList.add(itemStatusEffect.getStatusEffect());
            }
            cancelEffects(statusEffectList);
        }
    }

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }


    public int[] getCharacteristics() {
        return characteristics;
    }

    public CharacterItemSet getCharacterItemSet() {
        return characterItemSet;
    }

    public void setCharacterItemSet(CharacterItemSet characterItemSet) {
        this.characterItemSet = characterItemSet;
    }

    public String toStringCharacteristics() {
        String result = character.getName() + "------->\n";
        for (int i=0;i< characteristics.length;i++){
            result += Characteristic.values()[i] + ": " + characteristics[i] + "\n";
        }
        return result;
    }
}
