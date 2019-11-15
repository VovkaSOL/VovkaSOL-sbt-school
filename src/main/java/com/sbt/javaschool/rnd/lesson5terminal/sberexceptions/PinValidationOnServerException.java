package com.sbt.javaschool.rnd.lesson5terminal.sberexceptions;

import java.io.IOException;

public class PinValidationOnServerException extends IOException {
    @Override
        public String getMessage() {
            return "Pin validation on server problem";
        }
}
