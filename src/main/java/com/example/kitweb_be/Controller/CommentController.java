package com.example.kitweb_be.Controller;
import com.example.kitweb_be.Entity.Comment;
import com.example.kitweb_be.Repository.CommentRepository;
import com.example.kitweb_be.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CommentController {
    @Autowired
    private CommentRepository commentRepository;

    private CommentService commentService=new CommentService();
    @PostMapping("comment/{id}")
    public ResponseEntity<Object> createComment(@PathVariable Integer id, @RequestBody Comment comment){
        comment.setMessage_id(id);
        return ResponseEntity.ok(commentRepository.save(comment));
    }
    @GetMapping("comment/getByMessageId")
    public ResponseEntity<?> getAllMessageByMsId(@RequestParam(value = "id")Integer id) {

        return ResponseEntity.ok(commentRepository.findAllByMessage_id(id));
    }
    @PutMapping("comment/update/{id}")
    public ResponseEntity<Object> UpdateComment(@PathVariable Integer id,@RequestBody Comment comment){
        Comment newComment= commentRepository.findCommentById(id);
        commentService.converter(comment,newComment);
        return ResponseEntity.ok(commentRepository.save(newComment));
    }
}
