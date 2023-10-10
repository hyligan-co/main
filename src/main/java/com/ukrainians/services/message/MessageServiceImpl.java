package com.ukrainians.services.message;

import com.ukrainians.repository.MessageRepository;
import com.ukrainians.entity.Message;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {
    private final MessageRepository messageRepository;

    public MessageServiceImpl(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    public Message sendMessage(Message message) {
        //відправки повідомлення
        return null;
    }

    @Override
    public Message getMessageById(Long messageId) {
        //отримання повідомлення за ід
        return null;
    }

    @Override
    public List<Message> getInboxMessages(Long userId) {
        //отримання вхідних повідомлень користувача
        return null;
    }

    @Override
    public List<Message> getOutboxMessages(Long userId) {
        //отримання вихідних повідомлень користувача
        return null;
    }

    @Override
    public List<Message> getConversations(Long userId) {
        //отримання діалогів юзера
        return null;
    }

    @Override
    public Message updateMessage(Long messageId, Message updatedMessage) {
        //оновлення діалогу
        return null;
    }

    @Override
    public void deleteById(Long messageId) {
    }


}
