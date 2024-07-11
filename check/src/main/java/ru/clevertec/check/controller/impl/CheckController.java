package main.java.ru.clevertec.check.controller.impl;

import main.java.ru.clevertec.check.controller.Command;
import main.java.ru.clevertec.check.controller.CommandProvider;
import main.java.ru.clevertec.check.controller.Controller;

public class CheckController implements Controller {
    @Override
    public String doAction(String request) throws Exception {
        String[] requestParts;
        requestParts = request.split(" ");
        String commandName = requestParts[0];

        CommandProvider commandProvider = new CommandProvider();
        Command command = commandProvider.getCommand(commandName);

        return command.execute(requestParts);
    }
}
