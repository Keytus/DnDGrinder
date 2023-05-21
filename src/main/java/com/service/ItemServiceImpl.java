package com.service;

import com.model.entity.Item;
import com.repository.CharacterRepository;
import com.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemRepository itemRepository;

    @Override
    public List<Item> getItems(){
        List<Item> rt = itemRepository.findAll();
        return itemRepository.findAll();
    }
}
