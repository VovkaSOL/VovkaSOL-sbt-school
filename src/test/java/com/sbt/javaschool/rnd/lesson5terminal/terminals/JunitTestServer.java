package com.sbt.javaschool.rnd.lesson5terminal.terminals;

import com.sbt.javaschool.rnd.lesson5terminal.sberexceptions.AccountIsLockedException;
import com.sbt.javaschool.rnd.lesson5terminal.sberexceptions.NotEnoughMoneyException;
import com.sbt.javaschool.rnd.lesson5terminal.sberexceptions.PinValidationOnServerException;
import com.sbt.javaschool.rnd.lesson5terminal.servers.SberServerApi;

public class JunitTestServer implements SberServerApi {
    public Double testBalance=1000.0;
    String serverToken="";

    @Override
    public Boolean validateUserPinOnServer
            (Long userId, String MD5HashedPin) throws AccountIsLockedException, PinValidationOnServerException {
        serverToken="this_is_test_token";
        return true;
    }

    @Override
    public Double getUserBalance(String Token) {
        if(Token.equals("this_is_test_token"))
            return testBalance;
        return 0.0;
    }

    @Override
    public Boolean getCashFromServerToUser(String Token, Integer cash) throws NotEnoughMoneyException {
        if(testBalance>cash){
            testBalance-=cash;
            return true;
        }
        else throw new NotEnoughMoneyException();
    }


    @Override
    public void receiveCashFromUserToServer(String Token, Integer cash) {
            testBalance+=cash;
       }

    @Override
    public String getToken() {
        return this.serverToken;
    }
}
