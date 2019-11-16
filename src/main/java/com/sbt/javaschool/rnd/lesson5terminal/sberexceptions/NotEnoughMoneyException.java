package com.sbt.javaschool.rnd.lesson5terminal.sberexceptions;

import java.io.IOException;

public class NotEnoughMoneyException extends IOException {

    @Override
    public String getMessage() {
        return "Not enough money on account";
    }
}

