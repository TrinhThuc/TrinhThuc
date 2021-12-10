package com.example.kitweb_be.Controller;

import com.example.kitweb_be.Entity.Comment;
import com.example.kitweb_be.Entity.Message;
import com.example.kitweb_be.Repository.CommentRepository;
import com.example.kitweb_be.Repository.MessageRepository;
import com.example.kitweb_be.response.NewsResponse;
import com.example.kitweb_be.service.CommentService;
import com.example.kitweb_be.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MainController {
    @Autowired
    private MessageRepository messageRepository;
    @Autowired
    private CommentRepository commentRepository;

    private CommentService commentService=new CommentService();


    @DeleteMapping("message/delete/{id}")
    public ResponseEntity<?> deleteMessage(@PathVariable Integer id) {
        for(Integer ids : commentRepository.deleteByMessage_id(id))
        {
            messageRepository.deleteById(ids);
        }

        return ResponseEntity.ok("Delete complete!");
    }

    @DeleteMapping("comment/delete")
    public ResponseEntity<?> deleteComment(@RequestParam (value="id")Integer id) {
        commentRepository.deleteById(id);
        return ResponseEntity.ok("Delete complete!");
    }


    @GetMapping("News/{id}")
    public ResponseEntity<?> getNews(@PathVariable Integer id) {
        NewsResponse newsResponse=new NewsResponse();
        newsResponse.setMessage(messageRepository.findMessageById(id));
        newsResponse.setComments(commentRepository.findAllByMessage_id(id));
        return ResponseEntity.ok(newsResponse);
    }





}
