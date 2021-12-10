package com.example.kitweb_be.Repository;
import com.example.kitweb_be.Entity.Message;
import com.example.kitweb_be.response.NewsResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message,Integer> {
    List<Message> findAll();
    @Query("select message from Message message where message.content like %:content%")
    List<Message> findAllByContent(String content);
    @Query("select message from Message message where message.id=:id")
    Message findMessageById(Integer id);



}
