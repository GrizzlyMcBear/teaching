package teaching.java.unit4.recursion.tail;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReversePrintTest {

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @Test
    void iterativeTest1() {
        int number = 2710;

        assertEquals("0172", ReversePrintNumber.iterativeReturn(number));
    }

    @Test
    void iterativeTest2() {
        int number = 2;

        assertEquals("2", ReversePrintNumber.iterativeReturn(number));
    }

    @Test
    void iterativeTest3() {
        int number = 0;

        assertEquals("0", ReversePrintNumber.iterativeReturn(number));
    }

    @Test
    void iterativeTest4() {
        int number = 123456;

        assertEquals("654321", ReversePrintNumber.iterativeReturn(number));
    }

    @Test
    void recursiveTest1() {
        int number = 2710;

        assertEquals("0172", ReversePrintNumber.recursiveReturn(number));
    }

    @Test
    void recursiveTest2() {
        int number = 2;

        assertEquals("2", ReversePrintNumber.recursiveReturn(number));
    }

    @Test
    void recursiveTest3() {
        int number = 0;

        assertEquals("0", ReversePrintNumber.recursiveReturn(number));
    }

    @Test
    void recursiveTest4() {
        int number = 123456;

        assertEquals("654321", ReversePrintNumber.recursiveReturn(number));
    }
}