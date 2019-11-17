package com.sbt.javaschool.rnd.lesson5terminal.terminals;


// я бы сделал Terminal не интерфейсом, а абстрактным классом, чтобы защитить методы от переопределения,
// но в задании указано реализовать интерфейс Terminal, так что пишем интерфейс
// дефолтной с логикой в дефолтных методах интерфейса

import com.sbt.javaschool.rnd.lesson5terminal.pin.PinBaseValidator;
import com.sbt.javaschool.rnd.lesson5terminal.sberexceptions.*;
import com.sbt.javaschool.rnd.lesson5terminal.servers.SberServerApi;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public interface Terminal extends Runnable, PinBaseValidator {
    enum TerminalState { NOAUTHORIZED, AUTHORIZED, SHOWBALANCE, GETMONEY, INSERTMONEY, CLOSECONNECTION }
    @Override
    public default void run()//это основной общий обработчик логики всех терминалов, запускается в отдельном потоке
    {
        TerminalState state=TerminalState.NOAUTHORIZED;
        while(state!=TerminalState.CLOSECONNECTION) { //100 сделаем кодом окончания работы с терминалом
            switch (state) {
                case NOAUTHORIZED:
                    state=Authentification();
                    break;
                case AUTHORIZED:
                    state = showLogicScreen();
                    break;
                case SHOWBALANCE:
                    Double bal=getServer().getUserBalance(getServer().getToken());
                    showUserMessage("Ваш баланс = "+bal.toString());
                    state=TerminalState.AUTHORIZED;
                    break;
                case GETMONEY:
                    showUserMessage("Введите сумму");
                    Integer cash=InputCashCnt();
                    getMoney(cash);
                    state=TerminalState.AUTHORIZED;
                    break;
                case INSERTMONEY:
                    showUserMessage("Внесите Ваши купюры");
                    Integer cashIn=InputCashCnt();
                    insertMoney(cashIn);
                    state=TerminalState.AUTHORIZED;
                    break;
                case CLOSECONNECTION:
                    break;
            }

            Thread.yield();
        }
        showUserMessage("Сеанс окончен");
    }
    public default void startParallelTerminalThread()
    {
        Thread t = new Thread(this);
        t.start();
    }
    public default TerminalState Authentification(){

        showStartScreen();
        String readPin = readPinCode();
        //валидация на криворукость
        try {
            this.validateUserPinInput(readPin);
        } catch (UserPinInputException e) {
            showUserMessage(e.getMessage());
            return TerminalState.NOAUTHORIZED;
        }
        //аутентификация на сервере
        try{
            getServer().validateUserPinOnServer(getUserId(),getMD5(readPin));
        }
        catch (PinValidationOnServerException e){//ошибка ввода пина
            showUserMessage(e.getMessage());
            return TerminalState.NOAUTHORIZED;
        }
        catch (AccountIsLockedException e){//аккаунт заблокирован
            showUserMessage(e.getMessage());
            return TerminalState.NOAUTHORIZED;
        }
        //если ничего не выбросило до этого момента, значит авторизация прошла успешно
        return TerminalState.AUTHORIZED;//права на работу со счетом предоставлены

    }

    public default TerminalState getMoney(Integer cash){
        try{
            getServer().getCashFromServerToUser(getServer().getToken(),cash);
        } catch (NotEnoughMoneyException e) {
            showUserMessage("Недостаточно денег на Вашем счету");
            return TerminalState.AUTHORIZED;
        } catch (ConnectionProblemException e) {
            showUserMessage("Возникли проблемы с сетью");
            return TerminalState.AUTHORIZED;
        }
        showUserMessage("Ожидайте выдачи денег из Вашего ноутбука :-)");
        return TerminalState.AUTHORIZED;
    }

    public default void insertMoney(Integer cash){
        try{
            getServer().receiveCashFromUserToServer(getServer().getToken(),cash);
        } catch (InsertMoneyException e) {
            showUserMessage("Ошибка при вводе денег");
        } catch (ConnectionProblemException e) {
            showUserMessage("Возникли проблемы с сетью");
        }
        showUserMessage("Ваш баланс успешно пополнен");
    }

    public String readPinCode();//реализация будет зависеть от выбранного терминала
    public void showStartScreen();//реализация будет зависеть от выбранного терминала
    public TerminalState showLogicScreen();//реализация будет зависеть от выбранного терминала
    public void showUserMessage(String text);//реализация будет зависеть от выбранного терминала
    public int InputCashCnt();//запросить у пользователя ввести сумму на снятие или пополнение
    SberServerApi getServer();
    Long getUserId();

    public default String getMD5(String plaintext){
        try {
            MessageDigest m = MessageDigest.getInstance("MD5");
            m.reset();
            m.update(plaintext.getBytes());
            byte[] digest = m.digest();
            BigInteger bigInt = new BigInteger(1, digest);
            String hashtext = bigInt.toString(16);
            // Now we need to zero pad it if you actually want the full 32 chars.
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        }
        catch(NoSuchAlgorithmException e){
            System.out.println("Problem with md5");
        }
        return "";
    }
}
