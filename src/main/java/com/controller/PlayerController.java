package com.controller;

import com.model.Message;
import com.model.entity.Player;
import com.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/players")
public class PlayerController {
    @Autowired
    private PlayerService playerService;

    @GetMapping("/all")
    public List<Player> getPlayers(){
        return playerService.getPlayers();
    }

    @GetMapping("/{id}")
    public Player getPlayerByID(@PathVariable Integer id){
        return playerService.getPlayerByID(id);
    }

    @PutMapping("/{id}")
    public Player updatePlayerByID(@PathVariable Integer id, @RequestBody Player player){
        return playerService.updatePlayerByID(id, player);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Message> deleteCustomerByID(@PathVariable Integer id){
        playerService.deletePlayerByID(id);
        return new ResponseEntity<>(new Message("success", id), HttpStatus.OK);
    }

}
