package com.ukrainians.services.message;

import com.ukrainians.entity.Message;

import java.util.List;

public interface MessageService {
    Message sendMessage(Message message);
    Message getMessageById(Long messageId);
    public List<Message> getInboxMessages(Long userId);
    public List<Message> getOutboxMessages(Long userId);
    List<Message> getConversations(Long userId);
    Message updateMessage(Long messageId, Message updatedMessage);
    void deleteById(Long messageId);
}
