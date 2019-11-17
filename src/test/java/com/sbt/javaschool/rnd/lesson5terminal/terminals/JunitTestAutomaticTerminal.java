package com.sbt.javaschool.rnd.lesson5terminal.terminals;

import com.sbt.javaschool.rnd.lesson5terminal.servers.SberServerApi;

import java.util.Scanner;


public class JunitTestAutomaticTerminal implements Terminal {
        public String  EnterPin= "";
        public String LastShowMessage="";
        private SberServerApi server;
        private Integer UserId;
        public JunitTestAutomaticTerminal(Integer UserId, SberServerApi serverApi){
            server=serverApi;
            this.UserId=UserId;
           //this.startParallelTerminalThread();
        }

        @Override
        public String readPinCode() {
            return EnterPin;
        }

        // реализуем интерфейс Terminal в зависимости от выбранного терминала доступа к серверу
        @Override
        public void showStartScreen() {//начало работы с клиентом
            System.out.println("Hi, this is test terminal");
            System.out.println("Please, input your PIN code: ");
        }

        // реализуем интерфейс Terminal в зависимости от выбранного терминала доступа к серверу
        @Override
        public TerminalState showLogicScreen() {//меню операций
            System.out.println("Меню выбора операций, введите цифру");
            System.out.println("1 - Узнать баланс");
            System.out.println("2 - Снять деньги");
            System.out.println("3 - Внести деньги");
            System.out.println("4 - Завершить работу");
            int num=1;
            TerminalState state=TerminalState.NOAUTHORIZED;
            if(num==1) state=TerminalState.SHOWBALANCE;
            if(num==2) state=TerminalState.GETMONEY;
            if(num==3) state=TerminalState.INSERTMONEY;
            if(num==4) state=TerminalState.CLOSECONNECTION;
            return state;
        }

        @Override
        public int InputCashCnt() {
            return 100;
        }

        @Override
        public void showUserMessage(String text) {
            System.out.println(text);
            LastShowMessage=text;
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
