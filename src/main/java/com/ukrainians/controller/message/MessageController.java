package com.ukrainians.controller.message;

import com.ukrainians.entity.Message;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("user/message")
public interface MessageController {
    @PostMapping("/send")//відправити повідомлення
    public ResponseEntity<Message> sendMessage(@RequestBody Message message);

    @GetMapping("/{messageId}")
    public ResponseEntity<Message> getMessage(@PathVariable Long messageId);

    @GetMapping("/inbox")
    public List<Message> getInboxMessages(@RequestParam Long userId);

    @GetMapping("/outbox")
    public List<Message> getOutboxMessages(@RequestParam Long userId);

    @GetMapping("/conversations")
    public List<Message> getConversations(@RequestParam Long userId);

    @PutMapping("/{messageId}/update")
    ResponseEntity<Message> updateMessage(@PathVariable Long messageId, @RequestBody Message updatedMessage);

    @DeleteMapping("/{messageId}/delete")
    void deleteMessage(@PathVariable Long messageId);
}
