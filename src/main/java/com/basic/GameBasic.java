package com.basic;

import com.model.entity.Character;
import com.model.entity.Equipment;
import com.model.entity.StatusEffect;
import com.model.game.CharacterInfo;
import com.model.game.Characteristic;
import com.model.game.Race;
import com.model.game.ThrowAdvantage;
import com.model.game.category.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GameBasic {
//
//    public final static List<CharacterInfo> characterInfoList = new ArrayList<>();

    public static Race[] races = new Race[RaceCategory.values().length];

    public static Race[] subRaces = new Race[SubraceCategory.values().length];

    public static int getAbilityModifier(int abilityValue){
        return (int) Math.floor((abilityValue-10) / 2);
    }

//    public static void initializeChars(List<Character> characters, List<Equipment> equipmentList){
//        for(Character character : characters){
//            List<Equipment> characterEquipment = new ArrayList<>();
//            for (Equipment equipment: equipmentList){
//                if (equipment.getCharacter().getCharacterID().equals(character.getCharacterID())){
//                    characterEquipment.add(equipment);
//                }
//            }
//            CharacterInfo characterInfo = new CharacterInfo(character, characterEquipment);
//            characterInfoList.add(characterInfo);
//        }
//        System.out.println("Initialize Chars");
//    }

    public static void initializeRaces(){
        Race human = new Race("Human");

        human.getRaceBuffs().add(new StatusEffect(null, StatusEffectCategory.BuffUpp, null,
                null, 1, Characteristic.Strength.ordinal(), EffectOriginCategory.Race));
        human.getRaceBuffs().add(new StatusEffect(null, StatusEffectCategory.BuffUpp, null,
                null, 1, Characteristic.Dexterity.ordinal(), EffectOriginCategory.Race));
        human.getRaceBuffs().add(new StatusEffect(null, StatusEffectCategory.BuffUpp, null,
                null, 1, Characteristic.Intelligence.ordinal(), EffectOriginCategory.Race));
        human.getRaceBuffs().add(new StatusEffect(null, StatusEffectCategory.BuffUpp, null,
                null, 1, Characteristic.Constitution.ordinal(), EffectOriginCategory.Race));
        human.getRaceBuffs().add(new StatusEffect(null, StatusEffectCategory.BuffUpp, null,
                null, 1, Characteristic.Wisdom.ordinal(), EffectOriginCategory.Race));
        human.getRaceBuffs().add(new StatusEffect(null, StatusEffectCategory.BuffUpp, null,
                null, 1, Characteristic.Charisma.ordinal(), EffectOriginCategory.Race));

        human.getRaceBuffs().add(new StatusEffect(null, StatusEffectCategory.BuffSet, null,
                null, 30, Characteristic.WalkingSpeed.ordinal(), EffectOriginCategory.Race));

        human.getRaceBuffs().add(new StatusEffect(null, StatusEffectCategory.BuffSet, null,
                null, SizeCategory.Medium.ordinal(), Characteristic.Size.ordinal(), EffectOriginCategory.Race));

        races[RaceCategory.Human.ordinal()] = human;

        Race dwarf = new Race("Dwarf");

        dwarf.getRaceBuffs().add(new StatusEffect(null, StatusEffectCategory.BuffUpp, null,
                null, 2, Characteristic.Constitution.ordinal(), EffectOriginCategory.Race));
        dwarf.getRaceBuffs().add(new StatusEffect(null, StatusEffectCategory.BuffSet, null,
                null, 25, Characteristic.WalkingSpeed.ordinal(), EffectOriginCategory.Race));
        dwarf.getRaceBuffs().add(new StatusEffect(null, StatusEffectCategory.BuffSet, null,
                null, 60, Characteristic.DarkVision.ordinal(), EffectOriginCategory.Race));
        dwarf.getRaceBuffs().add(new StatusEffect(null, StatusEffectCategory.BuffSet, null,
                null, ResistanceCategory.Resistance.ordinal(), Characteristic.PoisonResistance.ordinal(), EffectOriginCategory.Race));
        dwarf.getRaceBuffs().add(new StatusEffect(null, StatusEffectCategory.Advantage, null,
                null, AdvantageCategory.Advantage.ordinal(), ThrowAdvantage.Poisoned.ordinal(), EffectOriginCategory.Race));


        System.out.println("Initialize Races");
    }
}
