package com.moniala.dynamic_table.controller;

import com.moniala.dynamic_table.model.Row;
import com.moniala.dynamic_table.service.RowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rows")
public class RowController {
    @Autowired
    private RowService rowService;

    @GetMapping("/card/{cardId}")
    public List<Row> getRowsByCard(@PathVariable Long cardId) {
        return rowService.getRowsByCardId(cardId);
    }

    @PostMapping
    public Row createRow(@RequestBody Row row) {
        return rowService.saveRow(row);
    }

    @DeleteMapping("/{id}")
    public void deleteRow(@PathVariable Long id) {
        rowService.deleteRow(id);
    }
}