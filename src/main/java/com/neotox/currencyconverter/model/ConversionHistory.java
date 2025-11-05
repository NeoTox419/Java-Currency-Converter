package com.neotox.currencyconverter.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class ConversionHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fromCurrency;
    private String toCurrency;
    private double amount;
    private double convertedAmount;
    private LocalDateTime timestamp;

    public ConversionHistory() {}

    public ConversionHistory(String fromCurrency, String toCurrency, double amount, double convertedAmount) {
        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;
        this.amount = amount;
        this.convertedAmount = convertedAmount;
        this.timestamp = LocalDateTime.now();
    }

    // Getters and Setters
    public Long getId() { return id; }
    public String getFromCurrency() { return fromCurrency; }
    public String getToCurrency() { return toCurrency; }
    public double getAmount() { return amount; }
    public double getConvertedAmount() { return convertedAmount; }
    public LocalDateTime getTimestamp() { return timestamp; }

    public void setId(Long id) { this.id = id; }
    public void setFromCurrency(String fromCurrency) { this.fromCurrency = fromCurrency; }
    public void setToCurrency(String toCurrency) { this.toCurrency = toCurrency; }
    public void setAmount(double amount) { this.amount = amount; }
    public void setConvertedAmount(double convertedAmount) { this.convertedAmount = convertedAmount; }
    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }
}
