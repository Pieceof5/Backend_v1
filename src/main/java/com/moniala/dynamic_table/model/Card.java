package com.moniala.dynamic_table.model;



import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "card", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Column> columns;

    @OneToMany(mappedBy = "card", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Row> rows = new ArrayList<>();

    // getterit ja setterit
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public List<Column> getColumns() { return columns; }
    public void setColumns(List<Column> columns) {
        this.columns = columns;
        if (columns != null) {
            columns.forEach(c -> c.setCard(this));
        }
    }

    public List<Row> getRows() { return rows; }
    public void setRows(List<Row> rows) {
        this.rows = rows;
        if (rows != null) {
            rows.forEach(r -> r.setCard(this));
        }
    }
}
