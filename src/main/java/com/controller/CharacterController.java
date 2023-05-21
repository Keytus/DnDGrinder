package com.controller;

import com.model.Message;
import com.model.entity.Character;
import com.model.entity.Equipment;
import com.model.entity.Player;
import com.model.game.CharacterInfo;
import com.model.game.CharacterItemSet;
import com.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/characters")
public class CharacterController {

    @Autowired
    private CharacterService characterService;

    @GetMapping("/all")
    public List<Character> getCharacters(){
        return characterService.getCharacters();
    }

    @GetMapping("/{id}")
    public Character getCharacterByID(@PathVariable Integer id){
        return characterService.getCharacterByID(id);
    }

    @GetMapping("/info/{id}")
    public CharacterInfo getCharacterInfoByID(@PathVariable Integer id){
        return characterService.getCharacterInfoByID(id);
    }

    @GetMapping("/{id}/equipment")
    public List<Equipment> getCharacterEquipmentByID(@PathVariable Integer id){
        return characterService.getCharacterEquipmentByID(id);
    }

    @PutMapping("/info/{id}/equipment/unequip")
    public CharacterInfo unequipItemBySetSlot(@PathVariable Integer id,
                                              @RequestParam CharacterItemSet.SetSlot setSlot){
        return characterService.unequipItemBySetSlot(id, setSlot);
    }
}
