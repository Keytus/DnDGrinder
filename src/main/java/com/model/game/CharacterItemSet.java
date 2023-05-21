package com.model.game;

import com.model.entity.Equipment;
import com.model.entity.Item;

import java.util.ArrayList;
import java.util.List;

public class CharacterItemSet {

    public enum SetSlot {
        Head,
        Face,
        Shoulders,
        Throat,
        Body,
        Torso,
        Arms,
        Hands,
        Waist,
        FirstRing,
        SecondRing,
        Feet,
        MainHand,
        OffHand,
    }
    private Item[] itemSet = new Item[SetSlot.values().length];

    public CharacterItemSet(List<Equipment> equipmentList){
        for (Equipment equipment : equipmentList){
            if (equipment.getEquip()){
                try {
                    equipItem(equipment.getItem());
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public Item unequipItem(SetSlot setSlot){
        Item item = itemSet[setSlot.ordinal()];
        itemSet[setSlot.ordinal()] = null;
        return item;
    }

    public List<Item> equipItem(Item newItem) throws Exception {
        List<Item> oldItems = new ArrayList<>();
        switch (newItem.getItemType()){
            case Head -> {
                if (itemSet[SetSlot.Head.ordinal()] != null){
                    oldItems.add(itemSet[SetSlot.Head.ordinal()]);
                }
                itemSet[SetSlot.Head.ordinal()] = newItem;
            }
            case Face -> {
                if (itemSet[SetSlot.Face.ordinal()] != null){
                    oldItems.add(itemSet[SetSlot.Face.ordinal()]);
                }
                itemSet[SetSlot.Face.ordinal()] = newItem;
            }
            case Shoulders -> {
                if (itemSet[SetSlot.Shoulders.ordinal()] != null){
                    oldItems.add(itemSet[SetSlot.Shoulders.ordinal()]);
                }
                itemSet[SetSlot.Shoulders.ordinal()] = newItem;
            }
            case Throat -> {
                if (itemSet[SetSlot.Throat.ordinal()] != null){
                    oldItems.add(itemSet[SetSlot.Throat.ordinal()]);
                }
                itemSet[SetSlot.Throat.ordinal()] = newItem;
            }
            case Body -> {
                if (itemSet[SetSlot.Body.ordinal()] != null){
                    oldItems.add(itemSet[SetSlot.Body.ordinal()]);
                }
                itemSet[SetSlot.Body.ordinal()] = newItem;
            }
            case Torso -> {
                if (itemSet[SetSlot.Torso.ordinal()] != null){
                    oldItems.add(itemSet[SetSlot.Torso.ordinal()]);
                }
                itemSet[SetSlot.Torso.ordinal()] = newItem;
            }
            case Hands -> {
                if (itemSet[SetSlot.Hands.ordinal()] != null){
                    oldItems.add(itemSet[SetSlot.Hands.ordinal()]);
                }
                itemSet[SetSlot.Hands.ordinal()] = newItem;
            }
            case Waist -> {
                if (itemSet[SetSlot.Waist.ordinal()] != null){
                    oldItems.add(itemSet[SetSlot.Waist.ordinal()]);
                }
                itemSet[SetSlot.Waist.ordinal()] = newItem;
            }
            case Feet -> {
                if (itemSet[SetSlot.Feet.ordinal()] != null){
                    oldItems.add(itemSet[SetSlot.Feet.ordinal()]);
                }
                itemSet[SetSlot.Feet.ordinal()] = newItem;
            }
            case Ring -> {
                if (itemSet[SetSlot.FirstRing.ordinal()] != null){
                    if(itemSet[SetSlot.SecondRing.ordinal()] != null){
                        oldItems.add(itemSet[SetSlot.FirstRing.ordinal()]);
                        itemSet[SetSlot.FirstRing.ordinal()] = newItem;
                    }
                    else itemSet[SetSlot.SecondRing.ordinal()] = newItem;
                }
                else itemSet[SetSlot.FirstRing.ordinal()] = newItem;
            }
            case OffHand -> {
                if (itemSet[SetSlot.OffHand.ordinal()] != null){
                    oldItems.add(itemSet[SetSlot.OffHand.ordinal()]);
                }
                if(itemSet[SetSlot.MainHand.ordinal()] != null &&
                        itemSet[SetSlot.MainHand.ordinal()].getWeapon().getTwoHanded()){
                    oldItems.add(itemSet[SetSlot.MainHand.ordinal()]);
                    itemSet[SetSlot.MainHand.ordinal()] = null;
                }
                itemSet[SetSlot.OffHand.ordinal()] = newItem;
            }
            case Weapon -> {
                if (newItem.getWeapon().getTwoHanded()){
                    if (itemSet[SetSlot.OffHand.ordinal()] != null){
                        oldItems.add(itemSet[SetSlot.OffHand.ordinal()]);
                        itemSet[SetSlot.OffHand.ordinal()] = null;
                    }
                    if (itemSet[SetSlot.MainHand.ordinal()] != null){
                        oldItems.add(itemSet[SetSlot.MainHand.ordinal()]);
                    }
                    itemSet[SetSlot.MainHand.ordinal()] = newItem;
                }
                else {
                    if (itemSet[SetSlot.MainHand.ordinal()] != null){
                        if (itemSet[SetSlot.OffHand.ordinal()] != null){
                            oldItems.add(itemSet[SetSlot.MainHand.ordinal()]);
                            itemSet[SetSlot.MainHand.ordinal()] = newItem;
                        }
                        else {
                            itemSet[SetSlot.OffHand.ordinal()] = newItem;
                        }
                    }
                    else itemSet[SetSlot.MainHand.ordinal()] = newItem;
                }
            }
            case default -> throw new Exception("This item " + newItem.getItemName() + " cannot be equipped");
        }

        return oldItems;
    }

    public Item[] getItemSet() {
        return itemSet;
    }

    public void setItemSet(Item[] itemSet) {
        this.itemSet = itemSet;
    }
}
