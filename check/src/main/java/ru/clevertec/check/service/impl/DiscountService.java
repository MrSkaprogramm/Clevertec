package main.java.ru.clevertec.check.service.impl;

import main.java.ru.clevertec.check.beans.DiscountCard;
import main.java.ru.clevertec.check.beans.builder.DiscountCardBuilder;
import main.java.ru.clevertec.check.dao.DAOProvider;
import main.java.ru.clevertec.check.dao.impl.DiscountDAO;

import java.util.List;

public class DiscountService {
    DAOProvider daoProvider = DAOProvider.getDaoProvider();
    DiscountDAO discountDAO = daoProvider.getPaymentDAO();

    public DiscountCard defineDiscountCard(String[] args) {
        String discountCardNum = null;
        Double balanceDebitCard = null;

        for (String arg : args) {
            if (arg.contains("discountCard=")) {
                // Обработка аргумента discountCard=xxxx
                discountCardNum = arg.split("=")[1];
            }
        }

        List<String> discountCardList = discountDAO.readDiscountCardInfo();
        DiscountCard discountCard = null;

        for (int i = 3; i < discountCardList.size(); i += 3) {
            int discountCardId = Integer.parseInt(discountCardList.get(i));
            int discountCardNumber = Integer.parseInt(discountCardList.get(i + 1));
            double discountPercentage = Double.parseDouble(discountCardList.get(i + 2));

            if (String.valueOf(discountCardNumber).equals(discountCardNum)) {
                DiscountCardBuilder discountCardBuilder = new DiscountCardBuilder();
                discountCardBuilder.setDiscountCardId(discountCardId);
                discountCardBuilder.setDiscountCardNum(discountCardNumber);
                discountCardBuilder.setDiscountPercentage(discountPercentage);
                discountCard = discountCardBuilder.build();
            }
        }
        if(discountCard == null) {
            return null;
        }
        return discountCard;
    }
}
