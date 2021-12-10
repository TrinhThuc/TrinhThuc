package com.example.kitweb_be.service;

import com.example.kitweb_be.Entity.Message;

public class MessageService {
    public Message converter(Message message,Message newMessage){
        newMessage.setContent(message.getContent());
        newMessage.setHeading(message.getHeading());
        newMessage.setCreateBy(message.getCreateBy());
        newMessage.setCreateDate(message.getCreateDate());
        newMessage.setThumbnail(message.getThumbnail());
        newMessage.setShortDescription(message.getShortDescription());
        newMessage.setUpdateBy(message.getUpdateBy());
        newMessage.setUpdateDate(message.getUpdateDate());
        return newMessage;
    }

}
