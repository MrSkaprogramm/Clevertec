package main.java.ru.clevertec.check.dao.impl;

import main.java.ru.clevertec.check.dao.DiscountDAOInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class DiscountDAO implements DiscountDAOInt {
    public static final String DISCOUNT_CARDS_FILE_PATH = "./src/main/resources/discount cards.csv";

    public List<String> readDiscountCardInfo() {
        List<String> discountCardList = new ArrayList();
        try (BufferedReader br = Files.newBufferedReader(Paths.get(DISCOUNT_CARDS_FILE_PATH))){

            String str = "";
            StringBuilder stringBuilder = new StringBuilder();

            //reading file line by line

            while((str = br.readLine()) != null){

                StringTokenizer tokenizer = new StringTokenizer(str, ","); // for csv file data comm(,) is delimeter

                while (tokenizer.hasMoreElements()) {
                    discountCardList.add(tokenizer.nextElement().toString());
                }
            }

        }catch (IOException ex) {
            System.out.println("INTERNAL SERVER ERROR");
            ex.printStackTrace();
        }

        return discountCardList;
    }
}
