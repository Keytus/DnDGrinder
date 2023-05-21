package com.controller;

import com.model.entity.Item;
import com.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/items")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @GetMapping("/all")
    public List<Item> getItems(){
        return itemService.getItems();
    }
}
