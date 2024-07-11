package main.java.ru.clevertec.check.beans.builder;

import main.java.ru.clevertec.check.beans.Product;

public class ProductBuilder {
    private Product product = new Product();

    public void setIdProduct(int idProduct) {
        product.setIdProduct(idProduct);
    }

    public void setDescription(String description) {
        product.setDescription(description);
    }

    public void setProductQuantity(int quantityProduct) {
        product.setQuantityProduct(quantityProduct);
    }

    public void setPrice(double price) {
        product.setPrice(price);
    }

    public void setWholesaleProduct(boolean wholesaleProduct) {
        product.setWholesaleProduct(wholesaleProduct);
    }

    public void setTotal(double total) {
        product.setTotal(total);
    }

    public void setDiscount(double discount) {
        product.setDiscount(discount);
    }

    public Product build() {
        return product;
    }
}
