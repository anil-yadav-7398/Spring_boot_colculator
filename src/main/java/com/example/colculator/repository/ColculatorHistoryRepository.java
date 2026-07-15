package com.example.colculator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.colculator.entity.ColculatorHistory;

@Repository
public interface ColculatorHistoryRepository extends JpaRepository<ColculatorHistory, Long> {

}
