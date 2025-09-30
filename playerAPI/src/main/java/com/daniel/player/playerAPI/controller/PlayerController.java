package com.daniel.player.playerAPI.controller;

import com.daniel.player.playerAPI.business.PlayerService;
import com.daniel.player.playerAPI.infrastructure.entities.Player;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/player")
@RequiredArgsConstructor
public class PlayerController {

    private final PlayerService playerService;

    @PostMapping
    public ResponseEntity<Player> save(@RequestBody Player player){
        Player novoPlayer = playerService.salvarPlayer(player);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoPlayer);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Player> findById(@PathVariable String id){
        Player player = playerService.buscarPlayerPorId(id);
        return ResponseEntity.ok(player);
    }

    @GetMapping
    public ResponseEntity<List<Player>> findAll() {return ResponseEntity.ok(playerService.listarPlayers());}

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String id){
        playerService.deletarPlayerPorId(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Player> replacePlayer(@PathVariable String id,
                                                @RequestBody Player novoPlayer){
        Player atualizado = playerService.substituirPlayer(id, novoPlayer);
        return ResponseEntity.ok(atualizado);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Player> updatePlayer(@PathVariable String id,
                                               @RequestBody Player novoPlayer){
        Player atualizado = playerService.atualizarPlayer(id, novoPlayer);
        return ResponseEntity.ok(atualizado);
    }
}
