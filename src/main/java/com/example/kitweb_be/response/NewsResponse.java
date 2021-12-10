package com.example.kitweb_be.response;

import com.example.kitweb_be.Entity.Comment;
import com.example.kitweb_be.Entity.Message;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewsResponse {
    private Message message;
    private List<Comment> comments;
}
