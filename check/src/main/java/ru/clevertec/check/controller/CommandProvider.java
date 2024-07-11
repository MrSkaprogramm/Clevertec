package main.java.ru.clevertec.check.controller;

import main.java.ru.clevertec.check.controller.impl.PrintCheckCommand;

import java.util.HashMap;
import java.util.Map;

public class CommandProvider {
    private Map<String, Command> commands = new HashMap<String, Command>();

    public CommandProvider() {
        commands.put("printCheck", new PrintCheckCommand());
    }

    public Command getCommand(String commandName) {
        Command command = commands.get(commandName);

        return command;
    }
}
