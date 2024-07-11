package main.java.ru.clevertec.check.beans;

import java.util.Objects;

public class DiscountCard {
    private int discountCardId;
    private int discountCardNum;
    private double discountPercentage;

    public DiscountCard() {
    }

    public int getDiscountCardId() {
        return discountCardId;
    }

    public void setDiscountCardId(int discountCardId) {
        this.discountCardId = discountCardId;
    }

    public int getDiscountCardNum() {
        return discountCardNum;
    }

    public void setDiscountCardNum(int discountCardNum) {
        this.discountCardNum = discountCardNum;
    }

    public double getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DiscountCard that = (DiscountCard) o;
        return discountCardId == that.discountCardId && discountCardNum == that.discountCardNum && Double.compare(that.discountPercentage, discountPercentage) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(discountCardId, discountCardNum, discountPercentage);
    }

    @Override
    public String toString() {
        return "DiscountCard{" +
                "discountCardId=" + discountCardId +
                ", discountCardNum=" + discountCardNum +
                ", discountPercentage=" + discountPercentage +
                '}';
    }
}
