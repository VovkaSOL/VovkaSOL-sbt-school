package com.sbt.javaschool.rnd.lesson5terminal.terminals;

import com.sbt.javaschool.rnd.lesson5terminal.servers.SberServerApi;

public class OutdoorTerminal implements Terminal {

    @Override
    public String readPinCode() {
        return null;
    }

    @Override
    public void showStartScreen() {

    }

    @Override
    public TerminalState showLogicScreen() {
        return null;
    }

    @Override
    public void showUserMessage(String text) {

    }

    @Override
    public int InputCashCnt() {
        return 0;
    }

    @Override
    public SberServerApi getServer() {
        return null;
    }

    @Override
    public Long getUserId() {
        return null;
    }
}
