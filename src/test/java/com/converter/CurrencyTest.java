package com.converter;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CurrencyTest {

    @Test
    public void testFromUSDtoEUR() {
        // given
        String currencyYouHave = "USD";
        String currencyYouWant = "EUR";
        BigDecimal amountOfMoney = new BigDecimal("1000");
        BigDecimal usdCurrency = new BigDecimal("3.9862");
        BigDecimal eurCurrency = new BigDecimal("4.3159");

        // when
        var result = Currency.convert(currencyYouHave, amountOfMoney, currencyYouWant);


        // then
        var expectedResult = amountOfMoney.multiply(usdCurrency).divide(eurCurrency, RoundingMode.HALF_EVEN);
        assertThat(result).isEqualByComparingTo(expectedResult.setScale(2, RoundingMode.HALF_EVEN));
    }

    @Test
    public void testFromPLNtoEUR() {
        // given
        String currencyYouHave = "PLN";
        String currencyYouWant = "EUR";
        BigDecimal amountOfMoney = new BigDecimal("1000");
        BigDecimal eurCurrency = new BigDecimal("4.3159");

        // when
        var result = Currency.convert(currencyYouHave, amountOfMoney, currencyYouWant);


        // then
        var expectedResult = amountOfMoney.divide(eurCurrency, RoundingMode.HALF_EVEN);
        assertThat(result).isEqualByComparingTo(expectedResult);
    }

    @Test
    public void testFromPLNtoPLN() {
        // given
        String currencyYouHave = "PLN";
        String currencyYouWant = "PLN";
        BigDecimal amountOfMoney = new BigDecimal("1000");
        BigDecimal plnCurrency = new BigDecimal("1");

        // when
        var result = Currency.convert(currencyYouHave, amountOfMoney, currencyYouWant);


        // then
        var expectedResult = amountOfMoney.divide(plnCurrency, RoundingMode.HALF_EVEN);
        assertThat(result).isEqualByComparingTo(expectedResult);
    }

    @Test
    public void testFromJPYtoEUR() {
        // given
        String currencyYouHave = "JPY";
        String currencyYouWant = "EUR";
        BigDecimal amountOfMoney = new BigDecimal("1000");
        BigDecimal JPYCurrency = new BigDecimal("2.6400").divide(BigDecimal.valueOf(100), RoundingMode.HALF_EVEN);
        BigDecimal eurCurrency = new BigDecimal("4.3159");

        // when
        var result = Currency.convert(currencyYouHave, amountOfMoney, currencyYouWant);

        // then

        var expectedResult = amountOfMoney.multiply(JPYCurrency).divide(eurCurrency, RoundingMode.HALF_EVEN);
        assertThat(result).isEqualByComparingTo(expectedResult.setScale(2, RoundingMode.HALF_EVEN));
    }

    @Test
    public void testFromEURtoINR() {
        // given
        String currencyYouHave = "INR";
        String currencyYouWant = "EUR";
        BigDecimal amountOfMoney = new BigDecimal("1000");
        BigDecimal INRCurrency = new BigDecimal("4.7413").divide(BigDecimal.valueOf(100), 12, RoundingMode.HALF_EVEN);
        BigDecimal eurCurrency = new BigDecimal("4.3159");

        // when
        var result = Currency.convert(currencyYouHave, amountOfMoney, currencyYouWant);

        // then

        var expectedResult = amountOfMoney.multiply(INRCurrency).divide(eurCurrency, RoundingMode.HALF_EVEN);
        assertThat(result).isEqualByComparingTo(expectedResult.setScale(2, RoundingMode.HALF_EVEN));
    }

    @Test
    public void testInvalidInputFirstArgument() {
        // given
        String currencyYouHave = "Irn";
        String currencyYouWant = "EUR";
        BigDecimal amountOfMoney = new BigDecimal("1000");
        BigDecimal INRCurrency = new BigDecimal("4.7413").divide(BigDecimal.valueOf(100), 12, RoundingMode.HALF_EVEN);
        BigDecimal eurCurrency = new BigDecimal("4.3159");
        // when
        Exception exception = assertThrows(IllegalArgumentException.class, () -> Currency.convert(currencyYouHave, amountOfMoney, currencyYouWant));
        // then
        assertEquals(IllegalArgumentException.class, exception.getClass());
    }
    @Test
    public void testInvalidInputSecondArgument() {
        // given
        String currencyYouHave = "EUR";
        String currencyYouWant = "usa";
        BigDecimal amountOfMoney = new BigDecimal("1000");
        BigDecimal INRCurrency = new BigDecimal("4.7413").divide(BigDecimal.valueOf(100), 12, RoundingMode.HALF_EVEN);
        BigDecimal eurCurrency = new BigDecimal("4.3159");
        // when
        Exception exception = assertThrows(IllegalArgumentException.class, () -> Currency.convert(currencyYouHave, amountOfMoney, currencyYouWant));
        // then
        assertEquals(IllegalArgumentException.class, exception.getClass());
    }
    @Test
    public void testInvalidInputAllArguments() {
        // given
        String currencyYouHave = "Er";
        String currencyYouWant = "usa";
        BigDecimal amountOfMoney = new BigDecimal("1000");
        BigDecimal INRCurrency = new BigDecimal("4.7413").divide(BigDecimal.valueOf(100), 12, RoundingMode.HALF_EVEN);
        BigDecimal eurCurrency = new BigDecimal("4.3159");
        // when
        Exception exception = assertThrows(IllegalArgumentException.class, () -> Currency.convert(currencyYouHave, amountOfMoney, currencyYouWant));
        // then
        assertEquals(IllegalArgumentException.class, exception.getClass());
    }
}
