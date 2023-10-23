package com.ukrainians.controller;

import com.ukrainians.entity.MessageEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("user/message")
public interface MessageController {
    @PostMapping("/send")//відправити повідомлення
    public ResponseEntity<MessageEntity> sendMessage(@RequestBody MessageEntity message);

    @GetMapping("/{messageId}")
    public ResponseEntity<MessageEntity> getMessage(@PathVariable Long messageId);

    @GetMapping("/inbox")
    public List<MessageEntity> getInboxMessages(@RequestParam Long userId);

    @GetMapping("/outbox")
    public List<MessageEntity> getOutboxMessages(@RequestParam Long userId);

    @GetMapping("/conversations")
    public List<MessageEntity> getConversations(@RequestParam Long userId);

    @PutMapping("/{messageId}/update")
    ResponseEntity<MessageEntity> updateMessage(@PathVariable Long messageId, @RequestBody MessageEntity updatedMessage);

    @DeleteMapping("/{messageId}/delete")
    void deleteMessage(@PathVariable Long messageId);
}
