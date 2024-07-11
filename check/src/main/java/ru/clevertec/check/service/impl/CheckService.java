package main.java.ru.clevertec.check.service.impl;

import main.java.ru.clevertec.check.beans.Check;
import main.java.ru.clevertec.check.beans.Product;
import main.java.ru.clevertec.check.beans.builder.CheckBuilder;
import main.java.ru.clevertec.check.dao.impl.CheckDAO;
import main.java.ru.clevertec.check.dao.DAOProvider;
import main.java.ru.clevertec.check.service.CheckServiceInt;

import java.util.List;

public class CheckService implements CheckServiceInt {
    DAOProvider daoProvider = DAOProvider.getDaoProvider();
    CheckDAO checkDAO = daoProvider.getCheckDAO();
    ProductService productService = new ProductService();
    DiscountService discountService = new DiscountService();

    public void saveCheck(Check check) {
        checkDAO.saveCheck(check);
        System.out.println("Check saved");
    }

    public void makeCheck(String[] args) throws Exception {
        Check check = new Check();
        check.setProductList(productService.makeCheckProductList(args));
        check.setDiscountCard(discountService.defineDiscountCard(args));
        check.setProductList(productService.calculateDiscount(check.getProductList(), check.getDiscountCard()));
        check.setBalanceDebitCard(defineBalanceDebitCard(args));
        check.setTotalPrice(calculateTotalPrice(check.getProductList()));
        check.setTotalDiscount(calculateTotalDiscount(check.getProductList()));
        check.setTotalWithDiscount(calculateTotalWithDiscount(check.getTotalPrice(), check.getTotalDiscount()));

        if(check.getBalanceDebitCard() < check.getTotalWithDiscount()){
            throw new Exception("ERROR" + "\n" + "NOT ENOUGH MONEY");
        }
        saveCheck(check);
    }

    public double defineBalanceDebitCard(String[] args) {
        double balance = 0;
        for (String arg : args) {
            if (arg.contains("discountCard=")) {
                // Обработка аргумента discountCard=xxxx
                balance = Double.valueOf(arg.split("=")[1]);
            }
        }
        return balance;
    }

    public double calculateTotalPrice(List<Product> checkProducts){
        double totalPrice = 0.0;
        for (Product product : checkProducts) {
            totalPrice += product.getPrice();
        }
        return totalPrice;
    }

    public double calculateTotalDiscount(List<Product> checkProducts){
        double totalDiscount = 0.0;
        for (Product product : checkProducts) {
            totalDiscount += product.getDiscount();
        }
        return totalDiscount;
    }

    public double calculateTotalWithDiscount(double totalPrice, double totalDiscount){
        return totalPrice - totalDiscount;
    }
}
