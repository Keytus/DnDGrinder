package com.service;

import com.basic.GameBasic;
import com.model.entity.Character;
import com.model.entity.Equipment;
import com.model.game.CharacterInfo;
import com.model.game.CharacterItemSet;
import com.repository.CharacterRepository;
import com.repository.EquipmentRepository;
import com.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class CharacterServiceImpl implements CharacterService{

    @Autowired
    private CharacterRepository characterRepository;

    @Autowired
    private EquipmentRepository equipmentRepository;

    @Autowired
    private ItemRepository itemRepository;

    @PostConstruct
    public void init() {
        GameBasic.initializeRaces();
//        GameBasic.initializeChars(characterRepository.findAll(), equipmentRepository.findAll());
    }

    @Override
    public List<Character> getCharacters(){
        return characterRepository.findAll();
    }

    @Override
    public Character getCharacterByID(Integer id){
        return characterRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Character not exist with id :" + id));
    }

    @Override
    public List<Equipment> getCharacterEquipmentByID(Integer id){
        return equipmentRepository.findByCharacterCharacterID(id);
    }

    @Override
    public CharacterInfo getCharacterInfoByID(Integer id){
        Character character =  getCharacterByID(id);
        List<Equipment> characterEquipment = new ArrayList<>();
        for (Equipment equipment: equipmentRepository.findAll()){
            if (equipment.getCharacter().getCharacterID().equals(character.getCharacterID())){
                characterEquipment.add(equipment);
            }
        }
        return new CharacterInfo(character, characterEquipment);
    }

    @Override
    public CharacterInfo unequipItemBySetSlot(Integer id, CharacterItemSet.SetSlot setSlot){
        CharacterInfo characterInfo = getCharacterInfoByID(id);
        characterInfo.unequipAndCancelItem(setSlot);
        return characterInfo;
    }
}
