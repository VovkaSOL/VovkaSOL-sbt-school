package com.sbt.javaschool.rnd.lesson5terminal.terminals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TerminalTest {
    Terminal terminal = new OutdoorTerminal();

    @Test
    void testRun() {
        terminal.run();
    }

    @Test
    void testStartParallelTerminalThread() {
        terminal.startParallelTerminalThread();
    }

    @Test
    void testAuthentification() {
        Terminal.TerminalState result = terminal.Authentification();
        //Assertions.assertEquals(new OutdoorTerminal().com.sbt.javaschool.rnd.lesson5terminal.terminals.Terminal.TerminalState.NOAUTHORIZED, result);
    }

    @Test
    void testGetMoney() {
        Terminal.TerminalState result = terminal.getMoney(Integer.valueOf(0));
        //Assertions.assertEquals(new OutdoorTerminal().com.sbt.javaschool.rnd.lesson5terminal.terminals.Terminal.TerminalState.NOAUTHORIZED, result);
    }

    @Test
    void testInsertMoney() {
        terminal.insertMoney(Integer.valueOf(0));
    }

    @Test
    void testGetMD5() {
        String result = terminal.getMD5("plaintext");
        Assertions.assertEquals("replaceMeWithExpectedResult", result);
    }

    @Test
    void testValidateUserPinInput() {
    //    terminal.validateUserPinInput("pin");
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme