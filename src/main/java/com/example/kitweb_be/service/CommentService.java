package com.example.kitweb_be.service;
import com.example.kitweb_be.Entity.Comment;
import com.example.kitweb_be.Entity.Message;

public class CommentService {
    public Comment converter(Comment comment,Comment newComment){
        newComment.setComment(comment.getComment());
        newComment.setUpdateDate(comment.getUpdateDate());
        return newComment;
    }
}
