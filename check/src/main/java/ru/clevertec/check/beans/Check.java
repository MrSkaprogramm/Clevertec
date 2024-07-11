package main.java.ru.clevertec.check.beans;

import java.util.List;
import java.util.Objects;

public class Check {
    private List<Product> productList;
    private DiscountCard discountCard;
    double balanceDebitCard;
    private double totalPrice;
    private double totalDiscount;
    private double totalWithDiscount;

    public Check() {
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public DiscountCard getDiscountCard() {
        return discountCard;
    }

    public void setDiscountCard(DiscountCard discountCard) {
        this.discountCard = discountCard;
    }

    public double getBalanceDebitCard() {
        return balanceDebitCard;
    }

    public void setBalanceDebitCard(double balanceDebitCard) {
        this.balanceDebitCard = balanceDebitCard;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public double getTotalDiscount() {
        return totalDiscount;
    }

    public void setTotalDiscount(double totalDiscount) {
        this.totalDiscount = totalDiscount;
    }

    public double getTotalWithDiscount() {
        return totalWithDiscount;
    }

    public void setTotalWithDiscount(double totalWithDiscount) {
        this.totalWithDiscount = totalWithDiscount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Check check = (Check) o;
        return Double.compare(check.balanceDebitCard, balanceDebitCard) == 0 && Double.compare(check.totalPrice, totalPrice) == 0 && Double.compare(check.totalDiscount, totalDiscount) == 0 && Double.compare(check.totalWithDiscount, totalWithDiscount) == 0 && Objects.equals(productList, check.productList) && Objects.equals(discountCard, check.discountCard);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productList, discountCard, balanceDebitCard, totalPrice, totalDiscount, totalWithDiscount);
    }

    @Override
    public String toString() {
        return "Check{" +
                "productList=" + productList +
                ", discountCard=" + discountCard +
                ", balanceDebitCard=" + balanceDebitCard +
                ", totalPrice=" + totalPrice +
                ", totalDiscount=" + totalDiscount +
                ", totalWithDiscount=" + totalWithDiscount +
                '}';
    }
}
