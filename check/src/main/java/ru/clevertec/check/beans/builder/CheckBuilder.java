package main.java.ru.clevertec.check.beans.builder;

import main.java.ru.clevertec.check.beans.Check;
import main.java.ru.clevertec.check.beans.DiscountCard;
import main.java.ru.clevertec.check.beans.Product;

import java.util.List;

public class CheckBuilder {
    Check check = new Check();

    public void setProductList(List<Product> productList) {
        check.setProductList(productList);
    }

    public void setDiscountCard(DiscountCard discountCard) {
        check.setDiscountCard(discountCard);
    }

    public void setBalanceDebitCard(double balanceDebitCard) {
        check.setBalanceDebitCard(balanceDebitCard);
    }

    public void setTotalPrice(double totalPrice) {
        check.setTotalPrice(totalPrice);
    }

    public void setTotalDiscount(double totalDiscount) {
        check.setTotalDiscount(totalDiscount);
    }

    public void setTotalWithDiscount(double totalWithDiscount) {
        check.setTotalWithDiscount(totalWithDiscount);
    }

    public Check build() {
        return check;
    }
}
