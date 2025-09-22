package com.daniel.player.playerAPI.business;

import com.daniel.player.playerAPI.infrastructure.entities.Player;
import com.daniel.player.playerAPI.infrastructure.repository.PlayerRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlayerService {

    private final PlayerRepository playerRepository;

    public Player salvarPlayer(Player player){return playerRepository.save(player);}

    public List<Player> listarPlayers(){return playerRepository.findAll();}

    public Player buscarPlayerPorId(String id){
        Player player = playerRepository.findById(id);
        if (player == null){
            throw new RuntimeException("Player com id " + id + " não encontrado");
        }
        return player;
    }

    public Player substituirPlayer(String id, Player novoPlayer){
        Player existente = playerRepository.findById(id);
        if (existente == null){
            throw new RuntimeException("Player com id " + id + " não encontrado");
        }
        novoPlayer.setId(id);
        return playerRepository.save(novoPlayer);

    }

    public Player atualizarPlayer(String id, Player novoPlayer){
        Player existente = playerRepository.findById(id);
        if (existente == null){
            throw new RuntimeException("Player com id " + id + " não encontrado");
        }

        if (novoPlayer.getName() != null) existente.setName(novoPlayer.getName());
        if (novoPlayer.getLevel() != 0) existente.setLevel(novoPlayer.getLevel());

        return playerRepository.save(existente);
    }

    public void deletarPlayerPorId(String id){ playerRepository.deleteById(id); }


}
