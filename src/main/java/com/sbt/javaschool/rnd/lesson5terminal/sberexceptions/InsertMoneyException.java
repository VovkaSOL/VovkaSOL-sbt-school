package com.sbt.javaschool.rnd.lesson5terminal.sberexceptions;

import java.io.IOException;

public class InsertMoneyException extends IOException {
    @Override
    public String getMessage() {
        return "Money insertion problem";
    }
}
