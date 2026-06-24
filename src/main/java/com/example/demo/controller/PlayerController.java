package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.PlayerDTO;
import com.example.demo.entity.Player;
import com.example.demo.service.PlayerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/players")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @PostMapping
    public Player createPlayer(
            @Valid @RequestBody PlayerDTO playerDTO) {

        return playerService.createPlayer(playerDTO);
    }

    @GetMapping
    public List<Player> getAllPlayers() {

        return playerService.getAllPlayers();
    }

    @GetMapping("/{playerId}")
    public Player getPlayerById(
            @PathVariable Long playerId) {

        return playerService.getPlayerById(playerId);
    }

    @PutMapping("/{playerId}")
    public Player updatePlayer(
            @PathVariable Long playerId,
            @Valid @RequestBody PlayerDTO playerDTO) {

        return playerService.updatePlayer(
                playerId,
                playerDTO);
    }

    @DeleteMapping("/{playerId}")
    public String deletePlayer(
            @PathVariable Long playerId) {

        playerService.deletePlayer(playerId);

        return "Player Deleted Successfully";
    }
}