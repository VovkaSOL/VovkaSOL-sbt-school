package com.sbt.javaschool.rnd.lesson5terminal.sberexceptions;

import java.io.IOException;

public class ConnectionProblemException extends IOException {
    @Override
    public String getMessage() {
        return "Connection with server problem";
    }
}
