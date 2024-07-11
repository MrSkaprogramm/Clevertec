package main.java.ru.clevertec.check.controller;

public interface Command {
    public String execute(String[] requestParts) throws Exception;
}
