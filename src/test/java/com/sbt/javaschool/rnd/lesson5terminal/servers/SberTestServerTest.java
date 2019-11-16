package com.sbt.javaschool.rnd.lesson5terminal.servers;

import com.sbt.javaschool.rnd.lesson5terminal.sberexceptions.AccountIsLockedException;
import com.sbt.javaschool.rnd.lesson5terminal.sberexceptions.NotEnoughMoneyException;
import com.sbt.javaschool.rnd.lesson5terminal.sberexceptions.PinValidationOnServerException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


// это только шаблон, сгенерированный SquareTest генератором

class SberTestServerTest {

    private SberTestServer sberTestServerUnderTest;

    @BeforeEach
    void setUp() {
        sberTestServerUnderTest = new SberTestServer();
        sberTestServerUnderTest.testBalance = 0.0;
        sberTestServerUnderTest.serverToken = "serverToken";
    }

    @Test
    void testValidateUserPinOnServer() throws Exception {
        // Setup

        // Run the test
        final Boolean result = sberTestServerUnderTest.validateUserPinOnServer(0L, "MD5HashedPin");

        // Verify the results
        assertTrue(result);
    }

    @Test
    void testValidateUserPinOnServer_ThrowsAccountIsLockedException() {
        // Setup

        // Run the test
        assertThrows(AccountIsLockedException.class, () -> {
            sberTestServerUnderTest.validateUserPinOnServer(0L, "MD5HashedPin");
        });
    }

    @Test
    void testValidateUserPinOnServer_ThrowsPinValidationOnServerException() {
        // Setup

        // Run the test
        assertThrows(PinValidationOnServerException.class, () -> {
            sberTestServerUnderTest.validateUserPinOnServer(0L, "MD5HashedPin");
        });
    }

    @Test
    void testGetUserBalance() {
        // Setup
        final Double expectedResult = 0.0;

        // Run the test
        final Double result = sberTestServerUnderTest.getUserBalance("Token");

        // Verify the results
        assertEquals(expectedResult, result, 0.0001);
    }

    @Test
    void testGetCashFromServerToUser() throws Exception {
        // Setup

        // Run the test
        final Boolean result = sberTestServerUnderTest.getCashFromServerToUser("Token", 0);

        // Verify the results
        assertTrue(result);
    }

    @Test
    void testGetCashFromServerToUser_ThrowsNotEnoughMoneyException() {
        // Setup

        // Run the test
        assertThrows(NotEnoughMoneyException.class, () -> {
            sberTestServerUnderTest.getCashFromServerToUser("Token", 0);
        });
    }

    @Test
    void testReceiveCashFromUserToServer() {
        // Setup

        // Run the test
        sberTestServerUnderTest.receiveCashFromUserToServer("Token", 0);

        // Verify the results
    }
}
