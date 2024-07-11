package main.java.ru.clevertec.check.service;

import main.java.ru.clevertec.check.beans.Check;
import main.java.ru.clevertec.check.beans.Product;

import java.util.List;

public interface CheckServiceInt {
    public void saveCheck(Check check);

    public void makeCheck(String[] args) throws Exception;

    public double defineBalanceDebitCard(String[] args);

    public double calculateTotalPrice(List<Product> checkProducts);

    public double calculateTotalDiscount(List<Product> checkProducts);

    public double calculateTotalWithDiscount(double totalPrice, double totalDiscount);
}
