package com.moniala.dynamic_table.model;

import jakarta.persistence.*;

@Entity
public class Column {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "card_id")
    private Card card;

    // Getterit ja setterit
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Card getCard() { return card; }
    public void setCard(Card card) { this.card = card; }
}
