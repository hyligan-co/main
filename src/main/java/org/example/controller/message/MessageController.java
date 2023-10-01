package org.example.controller.message;
import org.example.entity.Message;
import org.example.services.message.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/message")
public class MessageController implements MessageCntr {

    @Autowired
    private MessageService messageService;

    @Override
    @PostMapping("/send")//відправити повідомлення
    public ResponseEntity<Message> sendMessage(@RequestBody Message message) {
       //відправка повідомлень
        Message sentMessage = messageService.sendMessage(message);
        return ResponseEntity.ok(sentMessage);
    }

    @Override
    @GetMapping("/{messageId}")
    public ResponseEntity<Message> getMessage (@PathVariable Long messageId) {
        //отримання помідомлення за ід
        Message message = messageService.getMessageById(messageId);
        if (message != null) {
            return ResponseEntity.ok(message);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/inbox")
    public List<Message> getInboxMessages(@RequestParam Long userId) {
        // Отримання вхідних повідомлень
        return messageService.getInboxMessages(userId);
    }

    @GetMapping("/outbox")
    public List<Message> getOutboxMessages(@RequestParam Long userId) {
        // Отримання вихідних повідомлень
        return messageService.getOutboxMessages(userId);
    }

    @GetMapping("/conversations")
    public List<Message> getConversations(@RequestParam Long userId) {
        return messageService.getConversations(userId);
    }

    @PutMapping("/{messageId}/update")
    public ResponseEntity<Message> updateMessage(@PathVariable Long messageId, @RequestBody Message updatedMessage) {
        //оновлення повідомлення за ід
        Message updated = messageService.updateMessage(messageId, updatedMessage);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{messageId}/delete")
    public void deleteMessage(@PathVariable Long messageId) {
        messageService.deleteById(messageId);
    }

}


//Позначити повідомлення як прочитані:
//
//POST /messages/{messageId}/mark-as-read: Позначити повідомлення як прочитане.

//Пошук повідомлень:
//
//GET /messages/search?query={searchQuery}: Здійснити пошук повідомлень за певним запитом.

//Дії з розмовами:
//
//POST /messages/conversations/create: Створити нову розмову з користувачем чи групою.
//POST /messages/conversations/{conversationId}/add-member: Додати користувача до розмови (якщо це групова розмова).
