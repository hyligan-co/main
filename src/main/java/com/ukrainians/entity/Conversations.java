package com.ukrainians.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Conversations")
public class Conversations {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long conversation_id;
}
