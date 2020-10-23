package com.bookstore.api.model.entity;

import javax.persistence.*;

@Entity
public class LoanHistory {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Book book;

    @ManyToOne
    private User user;
}
