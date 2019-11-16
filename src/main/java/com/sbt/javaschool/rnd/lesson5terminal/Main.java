package com.sbt.javaschool.rnd.lesson5terminal;

import com.sbt.javaschool.rnd.lesson5terminal.pin.PinBaseValidator;
import com.sbt.javaschool.rnd.lesson5terminal.servers.SberTestServer;
import com.sbt.javaschool.rnd.lesson5terminal.terminals.InConsoleTerminal;
import com.sbt.javaschool.rnd.lesson5terminal.terminals.Terminal;

public class Main {
    public static void main(String[] args) {
        //можем подкидывать любой сервер к нашему терминалу
        //для тестов будем подкидывать тестовый сервер
        Terminal st= new InConsoleTerminal(12345, new SberTestServer());
    }
}
