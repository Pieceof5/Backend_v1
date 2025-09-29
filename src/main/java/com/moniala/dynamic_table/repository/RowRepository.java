package com.moniala.dynamic_table.repository;

import com.moniala.dynamic_table.model.Row;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RowRepository extends JpaRepository<Row, Long> {
    List<Row> findByCardId(Long cardId);
}