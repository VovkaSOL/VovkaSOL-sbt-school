package com.sbt.javaschool.rnd.lesson5terminal.sberexceptions;

import java.io.IOException;

public class UserPinInputException extends IOException {
    @Override
    public String getMessage() {
        return "Pin code input error";
    }
}
