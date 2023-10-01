package org.example.services.message;

import org.example.entity.Message;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface MessageSrvc {
    Message sendMessage(Message message);
    Message getMessageById(Long messageId);
    public List<Message> getInboxMessages(Long userId);
    public List<Message> getOutboxMessages(Long userId);
    List<Message> getConversations(Long userId);
    Message updateMessage(Long messageId, Message updatedMessage);
    void deleteById(Long messageId);
}
