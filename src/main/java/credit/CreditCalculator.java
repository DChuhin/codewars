package main.java.credit;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.stream.Stream;

public class CreditCalculator {

  private static class CreditSummary {
    Payment[] payments;
    double creditAmount;
    double totalPaymentAmount;

    public void setPayments(Payment[] payments) {
      this.payments = payments;
    }

    public void setCreditAmount(double creditAmount) {
      this.creditAmount = creditAmount;
    }

    public void setTotalPaymentAmount(double totalPaymentAmount) {
      this.totalPaymentAmount = totalPaymentAmount;
    }

    @Override
    public String toString() {
      return "CreditSummary{" +
          "\npayments=" + Arrays.toString(payments) +
          ", \ncreditAmount=" + creditAmount +
          ", \ntotalPaymentAmount=" + totalPaymentAmount +
          ", \noverpay=" + (totalPaymentAmount - creditAmount) +
          ", \noverpayPercent=" + (totalPaymentAmount - creditAmount) / creditAmount +
          '}';
    }
  }

  private static class Payment {
    LocalDate date;
    double amount;

    public Payment(LocalDate date, double amount) {
      this.date = date;
      this.amount = amount;
    }

    @Override
    public String toString() {
      return date.format(DateTimeFormatter.ISO_DATE) + " : " + amount;
    }

    public LocalDate getDate() {
      return date;
    }

    public double getAmount() {
      return amount;
    }
  }

  public static CreditSummary calculate(double creditAmount, LocalDate start, int months, double rate) {
    Payment[] payments = new Payment[months];
    double bodyFee = creditAmount / months;
    double creditBalance = creditAmount;
    LocalDate startPeriod = start;
    for (int i = 0; i < months; i++) {
      LocalDate endPeriod = startPeriod.plusMonths(1);
      long daysInPeriod = ChronoUnit.DAYS.between(startPeriod, endPeriod);
      double periodFee = creditBalance * rate / 365 * daysInPeriod;
      payments[i] = new Payment(startPeriod, bodyFee + periodFee);
      startPeriod = endPeriod;
      creditBalance -= bodyFee;
    }
    CreditSummary summary = new CreditSummary();
    summary.setPayments(payments);
    summary.setCreditAmount(creditAmount);
    summary.setTotalPaymentAmount(Stream.of(payments).mapToDouble(Payment::getAmount).sum());
    return summary;
  }

  public static void main(String[] args) {
    System.out.println(calculate(70000, LocalDate.now().plusMonths(1), 24, 0.1232));
  }
}
