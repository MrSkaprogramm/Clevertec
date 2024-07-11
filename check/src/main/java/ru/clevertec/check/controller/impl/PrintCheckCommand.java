package main.java.ru.clevertec.check.controller.impl;

import main.java.ru.clevertec.check.controller.Command;
import main.java.ru.clevertec.check.service.impl.CheckService;

public class PrintCheckCommand implements Command {
    @Override
    public String execute(String[] args) throws Exception {
        if (args.length < 3) {
            throw new Exception("ERROR" + "\n" + "BAD REQUEST");
        }

        CheckService checkService = new CheckService();
        checkService.makeCheck(args);
        return null;
    }
}
