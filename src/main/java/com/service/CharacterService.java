package com.service;

import com.model.entity.Character;
import com.model.entity.Equipment;
import com.model.entity.Item;
import com.model.game.CharacterInfo;
import com.model.game.CharacterItemSet;

import java.util.List;

public interface CharacterService {
    public List<Character> getCharacters();

    public Character getCharacterByID(Integer id);

    public List<Equipment> getCharacterEquipmentByID(Integer id);

    public CharacterInfo getCharacterInfoByID(Integer id);

    public CharacterInfo unequipItemBySetSlot(Integer id, CharacterItemSet.SetSlot setSlot);
}
