package com.example.kitweb_be.Controller;

import com.example.kitweb_be.Entity.Message;
import com.example.kitweb_be.Entity.Tag;
import com.example.kitweb_be.Repository.MessageRepository;
import com.example.kitweb_be.Repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TagController {
    @Autowired
    TagRepository tagRepository;

    @Autowired
    MessageRepository messageRepository;

    @PostMapping("tag/post")
    public ResponseEntity<Object> createTag(@RequestBody Tag tag){
        return ResponseEntity.ok(tagRepository.save(tag));
    }

    @GetMapping("tag/getAll")
    public ResponseEntity<Object> getAllTag() {
        return ResponseEntity.ok(tagRepository.findAll());
    }

    @PutMapping("tag/{tagId}/message/{messageId}")
    public ResponseEntity<Object> addTagtoMessage(
            @PathVariable Integer tagId,
            @PathVariable Integer messageId
    ) {
        Message message = messageRepository.findById(messageId).get();
        Tag tag = tagRepository.findById(tagId).get();
        tag.messages.add(message);
        return ResponseEntity.ok(tagRepository.save(tag));
    }
}
