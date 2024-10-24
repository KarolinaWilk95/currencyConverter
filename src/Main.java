import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome in your handy currency converter from foreign currency to PLN!");
        System.out.println("What currency would you like to exchange for?");
        String wantedCurrency = scanner.nextLine();
        System.out.println("How much money would you like to exchange:");
        BigDecimal amountOfMoney = scanner.nextBigDecimal();
        BigDecimal finalAmount = null;

        switch (wantedCurrency) {
            case "EUR":
                finalAmount = amountOfMoney.multiply(new BigDecimal("4.3159"));
                break;
            case "USD":
                finalAmount = amountOfMoney.multiply(new BigDecimal("3.9862"));
                break;
            case "CHF":
                finalAmount = amountOfMoney.multiply(new BigDecimal("4.6063"));
                break;
            case "JPY":
                finalAmount = (amountOfMoney.multiply(new BigDecimal("2.6400"))).divide(new BigDecimal(100));
                break;
            default:
                System.out.println("You choose currency out of range");
        }

        System.out.println(finalAmount.setScale(2, RoundingMode.HALF_EVEN) + " PLN");
        scanner.close();

    }
}