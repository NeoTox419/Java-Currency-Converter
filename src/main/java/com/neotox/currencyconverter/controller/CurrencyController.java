package com.neotox.currencyconverter.controller;

import com.neotox.currencyconverter.model.ConversionHistory;
import com.neotox.currencyconverter.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.List;


@RestController
@RequestMapping("/api/currency")
public class CurrencyController {

    @Autowired
    private CurrencyService currencyService;

    @GetMapping("/convert")
    public Map<String, Object> convertCurrency(
            @RequestParam String from,
            @RequestParam String to,
            @RequestParam double amount
    ) {
        return currencyService.convert(from, to, amount);
    }

    @GetMapping("/history")
    public List<ConversionHistory> getHistory(){
        return currencyService.getAllHistory();
    }
}
