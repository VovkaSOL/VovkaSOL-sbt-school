package com.sbt.javaschool.rnd.lesson5terminal.servers;

import com.sbt.javaschool.rnd.lesson5terminal.sberexceptions.*;

public interface SberServerApi {
    //пин отправляется серверу в виде MD5 hash
    Boolean validateUserPinOnServer(Long userId, String MD5HashedPin) throws AccountIsLockedException, PinValidationOnServerException;
    //если пин верный и акк не заблокирован -возвращается Token для сессии, далее раброта по Token

    //получить состояние счёта с сервера по токену
    Double getUserBalance(String Token);

    //запрос на снятие денег со счета на сервере по токену
    Boolean getCashFromServerToUser(String Token, Integer cash) throws NotEnoughMoneyException, ConnectionProblemException;

    //запрос на пополнение денег на счет на сервере по токену
    void receiveCashFromUserToServer(String Token, Integer cash) throws InsertMoneyException, ConnectionProblemException;;

    // getter для полученного токена
    String getToken();
}
