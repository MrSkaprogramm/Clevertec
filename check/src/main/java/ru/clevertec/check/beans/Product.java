package main.java.ru.clevertec.check.beans;

import java.util.Objects;

public class Product {
    private int idProduct;
    private String description;
    private double price;
    private int quantityProduct;
    private boolean wholesaleProduct;
    private double total;
    private double discount;

    public Product() {
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantityProduct() {
        return quantityProduct;
    }

    public void setQuantityProduct(int quantityProduct) {
        this.quantityProduct = quantityProduct;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isWholesaleProduct() {
        return wholesaleProduct;
    }

    public void setWholesaleProduct(boolean wholesaleProduct) {
        this.wholesaleProduct = wholesaleProduct;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return idProduct == product.idProduct && Double.compare(product.price, price) == 0 && quantityProduct == product.quantityProduct && wholesaleProduct == product.wholesaleProduct && Double.compare(product.total, total) == 0 && Double.compare(product.discount, discount) == 0 && Objects.equals(description, product.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProduct, description, price, quantityProduct, wholesaleProduct, total, discount);
    }

    @Override
    public String toString() {
        return "Product{" +
                "idProduct=" + idProduct +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", quantityProduct=" + quantityProduct +
                ", wholesaleProduct=" + wholesaleProduct +
                ", total=" + total +
                ", discount=" + discount +
                '}';
    }
}
