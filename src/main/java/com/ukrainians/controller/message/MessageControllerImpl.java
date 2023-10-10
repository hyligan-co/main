package com.ukrainians.controller.message;

import com.ukrainians.entity.Message;
import com.ukrainians.services.message.MessageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MessageControllerImpl implements MessageController {

    @Autowired
    private MessageServiceImpl messageService;

    @Override
    public ResponseEntity<Message> sendMessage(@RequestBody Message message) {
        //відправка повідомлень
        Message sentMessage = messageService.sendMessage(message);
        return ResponseEntity.ok(sentMessage);
    }

    @Override
    public ResponseEntity<Message> getMessage(@PathVariable Long messageId) {
        //отримання помідомлення за ід
        Message message = messageService.getMessageById(messageId);
        if (message != null) {
            return ResponseEntity.ok(message);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public List<Message> getInboxMessages(@RequestParam Long userId) {
        // Отримання вхідних повідомлень
        return messageService.getInboxMessages(userId);
    }

    @Override
    public List<Message> getOutboxMessages(@RequestParam Long userId) {
        // Отримання вихідних повідомлень
        return messageService.getOutboxMessages(userId);
    }

    @Override
    public List<Message> getConversations(@RequestParam Long userId) {
        return messageService.getConversations(userId);
    }

    @Override
    public ResponseEntity<Message> updateMessage(@PathVariable Long messageId, @RequestBody Message updatedMessage) {
        //оновлення повідомлення за ід
        Message updated = messageService.updateMessage(messageId, updatedMessage);
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

