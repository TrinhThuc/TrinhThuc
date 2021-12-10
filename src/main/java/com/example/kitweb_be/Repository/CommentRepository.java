package com.example.kitweb_be.Repository;

import com.example.kitweb_be.Entity.Comment;


import com.example.kitweb_be.Entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
public interface CommentRepository extends JpaRepository<Comment,Integer>{

    @Query("select cmt from Comment cmt where cmt.message_id=:id")
    List<Comment> findAllByMessage_id(Integer id);

    @Query("select comment from Comment comment where comment.id=:id")
    Comment findCommentById(Integer id);

    @Modifying
    @Query("delete from Comment cmt where cmt.message_id=:id")
    void deleteByMessage_Id(Integer id);

    @Query("select cmt.id from Comment cmt where cmt.message_id=:id")
    List<Integer> deleteByMessage_id(Integer id);


}
