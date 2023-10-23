package com.ukrainians.controller.impl;

import com.ukrainians.controller.MessageController;
import com.ukrainians.entity.MessageEntity;
import com.ukrainians.services.impl.MessageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MessageControllerImpl implements MessageController {

    @Autowired
    private MessageServiceImpl messageService;

    @Override
    public ResponseEntity<MessageEntity> sendMessage(@RequestBody MessageEntity message) {
        //відправка повідомлень
        MessageEntity sentMessage = messageService.sendMessage(message);
        return ResponseEntity.ok(sentMessage);
    }

    @Override
    public ResponseEntity<MessageEntity> getMessage(@PathVariable Long messageId) {
        //отримання помідомлення за ід
        MessageEntity message = messageService.getMessageById(messageId);
        if (message != null) {
            return ResponseEntity.ok(message);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public List<MessageEntity> getInboxMessages(@RequestParam Long userId) {
        // Отримання вхідних повідомлень
        return messageService.getInboxMessages(userId);
    }

    @Override
    public List<MessageEntity> getOutboxMessages(@RequestParam Long userId) {
        // Отримання вихідних повідомлень
        return messageService.getOutboxMessages(userId);
    }

    @Override
    public List<MessageEntity> getConversations(@RequestParam Long userId) {
        return messageService.getConversations(userId);
    }

    @Override
    public ResponseEntity<MessageEntity> updateMessage(@PathVariable Long messageId, @RequestBody MessageEntity updatedMessage) {
        //оновлення повідомлення за ід
        MessageEntity updated = messageService.updateMessage(messageId, updatedMessage);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public void deleteMessage(@PathVariable Long messageId) {
        messageService.deleteById(messageId);
    }

}

