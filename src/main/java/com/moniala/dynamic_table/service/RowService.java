package com.moniala.dynamic_table.service;

import com.moniala.dynamic_table.model.Row;
import com.moniala.dynamic_table.repository.RowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RowService {
    @Autowired
    private RowRepository rowRepository;

    public List<Row> getRowsByCardId(Long cardId) {
        return rowRepository.findByCardId(cardId);
    }

    public Row saveRow(Row row) {
        return rowRepository.save(row);
    }

    public void deleteRow(Long id) {
        rowRepository.deleteById(id);
    }
}
