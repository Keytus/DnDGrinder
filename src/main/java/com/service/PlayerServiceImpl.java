package com.service;

import com.model.entity.Player;
import com.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    @Override
    public List<Player> getPlayers(){
        return playerRepository.findAll();
    }

    @Override
    public Player getPlayerByID(Integer id){
        return playerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Player not exist with id :" + id));
    }

    @Override
    public void deletePlayerByID(Integer id){
        Player player = playerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Player not exist with id :" + id));
        playerRepository.delete(player);
    }

    @Override
    public Player updatePlayerByID(Integer id, Player playerData){
        Player player = playerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Player not exist with id :" + id));
        player.setEmail(playerData.getEmail());
        player.setPassword(playerData.getPassword());
        player.setUserName(playerData.getUserName());
        return playerRepository.save(player);
    }

}
