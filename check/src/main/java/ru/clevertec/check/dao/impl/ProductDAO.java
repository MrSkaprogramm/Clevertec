package main.java.ru.clevertec.check.dao.impl;

import main.java.ru.clevertec.check.dao.ProductDAOInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ProductDAO implements ProductDAOInt {
    public static final String PRODUCTS_FILE_PATH = "./src/main/resources/products.csv";

    public List<String> readItemInfo() {
        List<String> productList = new ArrayList();
        try (BufferedReader br = Files.newBufferedReader(Paths.get(PRODUCTS_FILE_PATH))){

            String str = "";
            StringBuilder stringBuilder = new StringBuilder();

            while((str = br.readLine()) != null){

                StringTokenizer tokenizer = new StringTokenizer(str, ","); // for csv file data comm(,) is delimeter

                while (tokenizer.hasMoreElements()) {
                    productList.add(tokenizer.nextElement().toString());
                }
            }

        }catch (IOException ex) {
            System.out.println("INTERNAL SERVER ERROR");
            ex.printStackTrace();
        }

        return productList;
    }
}
