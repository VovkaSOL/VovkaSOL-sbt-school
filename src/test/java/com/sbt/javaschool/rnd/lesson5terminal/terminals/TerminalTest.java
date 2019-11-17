package com.sbt.javaschool.rnd.lesson5terminal.terminals;

import com.sbt.javaschool.rnd.lesson5terminal.servers.SberServerApi;
import com.sbt.javaschool.rnd.lesson5terminal.servers.SberTestServer;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class TerminalTest {

    @BeforeAll
    public static void beforeAll() {
        System.out.println("Тестирование интерфейса Terminal.java с дефолтными методами начато");
    }
    @AfterAll
    public static void afterAll() {
        System.out.println("Тестрование Terminal.java завершено");
    }

//
    @Test
    void testAuthentification() {
        SberServerApi s=new JunitTestServer();
        JunitTestAutomaticTerminal st= new JunitTestAutomaticTerminal(12345,s);
        st.EnterPin="12345";
        Terminal.TerminalState state=st.Authentification();
        Assertions.assertEquals(Terminal.TerminalState.NOAUTHORIZED, state);
        //System.out.println("Отказ при валидации неверного пина на устройстве прошёл успешно");
        st.EnterPin="1234";
        state=st.Authentification();
        Assertions.assertEquals(Terminal.TerminalState.AUTHORIZED, state);
        //System.out.println("Валидации корректного пина на устройстве прошла успешно");
        //terminal.run();
    }

    @Test
    void testGetMoney() {
        System.out.println("testGetmMney");
        JunitTestServer server=new JunitTestServer();
        JunitTestAutomaticTerminal testTerminal= new JunitTestAutomaticTerminal(12345,server);
        testTerminal.EnterPin="1234";
        Terminal.TerminalState state=testTerminal.Authentification();
        Assertions.assertEquals(Terminal.TerminalState.AUTHORIZED, state);
        //System.out.println("Валидации корректного пина на устройстве прошла успешно");
        server.testBalance=1000.0;
        testTerminal.getMoney(100);//снимаем 100
        Assertions.assertEquals(900.0,server.testBalance);
        //terminal.run();
    }

    @Test
    void testInsertMoney() {
        System.out.println("testInsertMoney");
        JunitTestServer server=new JunitTestServer();
        JunitTestAutomaticTerminal testTerminal= new JunitTestAutomaticTerminal(12345,server);
        testTerminal.EnterPin="1234";
        Terminal.TerminalState state=testTerminal.Authentification();
        Assertions.assertEquals(Terminal.TerminalState.AUTHORIZED, state);
        //System.out.println("Валидации корректного пина на устройстве прошла успешно");
        server.testBalance=1000.0;
        testTerminal.insertMoney(100);//снимаем 100
        Assertions.assertEquals(1100.0,server.testBalance);
     }
}

