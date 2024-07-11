package main.java.ru.clevertec.check.service.impl;

import main.java.ru.clevertec.check.beans.DiscountCard;
import main.java.ru.clevertec.check.beans.Product;
import main.java.ru.clevertec.check.beans.builder.ProductBuilder;
import main.java.ru.clevertec.check.dao.DAOProvider;
import main.java.ru.clevertec.check.dao.impl.ProductDAO;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProductService {
    DAOProvider daoProvider = DAOProvider.getDaoProvider();
    ProductDAO productDAO = daoProvider.getProductDAO();

    public List<Product> makeProductList() {
        List<String> productList = productDAO.readItemInfo();

        List<Product> products = new ArrayList<>();

        // Пропускаем первые 5 строки заголовков
        for (int i = 5; i < productList.size(); i += 5) {
            try {
                ProductBuilder productBuilder = new ProductBuilder();

                productBuilder.setIdProduct(Integer.parseInt(productList.get(i).trim()));
                productBuilder.setDescription(productList.get(i + 1).trim());
                productBuilder.setPrice(Double.valueOf(productList.get(i + 2).trim().replaceAll("\"", "")));
                productBuilder.setProductQuantity(Integer.parseInt(productList.get(i + 3).trim()));
                if (productList.get(i + 4).trim().replaceAll("\"", "").equalsIgnoreCase("+")) {
                    productBuilder.setWholesaleProduct(true);
                } else {
                    productBuilder.setWholesaleProduct(false);
                }

                Product product = productBuilder.build();
                products.add(product);
            } catch (NumberFormatException e) {
            }
        }

        return products;
    }

    //сопоставление продуктов заказа со списком продуктов
    public List<Product> makeCheckProductList(String[] args) {
        Map<Integer, Integer> productOrderMap = countOrderProducts(args);

        List<Product> products = makeProductList();
        List<Product> checkProducts = new ArrayList<>();

        for (Product product : products) {
            int productId = product.getIdProduct();
            if (productOrderMap.keySet().contains(productId)) {
                Product product1 = new Product();
                product1.setIdProduct(productId);
                product1.setDescription(product.getDescription());
                product1.setQuantityProduct(productOrderMap.get(productId));
                product1.setWholesaleProduct(product.isWholesaleProduct());
                product1.setPrice(product.getPrice());
                product1.setTotal(product1.getQuantityProduct()*product1.getPrice());
                checkProducts.add(product1);
            }
        }

        return checkProducts;
    }

    //проверка на совпадение id со списком продуктов
    public boolean defineOrderProducts(Map<Integer, Integer> orderMap) {
        List<Product> productList = makeProductList();
        Set<Integer> productsId = new HashSet<>();

        for(Product product : productList) {
            productsId.add(product.getIdProduct());
        }

        for (int key : orderMap.keySet()) {
            if (!productsId.contains(key)) {
                return false;
            }
        }
        return true;
    }

    public Map<Integer, Integer> countOrderProducts(String[] args) {
        Map<Integer, Integer> idQuantityMap = new HashMap<>();
        String pattern = "^[0-9]+\\-[0-9]+$";
        Pattern r = Pattern.compile(pattern);

        for (String arg : args) {
            Matcher m = r.matcher(arg.trim());

            // Обработка аргумента id-quantity
            if (!m.matches()) {
                continue;
            } else {
                String[] idQuantity = arg.split("-");
                int id = Integer.parseInt(idQuantity[0]);
                int quantity = Integer.parseInt(idQuantity[1]);
                idQuantityMap.put(id, quantity);
                System.out.println(arg);
            }
        }

        Map<Integer, Integer> resultMap = new HashMap<>();

        // Итерация по входной Map
        for (Map.Entry<Integer, Integer> entry : idQuantityMap.entrySet()) {
            Integer key = entry.getKey();
            int value = entry.getValue();

            // Если ключ уже есть в resultMap, то суммируем значения
            if (resultMap.containsKey(key)) {
                int existingValue = resultMap.get(key);
                resultMap.put(key, existingValue + value);
            } else {
                resultMap.put(key, value);
            }
        }

        return resultMap;
    }

    public List<Product> calculateDiscount(List<Product> checkProducts, DiscountCard discountCard){
        double totalPrice = 0.0;
        double totalDiscount = 0.0;

        for (Product product : checkProducts) {
            double productPrice = product.getTotal();
            double discount;
            if (product.isWholesaleProduct() && product.getQuantityProduct() >= 5) {
                discount = productPrice * (10 / 100);
            } else {
                discount = productPrice * (discountCard.getDiscountPercentage() / 100);
            }
            product.setDiscount(discount);
        }
        return checkProducts;
    }
}