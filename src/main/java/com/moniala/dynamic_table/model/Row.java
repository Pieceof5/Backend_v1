package com.moniala.dynamic_table.model;



import jakarta.persistence.*;
import java.util.Map;
import jakarta.persistence.Column;

@Entity
@Table(name = "row_table")
public class Row {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "card_id")
    private Card card;

    @ElementCollection
    @CollectionTable(name = "row_values", joinColumns = @JoinColumn(name = "row_id"))
    @MapKeyColumn(name = "column_name")
    @Column(name = "column_value") // <-- vaihdettiin 'value' -> 'column_value'
    private Map<String, String> values;


    // getterit ja setterit
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Card getCard() { return card; }
    public void setCard(Card card) { this.card = card; }

    public Map<String, String> getValues() { return values; }
    public void setValues(Map<String, String> values) { this.values = values; }
}

/*

import jakarta.persistence.*;
import java.util.Map;
import jakarta.persistence.Column;

@Entity
@Table(name = "row_table")
public class Row {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "card_id")
    private Card card;

    @ElementCollection
    @CollectionTable(name = "row_values", joinColumns = @JoinColumn(name = "row_id"))
    @MapKeyColumn(name = "column_name")
    @Column(name = "column_value") // <-- vaihdettiin 'value' -> 'column_value'
    private Map<String, String> values;


    // getterit ja setterit
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Card getCard() { return card; }
    public void setCard(Card card) { this.card = card; }

    public Map<String, String> getValues() { return values; }
    public void setValues(Map<String, String> values) { this.values = values; }
}
*/