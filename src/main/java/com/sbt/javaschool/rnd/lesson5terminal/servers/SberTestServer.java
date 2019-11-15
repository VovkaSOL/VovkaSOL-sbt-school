package com.sbt.javaschool.rnd.lesson5terminal.servers;

import com.sbt.javaschool.rnd.lesson5terminal.sberexceptions.AccountIsLockedException;
import com.sbt.javaschool.rnd.lesson5terminal.sberexceptions.PinValidationOnServerException;

public class SberTestServer implements SberServerApi {
    Double testBalance=1000.0;
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
    public Boolean getCashFromServerToUser(String Token, Double cash) {
        if(testBalance>cash){
            testBalance-=cash;
            return true;
        }
        return false;
    }

    @Override
    public void receiveCashFromUserToServer(String Token, Double cash) {
            testBalance+=cash;
       }

    @Override
    public String getToken() {
        return this.serverToken;
    }
}
