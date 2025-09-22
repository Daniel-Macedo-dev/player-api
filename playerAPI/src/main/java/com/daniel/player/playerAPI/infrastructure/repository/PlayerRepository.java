package com.daniel.player.playerAPI.infrastructure.repository;

import com.daniel.player.playerAPI.infrastructure.entities.Player;
import org.springframework.stereotype.Repository;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Repository
public class PlayerRepository {

    private final DynamoDbTable<Player> playerTable;

    public PlayerRepository(DynamoDbClient dynamoDbClient) {
        DynamoDbEnhancedClient enhancedClient = DynamoDbEnhancedClient.builder()
                .dynamoDbClient(dynamoDbClient)
                .build();

        this.playerTable = enhancedClient.table("Players", TableSchema.fromBean(Player.class));
    }

    public Player save(Player player) {
        if (player.getId() == null) {
            player.setId(UUID.randomUUID().toString());
        }
        playerTable.putItem(player);
        return player;
    }

    public List<Player> findAll() {
        return StreamSupport.stream(playerTable.scan().spliterator(), false)
                .flatMap(page -> page.items().stream()) // converte Page<Player> → Player
                .collect(Collectors.toList());
    }

    public Player findById(String id) {
        return playerTable.getItem(r -> r.key(k -> k.partitionValue(id)));
    }

    public void deleteById(String id) {
        playerTable.deleteItem(r -> r.key(k -> k.partitionValue(id)));
    }
}
