package main.java.ru.clevertec.check;

import main.java.ru.clevertec.check.controller.Controller;
import main.java.ru.clevertec.check.controller.impl.CheckController;
import main.java.ru.clevertec.check.service.impl.CheckService;

public class CheckRunner {
    public static void main(String[] args) throws Exception {
        Controller controller = new CheckController();

        String arguments = "1-5 2-1 discountCard=1111 balanceDebitCard=1000";

        String request = "printCheck";
        String vansWork = controller.doAction("printCheck" + " " + arguments);
    }
}
