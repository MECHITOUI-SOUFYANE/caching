package com.caching.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "book")
@ToString
public class Book implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 60)
    private String name;
    @Column(length = 40)
    private String category;
    @Column(length = 40)
    private String author;
    @Column(length = 40)
    private String publisher;
    @Column(length = 10)
    private String edition;
}
