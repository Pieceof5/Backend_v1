package com.moniala.dynamic_table.repository;

import com.moniala.dynamic_table.model.Column;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ColumnRepository extends JpaRepository<Column, Long> {

    // Hakee kaikki sarakkeet tietylle kortille
    List<Column> findByCardId(Long cardId);
}