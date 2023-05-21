package com.service;

import com.model.entity.Player;

import java.util.List;

public interface PlayerService {
    public List<Player> getPlayers();

    public Player getPlayerByID(Integer id);

    public void deletePlayerByID(Integer id);

    public Player updatePlayerByID(Integer id, Player player);
}
