package com.ukrainians.services;

import com.ukrainians.entity.MessageEntity;

import java.util.List;

public interface MessageService {
    MessageEntity sendMessage(MessageEntity message);
    MessageEntity getMessageById(Long messageId);
    public List<MessageEntity> getInboxMessages(Long userId);
    public List<MessageEntity> getOutboxMessages(Long userId);
    List<MessageEntity> getConversations(Long userId);
    MessageEntity updateMessage(Long messageId, MessageEntity updatedMessage);
    void deleteById(Long messageId);
}
