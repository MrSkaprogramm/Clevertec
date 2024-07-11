package main.java.ru.clevertec.check.service;

import main.java.ru.clevertec.check.service.impl.CheckService;
import main.java.ru.clevertec.check.service.impl.DiscountService;
import main.java.ru.clevertec.check.service.impl.ProductService;

public class ServiceProvider {
    private static final ServiceProvider serviceProvider = new ServiceProvider();

    private CheckService checkService = new CheckService();
    private DiscountService discountService = new DiscountService();
    private ProductService productService = new ProductService();

    public ServiceProvider() {
    }

    public CheckService getCheckService() {
        return checkService;
    }

    public void setCheckService(CheckService checkService) {
        this.checkService = checkService;
    }

    public DiscountService getDiscountService() {
        return discountService;
    }

    public void setDiscountService(DiscountService discountService) {
        this.discountService = discountService;
    }

    public ProductService getProductService() {
        return productService;
    }

    public void setProductService(ProductService productService) {
        this.productService = productService;
    }
}
