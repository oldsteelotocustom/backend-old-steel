package com.oldsteel.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter @ToString
@Table(name = "post")
public class PostArticle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @Lob
    @Column(name = "body_article")
    // columnDefinition = "TEXT", length = 2000)
    private String body;
    private String author;

    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;



}
