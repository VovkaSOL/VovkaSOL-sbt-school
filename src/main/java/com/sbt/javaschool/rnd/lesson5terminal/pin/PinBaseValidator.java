package com.sbt.javaschool.rnd.lesson5terminal.pin;

import com.sbt.javaschool.rnd.lesson5terminal.sberexceptions.AccountIsLockedException;
import com.sbt.javaschool.rnd.lesson5terminal.sberexceptions.UserPinInputException;

public interface PinBaseValidator {
    //базовый валидатор проверяет условия (PIN- digit, len(PIN)= 4 digits)
    public default  void validateUserPinInput(String pin) throws UserPinInputException {
       if(pin.length()!=4) throw new UserPinInputException();
       int pd=0;
       try {
           pd = new Integer(pin);
       }
       catch(Exception e){// не получилось привести строку к числу
           throw new UserPinInputException();
       }
    };
}
