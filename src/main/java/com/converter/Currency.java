package com.converter;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;

public class Currency {

    private static final Map<String, BigDecimal> CURRENCIES = Map.ofEntries(
            Map.entry("THB", new BigDecimal("0.1190")),
            Map.entry("USD", new BigDecimal("3.9862")),
            Map.entry("AUD", new BigDecimal("2.6624")),
            Map.entry("HKD", new BigDecimal("0.5128")),
            Map.entry("CAD", new BigDecimal("2.8814")),
            Map.entry("NZD", new BigDecimal("2.4119")),
            Map.entry("SGD", new BigDecimal("3.0309")),
            Map.entry("EUR", new BigDecimal("4.3159")),
            Map.entry("HUF", new BigDecimal("1.0767").divide(BigDecimal.valueOf(100), 12, RoundingMode.HALF_EVEN)),
            Map.entry("CHF", new BigDecimal("4.6063")),
            Map.entry("GBP", new BigDecimal("5.1777")),
            Map.entry("UAH", new BigDecimal("0.0964")),
            Map.entry("JPY", new BigDecimal("2.6400").divide(BigDecimal.valueOf(100), 12, RoundingMode.HALF_EVEN)),
            Map.entry("CZK", new BigDecimal("0.1708")),
            Map.entry("DKK", new BigDecimal("0.5787")),
            Map.entry("ISK", new BigDecimal("2.8946").divide(BigDecimal.valueOf(100), 12, RoundingMode.HALF_EVEN)),
            Map.entry("NOK", new BigDecimal("0.3645")),
            Map.entry("SEK", new BigDecimal("0.3782")),
            Map.entry("RON", new BigDecimal("0.8678")),
            Map.entry("BGN", new BigDecimal("2.2067")),
            Map.entry("TRY", new BigDecimal("0.1162")),
            Map.entry("ILS", new BigDecimal("1.0540")),
            Map.entry("CLP", new BigDecimal("0.4181").divide(BigDecimal.valueOf(100), 12, RoundingMode.HALF_EVEN)),
            Map.entry("PHP", new BigDecimal("0.0689")),
            Map.entry("MXN", new BigDecimal("0.2003")),
            Map.entry("ZAR", new BigDecimal("0.2270")),
            Map.entry("BRL", new BigDecimal("0.7007")),
            Map.entry("MYR", new BigDecimal("0.9219")),
            Map.entry("IDR", new BigDecimal("2.5618").divide(BigDecimal.valueOf(10000), 12, RoundingMode.HALF_EVEN)),
            Map.entry("INR", new BigDecimal("4.7413").divide(BigDecimal.valueOf(100), 12, RoundingMode.HALF_EVEN)),
            Map.entry("KRW", new BigDecimal("0.2893").divide(BigDecimal.valueOf(100), 12, RoundingMode.HALF_EVEN)),
            Map.entry("CNY", new BigDecimal("0.5598")),
            Map.entry("XDR", new BigDecimal("5.3006")),
            Map.entry("PLN", new BigDecimal("1"))
    );


    static BigDecimal convert(String currencyYouHave, BigDecimal amountOfMoney, String wantedCurrency) {
        BigDecimal finalAmount;
//RoundingMode.HALF_EVEN
        var currencyYouHaveValueMap = CURRENCIES.get(currencyYouHave.toUpperCase());
        var wantedCurrencyValueMap = CURRENCIES.get(wantedCurrency.toUpperCase());

        if (!CURRENCIES.containsKey(currencyYouHave.toUpperCase()) || !CURRENCIES.containsKey(wantedCurrency.toUpperCase())) {
            throw new IllegalArgumentException();
        }

        if (currencyYouHave.equals("PLN")) {
            finalAmount = amountOfMoney.divide(wantedCurrencyValueMap, RoundingMode.HALF_EVEN);
        } else {
            finalAmount = amountOfMoney.multiply(currencyYouHaveValueMap).divide(wantedCurrencyValueMap, RoundingMode.HALF_EVEN);
        }
        return finalAmount.setScale(2, RoundingMode.HALF_EVEN);
    }
}
