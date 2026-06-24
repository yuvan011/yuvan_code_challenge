package com.example.demo.service;

import java.util.List;
import com.example.demo.dto.RoleCountDTO;
import com.example.demo.dto.PlayerDTO;
import com.example.demo.entity.Player;

public interface PlayerService {
	List<RoleCountDTO> getPlayerCountByRole(String teamName);

    Player createPlayer(PlayerDTO playerDTO);

    List<Player> getAllPlayers();

    Player getPlayerById(Long playerId);

    Player updatePlayer(Long playerId, PlayerDTO playerDTO);

    void deletePlayer(Long playerId);
}