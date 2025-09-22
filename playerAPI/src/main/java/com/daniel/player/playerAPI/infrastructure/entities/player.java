package com.daniel.player.playerAPI.infrastructure.entities;

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;
import lombok.Data;

@Data
@DynamoDbBean
public class Player {

    private String id;
    private String name;
    private int level;

    @DynamoDbPartitionKey
    public String getId() {
        return id;
    }
}
