package khnu.mizhfac;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    @Test
    void name() {
        // AAA
        // arrange
        int expected = 3;
        // act
        int res = Main.add(1, 2);
        // assert
        assertAll(
                () -> assertEquals(expected,res),
                () -> assertEquals(expected,res)
        );
    }
}