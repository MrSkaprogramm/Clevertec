package main.java.ru.clevertec.check.dao.impl;

import main.java.ru.clevertec.check.beans.Check;
import main.java.ru.clevertec.check.beans.DiscountCard;
import main.java.ru.clevertec.check.beans.Product;
import main.java.ru.clevertec.check.dao.CheckDAOInt;

import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class CheckDAO implements CheckDAOInt {
    public static final String CHECK_FILE_PATH = "./src/main/resources/result.csv";

    public void saveCheck(Check check) {

        DiscountCard discountCard = check.getDiscountCard();

        List<Product> checkList = check.getProductList();

        StringBuilder stringBuilder = new StringBuilder();

        LocalDateTime currentDateTime = LocalDateTime.now();

        stringBuilder.append("Date").append(",").append("Time").append("\n");

        stringBuilder.append(currentDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))).append(",")
                .append(currentDateTime.format(DateTimeFormatter.ofPattern("HH:mm:ss"))).append(",").append("\n");

        stringBuilder.append("\n");

        stringBuilder.append("QTY").append(",").append("DESCRIPTION").append(",").append("PRICE").append(",")
                .append("DISCOUNT").append(",").append("TOTAL").append("\n");

        for(Product product : checkList){
            stringBuilder.append(product.getQuantityProduct()).append(",")
                    .append(product.getDescription()).append(",")
                    .append(product.getPrice()).append(",")
                    .append(product.getDiscount()).append(",")
                    .append(product.getTotal()).append(",")
                    .append("\n");
        }

        stringBuilder.append("\n");

        stringBuilder.append("DISCOUNT CARD").append(",").append("DISCOUNT PERCENTAGE").append("\n");

        stringBuilder.append(discountCard.getDiscountCardNum()).append(",")
                .append(discountCard.getDiscountPercentage()).append("\n");

        stringBuilder.append("\n");

        stringBuilder.append("TOTAL PRICE").append(",").append("TOTAL DISCOUNT").append(",").append("TOTAL WITH DISCOUNT").append("\n");

        stringBuilder.append(check.getTotalPrice()).append(",").append(check.getTotalDiscount()).append(",").append(check.getTotalWithDiscount());

        System.out.println(stringBuilder.toString());

        try ( FileWriter fileWriter = new FileWriter(CHECK_FILE_PATH) ) {

            fileWriter.write(stringBuilder.toString());

        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
}
