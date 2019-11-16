package com.sbt.javaschool.rnd.lesson5terminal.sberexceptions;

import java.io.IOException;

public class YouAreIdiotException  extends IOException {
    @Override
    public String getMessage() {
        return "You are stupid idiot";
    }
}
