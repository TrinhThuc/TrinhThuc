package com.example.kitweb_be.Controller;

import com.example.kitweb_be.Entity.Message;
import com.example.kitweb_be.Entity.Tag;
import com.example.kitweb_be.Repository.MessageRepository;
import com.example.kitweb_be.Repository.TagRepository;
import com.example.kitweb_be.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MessageController {
    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    TagRepository tagRepository;

    private MessageService messageService=new MessageService();
    @PostMapping("message/post")
    public ResponseEntity<Object> createMessage(@RequestBody Message message){
        return ResponseEntity.ok(messageRepository.save(message));
    }
    @GetMapping("message/getAll")
    public ResponseEntity<Object> getAllMessage() {
        return ResponseEntity.ok(messageRepository.findAll());
    }

    @GetMapping("message/search")
    public ResponseEntity<?> getAllMessageByKeyWord(@RequestParam(value = "content")String content) {

        return ResponseEntity.ok(messageRepository.findAllByContent(content));
    }
    @PutMapping("message/update/{id}")
    public ResponseEntity<Object> UpdateMessage(@PathVariable Integer id,@RequestBody Message message){
        Message newMessage = messageRepository.findMessageById(id);
        messageService.converter(message,newMessage);
        return ResponseEntity.ok(messageRepository.save(newMessage));
    }

    @PutMapping("message/{messageId}/tag/{tagId}")
    public ResponseEntity<Object> addTagtoMessage(
            @PathVariable Integer messageId,
            @PathVariable Integer tagId
    ) {
        Message message = messageRepository.findById(messageId).get();
        Tag tag = tagRepository.findById(tagId).get();
        message.tags.add(tag);
        return ResponseEntity.ok(messageRepository.save(message));
    }

}