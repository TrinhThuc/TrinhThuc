package com.example.kitweb_be.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name="Message")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "createBy")
    private String createBy;

    @Column(name = "updateBy")
    private  String updateBy;

    @Column(name = "createDate")
    private Date createDate;

    @Column(name = "updateDate")
    private Date updateDate;

    @Column(name="heading",nullable = false,columnDefinition = "TEXT")
    private String heading;

    @Column(name="content",nullable = false,columnDefinition = "TEXT")
    private String content;

    @Lob
    @Column(name = "thumbnail")
    private String thumbnail;

    @Column(name = "shortdescription",columnDefinition = "TEXT")
    private String shortDescription;


    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "message_tags",
            joinColumns = { @JoinColumn(name = "message_id")},
            inverseJoinColumns = { @JoinColumn (name = "tag_id")})
    public Set<Tag> tags = new HashSet<Tag>();
}

