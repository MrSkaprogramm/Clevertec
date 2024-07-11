package main.java.ru.clevertec.check.beans.builder;

import main.java.ru.clevertec.check.beans.DiscountCard;

public class DiscountCardBuilder {
    private DiscountCard discountCard = new DiscountCard();

    public void setDiscountCardId(int discountCardId) {
        discountCard.setDiscountCardId(discountCardId);
    }

    public void setDiscountCardNum(int discountCardNum) {
        discountCard.setDiscountCardNum(discountCardNum);
    }

    public void setDiscountPercentage(double discountPercentage) {
        discountCard.setDiscountPercentage(discountPercentage);
    }

    public DiscountCard build() {
        return discountCard;
    }
}
