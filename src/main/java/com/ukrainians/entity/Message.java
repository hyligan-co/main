package com.ukrainians.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "MESSAGES")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "sender_id", referencedColumnName = "id")
    private User sender; // Користувач, який відправив повідомлення

    @ManyToOne
    @JoinColumn(name = "recipient_id", referencedColumnName = "id")
    private User recipient; // Користувач, якому призначено повідомлення

    @Column(name = "content", length = 1000)
    private String content; // Текст повідомлення

    @Column(name = "sent_at")
    private Date sentAt; // Дата і час відправки

    @Column(name = "read_at")
    private Date readAt; // Дата і час, коли повідомлення було прочитано


}
