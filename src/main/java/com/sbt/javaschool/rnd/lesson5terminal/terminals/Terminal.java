package com.sbt.javaschool.rnd.lesson5terminal.terminals;

// я бы сделал Terminal не интерфейсом, а абстрактным классом, чтобы защитить методы от переопределения,
// но в задании указано реализовать интерфейс Terminal, так что пишем интерфейс

import com.sbt.javaschool.rnd.lesson5terminal.pin.PinBaseValidator;
import com.sbt.javaschool.rnd.lesson5terminal.sberexceptions.AccountIsLockedException;
import com.sbt.javaschool.rnd.lesson5terminal.sberexceptions.PinValidationOnServerException;
import com.sbt.javaschool.rnd.lesson5terminal.sberexceptions.UserPinInputException;
import com.sbt.javaschool.rnd.lesson5terminal.servers.SberServerApi;
import sun.plugin2.message.GetAppletMessage;

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
                    state=TerminalState.AUTHORIZED;
                    break;
            }
            Thread.yield();
        }
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
            showUserWarning(e.getMessage());
            return TerminalState.NOAUTHORIZED;
        }
        //аутентификация на сервере
        try{
            getServer().validateUserPinOnServer(getUserId(),getMD5(readPin));
        }
        catch (PinValidationOnServerException e){//ошибка ввода пина
            showUserWarning(e.getMessage());
            return TerminalState.NOAUTHORIZED;
        }
        catch (AccountIsLockedException e){//аккаунт заблокирован
            showUserWarning(e.getMessage());
            return TerminalState.NOAUTHORIZED;
        }
        //если ничего не выбросило до этого момента, значит авторизация прошла успешно
        return TerminalState.AUTHORIZED;//права на работу со счетом предоставлены

    }
    public String readPinCode();//реализация будет зависеть от выбранного терминала
    public void showStartScreen();//реализация будет зависеть от выбранного терминала
    public TerminalState showLogicScreen();//реализация будет зависеть от выбранного терминала
    public void showUserWarning(String text);//реализация будет зависеть от выбранного терминала
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
