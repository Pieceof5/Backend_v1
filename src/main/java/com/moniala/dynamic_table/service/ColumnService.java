package com.moniala.dynamic_table.service;



import com.moniala.dynamic_table.model.Column;
import com.moniala.dynamic_table.repository.ColumnRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColumnService {

    private final ColumnRepository columnRepository;

    public ColumnService(ColumnRepository columnRepository) {
        this.columnRepository = columnRepository;
    }

    // Tallenna sarake
    public Column saveColumn(Column column) {
        return columnRepository.save(column);
    }

    // Hae kaikki sarakkeet tietylle kortille
    public List<Column> getColumnsByCardId(Long cardId) {
        return columnRepository.findByCardId(cardId);
    }

    // Hae kaikki sarakkeet
    public List<Column> getAllColumns() {
        return columnRepository.findAll();
    }

    public void deleteColumn(Long columnId) {
        if (columnRepository.existsById(columnId)) {
            columnRepository.deleteById(columnId);
        } else {
            throw new RuntimeException("Saraketta ei löydy ID:llä " + columnId);
        }
    }

}
