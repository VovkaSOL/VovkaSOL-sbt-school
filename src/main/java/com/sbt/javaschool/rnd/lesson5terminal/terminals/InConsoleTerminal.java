package com.sbt.javaschool.rnd.lesson5terminal.terminals;

import com.sbt.javaschool.rnd.lesson5terminal.pin.PinBaseValidator;
import com.sbt.javaschool.rnd.lesson5terminal.servers.SberServerApi;

import java.util.Scanner;

public class InConsoleTerminal implements Terminal {
    private SberServerApi server=null;
    private Integer UserId = 0;
    public InConsoleTerminal(Integer UserId, SberServerApi serverApi){
        server=serverApi;
        this.UserId=UserId;
        this.startParallelTerminalThread();
    }

    @Override
    public String readPinCode() {
            Scanner scanner=new Scanner(System.in);
            String Pin=scanner.nextLine();
            return Pin;
    }

    // реализуем интерфейс Terminal в зависимости от выбранного терминала доступа к серверу
    @Override
    public void showStartScreen() {//начало работы с клиентом
        System.out.println("Hi, this is console terminal");
        System.out.println("Please, input your PIN code: ");
    }

    // реализуем интерфейс Terminal в зависимости от выбранного терминала доступа к серверу
    @Override
    public TerminalState showLogicScreen() {//меню операций
        System.out.println("Меню выбора операций, введите цифру");
        System.out.println("1 - Узнать баланс");
        System.out.println("2 - Снять деньги");
        System.out.println("3 - Внести деньги");
        Scanner scanner=new Scanner(System.in);
        int num=scanner.nextInt();
        TerminalState state=TerminalState.NOAUTHORIZED;
        if(num==1) state=TerminalState.SHOWBALANCE;
        if(num==2) state=TerminalState.GETMONEY;
        if(num==3) state=TerminalState.INSERTMONEY;
        return state;
    }

    @Override
    public void showUserWarning(String text) {
        System.out.println(text);
    }

    @Override
    public SberServerApi getServer() {
        return server;
    }

    @Override
    public Long getUserId() {
        return 1234578910L;
    }


}
