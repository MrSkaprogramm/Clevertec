package main.java.ru.clevertec.check.dao;

import main.java.ru.clevertec.check.dao.impl.CheckDAO;
import main.java.ru.clevertec.check.dao.impl.DiscountDAO;
import main.java.ru.clevertec.check.dao.impl.ProductDAO;

public class DAOProvider {
    private static final DAOProvider daoProvider = new DAOProvider();

    private CheckDAO checkDAO = new CheckDAO();
    private DiscountDAO discountDAO = new DiscountDAO();
    private ProductDAO productDAO = new ProductDAO();

    public DAOProvider() {
    }

    public CheckDAO getCheckDAO() {
        return checkDAO;
    }

    public void setCheckDAO(CheckDAO checkDAO) {
        this.checkDAO = checkDAO;
    }

    public DiscountDAO getPaymentDAO() {
        return discountDAO;
    }

    public void setPaymentDAO(DiscountDAO discountDAO) {
        this.discountDAO = discountDAO;
    }

    public ProductDAO getProductDAO() {
        return productDAO;
    }

    public void setProductDAO(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    public static DAOProvider getDaoProvider() {
        return daoProvider;
    }
}
