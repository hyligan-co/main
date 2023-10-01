package org.example.controller.message;

import org.example.entity.Message;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface MessageCntr {
    public ResponseEntity<Message> sendMessage(@RequestBody Message message);
    public ResponseEntity<Message> getMessage(@PathVariable Long messageId);

    public List<Message> getInboxMessages(@RequestParam Long userId);

    public List<Message> getOutboxMessages(@RequestParam Long userId);
    public List<Message> getConversations(@RequestParam Long userId);

}
