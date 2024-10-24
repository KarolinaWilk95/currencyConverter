package com.converter;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String wantedCurrency;
        String currencyYouHave;
        BigDecimal amountOfMoney;
        BigDecimal finalAmount = null;
        String quit = "";


        try (Scanner scanner = new Scanner(System.in)) {
            while (!quit.equals("Q")) {
                System.out.println("Welcome in your handy currency converter!");
                System.out.println("What currency you have?");
                currencyYouHave = scanner.nextLine().trim();
                System.out.println("What currency would you like to exchange for?");
                wantedCurrency = scanner.nextLine().trim();
                System.out.println("How much money would you like to exchange?");
                amountOfMoney = new BigDecimal(scanner.nextLine().trim());
                try {
                    finalAmount = Currency.convert(currencyYouHave, amountOfMoney, wantedCurrency);
                    System.out.println(finalAmount);
                } catch (IllegalArgumentException e) {
                    System.out.println("You choose wrong currency");
                } catch (Exception e) {
                    System.out.println("Unknown error");
                }
                System.out.println("If you want to quit type Q, however if you want to repeat actions type anything else");
                quit = scanner.nextLine();
            }
        }
    }
}