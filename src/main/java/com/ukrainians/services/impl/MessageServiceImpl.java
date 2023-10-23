package com.ukrainians.services.impl;

import com.ukrainians.repository.MessageRepository;
import com.ukrainians.entity.MessageEntity;
import com.ukrainians.services.MessageService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {
    private final MessageRepository messageRepository;

    public MessageServiceImpl(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    public MessageEntity sendMessage(MessageEntity message) {
        //відправки повідомлення
        return null;
    }

    @Override
    public MessageEntity getMessageById(Long messageId) {
        //отримання повідомлення за ід
        return null;
    }

    @Override
    public List<MessageEntity> getInboxMessages(Long userId) {
        //отримання вхідних повідомлень користувача
        return null;
    }

    @Override
    public List<MessageEntity> getOutboxMessages(Long userId) {
        //отримання вихідних повідомлень користувача
        return null;
    }

    @Override
    public List<MessageEntity> getConversations(Long userId) {
        //отримання діалогів юзера
        return null;
    }

    @Override
    public MessageEntity updateMessage(Long messageId, MessageEntity updatedMessage) {
        //оновлення діалогу
        return null;
    }

    @Override
    public void deleteById(Long messageId) {
    }


}
