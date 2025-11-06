package com.neotox.currencyconverter.repository;

import com.neotox.currencyconverter.model.ConversionHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConversionHistoryRepository extends JpaRepository<ConversionHistory, Long> {
}